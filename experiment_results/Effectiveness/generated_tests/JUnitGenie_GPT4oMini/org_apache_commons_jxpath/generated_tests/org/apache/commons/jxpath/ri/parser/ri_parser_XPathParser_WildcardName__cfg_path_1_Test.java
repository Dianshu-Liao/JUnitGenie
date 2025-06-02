package org.apache.commons.jxpath.ri.parser;
import org.apache.commons.jxpath.ri.parser.XPathParser;
import org.apache.commons.jxpath.ri.parser.ParseException;
import org.apache.commons.jxpath.ri.parser.Token;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class ri_parser_XPathParser_WildcardName__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testWildcardNameThrowsParseException() {
        // Arrange
        String input = ""; // Provide an empty input to simulate the scenario
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        XPathParser parser = new XPathParser(inputStream); // Use ByteArrayInputStream instead of System.in
        parser.jj_nt = new Token(); // Initialize the token
        parser.jj_nt.kind = -1; // Set kind to -1 to trigger the ParseException

        // Act
        try {
            parser.WildcardName();
            fail("Expected ParseException to be thrown");
        } catch (ParseException e) {
            // Assert
            assertNotNull(e);
        }
    }

}