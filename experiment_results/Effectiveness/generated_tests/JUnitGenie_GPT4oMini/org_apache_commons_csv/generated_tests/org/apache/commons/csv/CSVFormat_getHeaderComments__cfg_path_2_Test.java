package org.apache.commons.csv;
import org.apache.commons.csv.CSVFormat;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class CSVFormat_getHeaderComments__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testGetHeaderCommentsWhenHeaderCommentsIsNull() {
        try {
            // Create an instance of CSVFormat using reflection
            CSVFormat csvFormat = (CSVFormat) CSVFormat.class.getDeclaredConstructor().newInstance();
            
            // Access the private final field headerComments and set it to null
            java.lang.reflect.Field field = CSVFormat.class.getDeclaredField("headerComments");
            field.setAccessible(true);
            field.set(csvFormat, null);
            
            // Call the method under test
            String[] result = csvFormat.getHeaderComments();
            
            // Assert that the result is null
            assertNull(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}