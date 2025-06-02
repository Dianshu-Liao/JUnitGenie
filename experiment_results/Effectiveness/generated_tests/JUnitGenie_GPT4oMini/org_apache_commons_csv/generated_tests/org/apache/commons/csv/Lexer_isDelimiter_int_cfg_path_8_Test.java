package org.apache.commons.csv;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.ExtendedBufferedReader;
import org.apache.commons.csv.Lexer;
import org.junit.Test;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import static org.junit.Assert.assertFalse;

public class Lexer_isDelimiter_int_cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testIsDelimiterFalse() {
        // Arrange
        char[] delimiters = {'a'};
        StringReader stringReader = new StringReader(""); // Create a StringReader as a mock input
        ExtendedBufferedReader reader = new ExtendedBufferedReader(stringReader, StandardCharsets.UTF_8, false); // Use the correct constructor
        Lexer lexer = new Lexer(CSVFormat.DEFAULT.withDelimiter(delimiters[0]), reader); // Set the delimiter for the lexer
        int testChar = 'b'; // A character that is not a delimiter

        // Act
        boolean result = false;
        try {
            result = lexer.isDelimiter(testChar);
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception
        }

        // Assert
        assertFalse(result);
    }


}