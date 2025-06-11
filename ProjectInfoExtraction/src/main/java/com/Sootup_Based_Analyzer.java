package com;

import com.github.javaparser.ast.CompilationUnit;
import fj.Unit;
import sootup.codepropertygraph.ast.AstCreator;
import sootup.codepropertygraph.cfg.CfgCreator;
import sootup.codepropertygraph.propertygraph.PropertyGraph;
import sootup.codepropertygraph.propertygraph.nodes.PropertyGraphNode;
import sootup.core.frontend.BodySource;
import sootup.core.inputlocation.AnalysisInputLocation;
import sootup.core.jimple.common.stmt.Stmt;
import sootup.core.model.*;
import sootup.core.signatures.FieldSignature;
import sootup.core.signatures.MethodSignature;
import sootup.core.types.ClassType;
import sootup.core.views.View;
import sootup.java.bytecode.frontend.inputlocation.PathBasedAnalysisInputLocation;
import sootup.java.core.views.JavaView;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.io.File;
import sootup.core.types.Type;


import java.io.File;
import java.util.Optional;
import com.Config;


public class Sootup_Based_Analyzer {




    public static void extract_info_from_a_class_file(String path, String class_name, String outputCsvPath, String error_log_path) {


        Path pathToBinary = Paths.get(path);
        AnalysisInputLocation inputLocation = PathBasedAnalysisInputLocation.create(pathToBinary, SourceType.Application);
        View view = new JavaView(inputLocation);
        ClassType classType = view.getIdentifierFactory().getClassType(class_name);

        try {
            Optional<SootClass> sootClassOptional = (Optional<SootClass>) view.getClass(classType);

            // ???????????????????
            File file = new File(outputCsvPath);
            boolean file_exists = file.exists();

            // ?????????
            try (FileWriter csvWriter = new FileWriter(outputCsvPath, true)) {
                if (!file_exists) {
                    csvWriter.append("FEN,Type,class,sub_signature,cfg_dot\n");
                }

                if (sootClassOptional.isPresent()) {
                    SootClass sootClass = sootClassOptional.get();

                    extractFieldInfo(sootClass, csvWriter);
                    extractMethodInfo(sootClass, csvWriter);
                } else {
                    System.out.println("Class not found: " + classType);
                }
            }
        } catch (NoSuchMethodError e) {
            handleError(e, class_name, error_log_path, "NoSuchMethodError encountered for class: ");
        } catch (Exception e) {
            handleError(e, class_name, error_log_path, "Error processing class: ");
        }
    }

    private static void extractFieldInfo(SootClass sootClass, FileWriter csvWriter) throws Exception {
        Set<SootField> fields = (Set<SootField>) sootClass.getFields();
        for (SootField field : fields) {

            FieldSignature fieldSignature = field.getSignature();

            String field_belonged_class = fieldSignature.getDeclClassType().toString();
            String field_sub_signature = fieldSignature.getSubSignature().toString();
            String cfg_dot = "field with no cfg";
            // ????????
            String[] subSignatureParts = field_sub_signature.split("\\s+"); // ???????????
            String fieldName = subSignatureParts[subSignatureParts.length - 1]; // ????????

            String FEN = field_belonged_class + '.' + fieldName; // ?? FEN
            csvWriter.append(String.format(
                    "\"%s\",\"%s\",\"%s\",\"%s\",\"%s\"\n",
                    FEN,
                    "field",
                    field_belonged_class,
                    field_sub_signature,
                    cfg_dot.replace("\"", "\"\"")
            ));

        }
    }

    public static String get_method_FEN(String method_belonged_class, String method_sub_signature) {

        // ??????????????????
        String simplifiedMethodSubSignature = method_sub_signature.substring(method_sub_signature.indexOf(' ') + 1); // ??????

        // ?????
        String methodName = simplifiedMethodSubSignature.substring(0, simplifiedMethodSubSignature.indexOf('('));

        // ?????????
        String parameterList = simplifiedMethodSubSignature.substring(simplifiedMethodSubSignature.indexOf('(') + 1, simplifiedMethodSubSignature.indexOf(')'));
        String[] parameters = parameterList.isEmpty() ? new String[0] : parameterList.split(",");

        StringBuilder processedParameters = new StringBuilder();
        for (String parameter : parameters) {
            String simpleName = parameter.trim().substring(parameter.lastIndexOf('.') + 1); // ?? FQN????????
            processedParameters.append(simpleName).append(",");
        }

        // ???????
        if (processedParameters.length() > 0) {
            processedParameters.setLength(processedParameters.length() - 1);
        }

        // ???? FEN
        String FEN = String.format("%s.%s(%s)", method_belonged_class, methodName, processedParameters);
        return FEN;
    }

    private static void extractParameterInfo(SootMethod method, String methodFEN, String className, FileWriter csvWriter) throws IOException {
        List<Type> parameterTypes = method.getParameterTypes();


        for (int i = 0; i < parameterTypes.size(); i++) {
            Type parameterType = parameterTypes.get(i);
            // ?????????paramX
            String parameterName = "param" + (i + 1);

            // ??????
            String parameterFEN = "Belong to " + methodFEN;
            String parameterSubSignature = parameterType.toString();

            // ?? CSV
            csvWriter.append(String.format(
                    "\"%s\",\"%s\",\"%s\",\"%s\",\"%s\"\n",
                    parameterFEN,
                    "Parameter_" + (i + 1),
                    className,
                    parameterSubSignature,
                    "Parameter does not obtain cfg"
            ));
        }
    }


    private static void extractMethodInfo(SootClass sootClass, FileWriter csvWriter) throws IOException {
        Set<SootMethod> methods = (Set<SootMethod>) sootClass.getMethods();

        for (SootMethod method : methods) {



            MethodSignature methodSignature = method.getSignature();
            String method_belonged_class = methodSignature.getDeclClassType().toString();
            String method_sub_signature = methodSignature.getSubSignature().toString();
            String FEN = get_method_FEN(method_belonged_class, method_sub_signature);


            SootMethod sootMethod = sootClass.getMethod(methodSignature.getSubSignature()).get();
            CfgCreator cfgCreator = new CfgCreator();
            PropertyGraph cfgGraph = cfgCreator.createGraph(sootMethod);

            String cfg_dot = cfgGraph.toDotGraph();

            cfg_dot = cfg_dot.replace("\n\trankdir=TB;", "")
                    .replace("\n\tnode [style=filled, shape=record];", "")
                    .replace("\n\tedge [style=filled]", "")
                    .replace(", fillcolor=\"lightblue\"", "")
                    .replace(", color=\"black\", fontcolor=\"black\"", "")
                    .replace("&lt;", "<")
                    .replace("&gt;", ">");

            csvWriter.append(String.format(
                    "\"%s\",\"%s\",\"%s\",\"%s\",\"%s\"\n",
                    FEN,
                    "Method",
                    method_belonged_class,
                    method_sub_signature,
                    cfg_dot.replace("\"", "\"\"")
            ));

            extractParameterInfo(method, FEN, method_belonged_class, csvWriter);

        }

    }

    private static void handleError(Throwable e, String class_name, String error_log_path, String errorMessage) {
        System.err.println(errorMessage + class_name);
        e.printStackTrace();
        try (FileWriter errorLogWriter = new FileWriter(error_log_path, true)) {
            errorLogWriter.append(errorMessage + class_name + "\n");
        } catch (IOException ioException) {
            System.err.println("Error writing to error log file: " + ioException.getMessage());
        }
    }

    // find all classes in a project ?input a project path, output a list of all classes names?
    public static List<String> find_all_classes_in_a_project(String project_classes_dir) {
        List<String> all_classes = null;
        try {
            all_classes = Files.walk(Paths.get(project_classes_dir))
                    .filter(Files::isRegularFile)
                    .map(Path::toString)
                    .filter(f -> f.endsWith(".class"))
                    .map(f -> f.replace(project_classes_dir, ""))
                    .map(f -> f.replace("/", "."))
                    .map(f -> f.replace(".class", ""))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return all_classes;
    }

    // extract cfgs from all classes in a project
    public static void extract_info_from_all_classes_in_a_project(String project_classes_dir, String outputCsvPath, String error_log_path) {
        List<String> all_classes = find_all_classes_in_a_project(project_classes_dir);
        for (String class_name : all_classes) {

            extract_info_from_a_class_file(project_classes_dir, class_name, outputCsvPath, error_log_path);

        }
    }


}
