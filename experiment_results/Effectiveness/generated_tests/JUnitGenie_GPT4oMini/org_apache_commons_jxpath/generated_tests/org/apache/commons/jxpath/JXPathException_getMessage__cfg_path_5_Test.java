package org.apache.commons.jxpath;
import org.apache.commons.jxpath.JXPathException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class JXPathException_getMessage__cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testGetMessage_NoException() {
        JXPathException jXPathException = new JXPathException();
        String expectedMessage = ""; // No custom message and no exception
        String actualMessage = jXPathException.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test(timeout = 4000)
    public void testGetMessage_WithNullMessage() {
        Throwable throwable = new Throwable(); // Use general throwable for this test
        JXPathException jXPathException = new JXPathException("An error occurred", throwable);
        String expectedMessage = throwable.getClass().getName();
        String actualMessage = jXPathException.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test(timeout = 4000)
    public void testGetMessage_WithMessage() {
        Throwable throwable = new Throwable("Some error happened");
        JXPathException jXPathException = new JXPathException("An error occurred", throwable);
        String expectedMessage = "An error occurred; Some error happened";
        String actualMessage = jXPathException.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test(timeout = 4000)
    public void testGetMessage_WithNullPointerException() {
        Throwable throwable = new NullPointerException("Null reference");
        JXPathException jXPathException = new JXPathException(throwable);
        String expectedMessage = "Null reference";
        String actualMessage = jXPathException.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

}