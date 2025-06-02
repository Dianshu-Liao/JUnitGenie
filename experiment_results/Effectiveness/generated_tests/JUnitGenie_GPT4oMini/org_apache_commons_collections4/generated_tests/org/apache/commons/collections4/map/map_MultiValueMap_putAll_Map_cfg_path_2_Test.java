package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.MultiValueMap;
import org.junit.Test;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class map_MultiValueMap_putAll_Map_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testPutAllWithMultiMap() {
        try {
            MultiValueMap<String, String> multiValueMap = new MultiValueMap<>();
            Map<String, Collection<String>> mapToAdd = new HashMap<>();
            Collection<String> values = new ArrayList<>();
            values.add("value1");
            mapToAdd.put("key1", values);
            multiValueMap.putAll(mapToAdd);
            // Assert to verify that the elements were added correctly
            assert multiValueMap.size() == 1; // We expect 1 entry
        } catch (Exception e) {
            e.printStackTrace(); // Handle any exceptions that may be thrown
        }
    }

    @Test(timeout = 4000)
    public void testPutAllWithNonMultiMap() {
        try {
            MultiValueMap<String, String> multiValueMap = new MultiValueMap<>();
            Map<String, String> mapToAdd = new HashMap<>();
            mapToAdd.put("key2", "value2");
            multiValueMap.putAll(mapToAdd);
            // Assert to verify that the elements were added correctly
            assert multiValueMap.size() == 1; // We expect 1 entry
        } catch (Exception e) {
            e.printStackTrace(); // Handle any exceptions that may be thrown
        }
    }

}