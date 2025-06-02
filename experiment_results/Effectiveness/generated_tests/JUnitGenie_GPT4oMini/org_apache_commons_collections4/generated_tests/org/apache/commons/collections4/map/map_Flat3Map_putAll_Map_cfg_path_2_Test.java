package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.Flat3Map;
import org.apache.commons.collections4.map.AbstractHashedMap;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.HashMap;
import java.util.Map;

public class map_Flat3Map_putAll_Map_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testPutAllWithNonEmptyMap() {
        // Arrange
        Flat3Map<String, String> flat3Map = new Flat3Map<>();
        Map<String, String> inputMap = new HashMap<>();
        inputMap.put("key1", "value1");
        inputMap.put("key2", "value2");
        inputMap.put("key3", "value3");

        // Act
        flat3Map.putAll(inputMap);

        // Assert
        assertEquals("value1", flat3Map.get("key1"));
        assertEquals("value2", flat3Map.get("key2"));
        assertEquals("value3", flat3Map.get("key3"));
    }

    @Test(timeout = 4000)
    public void testPutAllWithEmptyMap() {
        // Arrange
        Flat3Map<String, String> flat3Map = new Flat3Map<>();
        Map<String, String> inputMap = new HashMap<>();

        // Act
        flat3Map.putAll(inputMap);

        // Assert
        assertNull(flat3Map.get("anyKey")); // No entries should be present
    }

    @Test(timeout = 4000)
    public void testPutAllWithDelegateMap() {
        // Arrange
        AbstractHashedMap<String, String> delegate = new AbstractHashedMap<>();
        Flat3Map<String, String> flat3Map = new Flat3Map<>(delegate);
        Map<String, String> inputMap = new HashMap<>();
        inputMap.put("key1", "value1");

        // Act
        flat3Map.putAll(inputMap);

        // Assert
        assertEquals("value1", flat3Map.get("key1")); // Check flat3Map first
        assertEquals("value1", delegate.get("key1")); // Then check delegate
    }

    @Test(timeout = 4000)
    public void testPutAllWithSizeLessThanFour() {
        // Arrange
        Flat3Map<String, String> flat3Map = new Flat3Map<>();
        Map<String, String> inputMap = new HashMap<>();
        inputMap.put("key1", "value1");
        inputMap.put("key2", "value2");

        // Act
        flat3Map.putAll(inputMap);

        // Assert
        assertEquals("value1", flat3Map.get("key1"));
        assertEquals("value2", flat3Map.get("key2"));
    }

    @Test(timeout = 4000)
    public void testPutAllWithSizeGreaterThanOrEqualToFour() {
        // Arrange
        Flat3Map<String, String> flat3Map = new Flat3Map<>();
        Map<String, String> inputMap = new HashMap<>();
        inputMap.put("key1", "value1");
        inputMap.put("key2", "value2");
        inputMap.put("key3", "value3");
        inputMap.put("key4", "value4");

        // Act
        flat3Map.putAll(inputMap);

        // Assert
        assertEquals("value1", flat3Map.get("key1"));
        assertEquals("value2", flat3Map.get("key2"));
        assertEquals("value3", flat3Map.get("key3"));
        assertEquals("value4", flat3Map.get("key4"));
    }


}