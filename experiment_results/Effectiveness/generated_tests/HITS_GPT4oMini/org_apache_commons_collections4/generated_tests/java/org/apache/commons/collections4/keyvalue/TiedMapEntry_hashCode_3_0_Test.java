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

public class TiedMapEntry_hashCode_3_0_Test {

    private Map<String, String> testMap;

    private TiedMapEntry<String, String> entryWithNonNullKeyValue;

    private TiedMapEntry<String, String> entryWithNullValue;

    private TiedMapEntry<String, String> entryWithNullKey;

    @BeforeEach
    public void setUp() {
        testMap = new HashMap<>();
        testMap.put("key1", "value1");
        testMap.put("key2", "value2");
        entryWithNonNullKeyValue = new TiedMapEntry<>(testMap, "key1");
        entryWithNullValue = new TiedMapEntry<>(testMap, "key2");
        entryWithNullKey = new TiedMapEntry<>(testMap, null);
    }

    @Test
    public void testHashCodeWithNonNullKeyAndValue() {
        int expectedHashCode = "key1".hashCode() ^ "value1".hashCode();
        assertEquals(expectedHashCode, entryWithNonNullKeyValue.hashCode());
    }

    @Test
    public void testHashCodeWithNonNullKeyAndNullValue() {
        int expectedHashCode = "key2".hashCode() ^ 0;
        assertEquals(expectedHashCode, entryWithNullValue.hashCode());
    }

    @Test
    public void testHashCodeWithNullKeyAndNullValue() {
        int expectedHashCode = 0 ^ 0;
        assertEquals(expectedHashCode, entryWithNullKey.hashCode());
    }

    @Test
    public void testHashCodeWithDifferentEntries() {
        TiedMapEntry<String, String> anotherEntry = new TiedMapEntry<>(testMap, "key1");
        assertEquals(entryWithNonNullKeyValue.hashCode(), anotherEntry.hashCode());
        TiedMapEntry<String, String> differentEntry = new TiedMapEntry<>(testMap, "key2");
        assertNotEquals(entryWithNonNullKeyValue.hashCode(), differentEntry.hashCode());
    }

    @Test
    public void testHashCodeWithSameKeyDifferentValue() {
        testMap.put("key1", "value2");
        TiedMapEntry<String, String> entryWithSameKeyDifferentValue = new TiedMapEntry<>(testMap, "key1");
        assertNotEquals(entryWithNonNullKeyValue.hashCode(), entryWithSameKeyDifferentValue.hashCode());
    }
}
