import pandas as pd

from config import Config
from llm_utils import LLM_Utils
from neo4jcommands import Neo4jCommands
from pipelines.obtain_cfg_paths import extract_paths, obtain_cfg_path_info, parse_dot_to_cfg

import pygraphviz as pgv
import networkx as nx
import re


# given a class_FEN, find all the abstract methods in the class
def get_abstract_methods_signatures_in_class(class_FEN):
    class_methods = Neo4jCommands.find_post_entities_in_relation(class_FEN, relation='Has_Method')
    # abstract_methods_FENs = []
    abstract_methods_signatures = []
    for method in class_methods:
        method_entity = method['n']
        method_type = str(method_entity.labels)
        if 'Abstract Method' in method_type:
            abstract_method_FEN = method_entity['FEN']
            abstract_method_signature = method_entity['Signature']

            # abstract_methods_FENs.append(abstract_method_FEN)
            abstract_methods_signatures.append(abstract_method_signature)
    return abstract_methods_signatures

def get_non_abstract_methods_signatures_in_class(class_FEN):
    class_methods = Neo4jCommands.find_post_entities_in_relation(class_FEN, relation='Has_Method')
    # concrete_methods_FENs = []
    non_abstract_methods_signatures = []
    for method in class_methods:
        method_entity = method['n']
        method_type = str(method_entity.labels)
        if 'Abstract Method' not in method_type:
            non_abstract_method_signature = method_entity['Signature']
            non_abstract_methods_signatures.append(non_abstract_method_signature)
    return non_abstract_methods_signatures

def get_extends_implements_classes_FENs(class_FEN):
    classes_FENs = []
    try:
        class_entity = Neo4jCommands.find_entity(class_FEN)
    except:
        return []
    extended_classes = class_entity['Extends']
    if pd.isna(extended_classes):
        extended_classes = ''
    implemented_interfaces = class_entity['Implements']
    if pd.isna(implemented_interfaces):
        implemented_interfaces = ''
    extended_classes_list = extended_classes.split(';')
    implemented_interfaces_list = implemented_interfaces.split(';')
    for extended_class in extended_classes_list:
        if extended_class != '':
            classes_FENs.append(extended_class)
    for implemented_interface in implemented_interfaces_list:
        if implemented_interface != '':
            classes_FENs.append(implemented_interface)
    return classes_FENs

def get_extends_implements_classes_FENs_chain(class_FEN):
    classes_FENs = get_extends_implements_classes_FENs(class_FEN)
    for class_FEN in classes_FENs:
        extend_classes_FENs = get_extends_implements_classes_FENs(class_FEN)
        if len(extend_classes_FENs) != 0:
            classes_FENs += extend_classes_FENs
            for extend_class_FEN in extend_classes_FENs:
                classes_FENs += get_extends_implements_classes_FENs_chain(extend_class_FEN)
    return classes_FENs

def get_abstract_methods_for_implementation(method_belong_to_class_FEN):
    abstract_methods_list = []
    classes_FENs_list = list(set(get_extends_implements_classes_FENs_chain(method_belong_to_class_FEN))) + [method_belong_to_class_FEN]
    for class_FEN in classes_FENs_list:
        try:
            class_entity = Neo4jCommands.find_entity(class_FEN)
        except:
            # class is third party library, skip it
            continue
        abstract_methods = get_abstract_methods_signatures_in_class(class_FEN)
        abstract_methods_list += abstract_methods
    abstract_methods_list = list(set(abstract_methods_list))

    non_abstract_methods_list = []
    for class_FEN in classes_FENs_list:
        try:
            class_entity = Neo4jCommands.find_entity(class_FEN)
        except:
            # class is third party library, skip it
            continue
        non_abstract_methods = get_non_abstract_methods_signatures_in_class(class_FEN)
        non_abstract_methods_list += non_abstract_methods

    abstract_methods_for_implementation = []
    non_abstract_methods_list = list(set(non_abstract_methods_list))
    for abstract_method in abstract_methods_list:
        if abstract_method in non_abstract_methods_list:
            pass
        else:
            abstract_methods_for_implementation.append(abstract_method)
    return abstract_methods_for_implementation


def focal_method_info_in_the_project(method_entity):



    method_FEN = method_entity['FEN']
    method_signature = method_entity['Signature']
    method_simplename = method_signature.split(' ')[1].split('(')[0]
    method_modifier_info = method_entity['Modifiers']

    method_belong_to_class = Neo4jCommands.find_pre_entities_in_relation(method_FEN, relation='Has_Method')
    if len(method_belong_to_class) != 1:
        raise ValueError(f'When finding the class of method {method_FEN}, got {len(method_belong_to_class)} classes.')



    method_belong_to_class = method_belong_to_class[0]['n']
    method_belong_to_class_FEN = method_belong_to_class['FEN']
    method_belong_to_class_modifier_info = method_belong_to_class['Modifiers']
    method_belong_to_class_label = method_belong_to_class.labels
    if '$' in method_belong_to_class_FEN:
        raise ValueError(f'The class {method_belong_to_class_FEN} is a nested class.')
    else:
        focal_method_info = 'Class: {}\n'.format(method_belong_to_class_FEN)
    focal_method_info += 'Class Modifiers: {}\n'.format(method_belong_to_class_modifier_info)
    focal_method_info += 'Method Signature: {}\n'.format(method_signature)
    focal_method_info += 'Method Modifiers: {}\n'.format(method_modifier_info)


    if 'Abstract Class' in method_belong_to_class_label or 'Interface' in method_belong_to_class_label:

        class_abstract_methods_for_implementation = get_abstract_methods_for_implementation(method_belong_to_class_FEN)
        focal_method_info += '\nThe class "{}" is an abstract class, you should create a concrete class to implement it and implement the following abstract methods:\n'.format(method_belong_to_class_FEN)
        for abstract_method in class_abstract_methods_for_implementation:
            focal_method_info += '{}\n'.format(abstract_method)
        focal_method_info += '\n'




    method_belong_to_class_simple_name = method_belong_to_class_FEN.split('.')[-1]
    for modifier in method_belong_to_class_modifier_info.split(','):
        modifier = modifier.strip()
        if modifier == 'private':
            focal_method_info += 'The class "{}" is a private class, you should use "reflection" to access it.\n'.format(method_belong_to_class_FEN)
        if modifier == 'protected':
            focal_method_info += 'The class "{}" is a protected class, you should use "reflection" to access it.\n'.format(method_belong_to_class_FEN)
    if 'private' not in method_belong_to_class_modifier_info and 'protected' not in method_belong_to_class_modifier_info:
        focal_method_info += 'You can access the class by importing the class directly: "import {}"\n'.format(method_belong_to_class_FEN)
    if 'static' in method_modifier_info:
        focal_method_info += 'The method "{}" is a static method, you can access it directly by importing the focal class.\n'.format(
            method_simplename)
    methods_of_class = Neo4jCommands.find_post_entities_in_relation(method_belong_to_class_FEN,
                                                                    relation='Has_Method')
    if 'static' not in method_belong_to_class_modifier_info:
        focal_method_info += 'The class "{}" has the following constructors that facilitate its instantiation (you can select one of them to instantiate the class):\n'.format(
            method_belong_to_class_FEN.replace('$', '.'))
        # find the constructor of the outer class
        for method_of_class in methods_of_class:
            method_of_class_entity = method_of_class['n']
            method_of_class_entity_type = str(method_of_class_entity.labels)
            method_of_class_entity_modifier_info = method_of_class_entity['Modifiers']
            method_of_class_entity_signature = method_of_class_entity['Signature']
            if 'Constructor' in method_of_class_entity_type:
                method_of_class_source_code = method_of_class_entity['Source Code'].replace('\\n', '\n')

                if 'private' in method_of_class_entity_modifier_info:
                    focal_method_info += '"{}" (this method is private, if you want to access it, you should use "reflection")\n'.format(
                        method_of_class_entity_signature)
                elif 'protected' in method_of_class_entity_modifier_info:
                    focal_method_info += '"{}" (this method is protected, if you want to access it, you should use "reflection")\n'.format(
                        method_of_class_entity_signature)
                else:
                    focal_method_info += '"{}"\n'.format(method_of_class_entity_signature)

    focal_method_info += '\n'
    method_modifier_info = method_entity['Modifiers']
    focal_method_info += 'The focal method "{}" has modifiers: "{}"\n'.format(method_signature, method_modifier_info.strip())
    if 'private' in method_modifier_info:
        focal_method_info += 'The focal method "{}" is a private method, you should use "reflection" to access it.\n'.format(method_signature)
    if 'protected' in method_modifier_info:
        focal_method_info += 'The focal method "{}" is a protected method, you should use "reflection" to access it.\n'.format(method_signature)
    if 'static' in method_modifier_info:
        focal_method_info += 'The focal method "{}" is a static method, you can access it directly.\n'.format(method_signature)


    focal_method_info += '\n'

    method_parameters = method_signature.split('(')[1].split(')')[0].split(',')

    for method_parameter in method_parameters:
        if method_parameter == '':
            continue
        try:
            class_entity = Neo4jCommands.find_entity(method_parameter)
            class_FEN = class_entity['FEN']
            class_modifier_info = class_entity['Modifiers']
            class_label = class_entity.labels

            if 'Abstract Class' in class_label:
                abstract_methods_for_implementation = get_abstract_methods_for_implementation(class_FEN)
                focal_method_info += 'The parameter "{}" of the focal method is an abstract class, you should create a concrete class to implement it and implement the following abstract methods:\n'.format(class_FEN)
                for abstract_method in abstract_methods_for_implementation:
                    focal_method_info += '{}\n'.format(abstract_method)
            if 'Interface' in class_label:
                abstract_methods_for_implementation = get_abstract_methods_for_implementation(class_FEN)
                focal_method_info += 'The parameter "{}" of the focal method is an interface, you should implement it.\n'.format(class_FEN)
                for abstract_method in abstract_methods_for_implementation:
                    focal_method_info += '{}\n'.format(abstract_method)

            if 'public' in class_modifier_info:
                focal_method_info += 'The parameter "{}" of the focal method is a public class, you can access it directly. '.format(method_parameter)
            if 'protected' in class_modifier_info:
                focal_method_info += 'The parameter "{}" of the focal method is a protected class, you should use "reflection" to access it. '.format(method_parameter)
            if 'private' in class_modifier_info:
                focal_method_info += 'The parameter "{}" of the focal method is a private class, you should use "reflection" to access it. '.format(method_parameter)
            if 'final' in class_modifier_info:
                focal_method_info += 'The parameter "{}" of the focal method is a final class, you can not extend it and mock it. '.format(method_parameter)

            focal_method_info += '\n'

            if 'static' not in class_modifier_info and 'Interface' not in class_label:
                methods_of_class = Neo4jCommands.find_post_entities_in_relation(class_FEN, relation='Has_Method')
                focal_method_info += 'The class "{}" has the following constructors that facilitate its instantiation (you can select one of them to instantiate the class):\n'.format(class_FEN)
                # find the constructor of the outer class
                for method_of_class in methods_of_class:
                    method_of_class_entity = method_of_class['n']
                    method_of_class_entity_type = str(method_of_class_entity.labels)
                    method_of_class_entity_modifier_info = method_of_class_entity['Modifiers']
                    method_of_class_entity_signature = method_of_class_entity['Signature']
                    if 'Constructor' in method_of_class_entity_type:
                        method_of_class_source_code = method_of_class_entity['Source Code'].replace('\\n', '\n')

                        if 'private' in method_of_class_entity_modifier_info:
                            focal_method_info += '"{}" (this method is private, if you want to access it, you should use "reflection")\n'.format(
                                method_of_class_entity_signature)
                        elif 'protected' in method_of_class_entity_modifier_info:
                            focal_method_info += '"{}" (this method is protected, if you want to access it, you should use "reflection")\n'.format(
                                method_of_class_entity_signature)
                        else:
                            focal_method_info += '"{}"\n'.format(method_of_class_entity_signature)
        except:
            # class is third party library, skip it
            pass


    return focal_method_info

def obtain_relevant_fields_and_enum_constant_source_code(uses_fields, uses_enum_constant):

    if len(uses_fields) == 0 and len(uses_enum_constant) == 0:
        return 'There is no external field or enum constant used in the focal method.'
    relevant_fields_source_code = ''
    for relevant_field in uses_fields:
        relevant_field_entity = relevant_field['n']
        relevant_field_FEN = relevant_field_entity['FEN']
        relevant_field_source_code = relevant_field_entity['Source Code'].replace('\\n', '\n')
        relevant_field_modifier_info = relevant_field_entity['Modifiers']
        relevant_fields_source_code += 'source code of field {} (Note that this variable is "{}") is:\n{}\n'.format(relevant_field_FEN, relevant_field_modifier_info, relevant_field_source_code)

    relevant_enum_constants_source_code = ''
    for relevant_enum_constant in uses_enum_constant:
        relevant_enum_constant_entity = relevant_enum_constant['n']
        relevant_enum_constant_FEN = relevant_enum_constant_entity['FEN']
        relevant_enum_constant_source_code = relevant_enum_constant_entity['Source Code'].replace('\\n', '\n')
        relevant_enum_constant_modifier_info = relevant_enum_constant_entity['Modifiers']
        relevant_enum_constants_source_code += 'source code of enum constant {} (Note that this variable is "{}") is:\n{}\n'.format(relevant_enum_constant_FEN, relevant_enum_constant_modifier_info, relevant_enum_constant_source_code)
    relevant_fields_and_enum_constant_source_code = relevant_fields_source_code + '\n' + relevant_enum_constants_source_code
    return relevant_fields_and_enum_constant_source_code


def get_parameters_constraints_prompt(cfg_path, method_constraint, external_methods_constraints):


    system_prompt = LLM_Utils.read_prompt_file(Config.Parameters_Constraints_prompt_dir + '/System')
    input_prompt = LLM_Utils.read_prompt_file(Config.Parameters_Constraints_prompt_dir + '/Input')

    user_input_prompt = input_prompt.replace('#{}#', cfg_path, 1)
    user_input_prompt = user_input_prompt.replace('#{}#', method_constraint, 1)
    user_input_prompt = user_input_prompt.replace('#{}#', external_methods_constraints, 1)

    example_prompt = LLM_Utils.read_example_prompts(Config.Parameters_Constraints_prompt_dir)

    system = [{'role': 'system', 'content': system_prompt}]
    user_input = [{'role': 'user', 'content': user_input_prompt}]
    input_prompt = system + example_prompt + user_input
    return input_prompt


def select_paths_to_fullfill_method_constraints_prompt(method_FEN, method_constraint, method_cfg_entry_node):
    method_entity = Neo4jCommands.find_entity(method_FEN)
    method_cfg = method_entity['CFG'].replace('\\\\n', '\n').replace('\\\\t', '\t').replace('\\n', '\n').replace('\\t', '\t')

    system_prompt = LLM_Utils.read_prompt_file(Config.CFG_Paths_Selector_prompt_dir + '/System')
    input_prompt = LLM_Utils.read_prompt_file(Config.CFG_Paths_Selector_prompt_dir + '/Input')

    user_input_prompt = input_prompt.replace('#{}#', method_cfg, 1)
    user_input_prompt = user_input_prompt.replace('#{}#', method_constraint, 1)
    user_input_prompt = user_input_prompt.replace('#{}#', method_cfg_entry_node, 1)

    example_prompt = LLM_Utils.read_example_prompts(Config.CFG_Paths_Selector_prompt_dir)

    system = [{'role': 'system', 'content': system_prompt}]
    user_input = [{'role': 'user', 'content': user_input_prompt}]
    input_prompt = system + example_prompt + user_input
    return input_prompt

def same_cfg_path(cfg_path1, cfg_path2):
    cfg_path1_path = cfg_path1.split('\nCFG Path: ')[-1].strip()
    cfg_path2_path = cfg_path2.split('\nCFG Path: ')[-1].strip()
    if cfg_path1_path == cfg_path2_path:
        return True
    else:
        return False


def check_cfgpath_in_set(cfg_path, all_cfg_paths_in_cfg_after_prune):

    for cfg_path_in_cfg_after_prune in all_cfg_paths_in_cfg_after_prune:
        if same_cfg_path(cfg_path, cfg_path_in_cfg_after_prune):
            return True

    return False


def calculate_cfg_path_len(cfg_path):

    cfg_path_path = eval(cfg_path.split('\nCFG Path: ')[-1].strip())

    cfg_path_len = len(cfg_path_path)
    return cfg_path_len

def select_shortest_cfg_paths(satisfied_cfg_paths_FENs):

    dict_cfg_pathFEN_to_len = {}
    for cfg_path_FEN in satisfied_cfg_paths_FENs:
        cfg_path_entity = Neo4jCommands.find_entity(cfg_path_FEN)
        cfg_path = cfg_path_entity['CFG_Path'].replace('\\\\n', '\n').replace('\\\\t', '\t').replace('\\n', '\n').replace('\\t', '\t')
        cfg_path_len = calculate_cfg_path_len(cfg_path)
        dict_cfg_pathFEN_to_len[cfg_path_FEN] = cfg_path_len

    shortest_len = min(dict_cfg_pathFEN_to_len.values())
    shortest_cfg_path_FENs = [cfg_path_FEN for cfg_path_FEN, cfg_path_len in dict_cfg_pathFEN_to_len.items() if cfg_path_len == shortest_len]

    return shortest_cfg_path_FENs

'''
'###Method_Constraints
"org.apache.commons.lang3.StringUtils.isEmpty(CharSequence)": The return value must be `false`.
"org.apache.commons.lang3.CharSetUtils.deepEmpty(String[])": The return value must be `true`.'

i want to get a dictionary like this:
{
    "org.apache.commons.lang3.StringUtils.isEmpty(CharSequence)": The return value must be `false`.,
    "org.apache.commons.lang3.CharSetUtils.deepEmpty(String[])": The return value must be `true`.
}
'''
def get_external_methods_constrains(method_constraints_prompt, external_methods, openai_key):
    gpt_response = LLM_Utils.trigger_GPT_API_basedon_http_request(method_constraints_prompt, model=Config.foundation_model_gpt4o_mini, openai_key=openai_key)
    method_constraints = gpt_response.replace('###External_Methods_Constraints\n', '')


    method_constraints = method_constraints.split('```external method constraints')[1]
    method_constraints = method_constraints.split('```')[0].strip()

    method_constraints = method_constraints.split('\n')
    method_constraints_dict = {}
    for method_constraint in method_constraints:
        for relevant_method in external_methods:
            relevant_method_FEN = relevant_method['n']['FEN']
            if relevant_method_FEN in method_constraint:
                method_constraint = method_constraint.replace('"' + relevant_method_FEN + '": ', '')
                method_constraints_dict[relevant_method_FEN] = method_constraint

    return method_constraints_dict



def get_external_methods_constraints_prompt(cfg_path, external_methods):
    methods_info = ''

    for external_method in external_methods:
        external_method_entity = external_method['n']
        external_method_FEN = external_method_entity['FEN']
        external_method_belongs_to_class = Neo4jCommands.find_pre_entities_in_relation(external_method_FEN, relation='Has_Method')
        if len(external_method_belongs_to_class) != 1:
            raise ValueError(f'When finding the class of method {external_method_FEN}, got {len(external_method_belongs_to_class)} classes.')
        external_method_belongs_to_class_FEN = external_method_belongs_to_class[0]['n']['FEN']
        external_method_signature = external_method_entity['Signature']


        methods_info += '"{}" with the fully entity name "{}"\n'.format(external_method_belongs_to_class_FEN+': ' + external_method_signature, external_method_FEN)

    system_prompt = LLM_Utils.read_prompt_file(Config.Method_Constraints_prompt_dir + '/System')
    input_prompt = LLM_Utils.read_prompt_file(Config.Method_Constraints_prompt_dir + '/Input')

    user_input_prompt = input_prompt.replace('#{}#', cfg_path, 1)
    user_input_prompt = user_input_prompt.replace('#{}#', methods_info, 1)

    example_prompt = LLM_Utils.read_example_prompts(Config.Method_Constraints_prompt_dir)

    system = [{'role': 'system', 'content': system_prompt}]
    user_input = [{'role': 'user', 'content': user_input_prompt}]
    input_prompt = system + example_prompt + user_input
    return input_prompt


def check_cfg_after_prune_dot(cfg_after_prune_dot, cfg_before_prune_dot, cfg_entry_node):
    """
    Verifies that cfg_after_prune_dot is a subgraph of cfg_before_prune_dot.
    Ensures:
    1. No new nodes or edges appear in cfg_after_prune_dot.
    2. No isolated nodes exist in cfg_after_prune_dot.
    3. There is only one entry point (a single node with no incoming edges).

    Args:
        cfg_after_prune_dot (str): The pruned CFG in DOT format.
        cfg_before_prune_dot (str): The original CFG in DOT format.

    Returns:
        bool: True if valid, False if invalid (indicating regeneration is needed).
    """
    check_success = True
    check_failed_info = ""
    # Convert DOT strings to graphs
    before_graph = pgv.AGraph(string=cfg_before_prune_dot)
    after_graph = pgv.AGraph(string=cfg_after_prune_dot)

    # Extract nodes and edges
    before_nodes = set(before_graph.nodes())
    after_nodes = set(after_graph.nodes())

    before_edges = set((str(edge[0]), str(edge[1]), edge.attr.get('label', "cfg_next"))
                       for edge in before_graph.edges())
    after_edges = set((str(edge[0]), str(edge[1]), edge.attr.get('label', "cfg_next"))
                      for edge in after_graph.edges())

    # 1. Check if after_nodes is a subset of before_nodes
    if not after_nodes.issubset(before_nodes):
        check_success = False
        new_nodes = after_nodes - before_nodes
        new_nodes_str = ""
        for node in new_nodes:
            node_label = after_graph.get_node(node).attr['label']
            new_nodes_str += f'"{node}" [label="{node_label}"];' + ','
        new_nodes_str = new_nodes_str[:-1]
        check_failed_info += "cfg after prune contains new nodes that are not in cfg_before_prune_dot: {}\n".format(new_nodes_str)

    # 2. Check if after_edges is a subset of before_edges
    if not after_edges.issubset(before_edges):
        check_success = False
        new_edges = after_edges - before_edges
        new_edges_str = ""
        for edge in new_edges:
            new_edges_str += f'"{edge[0]}" -> "{edge[1]}"[label={edge[2]}];' + ','
        new_edges_str = new_edges_str[:-1]
        check_failed_info += "cfg after prune contains new edges that are not in cfg_before_prune_dot: {}\n".format(new_edges_str)

    # 3. Check for isolated nodes (nodes with no incoming or outgoing edges)
    after_graph_nx = nx.DiGraph(nx.nx_agraph.from_agraph(after_graph))
    isolated_nodes = {node for node in after_nodes if after_graph_nx.in_degree(node) == 0 and after_graph_nx.out_degree(node) == 0}
    if isolated_nodes:
        check_success = False
        isolated_nodes_str = ""
        for node in isolated_nodes:
            node_label = after_graph.get_node(node).attr['label']
            isolated_nodes_str += f'"{node}" [label="{node_label}"];' + ','
        isolated_nodes_str = isolated_nodes_str[:-1]
        check_failed_info += "cfg after prune contains isolated nodes: {}\n".format(isolated_nodes_str)

    # 4. Check for multiple entry points (nodes with no incoming edges)
    entry_points = [node for node in after_nodes if after_graph_nx.in_degree(node) == 0]
    if len(entry_points) > 1:
        check_success = False
        multiple_entry_points_str = ""
        for node in entry_points:
            node_label = after_graph.get_node(node).attr['label']
            multiple_entry_points_str += f'"{node}" [label="{node_label}"];' + ','
        multiple_entry_points_str = multiple_entry_points_str[:-1]
        check_failed_info += "cfg after prune has multiple entry points: {}, the entry point must be {}!\n".format(multiple_entry_points_str, cfg_entry_node)
    if len(entry_points) == 0:
        check_success = False
        check_failed_info += "cfg after prune has no valid entry point.\n"

    # If all checks pass, the pruned CFG is valid
    return check_success, check_failed_info

def get_entry_node_of_cfg(cfg):
    cfg = cfg.replace('\\\\n', '\n').replace('\\\\t', '\t').replace('\\n', '\n').replace('\\t', '\t')
    cfg_graph = pgv.AGraph(string=cfg)
    cfg_graph_nx = nx.DiGraph(nx.nx_agraph.from_agraph(cfg_graph))
    entry_points = [node for node in cfg_graph.nodes() if cfg_graph_nx.in_degree(node) == 0]
    if len(entry_points) == 1:
        entry_point_label = cfg_graph.get_node(entry_points[0]).attr['label']
        entry_point_str = f'"{entry_points[0]}" [label="{entry_point_label}"];'
        return entry_point_str
    else:
        raise ValueError("The CFG has no valid entry point.")


def parse_dot_to_nx(dot_string):
    """Parses a DOT format string into a NetworkX graph while retaining node labels and graph name."""
    G = nx.DiGraph(nx.nx_agraph.from_agraph(pgv.AGraph(string=dot_string)))

    # Extract node labels from the original DOT string
    node_labels = {}
    node_label_matches = re.findall(r'"(\d+)" \[label="(.*?)"\];', dot_string)
    for node, label in node_label_matches:
        node_labels[node] = label

    # Assign labels to nodes in the graph
    nx.set_node_attributes(G, node_labels, name="label")

    # Extract the graph name (first match of "digraph <name>")
    graph_name_match = re.search(r'digraph (\w+) {', dot_string)
    graph_name = graph_name_match.group(1) if graph_name_match else "cfg_pruned"

    return G, graph_name

def delete_edges_in_cfg(cfg_dot, list_of_pruned_edges):
    """Removes specified edges from the CFG and deletes isolated nodes while preserving graph name and node labels."""

    # Parse the DOT format CFG into a NetworkX graph
    G, graph_name = parse_dot_to_nx(cfg_dot)

    # Remove specified edges
    for edge in list_of_pruned_edges:
        match = re.findall(r'"(\d+)" -> "(\d+)"', edge)
        if match:
            src, dst = match[0]
            if G.has_edge(src, dst):
                G.remove_edge(src, dst)

    # Remove isolated nodes (nodes with no incoming and outgoing edges)
    isolated_nodes = [node for node in list(G.nodes) if G.in_degree(node) == 0 and G.out_degree(node) == 0]
    G.remove_nodes_from(isolated_nodes)

    # Convert the modified graph back to DOT format
    pruned_dot = f'digraph {graph_name} {{\n'  # Preserve original graph name

    # Add nodes with original labels
    for node, attrs in G.nodes(data=True):
        pruned_dot += f'    "{node}" [label="{attrs["label"]}"];\n'

    # Add edges with original labels (assuming cfg_next as a default label)
    for src, dst, attrs in G.edges(data=True):
        label = attrs.get("label", "cfg_next")  # Preserve original edge labels
        pruned_dot += f'    "{src}" -> "{dst}" [label="{label}"];\n'

    pruned_dot += '}'

    return pruned_dot


def select_paths_to_fulfill_method_constraints(external_method_FEN, external_method_constraint, openai_key):
    # print('select_paths_to_fulfill_method_constraints for external method: {}'.format(external_method_FEN))

    external_method_entity = Neo4jCommands.find_entity(external_method_FEN)
    external_method_cfg = external_method_entity['CFG'].replace('\\\\n', '\n').replace('\\\\t', '\t').replace('\\n', '\n').replace('\\t', '\t')
    external_method_cfg_entry_node = get_entry_node_of_cfg(external_method_cfg)


    select_paths_prompt = select_paths_to_fullfill_method_constraints_prompt(external_method_FEN,
                                                                             external_method_constraint, external_method_cfg_entry_node)  # 删去不符合条件的edges，得到符合条件的edges。最终得到的结果还是cfg，只不过删除了一些边。


    #  What we get in this step is some deleted edges, then we should get a new CFG based on these deleted edges, this new CFG must not contain independent nodes, must not contain new nodes, and must not contain multiple entry nodes.
    gpt_response = LLM_Utils.trigger_GPT_API_basedon_http_request(select_paths_prompt, model=Config.foundation_model_gpt4o_mini, openai_key=openai_key)


    pruned_edges = gpt_response.split('###Pruned_Edges\n')[1].strip('`')

    # Check if the format of pruned_edges is correct
    pattern_edges = r'^"\d+" -> "\d+"\[label="[^"]+"\];$'

    # Split by newline and verify if all lines match the required format
    list_of_pruned_edges = pruned_edges.strip().split('\n')
    is_valid_format = all(re.match(pattern_edges, edge.strip()) for edge in list_of_pruned_edges)

    if not is_valid_format:
        cfg_after_prune_dot = external_method_cfg
    else:
        list_of_pruned_edges = pruned_edges.split('\n')

        cfg_after_prune_dot = delete_edges_in_cfg(external_method_cfg, list_of_pruned_edges)


    path_selection_tries = 0
    check_success, check_failed_info = check_cfg_after_prune_dot(cfg_after_prune_dot, external_method_cfg, external_method_cfg_entry_node)


    while not check_success:
        # print('tries: {}'.format(path_selection_tries))
        if path_selection_tries == 0:
            model_result = {'role': 'assistant', 'content': gpt_response}
            reflection = {'role': 'user',
                          'content': 'The pruned edges are not correct: {}. Please regenerate the correct Pruned_Edges for the CFG that can matches the rules'.format(
                              check_failed_info)}
            select_paths_prompt += [model_result, reflection]
            gpt_response = LLM_Utils.trigger_GPT_API_basedon_http_request(select_paths_prompt,
                                                                          model=Config.foundation_model_gpt4o_mini, openai_key=openai_key)


        elif path_selection_tries > 0 and path_selection_tries < Config.path_selector_verification_time:
            # remove the last two elements in the prompt list
            select_paths_prompt = select_paths_prompt[:-2]
            model_result = {'role': 'assistant', 'content': gpt_response}
            reflection = {'role': 'user', 'content': 'The pruned edges are not correct: {}. Please regenerate the correct Pruned_Edges for the CFG that can matches the rules'.format(check_failed_info)}
            select_paths_prompt += [model_result, reflection]
            gpt_response = LLM_Utils.trigger_GPT_API_basedon_http_request(select_paths_prompt, model=Config.foundation_model_gpt4o_mini, openai_key=openai_key)


        else:
            # raise ValueError("Error when selecting paths to fulfill the method constraints.")
            cfg_after_prune_dot = external_method_cfg
            break


        pruned_edges = gpt_response.split('###Pruned_Edges\n')[1].strip('`')

        list_of_pruned_edges = pruned_edges.split('\n')

        cfg_after_prune_dot = delete_edges_in_cfg(external_method_cfg, list_of_pruned_edges)

        # cfg_after_prune_dot = gpt_response.replace('###CFG_After_Prune\n', '')
        # cfg_after_prune_dot = cfg_after_prune_dot.split('```dot')[1]
        # cfg_after_prune_dot = cfg_after_prune_dot.split('```')[0].strip()
        check_success, check_failed_info = check_cfg_after_prune_dot(cfg_after_prune_dot, external_method_cfg, external_method_cfg_entry_node)
        path_selection_tries += 1




    try:
        # Convert DOT format to CFG in dictionary form
        cfg_after_prune = parse_dot_to_cfg(cfg_after_prune_dot)
    except:
        raise ValueError("Error when parsing the CFG after pruning.")


    all_cfg_paths_in_cfg_after_prune = []


    try:
        # Extract paths from CFG
        all_paths = extract_paths(cfg_after_prune)
    except:
        raise ValueError("Error when constructing CFG paths for the given method constraints.")



    for path in all_paths:
        cfg_path_info = obtain_cfg_path_info(path, cfg_after_prune_dot)

        all_cfg_paths_in_cfg_after_prune.append(cfg_path_info)


    all_cfg_path_entities = Neo4jCommands.find_post_entities_in_relation(external_method_FEN, relation='Has_CFG_Path')
    if len(all_cfg_path_entities) == 0:
        raise ValueError("No CFG paths are found for the given method constraints.")
    satisfied_cfg_paths_FENs = []

    for cfg_path_entity in all_cfg_path_entities:
        cfg_path_entity = cfg_path_entity['n']
        cfg_path_FEN = cfg_path_entity['FEN']
        cfg_path = cfg_path_entity['CFG_Path'].replace('\\\\n', '\n').replace('\\\\t', '\t').replace('\\n', '\n').replace('\\t', '\t')
        if check_cfgpath_in_set(cfg_path, all_cfg_paths_in_cfg_after_prune):
            satisfied_cfg_paths_FENs.append(cfg_path_FEN)



    if len(satisfied_cfg_paths_FENs) == 0:
        raise ValueError("No CFG path satisfies the given constraints.")
    elif len(satisfied_cfg_paths_FENs) == 1:
        return satisfied_cfg_paths_FENs[0]
    else:

        '''
        (1) Prefer paths where no other external methods exist above the path (to prevent going to the second level of analysis).
        (2) Select the path that has no external variable/class.
        (3) If there are no external methods, it is preferred to choose a path with shorter edges (to reduce the burden of analysis).
        (4) Select a random path if you can't find a shorter one.
        '''

        # find a best path. First find the path that does not contain relevant methods from all the satisfied paths, then find the shortest path among them. If all the paths contain relevant methods, find the shortest path. whether relevant methods exist or not depends on whether relevant_method in project_info_with_cfg_path_and_relevant_info is [] or not.

        # 找到Has_Method关系为0的CFG_Path
        satisfied_cfg_paths_FENs_without_relevant_methods = []
        for satisfied_cfg_path_FEN in satisfied_cfg_paths_FENs:
            external_method_entities = Neo4jCommands.find_post_entities_in_relation(satisfied_cfg_path_FEN, relation='Uses_Method')
            if len(external_method_entities) == 0:
                satisfied_cfg_paths_FENs_without_relevant_methods.append(satisfied_cfg_path_FEN)


        if len(satisfied_cfg_paths_FENs_without_relevant_methods) == 0:
            # find relevant info to get constraints.
            shortest_cfg_paths_FENs = select_shortest_cfg_paths(satisfied_cfg_paths_FENs)
            if len(shortest_cfg_paths_FENs) > 1:
                # randomly select a cfg_path_FEN
                selected_cfg_path_FEN = shortest_cfg_paths_FENs[0]
                return selected_cfg_path_FEN

            elif len(shortest_cfg_paths_FENs) == 1:
                return shortest_cfg_paths_FENs[0]
            else:
                raise ValueError("No CFG path satisfies the given constraints.")

        elif len(satisfied_cfg_paths_FENs_without_relevant_methods) == 1:
            return satisfied_cfg_paths_FENs_without_relevant_methods[0]
        else:
            # select a best path
            satisfied_cfg_paths_FENs_without_relevant_field_and_enum_constant = []
            for satisfied_cfg_path_FEN in satisfied_cfg_paths_FENs_without_relevant_methods:
                uses_fields = Neo4jCommands.find_post_entities_in_relation(satisfied_cfg_path_FEN, relation='Uses_Field')
                uses_enum_constant = Neo4jCommands.find_post_entities_in_relation(satisfied_cfg_path_FEN, relation='Uses_Enum_Constant')
                if len(uses_fields) == 0 and len(uses_enum_constant) == 0:
                    satisfied_cfg_paths_FENs_without_relevant_field_and_enum_constant.append(satisfied_cfg_path_FEN)


            # every path contains relevant fields
            if len(satisfied_cfg_paths_FENs_without_relevant_field_and_enum_constant) == 0:
                # find a shortest path
                shortest_cfg_paths_FENs = select_shortest_cfg_paths(satisfied_cfg_paths_FENs_without_relevant_methods)
                if len(shortest_cfg_paths_FENs) > 1:
                    # randomly select a row
                    selected_cfg_path_FEN = shortest_cfg_paths_FENs[0]
                    return selected_cfg_path_FEN
                elif len(shortest_cfg_paths_FENs) == 1:
                    return shortest_cfg_paths_FENs[0]
                else:
                    raise ValueError("No CFG path satisfies the given constraints.")
            elif len(satisfied_cfg_paths_FENs_without_relevant_field_and_enum_constant) == 1:
                return satisfied_cfg_paths_FENs_without_relevant_field_and_enum_constant[0]
            else:
                #every path contains no relevant fields
                # find a shortest path
                shortest_cfg_paths_FENs = select_shortest_cfg_paths(satisfied_cfg_paths_FENs_without_relevant_field_and_enum_constant)

                if len(shortest_cfg_paths_FENs) > 1:
                    # randomly select a row
                    selected_cfg_path_FEN = shortest_cfg_paths_FENs[0]
                    return selected_cfg_path_FEN
                elif len(shortest_cfg_paths_FENs) == 1:
                    return shortest_cfg_paths_FENs[0]

                else:
                    raise ValueError("No CFG path satisfies the given constraints.")

def check_cfg_path_no_FEN(method_FEN, cfg_path_no):
    cfg_paths = Neo4jCommands.find_post_entities_in_relation(method_FEN, relation='Has_CFG_Path')
    cfg_path_FEN = method_FEN + '.CFG_Path_' + str(cfg_path_no)
    cfg_path_num = 0
    # 判断cfg_paths中是否存在FEN为cfg_path_FEN的CFG_Path
    cfg_path_e = None
    for cfg_path_entity in cfg_paths:
        cfg_path_entity = cfg_path_entity['n']
        if cfg_path_entity['FEN'] == cfg_path_FEN:
            cfg_path_e = cfg_path_entity
            cfg_path_num += 1

    if cfg_path_e is None:
        raise ValueError(f'When finding CFG path {cfg_path_FEN}, got no results.')
    if cfg_path_num > 1:
        raise ValueError(f'When finding CFG path {cfg_path_FEN}, got {cfg_path_num} results.')

    return cfg_path_e

def construct_prompt_for_a_cfg_path(method_FEN, cfg_path_no, openai_key):
    method_entity = Neo4jCommands.find_entity(method_FEN)
    method_source_code = method_entity['Source Code'].replace('\\n', '\n')

    focal_method_class_and_signature = focal_method_info_in_the_project(method_entity)



    cfg_path_entity = check_cfg_path_no_FEN(method_FEN, cfg_path_no)
    cfg_path = cfg_path_entity['CFG_Path'].replace('\\\\n', '\n').replace('\\\\t', '\t').replace('\\n', '\n').replace('\\t', '\t')
    cfg_path_FEN = cfg_path_entity['FEN']

    uses_fields = Neo4jCommands.find_post_entities_in_relation(cfg_path_FEN, relation='Uses_Field')
    uses_methods = Neo4jCommands.find_post_entities_in_relation(cfg_path_FEN, relation='Uses_Method')
    uses_enum_constant = Neo4jCommands.find_post_entities_in_relation(cfg_path_FEN, relation='Uses_Enum_Constant')


    relevant_fields_and_enum_constant_source_code = obtain_relevant_fields_and_enum_constant_source_code(uses_fields, uses_enum_constant)

    if len(uses_methods) == 0:
        external_methods_parameters_constraints = 'This ###CFG_Path does not contain any external method.'
    else:
        external_methods_parameters_constraints = obtain_external_methods_parameters_constraints(cfg_path_FEN, openai_key)


    system_prompt = LLM_Utils.read_prompt_file(Config.LLM_CFGPath_SemanticContextInfo_prompt_dir + '/System')
    input_prompt = LLM_Utils.read_prompt_file(Config.LLM_CFGPath_SemanticContextInfo_prompt_dir + '/Input')

    user_input_prompt = input_prompt.replace('#{}#', method_source_code, 1)
    user_input_prompt = user_input_prompt.replace('#{}#', focal_method_class_and_signature, 1)
    user_input_prompt = user_input_prompt.replace('#{}#', cfg_path, 1)
    user_input_prompt = user_input_prompt.replace('#{}#', external_methods_parameters_constraints, 1)
    user_input_prompt = user_input_prompt.replace('#{}#', relevant_fields_and_enum_constant_source_code, 1)


    # example_prompt = read_example_prompts(Config.Parameters_Constraints_prompt_dir)

    system = [{'role': 'system', 'content': system_prompt}]
    user_input = [{'role': 'user', 'content': user_input_prompt}]
    input_prompt = system + user_input
    return input_prompt


'''
Given a method, get the constraints on the parameters of the external method it calls
'''
def obtain_external_methods_parameters_constraints(cfg_path_FEN, openai_key):
    # print('obtain_external_methods_parameters_constraints for cfg_path: {}'.format(cfg_path_FEN))


    cfg_path_entity = Neo4jCommands.find_entity(cfg_path_FEN)
    cfg_path = cfg_path_entity['CFG_Path'].replace('\\\\n', '\n').replace('\\\\t', '\t').replace('\\n', '\n').replace('\\t', '\t')


    #external method constraints generation
    external_methods = Neo4jCommands.find_post_entities_in_relation(cfg_path_FEN, relation='Uses_Method')

    external_methods_constraints_prompt = get_external_methods_constraints_prompt(cfg_path, external_methods)
    external_methods_constraints = get_external_methods_constrains(external_methods_constraints_prompt, external_methods, openai_key)
    external_methods_parameters_constraints = ''

    for external_method_constraints in external_methods_constraints.items():
        external_method_FEN = external_method_constraints[0]
        external_method_constraint = external_method_constraints[1]
        external_method_CFG = Neo4jCommands.find_entity(external_method_FEN)['CFG'].replace('\\\\n', '\n').replace('\\\\t', '\t').replace('\\n', '\n').replace('\\t', '\t')
        try:
            selected_cfg_path_FEN_of_external_method = select_paths_to_fulfill_method_constraints(external_method_FEN,
                                                                                 external_method_constraint, openai_key)

            selected_cfg_path_entity_of_external_method = Neo4jCommands.find_entity(selected_cfg_path_FEN_of_external_method)
            selected_cfg_path_of_external_method = selected_cfg_path_entity_of_external_method['CFG_Path'].replace('\\\\n', '\n').replace('\\\\t', '\t').replace('\\n', '\n').replace('\\t', '\t')

            external_methods_used_in_selected_cfg_path = Neo4jCommands.find_post_entities_in_relation(selected_cfg_path_FEN_of_external_method, relation='Uses_Method')
            if len(external_methods_used_in_selected_cfg_path) == 0:
                external_external_methods_parameters_constraints = 'This ###CFG_Path does not contain any external method.'
            else:
                external_external_methods_parameters_constraints = obtain_external_methods_parameters_constraints(selected_cfg_path_FEN_of_external_method, openai_key)
        except:
            external_external_methods_parameters_constraints = 'This ###CFG_Path does not contain any external method.'
            selected_cfg_path_of_external_method = external_method_CFG

        # external_methods_parameters_constraints generation (input external_method_cfg_path, external_method_constraint, external_external_methods_parameters_constraints)
        parameters_constraints_prompt = get_parameters_constraints_prompt(selected_cfg_path_of_external_method, external_method_constraint, external_external_methods_parameters_constraints)
        parameters_constraints = LLM_Utils.trigger_GPT_API_basedon_http_request(parameters_constraints_prompt, model=Config.foundation_model_gpt4o_mini, openai_key=openai_key).replace('Current_Method_Parameters_Constraints\n', '')
        each_external_method_info = 'The parameters of method "{}" in this ###CFG_Path must meet the following conditions to ensure the successful execution of the ###CFG_Path:\n'.format(external_method_FEN)
        each_external_method_info += parameters_constraints + '\n'
        external_methods_parameters_constraints += each_external_method_info + '\n'
    return external_methods_parameters_constraints

def generate_unit_tests_for_a_method(method_FEN, openai_key):
    all_cfg_paths_num = len(Neo4jCommands.find_post_entities_in_relation(method_FEN, relation='Has_CFG_Path'))
    for cfg_path_no in range(1, all_cfg_paths_num + 1):
        test_gen_prompt = construct_prompt_for_a_cfg_path(method_FEN, cfg_path_no, openai_key)
        test_code = LLM_Utils.trigger_GPT_API_basedon_http_request(test_gen_prompt, model=Config.foundation_model_gpt4o_mini, openai_key=openai_key)
        print('----------------------------')
        print('Test code for CFG Path {}:'.format(cfg_path_no))
        print(test_code)
        print('----------------------------')

if __name__ == '__main__':




    # method_FEN = 'org.apache.commons.lang3.CharSetUtils.squeeze(String,String[])'
    # generate_unit_tests_for_a_method(method_FEN, openai_key=Config.openai_key)


    # method_FEN = 'org.apache.commons.lang3.SerializationUtils$ClassLoaderAwareObjectInputStream.resolveClass(ObjectStreamClass)'
    # cfg_path_no = 1
    # test_gen_prompt = construct_prompt_for_a_cfg_path(method_FEN, cfg_path_no)
    # test_code = LLM_Utils.trigger_GPT_API_basedon_http_request(test_gen_prompt, model=Config.foundation_model_gpt4o_mini)
    # print(test_code)

    # method_FEN = 'org.apache.commons.lang3.CharSetUtils.squeeze(String,String[])'
    # cfg_path_no = 5
    # test_gen_prompt = construct_prompt_for_a_cfg_path(method_FEN, cfg_path_no)
    # test_code = LLM_Utils.trigger_GPT_API_basedon_http_request(test_gen_prompt, model=Config.foundation_model)
    # print(test_code)




    # method_FEN = 'org.apache.commons.lang3.StringUtils.removeEndIgnoreCase(String,String)'
    # cfg_path_no = 3
    # test_gen_prompt = construct_prompt_for_a_cfg_path(method_FEN, cfg_path_no)
    # test_code = LLM_Utils.trigger_GPT_API_basedon_http_request(test_gen_prompt, model=Config.foundation_model)
    # print(test_code)

    # method_FEN = 'org.apache.commons.lang3.CharRange$CharacterIterator.prepareNext()'
    # cfg_path_no = 2
    # test_gen_prompt = construct_prompt_for_a_cfg_path(method_FEN, cfg_path_no)
    # test_code = LLM_Utils.trigger_GPT_API_basedon_http_request(test_gen_prompt, model=Config.foundation_model_gpt4o_mini)
    # print(test_code)
    # a = 1


    # method_FEN = 'com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate._checkBinaryWrite()'
    # generate_unit_tests_for_a_method(method_FEN, openai_key=Config.openai_key)


    # method_FEN = 'com.fasterxml.jackson.core.JsonPointer.equals(Object)'
    # generate_unit_tests_for_a_method(method_FEN, openai_key=Config.openai_key)

    # method_FEN = 'org.joda.time.base.BasePartial.toString(String,Locale)'
    # generate_unit_tests_for_a_method(method_FEN, openai_key=Config.openai_key)

    method_FEN = 'org.joda.time.field.AbstractReadableInstantFieldProperty.compareTo(ReadableInstant)'
    generate_unit_tests_for_a_method(method_FEN, openai_key=Config.openai_key)