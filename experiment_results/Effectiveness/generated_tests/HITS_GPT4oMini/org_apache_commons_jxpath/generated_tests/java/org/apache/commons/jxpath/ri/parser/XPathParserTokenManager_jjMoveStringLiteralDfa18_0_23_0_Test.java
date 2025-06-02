package org.apache.commons.jxpath.ri.parser;

import java.io.StringReader;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class XPathParserTokenManager_jjMoveStringLiteralDfa18_0_23_0_Test {

    private XPathParserTokenManager tokenManager;

    @BeforeEach
    public void setUp() {
        SimpleCharStream charStream = new SimpleCharStream(new StringReader(""), 1, 1);
        tokenManager = new XPathParserTokenManager(charStream);
    }

    private int invokeJjMoveStringLiteralDfa18_0(long old0, long active0) throws Exception {
        Method method = XPathParserTokenManager.class.getDeclaredMethod("jjMoveStringLiteralDfa18_0", long.class, long.class);
        // Make the private method accessible
        method.setAccessible(true);
        return (int) method.invoke(tokenManager, old0, active0);
    }

    @Test
    public void testJjMoveStringLiteralDfa18_0_WithValidInput1() throws Exception {
        long old0 = 0x0000000000000000L;
        long active0 = 0x200000000000L;
        int result = invokeJjMoveStringLiteralDfa18_0(old0, active0);
        assertEquals(18, result);
    }

    @Test
    public void testJjMoveStringLiteralDfa18_0_WithValidInput2() throws Exception {
        long old0 = 0x0000000000000000L;
        long active0 = 0x400000000000L;
        int result = invokeJjMoveStringLiteralDfa18_0(old0, active0);
        assertEquals(18, result);
    }

    @Test
    public void testJjMoveStringLiteralDfa18_0_WithCharColon() throws Exception {
        long old0 = 0x0000000000000000L;
        long active0 = 0x200000000000L;
        tokenManager.curChar = ':';
        int result = invokeJjMoveStringLiteralDfa18_0(old0, active0);
        assertEquals(18, result);
    }

    @Test
    public void testJjMoveStringLiteralDfa18_0_WithCharT() throws Exception {
        long old0 = 0x0000000000000000L;
        long active0 = 0x400000000L;
        tokenManager.curChar = 't';
        int result = invokeJjMoveStringLiteralDfa18_0(old0, active0);
        assertEquals(18, result);
    }

    @Test
    public void testJjMoveStringLiteralDfa18_0_WithInvalidChar() throws Exception {
        long old0 = 0x0000000000000000L;
        long active0 = 0x200000000000L;
        tokenManager.curChar = 'x';
        int result = invokeJjMoveStringLiteralDfa18_0(old0, active0);
        assertEquals(17, result);
    }
}
