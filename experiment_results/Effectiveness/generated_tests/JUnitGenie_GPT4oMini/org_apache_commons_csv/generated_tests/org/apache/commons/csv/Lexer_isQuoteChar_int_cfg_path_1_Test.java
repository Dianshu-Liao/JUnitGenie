package org.apache.commons.csv;
import org.apache.commons.csv.Lexer;
import org.apache.commons.csv.CSVFormat;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class Lexer_isQuoteChar_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testIsQuoteCharReturnsFalseForNonQuoteChar() {
        // Arrange
        int nonQuoteChar = 'A'; // Assuming 'A' is not the quote character
        Lexer lexer = new Lexer(CSVFormat.DEFAULT, null); // Providing a valid CSVFormat

        // Act
        boolean result = lexer.isQuoteChar(nonQuoteChar);

        // Assert
        assertFalse(result);
    }


}