package org.apache.commons.jxpath.ri.parser;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.apache.commons.jxpath.ri.Compiler;

@ExtendWith(MockitoExtension.class)
public class XPathParser_jj_3R_111_71_2_Test {

    private XPathParser parser;

    private XPathParserTokenManager tokenManager;

    @BeforeEach
    public void setUp() {
        String input = "";
        InputStream stream = new ByteArrayInputStream(input.getBytes());
        tokenManager = mock(XPathParserTokenManager.class);
        parser = new XPathParser(tokenManager);
    }

    @Test
    public void testJj_3R_111_WithAxisPrecedingSibling() throws Exception {
        Token axisToken = mock(Token.class);
        when(axisToken.kind).thenReturn(XPathParserTokenManager.AXIS_PRECEDING_SIBLING);
        when(tokenManager.getNextToken()).thenReturn(axisToken);
        parser.token = axisToken;
        boolean result = (boolean) XPathParser.class.getDeclaredMethod("jj_3R_111").invoke(parser);
        assertTrue(result, "Expected jj_3R_111 to return true when AXIS_PRECEDING_SIBLING token is present.");
    }

    @Test
    public void testJj_3R_111_WithoutAxisPrecedingSibling() throws Exception {
        Token otherToken = mock(Token.class);
        // Using a mock token kind that is not AXIS_PRECEDING_SIBLING
        // Assuming -1 is an invalid token kind
        when(otherToken.kind).thenReturn(-1);
        when(tokenManager.getNextToken()).thenReturn(otherToken);
        parser.token = otherToken;
        boolean result = (boolean) XPathParser.class.getDeclaredMethod("jj_3R_111").invoke(parser);
        assertFalse(result, "Expected jj_3R_111 to return false when AXIS_PRECEDING_SIBLING token is not present.");
    }
}
