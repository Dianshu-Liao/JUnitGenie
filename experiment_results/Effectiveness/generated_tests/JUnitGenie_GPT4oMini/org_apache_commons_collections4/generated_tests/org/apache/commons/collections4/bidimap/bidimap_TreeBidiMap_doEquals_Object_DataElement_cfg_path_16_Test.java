package org.apache.commons.collections4.bidimap;
import org.apache.commons.collections4.bidimap.TreeBidiMap;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class bidimap_TreeBidiMap_doEquals_Object_DataElement_cfg_path_16_Test {

    @Test(timeout = 4000)
    public void testDoEquals() {
        try {
            // Create instances of TreeBidiMap
            TreeBidiMap<String, String> map1 = new TreeBidiMap<>();
            TreeBidiMap<String, String> map2 = new TreeBidiMap<>();

            // Set nodeCount to be equal for both maps
            setNodeCount(map1, 1);
            setNodeCount(map2, 1);

            // Populate the maps
            map1.put("key1", "value1");
            map2.put("key1", "value1");

            // Access the private method using reflection
            Method method = TreeBidiMap.class.getDeclaredMethod("doEquals", Object.class);
            method.setAccessible(true);

            // Test with equal maps
            assertTrue((Boolean) method.invoke(map1, map2));

            // Modify map2 to make them unequal
            map2.put("key1", "value2");
            assertFalse((Boolean) method.invoke(map1, map2));

            // Test with a non-map object
            assertFalse((Boolean) method.invoke(map1, new Object()));

            // Test with null
            assertFalse((Boolean) method.invoke(map1, null));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setNodeCount(TreeBidiMap<?, ?> map, int count) throws Exception {
        java.lang.reflect.Field field = TreeBidiMap.class.getDeclaredField("nodeCount");
        field.setAccessible(true);
        field.setInt(map, count);
    }

}