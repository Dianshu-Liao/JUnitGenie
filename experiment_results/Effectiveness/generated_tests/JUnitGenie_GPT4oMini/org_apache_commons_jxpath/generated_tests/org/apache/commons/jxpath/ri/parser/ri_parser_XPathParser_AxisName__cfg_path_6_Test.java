package org.apache.commons.jxpath.ri.parser;
import org.apache.commons.jxpath.ri.parser.XPathParser;
import org.apache.commons.jxpath.ri.parser.Token;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.apache.commons.jxpath.ri.parser.ParseException;

public class ri_parser_XPathParser_AxisName__cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testAxisNameWithAxisFollowing() {
        try {
            // Setup the input stream to simulate the required token
            String input = "some input that leads to AXIS_FOLLOWING"; // Adjust input as necessary
            InputStream inputStream = new ByteArrayInputStream(input.getBytes());
            XPathParser parser = new XPathParser(inputStream);
            
            // Set the jj_nt token to simulate the AXIS_FOLLOWING case
            Token token = new Token();
            token.kind = 39; // AXIS_FOLLOWING
            parser.jj_nt = token;

            // Call the method under test
            int result = parser.AxisName();
            
            // Verify the result
            assertEquals(39, result); // Use the token kind directly instead of Compiler.AXIS_FOLLOWING
        } catch (ParseException e) { // Catch the specific ParseException
            fail("ParseException was thrown: " + e.getMessage());
        } catch (Error e) {
            fail("Error was thrown: " + e.getMessage());
        }
    }


}