package org.apache.commons.collections4.bidimap;
import org.apache.commons.collections4.bidimap.TreeBidiMap;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class bidimap_TreeBidiMap_doEquals_Object_DataElement_cfg_path_23_Test {

    @Test(timeout = 4000)
    public void testDoEquals() {
        try {
            // Create an instance of TreeBidiMap
            TreeBidiMap<String, String> bidiMap = new TreeBidiMap<>();

            // Create a Map to compare
            Map<String, String> otherMap = new HashMap<>();
            // Add an entry to the otherMap
            otherMap.put("key1", "value1");

            // Use reflection to access the private method doEquals
            Method method = TreeBidiMap.class.getDeclaredMethod("equals", Object.class);
            method.setAccessible(true);

            // Test with a Map that has the same size and values
            assertTrue((Boolean) method.invoke(bidiMap, otherMap));

            // Test with a Map that has a different size
            otherMap.put("key2", "value2");
            assertFalse((Boolean) method.invoke(bidiMap, otherMap));

            // Test with a null object
            assertFalse((Boolean) method.invoke(bidiMap, null));

            // Test with an object that is not a Map
            assertFalse((Boolean) method.invoke(bidiMap, "Not a Map"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}