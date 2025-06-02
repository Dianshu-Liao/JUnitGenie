package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.MultiKeyMap;
import org.apache.commons.collections4.keyvalue.MultiKey;
import org.apache.commons.collections4.MapIterator;
import org.junit.Test;
import static org.junit.Assert.*;

public class map_MultiKeyMap_removeAll_Object_Object_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testRemoveAll() {
        // Setup
        MultiKeyMap<String, String> multiKeyMap = new MultiKeyMap<>();
        multiKeyMap.put(new MultiKey<>("key1", "key2", "key3"), "value1");
        multiKeyMap.put(new MultiKey<>("key4", "key5", "key6"), "value2");

        // Test case where keys match
        boolean modified = false;
        try {
            modified = multiKeyMap.removeAll("key1", "key2", "key3");
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }
        assertTrue(modified);
        assertFalse(multiKeyMap.containsKey(new MultiKey<>("key1", "key2", "key3")));

        // Test case where keys do not match
        modified = false;
        try {
            modified = multiKeyMap.removeAll("nonexistentKey1", "nonexistentKey2", "nonexistentKey3");
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }
        assertFalse(modified);
    }

}