package org.apache.commons.collections4.map;

import org.apache.commons.collections4.map.CompositeMap;
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

class CompositeMap_equals_5_0_Test {

    private CompositeMap<String, String> compositeMap1;

    private CompositeMap<String, String> compositeMap2;

    private CompositeMap<String, String> compositeMap3;

    private Map<String, String> map1;

    private Map<String, String> map2;

    private Map<String, String> map3;

    @BeforeEach
    void setUp() {
        map1 = new HashMap<>();
        map1.put("key1", "value1");
        map2 = new HashMap<>();
        map2.put("key1", "value1");
        map3 = new HashMap<>();
        map3.put("key2", "value2");
        compositeMap1 = new CompositeMap<>(map1, map2);
        // Same as compositeMap1
        compositeMap2 = new CompositeMap<>(map1, map2);
        // Different maps
        compositeMap3 = new CompositeMap<>(map1, map3);
    }

    @Test
    void testEquals_SameCompositeMaps() {
        assertTrue(compositeMap1.equals(compositeMap2), "CompositeMaps with same entries should be equal");
    }

    @Test
    void testEquals_DifferentCompositeMaps() {
        assertFalse(compositeMap1.equals(compositeMap3), "CompositeMaps with different entries should not be equal");
    }

    @Test
    void testEquals_NonMapObject() {
        assertFalse(compositeMap1.equals("Not a Map"), "CompositeMap should not equal a non-Map object");
    }

    @Test
    void testEquals_Null() {
        assertFalse(compositeMap1.equals(null), "CompositeMap should not equal null");
    }

    @Test
    void testEquals_EmptyCompositeMaps() {
        CompositeMap<String, String> emptyCompositeMap1 = new CompositeMap<>();
        CompositeMap<String, String> emptyCompositeMap2 = new CompositeMap<>();
        assertTrue(emptyCompositeMap1.equals(emptyCompositeMap2), "Two empty CompositeMaps should be equal");
    }

    @Test
    void testEquals_CompositeMapWithDifferentSize() {
        CompositeMap<String, String> compositeMapWithDifferentSize = new CompositeMap<>(map1, map3);
        assertFalse(compositeMap1.equals(compositeMapWithDifferentSize), "CompositeMaps with different sizes should not be equal");
    }
}
