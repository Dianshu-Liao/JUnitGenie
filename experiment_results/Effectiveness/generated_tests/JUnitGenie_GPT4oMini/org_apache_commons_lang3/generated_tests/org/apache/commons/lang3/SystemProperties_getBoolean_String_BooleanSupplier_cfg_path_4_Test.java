package org.apache.commons.lang3;
import org.apache.commons.lang3.SystemProperties;
import org.junit.Test;
import java.util.function.BooleanSupplier;
import static org.junit.Assert.assertTrue;

public class SystemProperties_getBoolean_String_BooleanSupplier_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testGetBooleanWithValidKeyAndDefaultSupplier() {
        // Arrange
        String key = "valid.property.key"; // This should be a valid key that returns a non-null value
        BooleanSupplier defaultSupplier = () -> true; // Default supplier that returns true

        // Act
        boolean result = SystemProperties.getBoolean(key, defaultSupplier);

        // Assert
        assertTrue(result); // Assuming the property for the key is set to "true"
    }

    @Test(timeout = 4000)
    public void testGetBooleanWithNullKeyAndDefaultSupplier() {
        // Arrange
        String key = null; // Key is null
        BooleanSupplier defaultSupplier = () -> false; // Default supplier that returns false

        // Act
        boolean result = SystemProperties.getBoolean(key, defaultSupplier);

        // Assert
        assertTrue(result); // Should return false since defaultIfAbsent is not null
    }

    @Test(timeout = 4000)
    public void testGetBooleanWithValidKeyAndNullDefaultSupplier() {
        // Arrange
        String key = "valid.property.key"; // This should be a valid key that returns a non-null value
        BooleanSupplier defaultSupplier = null; // Default supplier is null

        // Act
        boolean result = SystemProperties.getBoolean(key, defaultSupplier);

        // Assert
        assertTrue(result); // Assuming the property for the key is set to "true"
    }

    @Test(timeout = 4000)
    public void testGetBooleanWithNullKeyAndNullDefaultSupplier() {
        // Arrange
        String key = null; // Key is null
        BooleanSupplier defaultSupplier = null; // Default supplier is null

        // Act
        boolean result = SystemProperties.getBoolean(key, defaultSupplier);

        // Assert
        assertTrue(result); // Should return false since defaultIfAbsent is null
    }

}