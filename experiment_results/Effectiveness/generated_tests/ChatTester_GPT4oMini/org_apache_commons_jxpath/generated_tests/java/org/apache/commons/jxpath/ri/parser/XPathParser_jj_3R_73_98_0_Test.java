package org.apache.commons.jxpath.ri.parser;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.apache.commons.jxpath.ri.Compiler;

public class XPathParser_jj_3R_73_98_0_Test {

    private XPathParser parser;

    private Compiler compilerMock;

    private XPathParserTokenManager tokenManagerMock;

    @BeforeEach
    public void setUp() {
        // Initialize mocks and the XPathParser instance
        compilerMock = Mockito.mock(Compiler.class);
        tokenManagerMock = Mockito.mock(XPathParserTokenManager.class);
        parser = new XPathParser(tokenManagerMock);
    }

    @Test
    public void testJj3R73ReturnsTrueWhenJj3R82ReturnsTrue() throws Exception {
        // Mock the jj_3R_82 method
        Method method82 = XPathParser.class.getDeclaredMethod("jj_3R_82");
        method82.setAccessible(true);
        when(method82.invoke(parser)).thenReturn(true);
        // Invoke the jj_3R_73 method
        Method method = XPathParser.class.getDeclaredMethod("jj_3R_73");
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(parser);
        // Verify the result
        assertTrue(result);
    }

    @Test
    public void testJj3R73ReturnsTrueWhenJj3R83ReturnsTrue() throws Exception {
        // Mock the jj_3R_82 and jj_3R_83 methods
        Method method82 = XPathParser.class.getDeclaredMethod("jj_3R_82");
        method82.setAccessible(true);
        when(method82.invoke(parser)).thenReturn(false);
        Method method83 = XPathParser.class.getDeclaredMethod("jj_3R_83");
        method83.setAccessible(true);
        when(method83.invoke(parser)).thenReturn(true);
        // Invoke the jj_3R_73 method
        Method method = XPathParser.class.getDeclaredMethod("jj_3R_73");
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(parser);
        // Verify the result
        assertTrue(result);
    }

    @Test
    public void testJj3R73ReturnsFalseWhenBothJj3R82AndJj3R83ReturnFalse() throws Exception {
        // Mock the jj_3R_82 and jj_3R_83 methods
        Method method82 = XPathParser.class.getDeclaredMethod("jj_3R_82");
        method82.setAccessible(true);
        when(method82.invoke(parser)).thenReturn(false);
        Method method83 = XPathParser.class.getDeclaredMethod("jj_3R_83");
        method83.setAccessible(true);
        when(method83.invoke(parser)).thenReturn(false);
        // Invoke the jj_3R_73 method
        Method method = XPathParser.class.getDeclaredMethod("jj_3R_73");
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(parser);
        // Verify the result
        assertFalse(result);
    }
}
