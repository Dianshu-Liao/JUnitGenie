package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.ListOrderedMap;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.NoSuchElementException;

public class map_ListOrderedMap_firstKey__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testFirstKeyThrowsExceptionWhenMapIsEmpty() {
        ListOrderedMap<Object, Object> map = new ListOrderedMap<>();
        try {
            map.firstKey();
            fail("Expected NoSuchElementException to be thrown");
        } catch (NoSuchElementException e) {
            assertEquals("Map is empty", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testFirstKeyReturnsFirstElementWhenMapIsNotEmpty() {
        ListOrderedMap<String, String> map = new ListOrderedMap<>();
        map.put("first", "value1");
        map.put("second", "value2");

        Object firstKey = map.firstKey();
        assertEquals("first", firstKey);
    }

}