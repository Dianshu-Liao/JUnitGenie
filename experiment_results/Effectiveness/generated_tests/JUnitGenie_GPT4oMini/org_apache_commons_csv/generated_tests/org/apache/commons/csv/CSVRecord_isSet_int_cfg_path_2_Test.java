package org.apache.commons.csv;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.CSVParser;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class CSVRecord_isSet_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testIsSetWithNegativeIndex() {
        // Arrange
        String[] values = {"value1", "value2", "value3"};
        CSVParser parser = null; // Assuming a null parser is acceptable for the test
        CSVRecord record = new CSVRecord(parser, values, null, 0, 0, 0);

        // Act & Assert
        try {
            boolean result = record.isSet(-1);
            assertFalse(result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testIsSetWithIndexGreaterThanLength() {
        // Arrange
        String[] values = {"value1", "value2", "value3"};
        CSVParser parser = null; // Assuming a null parser is acceptable for the test
        CSVRecord record = new CSVRecord(parser, values, null, 0, 0, 0);

        // Act & Assert
        try {
            boolean result = record.isSet(3);
            assertFalse(result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }


}