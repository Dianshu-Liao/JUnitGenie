package com;
import java.io.File;

public class Config {
    public static final String CURRENT_DIR = System.getProperty("user.dir");

    // 上一级目录（也就是你想要的 Basic_Dir）
    public static final String BASE_DIR = new File(CURRENT_DIR).getParent();

    public static String Experiment_Result_Basic_Dir = BASE_DIR + "/experiment_results/Code_Knowledge_Base";

    public static String projectclassDir = "/target/classes/";

//    // for commons-codec
//    public static String Project_Basic_Dir = BASE_DIR + "/experiment_results/TenProjects/commons-codec-master";
//    public static String package_name = "org.apache.commons.codec";
//    public static String projectSrcDir = "/src/main/java/org/apache/commons/codec";
//    public static String testCodeDir = Project_Basic_Dir + "/src/test/java/org/apache/commons/codec";
//    public static String projectName = "commons-codec-master";
//    public static String syntaxErrorLog = Experiment_Result_Basic_Dir + "/syntax_error_log.txt";


//    // for jackson-databind
//    public static String Project_Basic_Dir = BASE_DIR + "/experiment_results/TenProjects/jackson-databind-2.19";
//    public static String package_name = "com.fasterxml.jackson.databind";
//    public static String projectSrcDir = "/src/main/java/com/fasterxml/jackson/databind";
//    public static String testCodeDir = Project_Basic_Dir + "/src/test/java/com/fasterxml/jackson/databind";
//    public static String projectName = "jackson-databind-2.19";
//    public static String syntaxErrorLog = Experiment_Result_Basic_Dir + "/syntax_error_log.txt";




//    // for commons-collections
//    public static String Project_Basic_Dir = BASE_DIR + "/experiment_results/TenProjects/commons-collections-master";
//    public static String package_name = "org.apache.commons.collections4";
//    public static String projectSrcDir = "/src/main/java/org/apache/commons/collections4";
//    public static String testCodeDir = Project_Basic_Dir + "/src/test/java/org/apache/commons/collections4";
//    public static String syntaxErrorLog = Experiment_Result_Basic_Dir + "/syntax_error_log.txt";


//    // for commons-compress
//    public static String Project_Basic_Dir = BASE_DIR + "/experiment_results/TenProjects/commons-compress-master";
//    public static String package_name = "org.apache.commons.compress";
//    public static String projectSrcDir = "/src/main/java/org/apache/commons/compress";
//    public static String testCodeDir = Project_Basic_Dir + "/src/test/java/org/apache/commons/compress";
//    public static String syntaxErrorLog = Experiment_Result_Basic_Dir + "/syntax_error_log.txt";

//    // for commons-csv
//    public static String Project_Basic_Dir = BASE_DIR + "/experiment_results/TenProjects/commons-csv-master";
//    public static String package_name = "org.apache.commons.csv";
//    public static String projectSrcDir = "/src/main/java/org/apache/commons/csv";
//    public static String testCodeDir = Project_Basic_Dir + "src/test/java/org/apache/commons/csv";
//    public static String syntaxErrorLog = Experiment_Result_Basic_Dir + "/syntax_error_log.txt";



//    // for jackson-core
//    public static String Project_Basic_Dir = BASE_DIR + "/experiment_results/TenProjects/jackson-core-2.19";
//    public static String package_name = "com.fasterxml.jackson.core";
//    public static String projectSrcDir = "/src/main/java/com/fasterxml/jackson/core";
//    public static String testCodeDir = Project_Basic_Dir + "/src/test/java/com/fasterxml/jackson/core";
//    public static String syntaxErrorLog = Experiment_Result_Basic_Dir + "/syntax_error_log.txt";

//    // for jackson-dataformat-xml
//    public static String Project_Basic_Dir = BASE_DIR + "/experiment_results/TenProjects/jackson-dataformat-xml-2.19";
//    public static String package_name = "com.fasterxml.jackson.dataformat.xml";
//    public static String projectSrcDir = "/src/main/java/com/fasterxml/jackson/dataformat/xml";
//    public static String testCodeDir = Project_Basic_Dir + "/src/test/java/com/fasterxml/jackson/dataformat/xml";
//    public static String syntaxErrorLog = Experiment_Result_Basic_Dir + "/syntax_error_log.txt";


//    // for apache-commons-jxpath
//    public static String Project_Basic_Dir = BASE_DIR + "/experiment_results/TenProjects/commons-jxpath-master";
//    public static String package_name = "org.apache.commons.jxpath";
//    public static String projectSrcDir = "/src/main/java/org/apache/commons/jxpath";
//    public static String testCodeDir = Project_Basic_Dir + "/src/test/java/org/apache/commons/jxpath";
//    public static String syntaxErrorLog = Experiment_Result_Basic_Dir + "/syntax_error_log.txt";
//

//    // for joad-time
//    public static String Project_Basic_Dir = BASE_DIR + "/experiment_results/TenProjects/joda-time-main";
//    public static String package_name = "org.joda.time";
//    public static String projectSrcDir = "/src/main/java/org/joda/time";
//    public static String testCodeDir = Project_Basic_Dir + "/src/test/java/org/joda/time";
//    public static String syntaxErrorLog = Experiment_Result_Basic_Dir + "/syntax_error_log.txt";


    // for commons-lang3
    public static String Project_Basic_Dir = BASE_DIR + "/experiment_results/TenProjects/commons-lang-master";
    public static String package_name = "org.apache.commons.lang3";
    public static String projectSrcDir = "/src/main/java/org/apache/commons/lang3";
    public static String testCodeDir = Project_Basic_Dir + "/src/test/java/org/apache/commons/lang3";
    public static String syntaxErrorLog = Experiment_Result_Basic_Dir + "/syntax_error_log.txt";


}
