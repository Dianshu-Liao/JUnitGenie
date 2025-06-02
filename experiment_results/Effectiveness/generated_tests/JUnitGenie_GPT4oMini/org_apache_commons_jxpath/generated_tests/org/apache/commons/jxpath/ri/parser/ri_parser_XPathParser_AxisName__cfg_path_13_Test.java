package org.apache.commons.jxpath.ri.parser;
import org.apache.commons.jxpath.ri.parser.XPathParser;
import org.apache.commons.jxpath.ri.parser.Token;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.apache.commons.jxpath.ri.parser.ParseException;

public class ri_parser_XPathParser_AxisName__cfg_path_13_Test {

    @Test(timeout = 4000)
    public void testAxisNameWithValidToken() {
        try {
            // Setup the input stream with a valid token
            String input = "valid input"; // Replace with actual input that leads to AXIS_FOLLOWING
            InputStream inputStream = new ByteArrayInputStream(input.getBytes());
            XPathParser parser = new XPathParser(inputStream);
            
            // Set the jj_nt to a valid token for testing
            parser.jj_nt = new Token();
            parser.jj_nt.kind = 46; // Simulating AXIS_FOLLOWING
            
            // Call the method under test
            int result = parser.AxisName();
            
            // Assert the expected result
            assertEquals(46, result); // Changed Token.AXIS_FOLLOWING to the actual integer value 46
        } catch (ParseException e) { // Catch ParseException
            fail("ParseException was thrown: " + e.getMessage());
        } catch (Error e) {
            fail("Error was thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testAxisNameWithInvalidToken() {
        try {
            // Setup the input stream with a valid token
            String input = "valid input"; // Replace with actual input
            InputStream inputStream = new ByteArrayInputStream(input.getBytes());
            XPathParser parser = new XPathParser(inputStream);
            
            // Set the jj_nt to an invalid token for testing
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