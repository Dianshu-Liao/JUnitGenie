package org.apache.commons.collections4.map;

import org.apache.commons.collections4.map.AbstractReferenceMap;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.keyvalue.DefaultMapEntry;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class AbstractReferenceMap_entrySet_9_0_Test {

    private AbstractReferenceMap<String, String> referenceMap;

    @BeforeEach
    void setUp() {
        referenceMap = new AbstractReferenceMap<String, String>() {

            @Override
            protected HashEntry<String, String> getEntry(Object key) {
                return super.getEntry(key);
            }

            @Override
            protected void init() {
                super.init();
            }
        };
    }

    @Test
    void testEntrySetWhenNull() {
        Set<Map.Entry<String, String>> entrySet = referenceMap.entrySet();
        assertNotNull(entrySet, "Entry set should not be null");
        assertTrue(entrySet.isEmpty(), "Entry set should be empty initially");
    }

    @Test
    void testEntrySetAfterPut() {
        referenceMap.put("key1", "value1");
        Set<Map.Entry<String, String>> entrySet = referenceMap.entrySet();
        assertEquals(1, entrySet.size(), "Entry set size should be 1 after putting an entry");
    }

    @Test
    void testEntrySetAfterClear() {
        referenceMap.put("key1", "value1");
        referenceMap.clear();
        Set<Map.Entry<String, String>> entrySet = referenceMap.entrySet();
        assertTrue(entrySet.isEmpty(), "Entry set should be empty after clear");
    }

    @Test
    void testEntrySetConcurrentModification() {
        referenceMap.put("key1", "value1");
        referenceMap.put("key2", "value2");
        Set<Map.Entry<String, String>> entrySet = referenceMap.entrySet();
        // Simulate concurrent modification
        referenceMap.put("key3", "value3");
        assertThrows(ConcurrentModificationException.class, () -> {
            Iterator<Map.Entry<String, String>> iterator = entrySet.iterator();
            // Triggering the concurrent modification exception
            iterator.next();
        });
    }

    @Test
    void testEntrySetReturnsSameInstance() {
        Set<Map.Entry<String, String>> firstEntrySet = referenceMap.entrySet();
        Set<Map.Entry<String, String>> secondEntrySet = referenceMap.entrySet();
        assertSame(firstEntrySet, secondEntrySet, "Entry set should return the same instance on multiple calls");
    }

    // Reflection test for private method if needed
    @Test
    void testPrivateMethodUsingReflection() throws Exception {
        Method method = AbstractReferenceMap.class.getDeclaredMethod("init");
        method.setAccessible(true);
        method.invoke(referenceMap);
        // Add assertions based on what the private method is supposed to do
    }
}
