package org.apache.commons.collections4.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
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
import java.util.Objects;
import java.util.function.Predicate;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.iterators.EmptyIterator;
import org.apache.commons.collections4.iterators.IteratorChain;
import org.apache.commons.collections4.list.UnmodifiableList;

class CompositeCollection_iterator_11_0_Test {

    private CompositeCollection<String> compositeCollection;

    @BeforeEach
    void setUp() {
        compositeCollection = new CompositeCollection<>();
    }

    @Test
    void testIterator_EmptyCollection() {
        Iterator<String> iterator = compositeCollection.iterator();
        assertFalse(iterator.hasNext(), "Iterator should be empty for an empty CompositeCollection");
    }

    @Test
    void testIterator_NonEmptyCollection() {
        List<String> collection1 = new ArrayList<>();
        Collections.addAll(collection1, "A", "B", "C");
        List<String> collection2 = new ArrayList<>();
        Collections.addAll(collection2, "D", "E");
        compositeCollection = new CompositeCollection<>(collection1, collection2);
        Iterator<String> iterator = compositeCollection.iterator();
        List<String> results = new ArrayList<>();
        while (iterator.hasNext()) {
            results.add(iterator.next());
        }
        List<String> expectedResults = new ArrayList<>();
        Collections.addAll(expectedResults, "A", "B", "C", "D", "E");
        assertIterableEquals(expectedResults, results, "Iterator should return all elements from the composite collections");
    }
}
