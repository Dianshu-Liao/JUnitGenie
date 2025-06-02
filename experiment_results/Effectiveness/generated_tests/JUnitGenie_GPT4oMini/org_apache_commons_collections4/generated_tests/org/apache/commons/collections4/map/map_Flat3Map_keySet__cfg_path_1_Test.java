package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.Flat3Map;
import org.apache.commons.collections4.map.AbstractHashedMap;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class map_Flat3Map_keySet__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testKeySetWhenDelegateMapIsNull() {
        Flat3Map<String, String> flat3Map = new Flat3Map<>();
        // When delegateMap is null, the KeySet constructor should be called
        assertNotNull(flat3Map.keySet());
    }

    @Test(timeout = 4000)
    public void testKeySetWhenDelegateMapIsNotNull() {
        // Create a delegate map
        AbstractHashedMap<String, String> delegateMap = new AbstractHashedMap<>(16); // Specify initial capacity
        delegateMap.put("key1", "value1");
        
        // Create Flat3Map with the delegate map
        Flat3Map<String, String> flat3Map = new Flat3Map<>(delegateMap);
        
        // When delegateMap is not null, the keySet should return the keys from the delegate map
        assertNotNull(flat3Map.keySet());
        // Additional assertions can be added to verify the contents of the keySet if needed
    }


}