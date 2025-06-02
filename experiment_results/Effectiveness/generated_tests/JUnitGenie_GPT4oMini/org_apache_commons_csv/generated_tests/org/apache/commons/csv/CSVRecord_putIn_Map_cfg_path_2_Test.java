package org.apache.commons.csv;
import org.apache.commons.csv.CSVRecord;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertEquals;

public class CSVRecord_putIn_Map_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testPutInWithNullHeaderMap() {
        // Arrange
        CSVRecord csvRecord = new CSVRecord(null, new String[]{}, "", 0, 0, 0);
        Map<String, String> map = new HashMap<>();

        // Act
        Map<String, String> result = csvRecord.putIn(map);

        // Assert
        assertEquals(map, result); // The map should remain unchanged
    }

}