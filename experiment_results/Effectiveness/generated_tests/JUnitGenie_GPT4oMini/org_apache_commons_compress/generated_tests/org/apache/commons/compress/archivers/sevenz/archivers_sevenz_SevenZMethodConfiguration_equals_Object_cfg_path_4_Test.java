package org.apache.commons.compress.archivers.sevenz;
import org.apache.commons.compress.archivers.sevenz.SevenZMethodConfiguration;
import org.apache.commons.compress.archivers.sevenz.SevenZMethod;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class archivers_sevenz_SevenZMethodConfiguration_equals_Object_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testEquals_NullObject() {
        SevenZMethodConfiguration config1 = new SevenZMethodConfiguration(SevenZMethod.LZMA); // Use a valid enum constant
        try {
            // Test equals with null
            boolean result = config1.equals(null);
            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace(); // Rule 4: Using try-catch for exception handling
        }
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentClass() {
        SevenZMethodConfiguration config1 = new SevenZMethodConfiguration(SevenZMethod.LZMA); // Use a valid enum constant
        Object differentClassObject = new Object(); // Object of an unrelated class
        try {
            // Test equals with different class
            boolean result = config1.equals(differentClassObject);
            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace(); // Rule 4: Using try-catch for exception handling
        }
    }


}