package com;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

public class check_syntax_error {

    /**
     * Checks if a given Java file contains syntax errors by attempting to compile it.
     *
     * @param javaFile      The Java file to check.
     * @param projectDir    The root directory of the project.
     * @param errorLogFile  The path to the file where compilation errors will be logged.
     * @return {@code true} if the file contains syntax errors, {@code false} otherwise.
     */
    public static boolean hasSyntaxError(Path javaFile, String projectDir, String errorLogFile) {
        try {
            // If the file does not exist, return false
            if (!javaFile.toFile().exists()) {
                return false;
            }

            // Check for known invalid content. Maybe need to be deleted
            String fileContent = new String(Files.readAllBytes(javaFile), StandardCharsets.UTF_8);
            if (fileContent.contains("can't match the test code")) {
                return true; // Treat this as a syntax error
            }

            // Delete the previous error log file
            File file = new File(errorLogFile);
            if (file.exists()) {
                file.delete();
            }

            // Compile the Java file
            ProcessBuilder builder = new ProcessBuilder(
                    "sh", "-c",
                    "javac -cp target/classes:src/main/java:$(cat /your_dir_path/classpath.txt) " +
                            "-d target/test-classes " + "'" + javaFile.toString() + "'" +
                            " 2>> " + errorLogFile
            );
            builder.directory(new File(projectDir)); // Set working directory
            Process process = builder.start();
            int exitCode = process.waitFor(); // Wait for compilation to finish

            return exitCode != 0; // Non-zero exit code indicates a syntax error
        } catch (Exception e) {
            e.printStackTrace();
            return true; // Treat exceptions as syntax errors
        }
    }

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
     * Reads the compilation error messages from the error log file.
     *
     * @param errorLogFile The path to the error log file.
     * @return The content of the error log.
     */
    public static String readErrorMessage(String errorLogFile) {
        try {
            return new String(Files.readAllBytes(Paths.get(errorLogFile))).trim();
        } catch (IOException e) {
            return "Error log file could not be read.";
        }
    }

    /**
     * Writes the syntax error details to a CSV file.
     *
     * @param resultRows             The collected error messages.
     * @param filesWithSyntaxErrorCsv The path to the output CSV file.
     */
    public static void writeToCsv(List<String[]> resultRows, String filesWithSyntaxErrorCsv) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filesWithSyntaxErrorCsv))) {
            for (String[] row : resultRows) {
                writer.write(String.join(",", escapeCsv(row)));
                writer.newLine();
            }
            System.out.println("Syntax errors saved to: " + filesWithSyntaxErrorCsv);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Escapes CSV values to handle special characters such as commas and newlines.
     *
     * @param row The row data to be written.
     * @return Escaped CSV row.
     */
    private static String[] escapeCsv(String[] row) {
        return Arrays.stream(row)
                .map(value -> "\"" + value.replace("\"", "\"\"").replace("\n", " | ") + "\"") // Escape double quotes and replace newlines
                .toArray(String[]::new);
    }


    public static List<Path> getFileNamesFromCsv(Path csvPath) throws IOException {
        List<Path> filePaths = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(csvPath)) {
            String headerLine = reader.readLine();
            if (headerLine == null) {
                return filePaths; // ???
            }

            String[] headers = headerLine.split(",");
            int fileNameIndex = -1;
            for (int i = 0; i < headers.length; i++) {
                if (headers[i].trim().replace("\"", "").equals("file_name")) {
                    fileNameIndex = i;
                    break;
                }
            }


            if (fileNameIndex == -1) {
                throw new IllegalArgumentException("CSV header does not contain 'file_name' column");
            }

            String line;
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");
                if (columns.length > fileNameIndex) {
                    String fileName = columns[fileNameIndex].trim().replace("\"", "");
                    filePaths.add(Paths.get(fileName));
                }
            }
        }

        return filePaths;
    }


    static public void check_syntax_error_iteration(String projectDir, String syntaxErrorFile, String filesWithSyntaxErrorCsv) throws IOException {
        List<Path> javaFiles = getFileNamesFromCsv(Paths.get(filesWithSyntaxErrorCsv));
        List<String[]> resultRows = new ArrayList<>();
        resultRows.add(new String[]{"file_name", "syntax_error_message"}); // CSV Header

        System.out.println("Total Java files to process: " + javaFiles.size());
        int count = 0;
        for (Path javaFilePath : javaFiles) {
            count++;
            System.out.println("Processing file " + count + " of " + javaFiles.size() + ": " + javaFilePath.getFileName());

            String javaFileName = javaFilePath.getFileName().toString();

            if (hasSyntaxError(javaFilePath, projectDir, syntaxErrorFile)) {
                // Read the error log file
                String errorMessage = readErrorMessage(syntaxErrorFile);

                // Add the file name and error message to the list
                resultRows.add(new String[]{String.valueOf(javaFilePath), errorMessage});
            }

        }

        // Write results to CSV
        writeToCsv(resultRows, filesWithSyntaxErrorCsv);

    }

    static public void check_syntax_error_for_a_project(String testCodeDir, String projectDir, String syntaxErrorFile, String filesWithSyntaxErrorCsv) {
        List<String[]> resultRows = new ArrayList<>();
        resultRows.add(new String[]{"file_name", "syntax_error_message"}); // CSV Header

        try {
            List<Path> javaFiles = getJavaFiles(testCodeDir); // Get all Java files
            System.out.println("Total Java files to process: " + javaFiles.size());

            int count = 0;
            for (Path javaFilePath : javaFiles) {
                count++;
                System.out.println("Processing file " + count + " of " + javaFiles.size() + ": " + javaFilePath.getFileName());

                String javaFileName = javaFilePath.getFileName().toString();

                if (hasSyntaxError(javaFilePath, projectDir, syntaxErrorFile)) {
                    // Read the error log file
                    String errorMessage = readErrorMessage(syntaxErrorFile);

                    // Add the file name and error message to the list
                    resultRows.add(new String[]{String.valueOf(javaFilePath), errorMessage});
                }

            }

            // Write results to CSV
            writeToCsv(resultRows, filesWithSyntaxErrorCsv);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
