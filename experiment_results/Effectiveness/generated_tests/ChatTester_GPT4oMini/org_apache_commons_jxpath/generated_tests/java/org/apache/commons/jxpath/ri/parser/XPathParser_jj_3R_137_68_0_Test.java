package org.apache.commons.jxpath.ri.parser;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import org.apache.commons.jxpath.ri.Compiler;

public class XPathParser_jj_3R_137_68_0_Test {

    private XPathParser parser;

    @BeforeEach
    public void setUp() {
        parser = new XPathParser(Mockito.mock(XPathParserTokenManager.class));
    }

    @Test
    public void testJj_3R_137_WithFirstConditionTrue() throws Exception {
        // Set up the necessary conditions for jj_3R_139() to return true
        Method jj_3R_139 = XPathParser.class.getDeclaredMethod("jj_3R_139");
        jj_3R_139.setAccessible(true);
        Mockito.when(jj_3R_139.invoke(parser)).thenReturn(true);
        // Set up the necessary conditions for jj_3R_140() to return false
        Method jj_3R_140 = XPathParser.class.getDeclaredMethod("jj_3R_140");
        jj_3R_140.setAccessible(true);
        Mockito.when(jj_3R_140.invoke(parser)).thenReturn(false);
        // Invoke the focal method
        Method jj_3R_137 = XPathParser.class.getDeclaredMethod("jj_3R_137");
        jj_3R_137.setAccessible(true);
        boolean result = (boolean) jj_3R_137.invoke(parser);
        // Assert the result
        assertFalse(result);
    }

    @Test
    public void testJj_3R_137_WithBothConditionsTrue() throws Exception {
        // Set up the necessary conditions for both jj_3R_139() and jj_3R_140() to return true
        Method jj_3R_139 = XPathParser.class.getDeclaredMethod("jj_3R_139");
        jj_3R_139.setAccessible(true);
        Mockito.when(jj_3R_139.invoke(parser)).thenReturn(true);
        Method jj_3R_140 = XPathParser.class.getDeclaredMethod("jj_3R_140");
        jj_3R_140.setAccessible(true);
        Mockito.when(jj_3R_140.invoke(parser)).thenReturn(true);
        // Invoke the focal method
        Method jj_3R_137 = XPathParser.class.getDeclaredMethod("jj_3R_137");
        jj_3R_137.setAccessible(true);
        boolean result = (boolean) jj_3R_137.invoke(parser);
        // Assert the result
        assertTrue(result);
    }

    @Test
    public void testJj_3R_137_WithFirstConditionFalse() throws Exception {
        // Set up the necessary conditions for jj_3R_139() to return false
        Method jj_3R_139 = XPathParser.class.getDeclaredMethod("jj_3R_139");
        jj_3R_139.setAccessible(true);
        Mockito.when(jj_3R_139.invoke(parser)).thenReturn(false);
        // Invoke the focal method
        Method jj_3R_137 = XPathParser.class.getDeclaredMethod("jj_3R_137");
        jj_3R_137.setAccessible(true);
        boolean result = (boolean) jj_3R_137.invoke(parser);
        // Assert the result
        assertFalse(result);
    }
}
