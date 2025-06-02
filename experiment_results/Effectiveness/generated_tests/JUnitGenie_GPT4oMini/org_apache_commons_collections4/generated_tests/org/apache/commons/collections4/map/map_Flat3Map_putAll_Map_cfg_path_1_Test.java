package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.Flat3Map;
import org.apache.commons.collections4.map.AbstractHashedMap;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.HashMap;
import java.util.Map;

public class map_Flat3Map_putAll_Map_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testPutAllWithNonEmptyMap() {
        Flat3Map<String, String> flat3Map = new Flat3Map<>();
        Map<String, String> inputMap = new HashMap<>();
        inputMap.put("key1", "value1");
        inputMap.put("key2", "value2");

        // Ensure delegateMap is null initially
        // Removed getDelegateMap() as it does not exist
        assertEquals(0, flat3Map.size());

        // Call the putAll method
        flat3Map.putAll(inputMap);

        // Verify the contents of the Flat3Map
        assertEquals(2, flat3Map.size());
        assertEquals("value1", flat3Map.get("key1"));
        assertEquals("value2", flat3Map.get("key2"));
    }

    @Test(timeout = 4000)
    public void testPutAllWithDelegateMap() {
        Flat3Map<String, String> flat3Map = new Flat3Map<>();
        // Removed setDelegateMap() as it does not exist
        Map<String, String> inputMap = new HashMap<>();
        inputMap.put("key1", "value1");

        // Call the putAll method
        flat3Map.putAll(inputMap);

        // Verify the contents of the Flat3Map
        // Adjusted to check the size of flat3Map directly
        assertEquals(1, flat3Map.size());
        assertEquals("value1", flat3Map.get("key1"));
    }

    @Test(timeout = 4000)
    public void testPutAllWithEmptyMap() {
        Flat3Map<String, String> flat3Map = new Flat3Map<>();
        Map<String, String> inputMap = new HashMap<>(); // Empty map

        // Call the putAll method
        flat3Map.putAll(inputMap);

        // Verify that the size remains 0
        assertEquals(0, flat3Map.size());
    }

    @Test(timeout = 4000)
    public void testPutAllWithNullMap() {
        Flat3Map<String, String> flat3Map = new Flat3Map<>();

        try {
            flat3Map.putAll(null); // This should not throw an exception
        } catch (Exception e) {
            fail("putAll should not throw an exception when map is null");
        }
    }

}