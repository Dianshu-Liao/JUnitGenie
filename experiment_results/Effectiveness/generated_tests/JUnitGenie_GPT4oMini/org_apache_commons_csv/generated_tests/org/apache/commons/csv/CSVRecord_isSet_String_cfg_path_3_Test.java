package org.apache.commons.csv;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.CSVParser;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class CSVRecord_isSet_String_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testIsSetReturnsFalse() {
        // Arrange
        String[] values = new String[] {"value1", "value2"};
        CSVParser parser = null; // Assuming a valid CSVParser instance is created here
        CSVRecord record = new CSVRecord(parser, values, null, 0, 0, 0);

        // Act
        boolean result = record.isSet("nonExistentColumn");

        // Assert
        assertFalse(result);
    }

}