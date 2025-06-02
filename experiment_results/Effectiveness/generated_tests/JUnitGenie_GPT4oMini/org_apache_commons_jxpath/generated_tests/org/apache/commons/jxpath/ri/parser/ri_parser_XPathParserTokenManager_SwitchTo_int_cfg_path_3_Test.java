package org.apache.commons.jxpath.ri.parser;
import org.apache.commons.jxpath.ri.parser.XPathParserTokenManager;
import org.apache.commons.jxpath.ri.parser.TokenMgrError;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.StringReader;

public class ri_parser_XPathParserTokenManager_SwitchTo_int_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testSwitchToValidState() {
        // Arrange
        XPathParserTokenManager tokenManager = new XPathParserTokenManager(new SimpleCharStream(new StringReader("")));
        int validState = 0; // A valid state within the acceptable range

        // Act
        tokenManager.SwitchTo(validState);

        // Assert
        // Since there is no direct way to assert the internal state, we can assume the method completes without exception
    }

    @Test(timeout = 4000)
    public void testSwitchToInvalidStateGreaterThanOne() {
        // Arrange
        XPathParserTokenManager tokenManager = new XPathParserTokenManager(new SimpleCharStream(new StringReader("")));
        int invalidState = 1; // An invalid state

        // Act
        try {
            tokenManager.SwitchTo(invalidState);
            fail("Expected TokenMgrError to be thrown");
        } catch (TokenMgrError e) {
            // Assert
            assertEquals("Error: Ignoring invalid lexical state : 1. State unchanged.", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testSwitchToInvalidStateNegative() {
        // Arrange
        XPathParserTokenManager tokenManager = new XPathParserTokenManager(new SimpleCharStream(new StringReader("")));
        int invalidState = -1; // An invalid state

        // Act
        try {
            tokenManager.SwitchTo(invalidState);
            fail("Expected TokenMgrError to be thrown");
        } catch (TokenMgrError e) {
            // Assert
            assertEquals("Error: Ignoring invalid lexical state : -1. State unchanged.", e.getMessage());
        }
    }


}