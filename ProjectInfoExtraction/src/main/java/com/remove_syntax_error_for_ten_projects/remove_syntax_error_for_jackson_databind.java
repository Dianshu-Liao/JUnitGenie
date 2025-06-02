package com.remove_syntax_error_for_ten_projects;

import com.Config;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import com.remove_syntax_error_code.*;

import static com.remove_syntax_error_code.*;

public class remove_syntax_error_for_jackson_databind {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String package_name = "com.fasterxml.jackson.databind";
        String testCodeDir = Config.BASE_DIR + "/experiment_results/TenProjects/jackson-databind-2.19/src/test/java/com/fasterxml/jackson/databind";
        String Project_Basic_Dir = Config.BASE_DIR + "/experiment_results/TenProjects/jackson-databind-2.19";
        String syntaxErrorFile = Config.CURRENT_DIR + "/saved_data/jackson_databind_syntax_error_log.txt";
        remove_all_syntax_error_code(testCodeDir, Project_Basic_Dir, syntaxErrorFile, package_name);
        long endTime = System.currentTimeMillis();
        System.out.println("Time: " + (endTime - startTime) + "ms");
    }
}
