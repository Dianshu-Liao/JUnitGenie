package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.MultiValueMap;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class map_MultiValueMap_totalSize__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testTotalSize() {
        MultiValueMap<String, String> map = new MultiValueMap<>();
        map.put("key1", "value1");
        map.put("key1", "value2");
        map.put("key2", "value3");

        int expectedSize = 3; // 2 values for key1 and 1 value for key2
        int actualSize = map.totalSize();
        assertEquals(expectedSize, actualSize);
    }

    @Test(timeout = 4000)
    public void testTotalSizeWithEmptyMap() {
        MultiValueMap<String, String> map = new MultiValueMap<>();

        int expectedSize = 0; // No values in the map
        int actualSize = map.totalSize();
        assertEquals(expectedSize, actualSize);
    }

    @Test(timeout = 4000)
    public void testTotalSizeWithNullValues() {
        MultiValueMap<String, Object> map = new MultiValueMap<>();
        map.put("key1", null); // Adding a null value

        int expectedSize = 1; // One null value is counted
        int actualSize = map.totalSize();
        assertEquals(expectedSize, actualSize);
    }

}