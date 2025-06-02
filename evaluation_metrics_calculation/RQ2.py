import os.path

from config import Config
from evaluation_metrics_calculation.calculate_coverages import calculate_coverages_based_on_jacoco_results


def get_all_ablations_coverages():
    print('Calculating coverages for JUnitGenie_without_CKD_CKE_TCR')
    JUnitGenie_without_CKD_CKE_TCR_jacoco_result_dir = Config.our_project_dir + '/experiment_results/Knowledge_Engineering/jacoco_results/JUnitGenie_without_CKD_CKE_TCR/'
    calculate_coverages_based_on_jacoco_results(JUnitGenie_without_CKD_CKE_TCR_jacoco_result_dir)
    print('==========================================================')



    print('Calculating coverages for JUnitGenie_without_CKD_CKE')
    JUnitGenie_without_CKD_CKE_jacoco_result_dir = Config.our_project_dir + '/experiment_results/Knowledge_Engineering/jacoco_results/JUnitGenie_without_CKD_CKE/'
    calculate_coverages_based_on_jacoco_results(JUnitGenie_without_CKD_CKE_jacoco_result_dir)
    print('==========================================================')



    print('Calculating coverages for JUnitGenie_without_CKD')
    JUnitGenie_without_CKD_jacoco_result_dir = Config.our_project_dir + '/experiment_results/Knowledge_Engineering/jacoco_results/JUnitGenie_without_CKD/'
    calculate_coverages_based_on_jacoco_results(JUnitGenie_without_CKD_jacoco_result_dir)
    print('==========================================================')


    print('Calculating coverages for JUnitGenie')
    JUnitGenie_GPT4oMini_jacoco_result_dir = Config.our_project_dir + '/experiment_results/Effectiveness/jacoco_results/JUnitGenie_GPT4oMini/'
    calculate_coverages_based_on_jacoco_results(JUnitGenie_GPT4oMini_jacoco_result_dir)
    print('==========================================================')

if __name__ == '__main__':

    get_all_ablations_coverages()

