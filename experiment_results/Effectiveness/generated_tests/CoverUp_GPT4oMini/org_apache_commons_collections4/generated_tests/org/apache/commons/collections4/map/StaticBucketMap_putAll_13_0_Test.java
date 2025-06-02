package org.apache.commons.collections4.map;

import org.apache.commons.collections4.map.StaticBucketMap;
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

    private StaticBucketMap<String, String> staticBucketMap;

    @BeforeEach
    public void setUp() {
        staticBucketMap = new StaticBucketMap<>();
    }

    @Test
    public void testPutAllWithEmptyMap() {
        Map<String, String> emptyMap = new HashMap<>();
        staticBucketMap.putAll(emptyMap);
        // No exceptions should be thrown, and nothing should be added
    }

    @Test
    public void testPutAllWithSingleEntry() {
        Map<String, String> singleEntryMap = new HashMap<>();
        singleEntryMap.put("key1", "value1");
        staticBucketMap.putAll(singleEntryMap);
        // Verify that the entry was added
        assertEquals("value1", invokePrivatePut(staticBucketMap, "key1", "value1"));
    }

    @Test
    public void testPutAllWithMultipleEntries() {
        Map<String, String> multipleEntriesMap = new HashMap<>();
        multipleEntriesMap.put("key1", "value1");
        multipleEntriesMap.put("key2", "value2");
        staticBucketMap.putAll(multipleEntriesMap);
        // Verify that both entries were added
        assertEquals("value1", invokePrivatePut(staticBucketMap, "key1", "value1"));
        assertEquals("value2", invokePrivatePut(staticBucketMap, "key2", "value2"));
    }

    @Test
    public void testPutAllWithDuplicateKeys() {
        Map<String, String> duplicateKeysMap = new HashMap<>();
        duplicateKeysMap.put("key1", "value1");
        // This should overwrite the previous value
        duplicateKeysMap.put("key1", "value2");
        staticBucketMap.putAll(duplicateKeysMap);
        // Verify that the last value is retained
        assertEquals("value2", invokePrivatePut(staticBucketMap, "key1", "value2"));
    }

    private String invokePrivatePut(StaticBucketMap<String, String> map, String key, String value) {
        try {
            Method method = StaticBucketMap.class.getDeclaredMethod("put", Object.class, Object.class);
            method.setAccessible(true);
            return (String) method.invoke(map, key, value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
