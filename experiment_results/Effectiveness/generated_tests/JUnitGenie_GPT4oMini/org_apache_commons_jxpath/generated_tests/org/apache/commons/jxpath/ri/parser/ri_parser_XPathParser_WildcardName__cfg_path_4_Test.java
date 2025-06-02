package org.apache.commons.jxpath.ri.parser;
import org.apache.commons.jxpath.ri.parser.XPathParser;
import org.apache.commons.jxpath.ri.parser.ParseException;
import org.apache.commons.jxpath.ri.parser.Token;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayInputStream;

public class ri_parser_XPathParser_WildcardName__cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testWildcardNameWithValidToken89() {
        try {
            XPathParser parser = new XPathParser(new ByteArrayInputStream(new byte[0])); // Use a valid InputStream
            parser.jj_nt = new Token();
            parser.jj_nt.kind = 89; // Set kind to 89 to match the case
            parser.token = parser.jj_nt; // Set token to jj_nt for the test
            Object result = parser.WildcardName();
            assertNotNull(result); // Ensure that the result is not null
        } catch (ParseException e) {
            fail("ParseException should not be thrown for valid token 89");
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testWildcardNameWithValidToken80() {
        try {
            XPathParser parser = new XPathParser(new ByteArrayInputStream(new byte[0])); // Use a valid InputStream
            parser.jj_nt = new Token();
            parser.jj_nt.kind = 80; // Set kind to 80 to match the case
            parser.token = parser.jj_nt; // Set token to jj_nt for the test
            Object result = parser.WildcardName();
            assertNotNull(result); // Ensure that the result is not null
        } catch (ParseException e) {
            fail("ParseException should not be thrown for valid token 80");
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testWildcardNameWithInvalidToken() {
        try {
            XPathParser parser = new XPathParser(new ByteArrayInputStream(new byte[0])); // Use a valid InputStream
            parser.jj_nt = new Token();
            parser.jj_nt.kind = -1; // Set kind to -1 to trigger the exception
            parser.token = parser.jj_nt; // Set token to jj_nt for the test
            parser.WildcardName();
            fail("ParseException expected for invalid token -1");
        } catch (ParseException e) {
            // Expected exception
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }


}