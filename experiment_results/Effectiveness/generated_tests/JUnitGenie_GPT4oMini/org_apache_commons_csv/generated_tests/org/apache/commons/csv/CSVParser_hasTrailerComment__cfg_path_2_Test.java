package org.apache.commons.csv;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import java.io.IOException;
import java.io.StringReader;

public class CSVParser_hasTrailerComment__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testHasTrailerCommentWhenTrailerCommentIsNull() throws IOException {
        // Arrange
        CSVParser parser = new CSVParser(new StringReader(""), CSVFormat.DEFAULT);
        
        // Act
        boolean result = parser.hasTrailerComment();
        
        // Assert
        assertFalse(result);
        
        // Close the parser to avoid resource leaks
        parser.close();
    }


}