package org.apache.commons.jxpath.ri.parser;

import java.io.StringReader;
import java.io.PrintStream;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class XPathParserTokenManager_jjCheckNAdd_27_0_Test {

    private XPathParserTokenManager tokenManager;

    @BeforeEach
    public void setUp() {
        // Create a SimpleCharStream with a valid Reader
        SimpleCharStream stream = new SimpleCharStream(new StringReader("test input"));
        tokenManager = new XPathParserTokenManager(stream);
    }

    @Test
    public void testJjCheckNAddWhenStateIsNew() throws Exception {
        // Prepare the test
        int state = 0;
        int expectedNewStateCount = 1;
        // Access the private method using reflection
        Method method = XPathParserTokenManager.class.getDeclaredMethod("jjCheckNAdd", int.class);
        method.setAccessible(true);
        // Invoke the method
        method.invoke(tokenManager, state);
        // Validate the state has been added
        int newStateCount = getNewStateCount();
        assertEquals(expectedNewStateCount, newStateCount);
    }

    @Test
    public void testJjCheckNAddWhenStateAlreadyExists() throws Exception {
        // Prepare the test
        int state = 0;
        int expectedNewStateCount = 1;
        // First invocation to add the state
        Method method = XPathParserTokenManager.class.getDeclaredMethod("jjCheckNAdd", int.class);
        method.setAccessible(true);
        method.invoke(tokenManager, state);
        // Second invocation to check if it doesn't add again
        method.invoke(tokenManager, state);
        // Validate the state count remains unchanged
        int newStateCount = getNewStateCount();
        assertEquals(expectedNewStateCount, newStateCount);
    }

    private int getNewStateCount() throws Exception {
        // Use reflection to access the private field jjnewStateCnt
        java.lang.reflect.Field field = XPathParserTokenManager.class.getDeclaredField("jjnewStateCnt");
        field.setAccessible(true);
        return field.getInt(tokenManager);
    }
}
