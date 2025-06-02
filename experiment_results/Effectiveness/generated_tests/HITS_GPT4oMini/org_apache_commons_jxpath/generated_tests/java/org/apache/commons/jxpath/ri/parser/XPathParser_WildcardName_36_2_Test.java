package org.apache.commons.jxpath.ri.parser;

import org.apache.commons.jxpath.ri.Compiler;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class XPathParser_WildcardName_36_2_Test {

    private XPathParser parser;

    private Compiler mockCompiler;

    @BeforeEach
    public void setUp() {
        mockCompiler = mock(Compiler.class);
        parser = new XPathParser(new XPathParserTokenManager(new SimpleCharStream(System.in, 1, 1)));
        parser.setCompiler(mockCompiler);
    }

    @Test
    public void testWildcardName_WithToken89() throws ParseException {
        parser.token = new Token();
        // Simulating token kind 89
        parser.token.kind = 89;
        parser.jj_nt = parser.token;
        Object result = parser.WildcardName();
        assertNotNull(result);
        verify(mockCompiler).qname(null, parser.token.image);
    }

    @Test
    public void testWildcardName_WithNCName() throws ParseException {
        parser.token = new Token();
        // Simulating NCName token
        // Replace with actual integer value for NCName token
        parser.token.kind = 1;
        parser.jj_nt = parser.token;
        when(mockCompiler.qname(anyString(), eq(parser.token.image))).thenReturn("mockQName");
        Object result = parser.WildcardName();
        assertEquals("mockQName", result);
        verify(mockCompiler).qname(null, parser.token.image);
    }

    @Test
    public void testWildcardName_WithSecondNCName() throws ParseException {
        parser.token = new Token();
        // Simulating token kind 80
        parser.token.kind = 80;
        parser.jj_nt = parser.token;
        // Simulating the second NCName token
        Token secondToken = new Token();
        // Replace with actual integer value for NCName token
        secondToken.kind = 1;
        secondToken.image = "secondName";
        parser.token.next = secondToken;
        when(mockCompiler.qname(parser.token.image, secondToken.image)).thenReturn("mockQName");
        Object result = parser.WildcardName();
        assertEquals("mockQName", result);
        verify(mockCompiler).qname(parser.token.image, secondToken.image);
    }

    @Test
    public void testWildcardName_WithInvalidToken() {
        parser.token = new Token();
        // Simulating an invalid token
        parser.token.kind = -1;
        parser.jj_nt = parser.token;
        Exception exception = assertThrows(ParseException.class, () -> {
            parser.WildcardName();
        });
        assertNotNull(exception);
    }
}
