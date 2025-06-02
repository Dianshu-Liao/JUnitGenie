package com.check_syntax_error_iteration;

import com.Config;

import java.io.IOException;

import static com.check_syntax_error.check_syntax_error_for_a_project;
import static com.check_syntax_error.check_syntax_error_iteration;

public class check_syntax_error_for_commons_lang {
    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
        String projectDir = Config.BASE_DIR + "/experiment_results/TenProjects/commons-lang-master";
        String syntaxErrorFile = Config.CURRENT_DIR + "/saved_data/syntax_error_log_lang.txt";
        String filesWithSyntaxErrorCsv = Config.CURRENT_DIR + "/saved_data/syntax_error_results/files_with_syntax_error_lang.csv";
        check_syntax_error_iteration(projectDir, syntaxErrorFile, filesWithSyntaxErrorCsv);
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) + "ms");
    }
}