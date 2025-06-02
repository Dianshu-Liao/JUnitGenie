package org.apache.commons.collections4.map;

import java.util.function.Function;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
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

@ExtendWith(MockitoExtension.class)
public class ConcurrentReferenceHashMap_computeIfAbsent_4_0_Test {

    private ConcurrentReferenceHashMap<String, Integer> map;

    @BeforeEach
    public void setUp() {
        // Create a mock of ConcurrentReferenceHashMap
        map = mock(ConcurrentReferenceHashMap.class);
    }

    @Test
    public void testComputeIfAbsent_NewKey() {
        // Define a mapping function
        Function<String, Integer> mappingFunction = key -> key.length();
        // Set up the mock to return null for the new key
        when(map.computeIfAbsent("test", mappingFunction)).thenReturn(4);
        // Compute if absent for a new key
        Integer result = map.computeIfAbsent("test", mappingFunction);
        // Verify that the result is as expected
        assertEquals(4, result);
        // Verify that the value is now present in the map
        assertEquals(4, map.computeIfAbsent("test", mappingFunction));
    }

    @Test
    public void testComputeIfAbsent_ExistingKey() {
        // Define a mapping function
        Function<String, Integer> mappingFunction = key -> key.length();
        // Set up the mock to return the existing value
        when(map.computeIfAbsent("test", mappingFunction)).thenReturn(4);
        // First compute the value for the key
        map.computeIfAbsent("test", mappingFunction);
        // Compute if absent should return the existing value
        Integer result = map.computeIfAbsent("test", mappingFunction);
        // Verify that the result is the same as the existing value
        assertEquals(4, result);
    }

    @Test
    public void testComputeIfAbsent_NullKey() {
        // Define a mapping function
        Function<String, Integer> mappingFunction = key -> key.length();
        // Expect NullPointerException when key is null
        Exception exception = assertThrows(NullPointerException.class, () -> {
            map.computeIfAbsent(null, mappingFunction);
        });
        assertNotNull(exception);
    }

    @Test
    public void testComputeIfAbsent_NullMappingFunction() {
        // Expect NullPointerException when mapping function is null
        Exception exception = assertThrows(NullPointerException.class, () -> {
            map.computeIfAbsent("test", null);
        });
        assertNotNull(exception);
    }
}
