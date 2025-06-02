package org.apache.commons.csv;
import org.apache.commons.csv.CSVFormat;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CSVFormat_getEscapeChar__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetEscapeCharWithNonNullEscapeCharacter() {
        try {
            // Using reflection to access the private final field escapeCharacter
            CSVFormat csvFormat = CSVFormat.DEFAULT; // Use the default instance
            java.lang.reflect.Field field = CSVFormat.class.getDeclaredField("escapeCharacter");
            field.setAccessible(true);
            field.set(csvFormat, 'a'); // Set escapeCharacter to a non-null value

            char result = csvFormat.getEscapeChar();
            assertEquals('a', result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetEscapeCharWithNullEscapeCharacter() {
        try {
            // Using reflection to set escapeCharacter to null
            CSVFormat csvFormat = CSVFormat.DEFAULT; // Use the default instance
            java.lang.reflect.Field field = CSVFormat.class.getDeclaredField("escapeCharacter");
            field.setAccessible(true);
            field.set(csvFormat, null); // Set escapeCharacter to null

            char result = csvFormat.getEscapeChar();
            assertEquals(0, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}