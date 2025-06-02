package org.apache.commons.lang3.exception;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.Test;
import java.io.PrintWriter;
import java.io.StringWriter;

public class exception_ExceptionUtils_printRootCauseStackTrace_Throwable_PrintWriter_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testPrintRootCauseStackTrace() {
        // Arrange
        Throwable throwable = new Exception("Root cause exception");
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);

        // Act
        try {
            ExceptionUtils.printRootCauseStackTrace(throwable, printWriter);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }

        // Assert
        String result = stringWriter.toString();
        assert !result.isEmpty() : "Expected non-empty stack trace output";
    }

    @Test(timeout = 4000)
    public void testPrintRootCauseStackTraceWithNullThrowable() {
        // Arrange
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);

        // Act
        try {
            ExceptionUtils.printRootCauseStackTrace(null, printWriter);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }

        // Assert
        // No exception should be thrown and nothing should be printed
        assert stringWriter.toString().isEmpty() : "Expected empty output for null throwable";
    }

    @Test(timeout = 4000)
    public void testPrintRootCauseStackTraceWithNullPrintWriter() {
        // Arrange
        Throwable throwable = new Exception("Root cause exception");

        // Act
        try {
            ExceptionUtils.printRootCauseStackTrace(throwable, (PrintWriter) null);
        } catch (NullPointerException e) {
            // Expected exception
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }


}