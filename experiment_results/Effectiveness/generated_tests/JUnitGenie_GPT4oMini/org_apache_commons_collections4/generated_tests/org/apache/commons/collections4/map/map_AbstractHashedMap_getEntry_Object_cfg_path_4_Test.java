package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.AbstractHashedMap;
import org.junit.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import static org.junit.Assert.assertNotNull;

public class map_AbstractHashedMap_getEntry_Object_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testGetEntry() {
        try {
            // Use reflection to access the protected constructor
            Constructor<AbstractHashedMap> constructor = AbstractHashedMap.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            AbstractHashedMap<Object, Object> map = constructor.newInstance();

            // Prepare a key and add an entry to the map
            Object key = new Object();
            Object value = new Object();
            // Add the entry to the map
            map.put(key, value); // Uncomment this line if a put method is available

            // Use reflection to access the protected getEntry method
            Method getEntryMethod = AbstractHashedMap.class.getDeclaredMethod("getEntry", Object.class);
            getEntryMethod.setAccessible(true);

            // Call the getEntry method
            Object entry = getEntryMethod.invoke(map, key);

            // Assert that the entry is not null (assuming the entry was added)
            assertNotNull(entry);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}