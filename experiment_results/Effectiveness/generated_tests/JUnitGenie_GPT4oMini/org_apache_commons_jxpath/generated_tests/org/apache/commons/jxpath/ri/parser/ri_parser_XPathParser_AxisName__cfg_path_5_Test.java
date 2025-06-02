package org.apache.commons.jxpath.ri.parser;
import org.apache.commons.jxpath.ri.parser.XPathParser;
import org.apache.commons.jxpath.ri.parser.Token;
import org.junit.Test;
import static org.junit.Assert.*;

public class ri_parser_XPathParser_AxisName__cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testAxisNameWithValidToken() {
        try {
            // Setup
            Token token = new Token();
            token.kind = 38; // kind must be equal to 38
            XPathParser parser = new XPathParser(new java.io.StringReader("")); // Use StringReader instead of System.in
            parser.jj_nt = token; // Set the jj_nt to a valid token

            // Execute
            int axis = parser.AxisName();

            // Verify
            assertEquals(4, axis); // AXIS_ATTRIBUTE value is 4 according to the original source code
        } catch (ParseException e) {
            fail("ParseException should not be thrown for valid token.");
        } catch (Error e) {
            fail("Unexpected Error: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testAxisNameThrowsExceptionOnInvalidToken() {
        try {
            // Setup
            Token token = new Token();
            token.kind = -1; // Invalid kind to trigger default case
            XPathParser parser = new XPathParser(new java.io.StringReader("")); // Use StringReader instead of System.in
            parser.jj_nt = token; // Set to an invalid token

            // Execute
            parser.AxisName();
            fail("Expected ParseException was not thrown.");
        } catch (ParseException e) {
            // Expected exception
        } catch (Error e) {
            fail("Unexpected Error: " + e.getMessage());
        }
    }


}