package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.DefaultedMap;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class map_DefaultedMap_get_Object_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testGetWithExistingKey() {
        // Arrange
        DefaultedMap<String, String> map = new DefaultedMap<>(key -> "default");
        map.put("key1", "value1");

        // Act
        Object result = map.get("key1");

        // Assert
        assertEquals("value1", result);
    }

    @Test(timeout = 4000)
    public void testGetWithNonExistingKey() {
        // Arrange
        DefaultedMap<String, String> map = new DefaultedMap<>(key -> "default");

        // Act
        Object result = map.get("nonExistingKey");

        // Assert
        assertEquals("default", result);
    }

}