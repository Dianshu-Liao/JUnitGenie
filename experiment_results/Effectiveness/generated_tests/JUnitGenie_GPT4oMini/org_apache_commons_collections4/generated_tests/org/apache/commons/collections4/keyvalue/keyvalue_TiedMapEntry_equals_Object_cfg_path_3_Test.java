package org.apache.commons.collections4.keyvalue;
import org.apache.commons.collections4.keyvalue.TiedMapEntry;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertTrue;

public class keyvalue_TiedMapEntry_equals_Object_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testEquals_WithEqualEntries() {
        // Arrange
        Map<String, String> map = new HashMap<>();
        String key = "testKey";
        String value = "testValue";
        map.put(key, value);
        
        TiedMapEntry<String, String> entry1 = new TiedMapEntry<>(map, key);
        TiedMapEntry<String, String> entry2 = new TiedMapEntry<>(map, key);
        
        // Act
        boolean result = entry1.equals(entry2);

        // Assert
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testEquals_WithDifferentKeys() {
        // Arrange
        Map<String, String> map = new HashMap<>();
        String key1 = "testKey1";
        String value1 = "testValue";
        String key2 = "testKey2";
        String value2 = "differentValue";
        
        map.put(key1, value1);
        map.put(key2, value2);

        TiedMapEntry<String, String> entry1 = new TiedMapEntry<>(map, key1);
        TiedMapEntry<String, String> entry2 = new TiedMapEntry<>(map, key2);
        
        // Act
        boolean result = entry1.equals(entry2);

        // Assert
        assertTrue(!result);
    }

    @Test(timeout = 4000)
    public void testEquals_WithMismatchedValue() {
        // Arrange
        Map<String, String> map = new HashMap<>();
        String key = "testKey";
        String value1 = "testValue";
        String value2 = "differentValue";
        
        map.put(key, value1);

        TiedMapEntry<String, String> entry1 = new TiedMapEntry<>(map, key);
        TiedMapEntry<String, String> entry2 = new TiedMapEntry<>(map, key);
        
        // Assume entry2 is manipulated to have a different value
        // this requires setting up the map differently which can depend on the logic in your actual getValue() implementation

        // Act
        boolean result = entry1.equals(entry2);

        // Assert
        assertTrue(!result);
    }

    @Test(timeout = 4000)
    public void testEquals_WithNonEntryObject() {
        // Arrange
        Map<String, String> map = new HashMap<>();
        String key = "testKey";
        String value = "testValue";
        map.put(key, value);

        TiedMapEntry<String, String> entry = new TiedMapEntry<>(map, key);
        Object nonEntryObject = new Object();

        // Act
        boolean result = entry.equals(nonEntryObject);

        // Assert
        assertTrue(!result);
    }

    @Test(timeout = 4000)
    public void testEquals_WithSameReference() {
        // Arrange
        Map<String, String> map = new HashMap<>();
        String key = "testKey";
        String value = "testValue";
        map.put(key, value);
        
        TiedMapEntry<String, String> entry = new TiedMapEntry<>(map, key);

        // Act
        boolean result = entry.equals(entry);

        // Assert
        assertTrue(result);
    }

}