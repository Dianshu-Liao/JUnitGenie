package org.apache.commons.collections4.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.iterators.EmptyIterator;
import org.apache.commons.collections4.iterators.IteratorChain;
import org.apache.commons.collections4.list.UnmodifiableList;

public class CompositeCollection_isEmpty_10_0_Test {

    private CompositeCollection<String> compositeCollection;

    @BeforeEach
    public void setUp() {
        compositeCollection = new CompositeCollection<>();
    }

    @Test
    public void testIsEmpty_WhenNoCollectionsAdded() {
        assertTrue(compositeCollection.isEmpty(), "CompositeCollection should be empty when no collections are added.");
    }

    @Test
    public void testIsEmpty_WhenAllCollectionsAreEmpty() {
        Collection<String> emptyCollection1 = new ArrayList<>();
        Collection<String> emptyCollection2 = new ArrayList<>();
        compositeCollection = new CompositeCollection<>(emptyCollection1, emptyCollection2);
        assertTrue(compositeCollection.isEmpty(), "CompositeCollection should be empty when all collections are empty.");
    }

    @Test
    public void testIsEmpty_WhenOneCollectionIsNotEmpty() {
        Collection<String> emptyCollection = new ArrayList<>();
        Collection<String> nonEmptyCollection = new ArrayList<>(Arrays.asList("item1"));
        compositeCollection = new CompositeCollection<>(emptyCollection, nonEmptyCollection);
        assertFalse(compositeCollection.isEmpty(), "CompositeCollection should not be empty when at least one collection is not empty.");
    }

    @Test
    public void testIsEmpty_WhenMultipleCollectionsWithOneNonEmpty() {
        Collection<String> emptyCollection = new ArrayList<>();
        Collection<String> anotherEmptyCollection = new ArrayList<>();
        Collection<String> nonEmptyCollection = new ArrayList<>(Arrays.asList("item2"));
        compositeCollection = new CompositeCollection<>(emptyCollection, anotherEmptyCollection, nonEmptyCollection);
        assertFalse(compositeCollection.isEmpty(), "CompositeCollection should not be empty when at least one collection is not empty.");
    }

    @Test
    public void testIsEmpty_WhenAllCollectionsAreNonEmpty() {
        Collection<String> nonEmptyCollection1 = new ArrayList<>(Arrays.asList("item1"));
        Collection<String> nonEmptyCollection2 = new ArrayList<>(Arrays.asList("item2"));
        compositeCollection = new CompositeCollection<>(nonEmptyCollection1, nonEmptyCollection2);
        assertFalse(compositeCollection.isEmpty(), "CompositeCollection should not be empty when all collections are non-empty.");
    }
}
