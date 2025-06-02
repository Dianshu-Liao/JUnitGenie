package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.MultiKeyMap;
import org.junit.Test;
import static org.junit.Assert.*;

public class map_MultiKeyMap_removeMultiKey_Object_Object_Object_Object_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testRemoveMultiKey() {
        MultiKeyMap multiKeyMap = new MultiKeyMap();
        
        // Adding a key-value pair to the map
        multiKeyMap.put("key1", "key2", "key3", "key4", "value");

        // Test removing the key
        Object removedValue = null;
        try {
            removedValue = multiKeyMap.removeMultiKey("key1", "key2", "key3", "key4");
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }

        // Verify the value is removed
        assertEquals("value", removedValue);
        assertNull(multiKeyMap.removeMultiKey("key1", "key2", "key3", "key4")); // Should return null now
    }

    @Test(timeout = 4000)
    public void testRemoveMultiKeyWithNulls() {
        MultiKeyMap multiKeyMap = new MultiKeyMap();
        
        // Adding a key-value pair with null keys
        multiKeyMap.put(null, null, null, null, "valueWithNulls");

        // Test removing the key with nulls
        Object removedValue = null;
        try {
            removedValue = multiKeyMap.removeMultiKey(null, null, null, null);
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }

        // Verify the value is removed
        assertEquals("valueWithNulls", removedValue);
        assertNull(multiKeyMap.removeMultiKey(null, null, null, null)); // Should return null now
    }

}