package org.apache.commons.csv;
import org.apache.commons.csv.CSVFormat;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CSVFormat_trim_String_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testTrimWithTrimEnabled() {
        try {
            // Create an instance of CSVFormat with trim enabled
            CSVFormat csvFormat = CSVFormat.Builder.create().setTrim(true).build();
            String input = "   test string   ";
            String expected = "test string";

            // Call the trim method
            String result = csvFormat.trim(input);

            // Assert the result
            assertEquals(expected, result);
        } catch (Exception e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testTrimWithTrimDisabled() {
        try {
            // Create an instance of CSVFormat with trim disabled
            CSVFormat csvFormat = CSVFormat.Builder.create().setTrim(false).build();
            String input = "   test string   ";
            String expected = "   test string   ";

            // Call the trim method
            String result = csvFormat.trim(input);

            // Assert the result
            assertEquals(expected, result);
        } catch (Exception e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

}