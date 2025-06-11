import pygraphviz as pgv
import networkx as nx
import pandas as pd
import tqdm
import concurrent.futures
from config import Config


def parse_dot_to_cfg(dot_string):
    """
    Parses a DOT string into a CFG dictionary format.

    Args:
        dot_string (str): The CFG in DOT format.

    Returns:
        dict: A dictionary representation of the CFG.
    """
    dot_graph = pgv.AGraph(string=dot_string)
    nx_graph = nx.DiGraph(nx.nx_agraph.from_agraph(dot_graph))

    cfg = {}
    for node in nx_graph.nodes():
        cfg[node] = [(neighbor, nx_graph[node][neighbor].get("label", "cfg_next"))
                     for neighbor in nx_graph.successors(node)]
    return cfg


def extract_paths(cfg):
    """
    Extracts paths from a control flow graph (CFG) while handling loops correctly.

    Args:
        cfg (dict): The control flow graph represented as {node: [(next_node, edge_type), ...]}

    Returns:
        list: All paths in the CFG.
    """

    def dfs(node, path, loop_entries):
        if len(paths) > 100:
            return

        if node not in cfg or not cfg[node]: 
            paths.append(path[:])
            return

        for next_node, edge_label in cfg[node]:
            if len(paths) > 100:
                return


            if next_node in loop_entries:
                continue 


            if (edge_label == "cfg_goto" and next_node in path) or (edge_label == "cfg_except" and next_node in path):
                loop_entries.add(next_node)
                path.append(next_node)
                dfs(next_node, path, loop_entries)
                path.pop()
                loop_entries.remove(next_node)
            else:
                path.append(next_node)
                dfs(next_node, path, loop_entries)
                path.pop()

    def find_start_node(cfg):
        all_nodes = set(cfg.keys())
        referenced_nodes = {next_node for edges in cfg.values() for next_node, _ in edges}
        start_nodes = all_nodes - referenced_nodes
        return start_nodes.pop() if start_nodes else None

    paths = []
    start_node = find_start_node(cfg)
    if start_node:
        dfs(start_node, [start_node], set())
    return paths

def find_node_label_from_dot(dot_input, node_no):
    dot_graph = pgv.AGraph(string=dot_input)
    node_label = dot_graph.get_node(node_no).attr['label']
    return node_label

def find_edge_label_from_dot(dot_input, from_node, to_node):
    dot_graph = pgv.AGraph(string=dot_input)
    edge_label = dot_graph.get_edge(from_node, to_node).attr['label']
    return edge_label

def obtain_cfg_path_info(path, cfg_dot_input):
    printed_nodes = set()  

    cfg_path_info = 'CFG Nodes:\n'
    for node in path:
        if node in printed_nodes:
            continue
        node_label = find_node_label_from_dot(cfg_dot_input, node)

        if '"' in node_label:
            node_label = node_label.replace('"', '\\"')

        cfg_path_info += f'"{node}" [label="{node_label}"];\n'
        printed_nodes.add(node)

    cfg_path_info += '\nCFG Edges:\n'
    all_edges_in_path = set()
    for i in range(len(path) - 1):
        edge = (path[i], path[i + 1])
        if edge in all_edges_in_path:
            continue
        edge_label = find_edge_label_from_dot(cfg_dot_input, edge[0], edge[1])
        cfg_path_info += f'"{edge[0]}" -> "{edge[1]}"[label="{edge_label}"];\n'
        all_edges_in_path.add(edge)

    cfg_path_info += '\nCFG Path: {}\n'.format(path)

    return cfg_path_info

def obtain_all_cfg_paths(csv_file_path, saved_csv_file_path, error_file_path):

    dict_cfg_pathnum_to_num = {}

    df = pd.read_csv(csv_file_path)
    dict_cfg_path_entities = {'FEN:ID': [], ':LABEL': [], 'CFG_Path': []}
    resolved_path = 0
    for index, row in tqdm.tqdm(df.iterrows(), total=df.shape[0]):

        FEN = row['FEN:ID']
        # print(FEN)
        entity_type = row[':LABEL']
        if entity_type == 'Abstract Method':
            continue

        cfg_dot_input = row['CFG'].replace('\\n', '\n')
        try:
            # 将 DOT 格式转为字典形式的 CFG
            cfg_from_dot = parse_dot_to_cfg(cfg_dot_input)
        except:
            with open(error_file_path, 'a') as f:
                f.write(f'Error when parsing CFG for {FEN}\n') 
            continue


        # try:
        #     with concurrent.futures.ProcessPoolExecutor(max_workers=1) as executor:
        #         future = executor.submit(extract_paths, cfg_from_dot)
        #         all_paths = future.result(timeout=60)
        # except concurrent.futures.TimeoutError:
        #     with open(error_file_path, 'a') as f:
        #         f.write(f'CFG extraction for {FEN} timed out after 60 seconds.\n')
        #     continue
        # except Exception as e:
        #     with open(error_file_path, 'a') as f:
        #         f.write(f'Error when constructing CFG paths for {FEN}: {str(e)}\n')
        #     continue

        try:
            # Extract paths from CFG
            all_paths = extract_paths(cfg_from_dot)
        except:
            with open(error_file_path, 'a') as f:
                f.write(f'Error when constructing CFG paths for {FEN}\n')
            continue
        cfg_pathnum = len(all_paths)
        if cfg_pathnum in dict_cfg_pathnum_to_num:
            dict_cfg_pathnum_to_num[cfg_pathnum] += 1
        else:
            dict_cfg_pathnum_to_num[cfg_pathnum] = 1


        if cfg_pathnum > 100:
            with open(error_file_path, 'a') as f:
                f.write(f'CFG path number for {FEN} is more than 100, which is too large.\n')
            continue
        cfg_no = 1
        for path in all_paths:
            cfg_path_info = obtain_cfg_path_info(path, cfg_dot_input)

            dict_cfg_path_entities['FEN:ID'].append(FEN + '.CFG_Path_' + str(cfg_no))
            dict_cfg_path_entities[':LABEL'].append('CFG_Path')
            dict_cfg_path_entities['CFG_Path'].append(cfg_path_info.replace('\n', '\\n'))

            cfg_no += 1
        resolved_path += 1

    df_cfg_path_entities = pd.DataFrame(dict_cfg_path_entities)
    df_cfg_path_entities.to_csv(saved_csv_file_path, index=False)




    # 1-5
    num_1_5 = 0
    num_6_10 = 0
    num_10_20 = 0
    num_20_100 = 0
    num_100_1000 = 0
    num_1000 = 0
    total_num = 0
    for key, value in dict_cfg_pathnum_to_num.items():
        total_num += value
        if key <= 5:
            num_1_5 += value
        elif key <= 10:
            num_6_10 += value
        elif key <= 20:
            num_10_20 += value
        elif key <= 100:
            num_20_100 += value
        elif key <= 1000:
            num_100_1000 += value
        else:
            num_1000 += value


    print("There are {} methods with CFG Paths in the range {}, representing a proportion of {} of all methods.".format(num_1_5, '1-5', num_1_5/total_num))
    print("There are {} methods with CFG Paths in the range {}, representing a proportion of {} of all methods.".format(num_6_10, '6-10', num_6_10/total_num))
    print("There are {} methods with CFG Paths in the range {}, representing a proportion of {} of all methods.".format(num_10_20, '10-20', num_10_20/total_num))
    print("There are {} methods with CFG Paths in the range {}, representing a proportion of {} of all methods.".format(num_20_100, '20-100', num_20_100/total_num))
    print("There are {} methods with CFG Paths in the range {}, representing a proportion of {} of all methods.".format(num_100_1000, '100-1000', num_100_1000/total_num))
    print("There are {} methods with CFG Paths in the range {}, representing a proportion of {} of all methods.".format(num_1000, '1000+', num_1000/total_num))
    print('\n')

    num_1_100 = num_1_5 + num_6_10 + num_10_20 + num_20_100
    print("There are {} methods with CFG Paths in the range {}, representing a proportion of {} of all methods.".format(num_1_100, '1-100', num_1_100/total_num))



def construct_has_cfg_path_relations(cfg_path_entities_path, has_cfg_path_relations_path):
    df_cfg_path_entities = pd.read_csv(cfg_path_entities_path)
    dict_has_cfg_path_relations = {'FEN:START_ID': [], 'FEN:END_ID': [], ':TYPE': []}

    for index, row in tqdm.tqdm(df_cfg_path_entities.iterrows(), total=df_cfg_path_entities.shape[0]):
        cfg_path_FEN = row['FEN:ID']
        method_FEN = cfg_path_FEN.split('.CFG_Path_')[0]
        dict_has_cfg_path_relations['FEN:START_ID'].append(method_FEN)
        dict_has_cfg_path_relations['FEN:END_ID'].append(cfg_path_FEN)
        dict_has_cfg_path_relations[':TYPE'].append('Has_CFG_Path')

    df_has_cfg_path_relations = pd.DataFrame(dict_has_cfg_path_relations)
    df_has_cfg_path_relations.to_csv(has_cfg_path_relations_path, index=False)

def cfg_path_entities_and_relations_extraction():
    obtain_all_cfg_paths(Config.method_entities_path, Config.cfg_path_entities_path, Config.cfg_path_construction_error_file_path)
    construct_has_cfg_path_relations(Config.cfg_path_entities_path, Config.has_cfg_path_relations_path)


if __name__ == '__main__':


    cfg_path_entities_and_relations_extraction()


#     cfg_dot = """digraph cfg_deepEmpty {
# 	"1" [label="$stack5 = staticinvoke <org.apache.commons.lang3.StringUtils: boolean isNotEmpty(java.lang.CharSequence)>(s)"];
# 	"2" [label="goto"];
# 	"3" [label="if $stack5 == 0"];
# 	"4" [label="if l3 >= l2"];
# 	"5" [label="if strings == null"];
# 	"6" [label="l1 = strings"];
# 	"7" [label="l2 = lengthof l1"];
# 	"8" [label="l3 = 0"];
# 	"9" [label="l3 = l3 + 1"];
# 	"11" [label="return 1"];
# 	"12" [label="s = l1[l3]"];
# 	"13" [label="strings := @parameter0: java.lang.String[]"];
# 	"1" -> "3"[label="cfg_next"];
# 	"12" -> "1"[label="cfg_next"];
# 	"13" -> "5"[label="cfg_next"];
# 	"2" -> "4"[label="cfg_goto"];
# 	"3" -> "9"[label="cfg_true"];
# 	"4" -> "11"[label="cfg_true"];
# 	"4" -> "12"[label="cfg_false"];
# 	"5" -> "11"[label="cfg_true"];
# 	"5" -> "6"[label="cfg_false"];
# 	"6" -> "7"[label="cfg_next"];
# 	"7" -> "8"[label="cfg_next"];
# 	"8" -> "4"[label="cfg_next"];
# 	"9" -> "2"[label="cfg_next"];
# }"""
#     cfg_from_dot = parse_dot_to_cfg(cfg_dot)
#     all_paths = extract_paths(cfg_from_dot)
#     a = 1
