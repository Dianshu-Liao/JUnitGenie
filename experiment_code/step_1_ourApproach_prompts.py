import pandas as pd
from concurrent.futures import ThreadPoolExecutor, as_completed
from neo4jcommands import Neo4jCommands
from pipelines.context_knowledge_distillation import construct_prompt_for_a_cfg_path
from llm_utils import LLM_Utils
from config import Config
import tqdm
import os


def initiate_csv_file(file_path, all_method_FENs, sampled_dataset):
    """Initialise the CSV file, populating it with all the required rows of data"""
    dict_result = {
        'project_dir': [], 'method_FEN': [], 'cfg_path_no': [],
        'test_gen_prompt': [], 'test_code': []
    }

    for method_FEN in tqdm.tqdm(all_method_FENs):
        project_dir = sampled_dataset[sampled_dataset['method_FEN'] == method_FEN]['project_dir'].values[0]
        all_cfg_paths_num = len(Neo4jCommands.find_post_entities_in_relation(method_FEN, relation='Has_CFG_Path'))
        for cfg_path_no in range(1, all_cfg_paths_num + 1):
            dict_result['project_dir'].append(project_dir)
            dict_result['method_FEN'].append(method_FEN)
            dict_result['cfg_path_no'].append(cfg_path_no)
            dict_result['test_gen_prompt'].append('')
            dict_result['test_code'].append('')

    result_df = pd.DataFrame(dict_result)
    result_df.to_csv(file_path, index=False)


def process_row(index, row, api_key):
    """Processes individual test cases with the specified API Key and handles exceptions"""
    method_FEN = row['method_FEN']
    cfg_path_no = row['cfg_path_no']

    try:
        # Generate test-generated prompts
        test_gen_prompt = construct_prompt_for_a_cfg_path(method_FEN, cfg_path_no, api_key)

        # Trigger GPT API to get test code
        test_code = LLM_Utils.trigger_GPT_API_basedon_http_request(
            test_gen_prompt, model=Config.foundation_model_gpt4o_mini, openai_key=api_key
        )
    except Exception as e:
        print(f"[ERROR] Failed to generate test for {method_FEN} - {cfg_path_no}: {e}")
        return index, 'error', "error"  # prompt is probably correct, but test_code is wrong.

    return index, test_gen_prompt, test_code  # Normal return data


# input a list of projects, and generate test code for all these projects.



if __name__ == '__main__':
    our_approach_result_path = 'our_approach_gpt4omini_results/RQ1_our_approach_results.csv'

    # project_list = ['com_fasterxml_jackson_core', 'org_apache_commons_codec', 'org_apache_commons_csv', 'com_fasterxml_jackson_databind', 'org_joda_time']
    # project_list = ['org_joda_time', 'org_apache_commons_codec']
    # project_list = ['org_apache_commons_jxpath']




    sampled_dataset_path = Config.sampled_dataset_path_for_all_projects
    sampled_dataset = pd.read_csv(sampled_dataset_path)

    # find the rows that the 'project_dir' column contains 'com.fasterxml.jackson.core'. This should be removed in the final version!!!!!!!!!!
    # sampled_dataset = sampled_dataset[sampled_dataset['project_dir'].str.contains('com_fasterxml_jackson_core')]
    # find the rows that the 'project_dir' column contains one of the projects in the project_list
    # sampled_dataset = sampled_dataset[sampled_dataset['project_dir'].isin(project_list)]

    all_method_FENs = sampled_dataset['method_FEN'].tolist()

    if not os.path.exists(our_approach_result_path):
        initiate_csv_file(our_approach_result_path, all_method_FENs, sampled_dataset)

    result_df = pd.read_csv(our_approach_result_path)

    batch_size = 200
    current_num = 0
    api_key_list = Config.api_key_list  # Assuming Config.api_key_list contains multiple available OpenAI API Keys
    futures = []

    with ThreadPoolExecutor(max_workers=len(api_key_list)) as executor:
        for index, row in tqdm.tqdm(result_df.iterrows(), total=result_df.shape[0]):
            # Skip lines that have been successfully processed
            if (pd.notna(row['test_gen_prompt'])) and (row['test_gen_prompt'] != 'error'):
                continue

            api_key = api_key_list[index % len(api_key_list)]  # Rotation API Key
            futures.append(executor.submit(process_row, index, row, api_key))  # Submission of missions

        for future in tqdm.tqdm(as_completed(futures), total=len(futures)):
            index, test_gen_prompt, test_code = future.result()
            result_df.loc[index, 'test_gen_prompt'] = str(test_gen_prompt)
            result_df.loc[index, 'test_code'] = test_code

            current_num += 1
            if current_num % batch_size == 0:
                result_df.to_csv(our_approach_result_path, index=False)  # Regular data retention
                print(f"[INFO] Saved {current_num} rows to {our_approach_result_path}")

    result_df.to_csv(our_approach_result_path, index=False)  # Save final data after task completion
    print(f"[INFO] Saved all rows to {our_approach_result_path}")
