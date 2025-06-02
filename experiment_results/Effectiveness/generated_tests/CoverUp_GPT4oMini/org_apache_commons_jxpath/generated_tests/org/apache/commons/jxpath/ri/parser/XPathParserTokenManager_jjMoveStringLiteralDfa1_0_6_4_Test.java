package org.apache.commons.jxpath.ri.parser;

import java.io.StringReader;
import java.io.PrintStream;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class XPathParserTokenManager_jjMoveStringLiteralDfa1_0_6_4_Test {

    private XPathParserTokenManager tokenManager;

    private SimpleCharStream stream;

    @BeforeEach
    public void setUp() {
        stream = new SimpleCharStream(new StringReader(""), 1, 1);
        tokenManager = new XPathParserTokenManager(stream);
    }

    @Test
    public void testJjMoveStringLiteralDfa1_0_case46() throws Exception {
        // Prepare the input stream for the test case
        stream = new SimpleCharStream(new StringReader("."), 1, 1);
        tokenManager = new XPathParserTokenManager(stream);
        // Call the private method using reflection
        Method method = XPathParserTokenManager.class.getDeclaredMethod("jjMoveStringLiteralDfa1_0", long.class, long.class);
        method.setAccessible(true);
        // Invoke the method with test values
        int result = (int) method.invoke(tokenManager, 0L, 0x100000L);
        assertEquals(1, result);
    }

    @Test
    public void testJjMoveStringLiteralDfa1_0_case47() throws Exception {
        // Prepare the input stream for the test case
        stream = new SimpleCharStream(new StringReader("/"), 1, 1);
        tokenManager = new XPathParserTokenManager(stream);
        // Call the private method using reflection
        Method method = XPathParserTokenManager.class.getDeclaredMethod("jjMoveStringLiteralDfa1_0", long.class, long.class);
        method.setAccessible(true);
        // Invoke the method with test values
        int result = (int) method.invoke(tokenManager, 0x80L, 0L);
        assertEquals(1, result);
    }

    @Test
    public void testJjMoveStringLiteralDfa1_0_case61() throws Exception {
        // Prepare the input stream for the test case
        stream = new SimpleCharStream(new StringReader("="), 1, 1);
        tokenManager = new XPathParserTokenManager(stream);
        // Call the private method using reflection
        Method method = XPathParserTokenManager.class.getDeclaredMethod("jjMoveStringLiteralDfa1_0", long.class, long.class);
        method.setAccessible(true);
        // Invoke the method with test values
        int result = (int) method.invoke(tokenManager, 0x1000L, 0L);
        assertEquals(1, result);
    }

    @Test
    public void testJjMoveStringLiteralDfa1_0_case97() throws Exception {
        // Prepare the input stream for the test case
        stream = new SimpleCharStream(new StringReader("a"), 1, 1);
        tokenManager = new XPathParserTokenManager(stream);
        // Call the private method using reflection
        Method method = XPathParserTokenManager.class.getDeclaredMethod("jjMoveStringLiteralDfa1_0", long.class, long.class);
        method.setAccessible(true);
        // Invoke the method with test values
        int result = (int) method.invoke(tokenManager, 0L, 0xc1012000000000L);
        assertEquals(2, result);
    }

    @Test
    public void testJjMoveStringLiteralDfa1_0_case100() throws Exception {
        // Prepare the input stream for the test case
        stream = new SimpleCharStream(new StringReader("d"), 1, 1);
        tokenManager = new XPathParserTokenManager(stream);
        // Call the private method using reflection
        Method method = XPathParserTokenManager.class.getDeclaredMethod("jjMoveStringLiteralDfa1_0", long.class, long.class);
        method.setAccessible(true);
        // Invoke the method with test values
        int result = (int) method.invoke(tokenManager, 0x8000000000000L, 0L);
        assertEquals(1, result);
    }

    @Test
    public void testJjMoveStringLiteralDfa1_0_case101() throws Exception {
        // Prepare the input stream for the test case
        stream = new SimpleCharStream(new StringReader("e"), 1, 1);
        tokenManager = new XPathParserTokenManager(stream);
        // Call the private method using reflection
        Method method = XPathParserTokenManager.class.getDeclaredMethod("jjMoveStringLiteralDfa1_0", long.class, long.class);
        method.setAccessible(true);
        // Invoke the method with test values
        int result = (int) method.invoke(tokenManager, 0x10880900000000L, 0x1000L);
        assertEquals(2, result);
    }
}
