package org.apache.commons.collections4.bidimap;
import org.apache.commons.collections4.bidimap.TreeBidiMap;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class bidimap_TreeBidiMap_doEquals_Object_DataElement_cfg_path_14_Test {

    @Test(timeout = 4000)
    public void testDoEquals() {
        try {
            // Create instances of TreeBidiMap
            TreeBidiMap<String, String> map1 = new TreeBidiMap<>();
            TreeBidiMap<String, String> map2 = new TreeBidiMap<>();

            // Populate the maps
            map1.put("key1", "value1");
            map1.put("key2", "value2");
            map2.put("key1", "value1");
            map2.put("key2", "value2");

            // Access the private method using reflection
            Method method = TreeBidiMap.class.getDeclaredMethod("equals", Object.class);
            method.setAccessible(true);

            // Test case where both maps are equal
            boolean result = (boolean) method.invoke(map1, map2);
            assertTrue(result);

            // Test case where maps are not equal
            map2.put("key3", "value3");
            result = (boolean) method.invoke(map1, map2);
            assertFalse(result);

            // Test case where obj is not a Map
            result = (boolean) method.invoke(map1, new Object());
            assertFalse(result);

            // Test case where obj is null
            result = (boolean) method.invoke(map1, null);
            assertFalse(result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}