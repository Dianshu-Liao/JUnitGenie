package org.apache.commons.collections4;

import org.junit.jupiter.api.function.Executable;
import java.util.Iterator;
import java.util.NoSuchElementException;
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

class CollectionUtils_forAllDo_30_1_Test {

    @Test
    void testForAllDo_withValidIteratorAndClosure() {
        // Arrange
        Iterator<String> iterator = Mockito.mock(Iterator.class);
        Closure<String> closure = Mockito.mock(Closure.class);
        Mockito.when(iterator.hasNext()).thenReturn(true, false);
        Mockito.when(iterator.next()).thenReturn("element");
        // Act
        Closure<String> result = CollectionUtils.forAllDo(iterator, closure);
        // Assert
        assertEquals(closure, result);
        Mockito.verify(closure).execute("element");
    }

    @Test
    void testForAllDo_withNullClosure() {
        // Arrange
        Iterator<String> iterator = Mockito.mock(Iterator.class);
        Closure<String> closure = null;
        // Act
        Closure<String> result = CollectionUtils.forAllDo(iterator, closure);
        // Assert
        assertNull(result);
    }

    @Test
    void testForAllDo_withEmptyIterator() {
        // Arrange
        Iterator<String> iterator = Mockito.mock(Iterator.class);
        Closure<String> closure = Mockito.mock(Closure.class);
        Mockito.when(iterator.hasNext()).thenReturn(false);
        // Act
        Closure<String> result = CollectionUtils.forAllDo(iterator, closure);
        // Assert
        assertEquals(closure, result);
        Mockito.verify(closure, Mockito.never()).execute(Mockito.any());
    }

    @Test
    void testForAllDo_withIteratorThrowingException() {
        // Arrange
        Iterator<String> iterator = Mockito.mock(Iterator.class);
        Closure<String> closure = Mockito.mock(Closure.class);
        Mockito.when(iterator.hasNext()).thenReturn(true);
        Mockito.when(iterator.next()).thenThrow(new NoSuchElementException());
        // Act & Assert
        assertThrows(NoSuchElementException.class, () -> {
            CollectionUtils.forAllDo(iterator, closure);
        });
    }
}
