package org.apache.commons.jxpath;
import org.apache.commons.jxpath.JXPathException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class JXPathException_getMessage__cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testGetMessageWithNullException() {
        JXPathException jXPathException = new JXPathException();
        String expectedMessage = "null"; // Assuming super.getMessage() returns "null"
        String actualMessage = jXPathException.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test(timeout = 4000)
    public void testGetMessageWithExceptionMessage() {
        Throwable throwable = new RuntimeException("Test Exception");
        JXPathException jXPathException = new JXPathException(throwable);
        String expectedMessage = "Test Exception"; // Expecting the message from the RuntimeException
        String actualMessage = jXPathException.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test(timeout = 4000)
    public void testGetMessageWithNullExceptionMessage() {
        Throwable throwable = new RuntimeException();
        JXPathException jXPathException = new JXPathException(throwable);
        String expectedMessage = "java.lang.RuntimeException"; // Expecting the class name since message is null
        String actualMessage = jXPathException.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

}