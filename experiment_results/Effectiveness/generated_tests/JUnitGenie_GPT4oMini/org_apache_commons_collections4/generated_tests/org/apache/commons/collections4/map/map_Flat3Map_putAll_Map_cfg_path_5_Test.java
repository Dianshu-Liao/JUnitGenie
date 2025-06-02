package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.Flat3Map;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.HashMap;
import java.util.Map;

public class map_Flat3Map_putAll_Map_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testPutAllWithEmptyMap() {
        Flat3Map<String, String> flat3Map = new Flat3Map<>();
        Map<String, String> emptyMap = new HashMap<>();
        
        flat3Map.putAll(emptyMap);
        
        // Verify that the map is still empty
        assertTrue(flat3Map.isEmpty());
    }

}