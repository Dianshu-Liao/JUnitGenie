package org.apache.commons.collections4;
import org.apache.commons.collections4.MapUtils;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class MapUtils_isNotEmpty_Map_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testIsNotEmpty_withNonEmptyMap() {
        // Arrange
        Map<String, String> map = new HashMap<>();
        map.put("key", "value");

        // Act
        boolean result = MapUtils.isNotEmpty(map);

        // Assert
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testIsNotEmpty_withEmptyMap() {
        // Arrange
        Map<String, String> map = new HashMap<>();

        // Act
        boolean result = MapUtils.isNotEmpty(map);

        // Assert
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testIsNotEmpty_withNullMap() {
        // Arrange
        Map<String, String> map = null;

        // Act
        boolean result;
        try {
            result = MapUtils.isNotEmpty(map);
        } catch (Exception e) {
            // Assert
            assertTrue(e instanceof NullPointerException);
            return; // Exit the test as we expect an exception
        }

        // If no exception is thrown, fail the test
        fail("Expected NullPointerException was not thrown.");
    }


}