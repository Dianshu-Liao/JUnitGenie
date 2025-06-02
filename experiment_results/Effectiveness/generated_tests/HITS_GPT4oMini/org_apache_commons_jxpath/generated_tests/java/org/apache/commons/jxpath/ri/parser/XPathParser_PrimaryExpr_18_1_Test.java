package org.apache.commons.jxpath.ri.parser;

import org.apache.commons.jxpath.ri.Compiler;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.io.ByteArrayInputStream;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class XPathParser_PrimaryExpr_18_1_Test {

    private XPathParser parser;

    private Compiler mockCompiler;

    @BeforeEach
    public void setUp() {
        mockCompiler = Mockito.mock(Compiler.class);
        parser = new XPathParser(new XPathParserTokenManager(new SimpleCharStream(new ByteArrayInputStream(new byte[0]), 1, 1)));
        parser.setCompiler(mockCompiler);
    }

    @Test
    public void testPrimaryExpr_VariableReference() throws ParseException {
        parser.token = new Token();
        // Assuming 1 corresponds to VARIABLE
        parser.token.kind = 1;
        Object expected = new Object();
        when(mockCompiler.variableReference(any())).thenReturn(expected);
        Object result = parser.PrimaryExpr();
        assertEquals(expected, result);
    }

    @Test
    public void testPrimaryExpr_Expression() throws ParseException {
        parser.token = new Token();
        // Assuming 81 corresponds to a valid token for Expression
        parser.token.kind = 81;
        Object expected = new Object();
        when(mockCompiler.function(any(), any())).thenReturn(expected);
        Object result = parser.PrimaryExpr();
        assertEquals(expected, result);
    }

    @Test
    public void testPrimaryExpr_Literal() throws ParseException {
        parser.token = new Token();
        // Assuming 2 corresponds to LITERAL
        parser.token.kind = 2;
        parser.token.image = "'test'";
        String expected = "test";
        when(mockCompiler.literal(anyString())).thenReturn(expected);
        Object result = parser.PrimaryExpr();
        assertEquals(expected, result);
    }

    @Test
    public void testPrimaryExpr_Number() throws ParseException {
        parser.token = new Token();
        // Assuming 3 corresponds to NUMBER
        parser.token.kind = 3;
        parser.token.image = "123";
        Object expected = 123;
        when(mockCompiler.number(anyString())).thenReturn(expected);
        Object result = parser.PrimaryExpr();
        assertEquals(expected, result);
    }

    @Test
    public void testPrimaryExpr_CoreFunctionCall() throws ParseException {
        parser.token = new Token();
        // Assuming 4 corresponds to FUNCTION_LAST
        parser.token.kind = 4;
        Object expected = new Object();
        when(mockCompiler.function(anyInt(), any())).thenReturn(expected);
        Object result = parser.PrimaryExpr();
        assertEquals(expected, result);
    }

    @Test
    public void testPrimaryExpr_InvalidToken() {
        parser.token = new Token();
        // Invalid token kind
        parser.token.kind = -1;
        assertThrows(ParseException.class, () -> {
            parser.PrimaryExpr();
        });
    }
}
