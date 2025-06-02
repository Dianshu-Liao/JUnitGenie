package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.ListOrderedMap;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.*;

public class map_ListOrderedMap_putAll_int_Map_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testPutAllWithValidIndex() {
        ListOrderedMap<String, Integer> listOrderedMap = new ListOrderedMap<>();
        Map<String, Integer> mapToAdd = new HashMap<>();
        mapToAdd.put("one", 1);
        mapToAdd.put("two", 2);

        // Valid index
        int index = 0;

        try {
            listOrderedMap.putAll(index, mapToAdd);
            assertEquals(2, listOrderedMap.size());
            assertTrue(listOrderedMap.containsKey("one"));
            assertTrue(listOrderedMap.containsKey("two"));
        } catch (Exception e) {
            fail("Exception should not have been thrown for valid index");
        }
    }

    @Test(timeout = 4000)
    public void testPutAllWithNegativeIndex() {
        ListOrderedMap<String, Integer> listOrderedMap = new ListOrderedMap<>();
        Map<String, Integer> mapToAdd = new HashMap<>();
        mapToAdd.put("one", 1);

        // Invalid index
        int index = -1;

        try {
            listOrderedMap.putAll(index, mapToAdd);
            fail("Expected IndexOutOfBoundsException for negative index");
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Index: -1, Size: 0", e.getMessage());
        } catch (Exception e) {
            fail("Unexpected exception type thrown");
        }
    }

    @Test(timeout = 4000)
    public void testPutAllWithIndexGreaterThanSize() {
        ListOrderedMap<String, Integer> listOrderedMap = new ListOrderedMap<>();
        Map<String, Integer> mapToAdd = new HashMap<>();
        mapToAdd.put("one", 1);

        // Invalid index greater than size
        int index = 1;

        try {
            listOrderedMap.putAll(index, mapToAdd);
            fail("Expected IndexOutOfBoundsException for index greater than size");
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Index: 1, Size: 0", e.getMessage());
        } catch (Exception e) {
            fail("Unexpected exception type thrown");
        }
    }

}