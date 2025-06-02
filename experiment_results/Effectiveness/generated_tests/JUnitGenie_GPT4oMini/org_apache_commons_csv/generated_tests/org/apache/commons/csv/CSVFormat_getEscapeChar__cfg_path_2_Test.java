package org.apache.commons.csv;
import org.apache.commons.csv.CSVFormat;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CSVFormat_getEscapeChar__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testGetEscapeCharWhenEscapeCharacterIsNull() {
        try {
            // Create an instance of CSVFormat using reflection
            CSVFormat csvFormat = (CSVFormat) CSVFormat.class.getDeclaredConstructor().newInstance();
            // Access the private final field escapeCharacter using reflection
            java.lang.reflect.Field field = CSVFormat.class.getDeclaredField("escapeCharacter");
            field.setAccessible(true);
            field.set(csvFormat, null); // Set escapeCharacter to null
            
            // Call the focal method
            char result = csvFormat.getEscapeChar();
            
            // Assert that the result is 0 when escapeCharacter is null
            assertEquals(0, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}