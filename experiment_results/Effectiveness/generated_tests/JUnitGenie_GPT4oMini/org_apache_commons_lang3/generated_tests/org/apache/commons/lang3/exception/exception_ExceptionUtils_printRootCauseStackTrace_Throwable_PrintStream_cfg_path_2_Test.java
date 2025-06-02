package org.apache.commons.lang3.exception;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.Test;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.assertEquals;

public class exception_ExceptionUtils_printRootCauseStackTrace_Throwable_PrintStream_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testPrintRootCauseStackTraceWithNullThrowable() {
        // Arrange
        Throwable throwable = null;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);

        // Act
        try {
            ExceptionUtils.printRootCauseStackTrace(throwable, printStream);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }

        // Assert
        assertEquals("", outputStream.toString()); // Expecting no output for null throwable
    }

    @Test(timeout = 4000)
    public void testPrintRootCauseStackTraceWithValidThrowable() {
        // Arrange
        Throwable throwable = new Exception("Test Exception");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);

        // Act
        try {
            ExceptionUtils.printRootCauseStackTrace(throwable, printStream);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }

        // Assert
        String expectedOutput = "java.lang.Exception: Test Exception\n"; // Expected output format
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test(timeout = 4000)
    public void testPrintRootCauseStackTraceWithNullPrintStream() {
        // Arrange
        Throwable throwable = new Exception("Test Exception");
        PrintStream printStream = null;

        // Act
        try {
            ExceptionUtils.printRootCauseStackTrace(throwable, printStream);
        } catch (NullPointerException e) {
            // Assert that a NullPointerException is thrown
            assertEquals("printStream", e.getMessage());
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}