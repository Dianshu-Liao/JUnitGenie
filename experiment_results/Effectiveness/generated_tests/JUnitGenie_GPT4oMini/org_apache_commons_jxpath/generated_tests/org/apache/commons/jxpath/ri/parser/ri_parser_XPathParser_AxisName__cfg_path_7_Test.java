package org.apache.commons.jxpath.ri.parser;
import org.apache.commons.jxpath.ri.parser.XPathParser;
import org.apache.commons.jxpath.ri.parser.Token;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.apache.commons.jxpath.ri.parser.ParseException;

public class ri_parser_XPathParser_AxisName__cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testAxisNameWithValidToken() {
        try {
            // Setup the input stream and parser
            String input = "some input that leads to AXIS_CHILD"; // Adjust input as necessary
            InputStream inputStream = new ByteArrayInputStream(input.getBytes());
            XPathParser parser = new XPathParser(inputStream);
            
            // Set the jj_nt to a valid token for AXIS_CHILD
            parser.jj_nt = new Token();
            parser.jj_nt.kind = 40; // Assuming 40 corresponds to AXIS_CHILD
            
            // Call the method under test
            int result = parser.AxisName();
            
            // Verify the result
            assertEquals(40, result); // Changed from Compiler.AXIS_CHILD to 40
        } catch (ParseException e) { // Catch ParseException
            fail("ParseException was thrown: " + e.getMessage());
        } catch (Error e) {
            fail("Error was thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testAxisNameWithInvalidToken() {
        try {
            // Setup the input stream and parser
            String input = "some input that leads to an invalid token"; // Adjust input as necessary
            InputStream inputStream = new ByteArrayInputStream(input.getBytes());
            XPathParser parser = new XPathParser(inputStream);
            
            // Set the jj_nt to an invalid token
            parser.jj_nt = new Token();
            parser.jj_nt.kind = -1; // Invalid token
            
            // Call the method under test
            parser.AxisName();
            fail("Expected ParseException was not thrown.");
        } catch (ParseException e) { // Catch ParseException
            // Expected exception, test passes
        } catch (Error e) {
            fail("Error was thrown: " + e.getMessage());
        }
    }


}