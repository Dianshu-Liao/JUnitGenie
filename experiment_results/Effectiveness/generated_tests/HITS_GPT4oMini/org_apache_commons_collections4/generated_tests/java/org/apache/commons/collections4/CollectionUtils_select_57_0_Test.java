package org.apache.commons.collections4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.commons.collections4.Predicate;
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

public class CollectionUtils_select_57_0_Test {

    private List<Integer> inputList;

    private Predicate<Integer> predicate;

    @BeforeEach
    public void setUp() {
        inputList = new ArrayList<>();
        inputList.add(1);
        inputList.add(2);
        inputList.add(3);
        // Predicate to filter numbers greater than 1
        predicate = (Integer i) -> i > 1;
    }

    @Test
    public void testSelect_NonNullInputCollectionAndPredicate() {
        Set<Integer> outputSet = new HashSet<>();
        CollectionUtils.select(inputList, predicate, outputSet);
        Set<Integer> expectedSet = new HashSet<>();
        expectedSet.add(2);
        expectedSet.add(3);
        assertEquals(expectedSet, outputSet);
    }

    @Test
    public void testSelect_NullInputCollection() {
        Set<Integer> outputSet = new HashSet<>();
        CollectionUtils.select(null, predicate, outputSet);
        assertEquals(0, outputSet.size());
    }

    @Test
    public void testSelect_NullPredicate() {
        Set<Integer> outputSet = new HashSet<>();
        CollectionUtils.select(inputList, null, outputSet);
        assertEquals(0, outputSet.size());
    }

    @Test
    public void testSelect_NullInputCollectionAndPredicate() {
        Set<Integer> outputSet = new HashSet<>();
        CollectionUtils.select(null, null, outputSet);
        assertEquals(0, outputSet.size());
    }

    @Test
    public void testSelect_EmptyInputCollection() {
        List<Integer> emptyList = new ArrayList<>();
        Set<Integer> outputSet = new HashSet<>();
        CollectionUtils.select(emptyList, predicate, outputSet);
        assertEquals(0, outputSet.size());
    }
}
