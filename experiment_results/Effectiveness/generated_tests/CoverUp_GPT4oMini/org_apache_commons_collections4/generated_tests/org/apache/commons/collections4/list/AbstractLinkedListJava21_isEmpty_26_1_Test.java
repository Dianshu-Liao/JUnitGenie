package org.apache.commons.collections4.list;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.lang.reflect.Field;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.OrderedIterator;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AbstractLinkedListJava21_isEmpty_26_1_Test {

    private AbstractLinkedListJava21<String> list;

    private class TestLinkedList extends AbstractLinkedListJava21<String> {

        protected TestLinkedList() {
            super();
        }

        protected TestLinkedList(final Collection<? extends String> coll) {
            super(coll);
        }

        @Override
        public int size() {
            return getSize();
        }

        private int getSize() {
            try {
                Field sizeField = AbstractLinkedListJava21.class.getDeclaredField("size");
                sizeField.setAccessible(true);
                return (int) sizeField.get(this);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public String getFirst() {
            return super.getFirst();
        }

        @Override
        public String getLast() {
            return super.getLast();
        }

        @Override
        public String set(final int index, final String value) {
            return super.set(index, value);
        }
    }

    @BeforeEach
    void setUp() {
        list = new TestLinkedList();
    }

    @Test
    void testIsEmptyWhenListIsEmpty() {
        assertTrue(list.isEmpty(), "The list should be empty.");
    }

    @Test
    void testIsEmptyWhenListIsNotEmpty() {
        list.add("Element");
        assertFalse(list.isEmpty(), "The list should not be empty.");
    }

    @Test
    void testGetFirstThrowsExceptionWhenListIsEmpty() {
        assertThrows(NoSuchElementException.class, () -> {
            list.getFirst();
        });
    }

    @Test
    void testGetLastThrowsExceptionWhenListIsEmpty() {
        assertThrows(NoSuchElementException.class, () -> {
            list.getLast();
        });
    }

    @Test
    void testAddAndCheckSize() {
        list.add("Element1");
        list.add("Element2");
        assertEquals(2, list.size(), "List size should be 2.");
    }

    @Test
    void testGetFirstReturnsFirstElement() {
        list.add("Element1");
        assertEquals("Element1", list.getFirst(), "First element should be 'Element1'.");
    }

    @Test
    void testGetLastReturnsLastElement() {
        list.add("Element1");
        list.add("Element2");
        assertEquals("Element2", list.getLast(), "Last element should be 'Element2'.");
    }

    @Test
    void testSetUpdatesElement() {
        list.add("Element1");
        list.set(0, "UpdatedElement");
        assertEquals("UpdatedElement", list.getFirst(), "First element should be 'UpdatedElement'.");
    }

    @Test
    void testSetThrowsExceptionForInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.set(0, "Element");
        });
    }
}
