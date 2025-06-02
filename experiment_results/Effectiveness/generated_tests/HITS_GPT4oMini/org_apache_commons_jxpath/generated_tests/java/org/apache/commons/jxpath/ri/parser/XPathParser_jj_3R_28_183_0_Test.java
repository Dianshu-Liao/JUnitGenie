package org.apache.commons.jxpath.ri.parser;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.apache.commons.jxpath.ri.Compiler;

@ExtendWith(MockitoExtension.class)
public class XPathParser_jj_3R_28_183_0_Test {

    private XPathParser parser;

    private XPathParserTokenManager tokenManager;

    private static final int FUNCTION_POSITION = 1;

    private static final int OTHER_TOKEN = 2;

    @BeforeEach
    public void setUp() {
        tokenManager = mock(XPathParserTokenManager.class);
        parser = new XPathParser(tokenManager);
    }

    @Test
    public void testJj_3R_28_FunctionPositionToken() {
        // Arrange
        Token functionPositionToken = mock(Token.class);
        when(functionPositionToken.kind).thenReturn(FUNCTION_POSITION);
        when(tokenManager.getNextToken()).thenReturn(functionPositionToken);
        // Act
        // Use reflection to access the private method
        boolean result = invokePrivateMethod("jj_3R_28");
        // Assert
        assertTrue(result, "Expected jj_3R_28 to return true when FUNCTION_POSITION is matched");
    }

    @Test
    public void testJj_3R_28_NotFunctionPositionToken() {
        // Arrange
        Token otherToken = mock(Token.class);
        when(otherToken.kind).thenReturn(OTHER_TOKEN);
        when(tokenManager.getNextToken()).thenReturn(otherToken);
        // Act
        // Use reflection to access the private method
        boolean result = invokePrivateMethod("jj_3R_28");
        // Assert
        assertFalse(result, "Expected jj_3R_28 to return false when FUNCTION_POSITION is not matched");
    }

    // Helper method to invoke the private method using reflection
    private boolean invokePrivateMethod(String methodName) {
        try {
            java.lang.reflect.Method method = XPathParser.class.getDeclaredMethod(methodName);
            method.setAccessible(true);
            return (boolean) method.invoke(parser);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
