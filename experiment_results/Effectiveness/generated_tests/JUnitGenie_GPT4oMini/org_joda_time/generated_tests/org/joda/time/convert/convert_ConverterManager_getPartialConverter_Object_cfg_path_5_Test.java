package org.joda.time.convert;
import org.joda.time.convert.ConverterManager;
import org.joda.time.convert.PartialConverter;
import org.junit.Test;
import static org.junit.Assert.*;

public class convert_ConverterManager_getPartialConverter_Object_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testGetPartialConverterWithValidClass() {
        try {
            ConverterManager manager = new ConverterManager();
            Class<?> validClass = String.class; // Assuming String has a corresponding PartialConverter
            PartialConverter converter = manager.getPartialConverter(validClass);
            assertNotNull("Expected a non-null PartialConverter", converter);
        } catch (Exception e) {
            fail("Exception should not have been thrown for valid class: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testGetPartialConverterWithNull() {
        try {
            ConverterManager manager = new ConverterManager();
            PartialConverter converter = manager.getPartialConverter(null);
            fail("Expected IllegalArgumentException for null input");
        } catch (IllegalArgumentException e) {
            assertEquals("No partial converter found for type: null", e.getMessage());
        } catch (Exception e) {
            fail("Unexpected exception type: " + e.getClass().getName());
        }
    }

    @Test(timeout = 4000)
    public void testGetPartialConverterWithInvalidClass() {
        try {
            ConverterManager manager = new ConverterManager();
            Class<?> invalidClass = Object.class; // Assuming Object does not have a corresponding PartialConverter
            manager.getPartialConverter(invalidClass);
            fail("Expected IllegalArgumentException for invalid class");
        } catch (IllegalArgumentException e) {
            // Corrected: Use the invalidClass variable defined in this method
            assertTrue(e.getMessage().contains("No partial converter found for type: " + Object.class.getName()));
        } catch (Exception e) {
            fail("Unexpected exception type: " + e.getClass().getName());
        }
    }


}