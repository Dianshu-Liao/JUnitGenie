package org.apache.commons.jxpath.ri.parser;

import java.io.StringReader;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

class XPathParserTokenManager_jjMoveStringLiteralDfa9_0_14_1_Test {

    private XPathParserTokenManager tokenManager;

    private SimpleCharStream charStream;

    @BeforeEach
    void setUp() {
        charStream = new SimpleCharStream(new StringReader(""), 1, 1);
        tokenManager = new XPathParserTokenManager(charStream);
    }

    @Test
    void testGetNextToken_withNoActiveTokens() {
        charStream = new SimpleCharStream(new StringReader(""), 1, 1);
        tokenManager = new XPathParserTokenManager(charStream);
        Token result = tokenManager.getNextToken();
        // Expecting to return a token indicating end of file
        assertEquals(0, result.kind);
    }

    @Test
    void testGetNextToken_withActiveToken45() {
        charStream = new SimpleCharStream(new StringReader("-"), 1, 1);
        tokenManager = new XPathParserTokenManager(charStream);
        Token result = tokenManager.getNextToken();
        // Expecting to recognize '-' as a token
        // Assuming 39 is the token kind for '-'
        assertEquals(39, result.kind);
    }

    @Test
    void testGetNextToken_withActiveToken58() {
        charStream = new SimpleCharStream(new StringReader(":"), 1, 1);
        tokenManager = new XPathParserTokenManager(charStream);
        Token result = tokenManager.getNextToken();
        // Expecting to recognize ':' as a token
        // Assuming 40 is the token kind for ':'
        assertEquals(40, result.kind);
    }

    @Test
    void testGetNextToken_withActiveToken101() {
        charStream = new SimpleCharStream(new StringReader("e"), 1, 1);
        tokenManager = new XPathParserTokenManager(charStream);
        Token result = tokenManager.getNextToken();
        // Expecting to recognize 'e' as a token
        // Assuming 53 is the token kind for 'e'
        assertEquals(53, result.kind);
    }
}
