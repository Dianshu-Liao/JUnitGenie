package org.apache.commons.collections4.bidimap;
import org.apache.commons.collections4.bidimap.TreeBidiMap;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class bidimap_TreeBidiMap_doEquals_Object_DataElement_cfg_path_13_Test {

    @Test(timeout = 4000)
    public void testDoEquals() {
        try {
            // Create instances of TreeBidiMap
            TreeBidiMap<String, String> map1 = new TreeBidiMap<>();
            TreeBidiMap<String, String> map2 = new TreeBidiMap<>();

            // Instead of accessing nodeCount directly, we will use the put method to add elements
            map2.put("key1", "value1");
            map2.put("key2", "value2");

            // Use reflection to access the private method
            Method method = TreeBidiMap.class.getDeclaredMethod("doEquals", Object.class);
            method.setAccessible(true);

            // Test with equal maps
            assertTrue((Boolean) method.invoke(map1, map2));

            // Test with non-equal maps
            Map<String, String> differentMap = new HashMap<>();
            differentMap.put("key1", "value1");
            differentMap.put("key2", "differentValue");
            assertFalse((Boolean) method.invoke(map1, differentMap));

            // Test with null
            assertFalse((Boolean) method.invoke(map1, null));

            // Test with an object that is not a Map
            assertFalse((Boolean) method.invoke(map1, new Object()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}