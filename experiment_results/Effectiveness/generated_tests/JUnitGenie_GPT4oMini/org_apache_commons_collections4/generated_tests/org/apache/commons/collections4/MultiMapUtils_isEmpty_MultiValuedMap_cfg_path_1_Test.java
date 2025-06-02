package org.apache.commons.collections4;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.MultiMapUtils;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class MultiMapUtils_isEmpty_MultiValuedMap_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testIsEmpty_withNullMap() {
        MultiValuedMap<?, ?> map = null;
        try {
            boolean result = MultiMapUtils.isEmpty(map);
            assertTrue(result);
        } catch (Exception e) {
            // Handle the exception if necessary - though it shouldn't throw an exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIsEmpty_withEmptyMap() {
        MultiValuedMap<String, String> map = new ArrayListValuedHashMap<>();
        try {
            boolean result = MultiMapUtils.isEmpty(map);
            assertTrue(result);
        } catch (Exception e) {
            // Handle the exception if necessary - though it shouldn't throw an exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIsEmpty_withNonEmptyMap() {
        MultiValuedMap<String, String> map = new ArrayListValuedHashMap<>();
        map.put("key", "value");
        try {
            boolean result = MultiMapUtils.isEmpty(map);
            assertFalse(result);
        } catch (Exception e) {
            // Handle the exception if necessary - though it shouldn't throw an exception
            e.printStackTrace();
        }
    }

}