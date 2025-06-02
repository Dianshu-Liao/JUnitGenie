package com.check_syntax_error_for_ten_projects;

import com.Config;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import static com.check_syntax_error.*;

public class check_syntax_error_for_csv {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String testCodeDir = Config.BASE_DIR + "/experiment_results/TenProjects/commons-csv-master/src/test/java/org/apache/commons/csv";
        String projectDir = Config.BASE_DIR + "/experiment_results/TenProjects/commons-csv-master";
        String syntaxErrorFile = "/Users/dianshuliao/Documents/Research/Knowledge_Distillation_for_LLM_Test_Gen/UnitTestGeneration/ProjectInfoExtraction/saved_data/syntax_error_log_csv.txt";
        String filesWithSyntaxErrorCsv = "/Users/dianshuliao/Documents/Research/Knowledge_Distillation_for_LLM_Test_Gen/UnitTestGeneration/ProjectInfoExtraction/saved_data/syntax_error_results/files_with_syntax_error_csv.csv";
        check_syntax_error_for_a_project(testCodeDir, projectDir, syntaxErrorFile, filesWithSyntaxErrorCsv);
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) + "ms");
    }
}
