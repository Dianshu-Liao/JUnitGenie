package org.apache.commons.jxpath.ri.parser;

import java.io.StringReader;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class XPathParserTokenManager_jjMoveStringLiteralDfa12_0_17_0_Test {

    private XPathParserTokenManager tokenManager;

    private SimpleCharStream charStream;

    @BeforeEach
    public void setUp() {
        StringReader reader = new StringReader("sample input");
        charStream = new SimpleCharStream(reader);
        tokenManager = new XPathParserTokenManager(charStream);
    }

    private int invokeJjMoveStringLiteralDfa12_0(long old0, long active0, long old1, long active1) throws Exception {
        Method method = XPathParserTokenManager.class.getDeclaredMethod("jjMoveStringLiteralDfa12_0", long.class, long.class, long.class, long.class);
        method.setAccessible(true);
        return (int) method.invoke(tokenManager, old0, active0, old1, active1);
    }

    @Test
    public void testJjMoveStringLiteralDfa12_0_caseA() throws Exception {
        long old0 = 0xFFFFFFFFFFFFFFFEL;
        long old1 = 0x0L;
        long active0 = 0x0L;
        long active1 = 0x0L;
        int result = invokeJjMoveStringLiteralDfa12_0(old0, active0, old1, active1);
        assertEquals(12, result);
    }

    @Test
    public void testJjMoveStringLiteralDfa12_0_caseB() throws Exception {
        long old0 = 0x0L;
        long old1 = 0x0L;
        // 'i'
        long active0 = 0x40000000000000L;
        long active1 = 0x0L;
        int result = invokeJjMoveStringLiteralDfa12_0(old0, active0, old1, active1);
        assertEquals(12, result);
    }

    @Test
    public void testJjMoveStringLiteralDfa12_0_caseC() throws Exception {
        long old0 = 0x7FFFFFFFFFFFFFFFL;
        long old1 = 0x0L;
        long active0 = 0x0L;
        // 'h'
        long active1 = 0x1L;
        int result = invokeJjMoveStringLiteralDfa12_0(old0, active0, old1, active1);
        assertEquals(12, result);
    }

    @Test
    public void testJjMoveStringLiteralDfa12_0_caseD() throws Exception {
        long old0 = 0x0L;
        long old1 = 0x0L;
        // 'r'
        long active0 = 0x800000000000L;
        long active1 = 0x0L;
        int result = invokeJjMoveStringLiteralDfa12_0(old0, active0, old1, active1);
        assertEquals(12, result);
    }

    @Test
    public void testJjMoveStringLiteralDfa12_0_caseE() throws Exception {
        long old0 = 0x0L;
        long old1 = 0x0L;
    }
}
