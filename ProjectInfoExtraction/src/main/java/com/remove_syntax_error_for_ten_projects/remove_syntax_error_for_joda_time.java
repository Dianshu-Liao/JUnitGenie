package com.remove_syntax_error_for_ten_projects;

import com.Config;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import com.remove_syntax_error_code.*;

import static com.remove_syntax_error_code.*;

public class remove_syntax_error_for_joda_time {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String package_name = "org.joda.time";
        String testCodeDir = Config.BASE_DIR + "/experiment_results/TenProjects/joda-time-main/src/test/java/org/joda/time";
        String Project_Basic_Dir = Config.BASE_DIR + "/experiment_results/TenProjects/joda-time-main";
        String syntaxErrorFile = Config.CURRENT_DIR + "/saved_data/joda_time_syntax_error_log.txt";
        remove_all_syntax_error_code(testCodeDir, Project_Basic_Dir, syntaxErrorFile, package_name);
        long endTime = System.currentTimeMillis();
        System.out.println("Time: " + (endTime - startTime) + "ms");
    }
}
