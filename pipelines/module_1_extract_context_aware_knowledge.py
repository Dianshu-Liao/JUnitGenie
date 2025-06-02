from pipelines.basic_entities_extraction import basic_entities_and_relations_extraction
from pipelines.obtain_cfg_paths import cfg_path_entities_and_relations_extraction
from pipelines.obtain_use_relevant_info_relations import uses_field_method_relations_construction
from config import Config
from utils import Util


def extract_code_aware_knowledge():
    basic_entities_and_relations_extraction()
    cfg_path_entities_and_relations_extraction()
    uses_field_method_relations_construction()

    # cp the entities and relations to neo4j import directory
    command_statement = ''
    command_statement += 'sudo rm -rf /opt/homebrew/var/neo4j/data/databases/neo4j'
    command_statement += '\n'
    command_statement += 'sudo cp {}/*.csv /opt/homebrew/Cellar/neo4j/2025.01.0/libexec/import/'.format(
        Config.entities_dir)

    command_statement += '\n'
    command_statement += 'sudo cp {}/*.csv /opt/homebrew/Cellar/neo4j/2025.01.0/libexec/import/'.format(
        Config.relations_dir)

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

    neo4j_import_command_file_path = Config.experiment_Result_Basic_Dir + '/' + Config.project_package_name.replace('.',
                                                                                                                    '_') + '/neo4j_import_command.txt'
    Util.write_content_to_file(neo4j_import_command_file_path, command_statement)

if __name__ == '__main__':


    extract_code_aware_knowledge()
