package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.SingletonMap;
import org.junit.Test;
import java.util.Collections;
import java.util.Map;

public class map_SingletonMap_putAll_Map_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testPutAllWithEmptyMap() {
        SingletonMap<Object, Object> singletonMap = new SingletonMap<>();
        singletonMap.putAll(Collections.emptyMap());
        // Expected: Nothing happens
    }

    @Test(timeout = 4000)
    public void testPutAllWithSingleEntry() {
        SingletonMap<Object, Object> singletonMap = new SingletonMap<>();
        Map<Object, Object> singleEntryMap = Collections.singletonMap("key", "value");
        singletonMap.putAll(singleEntryMap);
        // Verify that the entry has been added
        // (Additional code to assert the map contains the entry can be added here)
    }

    @Test(timeout = 4000)
    public void testPutAllWithMoreThanOneEntry() {
        SingletonMap<Object, Object> singletonMap = new SingletonMap<>();
        try {
            // Use a different method to create a map with multiple entries
            Map<Object, Object> multipleEntriesMap = new java.util.HashMap<>();
            multipleEntriesMap.put("key1", "value1");
            multipleEntriesMap.put("key2", "value2");
            singletonMap.putAll(multipleEntriesMap);
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }


}