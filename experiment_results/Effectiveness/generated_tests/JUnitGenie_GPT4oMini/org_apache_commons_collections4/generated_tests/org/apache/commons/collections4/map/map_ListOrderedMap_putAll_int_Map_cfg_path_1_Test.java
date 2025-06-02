package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.ListOrderedMap;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.fail;

public class map_ListOrderedMap_putAll_int_Map_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testPutAll_IndexOutOfBoundsException() {
        ListOrderedMap<String, String> listOrderedMap = new ListOrderedMap<>();
        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");

        try {
            // Attempt to put all with an invalid index
            listOrderedMap.putAll(-1, map);
            fail("Expected IndexOutOfBoundsException to be thrown");
        } catch (IndexOutOfBoundsException e) {
            // Exception is expected, test passes
            System.out.println("Caught expected exception: " + e.getMessage());
        }
    }


}