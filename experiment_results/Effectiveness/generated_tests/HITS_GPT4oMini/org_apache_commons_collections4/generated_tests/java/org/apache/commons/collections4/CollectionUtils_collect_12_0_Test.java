package org.apache.commons.collections4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
// Correct import for Transformer
import org.apache.commons.collections4.Transformer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Array;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
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

class CollectionUtils_collect_12_0_Test {

    private static class TestTransformer implements Transformer<Integer, String> {

        @Override
        public String transform(Integer input) {
            return "Number: " + input;
        }
    }

    @Test
    void testCollectWithNullInputCollection() {
        Collection<String> result = CollectionUtils.collect((Iterable<Integer>) null, new TestTransformer());
        assertNotNull(result);
        assertTrue(result.isEmpty(), "Result should be an empty collection when input is null.");
    }

    @Test
    void testCollectWithEmptyCollection() {
        Collection<Integer> input = Collections.emptyList();
        Collection<String> result = CollectionUtils.collect(input, new TestTransformer());
        assertNotNull(result);
        assertTrue(result.isEmpty(), "Result should be an empty collection when input is empty.");
    }

    @Test
    void testCollectWithNonEmptyCollection() {
        Collection<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);
        Collection<String> result = CollectionUtils.collect(input, new TestTransformer());
        assertNotNull(result);
        assertEquals(3, result.size(), "Result size should match input collection size.");
        assertTrue(result.contains("Number: 1"), "Result should contain transformed value for 1.");
        assertTrue(result.contains("Number: 2"), "Result should contain transformed value for 2.");
        assertTrue(result.contains("Number: 3"), "Result should contain transformed value for 3.");
    }

    @Test
    void testCollectWithDifferentTransformer() {
        Collection<Integer> input = new ArrayList<>();
        input.add(10);
        input.add(20);
        input.add(30);
        Collection<String> result = CollectionUtils.collect(input, new Transformer<Integer, String>() {

            @Override
            public String transform(Integer input) {
                return "Value: " + (input * 2);
            }
        });
        assertNotNull(result);
        assertEquals(3, result.size(), "Result size should match input collection size.");
        assertTrue(result.contains("Value: 20"), "Result should contain transformed value for 10.");
        assertTrue(result.contains("Value: 40"), "Result should contain transformed value for 20.");
        assertTrue(result.contains("Value: 60"), "Result should contain transformed value for 30.");
    }
}
