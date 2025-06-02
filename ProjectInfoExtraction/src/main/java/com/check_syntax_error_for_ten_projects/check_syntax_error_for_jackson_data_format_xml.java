package com.check_syntax_error_for_ten_projects;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import static com.check_syntax_error.*;

public class check_syntax_error_for_jackson_data_format_xml {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String testCodeDir = "/Users/dianshuliao/Documents/Research/Knowledge_Distillation_for_LLM_Test_Gen/UnitTestGeneration/saved_data/TenJavaProjects/jackson-dataformat-xml-2.19/src/test/java/com/fasterxml/jackson/dataformat/xml";
        String projectDir = "/Users/dianshuliao/Documents/Research/Knowledge_Distillation_for_LLM_Test_Gen/UnitTestGeneration/saved_data/TenJavaProjects/jackson-dataformat-xml-2.19";
        String syntaxErrorFile = "/Users/dianshuliao/Documents/Research/Knowledge_Distillation_for_LLM_Test_Gen/UnitTestGeneration/ProjectInfoExtraction/saved_data/syntax_error_log_jackson_data_format_xml.txt";
        String filesWithSyntaxErrorCsv = "/Users/dianshuliao/Documents/Research/Knowledge_Distillation_for_LLM_Test_Gen/UnitTestGeneration/ProjectInfoExtraction/saved_data/syntax_error_results/files_with_syntax_error_jackson_data_format_xml.csv";
        check_syntax_error_for_a_project(testCodeDir, projectDir, syntaxErrorFile, filesWithSyntaxErrorCsv);

        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) + "ms");
    }
}
