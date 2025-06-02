package org.apache.commons.collections4.bidimap;
import org.apache.commons.collections4.bidimap.TreeBidiMap;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class bidimap_TreeBidiMap_doEquals_Object_DataElement_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testDoEquals() {
        try {
            // Create instances of TreeBidiMap
            TreeBidiMap<String, String> map1 = new TreeBidiMap<>();
            TreeBidiMap<String, String> map2 = new TreeBidiMap<>();

            // Populate the maps to ensure they are equal
            map1.put("key1", "value1");
            map1.put("key2", "value2");
            map2.put("key1", "value1");
            map2.put("key2", "value2");

            // Access the private method using reflection
            Method method = TreeBidiMap.class.getDeclaredMethod("equals", Object.class);
            method.setAccessible(true);

            // Test for equality
            boolean result = (boolean) method.invoke(map1, map2);
            assertTrue(result);

            // Modify map2 to make them unequal
            map2.put("key3", "value3");

            // Test for inequality
            result = (boolean) method.invoke(map1, map2);
            assertFalse(result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}