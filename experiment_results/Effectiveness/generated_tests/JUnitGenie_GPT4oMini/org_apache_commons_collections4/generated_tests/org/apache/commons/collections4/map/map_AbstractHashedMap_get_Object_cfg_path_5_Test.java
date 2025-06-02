package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.AbstractHashedMap;
import org.junit.Test;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;

public class map_AbstractHashedMap_get_Object_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testGetNullKey() {
        AbstractHashedMap<Object, Object> map = new AbstractHashedMap<Object, Object>() {
            // Overriding the protected constructor using reflection
            {
                try {
                    java.lang.reflect.Constructor<AbstractHashedMap> constructor = 
                        AbstractHashedMap.class.getDeclaredConstructor();
                    constructor.setAccessible(true);
                    constructor.newInstance();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        
        // Calling get with null, which should return null
        Object result = map.get(null);
        assertNull(result);
    }
    
    @Test(timeout = 4000)
    public void testGetWithNonNullKey() {
        AbstractHashedMap<Object, String> map = new AbstractHashedMap<Object, String>() {
            {
                try {
                    // Using a valid constructor
                    java.lang.reflect.Constructor<AbstractHashedMap> constructor = 
                        AbstractHashedMap.class.getDeclaredConstructor(int.class);
                    constructor.setAccessible(true);
                    constructor.newInstance(10);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        
        // Adding a value to the map
        map.put("testKey", "testValue");
        
        // Retrieving the value with the key
        Object result = map.get("testKey");
        assertNotNull(result);
    }

    @Test(timeout = 4000)
    public void testGetNonExistentKey() {
        AbstractHashedMap<Object, Object> map = new AbstractHashedMap<Object, Object>() {
            {
                try {
                    // Using a valid constructor
                    java.lang.reflect.Constructor<AbstractHashedMap> constructor = 
                        AbstractHashedMap.class.getDeclaredConstructor(int.class);
                    constructor.setAccessible(true);
                    constructor.newInstance(10);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        
        // Attempting to retrieve a value with a non-existent key
        Object result = map.get("nonExistentKey");
        assertNull(result);
    }


}