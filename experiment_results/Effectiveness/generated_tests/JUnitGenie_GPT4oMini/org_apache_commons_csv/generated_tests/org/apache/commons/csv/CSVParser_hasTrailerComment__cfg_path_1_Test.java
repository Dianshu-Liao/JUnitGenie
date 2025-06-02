package org.apache.commons.csv;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import java.io.IOException;

public class CSVParser_hasTrailerComment__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testHasTrailerCommentWhenTrailerCommentIsNull() {
        // Arrange
        CSVParser parser = null; // Initialize parser to null
        try {
            parser = new CSVParser(new java.io.StringReader(""), CSVFormat.DEFAULT);
            
            // Accessing the private field 'trailerComment' using reflection
            java.lang.reflect.Field field = CSVParser.class.getDeclaredField("trailerComment");
            field.setAccessible(true);
            field.set(parser, null); // Set trailerComment to null
            
            // Act
            boolean result = parser.hasTrailerComment();
            
            // Assert
            assertFalse(result);
        } catch (NoSuchFieldException | IllegalAccessException | IOException e) {
            e.printStackTrace(); // Handle the exception
        } finally {
            if (parser != null) {
                try {
                    parser.close(); // Ensure the parser is closed
                } catch (IOException e) {
                    e.printStackTrace(); // Handle the exception
                }
            }
        }
    }

}