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

public class CompositeMap_entrySet_4_0_Test {

    private CompositeMap<String, String> compositeMap;

    @BeforeEach
    public void setUp() {
        Map<String, String> map1 = new HashMap<>();
        map1.put("key1", "value1");
        map1.put("key2", "value2");
        Map<String, String> map2 = new HashMap<>();
        map2.put("key3", "value3");
        map2.put("key4", "value4");
        compositeMap = new CompositeMap<>(map1, map2);
    }

    @Test
    public void testEntrySetSize() {
        Set<Map.Entry<String, String>> entries = compositeMap.entrySet();
        assertEquals(4, entries.size(), "Entry set size should be 4");
    }

    @Test
    public void testEntrySetContainsAllEntries() {
        Set<Map.Entry<String, String>> entries = compositeMap.entrySet();
        assertTrue(entries.stream().anyMatch(entry -> entry.getKey().equals("key1") && entry.getValue().equals("value1")));
        assertTrue(entries.stream().anyMatch(entry -> entry.getKey().equals("key2") && entry.getValue().equals("value2")));
        assertTrue(entries.stream().anyMatch(entry -> entry.getKey().equals("key3") && entry.getValue().equals("value3")));
        assertTrue(entries.stream().anyMatch(entry -> entry.getKey().equals("key4") && entry.getValue().equals("value4")));
    }

    @Test
    public void testEntrySetOrder() {
        Set<Map.Entry<String, String>> entries = compositeMap.entrySet();
        Object[] entryArray = entries.toArray();
        assertEquals("value4", ((Map.Entry<?, ?>) entryArray[0]).getValue(), "First entry should be from the second map");
        assertEquals("value3", ((Map.Entry<?, ?>) entryArray[1]).getValue(), "Second entry should be from the second map");
        assertEquals("value2", ((Map.Entry<?, ?>) entryArray[2]).getValue(), "Third entry should be from the first map");
        assertEquals("value1", ((Map.Entry<?, ?>) entryArray[3]).getValue(), "Fourth entry should be from the first map");
    }
}
