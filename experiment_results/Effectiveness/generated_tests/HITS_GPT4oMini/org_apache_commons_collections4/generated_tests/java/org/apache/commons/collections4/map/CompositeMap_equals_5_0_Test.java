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

public class CompositeMap_equals_5_0_Test {

    @Test
    public void testEquals_SameInstance() {
        CompositeMap map = new CompositeMap();
        assertTrue(map.equals(map), "A CompositeMap should equal itself.");
    }

    @Test
    public void testEquals_Null() {
        CompositeMap map = new CompositeMap();
        assertFalse(map.equals(null), "A CompositeMap should not equal null.");
    }

    @Test
    public void testEquals_NotAMap() {
        CompositeMap map = new CompositeMap();
        assertFalse(map.equals("Not a Map"), "A CompositeMap should not equal a non-Map object.");
    }

    @Test
    public void testEquals_EmptyMaps() {
        CompositeMap map1 = new CompositeMap();
        CompositeMap map2 = new CompositeMap();
        assertTrue(map1.equals(map2), "Two empty CompositeMaps should be equal.");
    }

    @Test
    public void testEquals_EqualMaps() {
        Map<String, String> map1 = new HashMap<>();
        map1.put("key1", "value1");
        CompositeMap compositeMap1 = new CompositeMap(map1);
        Map<String, String> map2 = new HashMap<>();
        map2.put("key1", "value1");
        CompositeMap compositeMap2 = new CompositeMap(map2);
        assertTrue(compositeMap1.equals(compositeMap2), "CompositeMaps with equal underlying maps should be equal.");
    }

    @Test
    public void testEquals_NonEqualMaps() {
        Map<String, String> map1 = new HashMap<>();
        map1.put("key1", "value1");
        CompositeMap compositeMap1 = new CompositeMap(map1);
        Map<String, String> map2 = new HashMap<>();
        map2.put("key1", "value2");
        CompositeMap compositeMap2 = new CompositeMap(map2);
        assertFalse(compositeMap1.equals(compositeMap2), "CompositeMaps with non-equal underlying maps should not be equal.");
    }

    @Test
    public void testEquals_CompositeMapsWithDifferentEntries() {
        Map<String, String> map1 = new HashMap<>();
        map1.put("key1", "value1");
        CompositeMap compositeMap1 = new CompositeMap(map1);
        Map<String, String> map2 = new HashMap<>();
        map2.put("key2", "value2");
        CompositeMap compositeMap2 = new CompositeMap(map2);
        assertFalse(compositeMap1.equals(compositeMap2), "CompositeMaps with different entries should not be equal.");
    }

    @Test
    public void testEquals_CompositeMapWithMultipleMaps() {
        Map<String, String> map1 = new HashMap<>();
        map1.put("key1", "value1");
        Map<String, String> map2 = new HashMap<>();
        map2.put("key2", "value2");
        CompositeMap compositeMap1 = new CompositeMap(map1, map2);
        Map<String, String> map3 = new HashMap<>();
        map3.put("key1", "value1");
        Map<String, String> map4 = new HashMap<>();
        map4.put("key2", "value2");
        CompositeMap compositeMap2 = new CompositeMap(map3, map4);
        assertTrue(compositeMap1.equals(compositeMap2), "CompositeMaps with the same entries should be equal.");
    }
}
