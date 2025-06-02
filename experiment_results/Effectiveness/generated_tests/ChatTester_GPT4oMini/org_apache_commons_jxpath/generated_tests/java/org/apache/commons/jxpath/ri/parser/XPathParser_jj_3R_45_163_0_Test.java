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

public class XPathParser_jj_3R_45_163_0_Test {

    private XPathParser parser;

    private XPathParserTokenManager tokenManager;

    @BeforeEach
    public void setUp() {
        tokenManager = Mockito.mock(XPathParserTokenManager.class);
        parser = new XPathParser(tokenManager);
    }

    @Test
    public void testJj_3R_45_TokenFound() throws Exception {
        // Simulate the condition where FUNCTION_BOOLEAN token is found
        Token functionBooleanToken = new Token();
        // Assuming FUNCTION_BOOLEAN is a constant in Compiler
        functionBooleanToken.kind = Compiler.FUNCTION_BOOLEAN;
        Mockito.when(tokenManager.getNextToken()).thenReturn(functionBooleanToken);
        // Set the token source to the parser
        parser.ReInit(tokenManager);
        // Use reflection to invoke the private method
        Method method = XPathParser.class.getDeclaredMethod("jj_3R_45");
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(parser);
        assertTrue(result, "Expected jj_3R_45 to return true when FUNCTION_BOOLEAN is found");
    }

    @Test
    public void testJj_3R_45_TokenNotFound() throws Exception {
        // Simulate the condition where FUNCTION_BOOLEAN token is not found
        Token otherToken = new Token();
        // Some other token that is not FUNCTION_BOOLEAN
        otherToken.kind = -1;
        Mockito.when(tokenManager.getNextToken()).thenReturn(otherToken);
        // Set the token source to the parser
        parser.ReInit(tokenManager);
        // Use reflection to invoke the private method
        Method method = XPathParser.class.getDeclaredMethod("jj_3R_45");
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(parser);
        assertFalse(result, "Expected jj_3R_45 to return false when FUNCTION_BOOLEAN is not found");
    }
}
