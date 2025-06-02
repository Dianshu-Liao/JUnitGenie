package org.apache.commons.collections4;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Transformer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
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

class CollectionUtils_collect_11_3_Test {

    @Test
    void testCollectWithNonNullInput() {
        // Arrange
        Collection<Integer> inputCollection = new HashSet<>();
        inputCollection.add(1);
        inputCollection.add(2);
        inputCollection.add(3);
        Transformer<Integer, String> transformer = Object::toString;
        Collection<String> outputCollection = new ArrayList<>();
        // Act
        Collection<String> result = invokeCollect(inputCollection, transformer, outputCollection);
        // Assert
        assertNotNull(result);
        assertEquals(3, result.size());
        assertEquals(3, outputCollection.size());
        assertEquals("1", outputCollection.iterator().next());
    }

    @Test
    void testCollectWithNullInput() {
        // Arrange
        Collection<String> outputCollection = new ArrayList<>();
        Transformer<Object, String> transformer = Object::toString;
        // Act
        Collection<String> result = invokeCollect(null, transformer, outputCollection);
        // Assert
        assertNotNull(result);
        assertEquals(outputCollection, result);
    }

    @Test
    void testCollectWithEmptyInput() {
        // Arrange
        Collection<Integer> inputCollection = new HashSet<>();
        Transformer<Integer, String> transformer = Object::toString;
        Collection<String> outputCollection = new ArrayList<>();
        // Act
        Collection<String> result = invokeCollect(inputCollection, transformer, outputCollection);
        // Assert
        assertNotNull(result);
        assertEquals(0, result.size());
        assertEquals(0, outputCollection.size());
    }

    @Test
    void testCollectWithSingleElement() {
        // Arrange
        Collection<Integer> inputCollection = new HashSet<>();
        inputCollection.add(5);
        Transformer<Integer, String> transformer = Object::toString;
        Collection<String> outputCollection = new ArrayList<>();
        // Act
        Collection<String> result = invokeCollect(inputCollection, transformer, outputCollection);
        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("5", outputCollection.iterator().next());
    }

    @SuppressWarnings("unchecked")
    private <I, O, R extends Collection<? super O>> R invokeCollect(Iterable<? extends I> inputCollection, Transformer<? super I, ? extends O> transformer, R outputCollection) {
        try {
            Method method = CollectionUtils.class.getDeclaredMethod("collect", Iterable.class, Transformer.class, Collection.class);
            method.setAccessible(true);
            return (R) method.invoke(null, inputCollection, transformer, outputCollection);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
