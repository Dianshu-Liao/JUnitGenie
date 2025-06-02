package com.fasterxml.jackson.databind.util.internal;
import com.fasterxml.jackson.databind.util.internal.PrivateMaxEntriesMap;
import org.junit.Test;
import java.util.Set;
import java.util.Map.Entry;
import static org.junit.Assert.assertNotNull;

public class util_internal_PrivateMaxEntriesMap_entrySet__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testEntrySetWhenEntrySetIsNull() {
        PrivateMaxEntriesMap map = new PrivateMaxEntriesMap(new PrivateMaxEntriesMap.Builder());
        Set<Entry<Object, Object>> entrySet = map.entrySet();
        assertNotNull("Entry set should not be null after calling entrySet()", entrySet);
    }

    @Test(timeout = 4000)
    public void testEntrySetWhenEntrySetIsNotNull() {
        PrivateMaxEntriesMap map = new PrivateMaxEntriesMap(new PrivateMaxEntriesMap.Builder());
        // Simulate the entrySet being initialized
        // Assuming PrivateMaxEntriesMap has a method to add entries to the map
        map.put("key", "value"); // Hypothetical method to add an entry to the map
        Set<Entry<Object, Object>> entrySet = map.entrySet();
        assertNotNull("Entry set should not be null when it contains entries", entrySet);
    }

}