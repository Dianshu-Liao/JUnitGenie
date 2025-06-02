package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.CompositeMap;
import org.apache.commons.collections4.set.CompositeSet;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import static org.junit.Assert.assertNotNull;

public class map_CompositeMap_entrySet__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testEntrySet() {
        // Setup: Initialize the composite map with sample maps
        Map<String, String>[] sampleMaps = new HashMap[2];
        sampleMaps[0] = new HashMap<>();
        sampleMaps[0].put("key1", "value1");
        sampleMaps[1] = new HashMap<>();
        sampleMaps[1].put("key2", "value2");

        // Create an instance of CompositeMap with the sampleMaps
        CompositeMap<String, String> compositeMap = new CompositeMap<>(sampleMaps);

        // Invoke the entrySet method
        Set<Map.Entry<String, String>> entries = null;
        try {
            entries = compositeMap.entrySet();
        } catch (Exception e) {
            // Handle potential exceptions during entrySet execution
            e.printStackTrace();
        }

        // Verify: Ensure that the entries are not null
        assertNotNull(entries);
    }

}