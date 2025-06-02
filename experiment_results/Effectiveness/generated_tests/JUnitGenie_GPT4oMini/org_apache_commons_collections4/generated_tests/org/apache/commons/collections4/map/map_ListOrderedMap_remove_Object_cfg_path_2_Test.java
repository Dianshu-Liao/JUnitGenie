package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.ListOrderedMap;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class map_ListOrderedMap_remove_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testRemoveKeyExists() {
        ListOrderedMap<String, String> map = new ListOrderedMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");

        // Test removing an existing key
        String result = map.remove("key1");
        assertNull(result); // Expecting null since the key was removed
    }

    @Test(timeout = 4000)
    public void testRemoveKeyDoesNotExist() {
        ListOrderedMap<String, String> map = new ListOrderedMap<>();
        map.put("key1", "value1");

        // Test removing a non-existing key
        String result = map.remove("key2");
        assertNull(result); // Expecting null since the key does not exist
    }

}