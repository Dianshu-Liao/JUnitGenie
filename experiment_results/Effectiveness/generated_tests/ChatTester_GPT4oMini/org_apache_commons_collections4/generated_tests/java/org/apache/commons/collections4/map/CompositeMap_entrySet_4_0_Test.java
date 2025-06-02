package org.apache.commons.collections4.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
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
import org.apache.commons.collections4.set.CompositeSet;

class CompositeMap_entrySet_4_0_Test {

    private CompositeMap<String, String> compositeMap;

    private Map<String, String> map1;

    private Map<String, String> map2;

    @BeforeEach
    void setUp() {
        map1 = new HashMap<>();
        map1.put("key1", "value1");
        map1.put("key2", "value2");
        map2 = new HashMap<>();
        map2.put("key3", "value3");
        map2.put("key4", "value4");
        compositeMap = new CompositeMap<>(map1, map2);
    }

    @Test
    void testEntrySet() {
        Set<Map.Entry<String, String>> entries = compositeMap.entrySet();
        assertNotNull(entries);
        assertEquals(4, entries.size());
        // Check if all entries from both maps are present
        assertEquals(1, entries.stream().filter(entry -> entry.getKey().equals("key1") && entry.getValue().equals("value1")).count());
        assertEquals(1, entries.stream().filter(entry -> entry.getKey().equals("key2") && entry.getValue().equals("value2")).count());
        assertEquals(1, entries.stream().filter(entry -> entry.getKey().equals("key3") && entry.getValue().equals("value3")).count());
        assertEquals(1, entries.stream().filter(entry -> entry.getKey().equals("key4") && entry.getValue().equals("value4")).count());
    }

    @Test
    void testEntrySetWithEmptyComposite() {
        CompositeMap<String, String> emptyCompositeMap = new CompositeMap<>(new HashMap<>(), new HashMap<>());
        Set<Map.Entry<String, String>> entries = emptyCompositeMap.entrySet();
        assertNotNull(entries);
        assertEquals(0, entries.size());
    }

    @Test
    void testEntrySetWithNullComposite() {
        compositeMap = new CompositeMap<>(new HashMap<>(), new HashMap<>());
        Set<Map.Entry<String, String>> entries = compositeMap.entrySet();
        assertNotNull(entries);
        assertEquals(0, entries.size());
    }
}
