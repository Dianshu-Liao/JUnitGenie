package org.apache.commons.collections4.list;

import java.util.NoSuchElementException;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
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
import java.util.Objects;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.OrderedIterator;

@ExtendWith(MockitoExtension.class)
public class AbstractLinkedListJava21_removeLast_37_3_Test {

    private AbstractLinkedListJava21<Integer> linkedList;

    @BeforeEach
    public void setUp() {
        linkedList = new AbstractLinkedListJava21<Integer>() {

            // Provide implementation for abstract class
            @Override
            protected void removeNode(Node<Integer> node) {
                // Custom implementation for testing
                if (node == header)
                    return;
                node.previous.next = node.next;
                node.next.previous = node.previous;
                size--;
                modCount++;
            }

            @Override
            public Node<Integer> getNode(int index, boolean create) {
                // Custom implementation for testing
                // Simplified for the purpose of this test
                return null;
            }

            @Override
            public void updateNode(Node<Integer> node, Integer value) {
                // Custom implementation for testing
                node.value = value;
            }
        };
    }

    @Test
    public void testRemoveLast_EmptyList() {
        assertThrows(NoSuchElementException.class, () -> linkedList.removeLast());
    }

    @Test
    public void testRemoveLast_SingleElement() {
        // Assuming there's an add method to add elements
        linkedList.add(1);
        Integer removedValue = linkedList.removeLast();
        assertEquals(1, removedValue);
        assertThrows(NoSuchElementException.class, () -> linkedList.removeLast());
    }

    @Test
    public void testRemoveLast_MultipleElements() {
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        Integer removedValue = linkedList.removeLast();
        assertEquals(3, removedValue);
        removedValue = linkedList.removeLast();
        assertEquals(2, removedValue);
        removedValue = linkedList.removeLast();
        assertEquals(1, removedValue);
        assertThrows(NoSuchElementException.class, () -> linkedList.removeLast());
    }
}
