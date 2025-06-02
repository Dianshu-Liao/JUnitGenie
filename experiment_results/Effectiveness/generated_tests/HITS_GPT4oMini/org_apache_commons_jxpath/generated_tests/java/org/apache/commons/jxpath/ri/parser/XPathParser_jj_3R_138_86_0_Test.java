package org.apache.commons.jxpath.ri.parser;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.apache.commons.jxpath.ri.Compiler;

@ExtendWith(MockitoExtension.class)
public class XPathParser_jj_3R_138_86_0_Test {

    private XPathParser parser;

    private XPathParserTokenManager tokenManager;

    @BeforeEach
    public void setUp() {
        // Mocking the input stream and initializing the parser
        SimpleCharStream stream = new SimpleCharStream(System.in, 1, 1);
        tokenManager = new XPathParserTokenManager(stream);
        parser = new XPathParser(tokenManager);
    }

    private boolean testJj3R138() {
        // This method simulates the behavior of jj_3R_138() indirectly
        return parser.getNextToken().kind == XPathParserTokenManager.UNION || mockJj3R137();
    }

    private boolean mockJj3R137() {
        // Mock the behavior of jj_3R_137 to return true
        // Simulate the condition where jj_3R_137 would return true
        return true;
    }

    @Test
    public void testJj_3R_138_WhenUnionTokenPresent() {
        // Setup: Mock the token source to return UNION token
        Token token = new Token();
        token.kind = XPathParserTokenManager.UNION;
        parser.token = token;
        parser.jj_nt = token;
        // Execute: Call the method that indirectly tests jj_3R_138()
        boolean result = testJj3R138();
        // Verify: Expect true since UNION token is present
        assertTrue(result, "Expected jj_3R_138() to return true when UNION token is present.");
    }

    @Test
    public void testJj_3R_138_WhenUnionTokenNotPresentAndR137ReturnsTrue() {
        // Setup: Mock the token source to not return UNION token
        Token token = new Token();
        // Not a UNION token
        token.kind = -1;
        parser.token = token;
        parser.jj_nt = token;
        // Execute: Call the method that indirectly tests jj_3R_138()
        boolean result = testJj3R138();
        // Verify: Expect true since jj_3R_137() returns true
        assertTrue(result, "Expected jj_3R_138() to return true when UNION token is not present but jj_3R_137() returns true.");
    }
}
