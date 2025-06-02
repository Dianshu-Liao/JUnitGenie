package org.apache.commons.collections4;
import org.apache.commons.collections4.MapUtils;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertTrue;

public class MapUtils_isNotEmpty_Map_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testIsNotEmpty_withNonEmptyMap() {
        // Arrange
        Map<String, String> map = new HashMap<>();
        map.put("key", "value");

        // Act
        boolean result = MapUtils.isNotEmpty(map);

        // Assert
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testIsNotEmpty_withEmptyMap() {
        // Arrange
        Map<String, String> map = new HashMap<>();

        // Act
        boolean result = MapUtils.isNotEmpty(map);

        // Assert
        assertTrue(!result);
    }

    @Test(timeout = 4000)
    public void testIsNotEmpty_withNullMap() {
        // Arrange
        Map<String, String> map = null;

        // Act
        try {
            boolean result = MapUtils.isNotEmpty(map);
        } catch (NullPointerException e) {
            // Assert
            // Expected exception
        }
    }

}