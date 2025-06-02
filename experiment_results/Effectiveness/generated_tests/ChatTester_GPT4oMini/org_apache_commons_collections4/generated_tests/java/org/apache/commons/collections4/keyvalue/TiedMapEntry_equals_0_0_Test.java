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

public class TiedMapEntry_equals_0_0_Test {

    private TiedMapEntry<String, String> entry;

    private Map<String, String> map;

    @BeforeEach
    public void setUp() {
        map = new HashMap<>();
        map.put("key1", "value1");
        entry = new TiedMapEntry<>(map, "key1");
    }

    @Test
    public void testEquals_SameInstance() {
        assertTrue(entry.equals(entry));
    }

    @Test
    public void testEquals_NullObject() {
        assertFalse(entry.equals(null));
    }

    @Test
    public void testEquals_NotMapEntry() {
        assertFalse(entry.equals("Not a Map.Entry"));
    }

    @Test
    public void testEquals_DifferentKeys() {
        Map.Entry<String, String> otherEntry = new HashMap.SimpleEntry<>("key2", "value1");
        assertFalse(entry.equals(otherEntry));
    }

    @Test
    public void testEquals_DifferentValues() {
        Map.Entry<String, String> otherEntry = new HashMap.SimpleEntry<>("key1", "value2");
        assertFalse(entry.equals(otherEntry));
    }

    @Test
    public void testEquals_SameKeyAndValue() {
        Map.Entry<String, String> otherEntry = new HashMap.SimpleEntry<>("key1", "value1");
        assertTrue(entry.equals(otherEntry));
    }

    @Test
    public void testEquals_SameKeyDifferentMap() {
        Map<String, String> anotherMap = new HashMap<>();
        anotherMap.put("key1", "value1");
        TiedMapEntry<String, String> anotherEntry = new TiedMapEntry<>(anotherMap, "key1");
        assertTrue(entry.equals(anotherEntry));
    }

    @Test
    public void testEquals_DifferentKeyType() {
        Map.Entry<Integer, String> otherEntry = new HashMap.SimpleEntry<>(1, "value1");
        assertFalse(entry.equals(otherEntry));
    }
}
