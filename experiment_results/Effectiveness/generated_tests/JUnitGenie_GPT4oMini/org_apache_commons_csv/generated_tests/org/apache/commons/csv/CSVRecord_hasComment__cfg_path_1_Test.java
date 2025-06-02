package org.apache.commons.csv;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.CSVParser;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class CSVRecord_hasComment__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testHasCommentReturnsFalseWhenCommentIsNull() {
        // Arrange
        String[] values = new String[0]; // Dummy values
        CSVParser parser = null; // Assuming a valid CSVParser is not needed for this test
        CSVRecord record = new CSVRecord(parser, values, null, 0, 0, 0); // comment is null by default

        // Act
        boolean result = record.hasComment();

        // Assert
        assertFalse(result);
    }

}