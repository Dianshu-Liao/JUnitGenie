package org.apache.commons.jxpath.ri.parser;
import org.apache.commons.jxpath.ri.parser.XPathParser;
import org.apache.commons.jxpath.ri.parser.ParseException;
import org.apache.commons.jxpath.ri.parser.Token;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class ri_parser_XPathParser_AxisName__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testAxisNameThrowsParseException() {
        // Arrange
        String input = ""; // Provide an empty input to simulate invalid token
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        XPathParser parser = new XPathParser(inputStream);
        parser.jj_nt = new Token();  // assuming this sets up your jj_nt
        parser.jj_nt.kind = -1; // setting to an invalid token kind to trigger ParseException

        // Act and Assert
        try {
            parser.AxisName();
            fail("Expected ParseException to be thrown");
        } catch (ParseException e) {
            // Expected exception
        } catch (Exception e) {
            fail("Expected ParseException, but got: " + e.getClass().getSimpleName());
        }
    }

}