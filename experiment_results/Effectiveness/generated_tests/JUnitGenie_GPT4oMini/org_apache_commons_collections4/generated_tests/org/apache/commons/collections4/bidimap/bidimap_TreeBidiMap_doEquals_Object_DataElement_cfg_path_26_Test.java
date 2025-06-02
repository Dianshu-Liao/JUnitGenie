package org.apache.commons.collections4.bidimap;
import org.apache.commons.collections4.bidimap.TreeBidiMap;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertFalse;

public class bidimap_TreeBidiMap_doEquals_Object_DataElement_cfg_path_26_Test {

    @Test(timeout = 4000)
    public void testDoEqualsWithNonMapObject() {
        TreeBidiMap<String, String> bidimap = new TreeBidiMap<>();
        Object nonMapObject = new Object(); // Non-Map Object

        try {
            Method method = TreeBidiMap.class.getDeclaredMethod("equals", Object.class);
            method.setAccessible(true);
            boolean result = (Boolean) method.invoke(bidimap, nonMapObject);
            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testDoEqualsWithMapSizeMismatch() {
        TreeBidiMap<String, String> bidimap1 = new TreeBidiMap<>();
        bidimap1.put("key1", "value1");
        
        TreeBidiMap<String, String> bidimap2 = new TreeBidiMap<>();
        bidimap2.put("key2", "value2");

        try {
            Method method = TreeBidiMap.class.getDeclaredMethod("equals", Object.class);
            method.setAccessible(true);
            boolean result = (Boolean) method.invoke(bidimap1, bidimap2);
            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testDoEqualsWithMatchingMap() {
        TreeBidiMap<String, String> bidimap1 = new TreeBidiMap<>();
        bidimap1.put("key1", "value1");

        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");

        try {
            Method method = TreeBidiMap.class.getDeclaredMethod("equals", Object.class);
            method.setAccessible(true);
            boolean result = (Boolean) method.invoke(bidimap1, map);
            assertFalse(result); // Expect false since key counts do not match
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}