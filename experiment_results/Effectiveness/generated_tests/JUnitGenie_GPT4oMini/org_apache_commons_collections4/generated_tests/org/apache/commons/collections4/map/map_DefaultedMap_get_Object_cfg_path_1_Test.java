package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.DefaultedMap;
import org.apache.commons.collections4.Transformer;
import org.junit.Test;
import static org.junit.Assert.*;

public class map_DefaultedMap_get_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetWithNonNullKey() {
        // Create a Transformer that returns a default value
        Transformer<Object, Object> transformer = new Transformer<Object, Object>() {
            @Override
            public Object transform(Object input) {
                return "defaultValue";
            }
        };

        // Create an instance of DefaultedMap
        DefaultedMap<Object, Object> map = new DefaultedMap<>(transformer);
        
        // Add a key-value pair to the map
        map.put("key1", "value1");

        // Test the get method with a key that exists in the map
        Object result = map.get("key1");
        assertEquals("value1", result);
    }

    @Test(timeout = 4000)
    public void testGetWithNullKey() {
        // Create a Transformer that returns a default value
        Transformer<Object, Object> transformer = new Transformer<Object, Object>() {
            @Override
            public Object transform(Object input) {
                return "defaultValue";
            }
        };

        // Create an instance of DefaultedMap
        DefaultedMap<Object, Object> map = new DefaultedMap<>(transformer);

        // Test the get method with a null key
        Object result = map.get(null);
        assertEquals("defaultValue", result);
    }

    @Test(timeout = 4000)
    public void testGetWithNonExistentKey() {
        // Create a Transformer that returns a default value
        Transformer<Object, Object> transformer = new Transformer<Object, Object>() {
            @Override
            public Object transform(Object input) {
                return "defaultValue";
            }
        };

        // Create an instance of DefaultedMap
        DefaultedMap<Object, Object> map = new DefaultedMap<>(transformer);

        // Test the get method with a key that does not exist in the map
        Object result = map.get("nonExistentKey");
        assertEquals("defaultValue", result);
    }

}