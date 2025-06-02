package org.apache.commons.csv;
import org.apache.commons.csv.CSVFormat;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class CSVFormat_copy_CSVFormat_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testCopyWithNullFormat() {
        try {
            CSVFormat result = CSVFormat.copy(null);
            assertNull(result);
        } catch (Exception e) {
            // Handle the exception as needed; though not expected in this test
        }
    }

}