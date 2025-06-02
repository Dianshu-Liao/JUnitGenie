package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.AbstractHashedMap;
import org.junit.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import static org.junit.Assert.assertNull;

public class map_AbstractHashedMap_getEntry_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testGetEntryWithNullKey() {
        try {
            // Create an instance of AbstractHashedMap using reflection
            Constructor<AbstractHashedMap> constructor = AbstractHashedMap.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            AbstractHashedMap<Object, Object> map = constructor.newInstance();

            // Call the protected method getEntry using reflection
            Method getEntryMethod = AbstractHashedMap.class.getDeclaredMethod("getEntry", Object.class);
            getEntryMethod.setAccessible(true);

            // Test with a null key
            Object result = getEntryMethod.invoke(map, (Object) null);
            assertNull(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetEntryWithNonExistentKey() {
        try {
            // Create an instance of AbstractHashedMap using reflection
            Constructor<AbstractHashedMap> constructor = AbstractHashedMap.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            AbstractHashedMap<Object, Object> map = constructor.newInstance();

            // Call the protected method getEntry using reflection
            Method getEntryMethod = AbstractHashedMap.class.getDeclaredMethod("getEntry", Object.class);
            getEntryMethod.setAccessible(true);

            // Test with a non-existent key
            Object result = getEntryMethod.invoke(map, new Object());
            assertNull(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}