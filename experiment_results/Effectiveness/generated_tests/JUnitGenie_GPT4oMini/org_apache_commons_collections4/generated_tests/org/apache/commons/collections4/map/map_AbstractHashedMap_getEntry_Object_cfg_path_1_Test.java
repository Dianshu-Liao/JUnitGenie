package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.AbstractHashedMap;
import org.junit.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class map_AbstractHashedMap_getEntry_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetEntry() {
        try {
            // Use reflection to access the protected constructor
            Constructor<AbstractHashedMap> constructor = AbstractHashedMap.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            AbstractHashedMap<Object, Object> map = constructor.newInstance();

            // Prepare a key and an entry to add to the map
            Object key = new Object();
            Object value = new Object();

            // Use reflection to access the protected method to add an entry
            Method putMethod = AbstractHashedMap.class.getDeclaredMethod("put", Object.class, Object.class);
            putMethod.setAccessible(true);
            putMethod.invoke(map, key, value);

            // Now test the getEntry method
            Method getEntryMethod = AbstractHashedMap.class.getDeclaredMethod("getEntry", Object.class);
            getEntryMethod.setAccessible(true);
            Object entry = getEntryMethod.invoke(map, key);

            // Assert that the entry is not null
            assertNotNull(entry);

            // Test with a non-existing key
            Object nonExistingKey = new Object();
            Object nonExistingEntry = getEntryMethod.invoke(map, nonExistingKey);

            // Assert that the entry is null
            assertNull(nonExistingEntry);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}