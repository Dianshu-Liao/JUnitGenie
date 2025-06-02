package org.joda.time.convert;
import org.joda.time.convert.ConverterManager;
import org.joda.time.convert.PartialConverter;
import org.junit.Test;
import static org.junit.Assert.*;

public class convert_ConverterManager_getPartialConverter_Object_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testGetPartialConverterWithNullObject() {
        ConverterManager manager = new ConverterManager();
        try {
            PartialConverter result = manager.getPartialConverter(null);
            assertNull(result); // Expecting null since the object is null
        } catch (IllegalArgumentException e) {
            fail("Should not throw exception for null input");
        }
    }

    @Test(timeout = 4000)
    public void testGetPartialConverterWithInvalidClass() {
        ConverterManager manager = new ConverterManager();
        try {
            // Create a mock or a class that does not have a corresponding PartialConverter
            Class<?> invalidClass = Object.class; // Assuming Object does not have a PartialConverter
            PartialConverter result = manager.getPartialConverter(invalidClass);
            assertNull(result); // Expecting null since there is no converter for Object
        } catch (IllegalArgumentException e) {
            // Expected exception since there is no converter for the given class
            assertEquals("No partial converter found for type: " + Object.class.getName(), e.getMessage());
        }
    }


}