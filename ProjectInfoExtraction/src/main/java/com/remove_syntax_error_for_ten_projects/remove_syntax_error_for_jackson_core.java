package com.remove_syntax_error_for_ten_projects;

import com.Config;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import com.remove_syntax_error_code.*;

import static com.remove_syntax_error_code.*;

public class remove_syntax_error_for_jackson_core {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String package_name = "com.fasterxml.jackson.core";
        String testCodeDir = Config.BASE_DIR + "/experiment_results/TenProjects/jackson-core-2.19/src/test/java/com/fasterxml/jackson/core";
        String Project_Basic_Dir = Config.BASE_DIR + "/experiment_results/TenProjects/jackson-core-2.19";
        String syntaxErrorFile = Config.CURRENT_DIR + "/saved_data/jackson_core_syntax_error_log.txt";
        remove_all_syntax_error_code(testCodeDir, Project_Basic_Dir, syntaxErrorFile, package_name);
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) + "ms");
    }
}
