package org.apache.commons.collections4.list;

import java.util.Arrays;
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

class AbstractLinkedListJava21_contains_10_0_Test extends AbstractLinkedListJava21<String> {

    private AbstractLinkedListJava21<String> list;

    @BeforeEach
    void setUp() {
        // Initialize the linked list with some elements
        list = new AbstractLinkedListJava21<String>() {

            {
                addAll(Arrays.asList("A", "B", "C"));
            }
        };
    }

    @Test
    void testContainsElementPresent() {
        assertTrue(list.contains("A"), "List should contain 'A'");
        assertTrue(list.contains("B"), "List should contain 'B'");
        assertTrue(list.contains("C"), "List should contain 'C'");
    }

    @Test
    void testContainsElementNotPresent() {
        assertFalse(list.contains("D"), "List should not contain 'D'");
        assertFalse(list.contains("E"), "List should not contain 'E'");
    }

    @Test
    void testContainsNullElement() {
        list.add(null);
        assertTrue(list.contains(null), "List should contain null");
    }

    @Test
    void testContainsOnEmptyList() {
        AbstractLinkedListJava21<String> emptyList = new AbstractLinkedListJava21<String>() {
        };
        assertFalse(emptyList.contains("A"), "Empty list should not contain any element");
    }

    @Override
    public boolean add(String e) {
        Node<String> newNode = new Node<>(e);
        if (header == null) {
            header = newNode;
            header.next = header;
            header.previous = header;
        } else {
            Node<String> last = header.previous;
            last.next = newNode;
            newNode.previous = last;
            newNode.next = header;
            header.previous = newNode;
        }
        size++;
        modCount++;
        return true;
    }
}
