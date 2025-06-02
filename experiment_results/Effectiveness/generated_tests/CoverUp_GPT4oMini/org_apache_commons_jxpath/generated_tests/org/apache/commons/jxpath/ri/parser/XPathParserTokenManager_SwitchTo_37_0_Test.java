package org.apache.commons.jxpath.ri.parser;

import java.lang.reflect.Field;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.StringReader;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class XPathParserTokenManager_SwitchTo_37_0_Test {

    @Test
    public void testSwitchToValidState() throws Exception {
        XPathParserTokenManager tokenManager = new XPathParserTokenManager(createSimpleCharStream());
        // Initial state should be 0
        assertEquals(0, getPrivateField(tokenManager, "curLexState"));
        // Switch to a valid state
        tokenManager.SwitchTo(1);
        // Check if the state has been changed
        assertEquals(1, getPrivateField(tokenManager, "curLexState"));
    }

    @Test
    public void testSwitchToInvalidStateNegative() {
        XPathParserTokenManager tokenManager = new XPathParserTokenManager(createSimpleCharStream());
        // Expecting an exception for invalid state
        TokenMgrError exception = assertThrows(TokenMgrError.class, () -> {
            tokenManager.SwitchTo(-1);
        });
        assertEquals("Error: Ignoring invalid lexical state : -1. State unchanged.", exception.getMessage());
    }

    @Test
    public void testSwitchToInvalidStateOutOfBounds() {
        XPathParserTokenManager tokenManager = new XPathParserTokenManager(createSimpleCharStream());
        // Expecting an exception for invalid state
        TokenMgrError exception = assertThrows(TokenMgrError.class, () -> {
            tokenManager.SwitchTo(2);
        });
        assertEquals("Error: Ignoring invalid lexical state : 2. State unchanged.", exception.getMessage());
    }

    private SimpleCharStream createSimpleCharStream() {
        return new SimpleCharStream(new StringReader(""), 1, 1, 1);
    }

    private Object getPrivateField(XPathParserTokenManager tokenManager, String fieldName) throws Exception {
        Field field = XPathParserTokenManager.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(tokenManager);
    }
}
