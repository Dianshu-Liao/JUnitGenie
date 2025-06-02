package org.apache.commons.collections4.bidimap;
import org.apache.commons.collections4.bidimap.TreeBidiMap;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.*;

public class bidimap_TreeBidiMap_doEquals_Object_DataElement_cfg_path_15_Test {

    @Test(timeout = 4000)
    public void testDoEquals() {
        // Create instances of TreeBidiMap
        TreeBidiMap<String, String> originalMap = new TreeBidiMap<>();
        TreeBidiMap<String, String> equivalentMap = new TreeBidiMap<>();
        
        // Add some data to the maps
        originalMap.put("key1", "value1");
        equivalentMap.put("key1", "value1");

        // Set the internal node counts to be equal
        setNodeCount(originalMap, 1);
        setNodeCount(equivalentMap, 1);

        // Use reflection to access the private doEquals method
        try {
            Method method = TreeBidiMap.class.getDeclaredMethod("doEquals", Object.class, Object.class);
            method.setAccessible(true);

            // Invoke the method
            boolean result = (boolean) method.invoke(originalMap, equivalentMap, null);

            // Assert that the result is true
            assertTrue(result);
        } catch (Exception e) {
            e.printStackTrace();
            fail("Exception occurred while testing doEquals: " + e.getMessage());
        }
    }

    private void setNodeCount(TreeBidiMap<?, ?> map, int value) {
        try {
            java.lang.reflect.Field field = TreeBidiMap.class.getDeclaredField("nodeCount");
            field.setAccessible(true);
            field.setInt(map, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}