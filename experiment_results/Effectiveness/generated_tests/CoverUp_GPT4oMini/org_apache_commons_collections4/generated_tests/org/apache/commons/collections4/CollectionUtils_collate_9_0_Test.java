package org.apache.commons.collections4;

import org.apache.commons.collections4.CollectionUtils;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.lang.reflect.InvocationTargetException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.collections4.bag.HashBag;
import org.apache.commons.collections4.collection.PredicatedCollection;
import org.apache.commons.collections4.collection.SynchronizedCollection;
import org.apache.commons.collections4.collection.TransformedCollection;
import org.apache.commons.collections4.collection.UnmodifiableBoundedCollection;
import org.apache.commons.collections4.collection.UnmodifiableCollection;
import org.apache.commons.collections4.functors.TruePredicate;
import org.apache.commons.collections4.iterators.CollatingIterator;
import org.apache.commons.collections4.iterators.PermutationIterator;

public class CollectionUtils_collate_9_0_Test {

    private static Method collateMethod;

    @BeforeAll
    public static void setUp() throws Exception {
        // Use reflection to access the private constructor
        collateMethod = CollectionUtils.class.getDeclaredMethod("collate", Iterable.class, Iterable.class, Comparator.class);
        collateMethod.setAccessible(true);
    }

    @Test
    public void testCollateWithEmptyCollections() throws Exception {
        List<String> result = (List<String>) collateMethod.invoke(null, Collections.emptyList(), Collections.emptyList(), (Comparator<String>) String::compareTo);
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    public void testCollateWithOneEmptyCollection() throws Exception {
        List<String> result = (List<String>) collateMethod.invoke(null, Arrays.asList("a", "b"), Collections.emptyList(), (Comparator<String>) String::compareTo);
        assertEquals(Arrays.asList("a", "b"), result);
    }

    @Test
    public void testCollateWithBothCollections() throws Exception {
        List<String> result = (List<String>) collateMethod.invoke(null, Arrays.asList("a", "c"), Arrays.asList("b", "d"), (Comparator<String>) String::compareTo);
        assertEquals(Arrays.asList("a", "b", "c", "d"), result);
    }

    @Test
    public void testCollateWithDuplicates() throws Exception {
        List<String> result = (List<String>) collateMethod.invoke(null, Arrays.asList("a", "b", "b"), Arrays.asList("b", "c"), (Comparator<String>) String::compareTo);
        assertEquals(Arrays.asList("a", "b", "b", "b", "c"), result);
    }

    @Test
    public void testCollateWithNullElements() throws Exception {
        List<String> result = (List<String>) collateMethod.invoke(null, Arrays.asList("a", null), Arrays.asList("b", "c"), (Comparator<String>) String::compareTo);
        assertEquals(Arrays.asList("a", null, "b", "c"), result);
    }

    @Test
    public void testCollateWithCustomComparator() throws Exception {
        Comparator<String> reverseComparator = (s1, s2) -> s2.compareTo(s1);
        List<String> result = (List<String>) collateMethod.invoke(null, Arrays.asList("a", "c"), Arrays.asList("b", "d"), reverseComparator);
        assertEquals(Arrays.asList("d", "c", "b", "a"), result);
    }
}
