package org.apache.commons.jxpath.ri.parser;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import org.apache.commons.jxpath.ri.Compiler;

public class XPathParser_PrimaryExpr_18_3_Test {

    private XPathParser parser;

    private Compiler mockCompiler;

    private XPathParserTokenManager mockTokenManager;

    @BeforeEach
    public void setUp() {
        InputStream inputStream = new ByteArrayInputStream("test input".getBytes());
        parser = new XPathParser(inputStream);
        mockCompiler = Mockito.mock(Compiler.class);
        mockTokenManager = Mockito.mock(XPathParserTokenManager.class);
        parser.setCompiler(mockCompiler);
        parser.token_source = mockTokenManager;
    }

    @Test
    public void testPrimaryExpr_VariableReference() throws Exception {
        // Mocking a variable token
        Token variableToken = new Token();
        // assuming VARIABLE is defined
        variableToken.kind = XPathParser.VARIABLE;
        parser.token = variableToken;
        Mockito.when(mockTokenManager.getNextToken()).thenReturn(variableToken);
        Mockito.when(mockCompiler.variableReference(Mockito.any())).thenReturn(new Object());
        Object result = invokePrivateMethod("PrimaryExpr");
        assertNotNull(result);
        Mockito.verify(mockCompiler).variableReference(Mockito.any());
    }

    @Test
    public void testPrimaryExpr_Literal() throws Exception {
        // Mocking a literal token
        Token literalToken = new Token();
        // assuming Literal is defined
        literalToken.kind = XPathParser.Literal;
        literalToken.image = "'test'";
        parser.token = literalToken;
        Mockito.when(mockTokenManager.getNextToken()).thenReturn(literalToken);
        Mockito.when(mockCompiler.literal(Mockito.anyString())).thenReturn(new Object());
        Object result = invokePrivateMethod("PrimaryExpr");
        assertNotNull(result);
        Mockito.verify(mockCompiler).literal(Mockito.eq("test"));
    }

    @Test
    public void testPrimaryExpr_Number() throws Exception {
        // Mocking a number token
        Token numberToken = new Token();
        // assuming Number is defined
        numberToken.kind = XPathParser.Number;
        numberToken.image = "123";
        parser.token = numberToken;
        Mockito.when(mockTokenManager.getNextToken()).thenReturn(numberToken);
        Mockito.when(mockCompiler.number(Mockito.anyString())).thenReturn(new Object());
        Object result = invokePrivateMethod("PrimaryExpr");
        assertNotNull(result);
        Mockito.verify(mockCompiler).number(Mockito.eq("123"));
    }

    @Test
    public void testPrimaryExpr_FunctionCall() throws Exception {
        // Mocking a function token
        Token functionToken = new Token();
        // assuming FUNCTION_NAME is defined
        functionToken.kind = XPathParser.FUNCTION_NAME;
        parser.token = functionToken;
        Mockito.when(mockTokenManager.getNextToken()).thenReturn(functionToken);
        Mockito.when(mockCompiler.function(Mockito.any(), Mockito.any())).thenReturn(new Object());
        Object result = invokePrivateMethod("PrimaryExpr");
        assertNotNull(result);
        Mockito.verify(mockCompiler).function(Mockito.any(), Mockito.any());
    }

    @Test
    public void testPrimaryExpr_InvalidToken() {
        // Mocking an invalid token
        Token invalidToken = new Token();
        // invalid token
        invalidToken.kind = -1;
        parser.token = invalidToken;
        Mockito.when(mockTokenManager.getNextToken()).thenReturn(invalidToken);
        Exception exception = assertThrows(ParseException.class, () -> {
            invokePrivateMethod("PrimaryExpr");
        });
        assertNotNull(exception);
    }

    private Object invokePrivateMethod(String methodName) throws Exception {
        java.lang.reflect.Method method = XPathParser.class.getDeclaredMethod(methodName);
        method.setAccessible(true);
        return method.invoke(parser);
    }
}
