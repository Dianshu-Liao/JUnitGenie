package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.MultiKeyMap;
import org.apache.commons.collections4.map.AbstractHashedMap;
import org.junit.Test;
import static org.junit.Assert.*;

public class map_MultiKeyMap_put_Object_Object_Object_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testPutWithNewEntry() {
        // Create a MultiKeyMap instance
        MultiKeyMap<String, Integer> multiKeyMap = new MultiKeyMap<>();
        
        // Define keys and value
        String key1 = "key1";
        String key2 = "key2";
        String key3 = "key3";
        Integer value = 1;

        // Check that putting a new entry returns null
        assertNull(multiKeyMap.put(key1, key2, key3, value));
    }

    @Test(timeout = 4000)
    public void testPutWithExistingEntry() {
        // Create a MultiKeyMap instance
        MultiKeyMap<String, Integer> multiKeyMap = new MultiKeyMap<>();
        
        // Define keys and value
        String key1 = "key1";
        String key2 = "key2";
        String key3 = "key3";
        Integer value1 = 1;
        Integer value2 = 2;

        // First put operation
        assertNull(multiKeyMap.put(key1, key2, key3, value1));
        // Second put operation with the same keys, checking return of old value
        assertEquals(value1, multiKeyMap.put(key1, key2, key3, value2));
    }

    @Test(timeout = 4000)
    public void testPutWithNullValues() {
        // Create a MultiKeyMap instance
        MultiKeyMap<String, Integer> multiKeyMap = new MultiKeyMap<>();
        
        // Define keys and null value
        String key1 = "key1";
        String key2 = "key2";
        String key3 = "key3";

        // Check that putting an entry with a null value returns null
        assertNull(multiKeyMap.put(key1, key2, key3, null));
        
        // Check that replacing existing entry with a null value returns the old value
        multiKeyMap.put(key1, key2, key3, 1);
        assertEquals(Integer.valueOf(1), multiKeyMap.put(key1, key2, key3, null));
    }

    @Test(timeout = 4000)
    public void testPutWithSameKeysDifferentValues() {
        // Create a MultiKeyMap instance
        MultiKeyMap<String, String> multiKeyMap = new MultiKeyMap<>();
        
        // Define keys and two different values
        String key1 = "key1";
        String key2 = "key2";
        String key3 = "key3";
        String value1 = "value1";
        String value2 = "value2";

        // First put operation
        assertNull(multiKeyMap.put(key1, key2, key3, value1));
        // Second put operation with the same keys, checking return of old value
        assertEquals(value1, multiKeyMap.put(key1, key2, key3, value2));
    }

}