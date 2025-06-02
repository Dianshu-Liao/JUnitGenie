package org.apache.commons.collections4;

import org.junit.jupiter.api.function.Executable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
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

class CollectionUtils_collect_14_0_Test {

    static class TestTransformer implements Transformer<Integer, String> {

        @Override
        public String transform(Integer input) {
            return "Transformed: " + input;
        }
    }

    @Test
    void testCollectWithValidInput() {
        List<Integer> input = Arrays.asList(1, 2, 3);
        Iterator<Integer> iterator = input.iterator();
        Transformer<Integer, String> transformer = new TestTransformer();
        Collection<String> result = CollectionUtils.collect(iterator, transformer);
        assertEquals(3, result.size());
        assertTrue(result.contains("Transformed: 1"));
        assertTrue(result.contains("Transformed: 2"));
        assertTrue(result.contains("Transformed: 3"));
    }

    @Test
    void testCollectWithEmptyIterator() {
        List<Integer> input = new ArrayList<>();
        Iterator<Integer> iterator = input.iterator();
        Transformer<Integer, String> transformer = new TestTransformer();
        Collection<String> result = CollectionUtils.collect(iterator, transformer);
        assertTrue(result.isEmpty());
    }

    @Test
    void testCollectWithNullTransformer() {
        List<Integer> input = Arrays.asList(1, 2, 3);
        Iterator<Integer> iterator = input.iterator();
        Executable executable = () -> CollectionUtils.collect(iterator, null);
        assertThrows(NullPointerException.class, executable);
    }

    @Test
    void testCollectWithNullInputIterator() {
        Transformer<Integer, String> transformer = new TestTransformer();
        Executable executable = () -> CollectionUtils.collect((Iterable<Integer>) null, transformer);
        assertThrows(NullPointerException.class, executable);
    }

    @Test
    void testCollectWithSingleElement() {
        List<Integer> input = Arrays.asList(42);
        Iterator<Integer> iterator = input.iterator();
        Transformer<Integer, String> transformer = new TestTransformer();
        Collection<String> result = CollectionUtils.collect(iterator, transformer);
        assertEquals(1, result.size());
        assertTrue(result.contains("Transformed: 42"));
    }

    @Test
    void testCollectWithMultipleTransformations() {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5);
        Iterator<Integer> iterator = input.iterator();
        Transformer<Integer, String> transformer = new TestTransformer();
        Collection<String> result = CollectionUtils.collect(iterator, transformer);
        assertEquals(5, result.size());
        assertTrue(result.contains("Transformed: 1"));
        assertTrue(result.contains("Transformed: 2"));
        assertTrue(result.contains("Transformed: 3"));
        assertTrue(result.contains("Transformed: 4"));
        assertTrue(result.contains("Transformed: 5"));
    }
}
