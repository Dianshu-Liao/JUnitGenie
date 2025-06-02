import pandas as pd
import re
import tqdm
from config import Config



def simplify_method_parameters(sub_signature_or_name):
    # Extract method name and parameter part
    match = re.match(r'([\w<>]+)\((.*?)\)', sub_signature_or_name)
    if not match:
        # If the input format does not match the method signature, the original string is returned directly
        return sub_signature_or_name

    method_name = match.group(1)
    parameters = match.group(2)

    if not parameters.strip():
        # If the parameter is null (e.g. `methodName()`), return it directly
        return f"{method_name}()"

    # Split the parameter section by commas and process each parameter
    simplified_parameters = []
    for param in parameters.split(','):
        # Remove spaces and extract simple class names (the last ‘.’ after the last ‘.’)
        simple_name = param.strip().split('.')[-1]
        simple_name = simple_name.split('$')[-1]
        simplified_parameters.append(simple_name)

    # Re-splicing method names and simplified parameters
    simplified_signature = f"{method_name}({','.join(simplified_parameters)})"
    return simplified_signature


def obtain_relevant_info(field_entities, enum_constant_entities, method_entities, cfg_path, project_package_name):
    field_and_enum_constant_entities = pd.concat([field_entities, enum_constant_entities], ignore_index=True)
    relevant_fields_and_enum_constants = []
    relevant_methods = []

    node_pattern = re.compile(r'"(\d+)" \[label="(.+?)"\];')
    pattern = re.compile(
        r"(?:\$[\w\d]+ = )?" 
        r"<([\w.$]+):\s+([\w\[\].<>]+)\s+([\w<>]+(?:\(.*?\))?)>"
    )

    # Extract nodes and their content
    cfg_nodes = node_pattern.findall(cfg_path)
    for node in cfg_nodes:
        node_content = node[1]

        # Match methods or fields in the node content
        matches = pattern.findall(node_content)

        for match in matches:
            # fqn = match.group(1)  # Fully Qualified Name
            # type_or_return = match.group(2)  # Type for fields or return type for methods
            # sub_signature_or_name = match.group(3)  # Sub-signature (for methods) or field name
            class_fqn, type_or_return, sub_signature_or_name = match

            # Determine if it's a method or field
            if "(" in sub_signature_or_name and ")" in sub_signature_or_name:

                # This is a method
                if class_fqn.startswith(project_package_name):
                    # method_signature = simplify_method_parameters(sub_signature_or_name)
                    # FEN = fqn + '.' + method_signature
                    # if FEN in FEN_List:
                    #     relevant_methods.append(FEN)
                    simple_sub_signature = simplify_method_parameters(sub_signature_or_name)
                    relevant_method_FEN = f"{class_fqn}.{simple_sub_signature}"
                    corresponding_row = method_entities[method_entities['FEN:ID'] == relevant_method_FEN]



                    if len(corresponding_row) == 0:
                        pass
                    elif len(corresponding_row) == 1:
                        FEN = corresponding_row.iloc[0]['FEN:ID']
                        relevant_methods.append(FEN)
                    else:
                        raise ValueError(f"Method FEN: {relevant_method_FEN} has more than one row!")
                        # FEN = corresponding_row.iloc[0]['FEN:ID']
                        # relevant_methods.append(FEN)
                        # print('FEN: {} more than one row!'.format(FEN))
            else:
                # # This is a field
                # if fqn.startswith(project_package_name):
                #     FEN = fqn + '.' + sub_signature_or_name
                #     if FEN in FEN_List:
                #         relevant_fields.append(FEN)
                relevant_field_FEN = f"{class_fqn}.{sub_signature_or_name}"
                corresponding_row = field_and_enum_constant_entities[field_and_enum_constant_entities['FEN:ID'] == relevant_field_FEN]

                if len(corresponding_row) == 0:
                    pass
                elif len(corresponding_row) == 1:
                    FEN = corresponding_row.iloc[0]['FEN:ID']
                    relevant_fields_and_enum_constants.append(FEN)
                else:
                    raise ValueError(f"Field or Enum Constant FEN: {relevant_field_FEN} has more than one row!")
                    # FEN = corresponding_row.iloc[0]['FEN']
                    # relevant_fields.append(FEN)
                    # print('FEN: {} more than one row!'.format(FEN))

    return list(set(relevant_fields_and_enum_constants)), list(set(relevant_methods))




def uses_field_method_relations_construction():
    dict_uses_field_relations = {'FEN:START_ID': [], 'FEN:END_ID': [], ':TYPE': []}
    dict_uses_enum_constant_relations = {'FEN:START_ID': [], 'FEN:END_ID': [], ':TYPE': []}
    dict_uses_method_relations = {'FEN:START_ID': [], 'FEN:END_ID': [], ':TYPE': []}

    field_entities = pd.read_csv(Config.field_entities_path)
    enum_constant_entities = pd.read_csv(Config.enum_constant_entities_path)
    method_entities = pd.read_csv(Config.method_entities_path)
    cfg_path_entities = pd.read_csv(Config.cfg_path_entities_path)

    for index, row in tqdm.tqdm(cfg_path_entities.iterrows(), total=len(cfg_path_entities)):
        cfg_path = row['CFG_Path'].replace('\\n', '\n')
        cfg_path_FEN = row['FEN:ID']

        relevant_fields_and_enum_constants, relevant_methods = obtain_relevant_info(field_entities, enum_constant_entities, method_entities, cfg_path,
                                                                 Config.project_package_name)
        for relevant_fields_and_enum_constants_FEN in relevant_fields_and_enum_constants:
            if relevant_fields_and_enum_constants_FEN in field_entities['FEN:ID'].values:
                dict_uses_field_relations['FEN:START_ID'].append(cfg_path_FEN)
                dict_uses_field_relations['FEN:END_ID'].append(relevant_fields_and_enum_constants_FEN)
                dict_uses_field_relations[':TYPE'].append('Uses_Field')
            elif relevant_fields_and_enum_constants_FEN in enum_constant_entities['FEN:ID'].values:
                dict_uses_enum_constant_relations['FEN:START_ID'].append(cfg_path_FEN)
                dict_uses_enum_constant_relations['FEN:END_ID'].append(relevant_fields_and_enum_constants_FEN)
                dict_uses_enum_constant_relations[':TYPE'].append('Uses_Enum_Constant')

        for relevant_method_FEN in relevant_methods:
            dict_uses_method_relations['FEN:START_ID'].append(cfg_path_FEN)
            dict_uses_method_relations['FEN:END_ID'].append(relevant_method_FEN)
            dict_uses_method_relations[':TYPE'].append('Uses_Method')

    df_uses_field_relations = pd.DataFrame(dict_uses_field_relations)
    df_use_enum_constant_relations = pd.DataFrame(dict_uses_enum_constant_relations)

    df_uses_method_relations = pd.DataFrame(dict_uses_method_relations)

    df_uses_field_relations.to_csv(Config.uses_field_relations_path, index=False)
    df_use_enum_constant_relations.to_csv(Config.uses_enum_constant_relations_path, index=False)
    df_uses_method_relations.to_csv(Config.uses_method_relations_path, index=False)





if __name__ == '__main__':


    #
    # project_package_name = 'org.apache.commons.lang3'
    # field_entities_path = 'saved_data/project_information/org_apache_commons_lang3/Entities/field_entities.csv'
    # enum_constant_entities_path = 'saved_data/project_information/org_apache_commons_lang3/Entities/enum_constant_entities.csv'
    # method_entities_path = 'saved_data/project_information/org_apache_commons_lang3/Entities/method_level_entities.csv'
    # cfg_path_entities_path = 'saved_data/project_information/org_apache_commons_lang3/Entities/cfg_path_entities.csv'
    # uses_field_relations_path = 'saved_data/project_information/org_apache_commons_lang3/Relations/uses_field.csv'
    # uses_method_relations_path = 'saved_data/project_information/org_apache_commons_lang3/Relations/uses_method.csv'
    # uses_enum_constant_relations_path = 'saved_data/project_information/org_apache_commons_lang3/Relations/uses_enum_constant.csv'

    uses_field_method_relations_construction()