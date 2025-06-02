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

public class CompositeMap_CompositeMap_18_0_Test {

    private CompositeMap<String, Integer> compositeMap;

    @BeforeEach
    public void setUp() {
        compositeMap = new CompositeMap<>();
    }

    @Test
    public void testCompositeMapWithEmptyArray() {
        CompositeMap<String, Integer> emptyCompositeMap = new CompositeMap<>(new HashMap[] {});
        assertNotNull(emptyCompositeMap);
    }

    @Test
    public void testCompositeMapWithSingleMap() {
        Map<String, Integer> singleMap = new HashMap<>();
        singleMap.put("one", 1);
        CompositeMap<String, Integer> singleCompositeMap = new CompositeMap<>(singleMap);
        assertNotNull(singleCompositeMap);
    }

    @Test
    public void testCompositeMapWithMultipleMaps() {
        Map<String, Integer> firstMap = new HashMap<>();
        firstMap.put("one", 1);
        Map<String, Integer> secondMap = new HashMap<>();
        secondMap.put("two", 2);
        CompositeMap<String, Integer> compositeMap = new CompositeMap<>(firstMap, secondMap);
        assertNotNull(compositeMap);
    }

    @Test
    public void testCompositeMapWithNull() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            new CompositeMap<>((Map<String, Integer>[]) null);
        });
        assertNotNull(exception);
    }

    @Test
    public void testCompositeMapWithArrayOfMaps() {
        Map<String, Integer> firstMap = new HashMap<>();
        firstMap.put("one", 1);
        Map<String, Integer> secondMap = new HashMap<>();
        secondMap.put("two", 2);
        Map<String, Integer> thirdMap = new HashMap<>();
        thirdMap.put("three", 3);
        CompositeMap<String, Integer> compositeMap = new CompositeMap<>(new Map[] { firstMap, secondMap, thirdMap });
        assertNotNull(compositeMap);
        assertEquals(3, compositeMap.size());
        assertTrue(compositeMap.containsKey("one"));
        assertTrue(compositeMap.containsKey("two"));
        assertTrue(compositeMap.containsKey("three"));
        assertEquals(1, compositeMap.get("one"));
        assertEquals(2, compositeMap.get("two"));
        assertEquals(3, compositeMap.get("three"));
    }
}
