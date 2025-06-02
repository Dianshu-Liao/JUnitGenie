package org.apache.commons.csv;
import org.apache.commons.csv.Lexer;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.ExtendedBufferedReader;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.IOException;
import java.io.StringReader;

public class Lexer_isDelimiter_int_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testIsDelimiter() {
        // Setup
        char[] delimiter = {',', ';'};
        ExtendedBufferedReader reader = new ExtendedBufferedReader(new StringReader("")); // Using StringReader for testing
        Lexer lexer = new Lexer(CSVFormat.DEFAULT, reader);
        
        // Test case where ch is equal to the first delimiter
        try {
            boolean result = lexer.isDelimiter(delimiter[0]);
            assertTrue(result);
        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }

        // Test case where ch is not equal to the first delimiter
        try {
            boolean result = lexer.isDelimiter('a');
            assertFalse(result);
        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }

        // Test case where delimiter length is 1
        try {
            lexer = new Lexer(CSVFormat.DEFAULT, reader);
            // Instead of accessing private field directly, we assume a method to set the delimiter
            // Assuming the Lexer class has a constructor that accepts a char as a delimiter
            lexer = new Lexer(CSVFormat.DEFAULT.withDelimiter(';'), reader);
            boolean result = lexer.isDelimiter(';');
            assertTrue(result);
        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }

        // Test case where delimiterBuf does not match the delimiter
        try {
            // Instead of accessing private field directly, we assume a method to set the delimiter buffer
            // Assuming the Lexer class has a constructor that accepts a char array as a delimiter
            // Correcting the method to use withDelimiter instead of withDelimiterBuf
            lexer = new Lexer(CSVFormat.DEFAULT.withDelimiter('a'), reader);
            boolean result = lexer.isDelimiter(',');
            assertFalse(result);
        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }
    }


}