package org.apache.commons.lang3.exception;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.io.PrintWriter;
import java.io.StringWriter;

public class exception_ExceptionUtils_printRootCauseStackTrace_Throwable_PrintWriter_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testPrintRootCauseStackTrace_NullThrowable() {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        
        try {
            // Call the method with null throwable
            ExceptionUtils.printRootCauseStackTrace(null, printWriter);
            // Verify that no output was printed
            assertEquals("", stringWriter.toString());
        } catch (Exception e) {
            e.printStackTrace(); // handle exception
        }
    }

    @Test(timeout = 4000)
    public void testPrintRootCauseStackTrace_ValidThrowable() {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);

        try {
            // Call the method with a valid throwable
            Throwable throwable = new Exception("Test exception");
            ExceptionUtils.printRootCauseStackTrace(throwable, printWriter);
            printWriter.flush();
            
            // Verify that the output contains the exception message
            assertTrue(stringWriter.toString().contains("Test exception"));
        } catch (Exception e) {
            e.printStackTrace(); // handle exception
        }
    }


}