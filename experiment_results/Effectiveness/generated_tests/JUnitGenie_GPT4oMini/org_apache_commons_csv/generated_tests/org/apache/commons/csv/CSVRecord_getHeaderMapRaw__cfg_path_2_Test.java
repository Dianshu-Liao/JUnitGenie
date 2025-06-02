package org.apache.commons.csv;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.Map;
import static org.junit.Assert.assertNull;

public class CSVRecord_getHeaderMapRaw__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testGetHeaderMapRaw_ReturnsNull_WhenParserIsNull() throws Exception {
        // Arrange
        CSVRecord csvRecord = createCSVRecordWithNullParser();
        Method method = CSVRecord.class.getDeclaredMethod("getHeaderMapRaw");
        method.setAccessible(true); // Allow access to the private method

        // Act
        Map<String, Integer> result = (Map<String, Integer>) method.invoke(csvRecord);

        // Assert
        assertNull(result);
    }

    private CSVRecord createCSVRecordWithNullParser() {
        return new CSVRecord(null, new String[0], null, 0, 0, 0);
    }

}