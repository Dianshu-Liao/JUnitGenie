package org.apache.commons.collections4.bidimap;
import org.apache.commons.collections4.bidimap.TreeBidiMap;
import org.apache.commons.collections4.bidimap.TreeBidiMap.Node;
import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.reflect.Method;

public class bidimap_TreeBidiMap_doRemoveValue_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testDoRemoveValue() {
        // Create an instance of TreeBidiMap
        TreeBidiMap<String, String> bidiMap = new TreeBidiMap<>();
        
        // Add a single entry to the map to meet the nodeCount constraint
        bidiMap.put("key1", "value1");

        // Use reflection to access the private method doRemoveValue
        try {
            Method method = TreeBidiMap.class.getDeclaredMethod("doRemoveValue", Object.class);
            method.setAccessible(true);

            // Call the method with a valid key that exists in the map
            Comparable result = (Comparable) method.invoke(bidiMap, "key1");
            assertEquals("key1", result);

            // Call the method with a value that does not exist
            result = (Comparable) method.invoke(bidiMap, "nonExistentKey");
            assertNull(result);
        } catch (Exception e) {
            e.printStackTrace();
            fail("Exception thrown during test: " + e.getMessage());
        }
    }

}