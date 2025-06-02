package com.check_syntax_error_iteration;

import com.Config;

import java.io.IOException;

import static com.check_syntax_error.check_syntax_error_for_a_project;
import static com.check_syntax_error.check_syntax_error_iteration;


public class check_syntax_error_for_jackson_data_format_xml {
    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
        String projectDir = Config.BASE_DIR + "/experiment_results/TenProjects/jackson-dataformat-xml-2.19";
        String syntaxErrorFile = Config.CURRENT_DIR + "/saved_data/syntax_error_log_jackson_data_format_xml.txt";
        String filesWithSyntaxErrorCsv = Config.CURRENT_DIR + "/saved_data/syntax_error_results/files_with_syntax_error_jackson_data_format_xml.csv";
        check_syntax_error_iteration(projectDir, syntaxErrorFile, filesWithSyntaxErrorCsv);

        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) + "ms");
    }
}