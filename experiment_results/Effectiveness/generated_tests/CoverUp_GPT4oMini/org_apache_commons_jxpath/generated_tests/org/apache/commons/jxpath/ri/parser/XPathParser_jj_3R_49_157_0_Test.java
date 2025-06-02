package org.apache.commons.jxpath.ri.parser;

import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.apache.commons.jxpath.ri.Compiler;

@ExtendWith(MockitoExtension.class)
class XPathParser_jj_3R_49_157_0_Test {

    private XPathParser parser;

    private XPathParserTokenManager tokenManager;

    @BeforeEach
    void setUp() {
        // Initialize the token manager mock
        tokenManager = mock(XPathParserTokenManager.class);
        // Create the XPathParser with the mocked token manager
        parser = new XPathParser(tokenManager);
    }

    @Test
    void testJj_3R_49_FunctionNullToken() throws Exception {
        // Arrange: set up the token to match FUNCTION_NULL
        Token functionNullToken = new Token();
        functionNullToken.kind = XPathParserTokenManager.FUNCTION_NULL;
        when(tokenManager.getNextToken()).thenReturn(functionNullToken);
        // Act: invoke the private method using reflection
        boolean result = invokePrivateMethod("jj_3R_49");
        // Assert: the method should return true
        assertTrue(result);
    }

    @Test
    void testJj_3R_49_NonFunctionNullToken() throws Exception {
        // Arrange: set up the token to not match FUNCTION_NULL
        Token nonFunctionNullToken = new Token();
        // Use a kind that does not match FUNCTION_NULL
        nonFunctionNullToken.kind = -1;
        when(tokenManager.getNextToken()).thenReturn(nonFunctionNullToken);
        // Act: invoke the private method using reflection
        boolean result = invokePrivateMethod("jj_3R_49");
        // Assert: the method should return false
        assertFalse(result);
    }

    private boolean invokePrivateMethod(String methodName) throws Exception {
        // Use reflection to access the private method
        java.lang.reflect.Method method = XPathParser.class.getDeclaredMethod(methodName);
        method.setAccessible(true);
        return (boolean) method.invoke(parser);
    }
}
