import pandas as pd
from config import Config
import tqdm
from llm_utils import LLM_Utils
from utils import Util
import re
from concurrent.futures import ThreadPoolExecutor, as_completed
from pipelines.code_formatting import get_runnable_code_from_test_code, empty_test_dir
import os
def extract_test_blocks(log: str):
    blocks = {}
    current_name = None
    current_lines = []

    for line in log.splitlines():
        # Beginning of Block
        if line.startswith("[INFO] Running "):
            # Save the previous block (including case error reporting)
            if current_name and current_lines:
                blocks[current_name] = '\n'.join(current_lines).strip()

            current_name = line[len("[INFO] Running "):].strip()
            current_lines = [line]

        # New block not started but in current block
        elif current_name:
            current_lines.append(line)

    # Process the last block
    if current_name and current_lines:
        blocks[current_name] = '\n'.join(current_lines).strip()

    return blocks





def get_to_be_analyzed_csv_file(RQ1_our_approach_results_path, jacoco_results_path, project_name):
    RQ1_our_approach_results = pd.read_csv(RQ1_our_approach_results_path)
    sampled_dataset = pd.read_csv(Config.sampled_dataset_path_for_all_projects)
    jacoco_results = pd.read_csv(jacoco_results_path)


    project_dir = project_name.replace('.', '_')
    project_sampled_dataset = sampled_dataset[sampled_dataset['project_dir'] == project_dir]
    method_FENs = project_sampled_dataset['method_FEN'].tolist()
    jacoco_results = jacoco_results[jacoco_results['method_FEN'].isin(method_FENs)]
    our_approach_results_for_project = RQ1_our_approach_results[RQ1_our_approach_results['project_dir'] == project_dir]

    # find the rows in jacoco_results that the column 'percentage_branches' is not 1
    relevant_rows = jacoco_results[jacoco_results['percentage_branches'] != '1.0']
    method_FENs_list_that_have_less_than_100_percentage_branches = relevant_rows['method_FEN'].tolist()
    our_approach_results_for_project = our_approach_results_for_project[our_approach_results_for_project['method_FEN'].isin(method_FENs_list_that_have_less_than_100_percentage_branches)]
    return our_approach_results_for_project

def find_corresponding_rows_in_df(method_FEN, df):
    corresponding_rows = df[df['method_FEN'] == method_FEN]
    for index, row in corresponding_rows.iterrows():
        if row['test_gen_prompt'] == 'error':
            continue
        test_gen_prompt = eval(row['test_gen_prompt'])
        test_code_after_formatting = row['test_code_after_formatting']
        print('method_FEN:', method_FEN)
        print('test code after formatting:\n', test_code_after_formatting)
        print('-------------------------------\n')

def get_list_of_all_method_FENs_that_coverage_less_than_100_percent(RQ1_our_approach_results_path, jacoco_results_path, project_name):
    our_approach_results_for_project = get_to_be_analyzed_csv_file(RQ1_our_approach_results_path, jacoco_results_path, project_name)
    method_FENs = list(set(our_approach_results_for_project['method_FEN'].tolist()))
    jacoco_results = pd.read_csv(jacoco_results_path)
    jacoco_corresponding_rows = jacoco_results[jacoco_results['method_FEN'].isin(method_FENs)]

    #对jacoco_corresponding_rows的'percentage_branches'列排序，从小到大
    jacoco_corresponding_rows = jacoco_corresponding_rows.sort_values(by='percentage_branches', ascending=True)

    list_of_all_method_FENs = jacoco_corresponding_rows['method_FEN'].tolist()

    return list_of_all_method_FENs

def get_saved_path_to_error_message_dict(RQ1_our_approach_results_path, jacoco_results_path, project_name):
    list_of_all_method_FENs = get_list_of_all_method_FENs_that_coverage_less_than_100_percent(RQ1_our_approach_results_path, jacoco_results_path, project_name)

    f = open(mvn_test_log_path, 'r')
    mvn_test_log = f.read()
    f.close()


    blocks = extract_test_blocks(mvn_test_log)

    our_approach_results = pd.read_csv(RQ1_our_approach_results_path)
    rows_that_correspond_to_list_of_all_method_FENs = our_approach_results[our_approach_results['method_FEN'].isin(list_of_all_method_FENs)]

    all_saved_paths = rows_that_correspond_to_list_of_all_method_FENs['saved_path'].tolist()
    dict_of_saved_path_to_error_message = {'file_name': [], 'syntax_error_message': []} # please change the 'syntax_error_message' to 'error_message' in the future!!!!!!
    for saved_path in all_saved_paths:
        class_file_name = saved_path.replace(test_dir, '').strip('/').replace('/', '.').replace('.java', '')
        if class_file_name in blocks:

            block = blocks[class_file_name].replace('\\n', '\n')

            # Grab the first stats line containing ‘Tests run:’ (INFO / ERROR prefixes are possible)
            stats_line = next((ln for ln in block.splitlines() if 'Tests run:' in ln), None)

            if stats_line:

                m = re.search(
                    r'Tests run:\s*\d+,\s*Failures:\s*(\d+),\s*Errors:\s*(\d+),\s*Skipped:\s*(\d+)',
                    stats_line
                )
                if m:
                    failures = int(m.group(1))
                    errors = int(m.group(2))
                    skipped = int(m.group(3))


                    if errors == 0 and skipped == 0 and failures > 0:
                        continue
                    if errors == 0 and skipped == 0 and failures == 0:

                        the_num_of_lines = len(block.split('\n'))
                        if the_num_of_lines == 2:
                            continue


            dict_of_saved_path_to_error_message['file_name'].append(saved_path)
            dict_of_saved_path_to_error_message['syntax_error_message'].append(block.replace('\n', '\\n'))

    return dict_of_saved_path_to_error_message


def obtain_error_message_csv(RQ1_our_approach_results_path, jacoco_results_path, project_name, filesWithSyntaxErrorCsv):
    dict_of_saved_path_to_error_message = get_saved_path_to_error_message_dict(RQ1_our_approach_results_path, jacoco_results_path, project_name)
    df_saved_path_to_error_message = pd.DataFrame(dict_of_saved_path_to_error_message)

    RQ1_our_approach_results = pd.read_csv(RQ1_our_approach_results_path)
    RQ1_our_approach_results_with_project_name = RQ1_our_approach_results[RQ1_our_approach_results['project_dir'] == project_name.replace('.', '_')]
    saved_paths_list = RQ1_our_approach_results_with_project_name['saved_path'].tolist()


    # df_saved_path_to_error_message keep only the line in RQ1_our_approach_results_with_project_name
    df_saved_path_to_error_message = df_saved_path_to_error_message[df_saved_path_to_error_message['file_name'].isin(saved_paths_list)]
    df_saved_path_to_error_message.to_csv(filesWithSyntaxErrorCsv, index=False)


def construct_code_refinement_prompt(error_message, test_code):
    system_prompt_path = Config.Code_Fixer_prompt_dir + '/System'
    system_prompt_content = LLM_Utils.read_prompt_file(system_prompt_path)
    system_prompt = [{'role': 'system', 'content': system_prompt_content}]
    input_prompt_path = Config.Code_Fixer_prompt_dir + '/Input'
    input_prompt_content = LLM_Utils.read_prompt_file(input_prompt_path)
    input_prompt_content = input_prompt_content.replace('#{}#', test_code, 1)
    input_prompt_content = input_prompt_content.replace('#{}#', error_message, 1)

    input_prompt = [{'role': 'user', 'content': input_prompt_content}]
    code_refinement_prompt = system_prompt + input_prompt
    return code_refinement_prompt

def process_refinement_row(index, row, api_key):
    """Process a single row for test code refinement."""
    project_dir = row['project_dir']
    method_FEN = row['method_FEN']
    cfg_path_no = row['cfg_path_no']
    # fifth_refinement_prompt = eval(row['fifth_refinement_prompt'])
    runtime_error_refinement_prompt = eval(row['runtime_error_refinement_prompt'])

    while True:
        try:
            test_code_after_runtime_error_refinement = LLM_Utils.trigger_GPT_API_basedon_http_request(
                runtime_error_refinement_prompt, model=Config.foundation_model_gpt4o_mini, openai_key=api_key
            )

            # method_name is the last part by splitting method_FEN by '.'
            method_name = method_FEN.split('.')[-1]
            # class_name is the second last part by splitting method_FEN by '.'. However, if there is a $ in method_FEN, the outermost class_name is the first part of method_FEN after splitting method_FEN with '$'.
            if '$' in method_FEN:
                class_name = method_FEN.split('$')[0].split('.')[-1]
            else:
                class_name = method_FEN.split('.')[-2]

            # package import name is the part before the class_name
            package_import_name = method_FEN.split('.' + class_name)[0]


            package_name = project_dir.replace('_', '.')
            class_name = method_FEN.replace(package_name + '.', '').replace('.', '_').replace('(', '_')\
                .replace(')', '').replace(',', '_').replace('[', '__').replace(']', '__')\
                .replace('$', '__dollarsign__').replace('<', '_').replace('>', '_') + f'_cfg_path_{cfg_path_no}_Test'
            test_code_after_runtime_error_after_formatting = get_runnable_code_from_test_code(
                test_code_after_runtime_error_refinement, package_import_name, class_name
            )

            return index, test_code_after_runtime_error_refinement, test_code_after_runtime_error_after_formatting

        except Exception as e:
            print(f"[ERROR] Refinement failed for {method_FEN} - {cfg_path_no}: {e}")
            continue

def get_code_refinement_prompts_for_our_approach(our_approach_result_after_formatting_path, syntax_error_messages_dir):
    all_csv_files = Util.find_files(syntax_error_messages_dir, endswith='.csv')

    # concatenate all csv files
    all_syntax_error_messages = pd.concat([pd.read_csv(file) for file in all_csv_files])
    all_filenames = all_syntax_error_messages['file_name'].tolist()

    our_approach_result = pd.read_csv(our_approach_result_after_formatting_path)
    our_approach_result['runtime_error_message'] = ''
    our_approach_result['runtime_error_refinement_prompt'] = ''


    for index, row in tqdm.tqdm(our_approach_result.iterrows(), total=our_approach_result.shape[0]):
        test_code_after_formatting = row['test_code_without_syntax_error']
        saved_path = row['saved_path']
        # file_name = saved_path.split('/')[-1]
        if saved_path in all_filenames:
        # if saved_path in all_filenames:
        #     corresponding_row = all_syntax_error_messages[all_syntax_error_messages['file_name'] == saved_path]
            corresponding_row = all_syntax_error_messages[all_syntax_error_messages['file_name'] == saved_path]


            if corresponding_row.empty:
                raise Exception(f"Cannot find corresponding row for {saved_path}")

            error_message = corresponding_row['syntax_error_message'].values[0].replace('\\n', '\n')
            if pd.isna(error_message):
                our_approach_result.loc[index, 'runtime_error_message'] = 'no runtime error thus no refinement needed'
                our_approach_result.loc[index, 'runtime_error_refinement_prompt'] = 'no runtime error thus no refinement needed'
                continue

            fifth_refinement_prompt = construct_code_refinement_prompt(error_message, test_code_after_formatting)
            our_approach_result.loc[index, 'runtime_error_message'] = error_message.replace('\n', '\\n')
            our_approach_result.loc[index, 'runtime_error_refinement_prompt'] = str(fifth_refinement_prompt)
        else:
            our_approach_result.loc[index, 'runtime_error_message'] = 'no runtime error thus no refinement needed'
            our_approach_result.loc[index, 'runtime_error_refinement_prompt'] = 'no runtime error thus no refinement needed'

    return our_approach_result

def get_test_code_after_refinement(RQ1_our_approach_results_path, RQ1_our_approach_after_runtime_error_fixed_path, syntax_error_messages_dir):
    """Parallel processing for refining test code."""
    our_approach_result = get_code_refinement_prompts_for_our_approach(
        RQ1_our_approach_results_path, syntax_error_messages_dir
    )


    our_approach_result['test_code_after_runtime_error_refinement'] = ''
    our_approach_result['test_code_after_runtime_error_after_formatting'] = ''

    batch_size = 200
    current_num = 0
    futures = []
    api_key_list = Config.api_key_list  # 假设 Config.api_key_list 包含多个可用的 OpenAI API Keys

    for index, row in tqdm.tqdm(our_approach_result.iterrows(), total=our_approach_result.shape[0]):

        if row['runtime_error_refinement_prompt'] == 'no runtime error thus no refinement needed':
            test_code_after_runtime_error_refinement = row['test_code_without_syntax_error']
            our_approach_result.at[index, 'test_code_after_runtime_error_refinement'] = test_code_after_runtime_error_refinement
            our_approach_result.at[index, 'test_code_after_runtime_error_after_formatting'] = test_code_after_runtime_error_refinement

    with ThreadPoolExecutor(max_workers=len(api_key_list)) as executor:
        for index, row in tqdm.tqdm(our_approach_result.iterrows(), total=our_approach_result.shape[0]):
            if row['runtime_error_refinement_prompt'] == 'no runtime error thus no refinement needed':
                continue  # Skip unnecessary processing

            api_key = api_key_list[index % len(api_key_list)]  # 轮换 API Key
            futures.append(executor.submit(process_refinement_row, index, row, api_key))  # 提交任务

        for future in tqdm.tqdm(as_completed(futures), total=len(futures)):
            index, test_code_after_runtime_error_refinement, test_code_after_runtime_error_after_formatting = future.result()
            our_approach_result.at[index, 'test_code_after_runtime_error_refinement'] = test_code_after_runtime_error_refinement
            our_approach_result.at[index, 'test_code_after_runtime_error_after_formatting'] = test_code_after_runtime_error_after_formatting

            current_num += 1
            if current_num % batch_size == 0:
                our_approach_result.to_csv(RQ1_our_approach_after_runtime_error_fixed_path, index=False)
                print(f"[INFO] Saved {current_num} rows to {RQ1_our_approach_after_runtime_error_fixed_path}")


    # Final save
    our_approach_result.to_csv(RQ1_our_approach_after_runtime_error_fixed_path, index=False)
    print(f"[INFO] Saved all rows to {RQ1_our_approach_after_runtime_error_fixed_path}")

def write_all_formatted_code_to_test_dir(our_approach_result_after_refinement_path):
    our_approach_result_after_refinement = pd.read_csv(our_approach_result_after_refinement_path)

    all_project_dirs = list(set(our_approach_result_after_refinement['project_dir'].tolist()))
    empty_test_dir(all_project_dirs)
    for index, row in tqdm.tqdm(our_approach_result_after_refinement.iterrows(),
                                total=our_approach_result_after_refinement.shape[0]):
        saved_path = row['saved_path']
        test_code_after_refinement_after_formatting = row['test_code_after_runtime_error_after_formatting']
        if saved_path == 'error' or test_code_after_refinement_after_formatting == 'error' or test_code_after_refinement_after_formatting == 'syntax error' or pd.isna(test_code_after_refinement_after_formatting):
            continue

        # if saved path's directory does not exist, create it
        saved_dir = os.path.dirname(saved_path)
        if not os.path.exists(saved_dir):
            os.makedirs(saved_dir)

        f = open(saved_path, 'w')
        f.write(test_code_after_refinement_after_formatting)
        f.close()

if __name__ == '__main__':


    RQ1_our_approach_results_path = 'our_approach_gpt4omini_results/RQ1_our_approach_results_without_syntax_error.csv'
    RQ1_our_approach_after_runtime_error_fixed_path = 'our_approach_gpt4omini_results/RQ1_our_approach_results_after_runtime_error_fixed.csv'


    syntax_error_messages_dir = Config.our_project_dir + '/ProjectInfoExtraction/saved_data/syntax_error_results'

    for package_name, test_dir in tqdm.tqdm(Config.package_name_to_test_dir.items()):
        project_name = package_name.replace('.', '_')

        jacoco_results_path = Config.our_project_dir + '/experiment_results/Effectiveness/jacoco_results/JUnitGenie_GPT4oMini/' + project_name.replace('.', '_') + '_jacoco.csv'
        mvn_test_log_path = test_dir.replace('src/test/java', 'mvn-test.log')
        filesWithSyntaxErrorCsv = Config.package_name_to_syntax_error_path[package_name]

        obtain_error_message_csv(RQ1_our_approach_results_path, jacoco_results_path, project_name, filesWithSyntaxErrorCsv)
    get_test_code_after_refinement(RQ1_our_approach_results_path, RQ1_our_approach_after_runtime_error_fixed_path, syntax_error_messages_dir)


    write_all_formatted_code_to_test_dir(RQ1_our_approach_after_runtime_error_fixed_path)