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

public class XPathParser_jj_3R_49_157_0_Test {

    private XPathParser parser;

    @BeforeEach
    public void setUp() {
        parser = new XPathParser(new java.io.ByteArrayInputStream(new byte[0]));
    }

    @Test
    public void testJj3R49_FunctionNullToken() throws Exception {
        // Assuming FUNCTION_NULL is a valid token and jj_scan_token is properly mocked
        // Use reflection to access the private method
        Method method = XPathParser.class.getDeclaredMethod("jj_3R_49");
        method.setAccessible(true);
        // Simulate the scanner to return FUNCTION_NULL token
        // This part needs to be implemented based on the actual token management
        // Mock or create a token
        parser.token = new Token();
        // Set to FUNCTION_NULL
        parser.token.kind = XPathParser.FUNCTION_NULL;
        // Set the next token
        parser.jj_nt = parser.token;
        // Call the method
        boolean result = (boolean) method.invoke(parser);
        // Assert that it returns true when FUNCTION_NULL is scanned
        assertTrue(result);
    }

    @Test
    public void testJj3R49_NotFunctionNullToken() throws Exception {
        // Use reflection to access the private method
        Method method = XPathParser.class.getDeclaredMethod("jj_3R_49");
        method.setAccessible(true);
        // Simulate the scanner to return a token that is not FUNCTION_NULL
        // Mock or create a token
        parser.token = new Token();
        // Set to a different token
        parser.token.kind = XPathParser.AND;
        // Set the next token
        parser.jj_nt = parser.token;
        // Call the method
        boolean result = (boolean) method.invoke(parser);
        // Assert that it returns false when FUNCTION_NULL is not scanned
        assertFalse(result);
    }
}
