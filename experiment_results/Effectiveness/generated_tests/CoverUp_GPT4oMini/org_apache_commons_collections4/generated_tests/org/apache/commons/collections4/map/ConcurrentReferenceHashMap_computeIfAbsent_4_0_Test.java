package org.apache.commons.collections4.map;

import org.apache.commons.collections4.map.ConcurrentReferenceHashMap;
import java.util.function.Function;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import /*
 * Written by Doug Lea with assistance from members of JCP JSR-166
 * Expert Group and released to the public domain, as explained at
 * http://creativecommons.org/licenses/publicdomain
 */
java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.EnumSet;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.BiFunction;
import java.util.function.Supplier;

class ConcurrentReferenceHashMap_computeIfAbsent_4_0_Test {

    private ConcurrentReferenceHashMap<String, Integer> map;

    @BeforeEach
    void setUp() throws Exception {
        Constructor<ConcurrentReferenceHashMap> constructor = ConcurrentReferenceHashMap.class.getDeclaredConstructor(int.class, float.class, int.class, ConcurrentReferenceHashMap.ReferenceType.class, ConcurrentReferenceHashMap.ReferenceType.class, EnumSet.class);
        constructor.setAccessible(true);
        map = constructor.newInstance(16, 0.75f, 16, ConcurrentReferenceHashMap.DEFAULT_KEY_TYPE, ConcurrentReferenceHashMap.DEFAULT_VALUE_TYPE, ConcurrentReferenceHashMap.DEFAULT_OPTIONS);
    }

    @Test
    void testComputeIfAbsentWhenKeyIsAbsent() {
        String key = "testKey";
        Function<String, Integer> mappingFunction = k -> 42;
        Integer result = map.computeIfAbsent(key, mappingFunction);
        assertEquals(42, result);
        // Ensure it does not call mapping function again
        assertEquals(42, map.computeIfAbsent(key, mappingFunction));
    }

    @Test
    void testComputeIfAbsentWhenKeyIsPresent() {
        String key = "existingKey";
        // First call to add the key
        map.computeIfAbsent(key, k -> 42);
        Function<String, Integer> mappingFunction = k -> 100;
        Integer result = map.computeIfAbsent(key, mappingFunction);
        // Should return the existing value
        assertEquals(42, result);
    }

    @Test
    void testComputeIfAbsentWithNullKey() {
        Function<String, Integer> mappingFunction = k -> 42;
        assertThrows(NullPointerException.class, () -> {
            map.computeIfAbsent(null, mappingFunction);
        });
    }

    @Test
    void testComputeIfAbsentWithNullMappingFunction() {
        String key = "testKey";
        assertThrows(NullPointerException.class, () -> {
            map.computeIfAbsent(key, null);
        });
    }
}
