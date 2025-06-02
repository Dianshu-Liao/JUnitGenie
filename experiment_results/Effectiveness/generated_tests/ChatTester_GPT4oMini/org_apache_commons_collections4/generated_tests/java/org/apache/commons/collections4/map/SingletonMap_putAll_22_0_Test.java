package org.apache.commons.collections4.map;

import java.util.HashMap;
import java.util.Map;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.collections4.BoundedMap;
import org.apache.commons.collections4.KeyValue;
import org.apache.commons.collections4.OrderedMap;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.ResettableIterator;
import org.apache.commons.collections4.iterators.SingletonIterator;
import org.apache.commons.collections4.keyvalue.TiedMapEntry;

public class SingletonMap_putAll_22_0_Test {

    private SingletonMap<String, String> singletonMap;

    @BeforeEach
    public void setUp() {
        singletonMap = new SingletonMap<>();
    }

    @Test
    public void testPutAll_EmptyMap() {
        Map<String, String> emptyMap = new HashMap<>();
        singletonMap.putAll(emptyMap);
        // No exception should be thrown, and state should remain unchanged
        Assertions.assertNull(singletonMap.getKey());
        Assertions.assertNull(singletonMap.getValue());
    }

    @Test
    public void testPutAll_SingleEntryMap() {
        Map<String, String> singleEntryMap = new HashMap<>();
        singleEntryMap.put("key1", "value1");
        // Invoke putAll which should internally call put
        singletonMap.putAll(singleEntryMap);
        // Verify that the entry has been added correctly
        Assertions.assertEquals("value1", singletonMap.getValue());
        Assertions.assertEquals("key1", singletonMap.getKey());
    }

    @Test
    public void testPutAll_MultipleEntriesMap() {
        Map<String, String> multipleEntryMap = new HashMap<>();
        multipleEntryMap.put("key1", "value1");
        multipleEntryMap.put("key2", "value2");
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            singletonMap.putAll(multipleEntryMap);
        });
        Assertions.assertEquals("The map size must be 0 or 1", thrown.getMessage());
    }
}
