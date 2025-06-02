package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.AbstractHashedMap;
import org.junit.Test;
import static org.junit.Assert.*;

public class map_AbstractHashedMap_get_Object_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testGetReturnsNullForNonExistentKey() {
        AbstractHashedMap<String, String> map = new AbstractHashedMap<>();
        String key = "nonExistentKey"; // Valid key
        String result = null;
        try {
            result = (String) map.get(key);
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }
        assertNull("Expected null for non-existent key", result);
    }

    @Test(timeout = 4000)
    public void testGetWithNullKey() {
        AbstractHashedMap<String, String> map = new AbstractHashedMap<>();
        String result = null;
        try {
            result = (String) map.get(null); // This should not throw an exception
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }
        assertNull("Expected null for null key", result);
    }

}