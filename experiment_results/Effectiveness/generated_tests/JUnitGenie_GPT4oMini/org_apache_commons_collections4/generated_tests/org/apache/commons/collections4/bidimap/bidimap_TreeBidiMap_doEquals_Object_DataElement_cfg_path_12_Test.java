package org.apache.commons.collections4.bidimap;
import org.apache.commons.collections4.bidimap.TreeBidiMap;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class bidimap_TreeBidiMap_doEquals_Object_DataElement_cfg_path_12_Test {

    @Test(timeout = 4000)
    public void testDoEquals() {
        try {
            // Create instances of TreeBidiMap
            TreeBidiMap<String, String> map1 = new TreeBidiMap<>();
            TreeBidiMap<String, String> map2 = new TreeBidiMap<>();

            // Set nodeCount to be equal for both instances
            setNodeCount(map1, 1);
            setNodeCount(map2, 1);

            // Add elements to both maps
            map1.put("key1", "value1");
            map2.put("key1", "value1");

            // Access the private method using reflection
            Method method = TreeBidiMap.class.getDeclaredMethod("equals", Object.class);
            method.setAccessible(true);

            // Test equality
            assertTrue((Boolean) method.invoke(map1, map2));

            // Modify map2 to make them unequal
            map2.put("key2", "value2");
            assertFalse((Boolean) method.invoke(map1, map2));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setNodeCount(TreeBidiMap<?, ?> map, int count) throws Exception {
        // Use reflection to set the private field nodeCount
        java.lang.reflect.Field field = TreeBidiMap.class.getDeclaredField("nodeCount");
        field.setAccessible(true);
        field.setInt(map, count);
    }

}