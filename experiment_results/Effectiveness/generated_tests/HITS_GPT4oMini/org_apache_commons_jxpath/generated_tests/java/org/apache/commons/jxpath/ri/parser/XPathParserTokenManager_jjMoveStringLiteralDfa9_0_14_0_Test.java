package org.apache.commons.jxpath.ri.parser;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class XPathParserTokenManager_jjMoveStringLiteralDfa9_0_14_0_Test {

    private XPathParserTokenManager tokenManager;

    @BeforeEach
    public void setUp() {
        // Initialize the SimpleCharStream with a mock input stream
        SimpleCharStream stream = new SimpleCharStream(new java.io.StringReader(""), 1, 1);
        tokenManager = new XPathParserTokenManager(stream);
    }

    private int invokeJjMoveStringLiteralDfa9_0(long old0, long active0, long old1, long active1) throws Exception {
        Method method = XPathParserTokenManager.class.getDeclaredMethod("jjMoveStringLiteralDfa9_0", long.class, long.class, long.class, long.class);
        method.setAccessible(true);
        return (int) method.invoke(tokenManager, old0, active0, old1, active1);
    }

    @Test
    public void testJjMoveStringLiteralDfa9_0_NoActiveBits() throws Exception {
        long old0 = 0L;
        long old1 = 0L;
        long active0 = 0L;
        long active1 = 0L;
        int result = invokeJjMoveStringLiteralDfa9_0(old0, active0, old1, active1);
        assertEquals(9, result, "Expected to transition to state 9 when no active bits are set.");
    }

    @Test
    public void testJjMoveStringLiteralDfa9_0_ActiveBitsSet() throws Exception {
        long old0 = 0x0000000000000001L;
        long old1 = 0x0000000000000000L;
        long active0 = 0x0000000000000001L;
        long active1 = 0x0000000000000000L;
        int result = invokeJjMoveStringLiteralDfa9_0(old0, active0, old1, active1);
        assertNotEquals(9, result, "Expected to transition to a different state when active bits are set.");
    }

    @Test
    public void testJjMoveStringLiteralDfa9_0_ActiveBitsInOld1() throws Exception {
        long old0 = 0x0000000000000000L;
        long old1 = 0x0000000000000001L;
        long active0 = 0x0000000000000000L;
        long active1 = 0x0000000000000001L;
        int result = invokeJjMoveStringLiteralDfa9_0(old0, active0, old1, active1);
        assertNotEquals(9, result, "Expected to transition to a different state when active bits are set in old1.");
    }
}
