package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.AbstractHashedMap;
import org.junit.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import static org.junit.Assert.assertNull;

public class map_AbstractHashedMap_getEntry_Object_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testGetEntryReturnsNullForNonExistentKey() {
        try {
            // Use reflection to access the protected constructor
            Constructor<AbstractHashedMap> constructor = AbstractHashedMap.class.getDeclaredConstructor(int.class);
            constructor.setAccessible(true);
            AbstractHashedMap map = constructor.newInstance(10); // Initialize with a positive size

            // Prepare a key that is guaranteed to not exist in the map
            Object key = new Object();

            // Use reflection to access the protected method getEntry
            Method getEntryMethod = AbstractHashedMap.class.getDeclaredMethod("getEntry", Object.class);
            getEntryMethod.setAccessible(true);

            // Call the method and assert that it returns null
            Object result = getEntryMethod.invoke(map, key);
            assertNull(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}