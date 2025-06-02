package org.apache.commons.collections4;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.HashMap;
import java.util.Map;

public class CollectionUtils_size_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testSizeWithMap() {
        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        
        int result = CollectionUtils.size(map);
        assertEquals(2, result);
    }

    @Test(timeout = 4000)
    public void testSizeWithNull() {
        int result = CollectionUtils.size(null);
        assertEquals(0, result);
    }

    @Test(timeout = 4000)
    public void testSizeWithEmptyMap() {
        Map<String, String> map = new HashMap<>();
        
        int result = CollectionUtils.size(map);
        assertEquals(0, result);
    }

}