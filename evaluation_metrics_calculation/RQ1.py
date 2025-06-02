import os.path

from config import Config
from evaluation_metrics_calculation.calculate_coverages import calculate_coverages_based_on_jacoco_results


def get_all_baselines_coverages():
    print('Calculating coverages for Randoop baseline...')
    Randoop_jacoco_result_dir = Config.our_project_dir + '/experiment_results/Effectiveness/jacoco_results/Randoop/'
    calculate_coverages_based_on_jacoco_results(Randoop_jacoco_result_dir)
    print('==========================================================')
    print('Calculating coverages for EvoSuite baseline...')
    EvoSuite_jacoco_result_dir = Config.our_project_dir + '/experiment_results/Effectiveness/jacoco_results/EvoSuite/'
    calculate_coverages_based_on_jacoco_results(EvoSuite_jacoco_result_dir)
    print('==========================================================')


    print('Calculating coverages for ChatTester_GPT4oMini baseline...')
    ChatTester_GPT4oMini_jacoco_result_dir = Config.our_project_dir + '/experiment_results/Effectiveness/jacoco_results/ChatTester_GPT4oMini/'
    calculate_coverages_based_on_jacoco_results(ChatTester_GPT4oMini_jacoco_result_dir)
    print('==========================================================')


    print('Calculating coverages for CoverUp baseline...')
    CoverUp_jacoco_result_dir = Config.our_project_dir + '/experiment_results/Effectiveness/jacoco_results/CoverUp_GPT4oMini/'
    calculate_coverages_based_on_jacoco_results(CoverUp_jacoco_result_dir)
    print('==========================================================')

    print('Calculating coverages for HITs baseline...')
    HITs_jacoco_result_dir = Config.our_project_dir + '/experiment_results/Effectiveness/jacoco_results/HITs_GPT4oMini/'
    calculate_coverages_based_on_jacoco_results(HITs_jacoco_result_dir)
    print('==========================================================')


    print('Calculating coverages for JUnitGenie_GPT4oMini baseline...')
    JUnitGenie_GPT4oMini_jacoco_result_dir = Config.our_project_dir + '/experiment_results/Effectiveness/jacoco_results/JUnitGenie_GPT4oMini/'
    calculate_coverages_based_on_jacoco_results(JUnitGenie_GPT4oMini_jacoco_result_dir)
    print('==========================================================')

if __name__ == '__main__':

    get_all_baselines_coverages()

