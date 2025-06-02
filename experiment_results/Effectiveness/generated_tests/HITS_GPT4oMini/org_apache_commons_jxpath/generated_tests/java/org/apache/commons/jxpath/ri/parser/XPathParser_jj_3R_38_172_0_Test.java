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

public class XPathParser_jj_3R_38_172_0_Test {

    private XPathParser parser;

    private XPathParserTokenManager tokenManager;

    @BeforeEach
    public void setUp() {
        tokenManager = mock(XPathParserTokenManager.class);
        parser = new XPathParser(tokenManager);
    }

    @Test
    public void testJj_3R_38_WhenTokenIsFunctionContains() throws Exception {
        // Arrange
        Token functionContainsToken = mock(Token.class);
        when(functionContainsToken.kind).thenReturn(XPathParser.FUNCTION_CONTAINS);
        when(tokenManager.getNextToken()).thenReturn(functionContainsToken);
        parser.token = functionContainsToken;
        // Act
        Method method = XPathParser.class.getDeclaredMethod("jj_3R_38");
        // Make the private method accessible
        method.setAccessible(true);
        boolean result = (Boolean) method.invoke(parser);
        // Assert
        assertTrue(result, "Expected method to return true when FUNCTION_CONTAINS token is scanned.");
    }

    @Test
    public void testJj_3R_38_WhenTokenIsNotFunctionContains() throws Exception {
        // Arrange
        Token someOtherToken = mock(Token.class);
        // Use an arbitrary value not equal to FUNCTION_CONTAINS
        when(someOtherToken.kind).thenReturn(999);
        when(tokenManager.getNextToken()).thenReturn(someOtherToken);
        parser.token = someOtherToken;
        // Act
        Method method = XPathParser.class.getDeclaredMethod("jj_3R_38");
        // Make the private method accessible
        method.setAccessible(true);
        boolean result = (Boolean) method.invoke(parser);
        // Assert
        assertFalse(result, "Expected method to return false when FUNCTION_CONTAINS token is not scanned.");
    }
}
