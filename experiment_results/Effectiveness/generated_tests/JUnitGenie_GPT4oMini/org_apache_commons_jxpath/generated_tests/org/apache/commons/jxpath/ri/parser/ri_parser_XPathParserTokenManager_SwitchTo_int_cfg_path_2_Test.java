package org.apache.commons.jxpath.ri.parser;
import org.apache.commons.jxpath.ri.parser.XPathParserTokenManager;
import org.apache.commons.jxpath.ri.parser.TokenMgrError;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.io.StringReader;

public class ri_parser_XPathParserTokenManager_SwitchTo_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testSwitchToInvalidLexStateGreaterThanOrEqualToOne() {
        XPathParserTokenManager manager = new XPathParserTokenManager(new SimpleCharStream(new StringReader("")));
        try {
            manager.SwitchTo(1); // This should throw TokenMgrError
        } catch (TokenMgrError e) {
            // Expected exception
            String expectedMessage = "Error: Ignoring invalid lexical state : 1. State unchanged.";
            assertEquals(expectedMessage, e.getMessage());
            assertEquals(2, e.errorCode); // Ensure the error code is 2
        }
    }

    @Test(timeout = 4000)
    public void testSwitchToInvalidLexStateNegative() {
        XPathParserTokenManager manager = new XPathParserTokenManager(new SimpleCharStream(new StringReader("")));
        try {
            manager.SwitchTo(-1); // This should throw TokenMgrError
        } catch (TokenMgrError e) {
            // Expected exception
            String expectedMessage = "Error: Ignoring invalid lexical state : -1. State unchanged.";
            assertEquals(expectedMessage, e.getMessage());
            assertEquals(2, e.errorCode); // Ensure the error code is 2
        }
    }


}