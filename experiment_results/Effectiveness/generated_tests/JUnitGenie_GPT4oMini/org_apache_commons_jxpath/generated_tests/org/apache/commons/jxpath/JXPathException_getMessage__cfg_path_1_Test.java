package org.apache.commons.jxpath;
import org.apache.commons.jxpath.JXPathException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class JXPathException_getMessage__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetMessageWithException() {
        Throwable throwable = new RuntimeException("Test exception message");
        JXPathException jXPathException = new JXPathException(throwable);
        
        String expectedMessage = "java.lang.RuntimeException: Test exception message";
        String actualMessage = jXPathException.getMessage();
        
        assertEquals(expectedMessage, actualMessage);
    }

    @Test(timeout = 4000)
    public void testGetMessageWithNullMessage() {
        Throwable throwable = new RuntimeException();
        JXPathException jXPathException = new JXPathException(throwable);
        
        String expectedMessage = "java.lang.RuntimeException";
        String actualMessage = jXPathException.getMessage();
        
        assertEquals(expectedMessage, actualMessage);
    }

    @Test(timeout = 4000)
    public void testGetMessageWithNullException() {
        JXPathException jXPathException = new JXPathException();
        
        String expectedMessage = null; // Assuming super.getMessage() returns null
        String actualMessage = jXPathException.getMessage();
        
        assertEquals(expectedMessage, actualMessage);
    }

}