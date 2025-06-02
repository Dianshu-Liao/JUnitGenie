package org.apache.commons.jxpath.ri.parser;
import org.apache.commons.jxpath.ri.parser.XPathParser;
import org.apache.commons.jxpath.ri.parser.ParseException;
import org.apache.commons.jxpath.ri.parser.Token;
import org.junit.Test;
import static org.junit.Assert.*;

public class ri_parser_XPathParser_NodeType__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testNodeTypeWithInvalidToken() {
        // Given
        Token token = new Token();
        token.kind = -1; // Set the token kind to -1 to trigger the exception
        XPathParser parser = new XPathParser(new java.io.ByteArrayInputStream(new byte[] {}));
        parser.jj_nt = token;  // Assigning the token to jj_nt
        
        // When
        try {
            parser.NodeType();
            fail("Expected ParseException to be thrown");
        } catch (ParseException e) {
            // Then
            assertNotNull(e); // Confirm that the exception is not null
        } catch (Exception e) {
            fail("Expected ParseException, but got: " + e);
        }
    }

}