package org.apache.commons.lang3;
import org.apache.commons.lang3.SystemProperties;
import org.junit.Test;
import java.util.function.BooleanSupplier;
import static org.junit.Assert.assertTrue;

public class SystemProperties_getBoolean_String_BooleanSupplier_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testGetBoolean_withValidKey_andDefaultSupplier() {
        // Arrange
        String key = "test.key";
        BooleanSupplier defaultSupplier = () -> true;

        // Simulate setting a system property for testing
        System.setProperty(key, "false");

        try {
            // Act
            boolean result = SystemProperties.getBoolean(key, defaultSupplier);

            // Assert
            assertTrue(!result); // The property is "false", so the result should be false.
        } finally {
            // Clean up by removing the property after the test
            System.clearProperty(key);
        }
    }

    @Test(timeout = 4000)
    public void testGetBoolean_withValidKey_andNullDefaultSupplier() {
        // Arrange
        String key = "another.test.key";
        BooleanSupplier defaultSupplier = null;

        // Simulate setting a system property for testing
        System.setProperty(key, "true");

        try {
            // Act
            boolean result = SystemProperties.getBoolean(key, defaultSupplier);

            // Assert
            assertTrue(result); // The property is "true", so the result should be true.
        } finally {
            // Clean up by removing the property after the test
            System.clearProperty(key);
        }
    }

    @Test(timeout = 4000)
    public void testGetBoolean_withInvalidKey_andDefaultSupplier() {
        // Arrange
        String key = "invalid.key";
        BooleanSupplier defaultSupplier = () -> false;

        try {
            // Act
            boolean result = SystemProperties.getBoolean(key, defaultSupplier);

            // Assert
            assertTrue(!result); // Since the property is absent, we expect the default to be used, which is false.
        } finally {
            // No cleanup needed as there were no simulated properties set.
        }
    }

}