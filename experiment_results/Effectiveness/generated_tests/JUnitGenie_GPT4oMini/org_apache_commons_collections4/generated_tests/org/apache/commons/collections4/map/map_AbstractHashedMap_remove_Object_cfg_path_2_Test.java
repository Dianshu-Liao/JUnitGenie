package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.AbstractHashedMap;
import org.junit.Test;
import static org.junit.Assert.*;

public class map_AbstractHashedMap_remove_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testRemove() {
        AbstractHashedMap<String, String> map = new AbstractHashedMap<>(10); // Using reflection to access protected constructor
        // Adding an entry to the map
        map.put("key1", "value1");

        // Test removing an existing key
        String removedValue = null;
        try {
            removedValue = (String) map.remove("key1");
        } catch (Exception e) {
            fail("Exception thrown during remove: " + e.getMessage());
        }
        assertEquals("value1", removedValue);

        // Test removing a non-existing key
        removedValue = null;
        try {
            removedValue = (String) map.remove("key2");
        } catch (Exception e) {
            fail("Exception thrown during remove: " + e.getMessage());
        }
        assertNull(removedValue);
    }

}