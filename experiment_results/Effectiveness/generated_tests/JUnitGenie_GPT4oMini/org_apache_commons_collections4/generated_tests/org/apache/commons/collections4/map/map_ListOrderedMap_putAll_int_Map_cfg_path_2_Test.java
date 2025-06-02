package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.ListOrderedMap;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.fail;

public class map_ListOrderedMap_putAll_int_Map_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testPutAll_IndexOutOfBoundsException() {
        ListOrderedMap<String, String> listOrderedMap = new ListOrderedMap<>();
        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");

        try {
            // This should throw an IndexOutOfBoundsException since the index is negative
            listOrderedMap.putAll(-1, map);
            fail("Expected IndexOutOfBoundsException to be thrown");
        } catch (IndexOutOfBoundsException e) {
            // Exception is expected, test passes
        }

        try {
            // This should throw an IndexOutOfBoundsException since the index is greater than the size
            listOrderedMap.putAll(1, map);
            fail("Expected IndexOutOfBoundsException to be thrown");
        } catch (IndexOutOfBoundsException e) {
            // Exception is expected, test passes
        }
    }

}