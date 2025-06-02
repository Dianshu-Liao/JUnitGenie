package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.ListOrderedMap;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

public class map_ListOrderedMap_putAll_int_Map_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testPutAllWithValidIndex() {
        ListOrderedMap<String, Integer> listOrderedMap = new ListOrderedMap<>();
        Map<String, Integer> mapToInsert = new HashMap<>();
        mapToInsert.put("one", 1);
        mapToInsert.put("two", 2);

        try {
            listOrderedMap.putAll(0, mapToInsert);
            // Additional assertions can be added here to verify the state of listOrderedMap
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testPutAllWithNegativeIndex() {
        ListOrderedMap<String, Integer> listOrderedMap = new ListOrderedMap<>();
        Map<String, Integer> mapToInsert = new HashMap<>();
        mapToInsert.put("one", 1);

        try {
            listOrderedMap.putAll(-1, mapToInsert);
        } catch (IndexOutOfBoundsException e) {
            // Expected exception
        } catch (Exception e) {
            // Handle unexpected exceptions
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testPutAllWithIndexGreaterThanSize() {
        ListOrderedMap<String, Integer> listOrderedMap = new ListOrderedMap<>();
        Map<String, Integer> mapToInsert = new HashMap<>();
        mapToInsert.put("one", 1);

        try {
            listOrderedMap.putAll(1, mapToInsert);
        } catch (IndexOutOfBoundsException e) {
            // Expected exception
        } catch (Exception e) {
            // Handle unexpected exceptions
            e.printStackTrace();
        }
    }

}