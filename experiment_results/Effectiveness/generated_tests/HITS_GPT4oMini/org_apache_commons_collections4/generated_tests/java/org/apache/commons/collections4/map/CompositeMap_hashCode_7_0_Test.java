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

public class CompositeMap_hashCode_7_0_Test {

    private CompositeMap<String, Integer> compositeMap1;

    private CompositeMap<String, Integer> compositeMap2;

    private CompositeMap<String, Integer> compositeMap3;

    @BeforeEach
    public void setUp() {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("key1", 1);
        map1.put("key2", 2);
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("key3", 3);
        map2.put("key4", 4);
        Map<String, Integer> map3 = new HashMap<>();
        map3.put("key1", 1);
        map3.put("key2", 2);
        map3.put("key3", 3);
        compositeMap1 = new CompositeMap<>(map1, map2);
        compositeMap2 = new CompositeMap<>(map1, map2);
        compositeMap3 = new CompositeMap<>(map3);
    }

    @Test
    public void testHashCodeEquality() {
        // Test that two composite maps with the same entries have the same hash code
        assertEquals(compositeMap1.hashCode(), compositeMap2.hashCode());
    }

    @Test
    public void testHashCodeInequality() {
        // Test that composite maps with different entries have different hash codes
        assertNotEquals(compositeMap1.hashCode(), compositeMap3.hashCode());
    }

    @Test
    public void testHashCodeWithEmptyCompositeMap() {
        CompositeMap<String, Integer> emptyCompositeMap = new CompositeMap<>();
        assertEquals(0, emptyCompositeMap.hashCode());
    }

    @Test
    public void testHashCodeWithSingleMap() {
        Map<String, Integer> singleMap = new HashMap<>();
        singleMap.put("keyA", 10);
        CompositeMap<String, Integer> singleCompositeMap = new CompositeMap<>(singleMap);
        assertNotEquals(0, singleCompositeMap.hashCode());
    }
}
