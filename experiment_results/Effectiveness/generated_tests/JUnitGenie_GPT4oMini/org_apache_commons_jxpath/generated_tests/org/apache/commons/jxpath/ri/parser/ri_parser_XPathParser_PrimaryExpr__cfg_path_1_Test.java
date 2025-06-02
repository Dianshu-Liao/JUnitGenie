package org.apache.commons.jxpath.ri.parser;
import org.apache.commons.jxpath.ri.parser.XPathParser;
import org.apache.commons.jxpath.ri.parser.ParseException;
import org.apache.commons.jxpath.ri.parser.Token;
import org.junit.Test;
import static org.junit.Assert.*;

public class ri_parser_XPathParser_PrimaryExpr__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testPrimaryExprWithParseException() {
        // Arrange
        XPathParser parser = new XPathParser(new java.io.ByteArrayInputStream(new byte[0]));
        parser.jj_nt = new Token();
        parser.jj_nt.kind = -1; // Set to an invalid token kind to trigger ParseException

        // Act
        try {
            parser.PrimaryExpr();
            fail("Expected ParseException to be thrown");
        } catch (ParseException e) {
            // Expected exception
        } catch (Exception e) {
            fail("Expected ParseException but got: " + e.getClass().getSimpleName());
        }
    }



}
