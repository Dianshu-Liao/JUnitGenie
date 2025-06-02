package org.apache.commons.jxpath.ri.parser;

import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import org.apache.commons.jxpath.ri.Compiler;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class XPathParser_jj_3R_97_96_0_Test {

    private XPathParser parser;

    private Compiler mockCompiler;

    private XPathParserTokenManager mockTokenManager;

    @BeforeEach
    public void setUp() {
        mockCompiler = mock(Compiler.class);
        mockTokenManager = mock(XPathParserTokenManager.class);
        parser = new XPathParser(mockTokenManager);
    }

    @Test
    public void testJj3R97ReturnsTrueWhenScanTokenIs88() throws Exception {
        // Use reflection to access the private method jj_scan_token
        Method scanTokenMethod = XPathParser.class.getDeclaredMethod("jj_scan_token", int.class);
        scanTokenMethod.setAccessible(true);
        // Invoke the private method
        boolean scanResult = (boolean) scanTokenMethod.invoke(parser, 88);
        assertTrue(scanResult);
        // Invoke the private method jj_3R_97
        Method method = XPathParser.class.getDeclaredMethod("jj_3R_97");
        method.setAccessible(true);
        // Execute the method
        boolean result = (boolean) method.invoke(parser);
        // Verify the result
        assertTrue(result);
    }

    @Test
    public void testJj3R97ReturnsTrueWhenJj3R96ReturnsTrue() throws Exception {
        // Use reflection to access the private method jj_scan_token
        Method scanTokenMethod = XPathParser.class.getDeclaredMethod("jj_scan_token", int.class);
        scanTokenMethod.setAccessible(true);
        // Simulate jj_scan_token returning false
        when(scanTokenMethod.invoke(parser, 88)).thenReturn(false);
        // Use reflection to access the private method jj_3R_96
        Method jj3R96Method = XPathParser.class.getDeclaredMethod("jj_3R_96");
        jj3R96Method.setAccessible(true);
        // Simulate jj_3R_96 returning true
        when(jj3R96Method.invoke(parser)).thenReturn(true);
        // Invoke the private method jj_3R_97
        Method method = XPathParser.class.getDeclaredMethod("jj_3R_97");
        method.setAccessible(true);
        // Execute the method
        boolean result = (boolean) method.invoke(parser);
        // Verify the result
        assertTrue(result);
    }

    @Test
    public void testJj3R97ReturnsFalseWhenBothConditionsFail() throws Exception {
        // Use reflection to access the private method jj_scan_token
        Method scanTokenMethod = XPathParser.class.getDeclaredMethod("jj_scan_token", int.class);
        scanTokenMethod.setAccessible(true);
        // Simulate jj_scan_token returning false
        when(scanTokenMethod.invoke(parser, 88)).thenReturn(false);
        // Use reflection to access the private method jj_3R_96
        Method jj3R96Method = XPathParser.class.getDeclaredMethod("jj_3R_96");
        jj3R96Method.setAccessible(true);
        // Simulate jj_3R_96 returning false
        when(jj3R96Method.invoke(parser)).thenReturn(false);
        // Invoke the private method jj_3R_97
        Method method = XPathParser.class.getDeclaredMethod("jj_3R_97");
        method.setAccessible(true);
        // Execute the method
        boolean result = (boolean) method.invoke(parser);
        // Verify the result
        assertFalse(result);
    }
}
