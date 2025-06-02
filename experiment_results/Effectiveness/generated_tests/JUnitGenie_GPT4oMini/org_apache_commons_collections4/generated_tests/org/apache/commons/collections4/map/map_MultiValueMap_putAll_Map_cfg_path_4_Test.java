package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.MultiValueMap;
import org.junit.Test;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class map_MultiValueMap_putAll_Map_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testPutAllWithMultiMap() {
        MultiValueMap<String, String> multiValueMap = new MultiValueMap<>();
        Map<String, Collection<String>> map = new HashMap<>();
        map.put("key1", Arrays.asList("value1", "value2"));
        map.put("key2", Arrays.asList("value3"));

        try {
            multiValueMap.putAll(map);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }


}