package org.apache.commons.csv;
import org.apache.commons.csv.CSVRecord;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class CSVRecord_isSet_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testIsSetWithNegativeIndex() {
        // Arrange
        String[] values = {"value1", "value2", "value3"};
        CSVRecord record = new CSVRecord(null, values, null, 0, 0, 0);

        // Act
        boolean result = record.isSet(-1);

        // Assert
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testIsSetWithIndexGreaterThanOrEqualToLength() {
        // Arrange
        String[] values = {"value1", "value2", "value3"};
        CSVRecord record = new CSVRecord(null, values, null, 0, 0, 0);

        // Act
        boolean result = record.isSet(3); // index is equal to length

        // Assert
        assertFalse(result);
    }

}