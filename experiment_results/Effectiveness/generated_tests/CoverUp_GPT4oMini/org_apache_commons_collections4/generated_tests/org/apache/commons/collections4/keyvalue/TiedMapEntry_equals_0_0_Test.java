package org.apache.commons.collections4.keyvalue;

import org.apache.commons.collections4.keyvalue.TiedMapEntry;
import java.util.HashMap;
import java.util.Map;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.util.Objects;
import org.apache.commons.collections4.KeyValue;

class TiedMapEntry_equals_0_0_Test {

    private Map<String, Integer> map;

    private TiedMapEntry entry1;

    private TiedMapEntry entry2;

    private TiedMapEntry entry3;

    @BeforeEach
    void setUp() {
        map = new HashMap<>();
        map.put("key1", 1);
        map.put("key2", 2);
        entry1 = new TiedMapEntry(map, "key1");
        // Same key and map as entry1
        entry2 = new TiedMapEntry(map, "key1");
        // Different key
        entry3 = new TiedMapEntry(map, "key2");
    }

    @Test
    void testEquals_SameObject() {
        assertTrue(entry1.equals(entry1));
    }

    @Test
    void testEquals_NullObject() {
        assertFalse(entry1.equals(null));
    }

    @Test
    void testEquals_DifferentType() {
        assertFalse(entry1.equals("Not a Map.Entry"));
    }

    @Test
    void testEquals_SameKeyAndValue() {
        assertTrue(entry1.equals(entry2));
    }

    @Test
    void testEquals_DifferentKey() {
        assertFalse(entry1.equals(entry3));
    }

    @Test
    void testEquals_DifferentValue() {
        // Change value for key1
        map.put("key1", 3);
        // Now entry1 and entry2 have different values
        assertFalse(entry1.equals(entry2));
    }

    @Test
    void testEquals_EntryWithDifferentMap() {
        Map<String, Integer> anotherMap = new HashMap<>();
        anotherMap.put("key1", 1);
        TiedMapEntry entry4 = new TiedMapEntry(anotherMap, "key1");
        // Same key but different map
        assertFalse(entry1.equals(entry4));
    }
}
