package org.apache.commons.jxpath.ri.parser;
import org.apache.commons.jxpath.ri.parser.XPathParser;
import org.apache.commons.jxpath.ri.parser.Token;
import org.junit.Test;
import static org.junit.Assert.*;

public class ri_parser_XPathParser_PrimaryExpr__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testPrimaryExprWithFunctionCall() {
        try {
            // Initialize the XPathParser with a suitable InputStream or Reader
            XPathParser parser = new XPathParser(new java.io.ByteArrayInputStream("".getBytes()));
            
            // Set up the necessary state for the parser
            parser.jj_nt = new Token();
            parser.jj_nt.kind = 27; // Set to a valid kind for FunctionCall
            
            // Call the method under test
            Object result = parser.PrimaryExpr();
            
            // Assert the expected outcome
            assertNotNull(result); // Assuming FunctionCall returns a non-null object
        } catch (ParseException e) {
            fail("ParseException was thrown: " + e.getMessage());
        } catch (Error e) {
            fail("Error was thrown: " + e.getMessage());
        } catch (NullPointerException e) {
            fail("NullPointerException was thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testPrimaryExprWithInvalidToken() {
        try {
            XPathParser parser = new XPathParser(new java.io.ByteArrayInputStream("".getBytes()));
            
            // Set up the necessary state for the parser
            parser.jj_nt = new Token();
            parser.jj_nt.kind = -1; // Set to an invalid kind to trigger exception
            
            // Call the method under test
            parser.PrimaryExpr();
            fail("Expected ParseException was not thrown.");
        } catch (ParseException e) {
            // Expected exception
        } catch (Error e) {
            fail("Error was thrown: " + e.getMessage());
        } catch (NullPointerException e) {
            fail("NullPointerException was thrown: " + e.getMessage());
        }
    }


}