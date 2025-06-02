package org.apache.commons.collections4.map;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.collection.CompositeCollection;
import org.apache.commons.collections4.set.CompositeSet;

@ExtendWith(MockitoExtension.class)
class CompositeMap_CompositeMap_19_2_Test {

    private CompositeMap<String, Integer> compositeMap;

    private Map<String, Integer> map1;

    private Map<String, Integer> map2;

    @BeforeEach
    void setUp() {
        map1 = new HashMap<>();
        map2 = new HashMap<>();
    }

    @Test
    void testCompositeMapWithTwoMaps() {
        // Setup
        map1.put("key1", 1);
        map1.put("key2", 2);
        map2.put("key3", 3);
        map2.put("key4", 4);
        // Execute
        compositeMap = createCompositeMap(map1, map2);
        // Verify
        assertEquals(4, compositeMap.size());
        assertTrue(compositeMap.containsKey("key1"));
        assertTrue(compositeMap.containsKey("key2"));
        assertTrue(compositeMap.containsKey("key3"));
        assertTrue(compositeMap.containsKey("key4"));
        assertEquals(1, compositeMap.get("key1"));
        assertEquals(2, compositeMap.get("key2"));
        assertEquals(3, compositeMap.get("key3"));
        assertEquals(4, compositeMap.get("key4"));
    }

    @Test
    void testCompositeMapWithEmptyMaps() {
        // Execute
        compositeMap = createCompositeMap(new HashMap<>(), new HashMap<>());
        // Verify
        assertTrue(compositeMap.isEmpty());
        assertEquals(0, compositeMap.size());
    }

    @Test
    void testCompositeMapWithNullMaps() {
        // Execute
        compositeMap = createCompositeMap(null, null);
        // Verify
        assertNotNull(compositeMap);
        assertEquals(0, compositeMap.size());
    }

    @Test
    void testCompositeMapWithKeyCollision() {
        // Setup
        map1.put("key1", 1);
        // Same key, different value
        map2.put("key1", 2);
        // Execute
        compositeMap = createCompositeMap(map1, map2);
        // Verify
        assertEquals(1, compositeMap.size());
        // Should take the value from map2
        assertEquals(2, compositeMap.get("key1"));
    }

    @Test
    void testCompositeMapWithSameMaps() {
        // Setup
        map1.put("key1", 1);
        map1.put("key2", 2);
        // Execute
        // Same map twice
        compositeMap = createCompositeMap(map1, map1);
        // Verify
        assertEquals(2, compositeMap.size());
        assertEquals(1, compositeMap.get("key1"));
        assertEquals(2, compositeMap.get("key2"));
    }

    @SuppressWarnings("unchecked")
    private CompositeMap<String, Integer> createCompositeMap(Map<String, Integer> one, Map<String, Integer> two) {
        try {
            return (CompositeMap<String, Integer>) CompositeMap.class.getDeclaredConstructor(Map.class, Map.class).newInstance(one, two);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
