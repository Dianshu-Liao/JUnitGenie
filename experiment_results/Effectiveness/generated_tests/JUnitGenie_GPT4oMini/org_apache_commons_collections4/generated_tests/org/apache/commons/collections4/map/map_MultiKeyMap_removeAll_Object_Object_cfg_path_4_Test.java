package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.MultiKeyMap;
import org.apache.commons.collections4.keyvalue.MultiKey;
import org.junit.Test;
import static org.junit.Assert.*;

public class map_MultiKeyMap_removeAll_Object_Object_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testRemoveAll() {
        // Initialize the MultiKeyMap
        MultiKeyMap<String, String> multiKeyMap = new MultiKeyMap<>();
        multiKeyMap.put(new MultiKey<>("key1", "key2"), "value1");
        multiKeyMap.put(new MultiKey<>("key3", "key4"), "value2");
        
        // Check initial state
        assertTrue(multiKeyMap.size() > 0);

        // Test for successful removal
        boolean result = false;
        try {
            result = multiKeyMap.removeAll("key1", "key2");
            assertTrue(result);
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }

        // Verify that the items are removed
        assertEquals(1, multiKeyMap.size()); // Only one entry should remain

        // Test that removing again does not modify the map
        try {
            result = multiKeyMap.removeAll("key1", "key2");
            assertFalse(result);
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }

        // Final verification
        assertEquals(1, multiKeyMap.size()); // Size should still be one
    }

}