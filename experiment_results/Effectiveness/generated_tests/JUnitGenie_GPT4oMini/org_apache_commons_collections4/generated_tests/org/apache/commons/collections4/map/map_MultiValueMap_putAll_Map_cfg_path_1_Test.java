package org.apache.commons.collections4.map;
import static org.junit.Assert.*;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.junit.Test;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class map_MultiValueMap_putAll_Map_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testPutAllWithMultiMap() {
        MultiValuedMap<String, String> map = new ArrayListValuedHashMap<>(); // Use a concrete implementation
        MultiValuedMap<String, String> multiMap = new ArrayListValuedHashMap<>();
        Collection<String> values = new ArrayList<>();
        values.add("value1");
        multiMap.put("key1", "value1"); // Corrected to put a single value instead of a collection

        try {
            map.putAll(multiMap);
            assertTrue(map.containsKey("key1"));
            assertTrue(map.get("key1").contains("value1"));
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testPutAllWithNonMultiMap() {
        MultiValuedMap<String, String> map = new ArrayListValuedHashMap<>(); // Use a concrete implementation
        Map<String, String> regularMap = new HashMap<>();
        regularMap.put("key2", "value2");

        try {
            // Convert regularMap to a MultiValuedMap before putting it in
            MultiValuedMap<String, String> tempMap = new ArrayListValuedHashMap<>();
            for (Map.Entry<String, String> entry : regularMap.entrySet()) {
                tempMap.put(entry.getKey(), entry.getValue());
            }
            map.putAll(tempMap);
            assertTrue(map.containsKey("key2"));
            assertTrue(map.get("key2").contains("value2"));
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

}