package org.apache.commons.jxpath.ri.parser;

import org.apache.commons.jxpath.ri.Compiler;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;

public class XPathParser_PrimaryExpr_18_0_Test {

    private XPathParser parser;

    private Compiler mockCompiler;

    private XPathParserTokenManager mockTokenManager;

    @BeforeEach
    public void setUp() {
        mockCompiler = mock(Compiler.class);
        mockTokenManager = mock(XPathParserTokenManager.class);
        parser = new XPathParser(mockTokenManager);
        parser.setCompiler(mockCompiler);
    }

    @Test
    public void testPrimaryExpr_Variable() throws Exception {
        // Arrange
        Token variableToken = new Token();
        variableToken.kind = XPathParserTokenManager.VARIABLE;
        parser.token = variableToken;
        parser.jj_nt = variableToken;
        // Mocking the behavior of VariableReference
        when(parser.VariableReference()).thenReturn("mockVariable");
        // Act
        Object result = parser.PrimaryExpr();
        // Assert
        assertEquals("mockVariable", result);
    }

    @Test
    public void testPrimaryExpr_Literal() throws Exception {
        // Arrange
        Token literalToken = new Token();
        literalToken.kind = XPathParserTokenManager.Literal;
        literalToken.image = "'mockLiteral'";
        parser.token = literalToken;
        parser.jj_nt = literalToken;
        // Mocking the behavior of compiler.literal
        when(mockCompiler.literal("mockLiteral")).thenReturn("mockLiteralResult");
        // Act
        Object result = parser.PrimaryExpr();
        // Assert
        assertEquals("mockLiteralResult", result);
    }

    @Test
    public void testPrimaryExpr_Number() throws Exception {
        // Arrange
        Token numberToken = new Token();
        numberToken.kind = XPathParserTokenManager.Number;
        numberToken.image = "123";
        parser.token = numberToken;
        parser.jj_nt = numberToken;
        // Mocking the behavior of compiler.number
        when(mockCompiler.number("123")).thenReturn(123);
        // Act
        Object result = parser.PrimaryExpr();
        // Assert
        assertEquals(123, result);
    }

    @Test
    public void testPrimaryExpr_FunctionCall() throws Exception {
        // Arrange
        Token functionToken = new Token();
        // Example function token
        functionToken.kind = XPathParserTokenManager.FUNCTION_COUNT;
        parser.token = functionToken;
        parser.jj_nt = functionToken;
        // Mocking the behavior of FunctionCall
        when(parser.FunctionCall()).thenReturn("mockFunctionCallResult");
        // Act
        Object result = parser.PrimaryExpr();
        // Assert
        assertEquals("mockFunctionCallResult", result);
    }

    @Test
    public void testPrimaryExpr_Expression() throws Exception {
        // Arrange
        Token expressionToken = new Token();
        // Assuming 81 is the token kind for expressions
        expressionToken.kind = 81;
        parser.token = expressionToken;
        parser.jj_nt = expressionToken;
        // Mocking the behavior of Expression
        when(parser.Expression()).thenReturn("mockExpressionResult");
        // Act
        Object result = parser.PrimaryExpr();
        // Assert
        assertEquals("mockExpressionResult", result);
    }

    @Test
    public void testPrimaryExpr_InvalidToken() {
        // Arrange
        Token invalidToken = new Token();
        // Invalid token kind
        invalidToken.kind = -1;
        parser.token = invalidToken;
        parser.jj_nt = invalidToken;
        // Act & Assert
        Exception exception = assertThrows(ParseException.class, () -> {
            parser.PrimaryExpr();
        });
        assertNotNull(exception);
    }
}
