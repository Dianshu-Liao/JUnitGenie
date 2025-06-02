// Test method
package org.apache.commons.jxpath.ri.parser;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import org.apache.commons.jxpath.ri.Compiler;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class XPathParser_AxisSpecifier_13_4_Test {

    private XPathParser parser;

    private XPathParserTokenManager tokenManager;

    private Token token;

    @BeforeEach
    public void setUp() {
        tokenManager = mock(XPathParserTokenManager.class);
        parser = new XPathParser(tokenManager);
        token = mock(Token.class);
        // Set the initial token
        parser.jj_nt = token;
    }

    @Test
    public void testAxisSpecifier_AxisName() throws Exception {
        // Set up the mock token to return a valid axis type
        when(token.kind).thenReturn(XPathParserTokenManager.AXIS_SELF);
        // Mock the AxisName method to return a specific value
        when(parser.AxisName()).thenReturn(1);
        // Use reflection to invoke the private method
        int result = invokeAxisSpecifier(parser);
        // Check that the result matches the expected value
        assertEquals(1, result);
    }

    @Test
    public void testAxisSpecifier_AbbreviatedAxisSpecifier() throws Exception {
        // Set up the mock token to return an invalid axis type
        when(token.kind).thenReturn(-1);
        // Mock the AbbreviatedAxisSpecifier method to return a specific value
        when(parser.AbbreviatedAxisSpecifier()).thenReturn(2);
        // Use reflection to invoke the private method
        int result = invokeAxisSpecifier(parser);
        // Verify that the result matches the expected value
        assertEquals(2, result);
    }

    @Test
    public void testAxisSpecifier_MissingReturn() {
        // Set up the mock token to return an invalid axis type
        when(token.kind).thenReturn(-1);
        // Verify that invoking the method throws an Error
        Error exception = assertThrows(Error.class, () -> {
            invokeAxisSpecifier(parser);
        });
        assertEquals("Missing return statement in function", exception.getMessage());
    }

    private int invokeAxisSpecifier(XPathParser parser) throws Exception {
        // Fixed the buggy line by replacing 'var' with 'java.lang.reflect.Method'
        java.lang.reflect.Method method = XPathParser.class.getDeclaredMethod("AxisSpecifier");
        method.setAccessible(true);
        return (int) method.invoke(parser);
    }
}
