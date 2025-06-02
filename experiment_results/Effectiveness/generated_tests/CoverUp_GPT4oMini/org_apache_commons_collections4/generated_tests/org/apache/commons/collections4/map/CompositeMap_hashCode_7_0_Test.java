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

public class CompositeMap_hashCode_7_0_Test {

    private CompositeMap<String, String> compositeMap;

    @BeforeEach
    public void setUp() {
        compositeMap = new CompositeMap<>();
    }

    @Test
    public void testHashCodeEmptyCompositeMap() {
        // Test hashCode for an empty CompositeMap
        assertEquals(0, compositeMap.hashCode());
    }

    @Test
    public void testHashCodeSingleMap() {
        // Test hashCode for a CompositeMap with one non-empty map
        Map<String, String> map1 = new HashMap<>();
        map1.put("key1", "value1");
        compositeMap = new CompositeMap<>(map1);
        int expectedHashCode = map1.hashCode();
        assertEquals(expectedHashCode, compositeMap.hashCode());
    }

    @Test
    public void testHashCodeMultipleMaps() {
        // Test hashCode for a CompositeMap with multiple maps
        Map<String, String> map1 = new HashMap<>();
        map1.put("key1", "value1");
        Map<String, String> map2 = new HashMap<>();
        map2.put("key2", "value2");
        compositeMap = new CompositeMap<>(map1, map2);
        int expectedHashCode = map1.hashCode() + map2.hashCode();
        assertEquals(expectedHashCode, compositeMap.hashCode());
    }

    @Test
    public void testHashCodeWithEmptyMap() {
        // Test hashCode for a CompositeMap with an empty map and a non-empty map
        Map<String, String> map1 = new HashMap<>();
        map1.put("key1", "value1");
        Map<String, String> emptyMap = new HashMap<>();
        compositeMap = new CompositeMap<>(map1, emptyMap);
        int expectedHashCode = map1.hashCode() + emptyMap.hashCode();
        assertEquals(expectedHashCode, compositeMap.hashCode());
    }

    @Test
    public void testHashCodeWithNullMutator() {
        // Test hashCode with a null mutator
        Map<String, String> map1 = new HashMap<>();
        map1.put("key1", "value1");
        compositeMap = new CompositeMap<>(map1, null);
        int expectedHashCode = map1.hashCode();
        assertEquals(expectedHashCode, compositeMap.hashCode());
    }
}
