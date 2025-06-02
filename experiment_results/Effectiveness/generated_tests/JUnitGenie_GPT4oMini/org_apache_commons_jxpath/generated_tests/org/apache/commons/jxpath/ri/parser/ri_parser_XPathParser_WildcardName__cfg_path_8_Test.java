package org.apache.commons.jxpath.ri.parser;
import org.apache.commons.jxpath.ri.parser.XPathParser;
import org.apache.commons.jxpath.ri.parser.Token;
import org.junit.Test;
import static org.junit.Assert.*;

public class ri_parser_XPathParser_WildcardName__cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testWildcardNameWithValidToken89() {
        try {
            XPathParser parser = new XPathParser(new java.io.ByteArrayInputStream(new byte[0])); // Use a valid InputStream
            parser.jj_nt = new Token();
            parser.jj_nt.kind = 89; // valid token
            parser.token = new Token();
            parser.token.image = "validNCName"; // valid NCName

            Object result = parser.WildcardName();
            assertNotNull(result);
        } catch (ParseException e) {
            fail("ParseException should not have been thrown for valid input.");
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testWildcardNameWithValidToken80() {
        try {
            XPathParser parser = new XPathParser(new java.io.ByteArrayInputStream(new byte[0])); // Use a valid InputStream
            parser.jj_nt = new Token();
            parser.jj_nt.kind = 80; // valid token
            parser.token = new Token();
            parser.token.image = "validNCName"; // valid NCName

            Object result = parser.WildcardName();
            assertNotNull(result);
        } catch (ParseException e) {
            fail("ParseException should not have been thrown for valid input.");
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testWildcardNameWithInvalidToken() {
        try {
            XPathParser parser = new XPathParser(new java.io.ByteArrayInputStream(new byte[0])); // Use a valid InputStream
            parser.jj_nt = new Token();
            parser.jj_nt.kind = -1; // invalid token
            parser.token = new Token();
            parser.token.image = "validNCName"; // valid NCName

            parser.WildcardName();
            fail("ParseException should have been thrown for invalid token.");
        } catch (ParseException e) {
            // Expected exception
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testWildcardNameWithNullNCName() {
        try {
            XPathParser parser = new XPathParser(new java.io.ByteArrayInputStream(new byte[0])); // Use a valid InputStream
            parser.jj_nt = new Token();
            parser.jj_nt.kind = 89; // valid token
            parser.token = new Token();
            parser.token.image = null; // invalid NCName

            parser.WildcardName();
            fail("ParseException should have been thrown for null NCName.");
        } catch (ParseException e) {
            // Expected exception
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

}