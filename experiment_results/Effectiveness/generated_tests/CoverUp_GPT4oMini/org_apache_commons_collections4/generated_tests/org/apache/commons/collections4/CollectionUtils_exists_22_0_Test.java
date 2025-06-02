package org.apache.commons.collections4;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.IterableUtils;
import org.apache.commons.collections4.functors.TruePredicate;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
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
import org.apache.commons.collections4.iterators.CollatingIterator;
import org.apache.commons.collections4.iterators.PermutationIterator;

public class CollectionUtils_exists_22_0_Test {

    @Test
    void testExistsWithMatchingPredicate() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        boolean result = CollectionUtils.exists(list, TruePredicate.INSTANCE);
        assertTrue(result);
    }

    @Test
    void testExistsWithNonMatchingPredicate() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        boolean result = CollectionUtils.exists(list, element -> element > 5);
        assertFalse(result);
    }

    @Test
    void testExistsWithEmptyIterable() {
        List<Integer> list = Arrays.asList();
        boolean result = CollectionUtils.exists(list, TruePredicate.INSTANCE);
        assertFalse(result);
    }

    @Test
    void testExistsWithNullPredicate() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        boolean result = CollectionUtils.exists(list, null);
        assertFalse(result);
    }

    @Test
    void testExistsWithNullIterable() {
        boolean result = CollectionUtils.exists(null, TruePredicate.INSTANCE);
        assertFalse(result);
    }

    @Test
    void testExistsWithMixedValues() {
        List<Object> mixedList = Arrays.asList(1, "string", 3.14, null);
        boolean result = CollectionUtils.exists(mixedList, obj -> obj instanceof String);
        assertTrue(result);
    }

    @Test
    void testPrivateConstructor() throws Exception {
        Method method = CollectionUtils.class.getDeclaredMethod("CollectionUtils");
        method.setAccessible(true);
        method.invoke(null);
    }
}
