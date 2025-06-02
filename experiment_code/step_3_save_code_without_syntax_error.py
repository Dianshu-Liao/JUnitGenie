import pandas as pd
import os
import tqdm
from pipelines.code_formatting import get_runnable_code_from_test_code, empty_test_dir


def write_all_formatted_code_to_test_dir(our_approach_result_after_refinement_path):
    our_approach_result_after_refinement = pd.read_csv(our_approach_result_after_refinement_path)

    all_project_dirs = list(set(our_approach_result_after_refinement['project_dir'].tolist()))
    empty_test_dir(all_project_dirs)
    for index, row in tqdm.tqdm(our_approach_result_after_refinement.iterrows(),
                                total=our_approach_result_after_refinement.shape[0]):
        saved_path = row['saved_path']
        test_code_after_refinement_after_formatting = row['test_code_without_syntax_error']
        if saved_path == 'error' or test_code_after_refinement_after_formatting == 'error' or pd.isna(test_code_after_refinement_after_formatting) or test_code_after_refinement_after_formatting == 'syntax error':
            continue

        # if saved path's directory does not exist, create it
        saved_dir = os.path.dirname(saved_path)
        if not os.path.exists(saved_dir):
            os.makedirs(saved_dir)

        f = open(saved_path, 'w')
        f.write(test_code_after_refinement_after_formatting)
        f.close()

if __name__ == '__main__':

    # our_approach_result_after_first_round_refinement_path = 'our_approach_gpt4omini_results/RQ1_our_approach_results_after_first_round_refinement.csv'
    # our_approach_result_after_first_round_refinement_without_syntax_error_path = 'our_approach_gpt4omini_results/RQ1_our_approach_results_after_first_round_refinement_without_syntax_error.csv'
    our_approach_result_after_fifth_round_refinement_path = 'our_approach_gpt4omini_results/RQ1_our_approach_results_after_fifth_round_refinement.csv'
    # this should be changed to the our_approach_result_after_first_round_refinement_path. The our_approach_result_after_first_round_refinement_without_syntax_error_path should be changed to the our_approach_result_after_first_round_refinement_without_syntax_error_path
    # our_approach_result_after_first_round_refinement_for_two_projects_path = 'our_approach_gpt4omini_results/RQ1_our_approach_results_after_first_round_refinement_for_two_projects.csv'
    # our_approach_result_after_first_round_refinement_for_two_projects_path = 'our_approach_gpt4omini_results/RQ1_our_approach_results_after_first_round_refinement_for_two_projects_by_changing_the_test_dir.csv'
    # our_approach_result_after_first_round_refinement_path = 'our_approach_gpt4omini_results/RQ1_our_approach_results_after_first_round_refinement_com_fasterxml_jackson_core.csv'
    # our_approach_result_after_first_round_refinement_without_syntax_error_path = 'our_approach_gpt4omini_results/RQ1_our_approach_results_after_first_round_refinement_without_syntax_error_for_two_projects.csv'
    # our_approach_result_after_first_round_refinement_without_syntax_error_path = 'our_approach_gpt4omini_results/RQ1_our_approach_results_after_first_round_refinement_without_syntax_error_for_two_projects_by_changing_the_test_dir.csv'
    # our_approach_result_after_first_round_refinement_without_syntax_error_path = 'our_approach_gpt4omini_results/RQ1_our_approach_results_after_first_round_refinement_without_syntax_error_com_fasterxml_jackson_core.csv'
    our_approach_result_without_syntax_error_path = 'our_approach_gpt4omini_results/RQ1_our_approach_results_without_syntax_error.csv'


    # our_approach_result_after_fifth_round_refinement = pd.read_csv(our_approach_result_after_fifth_round_refinement_path)
    #
    # our_approach_result_after_fifth_round_refinement['test_code_without_syntax_error'] = ''
    # for index, row in tqdm.tqdm(our_approach_result_after_fifth_round_refinement.iterrows(), total=our_approach_result_after_fifth_round_refinement.shape[0]):
    #     saved_path = row['saved_path']
    #     if os.path.exists(saved_path):
    #         f = open(saved_path, 'r')
    #         test_code_after_first_refinement = f.read()
    #         f.close()
    #         our_approach_result_after_fifth_round_refinement.loc[index, 'test_code_without_syntax_error'] = test_code_after_first_refinement
    #     else:
    #         our_approach_result_after_fifth_round_refinement.loc[index, 'test_code_without_syntax_error'] = 'syntax error'
    #
    # # find the rows with "syntax error" in the column "test_code_after_first_refinement_without_syntax_error"
    # syntax_error_rows = our_approach_result_after_fifth_round_refinement[our_approach_result_after_fifth_round_refinement['test_code_without_syntax_error'] == 'syntax error']
    #
    # our_approach_result_after_fifth_round_refinement.to_csv(our_approach_result_without_syntax_error_path, index=False)

    write_all_formatted_code_to_test_dir(our_approach_result_without_syntax_error_path)