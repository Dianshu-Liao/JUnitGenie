import pandas as pd
from utils import Util
from config import Config
from llm_utils import LLM_Utils
import tqdm
from pipelines.code_formatting import get_runnable_code_from_test_code
from concurrent.futures import ThreadPoolExecutor, as_completed
from pipelines.code_formatting import get_runnable_code_from_test_code, empty_test_dir
import os
import re

def remove_inline_warnings(log_text):
    # 1. remove the entire fragment beginning with warning: and the subsequent | with the regular
    cleaned = re.sub(r'warning:.*?(?=\|)', '', log_text)

    # 2. Remove warning fragments that may be at the end (if not |)
    cleaned = re.sub(r'\|?\s*warning:.*$', '', cleaned)

    # 3. 清理多余的 |（多个连续 | 或 | 开头结尾）
    cleaned = re.sub(r'\s*\|\s*', ' | ', cleaned)
    cleaned = re.sub(r'(\|\s*){2,}', '| ', cleaned)
    cleaned = re.sub(r'^\s*\|\s*', '', cleaned)
    cleaned = re.sub(r'\s*\|\s*$', '', cleaned)

    return cleaned.strip()

def construct_code_refinement_prompt(error_message, test_code):
    error_message = remove_inline_warnings(error_message).replace(' | ', '\n')
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

def get_code_refinement_prompts_for_our_approach(our_approach_result_after_formatting_path, syntax_error_messages_dir):
    all_csv_files = Util.find_files(syntax_error_messages_dir, endswith='.csv')

    # concatenate all csv files
    all_syntax_error_messages = pd.concat([pd.read_csv(file) for file in all_csv_files])
    all_filenames = all_syntax_error_messages['file_name'].tolist()

    our_approach_result = pd.read_csv(our_approach_result_after_formatting_path)
    our_approach_result['syntax_error_message'] = ''
    our_approach_result['first_refinement_prompt'] = ''


    for index, row in tqdm.tqdm(our_approach_result.iterrows(), total=our_approach_result.shape[0]):
        test_code_after_formatting = row['test_code_after_formatting']
        saved_path = row['saved_path']
        # file_name = saved_path.split('/')[-1]
        if saved_path in all_filenames:
        # if saved_path in all_filenames:
        #     corresponding_row = all_syntax_error_messages[all_syntax_error_messages['file_name'] == saved_path]
            corresponding_row = all_syntax_error_messages[all_syntax_error_messages['file_name'] == saved_path]


            if corresponding_row.empty:
                raise Exception(f"Cannot find corresponding row for {saved_path}")

            error_message = corresponding_row['syntax_error_message'].values[0]
            if pd.isna(error_message):
                our_approach_result.loc[index, 'syntax_error_message'] = 'no syntax error thus no refinement needed'
                our_approach_result.loc[index, 'first_refinement_prompt'] = 'no syntax error thus no refinement needed'
                continue

            first_refinement_prompt = construct_code_refinement_prompt(error_message, test_code_after_formatting)
            our_approach_result.loc[index, 'syntax_error_message'] = error_message.replace('\n', '\\n')
            our_approach_result.loc[index, 'first_refinement_prompt'] = str(first_refinement_prompt)
        else:
            our_approach_result.loc[index, 'syntax_error_message'] = 'no syntax error thus no refinement needed'
            our_approach_result.loc[index, 'first_refinement_prompt'] = 'no syntax error thus no refinement needed'

    return our_approach_result

def process_refinement_row(index, row, api_key):
    """Process a single row for test code refinement."""
    project_dir = row['project_dir']
    method_FEN = row['method_FEN']
    cfg_path_no = row['cfg_path_no']
    first_refinement_prompt = eval(row['first_refinement_prompt'])

    # if first_refinement_prompt == 'no syntax error thus no refinement needed':
    #     return index, 'no refinement needed', 'no refinement needed'

    try:
        test_code_after_first_refinement = LLM_Utils.trigger_GPT_API_basedon_http_request(
            first_refinement_prompt, model=Config.foundation_model_gpt4o_mini, openai_key=api_key
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
        test_code_after_first_refinement_after_formatting = get_runnable_code_from_test_code(
            test_code_after_first_refinement, package_import_name, class_name
        )

        return index, test_code_after_first_refinement, test_code_after_first_refinement_after_formatting

    except Exception as e:
        print(f"[ERROR] Refinement failed for {method_FEN} - {cfg_path_no}: {e}")
        return index, 'error', 'error'


# please note that this function is the final version to get the test code after refinement for all ten projects
def get_test_code_after_refinement(our_approach_result_after_formatting_path, syntax_error_messages_dir,
                                   our_approach_result_after_first_round_refinement_path):
    """Parallel processing for refining test code."""
    our_approach_result = get_code_refinement_prompts_for_our_approach(
        our_approach_result_after_formatting_path, syntax_error_messages_dir
    )
    our_approach_result['test_code_after_first_refinement'] = ''
    our_approach_result['test_code_after_first_refinement_after_formatting'] = ''

    batch_size = 200
    current_num = 0
    futures = []
    api_key_list = Config.api_key_list  # 假设 Config.api_key_list 包含多个可用的 OpenAI API Keys

    for index, row in tqdm.tqdm(our_approach_result.iterrows(), total=our_approach_result.shape[0]):

        if row['first_refinement_prompt'] == 'no syntax error thus no refinement needed':
            test_code_after_formatting = row['test_code_after_formatting']
            our_approach_result.at[index, 'test_code_after_first_refinement'] = test_code_after_formatting
            our_approach_result.at[index, 'test_code_after_first_refinement_after_formatting'] = test_code_after_formatting


    with ThreadPoolExecutor(max_workers=len(api_key_list)) as executor:
        for index, row in tqdm.tqdm(our_approach_result.iterrows(), total=our_approach_result.shape[0]):
            if row['first_refinement_prompt'] == 'no syntax error thus no refinement needed':
                continue  # Skip unnecessary processing

            api_key = api_key_list[index % len(api_key_list)]
            futures.append(executor.submit(process_refinement_row, index, row, api_key))

        for future in tqdm.tqdm(as_completed(futures), total=len(futures)):
            index, test_code_after_first_refinement, test_code_after_first_refinement_after_formatting = future.result()
            our_approach_result.at[index, 'test_code_after_first_refinement'] = test_code_after_first_refinement
            our_approach_result.at[index, 'test_code_after_first_refinement_after_formatting'] = test_code_after_first_refinement_after_formatting

            current_num += 1
            if current_num % batch_size == 0:
                our_approach_result.to_csv(our_approach_result_after_first_round_refinement_path, index=False)
                print(f"[INFO] Saved {current_num} rows to {our_approach_result_after_first_round_refinement_path}")


    # Final save
    our_approach_result.to_csv(our_approach_result_after_first_round_refinement_path, index=False)
    print(f"[INFO] Saved all rows to {our_approach_result_after_first_round_refinement_path}")


# please note that this function is only for the project "com_fasterxml_jackson_core" and "org_apache_commons_codec", this function should be removed after the final version
def get_test_code_after_refinement_for_jacksonCore_and_CodeC(our_approach_result_after_formatting_path, syntax_error_messages_dir,
                                   our_approach_result_after_first_round_refinement_path):


    """Parallel processing for refining test code."""
    our_approach_result = get_code_refinement_prompts_for_our_approach(
        our_approach_result_after_formatting_path, syntax_error_messages_dir
    )
    our_approach_result['test_code_after_first_refinement'] = ''
    our_approach_result['test_code_after_first_refinement_after_formatting'] = ''

    batch_size = 200
    current_num = 0
    futures = []
    api_key_list = Config.api_key_list

    # only for the project "com_fasterxml_jackson_core" and "org_apache_commons_codec"
    our_approach_result = our_approach_result[our_approach_result['project_dir'].isin(['com_fasterxml_jackson_core', 'org_apache_commons_codec'])]

    for index, row in tqdm.tqdm(our_approach_result.iterrows(), total=our_approach_result.shape[0]):

        if row['first_refinement_prompt'] == 'no syntax error thus no refinement needed':
            test_code_after_formatting = row['test_code_after_formatting']
            our_approach_result.at[index, 'test_code_after_first_refinement'] = test_code_after_formatting
            our_approach_result.at[index, 'test_code_after_first_refinement_after_formatting'] = test_code_after_formatting


    with ThreadPoolExecutor(max_workers=len(api_key_list)) as executor:
        for index, row in tqdm.tqdm(our_approach_result.iterrows(), total=our_approach_result.shape[0]):
            if row['first_refinement_prompt'] == 'no syntax error thus no refinement needed':
                continue  # Skip unnecessary processing

            api_key = api_key_list[index % len(api_key_list)]
            futures.append(executor.submit(process_refinement_row, index, row, api_key))

        for future in tqdm.tqdm(as_completed(futures), total=len(futures)):
            index, test_code_after_first_refinement, test_code_after_first_refinement_after_formatting = future.result()
            our_approach_result.at[index, 'test_code_after_first_refinement'] = test_code_after_first_refinement
            our_approach_result.at[index, 'test_code_after_first_refinement_after_formatting'] = test_code_after_first_refinement_after_formatting

            current_num += 1
            if current_num % batch_size == 0:
                our_approach_result.to_csv(our_approach_result_after_first_round_refinement_path, index=False)
                print(f"[INFO] Saved {current_num} rows to {our_approach_result_after_first_round_refinement_path}")


    # Final save
    our_approach_result.to_csv(our_approach_result_after_first_round_refinement_path, index=False)
    print(f"[INFO] Saved all rows to {our_approach_result_after_first_round_refinement_path}")


def write_all_formatted_code_to_test_dir(our_approach_result_after_first_round_refinement_path):
    our_approach_result_after_first_round_refinement = pd.read_csv(our_approach_result_after_first_round_refinement_path)

    all_project_dirs = list(set(our_approach_result_after_first_round_refinement['project_dir'].tolist()))
    empty_test_dir(all_project_dirs)
    for index, row in tqdm.tqdm(our_approach_result_after_first_round_refinement.iterrows(),
                                total=our_approach_result_after_first_round_refinement.shape[0]):
        saved_path = row['saved_path']
        test_code_after_first_refinement_after_formatting = row['test_code_after_first_refinement_after_formatting']
        if saved_path == 'error' or test_code_after_first_refinement_after_formatting == 'error':
            continue

        # if saved path's directory does not exist, create it
        saved_dir = os.path.dirname(saved_path)
        if not os.path.exists(saved_dir):
            os.makedirs(saved_dir)

        f = open(saved_path, 'w')
        f.write(test_code_after_first_refinement_after_formatting)
        f.close()


if __name__ == '__main__':
    syntax_error_messages_dir = Config.our_project_dir + '/ProjectInfoExtraction/saved_data/syntax_error_results'
    our_approach_result_after_formatting_path = 'our_approach_gpt4omini_results/RQ1_our_approach_results_after_formatting.csv'
    our_approach_result_after_first_round_refinement_path = 'our_approach_gpt4omini_results/RQ1_our_approach_results_after_first_round_refinement.csv'
    # get_test_code_after_refinement(our_approach_result_after_formatting_path, syntax_error_messages_dir, our_approach_result_after_first_round_refinement_path)


    # our_approach_result_after_formatting_path = 'our_approach_gpt4omini_results/RQ1_our_approach_results_after_formatting.csv'
    # our_approach_result_after_formatting_path = 'our_approach_gpt4omini_results/RQ1_our_approach_results_after_formatting_by_changing_the_test_dir.csv'
    # our_approach_result_after_formatting_path = 'our_approach_gpt4omini_results/RQ1_our_approach_results_after_formatting_com_fasterxml_jackson_core.csv'
    # our_approach_result_after_first_round_refinement_for_two_projects_path = 'our_approach_gpt4omini_results/RQ1_our_approach_results_after_first_round_refinement_for_two_projects.csv'
    # our_approach_result_after_first_round_refinement_for_two_projects_path = 'our_approach_gpt4omini_results/RQ1_our_approach_results_after_first_round_refinement_for_two_projects_by_changing_the_test_dir.csv'
    # our_approach_result_after_first_round_refinement_path = 'our_approach_gpt4omini_results/RQ1_our_approach_results_after_first_round_refinement_com_fasterxml_jackson_core.csv'
    # get_test_code_after_refinement_for_jacksonCore_and_CodeC(our_approach_result_after_formatting_path, syntax_error_messages_dir, our_approach_result_after_first_round_refinement_path)


    # i need to change the our_approach_result_after_first_round_refinement_for_two_projects_path to the our_approach_result_after_first_round_refinement_path later
    write_all_formatted_code_to_test_dir(our_approach_result_after_first_round_refinement_path)
