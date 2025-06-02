import os.path

from ortools.linear_solver import pywraplp
import pandas as pd
import re
from config import Config


def remove_redundant_rows_in_df_bytecode_based_analysis_result(df_ast_based_result, df_bytecode_based_result):
    failed_FENs = []
    all_methods_in_ast_based_result = df_ast_based_result[df_ast_based_result['Type'].isin(['Method', 'Abstract Method', 'Constructor'])]
    for index, row in all_methods_in_ast_based_result.iterrows():
        FEN = row['FEN']
        return_type = row['Return Type']
        bytecode_based_rows = df_bytecode_based_result[df_bytecode_based_result['FEN'] == FEN]
        if len(bytecode_based_rows) == 0:
            continue
        elif len(bytecode_based_rows) > 1:
            incorrect_rows = {}
            # select the correct one to keep
            for index, row in bytecode_based_rows.iterrows():
                signature = row['sub_signature']
                return_type_in_signature = signature.split(' ')[0].split('.')[-1]
                if return_type_in_signature != return_type:
                    incorrect_rows[index] = row
            if len(incorrect_rows) == 0:
                # remove all the rows
                df_bytecode_based_result = df_bytecode_based_result.drop(bytecode_based_rows.index)
                failed_FENs.append(FEN)
                # raise Exception(f'Cannot find the incorrect row for {FEN}')
            # remove the incorrect rows
            for index in incorrect_rows:
                df_bytecode_based_result = df_bytecode_based_result.drop(index)
    print(f'Failed FENs: {failed_FENs}')
    return df_bytecode_based_result



def format_FEN(df):
    for index, row in df.iterrows():
        entity_type = row['Type']
        if entity_type == 'Method' or entity_type == 'Abstract Method' or entity_type == 'Constructor' or 'Parameter' in entity_type:
            FEN = row['FEN']
            # obtain the parameters within the FEN, for example, (Parameter1,Parameter2,Parameter3)
            parameters = FEN.split('(')[1].split(')')[0]
            original_parameter_str = FEN.split('(')[1].split(')')[0]
            if parameters == '':
                continue
            elif ',' in parameters:
                parameters = parameters.split(',')
            else:
                parameters = [parameters]

            new_parameter_str = ''
            for parameter in parameters:
                if '.' in parameter:
                    parameter = parameter.split('.')[-1]
                if '$' in parameter:
                    parameter = parameter.split('$')[-1]
                new_parameter_str += parameter + ','
            new_parameter_str = new_parameter_str[:-1]
            new_FEN = FEN.replace(original_parameter_str, new_parameter_str)
            df.at[index, 'FEN'] = new_FEN

    return df

def remove_same_rows_in_df_ast_based_analysis_result(df_ast_based_result, df_bytecode_based_result):

    # remove the rows that the FEN is "UnknownClass"
    df_ast_based_result = df_ast_based_result[df_ast_based_result['FEN'] != 'UnknownClass']

    # remove the rows that the FEN is "UnknownMethod"
    df_bytecode_based_result = df_bytecode_based_result[df_bytecode_based_result['FEN'] != 'UnknownMethod']

    # If there is a FEN that contains $, see if there is a FEN that replaces $ with . If so, find all the lines where this FEN is located.
    FENs = df_ast_based_result['FEN'].tolist()
    FENs_with_dollar = []
    for FEN in FENs:
        if '$' in FEN:
            FENs_with_dollar.append(FEN)


    FENs_with_dollar_and_dot = []
    for FEN in FENs_with_dollar:
        if FEN.replace('$', '.') in FENs:
            FENs_with_dollar_and_dot.append(FEN)

    for FEN in FENs_with_dollar_and_dot:
        FEN_changed = FEN.replace('$', '.')


        # Find the rows in FEN that contain FEN_changed, and replace FEN_changed with FEN in those rows.
        rows = df_ast_based_result[df_ast_based_result['FEN'].str.contains(re.escape(FEN_changed))]
        for index, row in rows.iterrows():
            row_type = row['Type']

            row_FEN = row['FEN']
            row_FEN_changed = row_FEN.replace(FEN_changed, FEN)
            df_ast_based_result.at[index, 'FEN'] = row_FEN_changed

            # If row_type is Parameterx, then do the substitution for Comment
            if 'Parameter' in row_type:
                row_comment = row['Comment']
                row_comment_changed = row_comment.replace(FEN_changed, FEN)
                df_ast_based_result.at[index, 'Comment'] = row_comment_changed

    df_ast_based_result = df_ast_based_result.drop_duplicates()

    df_ast_based_result = format_FEN(df_ast_based_result)
    df_bytecode_based_result = format_FEN(df_bytecode_based_result)

    df_ast_based_result = df_ast_based_result.drop_duplicates()
    df_bytecode_based_result = df_bytecode_based_result.drop_duplicates()


    class_level_rows = df_ast_based_result[df_ast_based_result['Type'].isin(['Class', 'Abstract Class', 'Enum', 'Interface'])]
    class_level_FENs = class_level_rows['FEN'].unique()
    for class_level_FEN in class_level_FENs:

        # Find lines with the same FEN
        corresponding_rows = class_level_rows[class_level_rows['FEN'] == class_level_FEN]

        if len(corresponding_rows) > 1:
            # Retain lines whose Type is not Class, or the first line if they are all of type Class
            remain_rows = corresponding_rows[corresponding_rows['Type'] != 'Class']
            if remain_rows.empty:
                remain_rows = corresponding_rows.iloc[[0]]

            if len(remain_rows) > 1:
                # If there are more lines, keep the first line
                remain_rows = remain_rows.iloc[[0]]
            # Get the index of the row to be deleted
            rows_to_remove = corresponding_rows.index.difference(remain_rows.index)

            # Remove these rows from the original DataFrame
            df_ast_based_result = df_ast_based_result.drop(rows_to_remove)

    return df_ast_based_result, df_bytecode_based_result


def remove_java_code_comments(java_code):
    # remove the comments in the java code
    # remove the comments in the java code
    java_code = re.sub(r'//.*', '', java_code)
    java_code = re.sub(r'/\*.*?\*/', '', java_code, flags=re.DOTALL)
    return java_code

def obtain_entities(df_ast_based_result, df_bytecode_based_result, entities_dir):

    failed_FENs = []

    class_level_entities = {'FEN:ID': [], ':LABEL': [], 'Comment': [], 'Modifiers': [], 'Extends': [], 'Implements': []}
    method_level_entities = {'FEN:ID': [], ':LABEL': [], 'Comment': [], 'Source Code': [], 'Signature': [], 'CFG': [], 'Modifiers': []}
    field_entities = {'FEN:ID': [], ':LABEL': [], 'Comment': [], 'Source Code': [], 'Signature': [], 'Modifiers': []}
    enum_constant_entities = {'FEN:ID': [], ':LABEL': [], 'Comment': [], 'Source Code': [], 'Signature': [], 'Modifiers': []}
    parameter_level_entities = {'FEN:ID': [], ':LABEL': [], 'Parameter Name': [], 'Data Type': []}

    for index, row in df_ast_based_result.iterrows():
        FEN = row['FEN']
        entity_type = row['Type']
        modifiers = row['Modifier']
        extends = row['class_extends']


        implements = row['implements']
        if entity_type == 'Class' or entity_type == 'Interface' or entity_type == 'Abstract Class' or entity_type == 'Enum':
            class_level_entities['FEN:ID'].append(FEN)
            class_level_entities[':LABEL'].append(entity_type)
            comment = row['Comment']
            if pd.isna(comment):
                comment = ''
            class_level_entities['Comment'].append(comment.replace('\n', '\\n'))
            class_level_entities['Modifiers'].append(modifiers)
            if pd.isna(extends):
                extends = ''
            if pd.isna(implements):
                implements = ''
            extends = remove_java_code_comments(extends).strip()
            implements = remove_java_code_comments(implements).strip()

            class_level_entities['Extends'].append(extends)
            class_level_entities['Implements'].append(implements)
        elif entity_type == 'Abstract Method' or entity_type == 'Method' or entity_type == 'Constructor':

            # find the corresponding bytecode based result
            bytecode_based_row = df_bytecode_based_result[df_bytecode_based_result['FEN'] == FEN]
            if len(bytecode_based_row) == 0:
                continue

            elif len(bytecode_based_row) > 1:
                raise Exception(f'There are more than one bytecode based result for {FEN}')


            method_level_entities['FEN:ID'].append(FEN)
            method_level_entities[':LABEL'].append(entity_type)
            comment = row['Comment']
            if pd.isna(comment):
                comment = ''

            method_level_entities['Comment'].append(comment.replace('\n', '\\n'))

            method_level_entities['Source Code'].append(row['Source Code'].replace('\n', '\\n'))



            bytecode_based_row = bytecode_based_row.iloc[0]
            method_level_entities['Signature'].append(bytecode_based_row['sub_signature'])
            method_level_entities['CFG'].append(bytecode_based_row['cfg_dot'].replace('digraph cfg_<init> {', 'digraph cfg_init {').replace('\n', '\\n'))
            method_level_entities['Modifiers'].append(modifiers)
        elif entity_type == 'Field':
            # find the corresponding bytecode based result
            bytecode_based_row = df_bytecode_based_result[df_bytecode_based_result['FEN'] == FEN]
            if len(bytecode_based_row) == 0:
                # raise Exception(f'Cannot find the bytecode based result for {FEN}')
                failed_FENs.append(FEN)
                continue
            elif len(bytecode_based_row) > 1:
                raise Exception(f'There are more than one bytecode based result for {FEN}')


            field_entities['FEN:ID'].append(FEN)
            field_entities[':LABEL'].append(entity_type)
            comment = row['Comment']
            if pd.isna(comment):
                comment = ''
            field_entities['Comment'].append(comment.replace('\n', '\\n'))
            field_entities['Source Code'].append(row['Source Code'].replace('\n', '\\n'))


            bytecode_based_row = bytecode_based_row.iloc[0]
            field_entities['Signature'].append(bytecode_based_row['sub_signature'])
            field_entities['Modifiers'].append(modifiers)

        elif entity_type == 'Enum Constant':
            # find the corresponding bytecode based result
            bytecode_based_row = df_bytecode_based_result[df_bytecode_based_result['FEN'] == FEN]
            if len(bytecode_based_row) == 0:
                # raise Exception(f'Cannot find the bytecode based result for {FEN}')
                failed_FENs.append(FEN)
                continue
            elif len(bytecode_based_row) > 1:
                raise Exception(f'There are more than one bytecode based result for {FEN}')


            enum_constant_entities['FEN:ID'].append(FEN)
            enum_constant_entities[':LABEL'].append(entity_type)
            enum_constant_entities['Comment'].append(row['Comment'].replace('\n', '\\n'))

            source_code = row['Source Code']
            if pd.isna(source_code):
                source_code = ''


            enum_constant_entities['Source Code'].append(source_code.replace('\n', '\\n'))


            bytecode_based_row = bytecode_based_row.iloc[0]
            enum_constant_entities['Signature'].append(bytecode_based_row['sub_signature'])
            enum_constant_entities['Modifiers'].append(modifiers)

        # if there is "Parameterx" in the type, then it is a parameter. Note: the x is a number, such as Parameter1, Parameter2, Parameter10, etc.
        elif 'Parameter' in entity_type:
            comment = row['Comment']
            bytecode_based_row = df_bytecode_based_result[(df_bytecode_based_result['FEN'] == comment)
                                                          & (df_bytecode_based_result['Type'] == entity_type)]
            if len(bytecode_based_row) == 0:
                continue
            elif len(bytecode_based_row) > 1:
                raise Exception(f'There are more than one bytecode based result for {FEN}')

            parameter_level_entities['FEN:ID'].append(FEN)
            parameter_level_entities[':LABEL'].append(entity_type)
            parameter_name = FEN.split('.')[-1]
            parameter_level_entities['Parameter Name'].append(parameter_name)




            bytecode_based_row = bytecode_based_row.iloc[0]
            parameter_level_entities['Data Type'].append(bytecode_based_row['sub_signature'])

        else:
            raise Exception(f'Unknown entity type: {entity_type}')

    class_level_entities = pd.DataFrame(class_level_entities)
    method_level_entities = pd.DataFrame(method_level_entities)
    method_level_entities = method_level_entities.drop_duplicates()
    if len(method_level_entities['FEN:ID'].tolist()) != len(method_level_entities['FEN:ID'].unique()):

        indexs_to_remove = []
        duplicated_FENs = method_level_entities[method_level_entities['FEN:ID'].duplicated()]['FEN:ID'].tolist()
        for duplicated_FEN in duplicated_FENs:
            rows = method_level_entities[method_level_entities['FEN:ID'] == duplicated_FEN]
            # 只保留最后一个
            indexs_to_remove.extend(rows.index[:-1])
        method_level_entities = method_level_entities.drop(indexs_to_remove)

    field_entities = pd.DataFrame(field_entities)
    enum_constant_entities = pd.DataFrame(enum_constant_entities)
    parameter_level_entities = pd.DataFrame(parameter_level_entities)

    class_level_entities.to_csv(f'{entities_dir}/class_level_entities.csv', index=False)
    method_level_entities.to_csv(f'{entities_dir}/method_level_entities.csv', index=False)
    field_entities.to_csv(f'{entities_dir}/field_entities.csv', index=False)
    enum_constant_entities.to_csv(f'{entities_dir}/enum_constant_entities.csv', index=False)
    parameter_level_entities.to_csv(f'{entities_dir}/parameter_level_entities.csv', index=False)
    print(f'Failed FENs: {failed_FENs}')

def obtain_relations(entities_dir, relations_dir):
    failed_relations = []
    class_level_entities = pd.read_csv('{}/class_level_entities.csv'.format(entities_dir))
    method_level_entities = pd.read_csv('{}/method_level_entities.csv'.format(entities_dir))
    field_entities = pd.read_csv('{}/field_entities.csv'.format(entities_dir))
    constant_level_entities = pd.read_csv('{}/enum_constant_entities.csv'.format(entities_dir))
    parameter_level_entities = pd.read_csv('{}/parameter_level_entities.csv'.format(entities_dir))

    # Extends_relations = {':START_ID': [], ':END_ID': [], ':TYPE': []}
    # Implements_relations = {':START_ID': [], ':END_ID': [], ':TYPE': []}
    # for index, row in class_level_entities.iterrows():
    #     class_FEN = row['FEN:ID']
    #     extends = row['Extends']
    #     implements = row['Implements']
    #     if row[':LABEL'] == 'Enum':
    #         continue
    #     if not pd.isna(extends):
    #         extends_FENs = extends.split(';')
    #         for extends_FEN in extends_FENs:
    #             if extends_FEN not in class_level_entities['FEN:ID'].tolist():
    #                 # third-party classes
    #                 continue
    #             Extends_relations[':START_ID'].append(class_FEN)
    #             Extends_relations[':END_ID'].append(extends_FEN)
    #             Extends_relations[':TYPE'].append('Extends')
    #     if not pd.isna(implements):
    #         implements_FENs = implements.split(';')
    #         for implements_FEN in implements_FENs:
    #             if implements_FEN not in class_level_entities['FEN:ID'].tolist():
    #                 # third-party classes
    #                 continue
    #             Implements_relations[':START_ID'].append(class_FEN)
    #             Implements_relations[':END_ID'].append(implements_FEN)
    #             Implements_relations[':TYPE'].append('Implements')
    # df_Extends_relations = pd.DataFrame(Extends_relations)
    # df_Implements_relations = pd.DataFrame(Implements_relations)


    if len(class_level_entities['FEN:ID'].tolist()) != len(class_level_entities['FEN:ID'].unique()):

        raise Exception('There are duplicate FENs in class_level_entities')

    has_method_relations = {':START_ID': [], ':END_ID': [], ':TYPE': []}
    if len(method_level_entities['FEN:ID'].tolist()) != len(method_level_entities['FEN:ID'].unique()):
        raise Exception('There are duplicate FENs in method_level_entities')




    if len(method_level_entities['FEN:ID'].tolist()) != len(method_level_entities['FEN:ID'].unique()):
            raise Exception('There are duplicate FENs in method_level_entities')
    for index, row in method_level_entities.iterrows():
        method_FEN = row['FEN:ID']
        class_FEN = '.'.join(method_FEN.split('.')[:-1])

        if class_FEN not in class_level_entities['FEN:ID'].tolist():
            raise Exception(f'Cannot find the class entity for {class_FEN}')
        has_method_relations[':START_ID'].append(class_FEN)
        has_method_relations[':END_ID'].append(method_FEN)
        has_method_relations[':TYPE'].append('Has_Method')
    df_has_method_relations = pd.DataFrame(has_method_relations)

    has_field_relations = {':START_ID': [], ':END_ID': [], ':TYPE': []}
    if len(field_entities['FEN:ID'].tolist()) != len(field_entities['FEN:ID'].unique()):
        raise Exception('There are duplicate FENs in field_level_entities')
    for index, row in field_entities.iterrows():
        field_FEN = row['FEN:ID']
        class_FEN = '.'.join(field_FEN.split('.')[:-1])


        if class_FEN not in class_level_entities['FEN:ID'].tolist():
            raise Exception(f'Cannot find the class entity for {class_FEN}')
        has_field_relations[':START_ID'].append(class_FEN)
        has_field_relations[':END_ID'].append(field_FEN)
        has_field_relations[':TYPE'].append('Has_Field')
    df_has_field_relations = pd.DataFrame(has_field_relations)


    has_enum_constant_relations = {':START_ID': [], ':END_ID': [], ':TYPE': []}
    if len(constant_level_entities['FEN:ID'].tolist()) != len(constant_level_entities['FEN:ID'].unique()):
        raise Exception('There are duplicate FENs in constant_level_entities')
    for index, row in constant_level_entities.iterrows():
        constant_FEN = row['FEN:ID']
        class_FEN = '.'.join(constant_FEN.split('.')[:-1])

        if class_FEN not in class_level_entities['FEN:ID'].tolist():
            raise Exception(f'Cannot find the class entity for {class_FEN}')
        has_enum_constant_relations[':START_ID'].append(class_FEN)
        has_enum_constant_relations[':END_ID'].append(constant_FEN)
        has_enum_constant_relations[':TYPE'].append('Has_Enum_Constant')
    df_has_enum_constant_relations = pd.DataFrame(has_enum_constant_relations)

    has_parameter_relations = {':START_ID': [], ':END_ID': [], ':TYPE': []}
    if len(parameter_level_entities['FEN:ID'].tolist()) != len(parameter_level_entities['FEN:ID'].unique()):
        raise Exception('There are duplicate FENs in parameter_level_entities')
    for index, row in parameter_level_entities.iterrows():
        parameter_FEN = row['FEN:ID']
        method_FEN = '.'.join(parameter_FEN.split('.')[:-1])

        if method_FEN not in method_level_entities['FEN:ID'].tolist():


            # raise Exception(f'Cannot find the class entity for {method_FEN}')
            failed_relations.append(parameter_FEN)
            continue
        has_parameter_relations[':START_ID'].append(method_FEN)
        has_parameter_relations[':END_ID'].append(parameter_FEN)
        has_parameter_relations[':TYPE'].append('Has_Parameter')
    df_has_parameter_relations = pd.DataFrame(has_parameter_relations)

    df_has_method_relations.to_csv(f'{relations_dir}/has_method_relations.csv', index=False)
    df_has_field_relations.to_csv(f'{relations_dir}/has_field_relations.csv', index=False)
    df_has_enum_constant_relations.to_csv(f'{relations_dir}/has_enum_constant_relations.csv', index=False)
    df_has_parameter_relations.to_csv(f'{relations_dir}/has_parameter_relations.csv', index=False)
    # df_Extends_relations.to_csv(f'{relations_dir}/extends.csv', index=False)
    # df_Implements_relations.to_csv(f'{relations_dir}/implements.csv', index=False)
    print(f'Failed relations: {failed_relations}')
def basic_entities_and_relations_extraction():
    if not os.path.exists(Config.entities_dir):
        os.makedirs(Config.entities_dir)
    if not os.path.exists(Config.relations_dir):
        os.makedirs(Config.relations_dir)

    df_ast_based_result = pd.read_csv(Config.ast_based_result_path)
    df_bytecode_based_result = pd.read_csv(Config.bytecode_based_result_path)


    df_ast_based_result, df_bytecode_based_result = remove_same_rows_in_df_ast_based_analysis_result(df_ast_based_result, df_bytecode_based_result)
    df_bytecode_based_result = remove_redundant_rows_in_df_bytecode_based_analysis_result(df_ast_based_result, df_bytecode_based_result)
    obtain_entities(df_ast_based_result, df_bytecode_based_result, Config.entities_dir)
    obtain_relations(Config.entities_dir, Config.relations_dir)


if __name__ == '__main__':

    basic_entities_and_relations_extraction()

