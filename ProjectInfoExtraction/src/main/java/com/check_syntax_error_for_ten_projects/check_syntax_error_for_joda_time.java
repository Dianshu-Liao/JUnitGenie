package com.check_syntax_error_for_ten_projects;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import static com.check_syntax_error.*;

public class check_syntax_error_for_joda_time {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String testCodeDir = "/Users/dianshuliao/Documents/Research/Knowledge_Distillation_for_LLM_Test_Gen/UnitTestGeneration/saved_data/TenJavaProjects/joda-time-main/src/test/java/org/joda/time";
        String projectDir = "/Users/dianshuliao/Documents/Research/Knowledge_Distillation_for_LLM_Test_Gen/UnitTestGeneration/saved_data/TenJavaProjects/joda-time-main";
        String syntaxErrorFile = "/Users/dianshuliao/Documents/Research/Knowledge_Distillation_for_LLM_Test_Gen/UnitTestGeneration/ProjectInfoExtraction/saved_data/syntax_error_log_joda_time.txt";
        String filesWithSyntaxErrorCsv = "/Users/dianshuliao/Documents/Research/Knowledge_Distillation_for_LLM_Test_Gen/UnitTestGeneration/ProjectInfoExtraction/saved_data/syntax_error_results/files_with_syntax_error_joda_time.csv";
        check_syntax_error_for_a_project(testCodeDir, projectDir, syntaxErrorFile, filesWithSyntaxErrorCsv);
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) + "ms");
    }
}
