package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.ListOrderedMap;
import org.junit.Test;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;

public class map_ListOrderedMap_remove_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testRemoveKeyExists() {
        ListOrderedMap<String, String> map = new ListOrderedMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");

        // Ensure the key exists before removal
        assertNotNull(map.remove("key1"));
        // Verify that the key is removed
        assertNull(map.remove("key1"));
    }

    @Test(timeout = 4000)
    public void testRemoveKeyDoesNotExist() {
        ListOrderedMap<String, String> map = new ListOrderedMap<>();
        map.put("key1", "value1");

        // Attempt to remove a key that does not exist
        assertNull(map.remove("key2"));
    }

}