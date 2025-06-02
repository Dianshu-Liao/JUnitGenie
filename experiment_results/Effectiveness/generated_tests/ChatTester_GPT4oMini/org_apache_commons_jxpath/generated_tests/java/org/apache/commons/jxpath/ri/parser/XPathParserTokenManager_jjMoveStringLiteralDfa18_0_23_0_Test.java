package org.apache.commons.jxpath.ri.parser;

import java.io.StringReader;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class XPathParserTokenManager_jjMoveStringLiteralDfa18_0_23_0_Test {

    private XPathParserTokenManager tokenManager;

    @BeforeEach
    public void setUp() {
        tokenManager = new XPathParserTokenManager(new SimpleCharStream(new StringReader("")));
    }

    @Test
    public void testJjMoveStringLiteralDfa18_0_WithValidInput() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        long old0 = 0x200000000000L;
        long active0 = 0x200000000000L;
        Method method = XPathParserTokenManager.class.getDeclaredMethod("jjMoveStringLiteralDfa18_0", long.class, long.class);
        method.setAccessible(true);
        int result = (int) method.invoke(tokenManager, old0, active0);
        assertEquals(18, result);
    }

    @Test
    public void testJjMoveStringLiteralDfa18_0_WithNoMatch() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        long old0 = 0x0L;
        long active0 = 0x0L;
        Method method = XPathParserTokenManager.class.getDeclaredMethod("jjMoveStringLiteralDfa18_0", long.class, long.class);
        method.setAccessible(true);
        int result = (int) method.invoke(tokenManager, old0, active0);
        assertEquals(18, result);
    }

    @Test
    public void testJjMoveStringLiteralDfa18_0_WithIOException() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        long old0 = 0x200000000000L;
        long active0 = 0x400000000000L;
        tokenManager.input_stream = null;
        Method method = XPathParserTokenManager.class.getDeclaredMethod("jjMoveStringLiteralDfa18_0", long.class, long.class);
        method.setAccessible(true);
        int result = (int) method.invoke(tokenManager, old0, active0);
        assertEquals(18, result);
    }

    @Test
    public void testJjMoveStringLiteralDfa18_0_WithColonCharacter() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        long old0 = 0x200000000000L;
        long active0 = 0x200000000000L;
        tokenManager.input_stream = new SimpleCharStream(new StringReader(":"));
        Method method = XPathParserTokenManager.class.getDeclaredMethod("jjMoveStringLiteralDfa18_0", long.class, long.class);
        method.setAccessible(true);
        int result = (int) method.invoke(tokenManager, old0, active0);
        assertEquals(18, result);
    }

    @Test
    public void testJjMoveStringLiteralDfa18_0_WithNonColonCharacter() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        long old0 = 0x200000000000L;
        long active0 = 0x200000000000L;
        tokenManager.input_stream = new SimpleCharStream(new StringReader("a"));
        Method method = XPathParserTokenManager.class.getDeclaredMethod("jjMoveStringLiteralDfa18_0", long.class, long.class);
        method.setAccessible(true);
        int result = (int) method.invoke(tokenManager, old0, active0);
        assertEquals(18, result);
    }
}
