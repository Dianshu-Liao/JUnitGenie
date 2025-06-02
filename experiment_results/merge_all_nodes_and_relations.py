import pandas as pd

from config import Config
from utils import Util

if __name__ == '__main__':

    all_project_info_dir = Config.our_project_dir + '/saved_data/experiment_results/all_projects_info'


    entities_dir = all_project_info_dir +  '/' + 'Entities'
    relations_dir = all_project_info_dir + '/' + 'Relations'


    field_entities_path = entities_dir + '/field_entities.csv'
    enum_constant_entities_path = entities_dir + '/enum_constant_entities.csv'
    method_entities_path = entities_dir + '/method_level_entities.csv'
    cfg_path_entities_path = entities_dir + '/cfg_path_entities.csv'
    class_level_entities_path = entities_dir + '/class_level_entities.csv'
    parameter_level_entities_path = entities_dir + '/parameter_level_entities.csv'

    uses_field_relations_path = relations_dir + '/uses_field.csv'
    uses_method_relations_path = relations_dir + '/uses_method.csv'
    uses_enum_constant_relations_path = relations_dir + '/uses_enum_constant.csv'
    has_cfg_path_relations_path = relations_dir + '/has_cfg_path.csv'
    has_enum_constant_relations_path = relations_dir + '/has_enum_constant_relations.csv'
    has_field_relations_path = relations_dir + '/has_field_relations.csv'
    has_method_relations_path = relations_dir + '/has_method_relations.csv'
    has_parameter_relations_path = relations_dir + '/has_parameter_relations.csv'
    # extends_relations_path = relations_dir + '/extends.csv'
    # implements_relations_path = relations_dir + '/implements.csv'


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

    all_field_entities = []
    all_enum_constant_entities = []
    all_method_entities = []
    all_cfg_path_entities = []
    all_class_level_entities = []
    all_parameter_level_entities = []


    all_uses_field_relations = []
    all_uses_method_relations = []
    all_uses_enum_constant_relations = []
    all_has_cfg_path_relations = []
    all_has_enum_constant_relations = []
    all_has_field_relations = []
    all_has_method_relations = []
    all_has_parameter_relations = []
    # all_extends_relations = []
    # all_implements_relations = []


    for project in project_list:
        field_entities = pd.read_csv(Config.experiment_Result_Basic_Dir + '/Code_Knowledge_Base/' + project + '/Entities' + '/field_entities.csv')
        enum_constant_entities = pd.read_csv(Config.experiment_Result_Basic_Dir + '/Code_Knowledge_Base/' + project + '/Entities' + '/enum_constant_entities.csv')
        method_entities = pd.read_csv(Config.experiment_Result_Basic_Dir + '/Code_Knowledge_Base/' + project + '/Entities' + '/method_level_entities.csv')
        cfg_path_entities = pd.read_csv(Config.experiment_Result_Basic_Dir + '/Code_Knowledge_Base/' + project + '/Entities' + '/cfg_path_entities.csv')
        class_level_entities = pd.read_csv(Config.experiment_Result_Basic_Dir + '/Code_Knowledge_Base/' + project + '/Entities' + '/class_level_entities.csv')
        parameter_level_entities = pd.read_csv(Config.experiment_Result_Basic_Dir + '/Code_Knowledge_Base/' + project + '/Entities' + '/parameter_level_entities.csv')

        uses_field_relations = pd.read_csv(Config.experiment_Result_Basic_Dir + '/Code_Knowledge_Base/' + project + '/Relations' + '/uses_field.csv')
        uses_method_relations = pd.read_csv(Config.experiment_Result_Basic_Dir + '/Code_Knowledge_Base/' + project + '/Relations' + '/uses_method.csv')
        uses_enum_constant_relations = pd.read_csv(Config.experiment_Result_Basic_Dir + '/Code_Knowledge_Base/' + project + '/Relations' + '/uses_enum_constant.csv')
        has_cfg_path_relations = pd.read_csv(Config.experiment_Result_Basic_Dir + '/Code_Knowledge_Base/' + project + '/Relations' + '/has_cfg_path.csv')
        has_enum_constant_relations = pd.read_csv(Config.experiment_Result_Basic_Dir + '/Code_Knowledge_Base/' + project + '/Relations' + '/has_enum_constant_relations.csv')
        has_field_relations = pd.read_csv(Config.experiment_Result_Basic_Dir + '/Code_Knowledge_Base/' + project + '/Relations' + '/has_field_relations.csv')
        has_method_relations = pd.read_csv(Config.experiment_Result_Basic_Dir + '/Code_Knowledge_Base/' + project + '/Relations' + '/has_method_relations.csv')
        has_parameter_relations = pd.read_csv(Config.experiment_Result_Basic_Dir + '/Code_Knowledge_Base/' + project + '/Relations' + '/has_parameter_relations.csv')
        # extends_relations = pd.read_csv(Config.experiment_Result_Basic_Dir + '/' + project + '/Relations' + '/extends.csv')
        # implements_relations = pd.read_csv(Config.experiment_Result_Basic_Dir + '/' + project + '/Relations' + '/implements.csv')


        all_field_entities.append(field_entities)
        all_enum_constant_entities.append(enum_constant_entities)
        all_method_entities.append(method_entities)
        all_cfg_path_entities.append(cfg_path_entities)
        all_class_level_entities.append(class_level_entities)
        all_parameter_level_entities.append(parameter_level_entities)


        all_uses_field_relations.append(uses_field_relations)
        all_uses_method_relations.append(uses_method_relations)
        all_uses_enum_constant_relations.append(uses_enum_constant_relations)
        all_has_cfg_path_relations.append(has_cfg_path_relations)
        all_has_enum_constant_relations.append(has_enum_constant_relations)
        all_has_field_relations.append(has_field_relations)
        all_has_method_relations.append(has_method_relations)
        all_has_parameter_relations.append(has_parameter_relations)
        # all_extends_relations.append(extends_relations)
        # all_implements_relations.append(implements_relations)


    all_field_entities = pd.concat(all_field_entities)
    all_enum_constant_entities = pd.concat(all_enum_constant_entities)
    all_method_entities = pd.concat(all_method_entities)
    all_cfg_path_entities = pd.concat(all_cfg_path_entities)
    all_class_level_entities = pd.concat(all_class_level_entities)
    all_parameter_level_entities = pd.concat(all_parameter_level_entities)


    all_uses_field_relations = pd.concat(all_uses_field_relations)
    all_uses_method_relations = pd.concat(all_uses_method_relations)
    all_uses_enum_constant_relations = pd.concat(all_uses_enum_constant_relations)
    all_has_cfg_path_relations = pd.concat(all_has_cfg_path_relations)
    all_has_enum_constant_relations = pd.concat(all_has_enum_constant_relations)
    all_has_field_relations = pd.concat(all_has_field_relations)
    all_has_method_relations = pd.concat(all_has_method_relations)
    all_has_parameter_relations = pd.concat(all_has_parameter_relations)
    # all_extends_relations = pd.concat(all_extends_relations)
    # all_implements_relations = pd.concat(all_implements_relations)



    all_field_entities.to_csv(field_entities_path, index=False)
    all_enum_constant_entities.to_csv(enum_constant_entities_path, index=False)
    all_method_entities.to_csv(method_entities_path, index=False)
    all_cfg_path_entities.to_csv(cfg_path_entities_path, index=False)
    all_class_level_entities.to_csv(class_level_entities_path, index=False)
    all_parameter_level_entities.to_csv(parameter_level_entities_path, index=False)


    all_uses_field_relations.to_csv(uses_field_relations_path, index=False)
    all_uses_method_relations.to_csv(uses_method_relations_path, index=False)
    all_uses_enum_constant_relations.to_csv(uses_enum_constant_relations_path, index=False)
    all_has_cfg_path_relations.to_csv(has_cfg_path_relations_path, index=False)
    all_has_enum_constant_relations.to_csv(has_enum_constant_relations_path, index=False)
    all_has_field_relations.to_csv(has_field_relations_path, index=False)
    all_has_method_relations.to_csv(has_method_relations_path, index=False)
    all_has_parameter_relations.to_csv(has_parameter_relations_path, index=False)
    # all_extends_relations.to_csv(extends_relations_path, index=False)
    # all_implements_relations.to_csv(implements_relations_path, index=False)


    print('All entities and relations are merged successfully!')

    # cp the entities and relations to neo4j import directory
    command_statement = ''
    command_statement += 'sudo rm -rf /opt/homebrew/var/neo4j/data/databases/neo4j'
    command_statement += '\n'
    command_statement += 'sudo cp {}/*.csv /opt/homebrew/Cellar/neo4j/2025.01.0/libexec/import/'.format(entities_dir)

    command_statement += '\n'
    command_statement += 'sudo cp {}/*.csv /opt/homebrew/Cellar/neo4j/2025.01.0/libexec/import/'.format(relations_dir)

    command_statement += '\n'

    command_statement += '''neo4j-admin database import full \
      --overwrite-destination=true \
      --nodes=/opt/homebrew/Cellar/neo4j/2025.01.0/libexec/import/class_level_entities.csv \
      --nodes=/opt/homebrew/Cellar/neo4j/2025.01.0/libexec/import/field_entities.csv \
      --nodes=/opt/homebrew/Cellar/neo4j/2025.01.0/libexec/import/enum_constant_entities.csv \
      --nodes=/opt/homebrew/Cellar/neo4j/2025.01.0/libexec/import/method_level_entities.csv \
      --nodes=/opt/homebrew/Cellar/neo4j/2025.01.0/libexec/import/parameter_level_entities.csv \
      --nodes=/opt/homebrew/Cellar/neo4j/2025.01.0/libexec/import/cfg_path_entities.csv \
      --relationships=/opt/homebrew/Cellar/neo4j/2025.01.0/libexec/import/has_parameter_relations.csv \
      --relationships=/opt/homebrew/Cellar/neo4j/2025.01.0/libexec/import/has_field_relations.csv \
      --relationships=/opt/homebrew/Cellar/neo4j/2025.01.0/libexec/import/has_method_relations.csv \
      --relationships=/opt/homebrew/Cellar/neo4j/2025.01.0/libexec/import/has_cfg_path.csv \
      --relationships=/opt/homebrew/Cellar/neo4j/2025.01.0/libexec/import/has_enum_constant_relations.csv \
      --relationships=/opt/homebrew/Cellar/neo4j/2025.01.0/libexec/import/uses_field.csv \
      --relationships=/opt/homebrew/Cellar/neo4j/2025.01.0/libexec/import/uses_enum_constant.csv \
      --relationships=/opt/homebrew/Cellar/neo4j/2025.01.0/libexec/import/uses_method.csv \
      --verbose \
      neo4j'''

    # command_statement += '''neo4j-admin database import full \
    #   --overwrite-destination=true \
    #   --nodes=/opt/homebrew/Cellar/neo4j/2025.01.0/libexec/import/class_level_entities.csv \
    #   --verbose \
    #   neo4j'''

    neo4j_import_command_file_path = all_project_info_dir + '/' + '/neo4j_import_command.txt'
    Util.write_content_to_file(neo4j_import_command_file_path, command_statement)