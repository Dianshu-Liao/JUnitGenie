package org.apache.commons.collections4.map;
import static org.junit.Assert.*;
import org.apache.commons.collections4.map.AbstractHashedMap;
import org.junit.Before;
import org.junit.Test;
import java.lang.reflect.Field;

public class map_AbstractHashedMap_remove_Object_cfg_path_1_Test {

    private AbstractHashedMap<String, Integer> map;

    @Before
    public void setUp() {
        map = new AbstractHashedMap<>(); // using default constructor
        // Add entries to the map for testing removal
        try {
            addEntryToMap("testKey", 42);
        } catch (Exception e) {
            // Handle the exception here in case reflection fails
            fail("Reflective operation failed: " + e.getMessage());
        }
    }

    // Helper method to add an entry to the HashMap using reflection
    private void addEntryToMap(String key, Integer value) throws Exception {
        Field dataField = AbstractHashedMap.class.getDeclaredField("data");
        dataField.setAccessible(true);
        Object[] dataArray = (Object[]) dataField.get(map);
        
        int hashCode = key.hashCode();
        int index = Math.abs(hashCode % dataArray.length); // Hashing logic similar to the focal method

        // Create a HashEntry instance directly
        Class<?> hashEntryClass = Class.forName("org.apache.commons.collections4.map.AbstractHashedMap$HashEntry");
        Object hashEntry = hashEntryClass.getConstructor(int.class, Object.class).newInstance(hashCode, key);
        
        // Use reflection to add the HashEntry directly to the data array
        dataArray[index] = hashEntry;
    }

    @Test(timeout = 4000)
    public void testRemoveExistingKey() {
        // Test case: Remove an existing key
        Object result = map.remove("testKey");
        assertEquals(Integer.valueOf(42), result);
    }

    @Test(timeout = 4000)
    public void testRemoveNonExistingKey() {
        // Test case: Remove a non-existing key
        Object result = map.remove("nonExistingKey");
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testRemoveWithNullKey() {
        // Test case: Remove with null key
        Object result = map.remove(null);
        assertNull(result);
    }

}