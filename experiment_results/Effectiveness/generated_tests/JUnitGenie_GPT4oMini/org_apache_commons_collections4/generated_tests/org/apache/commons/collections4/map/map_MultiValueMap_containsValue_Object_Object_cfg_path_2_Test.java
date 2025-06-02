package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.MultiValueMap;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class map_MultiValueMap_containsValue_Object_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testContainsValueWithNullCollection() {
        MultiValueMap<Object, Object> map = new MultiValueMap<>();
        Object key = new Object(); // key that does not exist in the map
        Object value = new Object(); // arbitrary value

        // The key does not correspond to any existing key in the MultiValueMap instance
        try {
            boolean result = map.containsValue(key, value);
            assertFalse(result); // Expecting false since the collection for the key is null
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}