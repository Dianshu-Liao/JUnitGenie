package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.SingletonMap;
import org.junit.Test;
import static org.junit.Assert.fail;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class map_SingletonMap_putAll_Map_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testPutAll_ThrowsIllegalArgumentException_WhenMapSizeIsGreaterThanOne() {
        SingletonMap<Object, Object> singletonMap = new SingletonMap<>();
        Map<Object, Object> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");

        try {
            singletonMap.putAll(map);
        } catch (IllegalArgumentException e) {
            // Expected exception
            return;
        }
        // If we reach this point, the exception was not thrown
        fail("Expected IllegalArgumentException was not thrown.");
    }

    @Test(timeout = 4000)
    public void testPutAll_ReturnsWithoutException_WhenMapSizeIsZero() {
        SingletonMap<Object, Object> singletonMap = new SingletonMap<>();
        Map<Object, Object> map = Collections.emptyMap();

        try {
            singletonMap.putAll(map);
            // No exception should be thrown
        } catch (Exception e) {
            fail("No exception should be thrown for empty map.");
        }
    }

    @Test(timeout = 4000)
    public void testPutAll_ReturnsWithoutException_WhenMapSizeIsOne() {
        SingletonMap<Object, Object> singletonMap = new SingletonMap<>();
        Map<Object, Object> map = new HashMap<>();
        map.put("key1", "value1");

        try {
            singletonMap.putAll(map);
            // No exception should be thrown
        } catch (Exception e) {
            fail("No exception should be thrown for map with one entry.");
        }
    }


}