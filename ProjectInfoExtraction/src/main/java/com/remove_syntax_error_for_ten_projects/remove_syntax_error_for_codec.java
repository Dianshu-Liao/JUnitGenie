package com.remove_syntax_error_for_ten_projects;

import com.Config;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import com.remove_syntax_error_code.*;

import static com.remove_syntax_error_code.*;

public class remove_syntax_error_for_codec {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String package_name = "org.apache.commons.codec";
        String testCodeDir = Config.BASE_DIR + "/experiment_results/TenProjects/commons-codec-master/src/test/java/org/apache/commons/codec";
        String Project_Basic_Dir = Config.BASE_DIR + "/experiment_results/TenProjects/commons-codec-master";
        String syntaxErrorFile = Config.CURRENT_DIR + "/saved_data/codec_syntax_error_log.txt";

        remove_all_syntax_error_code(testCodeDir, Project_Basic_Dir, syntaxErrorFile, package_name);
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) + "ms");

    }
}
