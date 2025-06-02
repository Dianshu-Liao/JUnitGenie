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

public class StaticBucketMap_putAll_13_0_Test {

    private StaticBucketMap<String, String> staticBucketMap;

    @BeforeEach
    public void setUp() {
        staticBucketMap = new StaticBucketMap<>();
    }

    @Test
    public void testPutAll_EmptyMap() {
        Map<String, String> map = new HashMap<>();
        staticBucketMap.putAll(map);
        // Verify that the map is still empty
        // should return null as it is a new entry
        assertNull(staticBucketMap.put("key1", "value1"));
    }

    @Test
    public void testPutAll_SingleEntry() {
        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        staticBucketMap.putAll(map);
        // Verify that the entry has been added
        // should return null as it is a new entry
        assertEquals("value1", staticBucketMap.put("key1", "value1"));
    }

    @Test
    public void testPutAll_MultipleEntries() {
        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        staticBucketMap.putAll(map);
        // Verify that the entries have been added
        // should return null as it is a new entry
        assertEquals("value1", staticBucketMap.put("key1", "value1"));
        // should return null as it is a new entry
        assertEquals("value2", staticBucketMap.put("key2", "value2"));
    }

    @Test
    public void testPutAll_OverwritingExistingEntries() {
        staticBucketMap.put("key1", "value1");
        Map<String, String> map = new HashMap<>();
        map.put("key1", "newValue1");
        staticBucketMap.putAll(map);
        // Verify that the existing entry has been updated
        // should return the old value
        assertEquals("value1", staticBucketMap.put("key1", "newValue1"));
        // should return null as it is the same value
        assertEquals("newValue1", staticBucketMap.put("key1", "newValue1"));
    }

    @Test
    public void testPutAll_NullMap() {
        staticBucketMap.putAll(null);
        // Verify that the map is still empty
        // should return null as it is a new entry
        assertNull(staticBucketMap.put("key1", "value1"));
    }
}
