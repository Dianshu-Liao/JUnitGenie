package org.apache.commons.collections4.list;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.OrderedIterator;

class AbstractLinkedListJava21_isEmpty_26_0_Test {

    private AbstractLinkedListJava21<Integer> list;

    // A concrete implementation of AbstractLinkedListJava21 for testing purposes
    private class TestLinkedList extends AbstractLinkedListJava21<Integer> {

        public TestLinkedList() {
            super();
        }

        public TestLinkedList(Collection<? extends Integer> coll) {
            super(coll);
        }

        @Override
        public Integer get(int index) {
            // Implementation not needed for this test
            return null;
        }

        @Override
        public int size() {
            return super.size();
        }
    }

    @BeforeEach
    void setUp() {
        list = new TestLinkedList();
    }

    @Test
    void testIsEmpty_WhenListIsEmpty_ShouldReturnTrue() {
        assertTrue(list.isEmpty(), "List should be empty");
    }

    @Test
    void testIsEmpty_WhenListHasElements_ShouldReturnFalse() {
        list.add(1);
        assertFalse(list.isEmpty(), "List should not be empty");
    }

    @Test
    void testIsEmpty_AfterRemovingAllElements_ShouldReturnTrue() {
        list.add(1);
        // Assuming remove method is implemented
        list.remove(0);
        assertTrue(list.isEmpty(), "List should be empty after removing all elements");
    }

    @Test
    void testIsEmpty_WhenListIsInitializedWithCollection_ShouldReturnFalse() {
        list = new TestLinkedList(java.util.Arrays.asList(1, 2, 3));
        assertFalse(list.isEmpty(), "List should not be empty when initialized with elements");
    }

    @Test
    void testIsEmpty_WhenListIsCleared_ShouldReturnTrue() {
        list.add(1);
        // Assuming clear method is implemented
        list.clear();
        assertTrue(list.isEmpty(), "List should be empty after clearing");
    }
}
