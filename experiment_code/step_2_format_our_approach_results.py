import pandas as pd

from pipelines.code_formatting import get_runnable_code_from_test_code, empty_test_dir
from config import Config
import tqdm
import os
def format_our_approach_results(our_approach_result_path, our_approach_result_after_formatting_path):
    our_approach_result = pd.read_csv(our_approach_result_path)


    our_approach_result['saved_path'] = ''
    our_approach_result['test_code_after_formatting'] = ''


    for index, row in tqdm.tqdm(our_approach_result.iterrows(), total=our_approach_result.shape[0]):
        test_code = row['test_code']
        if test_code == 'error' or pd.isna(test_code):
            our_approach_result.loc[index, 'test_code_after_formatting'] = 'error'
            our_approach_result.loc[index, 'saved_path'] = 'error'
            continue

        method_FEN = row['method_FEN']


        # method_name is the last part by splitting method_FEN by '.'
        method_name = method_FEN.split('.')[-1]
        # class_name is the second last part by splitting method_FEN by '.'. However, if there is a $ in method_FEN, the outermost class_name is the first part of method_FEN after splitting method_FEN with '$'.
        if '$' in method_FEN:
            class_name = method_FEN.split('$')[0].split('.')[-1]
        else:
            class_name = method_FEN.split('.')[-2]

        # package import name is the part before the class_name
        package_import_name = method_FEN.split('.' + class_name)[0]


        cfg_path_no = row['cfg_path_no']


        project_dir = row['project_dir']
        package_name = project_dir.replace('_', '.')
        class_name = method_FEN.replace(package_name + '.', '').replace('.', '_').replace('(', '_').replace(')',
                                                                                                            '').replace(
            ',', '_').replace('[', '__').replace(']', '__').replace('$', '__dollarsign__').replace('<', '_').replace(
            '>', '_') + '_cfg_path_' + str(cfg_path_no) + '_Test'
        test_code_after_formatting = get_runnable_code_from_test_code(test_code, package_import_name, class_name)
        if pd.isna(test_code_after_formatting):
            a = 1
        our_approach_result.loc[index, 'test_code_after_formatting'] = test_code_after_formatting
        saved_file_name = class_name + '.java'
        test_dir = Config.package_name_to_test_dir[package_name] + '/' + package_import_name.replace('.', '/')

        saved_path = f'{test_dir}/{saved_file_name}'
        our_approach_result.loc[index, 'saved_path'] = saved_path

    our_approach_result.to_csv(our_approach_result_after_formatting_path, index=False)


def write_all_formatted_code_to_test_dir(our_approach_result_after_formatting_path):
    our_approach_result_after_formatting = pd.read_csv(our_approach_result_after_formatting_path)
    count_num = 0
    all_project_dirs = list(set(our_approach_result_after_formatting['project_dir'].tolist()))
    empty_test_dir(all_project_dirs)
    for index, row in tqdm.tqdm(our_approach_result_after_formatting.iterrows(),
                                total=our_approach_result_after_formatting.shape[0]):
        saved_path = row['saved_path']
        test_code_after_formatting = row['test_code_after_formatting']
        if saved_path == 'error' or test_code_after_formatting == 'error' or test_code_after_formatting == "can't match the test code":
            if saved_path == "can't match the test code":
                count_num += 1
            continue

        # if saved path's directory does not exist, create it
        saved_dir = os.path.dirname(saved_path)
        if not os.path.exists(saved_dir):
            os.makedirs(saved_dir)


        f = open(saved_path, 'w')
        f.write(test_code_after_formatting)
        f.close()
    print('number of test code that can not be matched:', count_num)

if __name__ == '__main__':
    our_approach_result_path = 'our_approach_gpt4omini_results/RQ1_our_approach_results.csv'
    # our_approach_result_path = 'our_approach_gpt4omini_results/RQ1_our_approach_results_com_fasterxml_jackson_core.csv'
    # our_approach_result_after_formatting_path = 'our_approach_gpt4omini_results/RQ1_our_approach_results_after_formatting.csv'

    our_approach_result_after_formatting_path = 'our_approach_gpt4omini_results/RQ1_our_approach_results_after_formatting.csv'
    # our_approach_result_after_formatting_path = 'our_approach_gpt4omini_results/RQ1_our_approach_results_after_formatting_by_changing_the_test_dir.csv'
    # our_approach_result_after_formatting_path = 'our_approach_gpt4omini_results/RQ1_our_approach_results_after_formatting_com_fasterxml_jackson_core.csv'

    format_our_approach_results(our_approach_result_path, our_approach_result_after_formatting_path)
    write_all_formatted_code_to_test_dir(our_approach_result_after_formatting_path)