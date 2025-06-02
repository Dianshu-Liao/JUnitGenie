package org.apache.commons.jxpath.ri.parser;

import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.ri.Compiler;

public class // Additional tests can be added to cover more edge cases
XPathParser_AdditiveExpr_30_2_Test {

    @Mock
    private Compiler compiler;

    @Mock
    private XPathParserTokenManager tokenManager;

    @InjectMocks
    private XPathParser xPathParser;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        xPathParser = new XPathParser(tokenManager);
    }

    @Test
    public void testAdditiveExpr_SingleSubtractiveExpr() throws ParseException {
        // Setup mock behavior
        when(xPathParser.SubtractiveExpr()).thenReturn(5);
        // Simulate PLUS token
        when(xPathParser.jj_nt.kind).thenReturn(XPathParser.PLUS);
        // Call the method
        Object result = xPathParser.AdditiveExpr();
        // Verify
        assertEquals(5, result);
        verify(compiler, never()).sum(any());
    }

    @Test
    public void testAdditiveExpr_MultipleSubtractiveExpr() throws ParseException {
        // Setup mock behavior
        when(xPathParser.SubtractiveExpr()).thenReturn(5).thenReturn(3);
        // Simulate PLUS tokens
        when(xPathParser.jj_nt.kind).thenReturn(XPathParser.PLUS, XPathParser.PLUS, -1);
        // Call the method
        Object result = xPathParser.AdditiveExpr();
        // Verify
        verify(compiler).sum(new Object[] { 5, 3 });
        assertNotNull(result);
    }

    @Test
    public void testAdditiveExpr_NoSubtractiveExpr() throws ParseException {
        // Setup mock behavior
        when(xPathParser.SubtractiveExpr()).thenThrow(new ParseException("Error"));
        // Call the method and expect an exception
        assertThrows(ParseException.class, () -> {
            xPathParser.AdditiveExpr();
        });
    }

    @Test
    public void testAdditiveExpr_EmptyList() throws ParseException {
        // Setup mock behavior
        when(xPathParser.SubtractiveExpr()).thenReturn(5);
        // No PLUS token
        when(xPathParser.jj_nt.kind).thenReturn(-1);
        // Call the method
        Object result = xPathParser.AdditiveExpr();
        // Verify
        assertEquals(5, result);
        verify(compiler, never()).sum(any());
    }

    @Test
    public void testAdditiveExpr_SinglePlusWithMultipleSubtractiveExpr() throws ParseException {
        // Setup mock behavior
        when(xPathParser.SubtractiveExpr()).thenReturn(10).thenReturn(20);
        // Simulate PLUS tokens
        when(xPathParser.jj_nt.kind).thenReturn(XPathParser.PLUS, XPathParser.PLUS, -1);
        // Call the method
        Object result = xPathParser.AdditiveExpr();
        // Verify
        verify(compiler).sum(new Object[] { 10, 20 });
        assertNotNull(result);
    }

    @Test
    public void testAdditiveExpr_NoTokens() throws ParseException {
        // Setup mock behavior
        when(xPathParser.SubtractiveExpr()).thenReturn(15);
        // No PLUS token
        when(xPathParser.jj_nt.kind).thenReturn(-1);
        // Call the method
        Object result = xPathParser.AdditiveExpr();
        // Verify
        assertEquals(15, result);
        verify(compiler, never()).sum(any());
    }
}
