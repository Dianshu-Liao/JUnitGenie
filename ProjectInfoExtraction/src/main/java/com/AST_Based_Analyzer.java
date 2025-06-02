package com;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ParserConfiguration;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.*;
import com.github.javaparser.ast.comments.Comment;
import com.github.javaparser.ast.nodeTypes.NodeWithModifiers;
import com.github.javaparser.ast.type.ClassOrInterfaceType;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import com.Config;
import com.github.javaparser.resolution.types.ResolvedType;
import com.github.javaparser.symbolsolver.JavaSymbolSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.CombinedTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.JarTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.JavaParserTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.ReflectionTypeSolver;

public class AST_Based_Analyzer {

    // 辅助方法：尝试解析一个类型得到其 fully qualified name
    private static String resolveFQN(ClassOrInterfaceType type) {
        try {
            ResolvedType resolved = type.resolve();
            if (resolved.isReferenceType()) {
                return resolved.asReferenceType().getQualifiedName();
            } else {
                return type.toString();
            }
        } catch (Exception e) {
            return type.toString();
        }
    }


    private static void extractClassMembers(CompilationUnit compilationUnit, List<String[]> resultRows) {
        compilationUnit.findAll(ClassOrInterfaceDeclaration.class).forEach(cls -> {
            String classFqn = cls.getFullyQualifiedName().orElse("UnknownClass");
            String classComment = cls.getComment().map(Comment::getContent).orElse("No Comment").trim();

            // 判断是 Interface / Abstract Class / Class
            String type;
            if (cls.isInterface()) {
                type = "Interface";
            } else if (cls.isAbstract()) {
                type = "Abstract Class";
            } else {
                type = "Class";
            }

            String modifiers = cls.getModifiers().toString().replace("[", "").replace("]", "");
            if (modifiers.equals("")) {
                modifiers = "default";
            }

            // 针对类级别，抽取 extends 与 implements 信息
            String classExtends, implementsStr;
            if (cls.isInterface()) {
                // 对于接口，接口可以扩展其他接口
                classExtends = cls.getExtendedTypes().isEmpty() ? "" :
                        cls.getExtendedTypes().stream()
                                .map(et -> resolveFQN(et))
                                .reduce((a, b) -> a + ";" + b).orElse("");
                implementsStr = ""; // 接口没有 implements 关键字
            } else {
                classExtends = cls.getExtendedTypes().isEmpty() ? "" :
                        cls.getExtendedTypes().stream()
                                .map(et -> resolveFQN(et))
                                .reduce((a, b) -> a + ";" + b).orElse("");
                implementsStr = cls.getImplementedTypes().isEmpty() ? "" :
                        cls.getImplementedTypes().stream()
                                .map(it -> resolveFQN(it))
                                .reduce((a, b) -> a + ";" + b).orElse("");
            }
            resultRows.add(new String[]{
                    classFqn,
                    type,
                    classComment,
                    type + " do not obtain Source Code",
                    "No return type",
                    modifiers,
                    classExtends,
                    implementsStr
            });

            // 递归抽取内部成员
            extractClassMembersRecursively(cls, classFqn, resultRows);
        });

        // 处理顶层枚举
        extractTopLevelEnums(compilationUnit, resultRows);
    }

    private static void extractTopLevelEnums(CompilationUnit compilationUnit, List<String[]> resultRows) {
        compilationUnit.findAll(EnumDeclaration.class).forEach(enumDeclaration -> {
            String enumFqn = enumDeclaration.getFullyQualifiedName().orElse("UnknownEnum");
            extractEnumMembers(enumDeclaration, enumFqn, resultRows);
        });
    }

    private static void extractParameterInfo(CallableDeclaration<?> callable, String callableFEN, List<String[]> resultRows) {
        List<Parameter> parameters = callable.getParameters();

        for (int i = 0; i < parameters.size(); i++) {
            Parameter parameter = parameters.get(i);

            String parameterName = parameter.getNameAsString();
            String parameterFEN = callableFEN + "." + parameterName;
            String parameterType = "Parameter_" + (i + 1);
            String parameterComment = "Belong to " + callableFEN;

            resultRows.add(new String[]{
                    parameterFEN,
                    parameterType,
                    parameterComment,
                    "Parameter has not source code",
                    "No return type",
                    "No modifier",
                    "method/parameter/variable has no extends",
                    "method/parameter/variable has no implements"
            });
        }
    }

    private static void extractClassMembersRecursively(ClassOrInterfaceDeclaration cls, String currentClassFqn, List<String[]> resultRows) {
        // 处理字段
        cls.getFields().forEach(field -> {
            field.getVariables().forEach(variable -> {
                String fieldFqn = currentClassFqn + "." + variable.getNameAsString();
                String fieldComment = field.getComment().map(Comment::getContent).orElse("No Comment").trim();
                String fieldSource = field.clone().removeComment().toString().trim();

                String modifiers = field.getModifiers().toString().replace("[", "").replace("]", "");
                if (modifiers.equals("")) {
                    modifiers = "default";
                }
                resultRows.add(new String[]{
                        fieldFqn,
                        "Field",
                        fieldComment,
                        fieldSource,
                        "No return type",
                        modifiers,
                        "method/parameter/variable has no extends",
                        "method/parameter/variable has no implements"
                });
            });
        });

        // 处理方法
        cls.getMethods().forEach(method -> {
            String methodFqn = getFullyQualifiedName(method, currentClassFqn);
            String methodComment = method.getComment().map(Comment::getContent).orElse("No Comment").trim();
            String methodSource = method.clone().removeComment().toString().trim();
            String returnType = convertGenericType(method.getType().asString(), method);

            String methodType;
            if (cls.isInterface() || method.isAbstract()) {
                methodType = "Abstract Method";
            } else {
                methodType = "Method";
            }

            String modifiers = method.getModifiers().toString().replace("[", "").replace("]", "");
            if (modifiers.equals("")) {
                modifiers = "default";
            }
            resultRows.add(new String[]{
                    methodFqn,
                    methodType,
                    methodComment,
                    methodSource,
                    returnType,
                    modifiers,
                    "method/parameter/variable has no extends",
                    "method/parameter/variable has no implements"
            });

            extractParameterInfo(method, methodFqn, resultRows);
        });

        // 处理构造器
        cls.getConstructors().forEach(constructor -> {
            String constructorFqn = getFullyQualifiedNameForConstructor(constructor, currentClassFqn);
            String constructorComment = constructor.getComment().map(Comment::getContent).orElse("No Comment").trim();
            String constructorSource = constructor.clone().removeComment().toString().trim();

            String modifiers = constructor.getModifiers().toString().replace("[", "").replace("]", "");
            if (modifiers.equals("")) {
                modifiers = "default";
            }
            resultRows.add(new String[]{
                    constructorFqn,
                    "Constructor",
                    constructorComment,
                    constructorSource,
                    "No return type",
                    modifiers,
                    "method/parameter/variable has no extends",
                    "method/parameter/variable has no implements"
            });

            extractParameterInfo(constructor, constructorFqn, resultRows);
        });

        // 处理嵌套的类、接口、枚举（此处针对class level节点抽取extends/implements）
        cls.getMembers().stream()
                .filter(member -> member instanceof ClassOrInterfaceDeclaration || member instanceof EnumDeclaration)
                .forEach(member -> {
                    String nestedClassFqn;
                    String nestedType;
                    String nestedClassComment;
                    String nestedExtends;
                    String nestedImplements;

                    if (member instanceof EnumDeclaration) {
                        EnumDeclaration enumMember = (EnumDeclaration) member;
                        nestedClassFqn = currentClassFqn + "$" + enumMember.getNameAsString();
                        nestedType = "Enum";
                        nestedClassComment = enumMember.getComment().map(Comment::getContent).orElse("No Comment").trim();
                        // 枚举通常不显式继承其他类
                        nestedExtends = "enum has no extends";
                        nestedImplements = enumMember.getImplementedTypes().isEmpty() ? "" :
                                enumMember.getImplementedTypes().stream()
                                        .map(it -> resolveFQN(it))
                                        .reduce((a, b) -> a + ";" + b).orElse("");
                    } else if (member instanceof ClassOrInterfaceDeclaration) {
                        ClassOrInterfaceDeclaration classMember = (ClassOrInterfaceDeclaration) member;
                        nestedClassFqn = currentClassFqn + "$" + classMember.getNameAsString();
                        nestedType = classMember.isInterface() ? "Interface" : "Class";
                        nestedClassComment = classMember.getComment().map(Comment::getContent).orElse("No Comment").trim();
                        if (classMember.isInterface()) {
                            nestedExtends = classMember.getExtendedTypes().isEmpty() ? "" :
                                    classMember.getExtendedTypes().stream()
                                            .map(et -> resolveFQN(et))
                                            .reduce((a, b) -> a + ";" + b).orElse("");
                            nestedImplements = "";
                        } else {
                            nestedExtends = classMember.getExtendedTypes().isEmpty() ? "" :
                                    classMember.getExtendedTypes().stream()
                                            .map(et -> resolveFQN(et))
                                            .reduce((a, b) -> a + ";" + b).orElse("");
                            nestedImplements = classMember.getImplementedTypes().isEmpty() ? "" :
                                    classMember.getImplementedTypes().stream()
                                            .map(it -> resolveFQN(it))
                                            .reduce((a, b) -> a + ";" + b).orElse("");
                        }
                    } else {
                        // 其他情况不处理
                        return;
                    }

                    resultRows.add(new String[]{
                            nestedClassFqn,
                            nestedType,
                            nestedClassComment,
                            nestedType + " do not obtain Source Code",
                            "No return type",
                            ((NodeWithModifiers<?>) member).getModifiers().toString().replace("[", "").replace("]", ""),
                            nestedExtends,
                            nestedImplements
                    });

                    // 递归处理嵌套成员（仅对 ClassOrInterfaceDeclaration 递归）
                    if (member instanceof ClassOrInterfaceDeclaration) {
                        extractClassMembersRecursively((ClassOrInterfaceDeclaration) member, nestedClassFqn, resultRows);
                    } else if (member instanceof EnumDeclaration) {
                        extractEnumMembers((EnumDeclaration) member, nestedClassFqn, resultRows);
                    }
                });
    }

    private static void extractEnumMembers(EnumDeclaration enumDeclaration, String enumFqn, List<String[]> resultRows) {
        String enumComment = enumDeclaration.getComment().map(Comment::getContent).orElse("No Comment").trim();
        String modifiers = enumDeclaration.getModifiers().toString().replace("[", "").replace("]", "");
        if (modifiers.equals("")) {
            modifiers = "default";
        }
        // 对于枚举，extends 固定提示，implements 根据实现接口获取
        String enumExtends = "enum has no extends";
        String enumImplements = enumDeclaration.getImplementedTypes().isEmpty() ? "" :
                enumDeclaration.getImplementedTypes().stream()
                        .map(it -> resolveFQN(it))
                        .reduce((a, b) -> a + ";" + b).orElse("");

        resultRows.add(new String[]{
                enumFqn,
                "Enum",
                enumComment,
                "Enum do not obtain Source Code",
                "No return type",
                modifiers,
                enumExtends,
                enumImplements
        });

        // 处理枚举常量
        String finalModifiers = modifiers;
        enumDeclaration.getEntries().forEach(entry -> {
            String entryFqn = enumFqn + "." + entry.getNameAsString();
            String entryComment = entry.getComment().map(Comment::getContent).orElse("No Comment").trim();
            String entrySource = entry.clone().removeComment().toString().trim();
            resultRows.add(new String[]{
                    entryFqn,
                    "Enum Constant",
                    entryComment,
                    entrySource,
                    "No return type",
                    finalModifiers,
                    "method/parameter/variable has no extends",
                    "method/parameter/variable has no implements"
            });
        });

        // 处理枚举中方法
        String finalModifiers1 = modifiers;
        enumDeclaration.findAll(MethodDeclaration.class).forEach(method -> {
            String methodFqn = getFullyQualifiedName(method, enumFqn);
            String methodComment = method.getComment().map(Comment::getContent).orElse("No Comment").trim();
            String methodSource = method.clone().removeComment().toString().trim();
            String returnType = convertGenericType(method.getType().asString(), method);
            resultRows.add(new String[]{
                    methodFqn,
                    "Method",
                    methodComment,
                    methodSource,
                    returnType,
                    finalModifiers1,
                    "method/parameter/variable has no extends",
                    "method/parameter/variable has no implements"
            });

            extractParameterInfo(method, methodFqn, resultRows);
        });

        // 处理枚举构造器
        String finalModifiers2 = modifiers;
        enumDeclaration.findAll(ConstructorDeclaration.class).forEach(constructor -> {
            String constructorFqn = getFullyQualifiedNameForConstructor(constructor, enumFqn);
            String constructorComment = constructor.getComment().map(Comment::getContent).orElse("No Comment").trim();
            String constructorSource = constructor.clone().removeComment().toString().trim();
            resultRows.add(new String[]{
                    constructorFqn,
                    "Constructor",
                    constructorComment,
                    constructorSource,
                    "No return type",
                    finalModifiers2,
                    "method/parameter/variable has no extends",
                    "method/parameter/variable has no implements"
            });
            extractParameterInfo(constructor, constructorFqn, resultRows);
        });
    }

    private static String convertGenericType(String rawType, MethodDeclaration method) {
        Map<String, String> genericTypeMap = new HashMap<>();

        // 1. 从包含类提取泛型
        ClassOrInterfaceDeclaration containingClass = method.findAncestor(ClassOrInterfaceDeclaration.class).orElse(null);
        if (containingClass != null) {
            containingClass.getTypeParameters().forEach(typeParameter -> {
                String genericName = typeParameter.getNameAsString();
                String boundType = typeParameter.getTypeBound().isEmpty() ? "Object" : typeParameter.getTypeBound().get(0).toString();
                genericTypeMap.put(genericName, boundType);
            });
        }

        // 2. 从方法中提取泛型
        method.getTypeParameters().forEach(typeParameter -> {
            String genericName = typeParameter.getNameAsString();
            String boundType = typeParameter.getTypeBound().isEmpty() ? "Object" : typeParameter.getTypeBound().get(0).toString();
            genericTypeMap.put(genericName, boundType);
        });

        boolean isArray = rawType.endsWith("[]");
        String baseType = isArray ? rawType.substring(0, rawType.length() - 2) : rawType;

        baseType = removeGenerics(baseType);
        baseType = genericTypeMap.getOrDefault(baseType, baseType);

        return isArray ? baseType + "[]" : baseType;
    }

    private static String getFullyQualifiedName(MethodDeclaration method, String currentClassFqn) {
        Map<String, String> genericTypeMap = new HashMap<>();

        // 1. 从包含类提取泛型
        ClassOrInterfaceDeclaration containingClass = method.findAncestor(ClassOrInterfaceDeclaration.class).orElse(null);
        if (containingClass != null) {
            containingClass.getTypeParameters().forEach(typeParameter -> {
                String genericName = typeParameter.getNameAsString();
                String boundType = typeParameter.getTypeBound().isEmpty() ? "Object" : typeParameter.getTypeBound().get(0).toString();
                genericTypeMap.put(genericName, boundType);
            });
        }

        // 2. 从方法中提取泛型
        method.getTypeParameters().forEach(typeParameter -> {
            String genericName = typeParameter.getNameAsString();
            String boundType = typeParameter.getTypeBound().isEmpty() ? "Object" : typeParameter.getTypeBound().get(0).toString();
            genericTypeMap.put(genericName, boundType);
        });

        String methodName = method.getNameAsString();
        StringBuilder parameterTypes = new StringBuilder();

        method.getParameters().forEach(param -> {
            String paramType = param.getType().asString();
            boolean isArray = paramType.endsWith("[]");
            String baseType = isArray ? paramType.substring(0, paramType.length() - 2) : paramType;
            baseType = removeGenerics(baseType);
            baseType = genericTypeMap.getOrDefault(baseType, baseType);
            paramType = isArray ? baseType + "[]" : baseType;
            paramType = paramType.replaceAll("\\<.*?\\>", "");
            if (param.isVarArgs()) {
                paramType += "[]";
            }
            parameterTypes.append(paramType).append(",");
        });

        if (parameterTypes.length() > 0) {
            parameterTypes.setLength(parameterTypes.length() - 1);
        }

        return String.format("%s.%s(%s)", currentClassFqn, methodName, parameterTypes);
    }

    private static String removeGenerics(String type) {
        while (type.contains("<")) {
            type = type.replaceAll("\\<[^<>]*\\>", "");
        }
        return type.trim();
    }

    private static String getFullyQualifiedNameForConstructor(ConstructorDeclaration constructor, String currentClassFqn) {
        Map<String, String> genericTypeMap = new HashMap<>();

        // 1. 从包含类提取泛型
        ClassOrInterfaceDeclaration containingClass = constructor.findAncestor(ClassOrInterfaceDeclaration.class).orElse(null);
        if (containingClass != null) {
            containingClass.getTypeParameters().forEach(typeParameter -> {
                String genericName = typeParameter.getNameAsString();
                String boundType = typeParameter.getTypeBound().isEmpty() ? "Object" : typeParameter.getTypeBound().get(0).toString();
                genericTypeMap.put(genericName, boundType);
            });
        }

        // 2. 从构造器中提取泛型
        constructor.getTypeParameters().forEach(typeParameter -> {
            String genericName = typeParameter.getNameAsString();
            String boundType = typeParameter.getTypeBound().isEmpty() ? "Object" : typeParameter.getTypeBound().get(0).toString();
            genericTypeMap.put(genericName, boundType);
        });

        StringBuilder parameterTypes = new StringBuilder();
        constructor.getParameters().forEach(param -> {
            String paramType = param.getType().asString();
            boolean isArray = paramType.endsWith("[]");
            String baseType = isArray ? paramType.substring(0, paramType.length() - 2) : paramType;
            baseType = removeGenerics(baseType);
            baseType = genericTypeMap.getOrDefault(baseType, baseType);
            paramType = isArray ? baseType + "[]" : baseType;
            paramType = paramType.replaceAll("\\<.*?\\>", "");
            if (param.isVarArgs()) {
                paramType += "[]";
            }
            parameterTypes.append(paramType).append(",");
        });

        if (parameterTypes.length() > 0) {
            parameterTypes.setLength(parameterTypes.length() - 1);
        }

        return String.format("%s.<init>(%s)", currentClassFqn, parameterTypes);
    }

    public static void handle_all_java_files_in_a_directory(String projectDir, String outputCsv, String errorLogPath) throws IOException {
        // 更新表头，增加 extends 与 implements 两列
        List<String[]> resultRows = new ArrayList<>();
        resultRows.add(new String[]{"FEN", "Type", "Comment", "Source Code", "Return Type", "Modifier", "class_extends", "implements"});

        List<String> errorFiles = new ArrayList<>();

        Files.walk(Paths.get(projectDir))
                .filter(Files::isRegularFile)
                .filter(path -> path.toString().endsWith(".java"))
                .forEach(path -> handle_a_java_file(projectDir, path.toString(), resultRows, errorFiles));

        try (FileWriter writer = new FileWriter(outputCsv)) {
            for (String[] row : resultRows) {
                writer.write(String.join(",", escapeCsv(row)) + "\n");
            }
        }

        try (FileWriter errorLogWriter = new FileWriter(errorLogPath)) {
            for (String errorFile : errorFiles) {
                errorLogWriter.write(errorFile + "\n");
            }
        }
    }

    private static void handle_a_java_file(String projectDir, String filePath, List<String[]> resultRows, List<String> errorFiles) {
        try {
            // 从filePath中找到src目录，然后把src目录作为源码目录


            // 配置符号求解器：把 JDK 和项目源码的类型都添加进去
            CombinedTypeSolver typeSolver = new CombinedTypeSolver();
            typeSolver.add(new ReflectionTypeSolver()); // JDK 类

            List<String> jarPaths = Files.readAllLines(Paths.get(projectDir.split("/src/main/java")[0] + "/jar_dependencies.txt"));
            for (String jarPath : jarPaths) {
                jarPath = jarPath.trim();
                if (!jarPath.isEmpty()) {
                    try {
                         typeSolver.add(new JarTypeSolver(new File(jarPath)));
                    } catch (Exception e) {
                        System.err.println("Failed to add jar: " + jarPath);
                        e.printStackTrace();
                    }
                }
            }

//            typeSolver.add(new JarTypeSolver(new File("/Users/dianshuliao/.m2/repository/com/fasterxml/jackson/core/jackson-core/2.19.0-SNAPSHOT/jackson-core-2.19.0-20250301.215542-43.jar")));
//            typeSolver.add(new JarTypeSolver(new File("/Users/dianshuliao/.m2/repository/com/fasterxml/jackson/core/jackson-databind/2.19.0-SNAPSHOT/jackson-databind-2.19.0-20250314.000111-190.jar")));
            typeSolver.add(new JavaParserTypeSolver(new File(projectDir.split("/src/main/java")[0] + "/src/main/java"))); // 指定源码目录，根据你的项目结构调整

            JavaSymbolSolver symbolSolver = new JavaSymbolSolver(typeSolver);
            ParserConfiguration config = new ParserConfiguration().setSymbolResolver(symbolSolver);
            JavaParser parser = new JavaParser(config);
            String sourceCode = new String(Files.readAllBytes(Paths.get(filePath)));


//
//            String sourceCode = new String(Files.readAllBytes(Paths.get(filePath)));
//            JavaParser parser = new JavaParser();
            ParseResult<CompilationUnit> parseResult = parser.parse(sourceCode);

            if (parseResult.isSuccessful() && parseResult.getResult().isPresent()) {
                extractClassMembers(parseResult.getResult().get(), resultRows);
            } else {
                errorFiles.add(filePath);
            }
        } catch (IOException e) {
            errorFiles.add(filePath);
        }
    }

    private static String[] escapeCsv(String[] row) {
        String[] escaped = new String[row.length];
        for (int i = 0; i < row.length; i++) {
            escaped[i] = "\"" + row[i].replace("\"", "\"\"") + "\"";
        }
        return escaped;
    }
}
