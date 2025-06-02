package org.apache.commons.jxpath.ri.parser;

import java.io.StringReader;
import java.io.IOException;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

class XPathParserTokenManager_jjMoveStringLiteralDfa19_0_24_0_Test {

    private XPathParserTokenManager tokenManager;

    private SimpleCharStream charStream;

    @BeforeEach
    void setUp() {
        charStream = new SimpleCharStream(new StringReader(""), 1, 1);
        tokenManager = new XPathParserTokenManager(charStream);
    }

    private int invokeJjMoveStringLiteralDfa19_0(long old0, long active0) throws Exception {
        Method method = XPathParserTokenManager.class.getDeclaredMethod("jjMoveStringLiteralDfa19_0", long.class, long.class);
        method.setAccessible(true);
        return (int) method.invoke(tokenManager, old0, active0);
    }

    @Test
    void testJjMoveStringLiteralDfa19_0_withNoActive0() throws Exception {
        long old0 = 0x0L;
        long active0 = 0x0L;
        int result = invokeJjMoveStringLiteralDfa19_0(old0, active0);
        assertEquals(19, result);
    }

    @Test
    void testJjMoveStringLiteralDfa19_0_withActive0AndColon() throws Exception {
        long old0 = 0x800000000000L;
        charStream = new SimpleCharStream(new StringReader(":"), 1, 1);
        tokenManager = new XPathParserTokenManager(charStream);
        long active0 = old0;
        int result = invokeJjMoveStringLiteralDfa19_0(old0, active0);
        assertEquals(19, result);
    }

    @Test
    void testJjMoveStringLiteralDfa19_0_withActive0AndCharI() throws Exception {
        long old0 = 0x400000000L;
        charStream = new SimpleCharStream(new StringReader("i"), 1, 1);
        tokenManager = new XPathParserTokenManager(charStream);
        long active0 = old0;
        int result = invokeJjMoveStringLiteralDfa19_0(old0, active0);
        assertEquals(20, result);
    }

    @Test
    void testJjMoveStringLiteralDfa19_0_withActive0AndInvalidChar() throws Exception {
        long old0 = 0x0L;
        charStream = new SimpleCharStream(new StringReader("x"), 1, 1);
        tokenManager = new XPathParserTokenManager(charStream);
        long active0 = old0;
        int result = invokeJjMoveStringLiteralDfa19_0(old0, active0);
        assertEquals(18, result);
    }

    @Test
    void testJjMoveStringLiteralDfa19_0_withIOException() throws Exception {
        charStream = new SimpleCharStream(new StringReader(""), 1, 1);
        tokenManager = new XPathParserTokenManager(charStream);
        long old0 = 0x800000000000L;
        long active0 = old0;
        charStream.inputStream = new StringReader("invalid");
        int result = invokeJjMoveStringLiteralDfa19_0(old0, active0);
        assertEquals(19, result);
    }
}
