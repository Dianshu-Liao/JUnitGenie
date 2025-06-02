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

class TiedMapEntry_hashCode_3_0_Test {

    private Map<String, String> map;

    private TiedMapEntry<String, String> entry;

    @BeforeEach
    void setUp() {
        map = new HashMap<>();
        entry = new TiedMapEntry<>(map, "key1");
    }

    @Test
    void testHashCode_NullKeyAndValue() {
        // Given
        map.put("key1", null);
        entry = new TiedMapEntry<>(map, null);
        // When
        int hashCode = entry.hashCode();
        // Then
        assertEquals(0, hashCode);
    }

    @Test
    void testHashCode_NullValue() {
        // Given
        map.put("key1", null);
        // When
        int hashCode = entry.hashCode();
        // Then
        assertEquals("key1".hashCode(), hashCode);
    }

    @Test
    void testHashCode_NonNullKeyAndValue() {
        // Given
        map.put("key1", "value1");
        // When
        int hashCode = entry.hashCode();
        // Then
        assertEquals("key1".hashCode() ^ "value1".hashCode(), hashCode);
    }

    @Test
    void testHashCode_NullKey() {
        // Given
        entry = new TiedMapEntry<>(map, null);
        map.put(null, "value1");
        // When
        int hashCode = entry.hashCode();
        // Then
        assertEquals(0 ^ "value1".hashCode(), hashCode);
    }

    @Test
    void testHashCode_EqualKeysAndValues() {
        // Given
        TiedMapEntry<String, String> entry1 = new TiedMapEntry<>(map, "key1");
        TiedMapEntry<String, String> entry2 = new TiedMapEntry<>(map, "key1");
        map.put("key1", "value1");
        // When
        int hashCode1 = entry1.hashCode();
        int hashCode2 = entry2.hashCode();
        // Then
        assertEquals(hashCode1, hashCode2);
    }
}
