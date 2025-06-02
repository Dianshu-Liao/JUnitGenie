package org.apache.commons.collections4.keyvalue;

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

    private Map<String, String> map;

    private TiedMapEntry<String, String> entry1;

    private TiedMapEntry<String, String> entry2;

    private TiedMapEntry<String, String> entry3;

    @BeforeEach
    void setUp() {
        map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        entry1 = new TiedMapEntry<>(map, "key1");
        entry2 = new TiedMapEntry<>(map, "key1");
        entry3 = new TiedMapEntry<>(map, "key2");
    }

    @Test
    void testEquals_SameObject() {
        assertTrue(entry1.equals(entry1), "An object should be equal to itself.");
    }

    @Test
    void testEquals_SameKeyAndValue() {
        assertTrue(entry1.equals(entry2), "Entries with the same key and value should be equal.");
    }

    @Test
    void testEquals_DifferentKey() {
        assertFalse(entry1.equals(entry3), "Entries with different keys should not be equal.");
    }

    @Test
    void testEquals_DifferentValue() {
        map.put("key1", "differentValue");
        assertFalse(entry1.equals(entry2), "Entries with the same key but different values should not be equal.");
    }

    @Test
    void testEquals_NonEntryObject() {
        assertFalse(entry1.equals("Some String"), "An entry should not be equal to a non-entry object.");
    }

    @Test
    void testEquals_NullObject() {
        assertFalse(entry1.equals(null), "An entry should not be equal to null.");
    }

    @Test
    void testEquals_DifferentClass() {
        assertFalse(entry1.equals(new Object()), "An entry should not be equal to an object of a different class.");
    }
}
