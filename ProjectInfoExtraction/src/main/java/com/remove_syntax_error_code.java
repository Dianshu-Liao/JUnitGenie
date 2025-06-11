package com;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import java.io.*;
import java.util.*;
import java.util.regex.*;
import com.Config;

public class remove_syntax_error_code {

    public static class MethodInfo {
        String FEN; // Fully-Qualified Name
        int startLine; // ????
        int endLine;   // ????

        public MethodInfo(String FEN, int startLine, int endLine) {
            this.FEN = FEN;
            this.startLine = startLine;
            this.endLine = endLine;
        }

        @Override
        public String toString() {
            return "FEN: " + FEN + ", Start Line: " + startLine + ", End Line: " + endLine;
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
     * ????????????????????
     */
    public static void removeCodeInOriginalFile(String originalFilePath, List<int[]> rangesToDelete) throws IOException {

        List<String> lines = Files.readAllLines(Paths.get(originalFilePath));


        List<String> updatedLines = new ArrayList<>();


        for (int i = 0; i < lines.size(); i++) {
            int currentLine = i + 1; // ??? 1 ??
            boolean isInDeleteRange = false;

            for (int[] range : rangesToDelete) {
                if (currentLine >= range[0] && currentLine <= range[1]) {
                    isInDeleteRange = true;
                    break;
                }
            }

            // ????????????????
            if (!isInDeleteRange) {
                updatedLines.add(lines.get(i));
            }
        }

        // 先删除原文件
        Path path = Paths.get(originalFilePath);
        Files.deleteIfExists(path);

        // 重新创建文件并写入更新后的内容
        Files.write(path, updatedLines, StandardOpenOption.CREATE_NEW);

        System.out.println("Updated file: " + originalFilePath);
    }
    private static String getFullyQualifiedName(MethodDeclaration method, CompilationUnit compilationUnit) {

        String className = compilationUnit.findFirst(com.github.javaparser.ast.body.ClassOrInterfaceDeclaration.class)
                .flatMap(cls -> cls.getFullyQualifiedName())
                .orElse("UnknownClass");


        String methodName = method.getNameAsString();
        StringBuilder parameterTypes = new StringBuilder();
        method.getParameters().forEach(param -> {
            String paramType = param.getTypeAsString();
            parameterTypes.append(paramType).append(",");
        });

        if (parameterTypes.length() > 0) {
            parameterTypes.setLength(parameterTypes.length() - 1); // ???????
        }

        return String.format("%s.%s(%s)", className, methodName, parameterTypes);
    }


    public static List<MethodInfo> getMethodsFromJavaFile(String filePath) {
        List<MethodInfo> methodsInfo = new ArrayList<>();
        try {
            String sourceCode = new String(Files.readAllBytes(Paths.get(filePath)));
            JavaParser parser = new JavaParser();
            ParseResult<CompilationUnit> parseResult = parser.parse(sourceCode);

            if (parseResult.isSuccessful() && parseResult.getResult().isPresent()) {
                CompilationUnit compilationUnit = parseResult.getResult().get();


                compilationUnit.findAll(MethodDeclaration.class).forEach(method -> {

                    String FEN = getFullyQualifiedName(method, compilationUnit);


                    Optional<Integer> startLine = method.getBegin().map(pos -> pos.line);
                    Optional<Integer> endLine = method.getEnd().map(pos -> pos.line);


                    if (startLine.isPresent() && endLine.isPresent()) {
                        methodsInfo.add(new MethodInfo(FEN, startLine.get(), endLine.get()));
                    }
                });
            } else {
                System.err.println("Failed to parse file: " + filePath);
                // remove this file
                File file = new File(filePath);
                if (file.exists()) {
                    file.delete();
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return methodsInfo;
    }


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
            // if file javaFile does not exist, return true
            if (!javaFile.toFile().exists()) {
                return false;
            }
            // delete the error log file
            File file = new File(errorLogFile);

            if (file.exists()) {
                file.delete();
            }


            ProcessBuilder builder = new ProcessBuilder(
                    "sh", "-c",
                    "javac -cp target/classes:src/main/java:$(cat /Users/dianshuliao/Documents/Research/Knowledge_Distillation_for_LLM_Test_Gen/UnitTestGeneration/saved_data/Evosuite_and_randoop/classpath.txt) " +
                            "-d target/test-classes " + "'" + javaFile.toString() + "'" +
                            " 2>> " + errorLogFile
            );
            builder.directory(new java.io.File(projectDir)); // Set working directory
            Process process = builder.start();
            int exitCode = process.waitFor(); // Wait for compilation to finish

            return exitCode != 0; // Non-zero exit code indicates a syntax error
        } catch (Exception e) {
            e.printStackTrace();
            return true; // Treat exceptions as syntax errors
        }
    }

    /**
     * Extracts unique error line numbers for a specific Java file from the syntax error log.
     *
     * @param javaFile        The name of the Java file (e.g., "StringUtils_splitByCharacterType_String_boolean_cfg_path_6.java").
     * @param syntaxErrorFile The path to the syntax error log file.
     * @return A list of unique line numbers where errors occurred in the given Java file.
     */
    public static List<Integer> extractErrorLinesFromLog(String javaFile, String syntaxErrorFile, String package_name) {
        Set<Integer> errorLineSet = new LinkedHashSet<>(); // Use LinkedHashSet to keep unique line numbers while preserving order

        // Construct the regex dynamically to match the specific Java file
//        String regex = ".*src/test/java/" + package_name.replace('.', '/') + '/' + Pattern.quote(javaFile) + ":(\\d+): error:.*";
//        Pattern pattern = Pattern.compile(regex);
        String regex = ".*src/test/java/" + package_name.replace('.', '/') + "(?:/.*)*" + '/' + Pattern.quote(javaFile) + ":(\\d+): error:.*";
        Pattern pattern = Pattern.compile(regex);



        try (BufferedReader reader = new BufferedReader(new FileReader(syntaxErrorFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.matches()) {
                    int lineNumber = Integer.parseInt(matcher.group(1));  // Extract the error line number
                    errorLineSet.add(lineNumber); // Add to Set (automatically removes duplicates)
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }



        return new ArrayList<>(errorLineSet); // Convert Set back to List
    }

    public static void reviseCode(String javaFileName, Path javaFilePath, String syntaxErrorFile, String package_name) {
        // Extract error line numbers from the syntax error log
        List<Integer> errorLines = extractErrorLinesFromLog(javaFileName, syntaxErrorFile,package_name);

        // if errorLines is empty, errorLines is all the lines in the file ！！！！！！！！！！！
        if (errorLines.isEmpty()) {
            try {
                List<String> lines = Files.readAllLines(javaFilePath);
                for (int i = 0; i < lines.size(); i++) {
                    errorLines.add(i + 1);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Get method information for the Java file
        List<MethodInfo> methodsInfo = getMethodsFromJavaFile(javaFilePath.toString());
        Set<List<Integer>> uniqueRanges = new HashSet<>();  // Using Set to store unique ranges

        for (int errorLine : errorLines) {
            boolean foundMethod = false;
            for (MethodInfo methodInfo : methodsInfo) {
                if (errorLine >= methodInfo.startLine && errorLine <= methodInfo.endLine) {
                    uniqueRanges.add(Arrays.asList(methodInfo.startLine, methodInfo.endLine));
                    foundMethod = true;
                    break;
                }
            }
            // If the error is not inside a method, assume it's an import statement or other syntax issue
            if (!foundMethod) {
                uniqueRanges.add(Arrays.asList(errorLine, errorLine));
            }
        }

        // Convert Set<List<Integer>> back to List<int[]>
        List<int[]> rangesToDelete = new ArrayList<>();
        for (List<Integer> range : uniqueRanges) {
            rangesToDelete.add(new int[]{range.get(0), range.get(1)});
        }

        // Remove erroneous code from the file
        try {
            removeCodeInOriginalFile(javaFilePath.toString(), rangesToDelete);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Failed to process file: " + javaFilePath);
        }
    }


    public static boolean containsTestAnnotation(Path javaFilePath) {
        try {
            List<String> lines = Files.readAllLines(javaFilePath);
            for (String line : lines) {
                if ((line.contains("@Test")) || (line.contains("@org.junit.Test"))) {
                    return true; // File contains @Test annotation
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false; // No @Test annotation found
    }

    public static void remove_all_syntax_error_code(String testCodeDir, String Project_Basic_Dir, String syntaxErrorFile, String package_name) {
        try {
            List<Path> javaFiles = getJavaFiles(testCodeDir); // Get all Java files
            int count = 0;
            for (Path javaFilePath : javaFiles) {
                if (javaFilePath.getFileName().toString().equals("sym_CharsToNameCanonicalizer_mergeChild_TableInfo_cfg_path_1_Test.java")) {
                    int a = 1;
                }
                String javaFileName = javaFilePath.getFileName().toString();
                System.out.println("Processing file " + count + " of " + javaFiles.size() + ": " + javaFileName);
                while (hasSyntaxError(javaFilePath, Project_Basic_Dir, syntaxErrorFile)) {
                    System.out.println("Syntax error detected in: " + javaFileName);
                    reviseCode(javaFileName, javaFilePath, syntaxErrorFile, package_name);
                }
                count++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }



        try {
            List<Path> javaFiles = getJavaFiles(testCodeDir); // Get all Java files
            for (Path javaFilePath : javaFiles) {
                if (!containsTestAnnotation(javaFilePath)) {
                    Files.delete(javaFilePath); // Delete file if it does not contain @Test
                    System.out.println("Deleted: " + javaFilePath);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static List<Path> getFileNamesFromCsv(Path csvPath) throws IOException {
        List<Path> filePaths = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(csvPath)) {
            String headerLine = reader.readLine();
            if (headerLine == null) {
                return filePaths; // 空文件
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

    public static void remove_all_syntax_error_code_by_selecting_file_after_refinement(String Project_Basic_Dir, String syntaxErrorFile, String package_name, String filesWithSyntaxErrorCsv) throws IOException {



        List<Path> javaFiles = getFileNamesFromCsv(Paths.get(filesWithSyntaxErrorCsv));


        int count = 0;
        for (Path javaFilePath : javaFiles) {

            String javaFileName = javaFilePath.getFileName().toString();
            System.out.println("Processing file " + count + " of " + javaFiles.size() + ": " + javaFileName);
            while (hasSyntaxError(javaFilePath, Project_Basic_Dir, syntaxErrorFile)) {
                System.out.println("Syntax error detected in: " + javaFileName);
                reviseCode(javaFileName, javaFilePath, syntaxErrorFile, package_name);
            }
            count++;
        }


        try {
            for (Path javaFilePath : javaFiles) {
                if (!containsTestAnnotation(javaFilePath)) {
                    Files.delete(javaFilePath); // Delete file if it does not contain @Test
                    System.out.println("Deleted: " + javaFilePath);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
