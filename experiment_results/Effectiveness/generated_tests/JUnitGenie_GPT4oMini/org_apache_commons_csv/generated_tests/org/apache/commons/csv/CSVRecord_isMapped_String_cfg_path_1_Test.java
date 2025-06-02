package org.apache.commons.csv;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVFormat;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.StringReader;
import java.io.IOException;

public class CSVRecord_isMapped_String_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testIsMappedWithNullHeaderMap() throws IOException {
        // Arrange
        String name = "testName";
        CSVParser csvParser = new CSVParser(new StringReader(""), CSVFormat.DEFAULT);
        CSVRecord csvRecord = new CSVRecord(csvParser, new String[]{}, "", 0, 0, 0);

        // Act
        boolean result = csvRecord.isMapped(name);

        // Assert
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testIsMappedWithValidHeaderMap() throws IOException {
        // Arrange
        String name = "testName";
        CSVParser csvParser = new CSVParser(new StringReader("testName,testValue"), CSVFormat.DEFAULT);
        CSVRecord csvRecord = new CSVRecord(csvParser, new String[]{"testName"}, "", 0, 0, 0);
        
        // Act
        boolean result = csvRecord.isMapped(name);

        // Assert
        assertTrue(result);
    }

}