package org.apache.commons.csv;
import org.apache.commons.csv.CSVFormat;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class CSVFormat_isQuoteCharacterSet__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testIsQuoteCharacterSetWhenQuoteCharacterIsNull() {
        try {
            // Create an instance of CSVFormat using the public static method
            CSVFormat csvFormat = CSVFormat.DEFAULT.withQuote(null);
            
            // Call the method under test
            boolean result = csvFormat.isQuoteCharacterSet();
            
            // Assert the expected outcome
            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}