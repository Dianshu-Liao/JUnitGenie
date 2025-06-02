package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.Flat3Map;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.util.HashMap;
import java.util.Map;

public class map_Flat3Map_putAll_Map_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testPutAllWithNonEmptyMap() {
        Flat3Map<Integer, String> flat3Map = new Flat3Map<>();
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");

        // Pre-condition: Ensure we have enough entries in the map
        assertNotNull(map);
        assertTrue(map.size() >= 4);

        // Execute the method under test
        flat3Map.putAll(map);
        
        // Test the size of the internal map using a public method
        assertNotNull(flat3Map); // Check if flat3Map is not null
        assertTrue(flat3Map.size() == 4); // Check the size of flat3Map directly
    }

    @Test(timeout = 4000)
    public void testPutAllWithEmptyMap() {
        Flat3Map<Integer, String> flat3Map = new Flat3Map<>();
        Map<Integer, String> map = new HashMap<>();

        // Execute the method under test with an empty map
        flat3Map.putAll(map);
        
        // Verify that the internal map is still empty using a public method
        assertNotNull(flat3Map); // Check if flat3Map is not null
        assertTrue(flat3Map.isEmpty()); // Check if flat3Map is empty
    }

    @Test(timeout = 4000)
    public void testPutAllWithDelegateMapNull() {
        Flat3Map<Integer, String> flat3Map = new Flat3Map<>();
        // flat3Map.setDelegateMap(null); // Removed this line as it is not needed
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        map.put(2, "Two");

        // Execute the method under test
        flat3Map.putAll(map);

        // Verify that the mapping works as expected using a public method
        assertNotNull(flat3Map); // Check if flat3Map is not null
        assertTrue(flat3Map.size() == 2); // Check the size of flat3Map directly
    }

    @Test(timeout = 4000)
    public void testPutAllWithLargeMap() {
        Flat3Map<Integer, String> flat3Map = new Flat3Map<>();
        Map<Integer, String> map = new HashMap<>();
        for (int i = 1; i <= 10; i++) {
            map.put(i, "Number " + i);
        }

        // Execute the method under test with a large map
        flat3Map.putAll(map);

        // Validate the results using a public method
        assertNotNull(flat3Map); // Check if flat3Map is not null
        assertTrue(flat3Map.size() == 10); // Check the size of flat3Map directly
    }

}