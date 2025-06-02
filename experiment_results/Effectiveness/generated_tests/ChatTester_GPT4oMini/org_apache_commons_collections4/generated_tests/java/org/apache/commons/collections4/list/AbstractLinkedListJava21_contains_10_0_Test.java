package org.apache.commons.collections4.list;

import java.util.Collection;
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
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.OrderedIterator;

public class AbstractLinkedListJava21_contains_10_0_Test {

    private AbstractLinkedListJava21 linkedList;

    @BeforeEach
    public void setUp() {
        linkedList = new AbstractLinkedListJava21() {

            @Override
            public int indexOf(Object value) {
                // Mock implementation for testing
                if (value == null)
                    return -1;
                // Example: let's assume we have a list with 1, 2, 3
                if (value.equals(1))
                    return 0;
                if (value.equals(2))
                    return 1;
                if (value.equals(3))
                    return 2;
                return -1;
            }
        };
    }

    @Test
    public void testContains_WithExistingElement_ReturnsTrue() {
        assertTrue(linkedList.contains(1));
        assertTrue(linkedList.contains(2));
        assertTrue(linkedList.contains(3));
    }

    @Test
    public void testContains_WithNonExistingElement_ReturnsFalse() {
        assertFalse(linkedList.contains(4));
        assertFalse(linkedList.contains(null));
    }

    @Test
    public void testContains_WithEmptyList_ReturnsFalse() {
        AbstractLinkedListJava21 emptyList = new AbstractLinkedListJava21() {

            @Override
            public int indexOf(Object value) {
                // No elements in the list
                return -1;
            }
        };
        assertFalse(emptyList.contains(1));
        assertFalse(emptyList.contains(null));
    }

    @Test
    public void testContains_WithNullValue_ReturnsFalse() {
        assertFalse(linkedList.contains(null));
    }
}
