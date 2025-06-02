package com.check_syntax_error_for_ten_projects;

import com.Config;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import static com.check_syntax_error.*;

public class check_syntax_error_for_commons_jxpath {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String testCodeDir = Config.BASE_DIR + "/experiment_results/TenProjects/commons-jxpath-master/src/test/java/org/apache/commons/jxpath";
        String projectDir = Config.BASE_DIR + "/experiment_results/TenProjects/commons-jxpath-master";
        String syntaxErrorFile = Config.CURRENT_DIR + "/saved_data/syntax_error_log_jxpath.txt";
        String filesWithSyntaxErrorCsv = Config.CURRENT_DIR + "/saved_data/syntax_error_results/files_with_syntax_error_jxpath.csv";
        check_syntax_error_for_a_project(testCodeDir, projectDir, syntaxErrorFile, filesWithSyntaxErrorCsv);
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) + "ms");

    }
}
