package org.apache.commons.jxpath;
import org.apache.commons.jxpath.JXPathException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class JXPathException_getMessage__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testGetMessageWithNullException() {
        JXPathException jXPathException = new JXPathException();
        String expectedMessage = null; // since super.getMessage() is expected to return null
        String actualMessage = jXPathException.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test(timeout = 4000)
    public void testGetMessageWithExceptionMessage() {
        Throwable throwable = new RuntimeException("Test exception message");
        JXPathException jXPathException = new JXPathException(throwable);
        String expectedMessage = "java.lang.RuntimeException: Test exception message"; // expected output
        String actualMessage = jXPathException.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test(timeout = 4000)
    public void testGetMessageWithNullExceptionMessage() {
        Throwable throwable = new RuntimeException();
        JXPathException jXPathException = new JXPathException(throwable);
        String expectedMessage = "java.lang.RuntimeException"; // expected output when exception message is null
        String actualMessage = jXPathException.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test(timeout = 4000)
    public void testGetMessageWithSuperMessage() {
        JXPathException jXPathException = new JXPathException("Super message", new RuntimeException("Cause"));
        String expectedMessage = "Super message; java.lang.RuntimeException: Cause"; // expected output
        String actualMessage = jXPathException.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

}