import os

class Config:


    # our_project_dir = '/Users/dianshuliao/Documents/Research/Knowledge_Distillation_for_LLM_Test_Gen/UnitTestGeneration'
    # our_project_dir = 'JUnitGenieArtifact'
    our_project_dir = os.path.dirname(os.path.abspath(__file__))  # This file's folder

    api_key_list = ['sk-JWHQ6j8qFDjPH2QD050f3b8bE6534bD6Af5d06E3D594E51e', 'sk-fGIQURbVEuOM5MMm677604F2Ae6e4447A1C0171e55B57470',
                    'sk-OSLzZLU5c4AEMEDD1dAdF551563446F49e66F0B5F970774b', 'sk-B42S43cYAigfjnUW44FaC69b92184a52A0F3522bEc24Cb91',
                    'sk-KXe79KMnkdFmOYTF59C515742e5447328e4c838123AfC2Bc', 'sk-STrFl9VseiByLqSV23470433D56b41AfB164CfD3E63525Aa',
                    'sk-zqpu7dbWobzMgCFA2e84C15d1e024f0cBe385dF3E0A6Bb1a', 'sk-yPa3ZFkzGxRgVzWL07B6A628Ce3047D4B2Eb08Bf2789E279',
                    'sk-YEHAAxq2qnmf4vXTE8A391FcE3B542018d1e9f6b1fBaA04a', 'sk-wCr5hvHtI1ZAB56l9101FdC718D5460e9dA2A735De947256',
                    'sk-CVYgpjC5rZc9QPdYE4BeF9C56000497191DcE4AdFeBc771c', 'sk-uhvpIYu3WHEShzlA7292635f4a7d4e519e5c7d827a97C191',
                    'sk-uvGlqkZrFZBS1t3E60D69909FfDd422e8f0aB47f3167220f', 'sk-Ijx2nro4SAvroMou35Be8445B35d4456Ae555aD64dEa9405',
                    'sk-qwlbaLefQUUyIDlJDdB91900890d45E99d8395E6E95d2b2d', 'sk-4QfhlaULSVUwWjA7C934Bc4b52784aF4B0953c4dCd9b2dD3',
                    'sk-4xD3wLP9fVLBUdrNF7F6B3B6F99e4f8c9672F30b538e0aD7', 'sk-XnH3StNDYh6u2qNID8940aFd859746D3B0605a95E13fE0Ae',
                    'sk-jjxUz5ItURYG1BkS00D4F903FaAf43CbB6F3DeC02303A709', 'sk-OX1j8bKIJD2frVhWCe8c812e7dBf441097F4D4B636824231']
    openai_key = 'sk-JWHQ6j8qFDjPH2QD050f3b8bE6534bD6Af5d06E3D594E51e'
    LLM_CFGPath_ContextInfo_prompt_dir = our_project_dir + '/' + 'prompts/LLM_CFGPath_ContextInfo'
    LLM_CFGPath_prompt_dir = our_project_dir + '/' + 'prompts/LLM_CFGPath'
    LLM_Only_prompt_dir = our_project_dir + '/' + 'prompts/LLM_Only'
    LLM_CFGPath_SemanticContextInfo_prompt_dir = our_project_dir + '/' + 'prompts/LLM_CFGPath_SemanticContextInfo'
    LLM_ContextInfo_dir = our_project_dir + '/' + 'prompts/LLM_ContextInfo'
    Method_Constraints_prompt_dir = our_project_dir + '/' + 'prompts/Method_Constraints'
    CFG_Paths_Selector_prompt_dir = our_project_dir + '/' + 'prompts/CFG_Pruner'
    Parameters_Constraints_prompt_dir = our_project_dir + '/' + 'prompts/Parameters_Constraints'
    Code_Fixer_prompt_dir = our_project_dir + '/' + 'prompts/Code_Fixer'
    Check_Test_Oracle_dir = our_project_dir + '/' + 'prompts/Check_Test_Oracle'
    foundation_model_gpt4o = "gpt-4o"
    foundation_model_gpt4o_mini = "gpt-4o-mini"
    foundation_model_claude_3_5 = 'claude-3.5'
    path_selector_verification_time = 3

    package_name_to_syntax_error_path = {
        'org.apache.commons.codec': our_project_dir + '/ProjectInfoExtraction/saved_data/syntax_error_results/files_with_syntax_error_codec.csv',
        'org.apache.commons.collections4': our_project_dir + '/ProjectInfoExtraction/saved_data/syntax_error_results/files_with_syntax_error_collections.csv',
        'org.apache.commons.compress': our_project_dir + '/ProjectInfoExtraction/saved_data/syntax_error_results/files_with_syntax_error_compress.csv',
        'org.apache.commons.csv': our_project_dir + '/ProjectInfoExtraction/saved_data/syntax_error_results/files_with_syntax_error_csv.csv',
        'com.fasterxml.jackson.core': our_project_dir + '/ProjectInfoExtraction/saved_data/syntax_error_results/files_with_syntax_error_jackson_core.csv',
        'com.fasterxml.jackson.databind': our_project_dir + '/ProjectInfoExtraction/saved_data/syntax_error_results/files_with_syntax_error_jackson_databind.csv',
        'com.fasterxml.jackson.dataformat.xml': our_project_dir + '/ProjectInfoExtraction/saved_data/syntax_error_results/files_with_syntax_error_jackson_data_format_xml.csv',
        'org.apache.commons.jxpath': our_project_dir + '/ProjectInfoExtraction/saved_data/syntax_error_results/files_with_syntax_error_jxpath.csv',
        'org.joda.time': our_project_dir + '/ProjectInfoExtraction/saved_data/syntax_error_results/files_with_syntax_error_joda_time.csv',
        'org.apache.commons.lang3': our_project_dir + '/ProjectInfoExtraction/saved_data/syntax_error_results/files_with_syntax_error_lang.csv'
    }

    package_name_to_base_dir = {
        'org.apache.commons.codec': our_project_dir + '/saved_data/TenJavaProjects/commons-codec-master',
        'org.apache.commons.collections4': our_project_dir + '/saved_data/TenJavaProjects/commons-collections-master',
        'org.apache.commons.compress': our_project_dir + '/saved_data/TenJavaProjects/commons-compress-master',
        'org.apache.commons.csv': our_project_dir + '/saved_data/TenJavaProjects/commons-csv-master',
        'com.fasterxml.jackson.core': our_project_dir + '/saved_data/TenJavaProjects/jackson-core-2.19',
        'com.fasterxml.jackson.databind': our_project_dir + '/saved_data/TenJavaProjects/jackson-databind-2.19',
        'com.fasterxml.jackson.dataformat.xml': our_project_dir + '/saved_data/TenJavaProjects/jackson-dataformat-xml-2.19',
        'org.apache.commons.jxpath': our_project_dir + '/saved_data/TenJavaProjects/commons-jxpath-master',
        'org.joda.time': our_project_dir + '/saved_data/TenJavaProjects/joda-time-main',
        'org.apache.commons.lang3': our_project_dir + '/saved_data/TenJavaProjects/commons-lang-master'
    }

    package_name_to_test_dir = {
        'org.apache.commons.codec': our_project_dir + '/saved_data/TenJavaProjects/commons-codec-master/src/test/java',
        'org.apache.commons.collections4': our_project_dir + '/saved_data/TenJavaProjects/commons-collections-master/src/test/java',
        'org.apache.commons.compress': our_project_dir + '/saved_data/TenJavaProjects/commons-compress-master/src/test/java',
        'org.apache.commons.csv': our_project_dir + '/saved_data/TenJavaProjects/commons-csv-master/src/test/java',
        'com.fasterxml.jackson.core': our_project_dir + '/saved_data/TenJavaProjects/jackson-core-2.19/src/test/java',
        'com.fasterxml.jackson.databind': our_project_dir + '/saved_data/TenJavaProjects/jackson-databind-2.19/src/test/java',
        'com.fasterxml.jackson.dataformat.xml': our_project_dir + '/saved_data/TenJavaProjects/jackson-dataformat-xml-2.19/src/test/java',
        'org.apache.commons.jxpath': our_project_dir + '/saved_data/TenJavaProjects/commons-jxpath-master/src/test/java',
        'org.joda.time': our_project_dir + '/saved_data/TenJavaProjects/joda-time-main/src/test/java',
        'org.apache.commons.lang3': our_project_dir + '/saved_data/TenJavaProjects/commons-lang-master/src/test/java'
    }



    # for the project org.apache.commons.lang3
    project_package_name = 'org.apache.commons.lang3'
    testDir = our_project_dir + '/saved_data/TenJavaProjects/commons-lang-master'



    experiment_Result_Basic_Dir = our_project_dir + "/experiment_results"
    ast_based_result_path = experiment_Result_Basic_Dir + '/' +  project_package_name.replace('.', '_') + '/' + 'ASTBased_Results.csv'
    bytecode_based_result_path = experiment_Result_Basic_Dir + '/' + project_package_name.replace('.', '_') + '/' + 'ByteBased_Results.csv'


    entities_dir = experiment_Result_Basic_Dir + '/Code_Knowledge_Base/'  + project_package_name.replace('.', '_') + '/' + 'Entities'
    relations_dir = experiment_Result_Basic_Dir + '/Code_Knowledge_Base/'  + project_package_name.replace('.', '_') + '/' + 'Relations'


    cfg_path_construction_error_file_path = experiment_Result_Basic_Dir + '/' + project_package_name.replace('.', '_') + '/error_when_construct_cfg_paths.txt'



    field_entities_path = entities_dir + '/field_entities.csv'
    enum_constant_entities_path = entities_dir + '/enum_constant_entities.csv'
    method_entities_path = entities_dir + '/method_level_entities.csv'
    cfg_path_entities_path = entities_dir + '/cfg_path_entities.csv'
    uses_field_relations_path = relations_dir + '/uses_field.csv'
    uses_method_relations_path = relations_dir + '/uses_method.csv'
    uses_enum_constant_relations_path = relations_dir + '/uses_enum_constant.csv'
    has_cfg_path_relations_path = relations_dir + '/has_cfg_path.csv'
    # extends_relations_path = relations_dir + '/extends.csv'
    # implements_relations_path = relations_dir + '/implements.csv'

    dataset_path = experiment_Result_Basic_Dir + '/' + 'methods_with_multipaths_and_context.csv'
    sampled_dataset_path_for_all_projects = experiment_Result_Basic_Dir + '/Sampled_Dataset_For_All_Projects.csv'
    basic_prompt_for_LLMs_path = experiment_Result_Basic_Dir + '/' + project_package_name.replace('.', '_') + '/different_foundation_models/basic_prompt_for_LLMs.csv'

