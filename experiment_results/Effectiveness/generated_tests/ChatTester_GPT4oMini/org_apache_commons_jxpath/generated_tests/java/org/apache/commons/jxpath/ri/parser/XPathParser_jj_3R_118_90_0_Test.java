package org.apache.commons.jxpath.ri.parser;

import java.io.StringReader;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.apache.commons.jxpath.ri.Compiler;

public class XPathParser_jj_3R_118_90_0_Test {

    private XPathParser parser;

    @BeforeEach
    public void setUp() {
        // Fixing the Buggy Line: Creating a SimpleCharStream with a valid Reader
        parser = new XPathParser(new XPathParserTokenManager(new SimpleCharStream(new StringReader(""))));
    }

    @Test
    public void testJj_3R_118_AllBranches() throws Exception {
        Method method123 = XPathParser.class.getDeclaredMethod("jj_3R_123");
        Method method124 = XPathParser.class.getDeclaredMethod("jj_3R_124");
        Method method125 = XPathParser.class.getDeclaredMethod("jj_3R_125");
        Method method126 = XPathParser.class.getDeclaredMethod("jj_3R_126");
        method123.setAccessible(true);
        method124.setAccessible(true);
        method125.setAccessible(true);
        method126.setAccessible(true);
        // Test case 1: All methods return false
        when(method123.invoke(parser)).thenReturn(false);
        when(method124.invoke(parser)).thenReturn(false);
        when(method125.invoke(parser)).thenReturn(false);
        when(method126.invoke(parser)).thenReturn(false);
        assertFalse((Boolean) invokeJj3R118());
        // Test case 2: jj_3R_123 returns true
        when(method123.invoke(parser)).thenReturn(true);
        assertTrue((Boolean) invokeJj3R118());
        // Test case 3: jj_3R_123 returns false, jj_3R_124 returns true
        when(method123.invoke(parser)).thenReturn(false);
        when(method124.invoke(parser)).thenReturn(true);
        assertTrue((Boolean) invokeJj3R118());
        // Test case 4: jj_3R_123 and jj_3R_124 return false, jj_3R_125 returns true
        when(method123.invoke(parser)).thenReturn(false);
        when(method124.invoke(parser)).thenReturn(false);
        when(method125.invoke(parser)).thenReturn(true);
        assertTrue((Boolean) invokeJj3R118());
        // Test case 5: All methods return false except jj_3R_126
        when(method123.invoke(parser)).thenReturn(false);
        when(method124.invoke(parser)).thenReturn(false);
        when(method125.invoke(parser)).thenReturn(false);
        when(method126.invoke(parser)).thenReturn(true);
        assertTrue((Boolean) invokeJj3R118());
        // Test case 6: All methods return false
        when(method123.invoke(parser)).thenReturn(false);
        when(method124.invoke(parser)).thenReturn(false);
        when(method125.invoke(parser)).thenReturn(false);
        when(method126.invoke(parser)).thenReturn(false);
        assertFalse((Boolean) invokeJj3R118());
    }

    private Object invokeJj3R118() throws Exception {
        Method method = XPathParser.class.getDeclaredMethod("jj_3R_118");
        method.setAccessible(true);
        return method.invoke(parser);
    }
}
