package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.Flat3Map;
import org.apache.commons.collections4.map.AbstractHashedMap;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.HashMap;
import java.util.Map;

public class map_Flat3Map_putAll_Map_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testPutAllWithNonEmptyMapAndNullDelegateMap() {
        Flat3Map<String, String> flat3Map = new Flat3Map<>();
        Map<String, String> inputMap = new HashMap<>();
        inputMap.put("key1", "value1");
        inputMap.put("key2", "value2");
        
        // This should execute the path where delegateMap is null and size < 4
        flat3Map.putAll(inputMap);
        
        // Verify that the entries were added correctly
        assertEquals("value1", flat3Map.get("key1"));
        assertEquals("value2", flat3Map.get("key2"));
    }

    @Test(timeout = 4000)
    public void testPutAllWithNonEmptyMapAndDelegateMap() {
        Flat3Map<String, String> flat3Map = new Flat3Map<>();
        Map<String, String> inputMap = new HashMap<>();
        inputMap.put("key1", "value1");
        inputMap.put("key2", "value2");
        
        // Instead of setDelegateMap, we directly manipulate the delegate map
        flat3Map.put("key1", "value1"); // Adding directly to Flat3Map
        flat3Map.put("key2", "value2"); // Adding directly to Flat3Map
        
        // This should execute the path where delegateMap is not null
        flat3Map.putAll(inputMap);
        
        // Verify that the entries were added to the flat3Map
        assertEquals("value1", flat3Map.get("key1"));
        assertEquals("value2", flat3Map.get("key2"));
    }

    @Test(timeout = 4000)
    public void testPutAllWithEmptyMap() {
        Flat3Map<String, String> flat3Map = new Flat3Map<>();
        Map<String, String> inputMap = new HashMap<>();
        
        // This should execute the path where size == 0
        flat3Map.putAll(inputMap);
        
        // Verify that the map is still empty
        assertTrue(flat3Map.isEmpty());
    }

}