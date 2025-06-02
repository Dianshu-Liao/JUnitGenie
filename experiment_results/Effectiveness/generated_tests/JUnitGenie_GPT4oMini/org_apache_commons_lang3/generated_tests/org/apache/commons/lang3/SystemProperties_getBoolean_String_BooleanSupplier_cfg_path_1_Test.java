package org.apache.commons.lang3;
import org.apache.commons.lang3.SystemProperties;
import org.junit.Test;
import java.util.function.BooleanSupplier;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class SystemProperties_getBoolean_String_BooleanSupplier_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetBooleanWithValidTrueKey() {
        // Setup
        String key = "validTrueKey"; // This should correspond to a valid property key that returns "true"
        System.setProperty(key, "true");
        BooleanSupplier defaultIfAbsent = () -> false;

        // Execute
        boolean result = SystemProperties.getBoolean(key, defaultIfAbsent);

        // Verify
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testGetBooleanWithValidFalseKey() {
        // Setup
        String key = "validFalseKey"; // This should correspond to a valid property key that returns "false"
        System.setProperty(key, "false");
        BooleanSupplier defaultIfAbsent = () -> true;

        // Execute
        boolean result = SystemProperties.getBoolean(key, defaultIfAbsent);

        // Verify
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testGetBooleanWithNullKey() {
        // Setup
        String key = null;
        BooleanSupplier defaultIfAbsent = () -> true;

        // Execute
        boolean result = SystemProperties.getBoolean(key, defaultIfAbsent);

        // Verify
        assertTrue(result); // Since key is null, it should call defaultIfAbsent
    }

    @Test(timeout = 4000)
    public void testGetBooleanWithDefaultIfAbsentNull() {
        // Setup
        String key = "nonExistentKey"; // This should correspond to a key that does not exist
        BooleanSupplier defaultIfAbsent = null;

        // Execute
        boolean result = SystemProperties.getBoolean(key, defaultIfAbsent);

        // Verify
        assertFalse(result); // Since the key does not exist and defaultIfAbsent is null, it should return false
    }

}