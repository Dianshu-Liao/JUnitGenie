import pandas as pd
import re
import tqdm
from config import Config
import os
import shutil
# def get_runnable_code_from_test_code(test_code, package_name, class_name):
#     pattern = r'```java\s*\n(.*?)\n```'
#     matches = re.findall(pattern, test_code, re.DOTALL)
#
#     try:

#         test_code = matches[-1]
#     except:
#         a = 1
#     # Regex pattern for import statements
#     import_pattern = r'^import\s.+;$'
#     imports = re.findall(import_pattern, test_code, re.MULTILINE)
#
#     # Updated regex pattern for the class definition and its body
#     class_pattern = r'class\s+\w+\s*\{([\s\S]*)\}$'
#     class_match = re.search(class_pattern, test_code, re.MULTILINE)
#
#     # Extract the code within the class, stripping extra spaces
#     class_code = class_match.group(1) if class_match else ""
#
#     runnable_code = 'package ' + package_name + ';\n'
#     runnable_code += '\n'.join(imports)
#
#     # Format the class body
#     class_body = f"\n\npublic class {class_name} {{{class_code}\n}}"
#
#     # Combine imports and class body
#     runnable_code += class_body
#
#     return runnable_code

def extract_class_body(code):
    start = code.find('{')
    if start == -1:
        return ""

    stack = []
    for i in range(start, len(code)):
        if code[i] == '{':
            stack.append('{')
        elif code[i] == '}':
            stack.pop()
            if not stack:
                return code[start + 1:i]

    return ""


def get_runnable_code_from_test_code(test_code, package_name, class_name):

    test_code = re.sub(r'^(import\s+.*?;)\s*//.*$', r'\1', test_code, flags=re.MULTILINE)

    test_code = re.sub(r'/\*.*?\*/', '', test_code, flags=re.DOTALL)


    test_code = test_code.replace('    @Test\n', '    @Test(timeout = 4000)\n')

    pattern = r'```java\s*\n(.*?)\n```'
    matches = re.findall(pattern, test_code, re.DOTALL)

    try:
        test_code = matches[-1]
    except:
        return "can't match the test code"

    import_pattern = r'^import\s.+;$'
    imports = re.findall(import_pattern, test_code, re.MULTILINE)

    class_code = extract_class_body(test_code)


    class_decl_pattern = r'(public\s+)?class\s+\w+[^\\{]*\{'
    class_decl_match = re.search(class_decl_pattern, test_code)

    if class_decl_match:
        class_decl_line = class_decl_match.group().strip('{').strip()


        original_name_match = re.search(r'class\s+(\w+)', class_decl_line)
        if original_name_match:
            original_class_name = original_name_match.group(1)
            full_class_header = class_decl_line.replace(original_class_name, class_name, 1)
        else:
            full_class_header = f'public class {class_name}'
    else:
        full_class_header = f'public class {class_name}'

    runnable_code = f'package {package_name};\n'
    runnable_code += '\n'.join(imports)

    class_body = f"\n\n{full_class_header} {{{class_code}\n}}"
    runnable_code += class_body

    return runnable_code



def empty_test_dir(all_project_dirs):
    print('Emptying test directories...')
    test_dir_list = []

    for project_dir in all_project_dirs:
        test_dir = Config.package_name_to_test_dir[project_dir.replace('_', '.')]
        test_dir_list.append(test_dir)
    test_dir_list = list(set(test_dir_list))
    for test_dir in test_dir_list:
        delete_all_contents(test_dir)
        # if not os.path.exists(test_dir):
        #     os.makedirs(test_dir)
        # else:
        #     for file in os.listdir(test_dir):
        #         os.remove(os.path.join(test_dir, file))

    print('Test directories emptied.')


def delete_all_contents(folder_path):
    """  Delete all files and subfolders under the `folder_path` directory, but do not delete `folder_path` itself """
    if os.path.exists(folder_path):
        for item in os.listdir(folder_path):
            item_path = os.path.join(folder_path, item)
            if os.path.isfile(item_path) or os.path.islink(item_path): 
                os.remove(item_path)
            elif os.path.isdir(item_path):  
                shutil.rmtree(item_path)
    else:
        print(f"Folder {folder_path} does not exist.")


def formatting_for_normal_code(result_path, result_after_formatting_path, prompt_key, test_code_key):
    normal_code_result = pd.read_csv(result_path)
    normal_code_result['runnable_test_code'] = ''
    normal_code_result['saved_path'] = ''
    all_project_dirs = normal_code_result['project_dir'].unique()
    empty_test_dir(all_project_dirs)
    for index, row in tqdm.tqdm(normal_code_result.iterrows(), total=normal_code_result.shape[0]):
        project_dir = row['project_dir']

        package_name = project_dir.replace('_', '.')


        test_gen_prompt = row[prompt_key]
        test_code = row[test_code_key]
        if test_gen_prompt == 'error' or pd.isna(test_gen_prompt) or test_code == 'error':
            normal_code_result.loc[index, 'runnable_test_code'] = 'error'
            normal_code_result.loc[index, 'saved_path'] = 'error'
            continue
        method_FEN = row['method_FEN']
        test_code_class_name = method_FEN.replace(package_name + '.', '').replace('.', '_').replace('(', '_').replace(')', '').replace(',', '_').replace('[', '__').replace(']', '__').replace('$', '__dollarsign__').replace('<', '_').replace('>', '_') + '_Test'
        test_code_file_name = test_code_class_name + '.java'
        test_dir = Config.package_name_to_test_dir[package_name]





        saved_path = f'{test_dir}/{test_code_file_name}'
        normal_code_result.loc[index, 'saved_path'] = saved_path
        runnable_code = get_runnable_code_from_test_code(test_code, package_name, test_code_class_name)
        normal_code_result.loc[index, 'runnable_test_code'] = runnable_code

        f = open(saved_path, 'w')
        f.write(runnable_code)
        f.close()

    normal_code_result.to_csv(result_after_formatting_path, index=False)



def formatting_for_code_generated_by_our_approach():
    pass

if __name__ == '__main__':

    # package_name = 'org.apache.commons.lang3'
    # our_approach_result_path = 'saved_data/experiment_results/org_apache_commons_lang3_previous/our_approach_results.csv'
    #
    # our_approach_result = pd.read_csv(our_approach_result_path)
    #
    # our_approach_result_after_formatting_path = 'saved_data/experiment_results/org_apache_commons_lang3_previous/our_approach_results_after_formatting.csv'
    #
    # our_approach_result['runnable_test_code'] = ''
    # our_approach_result['saved_path'] = ''
    # for index, row in tqdm.tqdm(our_approach_result.iterrows(), total=our_approach_result.shape[0]):
    #     test_gen_prompt = row['test_gen_prompt']
    #     test_code = row['test_code']
    #     if test_gen_prompt == 'error' or pd.isna(test_gen_prompt):
    #         our_approach_result.loc[index, 'runnable_test_code'] = 'error'
    #         our_approach_result.loc[index, 'saved_path'] = 'error'
    #         continue
    #     method_FEN = row['method_FEN']
    #     method_file_name = method_FEN.replace('org.apache.commons.lang3.', '').replace('.', '_').replace('(', '_').replace(')', '').replace(',', '_').replace('[', '__').replace(']', '__').replace('$', '__dollarsign__')
    #     cfg_path_no = row['cfg_path_no']
    #     class_name = f'{method_file_name}_cfg_path_{cfg_path_no}'
    #     method_file_with_cfg_path = class_name + '.java'
    #     saved_path = f'/Users/dianshuliao/Documents/Research/TestCaseGeneration/Java_Projects/lang_1_buggy_check_evosuite_results_2/src/test/java/org/apache/commons/lang3/{method_file_with_cfg_path}'
    #     our_approach_result.loc[index, 'saved_path'] = saved_path
    #     runnable_code = get_runnable_code_from_test_code(test_code, package_name)
    #     our_approach_result.loc[index, 'runnable_test_code'] = runnable_code
    #
    #     f = open(saved_path, 'w')
    #     f.write(runnable_code)
    #     f.close()
    #
    # our_approach_result.to_csv(our_approach_result_after_formatting_path, index=False)


    pass

