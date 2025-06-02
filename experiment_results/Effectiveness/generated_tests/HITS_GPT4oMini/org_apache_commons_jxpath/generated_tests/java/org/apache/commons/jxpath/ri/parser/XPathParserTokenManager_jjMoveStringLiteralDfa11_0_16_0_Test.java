package org.apache.commons.jxpath.ri.parser;

import java.io.StringReader;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

class XPathParserTokenManager_jjMoveStringLiteralDfa11_0_16_0_Test {

    private SimpleCharStream inputStream;

    private XPathParserTokenManager tokenManager;

    @BeforeEach
    void setUp() {
        inputStream = new SimpleCharStream(new StringReader(""), 1, 1);
        tokenManager = new XPathParserTokenManager(inputStream);
    }

    private int callJjMoveStringLiteralDfa11_0(long old0, long active0, long old1, long active1) throws Exception {
        Method method = XPathParserTokenManager.class.getDeclaredMethod("jjMoveStringLiteralDfa11_0", long.class, long.class, long.class, long.class);
        method.setAccessible(true);
        return (int) method.invoke(tokenManager, old0, active0, old1, active1);
    }

    @Test
    void testJjMoveStringLiteralDfa11_0_withNoMatch() throws Exception {
        long old0 = 0x0L;
        long old1 = 0x0L;
        long active0 = 0x0L;
        long active1 = 0x0L;
        int result = callJjMoveStringLiteralDfa11_0(old0, active0, old1, active1);
        assertEquals(11, result, "Expected to return state 11 when no match occurs.");
    }

    @Test
    void testJjMoveStringLiteralDfa11_0_withMatchOnCharacter() throws Exception {
        long old0 = 0x80000000000L;
        long old1 = 0x0L;
        long active0 = 0x80000000000L;
        long active1 = 0x0L;
        inputStream = new SimpleCharStream(new StringReader(":"), 1, 1);
        tokenManager = new XPathParserTokenManager(inputStream);
        int result = callJjMoveStringLiteralDfa11_0(old0, active0, old1, active1);
        assertEquals(11, result, "Expected to return state 11 when matching ':' character.");
    }

    @Test
    void testJjMoveStringLiteralDfa11_0_withMatchOnDifferentCharacter() throws Exception {
        long old0 = 0x0L;
        long old1 = 0x0L;
        long active0 = 0x2000000000000000L;
        long active1 = 0x0L;
        inputStream = new SimpleCharStream(new StringReader("e"), 1, 1);
        tokenManager = new XPathParserTokenManager(inputStream);
        int result = callJjMoveStringLiteralDfa11_0(old0, active0, old1, active1);
        assertEquals(11, result, "Expected to return state 11 when matching 'e' character.");
    }
}
