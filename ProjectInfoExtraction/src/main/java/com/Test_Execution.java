package com;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

public class Test_Execution {

    /**
     * Retrieves all Java files within the specified directory.
     *
     * @param directory The root directory to search for Java files.
     * @return A list of paths to Java files.
     * @throws IOException If an error occurs while accessing the file system.
     */
    public static List<Path> getJavaFiles(String directory) throws IOException {
        return Files.walk(Paths.get(directory))
                .filter(Files::isRegularFile)
                .filter(path -> path.toString().endsWith(".java"))
                .collect(Collectors.toList());
    }

    /**
     * Extracts test class names from Java files and writes them to a file.
     * The test class names are written without ".java" extension.
     */
    public static void getTestList(String testCodeDir, String testListFile) {
        try {
            List<Path> javaFiles = getJavaFiles(testCodeDir); // Get all Java files
            List<String> testList = new ArrayList<>();

            for (Path javaFilePath : javaFiles) {
                String testClassName = javaFilePath.getFileName().toString().replace(".java", ""); // Remove .java extension
                testList.add(testClassName);
            }

            // Write to test_list.txt
            Files.write(Paths.get(testListFile), testList, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("Test list saved to: " + testListFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Runs the given shell command inside the specified working directory.
     */
    public static void runCommand(String command, String workingDir, String logFile) {
        try {
            ProcessBuilder builder = new ProcessBuilder("sh", "-c", command);
            builder.directory(new File(workingDir)); // Set working directory
            builder.redirectErrorStream(true); // Merge stdout and stderr
            builder.redirectOutput(new File(logFile)); // Save output to log file

            Process process = builder.start();
            int exitCode = process.waitFor(); // Wait for command execution

            System.out.println("Command executed: " + command);
            System.out.println("Exit Code: " + exitCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Define project paths
        String workingDir = "/Users/dianshuliao/Documents/Research/TestCaseGeneration/Java_Projects/lang_1_buggy_check_evosuite_results_2";
        String testCodeDir = "/Users/dianshuliao/Documents/Research/TestCaseGeneration/Java_Projects/lang_1_buggy_check_evosuite_results_2/src/test/java/org/apache/commons/lang3";
        String testListFile = "/Users/dianshuliao/Documents/Research/TestCaseGeneration/UnitTestGeneration/ProjectInfoExtraction/saved_data/test_list.txt";
        String mvnTestLogFile = "/Users/dianshuliao/Documents/Research/TestCaseGeneration/UnitTestGeneration/ProjectInfoExtraction/saved_data/maven_output.log";
        String jacocoLogFile = "/Users/dianshuliao/Documents/Research/TestCaseGeneration/UnitTestGeneration/ProjectInfoExtraction/saved_data/jacoco_output.log";

        // Step 1: Generate test list
        getTestList(testCodeDir, testListFile);

        // Step 2: Read test list from file
        List<String> testClasses;
        try {
            testClasses = Files.readAllLines(Paths.get(testListFile));
            if (testClasses.isEmpty()) {
                System.out.println("No test classes found!");
                return;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Step 3: Format the test class names for mvn command
        String testParam = String.join(",", testClasses);

        // Step 4: Execute mvn test
        String mvnTestCommand = "mvn test -Dtest=\"" + testParam + "\"";
        runCommand(mvnTestCommand, workingDir, mvnTestLogFile);

        // Step 5: Execute mvn jacoco:report
        String mvnJacocoCommand = "mvn jacoco:report";
        runCommand(mvnJacocoCommand, workingDir, jacocoLogFile);
    }
}
