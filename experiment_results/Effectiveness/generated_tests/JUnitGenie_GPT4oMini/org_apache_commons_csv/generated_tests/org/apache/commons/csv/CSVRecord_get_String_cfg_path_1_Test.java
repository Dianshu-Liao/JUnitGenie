package org.apache.commons.csv;
import org.apache.commons.csv.CSVRecord;
import org.junit.Test;
import static org.junit.Assert.*;

public class CSVRecord_get_String_cfg_path_1_Test {

    @Test(expected = IllegalStateException.class)
    public void testGetHeaderMapRawReturnsNull() {
        // Create a CSVRecord instance with a null parser to ensure getHeaderMapRaw() returns null
        CSVRecord csvRecord = new CSVRecord(null, new String[]{}, "", 0, 0, 0);
        
        // Call the get method with any name, it should throw IllegalStateException
        csvRecord.get("anyName");
    }

}