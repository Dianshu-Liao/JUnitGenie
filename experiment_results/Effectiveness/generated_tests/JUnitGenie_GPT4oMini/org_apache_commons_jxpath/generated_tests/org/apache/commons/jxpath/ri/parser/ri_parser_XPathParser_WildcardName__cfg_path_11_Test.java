package org.apache.commons.jxpath.ri.parser;
import org.apache.commons.jxpath.ri.parser.XPathParser;
import org.apache.commons.jxpath.ri.parser.ParseException;
import org.apache.commons.jxpath.ri.parser.Token;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class ri_parser_XPathParser_WildcardName__cfg_path_11_Test {

    @Test(timeout = 4000)
    public void testWildcardNameWithValidToken80() {
        try {
            // Arrange
            InputStream inputStream = new ByteArrayInputStream("validNCName".getBytes());
            XPathParser parser = new XPathParser(inputStream);
            parser.jj_nt = new Token();
            parser.jj_nt.kind = 80; // Set kind to 80 to trigger the corresponding case
            parser.token = new Token();
            parser.token.image = "validNCName"; // Set a valid NCName

            // Act
            Object result = parser.WildcardName();

            // Assert
            assertNotNull(result);
            // Additional assertions can be made based on expected behavior
        } catch (ParseException e) {
            fail("ParseException should not be thrown for valid input");
        } catch (Error e) {
            fail("Error should not be thrown for valid input");
        }
    }

    @Test(timeout = 4000)
    public void testWildcardNameWithInvalidToken() {
        try {
            // Arrange
            InputStream inputStream = new ByteArrayInputStream("invalidToken".getBytes());
            XPathParser parser = new XPathParser(inputStream);
            parser.jj_nt = new Token();
            parser.jj_nt.kind = -1; // Set kind to an invalid token to trigger exception

            // Act
            parser.WildcardName();
            fail("ParseException expected but not thrown");
        } catch (ParseException e) {
            // Expected exception
        } catch (Error e) {
            fail("Error should not be thrown for invalid token");
        }
    }

    @Test(timeout = 4000)
    public void testWildcardNameWithNullNCName() {
        try {
            // Arrange
            InputStream inputStream = new ByteArrayInputStream("nullNCName".getBytes());
            XPathParser parser = new XPathParser(inputStream);
            parser.jj_nt = new Token();
            parser.jj_nt.kind = 80; // Set kind to 80 to trigger the case
            parser.token = new Token();
            parser.token.image = null; // Set NCName to null

            // Act
            Object result = parser.WildcardName();

            // Assert
            assertNotNull(result);
            // Additional assertions can be made based on expected behavior
        } catch (ParseException e) {
            fail("ParseException should not be thrown for null NCName");
        } catch (Error e) {
            fail("Error should not be thrown for null NCName");
        }
    }


}