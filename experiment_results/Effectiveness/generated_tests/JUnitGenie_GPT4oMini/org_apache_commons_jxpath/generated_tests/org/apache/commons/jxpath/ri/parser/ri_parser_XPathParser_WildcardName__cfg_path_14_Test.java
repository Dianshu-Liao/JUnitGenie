package org.apache.commons.jxpath.ri.parser;
import org.apache.commons.jxpath.ri.parser.XPathParser;
import org.apache.commons.jxpath.ri.parser.Token;
import org.apache.commons.jxpath.ri.Compiler;
import org.junit.Test;
import static org.junit.Assert.*;

public class ri_parser_XPathParser_WildcardName__cfg_path_14_Test {

    @Test(timeout = 4000)
    public void testWildcardName() {
        // Arrange
        Token token = new Token();
        token.kind = 80; // Set kind to 80 to satisfy the condition in the method
        token.image = "testImage"; // Set a valid image for the token

        XPathParser parser = new XPathParser(new java.io.ByteArrayInputStream(new byte[0]));
        parser.jj_nt = token; // Set the jj_nt to the token we created

        // Act
        Object result = null;
        try {
            result = parser.WildcardName();
        } catch (ParseException e) {
            fail("ParseException was thrown: " + e.getMessage());
        } catch (Error e) {
            fail("Error was thrown: " + e.getMessage());
        }

        // Assert
        assertNotNull("The result should not be null", result);
    }

}