package org.apache.commons.collections4.list;

import java.util.Collection;
import java.util.NoSuchElementException;
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
import java.util.Objects;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.OrderedIterator;

public class AbstractLinkedListJava21_isEmpty_26_3_Test {

    private AbstractLinkedListJava21<String> linkedList;

    // Dummy implementation of the abstract class for testing
    private static class TestLinkedList extends AbstractLinkedListJava21<String> {

        public TestLinkedList() {
            super();
            header = new Node<>();
            header.next = header;
            header.previous = header;
            size = 0;
        }

        public TestLinkedList(Collection<? extends String> coll) {
            super(coll);
            header = new Node<>();
            header.next = header;
            header.previous = header;
            size = 0;
            for (String element : coll) {
                add(element);
            }
        }

        @Override
        public Node<String> getNode(int index, boolean create) {
            // Dummy implementation
            return null;
        }

        @Override
        public void updateNode(Node<String> node, String value) {
            // Dummy implementation
        }

        @Override
        public boolean add(String value) {
            Node<String> newNode = new Node<>(value);
            newNode.next = header;
            newNode.previous = header.previous;
            header.previous.next = newNode;
            header.previous = newNode;
            size++;
            return true;
        }

        public void clear() {
            size = 0;
            header.next = header;
            header.previous = header;
        }
    }

    @BeforeEach
    public void setUp() {
        linkedList = new TestLinkedList();
    }

    @Test
    public void testIsEmpty_WhenListIsEmpty() {
        assertTrue(linkedList.isEmpty(), "List should be empty");
    }

    @Test
    public void testIsEmpty_WhenListHasElements() {
        linkedList.add("Element");
        assertFalse(linkedList.isEmpty(), "List should not be empty");
    }

    @Test
    public void testIsEmpty_AfterClearingList() {
        linkedList.add("Element");
        linkedList.clear();
        assertTrue(linkedList.isEmpty(), "List should be empty after clearing");
    }
}
