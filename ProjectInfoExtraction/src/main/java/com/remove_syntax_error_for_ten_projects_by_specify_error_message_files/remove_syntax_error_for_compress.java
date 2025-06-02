package com.remove_syntax_error_for_ten_projects_by_specify_error_message_files;

import com.Config;

import java.io.IOException;

import static com.remove_syntax_error_code.remove_all_syntax_error_code;
import static com.remove_syntax_error_code.remove_all_syntax_error_code_by_selecting_file_after_refinement;

public class remove_syntax_error_for_compress {
    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
        String package_name = "org.apache.commons.compress";
        String Project_Basic_Dir = Config.BASE_DIR + "/experiment_results/TenProjects/commons-compress-master";
        String syntaxErrorFile = Config.CURRENT_DIR + "/saved_data/commons_compress_syntax_error_log.txt";
        String filesWithSyntaxErrorCsv = Config.CURRENT_DIR + "/saved_data/syntax_error_results/files_with_syntax_error_compress.csv";

        remove_all_syntax_error_code_by_selecting_file_after_refinement(Project_Basic_Dir, syntaxErrorFile, package_name, filesWithSyntaxErrorCsv);
        long endTime = System.currentTimeMillis();
        System.out.println("Time: " + (endTime - startTime) + "ms");
    }
}
