package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.MultiValueMap;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import java.util.Collection;
import java.util.Arrays;

public class map_MultiValueMap_putAll_Map_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testPutAllWithMultiMap() {
        MultiValueMap<String, String> multiValueMap = new MultiValueMap<>();
        Map<String, Collection<String>> inputMap = new HashMap<>();
        inputMap.put("key1", Arrays.asList("value1", "value2"));
        inputMap.put("key2", Arrays.asList("value3"));

        try {
            multiValueMap.putAll(inputMap);
        } catch (Exception e) {
            // Handle exception if necessary
        }

        // Add assertions to verify the expected state of multiValueMap
        // For example:
        // assertEquals(2, multiValueMap.size());
        // assertTrue(multiValueMap.containsKey("key1"));
        // assertTrue(multiValueMap.containsKey("key2"));
    }

    @Test(timeout = 4000)
    public void testPutAllWithNonMultiMap() {
        MultiValueMap<String, String> multiValueMap = new MultiValueMap<>();
        Map<String, String> inputMap = new HashMap<>();
        inputMap.put("key1", "value1");
        inputMap.put("key2", "value2");

        try {
            multiValueMap.putAll(inputMap);
        } catch (Exception e) {
            // Handle exception if necessary
        }

        // Add assertions to verify the expected state of multiValueMap
        // For example:
        // assertEquals(2, multiValueMap.size());
        // assertEquals("value1", multiValueMap.get("key1"));
        // assertEquals("value2", multiValueMap.get("key2"));
    }

}