package org.apache.commons.jxpath.ri.parser;
import org.apache.commons.jxpath.ri.parser.XPathParser;
import org.apache.commons.jxpath.ri.parser.Token;
import org.junit.Test;
import static org.junit.Assert.*;

public class ri_parser_XPathParser_PrimaryExpr__cfg_path_7_Test {


    @Test(timeout = 4000)
    public void testPrimaryExprWithToken81() {
        try {
            XPathParser parser = new XPathParser(new java.io.ByteArrayInputStream("token81".getBytes()));
            parser.jj_nt = new Token();
            parser.jj_nt.kind = 81; // Set kind to 81 to consume token
            Object result = parser.PrimaryExpr();
            assertNotNull(result);
        } catch (ParseException e) {
            fail("ParseException should not be thrown for valid input");
        }
    }

    @Test(timeout = 4000)
    public void testPrimaryExprWithToken82() {
        try {
            XPathParser parser = new XPathParser(new java.io.ByteArrayInputStream("token82".getBytes()));
            parser.jj_nt = new Token();
            parser.jj_nt.kind = 82; // Set kind to 82 to consume token
            Object result = parser.PrimaryExpr();
            assertNotNull(result);
        } catch (ParseException e) {
            fail("ParseException should not be thrown for valid input");
        }
    }

    @Test(timeout = 4000)
    public void testPrimaryExprWithInvalidToken() {
        try {
            XPathParser parser = new XPathParser(new java.io.ByteArrayInputStream("invalid".getBytes()));
            parser.jj_nt = new Token();
            parser.jj_nt.kind = -1; // Invalid token
            parser.PrimaryExpr();
            fail("ParseException expected for invalid token");
        } catch (ParseException e) {
            // Expected exception
        }
    }


}
