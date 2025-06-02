package org.apache.commons.collections4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.commons.collections4.Transformer;
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

public class CollectionUtils_collect_11_2_Test {

    // Transformer implementation to convert Integer to String
    private static class IntegerToStringTransformer implements Transformer<Integer, String> {

        @Override
        public String transform(Integer input) {
            return input.toString();
        }
    }

    @Test
    public void testCollectWithNonNullInput() {
        List<Integer> input = Arrays.asList(1, 2, 3);
        Set<String> output = new HashSet<>();
        CollectionUtils.collect(input, new IntegerToStringTransformer(), output);
        assertEquals(3, output.size());
        assertTrue(output.contains("1"));
        assertTrue(output.contains("2"));
        assertTrue(output.contains("3"));
    }

    @Test
    public void testCollectWithEmptyInput() {
        List<Integer> input = new ArrayList<>();
        Set<String> output = new HashSet<>();
        CollectionUtils.collect(input, new IntegerToStringTransformer(), output);
        assertEquals(0, output.size());
    }

    @Test
    public void testCollectWithNullInput() {
        List<Integer> input = null;
        Set<String> output = new HashSet<>();
        CollectionUtils.collect(input, new IntegerToStringTransformer(), output);
        assertEquals(0, output.size());
    }

    @Test
    public void testCollectWithNullTransformer() {
        List<Integer> input = Arrays.asList(1, 2, 3);
        Set<String> output = new HashSet<>();
        CollectionUtils.collect(input, null, output);
        assertEquals(0, output.size());
    }

    @Test
    public void testCollectWithNullOutputCollection() {
        List<Integer> input = Arrays.asList(1, 2, 3);
        Set<String> output = null;
        // When output collection is null, the method should return null
        Set<String> result = CollectionUtils.collect(input, new IntegerToStringTransformer(), output);
        assertEquals(null, result);
    }
}
