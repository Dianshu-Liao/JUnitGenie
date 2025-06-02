package org.apache.commons.jxpath.ri.parser;

import java.io.StringReader;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

class XPathParserTokenManager_jjMoveStringLiteralDfa2_0_7_0_Test {

    private XPathParserTokenManager tokenManager;

    private SimpleCharStream charStream;

    @BeforeEach
    void setUp() {
        charStream = new SimpleCharStream(new StringReader(""), 1, 1);
        tokenManager = new XPathParserTokenManager(charStream);
    }

    @Test
    void testJjMoveStringLiteralDfa2_0_withValidInputs() throws Exception {
        long old0 = 0x0000000000000000L;
        long old1 = 0x0000000000000000L;
        long active0 = 0x0000000000000000L;
        long active1 = 0x0000000000000000L;
        charStream = new SimpleCharStream(new StringReader("a"), 1, 1);
        tokenManager = new XPathParserTokenManager(charStream);
        Method method = XPathParserTokenManager.class.getDeclaredMethod("jjMoveStringLiteralDfa2_0", long.class, long.class, long.class, long.class);
        method.setAccessible(true);
        int result = (int) method.invoke(tokenManager, old0, active0, old1, active1);
        assertEquals(1, result);
    }

    @Test
    void testJjMoveStringLiteralDfa2_0_withDifferentInputs() throws Exception {
        long old0 = 0x0000000000000000L;
        long old1 = 0x0000000000000000L;
        long active0 = 0x0000000000000000L;
        long active1 = 0x0000000000000000L;
        charStream = new SimpleCharStream(new StringReader("b"), 1, 1);
        tokenManager = new XPathParserTokenManager(charStream);
        Method method = XPathParserTokenManager.class.getDeclaredMethod("jjMoveStringLiteralDfa2_0", long.class, long.class, long.class, long.class);
        method.setAccessible(true);
        int result = (int) method.invoke(tokenManager, old0, active0, old1, active1);
        assertEquals(1, result);
    }

    @Test
    void testJjMoveStringLiteralDfa2_0_withEdgeCase() throws Exception {
        long old0 = 0x0000000000000000L;
        long old1 = 0x0000000000000000L;
        long active0 = 0xFFFFFFFFFFFFFFFFL;
        long active1 = 0xFFFFFFFFFFFFFFFFL;
        charStream = new SimpleCharStream(new StringReader("z"), 1, 1);
        tokenManager = new XPathParserTokenManager(charStream);
        Method method = XPathParserTokenManager.class.getDeclaredMethod("jjMoveStringLiteralDfa2_0", long.class, long.class, long.class, long.class);
        method.setAccessible(true);
        int result = (int) method.invoke(tokenManager, old0, active0, old1, active1);
        assertEquals(2, result);
    }
}
