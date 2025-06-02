package org.apache.commons.csv;
import org.apache.commons.csv.Lexer;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.ExtendedBufferedReader;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.IOException;
import java.io.StringReader;

public class Lexer_isDelimiter_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testIsDelimiter() {
        // Setup
        char[] delimiter = {'a', 'b', 'c'};
        char[] delimiterBuf = new char[3];
        
        // Create a StringReader to simulate input for ExtendedBufferedReader
        StringReader stringReader = new StringReader("test input");
        ExtendedBufferedReader reader = new ExtendedBufferedReader(stringReader); // Use a suitable constructor
        
        Lexer lexer = new Lexer(CSVFormat.DEFAULT, reader);
        
        // Set the private fields using reflection (if necessary)
        try {
            java.lang.reflect.Field delimiterField = Lexer.class.getDeclaredField("delimiter");
            delimiterField.setAccessible(true);
            delimiterField.set(lexer, delimiter);
            
            java.lang.reflect.Field delimiterBufField = Lexer.class.getDeclaredField("delimiterBuf");
            delimiterBufField.setAccessible(true);
            delimiterBufField.set(lexer, delimiterBuf);
            
            // Test case where ch matches the first delimiter
            int ch = 'a';
            boolean result = lexer.isDelimiter(ch);
            assertTrue(result);
            
            // Test case where ch does not match the first delimiter
            ch = 'x';
            result = lexer.isDelimiter(ch);
            assertFalse(result);
            
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        } catch (IOException e) {
            // Handle IOException that may be thrown by isDelimiter method
            e.printStackTrace();
        }
    }

}