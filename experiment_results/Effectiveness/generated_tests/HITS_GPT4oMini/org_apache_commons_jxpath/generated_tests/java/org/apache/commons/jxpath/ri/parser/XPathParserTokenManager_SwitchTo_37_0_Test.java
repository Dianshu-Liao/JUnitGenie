package org.apache.commons.jxpath.ri.parser;

import java.io.StringReader;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

class XPathParserTokenManager_SwitchTo_37_0_Test {

    @Test
    void testSwitchToValidState() {
        XPathParserTokenManager tokenManager = new XPathParserTokenManager(new SimpleCharStream(new StringReader("")));
        tokenManager.SwitchTo(0);
        assertEquals(0, tokenManager.curLexState);
        tokenManager.SwitchTo(1);
        assertEquals(1, tokenManager.curLexState);
    }

    @Test
    void testSwitchToInvalidStateNegative() {
        XPathParserTokenManager tokenManager = new XPathParserTokenManager(new SimpleCharStream(new StringReader("")));
        try {
            tokenManager.SwitchTo(-1);
            fail("Expected TokenMgrError to be thrown");
        } catch (TokenMgrError exception) {
            assertEquals("Error: Ignoring invalid lexical state : -1. State unchanged.", exception.getMessage());
            assertEquals(0, tokenManager.curLexState);
        }
    }

    @Test
    void testSwitchToInvalidStateTooHigh() {
        XPathParserTokenManager tokenManager = new XPathParserTokenManager(new SimpleCharStream(new StringReader("")));
        try {
            tokenManager.SwitchTo(2);
            fail("Expected TokenMgrError to be thrown");
        } catch (TokenMgrError exception) {
            assertEquals("Error: Ignoring invalid lexical state : 2. State unchanged.", exception.getMessage());
            assertEquals(0, tokenManager.curLexState);
        }
    }
}
