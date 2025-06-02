package org.apache.commons.collections4.map;

import java.lang.reflect.Method;
import java.util.HashMap;
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

class AbstractReferenceMap_entrySet_9_3_Test {

    private AbstractReferenceMap<Object, Object> referenceMap;

    @BeforeEach
    void setUp() {
        referenceMap = new AbstractReferenceMap<Object, Object>() {

            @Override
            public Object put(final Object key, final Object value) {
                return super.put(key, value);
            }

            @Override
            public Object get(final Object key) {
                return super.get(key);
            }
        };
    }

    @Test
    void testEntrySet() throws Exception {
        referenceMap.put("key1", "value1");
        referenceMap.put("key2", "value2");
        Method entrySetMethod = AbstractReferenceMap.class.getDeclaredMethod("entrySet");
        entrySetMethod.setAccessible(true);
        Set<Map.Entry<Object, Object>> entries = (Set<Map.Entry<Object, Object>>) entrySetMethod.invoke(referenceMap);
        assertNotNull(entries, "The entrySet should not be null after first invocation.");
        assertTrue(entries.size() > 0, "The entrySet should contain entries.");
        assertTrue(entries.stream().anyMatch(entry -> "key1".equals(entry.getKey()) && "value1".equals(entry.getValue())), "The entrySet should contain the entry for key1.");
        assertTrue(entries.stream().anyMatch(entry -> "key2".equals(entry.getKey()) && "value2".equals(entry.getValue())), "The entrySet should contain the entry for key2.");
    }

    @Test
    void testEntrySetCaching() throws Exception {
        Method entrySetMethod = AbstractReferenceMap.class.getDeclaredMethod("entrySet");
        entrySetMethod.setAccessible(true);
        Set<Map.Entry<Object, Object>> firstCall = (Set<Map.Entry<Object, Object>>) entrySetMethod.invoke(referenceMap);
        Set<Map.Entry<Object, Object>> secondCall = (Set<Map.Entry<Object, Object>>) entrySetMethod.invoke(referenceMap);
        assertNotNull(firstCall, "The entrySet should not be null on first call.");
        assertNotNull(secondCall, "The entrySet should not be null on second call.");
        assertTrue(firstCall == secondCall, "The entrySet should return the same instance on subsequent calls.");
    }
}
