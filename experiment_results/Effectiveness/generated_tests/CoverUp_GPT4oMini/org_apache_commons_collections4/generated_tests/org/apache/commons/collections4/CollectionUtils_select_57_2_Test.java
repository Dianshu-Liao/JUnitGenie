package org.apache.commons.collections4;

import org.apache.commons.collections4.Predicate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.lang.reflect.Constructor;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.collections4.bag.HashBag;
import org.apache.commons.collections4.collection.PredicatedCollection;
import org.apache.commons.collections4.collection.SynchronizedCollection;
import org.apache.commons.collections4.collection.TransformedCollection;
import org.apache.commons.collections4.collection.UnmodifiableBoundedCollection;
import org.apache.commons.collections4.collection.UnmodifiableCollection;
import org.apache.commons.collections4.functors.TruePredicate;
import org.apache.commons.collections4.iterators.CollatingIterator;
import org.apache.commons.collections4.iterators.PermutationIterator;

public class CollectionUtils_select_57_2_Test {

    private CollectionUtils collectionUtils;

    @BeforeEach
    public void setUp() throws Exception {
        Constructor<CollectionUtils> constructor = CollectionUtils.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        collectionUtils = constructor.newInstance();
    }

    @Test
    public void testSelectWithNonNullInput() {
        List<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);
        input.add(4);
        input.add(5);
        Set<Integer> output = new HashSet<>();
        Predicate<Integer> predicate = item -> item % 2 == 0;
        collectionUtils.select(input, predicate, output);
        Set<Integer> expectedOutput = new HashSet<>();
        expectedOutput.add(2);
        expectedOutput.add(4);
        assertEquals(expectedOutput, output);
    }

    @Test
    public void testSelectWithEmptyInput() {
        List<Integer> input = new ArrayList<>();
        Set<Integer> output = new HashSet<>();
        Predicate<Integer> predicate = item -> item % 2 == 0;
        collectionUtils.select(input, predicate, output);
        Set<Integer> expectedOutput = new HashSet<>();
        assertEquals(expectedOutput, output);
    }

    @Test
    public void testSelectWithNullInputCollection() {
        Set<Integer> output = new HashSet<>();
        Predicate<Integer> predicate = item -> item % 2 == 0;
        collectionUtils.select(null, predicate, output);
        Set<Integer> expectedOutput = new HashSet<>();
        assertEquals(expectedOutput, output);
    }

    @Test
    public void testSelectWithNullPredicate() {
        List<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);
        input.add(4);
        input.add(5);
        Set<Integer> output = new HashSet<>();
        collectionUtils.select(input, null, output);
        Set<Integer> expectedOutput = new HashSet<>();
        assertEquals(expectedOutput, output);
    }

    @Test
    public void testSelectWithBothNulls() {
        Set<Integer> output = new HashSet<>();
        collectionUtils.select(null, null, output);
        Set<Integer> expectedOutput = new HashSet<>();
        assertEquals(expectedOutput, output);
    }

    @Test
    public void testSelectWithAlwaysTruePredicate() {
        List<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);
        input.add(4);
        input.add(5);
        Set<Integer> output = new HashSet<>();
        Predicate<Integer> predicate = item -> true;
        collectionUtils.select(input, predicate, output);
        Set<Integer> expectedOutput = new HashSet<>();
        expectedOutput.add(1);
        expectedOutput.add(2);
        expectedOutput.add(3);
        expectedOutput.add(4);
        expectedOutput.add(5);
        assertEquals(expectedOutput, output);
    }

    @Test
    public void testSelectWithAlwaysFalsePredicate() {
        List<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);
        input.add(4);
        input.add(5);
        Set<Integer> output = new HashSet<>();
        Predicate<Integer> predicate = item -> false;
        collectionUtils.select(input, predicate, output);
        Set<Integer> expectedOutput = new HashSet<>();
        assertEquals(expectedOutput, output);
    }
}
