package org.apache.commons.collections4.bidimap;
import org.apache.commons.collections4.bidimap.TreeBidiMap;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class bidimap_TreeBidiMap_doEquals_Object_DataElement_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testDoEquals() {
        try {
            // Create an instance of TreeBidiMap
            TreeBidiMap<String, String> bidiMap = new TreeBidiMap<>();
            // Set the nodeCount to a positive value to ensure the loop executes
            // This is done through reflection since nodeCount is private
            java.lang.reflect.Field nodeCountField = TreeBidiMap.class.getDeclaredField("nodeCount");
            nodeCountField.setAccessible(true);
            nodeCountField.setInt(bidiMap, 1); // Set nodeCount to 1

            // Prepare a Map to compare
            Map<String, String> otherMap = new HashMap<>();
            otherMap.put("key1", "value1");

            // Invoke the private method doEquals using reflection
            Method doEqualsMethod = TreeBidiMap.class.getDeclaredMethod("equals", Object.class);
            doEqualsMethod.setAccessible(true);

            // Test case where the maps are equal
            assertTrue((Boolean) doEqualsMethod.invoke(bidiMap, otherMap));

            // Test case where the maps are not equal
            otherMap.put("key2", "value2");
            assertFalse((Boolean) doEqualsMethod.invoke(bidiMap, otherMap));

            // Test case with null as the object
            assertFalse((Boolean) doEqualsMethod.invoke(bidiMap, null));

            // Test case with an object that is not a Map
            assertFalse((Boolean) doEqualsMethod.invoke(bidiMap, "Not a Map"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}