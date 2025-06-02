package org.apache.commons.jxpath.ri.parser;

import org.apache.commons.jxpath.ri.Compiler;
import org.apache.commons.jxpath.ri.parser.XPathParser;
import org.apache.commons.jxpath.ri.parser.XPathParserTokenManager;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

class XPathParser_SubtractiveExpr_31_1_Test {

    private XPathParser parser;

    private Compiler mockCompiler;

    private XPathParserTokenManager mockTokenManager;

    // Assuming MINUS is represented by 1
    private static final int MINUS = 1;

    // Assuming EOF is represented by 0
    private static final int EOF = 0;

    @BeforeEach
    void setUp() {
        InputStream inputStream = new ByteArrayInputStream("test input".getBytes());
        parser = new XPathParser(inputStream);
        mockCompiler = mock(Compiler.class);
        mockTokenManager = mock(XPathParserTokenManager.class);
        parser.setCompiler(mockCompiler);
        parser.token_source = mockTokenManager;
    }

    @Test
    void testSubtractiveExprWithSingleMinus() throws Exception {
        // Setup the token manager to return a MINUS token
        when(mockTokenManager.getNextToken()).thenReturn(createToken(MINUS, "-"), createToken(EOF, ""));
        // Mock the behavior of MultiplicativeExpr
        Object mockResult = new Object();
        when(parser.MultiplicativeExpr()).thenReturn(mockResult);
        when(mockCompiler.minus(any(), any())).thenReturn(mockResult);
        // Invoke the method using reflection
        Object result = invokePrivateMethod("SubtractiveExpr");
        // Verify results
        assertEquals(mockResult, result);
        verify(mockCompiler, times(1)).minus(any(), any());
    }

    @Test
    void testSubtractiveExprWithNoMinus() throws Exception {
        // Setup the token manager to return an EOF token immediately
        when(mockTokenManager.getNextToken()).thenReturn(createToken(EOF, ""));
        // Mock the behavior of MultiplicativeExpr
        Object mockResult = new Object();
        when(parser.MultiplicativeExpr()).thenReturn(mockResult);
        // Invoke the method using reflection
        Object result = invokePrivateMethod("SubtractiveExpr");
        // Verify results
        assertEquals(mockResult, result);
        verify(mockCompiler, never()).minus(any(), any());
    }

    private Object invokePrivateMethod(String methodName) throws Exception {
        java.lang.reflect.Method method = XPathParser.class.getDeclaredMethod(methodName);
        method.setAccessible(true);
        return method.invoke(parser);
    }

    private Token createToken(int kind, String image) {
        // Adjust this line if the constructor of Token is different
        // Updated to use the no-argument constructor
        return new Token();
    }
}
