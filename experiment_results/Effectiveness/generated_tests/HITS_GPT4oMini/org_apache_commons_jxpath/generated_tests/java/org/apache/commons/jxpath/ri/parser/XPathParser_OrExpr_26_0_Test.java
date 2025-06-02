package org.apache.commons.jxpath.ri.parser;

import org.apache.commons.jxpath.ri.Compiler;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;

public class XPathParser_OrExpr_26_0_Test {

    private XPathParser parser;

    private Compiler mockCompiler;

    @BeforeEach
    public void setUp() {
        // Create a mock compiler to use in tests
        mockCompiler = mock(Compiler.class);
        parser = new XPathParser(new XPathParserTokenManager(new SimpleCharStream(System.in, 1, 1)));
        parser.setCompiler(mockCompiler);
    }

    @Test
    public void testOrExpr_singleAndExpression() throws ParseException {
        // Mock behavior for AndExpr to return a specific value
        Object expected = new Object();
        when(parser.AndExpr()).thenReturn(expected);
        when(mockCompiler.or(any())).thenReturn(expected);
        Object result = parser.OrExpr();
        assertEquals(expected, result);
        verify(parser, times(1)).AndExpr();
        verify(mockCompiler, times(1)).or(any());
    }

    @Test
    public void testOrExpr_multipleAndExpressions() throws ParseException {
        // Mock behavior for AndExpr to return multiple values
        Object firstAndExpr = new Object();
        Object secondAndExpr = new Object();
        when(parser.AndExpr()).thenReturn(firstAndExpr).thenReturn(secondAndExpr);
        when(mockCompiler.or(any())).thenReturn(new Object());
        Object result = parser.OrExpr();
        assertNotNull(result);
        verify(parser, times(2)).AndExpr();
        verify(mockCompiler, times(1)).or(any());
    }

    @Test
    public void testOrExpr_noAndExpressions() throws ParseException {
        // Mock behavior for AndExpr to return null
        when(parser.AndExpr()).thenReturn(null);
        Object result = parser.OrExpr();
        assertNull(result);
        verify(parser, times(1)).AndExpr();
        verify(mockCompiler, never()).or(any());
    }

    @Test
    public void testOrExpr_withNoOrOperator() throws ParseException {
        // Mock behavior for AndExpr to return a value and simulate no OR token
        Object expected = new Object();
        when(parser.AndExpr()).thenReturn(expected);
        when(mockCompiler.or(any())).thenReturn(expected);
        Object result = parser.OrExpr();
        assertEquals(expected, result);
        verify(parser, times(1)).AndExpr();
        verify(mockCompiler, never()).or(any());
    }

    @Test
    public void testOrExpr_withMultipleOrOperators() throws ParseException {
        // Mock behavior for AndExpr to return values and simulate multiple OR tokens
        Object firstAndExpr = new Object();
        Object secondAndExpr = new Object();
        when(parser.AndExpr()).thenReturn(firstAndExpr).thenReturn(secondAndExpr);
        when(mockCompiler.or(any())).thenReturn(new Object());
        Object result = parser.OrExpr();
        assertNotNull(result);
        verify(parser, times(2)).AndExpr();
        verify(mockCompiler, times(1)).or(any());
    }
}
