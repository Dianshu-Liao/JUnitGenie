package org.apache.commons.jxpath.ri.parser;

import java.io.StringReader;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.apache.commons.jxpath.ri.Compiler;

public class XPathParser_jj_3R_48_158_3_Test {

    private XPathParser parser;

    @BeforeEach
    public void setUp() {
        // Initialize the XPathParser with a mock or dummy TokenManager
        parser = new XPathParser(new XPathParserTokenManager(new SimpleCharStream(new StringReader(""), 1, 1, 1)));
    }

    @Test
    public void testJj_3R_48_FunctionFalseToken() {
        // Mocking the behavior of the token_source to return FUNCTION_FALSE
        parser.token_source = mock(XPathParserTokenManager.class);
        Token functionFalseToken = new Token();
        functionFalseToken.kind = XPathParser.FUNCTION_FALSE;
        when(parser.token_source.getNextToken()).thenReturn(functionFalseToken);
        // Execute the method to test indirectly through a public method
        boolean result = invokePrivateMethod(parser, "jj_3R_48");
        // Verify the result
        assertTrue(result, "jj_3R_48 should return true when FUNCTION_FALSE token is scanned.");
    }

    @Test
    public void testJj_3R_48_NotFunctionFalseToken() {
        // Mocking the behavior of the token_source to return a non FUNCTION_FALSE token
        parser.token_source = mock(XPathParserTokenManager.class);
        Token nonFunctionFalseToken = new Token();
        // Not FUNCTION_FALSE
        nonFunctionFalseToken.kind = -1;
        when(parser.token_source.getNextToken()).thenReturn(nonFunctionFalseToken);
        // Execute the method to test indirectly through a public method
        boolean result = invokePrivateMethod(parser, "jj_3R_48");
        // Verify the result
        assertFalse(result, "jj_3R_48 should return false when the token is not FUNCTION_FALSE.");
    }

    private boolean invokePrivateMethod(XPathParser parser, String methodName) {
        try {
            java.lang.reflect.Method method = XPathParser.class.getDeclaredMethod(methodName);
            method.setAccessible(true);
            return (boolean) method.invoke(parser);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
