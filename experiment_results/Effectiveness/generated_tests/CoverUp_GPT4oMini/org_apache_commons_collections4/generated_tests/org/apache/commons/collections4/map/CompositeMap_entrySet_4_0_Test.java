package org.apache.commons.collections4.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.map.CompositeMap;
import org.apache.commons.collections4.set.CompositeSet;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.collection.CompositeCollection;

class CompositeMap_entrySet_4_0_Test {

    private CompositeMap<String, String> compositeMap;

    @BeforeEach
    void setUp() {
        Map<String, String> map1 = new HashMap<>();
        map1.put("key1", "value1");
        Map<String, String> map2 = new HashMap<>();
        map2.put("key2", "value2");
        compositeMap = new CompositeMap<>(map1, map2);
    }

    @Test
    void testEntrySet() {
        Set<Map.Entry<String, String>> entries = compositeMap.entrySet();
        assertNotNull(entries);
        assertEquals(2, entries.size());
        // Verify the entries contain the expected key-value pairs
        assertTrue(entries.stream().anyMatch(entry -> entry.getKey().equals("key1") && entry.getValue().equals("value1")));
        assertTrue(entries.stream().anyMatch(entry -> entry.getKey().equals("key2") && entry.getValue().equals("value2")));
    }

    @Test
    void testEntrySetWithEmptyComposite() {
        CompositeMap<String, String> emptyCompositeMap = new CompositeMap<>();
        Set<Map.Entry<String, String>> entries = emptyCompositeMap.entrySet();
        assertNotNull(entries);
        assertTrue(entries.isEmpty());
    }

    @Test
    void testEntrySetWithNullValues() {
        Map<String, String> mapWithNull = new HashMap<>();
        mapWithNull.put("key1", null);
        compositeMap = new CompositeMap<>(mapWithNull);
        Set<Map.Entry<String, String>> entries = compositeMap.entrySet();
        assertNotNull(entries);
        assertEquals(1, entries.size());
        assertTrue(entries.stream().anyMatch(entry -> entry.getKey().equals("key1") && entry.getValue() == null));
    }
}
