package org.joda.time.convert;
import org.joda.time.convert.ConverterManager;
import org.joda.time.convert.PartialConverter;
import org.junit.Test;
import static org.junit.Assert.*;

public class convert_ConverterManager_getPartialConverter_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testGetPartialConverterWithNullObject() {
        ConverterManager manager = new ConverterManager();
        try {
            PartialConverter converter = manager.getPartialConverter(null);
            assertNull(converter);
        } catch (IllegalArgumentException e) {
            fail("Exception should not be thrown for null input");
        }
    }

    @Test(timeout = 4000)
    public void testGetPartialConverterWithInvalidClass() {
        ConverterManager manager = new ConverterManager();
        try {
            // Assuming there is no valid converter for this class
            Class<?> invalidClass = Object.class; // Use a class that does not have a converter
            PartialConverter converter = manager.getPartialConverter(invalidClass);
            assertNull(converter);
        } catch (IllegalArgumentException e) {
            // Moved invalidClass declaration outside of the try block to make it accessible
            Class<?> invalidClass = Object.class; // Use a class that does not have a converter
            assertEquals("No partial converter found for type: " + invalidClass.getName(), e.getMessage());
        }
    }


}