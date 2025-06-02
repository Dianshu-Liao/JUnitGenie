package org.apache.commons.collections4.bidimap;
import org.apache.commons.collections4.bidimap.TreeBidiMap;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class bidimap_TreeBidiMap_doEquals_Object_DataElement_cfg_path_9_Test {

    @Test(timeout = 4000)
    public void testDoEquals() {
        try {
            // Create an instance of TreeBidiMap
            TreeBidiMap<String, String> map1 = new TreeBidiMap<>();
            TreeBidiMap<String, String> map2 = new TreeBidiMap<>();

            // Add elements to both maps
            map1.put("key1", "value1");
            map2.put("key1", "value1");

            // Access the private method using reflection
            Method method = TreeBidiMap.class.getDeclaredMethod("equals", Object.class);
            method.setAccessible(true);

            // Test with equal maps
            assertTrue((Boolean) method.invoke(map1, map2));

            // Modify map2 to make them unequal
            map2.put("key2", "value2");
            assertFalse((Boolean) method.invoke(map1, map2));

            // Test with a non-map object
            assertFalse((Boolean) method.invoke(map1, new Object()));

            // Test with null
            assertFalse((Boolean) method.invoke(map1, null));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}