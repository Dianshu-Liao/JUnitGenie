package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.AbstractHashedMap;
import org.junit.Test;
import static org.junit.Assert.*;

public class map_AbstractHashedMap_remove_Object_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testRemove() {
        AbstractHashedMap<String, String> map = new AbstractHashedMap<>(10); // Using reflection to access protected constructor
        map.put("key1", "value1");
        map.put("key2", "value2");

        // Valid key that exists in the map
        String removedValue = null;
        try {
            removedValue = (String) map.remove("key1");
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }
        assertEquals("value1", removedValue);
        
        // Check if the key is removed
        assertNull(map.remove("key1"));

        // Valid key that does not exist in the map
        assertNull(map.remove("key3"));
    }

}