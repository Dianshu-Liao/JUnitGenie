package org.apache.commons.collections4.collection;

import org.apache.commons.collections4.collection.CompositeCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.Predicate;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.iterators.EmptyIterator;
import org.apache.commons.collections4.iterators.IteratorChain;
import org.apache.commons.collections4.list.UnmodifiableList;

public class CompositeCollection_isEmpty_10_0_Test {

    private CompositeCollection<Object> compositeCollection;

    @BeforeEach
    public void setUp() {
        compositeCollection = new CompositeCollection<>();
    }

    @Test
    public void testIsEmpty_WhenAllCollectionsAreEmpty() {
        compositeCollection = new CompositeCollection<>(Collections.emptyList());
        assertTrue(compositeCollection.isEmpty());
    }

    @Test
    public void testIsEmpty_WhenOneCollectionIsNotEmpty() {
        List<Object> nonEmptyList = new ArrayList<>(Arrays.asList("item1"));
        compositeCollection = new CompositeCollection<>(Collections.emptyList(), nonEmptyList);
        assertFalse(compositeCollection.isEmpty());
    }

    @Test
    public void testIsEmpty_WhenMultipleCollectionsAreEmpty() {
        List<Object> emptyList1 = Collections.emptyList();
        List<Object> emptyList2 = Collections.emptyList();
        compositeCollection = new CompositeCollection<>(emptyList1, emptyList2);
        assertTrue(compositeCollection.isEmpty());
    }

    @Test
    public void testIsEmpty_WhenMultipleCollectionsMixed() {
        List<Object> emptyList = Collections.emptyList();
        List<Object> nonEmptyList = new ArrayList<>(Arrays.asList("item1"));
        compositeCollection = new CompositeCollection<>(emptyList, nonEmptyList);
        assertFalse(compositeCollection.isEmpty());
    }
}
