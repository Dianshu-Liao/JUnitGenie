package org.apache.commons.collections4;

import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.IterableUtils;
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
import org.apache.commons.collections4.functors.TruePredicate;
import org.apache.commons.collections4.iterators.CollatingIterator;
import org.apache.commons.collections4.iterators.PermutationIterator;

public class CollectionUtils_forAllButLastDo_27_0_Test {

    @BeforeEach
    public void setUp() {
        // No initialization needed for static utility class
    }

    @Test
    public void testForAllButLastDo_withValidCollectionAndClosure() {
        // Arrange
        List<Integer> collection = Arrays.asList(1, 2, 3, 4);
        Closure<Integer> closure = mock(Closure.class);
        doNothing().when(closure).execute(Mockito.anyInt());
        // Act
        CollectionUtils.forAllButLastDo(collection, closure);
        // Assert
        Mockito.verify(closure, Mockito.times(3)).execute(Mockito.anyInt());
    }

    @Test
    public void testForAllButLastDo_withNullClosure() {
        // Arrange
        List<Integer> collection = Arrays.asList(1, 2, 3, 4);
        // Act
        Object result = CollectionUtils.forAllButLastDo(collection, null);
        // Assert
        assertNull(result);
    }

    @Test
    public void testForAllButLastDo_withEmptyCollection() {
        // Arrange
        List<Integer> collection = Arrays.asList();
        // Act
        Object result = CollectionUtils.forAllButLastDo(collection, mock(Closure.class));
        // Assert
        assertNull(result);
    }

    @Test
    public void testForAllButLastDo_withSingleElementCollection() {
        // Arrange
        List<Integer> collection = Arrays.asList(1);
        Closure<Integer> closure = mock(Closure.class);
        doNothing().when(closure).execute(Mockito.anyInt());
        // Act
        CollectionUtils.forAllButLastDo(collection, closure);
        // Assert
        Mockito.verify(closure, Mockito.never()).execute(Mockito.anyInt());
    }
}
