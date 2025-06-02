package org.apache.commons.collections4.collection;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.iterators.EmptyIterator;
import org.apache.commons.collections4.iterators.IteratorChain;
import org.apache.commons.collections4.list.UnmodifiableList;

public class CompositeCollection_remove_12_0_Test {

    @Test
    public void testRemoveThrowsExceptionWhenMutatorIsNull() {
        // Arrange
        CompositeCollection<Object> collection = new CompositeCollection<>();
        // Act & Assert
        Exception exception = assertThrows(UnsupportedOperationException.class, () -> {
            collection.remove(new Object());
        });
        String expectedMessage = "remove() is not supported on CompositeCollection without a CollectionMutator strategy";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testRemoveDoesNotThrowExceptionWhenMutatorIsSet() {
        // Arrange
        CompositeCollection<Object> collection = new CompositeCollection<>();
        collection.setMutator(new CompositeCollection.CollectionMutator<Object>() {

            @Override
            public boolean remove(CompositeCollection<Object> compositeCollection, List<Collection<Object>> all, Object obj) {
                // Dummy implementation for testing
                return false;
            }

            @Override
            public boolean add(CompositeCollection<Object> compositeCollection, List<Collection<Object>> all, Object obj) {
                // Dummy implementation for testing
                return false;
            }

            @Override
            public boolean addAll(CompositeCollection<Object> compositeCollection, List<Collection<Object>> all, Collection<? extends Object> c) {
                // Dummy implementation for testing
                return false;
            }
        });
        // Act
        boolean result = collection.remove(new Object());
        // Assert
        // Since the dummy implementation returns false
        assertFalse(result);
    }
}
