package org.apache.commons.jxpath.ri.parser;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.apache.commons.jxpath.ri.Compiler;

public class XPathParser_WildcardName_36_1_Test {

    private XPathParser parser;

    private Compiler mockCompiler;

    @BeforeEach
    public void setUp() {
        mockCompiler = Mockito.mock(Compiler.class);
        parser = new XPathParser(new XPathParserTokenManager(new SimpleCharStream(System.in, 1, 1)));
        parser.setCompiler(mockCompiler);
    }

    @Test
    public void testWildcardNameSingleName() throws ParseException {
        // Setup: Simulate token for NCName
        parser.token = new Token();
        // Assuming 1 is the value for NCName
        parser.token.kind = 1;
        parser.token.image = "name1";
        parser.jj_nt = parser.token;
        // Mocking the compiler's response
        Mockito.when(mockCompiler.qname(null, "name1")).thenReturn("qname:name1");
        // Execute: Call the method under test
        Object result = parser.WildcardName();
        // Verify: Check the result
        assertEquals("qname:name1", result);
    }

    @Test
    public void testWildcardNameQualifiedName() throws ParseException {
        // Setup: Simulate token for NCName and then another token for the qualified name
        parser.token = new Token();
        // Assuming 1 is the value for NCName
        parser.token.kind = 1;
        parser.token.image = "name1";
        parser.jj_nt = parser.token;
        // Simulate the next token for the qualified name
        Token nextToken = new Token();
        // Assuming 2 is the value for DOT
        nextToken.kind = 2;
        parser.jj_nt.next = nextToken;
        // Simulate the next NCName
        Token nextNCNameToken = new Token();
        // Assuming 1 is the value for NCName
        nextNCNameToken.kind = 1;
        nextNCNameToken.image = "name2";
        nextToken.next = nextNCNameToken;
        // Mocking the compiler's response for qualified name
        Mockito.when(mockCompiler.qname("name1", "name2")).thenReturn("qname:name1.name2");
        // Execute: Call the method under test
        Object result = parser.WildcardName();
        // Verify: Check the result
        assertEquals("qname:name1.name2", result);
    }

    @Test
    public void testWildcardNameInvalidToken() {
        // Setup: Simulate an invalid token
        parser.token = new Token();
        // Invalid token kind
        parser.token.kind = -1;
        parser.jj_nt = parser.token;
        // Execute & Verify: Expect ParseException to be thrown
        assertThrows(ParseException.class, () -> {
            parser.WildcardName();
        });
    }
}
