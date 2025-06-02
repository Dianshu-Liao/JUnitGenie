package org.apache.commons.lang3;
import org.apache.commons.lang3.SystemProperties;
import org.junit.Test;
import java.util.function.BooleanSupplier;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class SystemProperties_getBoolean_String_BooleanSupplier_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testGetBooleanWithValidKeyAndDefaultSupplier() {
        // Arrange
        String key = "valid.property.key";
        BooleanSupplier defaultSupplier = () -> true;

        // Act
        boolean result = SystemProperties.getBoolean(key, defaultSupplier);

        // Assert
        assertTrue(result); // Assuming the property is set to "true"
    }

    @Test(timeout = 4000)
    public void testGetBooleanWithValidKeyAndNullSupplier() {
        // Arrange
        String key = "valid.property.key";
        BooleanSupplier defaultSupplier = null;

        // Act
        boolean result = SystemProperties.getBoolean(key, defaultSupplier);

        // Assert
        assertTrue(result); // Assuming the property is set to "true"
    }

    @Test(timeout = 4000)
    public void testGetBooleanWithInvalidKeyAndDefaultSupplier() {
        // Arrange
        String key = "invalid.property.key";
        BooleanSupplier defaultSupplier = () -> false;

        // Act
        boolean result = SystemProperties.getBoolean(key, defaultSupplier);

        // Assert
        assertFalse(result); // Assuming the property is not set, default should be used
    }

    @Test(timeout = 4000)
    public void testGetBooleanWithInvalidKeyAndNullSupplier() {
        // Arrange
        String key = "invalid.property.key";
        BooleanSupplier defaultSupplier = null;

        // Act
        boolean result = SystemProperties.getBoolean(key, defaultSupplier);

        // Assert
        assertFalse(result); // Assuming the property is not set, and no default supplier is provided
    }

}