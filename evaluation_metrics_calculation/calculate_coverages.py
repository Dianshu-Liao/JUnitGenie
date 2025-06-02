import xml.etree.ElementTree as ET
import pandas as pd
import re
from utils import Util
from config import Config
import os

# Mapping JVM Types to Java Types
JVM_TYPE_MAP = {
    'V': 'void',
    'Z': 'boolean',
    'B': 'byte',
    'C': 'char',
    'S': 'short',
    'I': 'int',
    'J': 'long',
    'F': 'float',
    'D': 'double'
}


def parse_jvm_type(desc):
    """Resolving JVM Type Descriptors to Java Types"""
    if desc in JVM_TYPE_MAP:
        return JVM_TYPE_MAP[desc]
    elif desc.startswith("L") and desc.endswith(";"):
        return desc[1:-1].replace("/", ".")  # Ljava/lang/String; -> java.lang.String
    else:
        return desc  # In case of an unknown situation, return as is


def parse_method_signature(method_desc):
    """Resolving JVM Method Signatures"""
    match = re.match(r"\((.*?)\)(.*)", method_desc)
    if not match:
        return method_desc   # Parsing failed, return original value

    param_part, return_part = match.groups()

    # Parse the parameters
    params = []
    i = 0
    while i < len(param_part):
        array_dim = 0
        while i < len(param_part) and param_part[i] == "[":
            array_dim += 1
            i += 1

        if i < len(param_part):
            if param_part[i] in JVM_TYPE_MAP:
                java_type = JVM_TYPE_MAP[param_part[i]]
                i += 1
            elif param_part[i] == "L":
                end = param_part.index(";", i) + 1
                java_type = parse_jvm_type(param_part[i:end])
                i = end
            else:
                java_type = param_part[i]
                i += 1

            params.append(java_type + "[]" * array_dim)

    # Parse the return value
    return_type = parse_jvm_type(return_part)
    if return_part.startswith("["):
        return_type = parse_jvm_type(return_part[return_part.rindex("[") + 1:]) + "[]" * return_part.count("[")

    return f"({', '.join(params)}) → {return_type}"


def construct_method_FEN(class_name, method_name, method_signature):

    # method parameters is the parameter part of method_signature, and all the fqn in the parameter become simple names. For example: (float[], java.lang.Integer[]) -> void becomes (float[], Integer[]) -> void
    method_parameters = method_signature.split(" → ")[0]
    method_parameter_list = method_parameters.replace('(', '').replace(')', '').split(",")
    new_method_parameters = ""
    for method_parameter in method_parameter_list:
        method_parameter = method_parameter.strip()
        if "." in method_parameter:
            simple_name = method_parameter.split(".")[-1]

            if "$" in simple_name:
                simple_name = simple_name.split("$")[-1]

            new_method_parameters += simple_name + ","

        else:
            new_method_parameters += method_parameter + ","

    new_method_parameters = '(' + new_method_parameters[:-1] + ')'
    method_FEN = class_name.replace('/', '.') + "." + method_name + new_method_parameters
    return method_FEN


def jacoco_based_results(jacoco_xml_path):
    tree = ET.parse(jacoco_xml_path)
    root = tree.getroot()

    coverage_data = []

    for package in root.findall('.//package'):
        package_name = package.get('name')
        for class_ in package.findall("class"):
            class_name = class_.get('name')
            for method in class_.findall('method'):
                method_name = method.get('name')
                jvm_method_desc = method.get('desc')
                method_signature = parse_method_signature(method.get('desc'))
                method_FEN = construct_method_FEN(class_name, method_name, method_signature)

                # 初始化覆盖率数据
                missed_instr = covered_instr = percentage_instr = 0
                missed_branches = covered_branches = percentage_branches = 0
                missed_lines = covered_lines = percentage_lines = 0
                missed_methods = covered_methods = percentage_methods = 0
                complexity = 0

                # Iterate over counter tags to get different coverage data
                for counter in method.findall('counter'):
                    type_ = counter.get('type')
                    missed = int(counter.get('missed'))
                    covered = int(counter.get('covered'))

                    if type_ == "INSTRUCTION":
                        missed_instr = missed
                        covered_instr = covered
                        percentage_instr = covered / (missed + covered)
                    elif type_ == "BRANCH":
                        missed_branches = missed
                        covered_branches = covered
                        percentage_branches = covered / (missed + covered)
                    elif type_ == "LINE":
                        missed_lines = missed
                        covered_lines = covered
                        percentage_lines = covered / (missed + covered)
                    elif type_ == "METHOD":
                        missed_methods = missed
                        covered_methods = covered
                        percentage_methods = covered / (missed + covered)
                    elif type_ == "COMPLEXITY":
                        complexity = missed + covered  # Total Complexity = Covered + Uncovered

                if missed_branches == 0 and covered_branches == 0:
                    percentage_branches = 'coverage not available since no branches'


                coverage_data.append([
                    package_name, class_name, method_name, method_signature, method_FEN,
                    missed_instr, covered_instr, percentage_instr,
                    missed_branches, covered_branches, percentage_branches,
                    complexity,
                    missed_lines, covered_lines, percentage_lines,
                    missed_methods, covered_methods, percentage_methods
                ])

    # Convert to Pandas DataFrame
    columns = [
        'package_name', 'class_name', 'method_name', 'method_signature', 'method_FEN',
        'missed_instr', 'covered_instr', 'percentage_instr',
        'missed_branches', 'covered_branches', 'percentage_branches',
        'complexity',
        'missed_lines', 'covered_lines', 'percentage_lines',
        'missed_methods', 'covered_methods', 'percentage_methods'
    ]
    coverage_df = pd.DataFrame(coverage_data, columns=columns)
    return coverage_df

def get_method_corresponding_rows_in_jacoco(sample_dataset_path, jacoco_results):


    sampled_dataset = pd.read_csv(sample_dataset_path)
    current_project_dir = Config.project_package_name.replace('.', '_')
    dataset = sampled_dataset[sampled_dataset['project_dir'] == current_project_dir]
    all_method_FENs_in_dataset = dataset['method_FEN'].unique()


    method_corresponding_rows_in_jacoco = []
    # Find method_FEN in jacoco_results in all_detected_methods_FENs line
    for method_FEN in all_method_FENs_in_dataset:
        rows = jacoco_results[jacoco_results['method_FEN'] == method_FEN]
        if rows.shape[0] == 0:
            print(f"Method {method_FEN} not found in jacoco results")
            pass
            # raise Exception(f"Method {method_FEN} not found in jacoco results")
        else:
            method_corresponding_rows_in_jacoco.append(rows)

    method_corresponding_rows_in_jacoco = pd.concat(method_corresponding_rows_in_jacoco)
    method_corresponding_rows_in_jacoco = method_corresponding_rows_in_jacoco.drop_duplicates(subset=['method_FEN'])
    return method_corresponding_rows_in_jacoco


def coverage_of_our_approach(our_approach_jacoco_xml_path, our_approach_jacoco_result_path, dataset_path, our_approach_result_after_formatting_path):

    our_approach_jacoco_results = jacoco_based_results(our_approach_jacoco_xml_path)
    our_approach_jacoco_results.to_csv(our_approach_jacoco_result_path, index=False)


    # remain the rows in our_approach_result_after_formatting_path that the method_FEN is in dataset

    method_corresponding_rows_in_jacoco = get_method_corresponding_rows_in_jacoco(dataset_path, our_approach_jacoco_results)

    all_methods = method_corresponding_rows_in_jacoco['method_FEN'].unique()



    our_approach_result_after_formatting = pd.read_csv(our_approach_result_after_formatting_path)
    our_approach_result_after_formatting = our_approach_result_after_formatting[our_approach_result_after_formatting['method_FEN'].isin(method_corresponding_rows_in_jacoco['method_FEN'])]


    methods_handled_by_our_approach = our_approach_result_after_formatting[our_approach_result_after_formatting['test_gen_prompt'] != 'error']['method_FEN'].unique()

    print(f"Total methods: {len(all_methods)}")
    print(f"Methods handled by our approach: {len(methods_handled_by_our_approach)}")
    print(f"Methods without syntax error: {len(method_corresponding_rows_in_jacoco)}")
    print()

    avg_instr_coverage = method_corresponding_rows_in_jacoco['percentage_instr'].mean()

    avg_line_coverage = method_corresponding_rows_in_jacoco['percentage_lines'].mean()
    avg_method_coverage = method_corresponding_rows_in_jacoco['percentage_methods'].mean()

    method_corresponding_rows_for_branch_coverage_in_jacoco = method_corresponding_rows_in_jacoco[method_corresponding_rows_in_jacoco['percentage_branches'] != 'coverage not available since no branches']
    avg_branch_coverage = method_corresponding_rows_for_branch_coverage_in_jacoco['percentage_branches'].mean()

    print(f"Average instruction coverage (denominator is {len(method_corresponding_rows_in_jacoco)}): {avg_instr_coverage}")
    print(f"Average branch coverage (denominator is {len(method_corresponding_rows_in_jacoco)}): {avg_branch_coverage}")
    print(f"Average line coverage (denominator is {len(method_corresponding_rows_in_jacoco)}): {avg_line_coverage}")
    print(f"Average method coverage (denominator is {len(method_corresponding_rows_in_jacoco)}): {avg_method_coverage}")
    print()



def coverage(jacoco_xml_path, jacoco_result_path, sample_dataset_path):


    jacoco_results = jacoco_based_results(jacoco_xml_path)
    jacoco_results.to_csv(jacoco_result_path, index=False)

    # remain the rows in our_approach_result_after_formatting_path that the method_FEN is in dataset

    method_corresponding_rows_in_jacoco = get_method_corresponding_rows_in_jacoco(sample_dataset_path,
                                                                                  jacoco_results)

    all_covered_instr = method_corresponding_rows_in_jacoco['covered_instr'].sum()
    all_missed_instr = method_corresponding_rows_in_jacoco['missed_instr'].sum()
    all_instr = all_covered_instr + all_missed_instr
    all_instr_coverage = all_covered_instr / all_instr

    all_covered_branches = method_corresponding_rows_in_jacoco['covered_branches'].sum()
    all_missed_branches = method_corresponding_rows_in_jacoco['missed_branches'].sum()
    all_branches = all_covered_branches + all_missed_branches
    all_branch_coverage = all_covered_branches / all_branches

    all_covered_lines = method_corresponding_rows_in_jacoco['covered_lines'].sum()
    all_missed_lines = method_corresponding_rows_in_jacoco['missed_lines'].sum()
    all_lines = all_covered_lines + all_missed_lines
    all_line_coverage = all_covered_lines / all_lines

    all_covered_methods = method_corresponding_rows_in_jacoco['covered_methods'].sum()
    all_missed_methods = method_corresponding_rows_in_jacoco['missed_methods'].sum()
    all_methods = all_covered_methods + all_missed_methods
    all_method_coverage = all_covered_methods / all_methods


    # use percentage format, and round to 2 decimal places. For example, 0.95715 -> 95.72%
    all_instr_coverage = round(all_instr_coverage * 100, 2)
    all_branch_coverage = round(all_branch_coverage * 100, 2)
    all_line_coverage = round(all_line_coverage * 100, 2)
    all_method_coverage = round(all_method_coverage * 100, 2)
    print(f"Total instruction coverage: {all_instr_coverage}%")
    print(f"Total branch coverage: {all_branch_coverage}%")
    print(f"Total line coverage: {all_line_coverage}%")
    print(f"Total method coverage: {all_method_coverage}%")


def project_ave(result_path_list, sample_dataset_path):
    sample_dataset = pd.read_csv(sample_dataset_path)

    all_data = []
    for result_path in result_path_list:
        data = pd.read_csv(result_path)
        all_data.append(data)

    all_data = pd.concat(all_data)
    all_data = all_data.drop_duplicates(subset=['method_FEN'])
    all_data = all_data[all_data['method_FEN'].isin(sample_dataset['method_FEN'])]

    missed_instr = all_data['missed_instr'].sum()
    covered_instr = all_data['covered_instr'].sum()
    instr = missed_instr + covered_instr
    instr_coverage = covered_instr / instr

    missed_branches = all_data['missed_branches'].sum()
    covered_branches = all_data['covered_branches'].sum()
    branches = missed_branches + covered_branches
    branch_coverage = covered_branches / branches

    missed_lines = all_data['missed_lines'].sum()
    covered_lines = all_data['covered_lines'].sum()
    lines = missed_lines + covered_lines
    line_coverage = covered_lines / lines

    missed_methods = all_data['missed_methods'].sum()
    covered_methods = all_data['covered_methods'].sum()
    methods = missed_methods + covered_methods
    method_coverage = covered_methods / methods

    instr_coverage = round(instr_coverage * 100, 2)
    branch_coverage = round(branch_coverage * 100, 2)
    line_coverage = round(line_coverage * 100, 2)
    method_coverage = round(method_coverage * 100, 2)
    print('All project coverage:')
    print(f"Total instruction coverage: {instr_coverage}%")
    print(f"Total branch coverage: {branch_coverage}%")
    print(f"Total line coverage: {line_coverage}%")
    print(f"Total method coverage: {method_coverage}%")
    print('\n')

def calculate_coverages_based_on_jacoco_results(jacoco_result_dir):
    jacoco_result_path_list = []
    package_name_to_test_dir = Config.package_name_to_test_dir
    for package_name, test_dir in package_name_to_test_dir.items():
        Config.project_package_name = package_name
        jacoco_xml_path = jacoco_result_dir + package_name.replace('.', '_') + '_jacoco.xml'
        if not os.path.exists(jacoco_xml_path):
            # print(f'Jacoco XML file does not exist for package {package_name}: {jacoco_xml_path}')
            continue
        print('package_name:', package_name)

        jacoco_result_path = jacoco_xml_path.replace('.xml', '.csv')
        jacoco_result_path_list.append(jacoco_result_path)
        coverage(jacoco_xml_path, jacoco_result_path, Config.sampled_dataset_path_for_all_projects)


        print('\n\n')

    project_ave(jacoco_result_path_list, Config.sampled_dataset_path_for_all_projects)




if __name__ == '__main__':


    print('Evosuite coverage:')
    coverage(Config.evosuite_jacoco_xml_path, Config.evosuite_jacoco_result_path, Config.sampled_dataset_path_for_all_projects)


    print('Randoop coverage:')
    coverage(Config.randoop_jacoco_xml_path, Config.randoop_jacoco_result_path, Config.sampled_dataset_path_for_all_projects)

    # project_ave()