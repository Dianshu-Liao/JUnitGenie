package com;

import java.io.IOException;


public class _1_Basic_Code_Analysis {
    public static void main(String[] args) throws IOException {
        String projectDir = Config.Project_Basic_Dir + Config.projectSrcDir;
        String outputCsv = Config.Experiment_Result_Basic_Dir + '/' + Config.package_name.replace('.', '_')  + "/ASTBased_Results.csv";

        String ASTerrorLogPath = Config.Experiment_Result_Basic_Dir + '/' + Config.package_name.replace('.', '_')  + "/ast_based_analysis_error_log.txt";

        AST_Based_Analyzer.handle_all_java_files_in_a_directory(projectDir, outputCsv, ASTerrorLogPath);


        String project_classes_dir = Config.Project_Basic_Dir  + Config.projectclassDir;
        String outputCsvPath = Config.Experiment_Result_Basic_Dir + '/' + Config.package_name.replace('.', '_') + "/ByteBased_Results.csv";
        String ByteerrorLogPath = Config.Experiment_Result_Basic_Dir + '/' + Config.package_name.replace('.', '_') + "/byte_based_analysis_error_log.txt";

        Sootup_Based_Analyzer.extract_info_from_all_classes_in_a_project(project_classes_dir, outputCsvPath, ByteerrorLogPath);


    }
}
