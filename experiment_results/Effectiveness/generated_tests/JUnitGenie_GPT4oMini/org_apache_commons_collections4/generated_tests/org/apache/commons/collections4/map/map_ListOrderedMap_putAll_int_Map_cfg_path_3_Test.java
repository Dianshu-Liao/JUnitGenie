package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.ListOrderedMap;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.*;

public class map_ListOrderedMap_putAll_int_Map_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testPutAll_Success() {
        // Arrange
        ListOrderedMap<String, Integer> listOrderedMap = new ListOrderedMap<>();
        listOrderedMap.put(0, "A", 1);
        listOrderedMap.put(1, "B", 2);
        
        Map<String, Integer> mapToPut = new HashMap<>();
        mapToPut.put("C", 3);
        mapToPut.put("D", 4);
        
        // Act
        try {
            listOrderedMap.putAll(1, mapToPut);
        } catch (Exception e) {
            fail("Should not have thrown an exception: " + e.getMessage());
        }

        // Assert
        assertEquals(4, listOrderedMap.size());
        assertTrue(listOrderedMap.containsKey("C"));
        assertTrue(listOrderedMap.containsKey("D"));
    }

    @Test(timeout = 4000)
    public void testPutAll_IndexOutOfBounds() {
        // Arrange
        ListOrderedMap<String, Integer> listOrderedMap = new ListOrderedMap<>();
        Map<String, Integer> mapToPut = new HashMap<>();
        mapToPut.put("A", 1);
        
        // Act & Assert
        try {
            listOrderedMap.putAll(-1, mapToPut);
            fail("Expected IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            // Expected exception
        }

        try {
            listOrderedMap.putAll(1, mapToPut);
            fail("Expected IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            // Expected exception
        }
    }

}