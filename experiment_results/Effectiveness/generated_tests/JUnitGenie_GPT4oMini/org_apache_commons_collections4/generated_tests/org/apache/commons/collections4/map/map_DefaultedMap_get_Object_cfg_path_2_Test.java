package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.DefaultedMap;
import org.apache.commons.collections4.Transformer;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class map_DefaultedMap_get_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testGetWithExistingKey() {
        // Arrange
        Transformer<Object, Object> transformer = input -> "defaultValue";
        DefaultedMap<Object, Object> map = new DefaultedMap<>(transformer);
        map.put("key1", "value1");

        // Act
        Object result = map.get("key1");

        // Assert
        assertEquals("value1", result);
    }

    @Test(timeout = 4000)
    public void testGetWithNonExistingKey() {
        // Arrange
        Transformer<Object, Object> transformer = input -> "defaultValue";
        DefaultedMap<Object, Object> map = new DefaultedMap<>(transformer);

        // Act
        Object result = map.get("nonExistingKey");

        // Assert
        assertEquals("defaultValue", result);
    }

    @Test(timeout = 4000)
    public void testGetWithNullKey() {
        // Arrange
        Transformer<Object, Object> transformer = input -> "defaultValue";
        DefaultedMap<Object, Object> map = new DefaultedMap<>(transformer);
        map.put(null, "valueNull");

        // Act
        Object result = map.get(null);

        // Assert
        assertEquals("valueNull", result);
    }

}