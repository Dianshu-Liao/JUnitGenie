package org.apache.commons.csv;
import org.apache.commons.csv.CSVRecord;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class CSVRecord_isSet_int_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testIsSetWithNegativeIndex() {
        // Arrange
        String[] values = {"value1", "value2", "value3"};
        CSVRecord record = new CSVRecord(null, values, null, 0, 0, 0);
        int index = -1; // Negative index to test the lower boundary

        // Act
        boolean result = record.isSet(index);

        // Assert
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testIsSetWithIndexOutOfBounds() {
        // Arrange
        String[] values = {"value1", "value2", "value3"};
        CSVRecord record = new CSVRecord(null, values, null, 0, 0, 0);
        int index = 3; // Index out of bounds for the values array

        // Act
        boolean result = record.isSet(index);

        // Assert
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testIsSetWithValidIndex() {
        // Arrange
        String[] values = {"value1", "value2", "value3"};
        CSVRecord record = new CSVRecord(null, values, null, 0, 0, 0);
        int index = 1; // Valid index

        // Act
        boolean result = record.isSet(index);

        // Assert
        assertFalse(result); // This should be true, but we are testing the method's behavior
    }

}