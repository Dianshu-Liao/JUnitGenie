package org.apache.commons.collections4.map;

import java.lang.reflect.Method;
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

public class StaticBucketMap_putAll_13_0_Test {

    private StaticBucketMap<String, Integer> staticBucketMap;

    @BeforeEach
    public void setUp() {
        // Initialize with 10 buckets
        staticBucketMap = new StaticBucketMap<>(10);
    }

    @Test
    public void testPutAllWithEmptyMap() {
        Map<String, Integer> emptyMap = new HashMap<>();
        staticBucketMap.putAll(emptyMap);
        // Verify that the map is still empty after putAll
        assertEquals(0, getSize(staticBucketMap));
    }

    @Test
    public void testPutAllWithNonEmptyMap() {
        Map<String, Integer> mapToAdd = new HashMap<>();
        mapToAdd.put("one", 1);
        mapToAdd.put("two", 2);
        staticBucketMap.putAll(mapToAdd);
        // Verify that the entries were added
        assertEquals(2, getSize(staticBucketMap));
        assertEquals(1, getValue(staticBucketMap, "one"));
        assertEquals(2, getValue(staticBucketMap, "two"));
    }

    @Test
    public void testPutAllWithDuplicateKeys() {
        Map<String, Integer> mapToAdd = new HashMap<>();
        mapToAdd.put("one", 1);
        // Duplicate key with new value
        mapToAdd.put("one", 2);
        staticBucketMap.putAll(mapToAdd);
        // Verify that the value for the key "one" has been updated
        assertEquals(1, getSize(staticBucketMap));
        assertEquals(2, getValue(staticBucketMap, "one"));
    }

    @Test
    public void testPutAllWithNullKey() {
        Map<String, Integer> mapToAdd = new HashMap<>();
        // Adding null key
        mapToAdd.put(null, 1);
        staticBucketMap.putAll(mapToAdd);
        // Verify that the null key has been added
        assertEquals(1, getSize(staticBucketMap));
        assertEquals(1, getValue(staticBucketMap, null));
    }

    @Test
    public void testPutAllWithNullValue() {
        Map<String, Integer> mapToAdd = new HashMap<>();
        // Adding null value
        mapToAdd.put("one", null);
        staticBucketMap.putAll(mapToAdd);
        // Verify that the null value has been added
        assertEquals(1, getSize(staticBucketMap));
        assertNull(getValue(staticBucketMap, "one"));
    }

    // Reflection method to get the size of the StaticBucketMap
    private int getSize(StaticBucketMap<String, Integer> map) {
        try {
            Method sizeMethod = StaticBucketMap.class.getDeclaredMethod("size");
            sizeMethod.setAccessible(true);
            return (int) sizeMethod.invoke(map);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Reflection method to get the value from the StaticBucketMap
    private Integer getValue(StaticBucketMap<String, Integer> map, String key) {
        try {
            Method getMethod = StaticBucketMap.class.getDeclaredMethod("get", Object.class);
            getMethod.setAccessible(true);
            return (Integer) getMethod.invoke(map, key);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
