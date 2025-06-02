package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.ListOrderedMap;
import org.junit.Test;
import java.util.NoSuchElementException;
import static org.junit.Assert.*;

public class map_ListOrderedMap_firstKey__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testFirstKeyThrowsNoSuchElementExceptionWhenMapIsEmpty() {
        ListOrderedMap<Object, Object> map = new ListOrderedMap<>();
        
        try {
            map.firstKey();
            fail("Expected NoSuchElementException to be thrown");
        } catch (NoSuchElementException e) {
            assertEquals("Map is empty", e.getMessage());
        }
    }

}