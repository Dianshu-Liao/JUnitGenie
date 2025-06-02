package org.apache.commons.collections4.bidimap;
import org.apache.commons.collections4.bidimap.TreeBidiMap;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class bidimap_TreeBidiMap_doEquals_Object_DataElement_cfg_path_22_Test {

    @Test(timeout = 4000)
    public void testDoEquals() {
        try {
            // Create an instance of TreeBidiMap
            TreeBidiMap<String, String> bidiMap = new TreeBidiMap<>();
            // Set the nodeCount to match the size of the map
            // Assuming we add some elements to the map
            bidiMap.put("key1", "value1");
            bidiMap.put("key2", "value2");

            // Access the private method using reflection
            Method method = TreeBidiMap.class.getDeclaredMethod("doEquals", Object.class, TreeBidiMap.DataElement.class);
            method.setAccessible(true);

            // Create a valid DataElement instance
            TreeBidiMap.DataElement dataElement = TreeBidiMap.DataElement.VALUE; // Use an existing enum value

            // Create a Map to compare
            Map<String, String> otherMap = new HashMap<>();
            otherMap.put("key1", "value1");
            otherMap.put("key2", "value2");

            // Test with a matching map
            boolean result = (boolean) method.invoke(bidiMap, otherMap, dataElement);
            assertTrue(result);

            // Test with a non-matching map
            otherMap.put("key3", "value3");
            result = (boolean) method.invoke(bidiMap, otherMap, dataElement);
            assertFalse(result);

            // Test with an object that is not a Map
            result = (boolean) method.invoke(bidiMap, new Object(), dataElement);
            assertFalse(result);

            // Test with null
            result = (boolean) method.invoke(bidiMap, null, dataElement);
            assertFalse(result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}