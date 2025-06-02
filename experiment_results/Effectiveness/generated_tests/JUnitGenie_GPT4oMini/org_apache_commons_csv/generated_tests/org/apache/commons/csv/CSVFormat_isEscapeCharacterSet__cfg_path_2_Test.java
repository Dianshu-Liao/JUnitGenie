package org.apache.commons.csv;
import org.apache.commons.csv.CSVFormat;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class CSVFormat_isEscapeCharacterSet__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testIsEscapeCharacterSetWhenEscapeCharacterIsNull() {
        try {
            // Create an instance of CSVFormat using reflection to access the private constructor
            CSVFormat csvFormat = (CSVFormat) CSVFormat.class.getDeclaredConstructor().newInstance();
            
            // Access the private field escapeCharacter and set it to null
            java.lang.reflect.Field escapeCharacterField = CSVFormat.class.getDeclaredField("escapeCharacter");
            escapeCharacterField.setAccessible(true);
            escapeCharacterField.set(csvFormat, null);
            
            // Call the method under test
            boolean result = csvFormat.isEscapeCharacterSet();
            
            // Assert that the result is false
            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}