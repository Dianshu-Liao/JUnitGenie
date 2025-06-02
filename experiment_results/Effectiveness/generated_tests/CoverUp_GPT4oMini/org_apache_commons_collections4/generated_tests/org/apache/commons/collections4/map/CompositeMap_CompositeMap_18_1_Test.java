package org.apache.commons.collections4.map;

import java.util.HashMap;
import java.util.Map;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.collection.CompositeCollection;
import org.apache.commons.collections4.set.CompositeSet;

public class CompositeMap_CompositeMap_18_1_Test {

    private CompositeMap<String, Integer> compositeMap;

    @BeforeEach
    public void setUp() {
        compositeMap = new CompositeMap<>();
    }

    @Test
    public void testCompositeMapWithEmptyArray() {
        CompositeMap<String, Integer> emptyMap = new CompositeMap<>(new Map[] {});
        assertNotNull(emptyMap);
        assertEquals(0, emptyMap.size());
    }

    @Test
    public void testCompositeMapWithSingleMap() {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("key1", 1);
        CompositeMap<String, Integer> singleMap = new CompositeMap<>(map1);
        assertNotNull(singleMap);
        assertEquals(1, singleMap.size());
        assertTrue(singleMap.containsKey("key1"));
        assertEquals(1, singleMap.get("key1"));
    }

    @Test
    public void testCompositeMapWithMultipleMaps() {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("key1", 1);
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("key2", 2);
        CompositeMap<String, Integer> multipleMaps = new CompositeMap<>(map1, map2);
        assertNotNull(multipleMaps);
        assertEquals(2, multipleMaps.size());
        assertTrue(multipleMaps.containsKey("key1"));
        assertTrue(multipleMaps.containsKey("key2"));
        assertEquals(1, multipleMaps.get("key1"));
        assertEquals(2, multipleMaps.get("key2"));
    }

    @Test
    public void testCompositeMapWithNullMap() {
        CompositeMap<String, Integer> nullMap = new CompositeMap<>(null);
        assertNotNull(nullMap);
        assertEquals(0, nullMap.size());
    }

    @Test
    public void testCompositeMapWithCollisions() {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("key1", 1);
        Map<String, Integer> map2 = new HashMap<>();
        // Collision on key1
        map2.put("key1", 2);
        compositeMap = new CompositeMap<>(map1, map2);
        assertEquals(1, compositeMap.size());
        // Should get value from map2
        assertEquals(2, compositeMap.get("key1"));
    }
}
