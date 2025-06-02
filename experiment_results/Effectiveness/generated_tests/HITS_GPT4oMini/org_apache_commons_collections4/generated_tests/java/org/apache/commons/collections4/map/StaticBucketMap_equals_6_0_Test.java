package org.apache.commons.collections4.map;

import java.util.HashMap;
import java.util.Map;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.collections4.KeyValue;

public class StaticBucketMap_equals_6_0_Test {

    @Test
    public void testEquals_SameInstance() {
        StaticBucketMap map = new StaticBucketMap();
        assertTrue(map.equals(map), "A map should equal itself.");
    }

    @Test
    public void testEquals_NullObject() {
        StaticBucketMap map = new StaticBucketMap();
        assertFalse(map.equals(null), "A map should not equal null.");
    }

    @Test
    public void testEquals_DifferentType() {
        StaticBucketMap map = new StaticBucketMap();
        assertFalse(map.equals("Not a map"), "A map should not equal an object of a different type.");
    }

    @Test
    public void testEquals_EqualMaps() {
        StaticBucketMap map1 = new StaticBucketMap();
        StaticBucketMap map2 = new StaticBucketMap();
        assertTrue(map1.equals(map2), "Two empty maps should be equal.");
    }

    @Test
    public void testEquals_NonEqualMaps() {
        StaticBucketMap map1 = new StaticBucketMap();
        StaticBucketMap map2 = new StaticBucketMap();
        // Simulating adding entries to map1
        // Here we assume there is a method to add entries to the map
        // Since we don't have that, we will simulate it
        // Assuming a put method exists
        map1.put("key1", "value1");
        assertFalse(map1.equals(map2), "Maps with different entries should not be equal.");
    }

    @Test
    public void testEquals_EqualMapsWithSameEntries() {
        StaticBucketMap map1 = new StaticBucketMap();
        StaticBucketMap map2 = new StaticBucketMap();
        // Simulating adding same entries to both maps
        // Assuming a put method exists
        map1.put("key1", "value1");
        // Assuming a put method exists
        map2.put("key1", "value1");
        assertTrue(map1.equals(map2), "Maps with the same entries should be equal.");
    }
}
