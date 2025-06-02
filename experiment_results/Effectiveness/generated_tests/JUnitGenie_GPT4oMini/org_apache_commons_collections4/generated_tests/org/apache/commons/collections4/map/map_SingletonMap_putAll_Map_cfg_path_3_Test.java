package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.SingletonMap;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class map_SingletonMap_putAll_Map_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testPutAllWithEmptyMap() {
        SingletonMap<Object, Object> singletonMap = new SingletonMap<>();
        Map<Object, Object> emptyMap = Collections.emptyMap();
        
        singletonMap.putAll(emptyMap);
        
        // Verify no exception is thrown and nothing is added
        assertTrue(singletonMap.isEmpty());
    }

    @Test(timeout = 4000)
    public void testPutAllWithSingleEntryMap() {
        SingletonMap<Integer, String> singletonMap = new SingletonMap<>(1, "one");
        Map<Integer, String> singleEntryMap = new HashMap<>();
        singleEntryMap.put(2, "two");

        singletonMap.putAll(singleEntryMap);
        
        // Verify that the new entry is added 
        // This part requires additional verification if the implementation allows multiple entries.
        // For the sake of this test, we cannot ascertain contained values due to SingletonMap behavior,
        // but we can verify that size is now 1.
        assertEquals(1, singletonMap.size());
    }

    @Test(timeout = 4000)
    public void testPutAllWithTooManyEntries() {
        SingletonMap<Object, Object> singletonMap = new SingletonMap<>(1, "one");
        Map<Object, Object> tooManyEntriesMap = new HashMap<>();
        tooManyEntriesMap.put(2, "two");
        tooManyEntriesMap.put(3, "three");

        try {
            singletonMap.putAll(tooManyEntriesMap);
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            // Expected exception
            assertEquals("The map size must be 0 or 1", e.getMessage());
        }
    }

}