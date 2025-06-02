import os.path

from config import Config
from evaluation_metrics_calculation.calculate_coverages import calculate_coverages_based_on_jacoco_results


def get_basic_prompting_for_different_foundation_models():
    print('Calculating coverages for Basic GPT4oMini')
    JUnitGenie_without_CKD_CKE_TCR_jacoco_result_dir = Config.our_project_dir + '/experiment_results/Model_Generality/jacoco_results/BasicPrompt_CodeLlama/'
    calculate_coverages_based_on_jacoco_results(JUnitGenie_without_CKD_CKE_TCR_jacoco_result_dir)
    print('==========================================================')

    print('Calculating coverages for Basic CodeLlama')
    JUnitGenie_without_CKD_CKE_jacoco_result_dir = Config.our_project_dir + '/experiment_results/Model_Generality/jacoco_results/BasicPrompt_CodeLlama/'
    calculate_coverages_based_on_jacoco_results(JUnitGenie_without_CKD_CKE_jacoco_result_dir)
    print('==========================================================')

    print('Calculating coverages for Basic DeepSeek_Coder')
    JUnitGenie_without_CKD_jacoco_result_dir = Config.our_project_dir + '/experiment_results/Model_Generality/jacoco_results/BasicPrompt_DeepSeek_Coder/'
    calculate_coverages_based_on_jacoco_results(JUnitGenie_without_CKD_jacoco_result_dir)
    print('==========================================================')

    print('Calculating coverages for Basic Qwen2_5')
    JUnitGenie_GPT4oMini_jacoco_result_dir = Config.our_project_dir + '/experiment_results/Model_Generality/jacoco_results/BasicPrompt_Qwen2_5/'
    calculate_coverages_based_on_jacoco_results(JUnitGenie_GPT4oMini_jacoco_result_dir)
    print('==========================================================')



def get_JUnitGenie_for_different_foundation_models():
    print('Calculating coverages for JUnitGenie GPT4oMini')
    JUnitGenie_GPT4oMini_jacoco_result_dir = Config.our_project_dir + '/experiment_results/Effectiveness/jacoco_results/JUnitGenie_GPT4oMini/'
    calculate_coverages_based_on_jacoco_results(JUnitGenie_GPT4oMini_jacoco_result_dir)
    print('==========================================================')

    print('Calculating coverages for JUnitGenie CodeLlama')
    JUnitGenie_CodeLlama_jacoco_result_dir = Config.our_project_dir + '/experiment_results/Model_Generality/jacoco_results/CodeLlama/'
    calculate_coverages_based_on_jacoco_results(JUnitGenie_CodeLlama_jacoco_result_dir)
    print('==========================================================')


    print('Calculating coverages for JUnitGenie DeepSeek_Coder')
    JUnitGenie_DeepSeek_Coder_jacoco_result_dir = Config.our_project_dir + '/experiment_results/Model_Generality/jacoco_results/DeepSeek_Coder/'
    calculate_coverages_based_on_jacoco_results(JUnitGenie_DeepSeek_Coder_jacoco_result_dir)
    print('==========================================================')



    print('Calculating coverages for JUnitGenie Qwen2_5')
    JUnitGenie_Qwen2_5_jacoco_result_dir = Config.our_project_dir + '/experiment_results/Model_Generality/jacoco_results/Qwen2_5/'
    calculate_coverages_based_on_jacoco_results(JUnitGenie_Qwen2_5_jacoco_result_dir)
    print('==========================================================')



if __name__ == '__main__':

    print('==================Getting basic prompting for different foundation models=====================')
    get_basic_prompting_for_different_foundation_models()

    print('==================Getting JUnitGenie for different foundation models=====================')
    get_JUnitGenie_for_different_foundation_models()
