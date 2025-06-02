package org.apache.commons.lang3.exception;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.Test;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class exception_ExceptionUtils_printRootCauseStackTrace_Throwable_PrintStream_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testPrintRootCauseStackTrace_withNullThrowable() {
        // Arrange
        Throwable throwable = null;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);

        // Act
        try {
            ExceptionUtils.printRootCauseStackTrace(throwable, printStream);
        } catch (Exception e) {
            // Handle exception if necessary
        }

        // Assert
        String output = outputStream.toString();
        assert(output.isEmpty()); // Expecting no output for null throwable
    }

    @Test(timeout = 4000)
    public void testPrintRootCauseStackTrace_withValidThrowable() {
        // Arrange
        Throwable throwable = new Exception("Test Exception");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);

        // Act
        try {
            ExceptionUtils.printRootCauseStackTrace(throwable, printStream);
        } catch (Exception e) {
            // Handle exception if necessary
        }

        // Assert
        String output = outputStream.toString();
        assert(output.contains("Test Exception")); // Expecting output to contain the exception message
    }

    @Test(timeout = 4000)
    public void testPrintRootCauseStackTrace_withNullPrintStream() {
        // Arrange
        Throwable throwable = new Exception("Test Exception");
        PrintStream printStream = null;

        // Act
        try {
            ExceptionUtils.printRootCauseStackTrace(throwable, printStream);
        } catch (NullPointerException e) {
            // Assert
            assert("printStream".equals(e.getMessage())); // Expecting NullPointerException with specific message
        }
    }

}