package org.apache.commons.collections4;

import java.util.ArrayList;
import java.util.List;
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

class CollectionUtils_forAllButLastDo_27_1_Test {

    @Test
    void testForAllButLastDo_NullClosure() {
        List<String> collection = new ArrayList<>();
        collection.add("A");
        collection.add("B");
        collection.add("C");
        // Test with null closure
        assertNull(CollectionUtils.forAllButLastDo(collection, null));
    }

    @Test
    void testForAllButLastDo_EmptyCollection() {
        List<String> collection = new ArrayList<>();
        // Test with an empty collection
        assertNull(CollectionUtils.forAllButLastDo(collection, new TestClosure()));
    }

    @Test
    void testForAllButLastDo_SingleElement() {
        List<String> collection = new ArrayList<>();
        collection.add("A");
        // Test with a single element collection
        assertNull(CollectionUtils.forAllButLastDo(collection, new TestClosure()));
    }

    @Test
    void testForAllButLastDo_MultipleElements() {
        List<String> collection = new ArrayList<>();
        collection.add("A");
        collection.add("B");
        collection.add("C");
        // Test with a collection of multiple elements
        TestClosure closure = new TestClosure();
        CollectionUtils.forAllButLastDo(collection, closure);
        assertEquals(2, closure.getCount());
        assertTrue(closure.getProcessedElements().contains("A"));
        assertTrue(closure.getProcessedElements().contains("B"));
        assertFalse(closure.getProcessedElements().contains("C"));
    }

    private static class TestClosure implements Closure<String> {

        private int count = 0;

        private final List<String> processedElements = new ArrayList<>();

        @Override
        public void execute(String input) {
            processedElements.add(input);
            count++;
        }

        public int getCount() {
            return count;
        }

        public List<String> getProcessedElements() {
            return processedElements;
        }
    }
}
