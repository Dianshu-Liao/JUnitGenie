package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.MultiValueMap;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class map_MultiValueMap_totalSize__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testTotalSize() {
        MultiValueMap<String, String> map = new MultiValueMap<>();
        map.put("key1", "value1");
        map.put("key1", "value2");
        map.put("key2", "value3");

        int expectedSize = 3; // key1 has 2 values and key2 has 1 value
        int actualSize = map.totalSize();
        
        assertEquals(expectedSize, actualSize);
    }

}