import pandas as pd
from neo4jcommands import Neo4jCommands
import tqdm
from config import Config
import math



def method_contains_global_context(method_FEN):
    all_method_cfg_paths = Neo4jCommands.find_post_entities_in_relation(method_FEN, relation='Has_CFG_Path')
    for method_cfg_path in all_method_cfg_paths:
        method_cfg_path = method_cfg_path['n']
        method_cfg_path_FEN = method_cfg_path['FEN']

        global_methods = Neo4jCommands.find_post_entities_in_relation(method_cfg_path_FEN, relation='Uses_Method')
        global_fields = Neo4jCommands.find_post_entities_in_relation(method_cfg_path_FEN, relation='Uses_Field')
        global_enum_constants = Neo4jCommands.find_post_entities_in_relation(method_cfg_path_FEN, relation='Uses_Enum_Constant')

        if len(global_methods) > 0 or len(global_fields) > 0 or len(global_enum_constants) > 0:
            return True

    return False

if __name__ == '__main__':


    dict_dataset_result = {'method_FEN': [], 'all_cfg_paths_num': []}
    method_entities = Neo4jCommands.get_entities_by_label('Method')
    constructor_methods = Neo4jCommands.get_entities_by_label('Constructor')
    all_methods = method_entities + constructor_methods
    for method_entity in tqdm.tqdm(all_methods):
        method_entity = method_entity['n']
        method_FEN = method_entity['FEN']
        if '$' in method_FEN:
            continue

        all_cfg_paths_num = len(Neo4jCommands.find_post_entities_in_relation(method_FEN, relation='Has_CFG_Path'))

        if all_cfg_paths_num > 1:
            if method_contains_global_context(method_FEN):

                dict_dataset_result['method_FEN'].append(method_FEN)
                dict_dataset_result['all_cfg_paths_num'].append(all_cfg_paths_num)

    result_df = pd.DataFrame(dict_dataset_result)
    result_df.to_csv(Config.dataset_path, index=False)

