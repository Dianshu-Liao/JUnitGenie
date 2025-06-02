package com.check_syntax_error_iteration;

import com.Config;

import java.io.IOException;

import static com.check_syntax_error.check_syntax_error_for_a_project;
import static com.check_syntax_error.check_syntax_error_iteration;

public class check_syntax_error_for_commons_jxpath {
    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();

        String projectDir = Config.BASE_DIR + "/experiment_results/TenProjects/commons-jxpath-master";
        String syntaxErrorFile = Config.CURRENT_DIR + "/saved_data/syntax_error_log_jxpath.txt";
        String filesWithSyntaxErrorCsv = Config.CURRENT_DIR + "/saved_data/syntax_error_results/files_with_syntax_error_jxpath.csv";

        check_syntax_error_iteration(projectDir, syntaxErrorFile, filesWithSyntaxErrorCsv);
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) + "ms");
    }
}