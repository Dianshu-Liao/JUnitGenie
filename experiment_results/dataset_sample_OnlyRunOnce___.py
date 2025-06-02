import pandas as pd
from config import Config
import math
from neo4jcommands import Neo4jCommands


def calculate_sample_size(population_size, confidence_level=0.95, margin_of_error=0.05, proportion=0.5):
    # Z-score for the desired confidence level
    z_score = {
        0.90: 1.645,
        0.95: 1.96,
        0.99: 2.576
    }[confidence_level]

    # Initial sample size calculation for an infinite population
    p = proportion
    e = margin_of_error
    z = z_score

    initial_sample_size = (z**2 * p * (1 - p)) / e**2

    # Adjust the sample size for a finite population
    adjusted_sample_size = initial_sample_size / (1 + (initial_sample_size - 1) / population_size)

    return math.ceil(adjusted_sample_size)

### Please note that this script should only be run once to sample the dataset!!!!!!!!
if __name__ == '__main__':


    project_list = ['com_fasterxml_jackson_core',
                    'com_fasterxml_jackson_databind',
                    'com_fasterxml_jackson_dataformat_xml',
                    'org_apache_commons_codec',
                    'org_apache_commons_collections4',
                    'org_apache_commons_compress',
                    'org_apache_commons_csv',
                    'org_apache_commons_jxpath',
                    'org_apache_commons_lang3',
                    'org_joda_time']

    all_project_dataset = []
    dataset = pd.read_csv(Config.dataset_path)
    for project in project_list:
        package_name = project.replace('_', '.')
        # project dataset is the rows that the method_FEN starts with the package name
        project_dataset = dataset[dataset['method_FEN'].str.startswith(package_name)]
        # project_dataset = dataset[dataset['project_dir'] == project]
        project_dataset_num = len(project_dataset)
        project_dataset_method_FENs = project_dataset['method_FEN'].tolist()
        class_FENs = set()

        for method_FEN in project_dataset_method_FENs:
            method_belonged_class = Neo4jCommands.find_pre_entities_in_relation(method_FEN, 'Has_Method')
            if method_belonged_class:
                class_FEN = method_belonged_class[0]['n']['FEN']
                class_FENs.add(class_FEN)
        class_FENs_num = len(class_FENs)

        sample_size = calculate_sample_size(project_dataset_num)
        print(f"Project: {project}, "
              f"Total Methods: {project_dataset_num}, "
              f"Total Classes: {class_FENs_num}, "
              f"Sample Size: {sample_size}")

        sampled_dataset = project_dataset.sample(sample_size)



        # 添加项目目录列
        sampled_dataset_with_dir = sampled_dataset.copy()
        sampled_dataset_with_dir['project_dir'] = project
        all_project_dataset.append(sampled_dataset_with_dir)

    all_project_dataset = pd.concat(all_project_dataset)
    sum_of_all_cfg_paths_num = all_project_dataset['all_cfg_paths_num'].sum()
    print(f"Sum of all cfg paths num: {sum_of_all_cfg_paths_num}")

    sampled_dataset_path_for_all_projects = Config.experiment_Result_Basic_Dir + '/Sampled_Dataset_For_All_Projects.csv'
    all_project_dataset.to_csv(sampled_dataset_path_for_all_projects, index=False)