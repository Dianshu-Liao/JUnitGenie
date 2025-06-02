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

@ExtendWith(MockitoExtension.class)
public class XPathParser_jj_3R_40_169_0_Test {

    private XPathParser xpathParser;

    private XPathParserTokenManager tokenManager;

    private Token mockToken;

    @BeforeEach
    public void setUp() {
        tokenManager = mock(XPathParserTokenManager.class);
        xpathParser = new XPathParser(tokenManager);
        mockToken = mock(Token.class);
    }

    @Test
    public void testJj_3R_40_WhenFunctionSubstringAfterTokenIsPresent() throws Exception {
        // Arrange
        when(tokenManager.getNextToken()).thenReturn(mockToken);
        when(mockToken.kind).thenReturn(XPathParser.FUNCTION_SUBSTRING_AFTER);
        // Act
        Method method = XPathParser.class.getDeclaredMethod("jj_3R_40");
        // Allow access to the private method
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(xpathParser);
        // Assert
        assertTrue(result);
    }

    @Test
    public void testJj_3R_40_WhenFunctionSubstringAfterTokenIsNotPresent() throws Exception {
        // Arrange
        when(tokenManager.getNextToken()).thenReturn(mockToken);
        // Assuming -1 indicates no valid token
        when(mockToken.kind).thenReturn(-1);
        // Act
        Method method = XPathParser.class.getDeclaredMethod("jj_3R_40");
        // Allow access to the private method
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(xpathParser);
        // Assert
        assertFalse(result);
    }
}
