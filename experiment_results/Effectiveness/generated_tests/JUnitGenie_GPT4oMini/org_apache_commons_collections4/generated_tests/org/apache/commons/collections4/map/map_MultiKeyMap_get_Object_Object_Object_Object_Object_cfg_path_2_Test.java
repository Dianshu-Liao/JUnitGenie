package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.MultiKeyMap;
import org.apache.commons.collections4.keyvalue.MultiKey;
import org.junit.Test;
import static org.junit.Assert.*;

public class map_MultiKeyMap_get_Object_Object_Object_Object_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testGetWithValidKeys() {
        MultiKeyMap multiKeyMap = new MultiKeyMap();
        Object key1 = new Object();
        Object key2 = new Object();
        Object key3 = new Object();
        Object key4 = new Object();
        Object key5 = new Object();
        
        // Create a MultiKey object with the keys
        MultiKey multiKey = new MultiKey(key1, key2, key3, key4, key5);
        multiKeyMap.put(multiKey, new Object()); // Store an object with the MultiKey
        
        try {
            Object result = multiKeyMap.get(multiKey);
            assertNotNull(result); // Expecting a non-null result since the keys match
        } catch (Exception e) {
            fail("Exception should not be thrown for valid keys: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testGetWithNullEntry() {
        MultiKeyMap multiKeyMap = new MultiKeyMap();
        Object key1 = new Object();
        Object key2 = new Object();
        Object key3 = new Object();
        Object key4 = new Object();
        Object key5 = new Object();
        
        // Attempt to get a value with keys that do not exist
        MultiKey multiKey = new MultiKey(key1, key2, key3, key4, key5);
        try {
            Object result = multiKeyMap.get(multiKey);
            assertNull(result); // Expecting null since the keys do not match
        } catch (Exception e) {
            fail("Exception should not be thrown when entry is null: " + e.getMessage());
        }
    }


}