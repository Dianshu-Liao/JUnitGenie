package org.apache.commons.jxpath.ri.parser;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.apache.commons.jxpath.ri.Compiler;

@ExtendWith(MockitoExtension.class)
public class XPathParser_jj_3R_49_157_1_Test {

    private XPathParser parser;

    private XPathParserTokenManager tokenManager;

    @BeforeEach
    public void setUp() {
        InputStream inputStream = new ByteArrayInputStream("dummy input".getBytes());
        tokenManager = mock(XPathParserTokenManager.class);
        parser = new XPathParser(tokenManager);
    }

    @Test
    public void testJj_3R_49_FunctionNullToken() throws Exception {
        // Simulate the FUNCTION_NULL token being present
        when(tokenManager.getNextToken()).thenReturn(mock(Token.class, "FUNCTION_NULL"));
        // Use reflection to access the private method
        Method method = XPathParser.class.getDeclaredMethod("jj_3R_49");
        method.setAccessible(true);
        // Call the method under test
        boolean result = (boolean) method.invoke(parser);
        assertTrue(result, "Expected jj_3R_49 to return true when FUNCTION_NULL token is present.");
    }

    @Test
    public void testJj_3R_49_NoFunctionNullToken() throws Exception {
        // Simulate a token that is not FUNCTION_NULL
        when(tokenManager.getNextToken()).thenReturn(mock(Token.class, "INVALID_TOKEN"));
        // Use reflection to access the private method
        Method method = XPathParser.class.getDeclaredMethod("jj_3R_49");
        method.setAccessible(true);
        // Call the method under test
        boolean result = (boolean) method.invoke(parser);
        assertFalse(result, "Expected jj_3R_49 to return false when FUNCTION_NULL token is not present.");
    }
}
