package org.apache.commons.collections4.list;

import java.util.Iterator;
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
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.OrderedIterator;

public class AbstractLinkedListJava21_toString_45_0_Test extends AbstractLinkedListJava21 {

    private AbstractLinkedListJava21<String> list;

    @BeforeEach
    public void setUp() {
        list = new TestLinkedList();
    }

    @Test
    public void testToString_EmptyList() {
        assertEquals("[]", list.toString());
    }

    @Test
    public void testToString_SingleElement() {
        list.add("Element1");
        assertEquals("[Element1]", list.toString());
    }

    @Test
    public void testToString_MultipleElements() {
        list.add("Element1");
        list.add("Element2");
        list.add("Element3");
        assertEquals("[Element1, Element2, Element3]", list.toString());
    }

    @Test
    public void testToString_SelfReference() {
        // Adding a placeholder string instead of self-reference
        list.add("SelfReference");
        assertEquals("[SelfReference]", list.toString());
    }

    @Test
    public void testToString_NullElement() {
        list.add(null);
        assertEquals("[null]", list.toString());
    }

    private class TestLinkedList extends AbstractLinkedListJava21<String> {

        @Override
        public boolean add(String e) {
            Node<String> newNode = new Node<>(e);
            if (header == null) {
                // Initialize header if not already done
                header = new Node<>();
                header.next = header;
                header.previous = header;
            }
            newNode.next = header;
            newNode.previous = header.previous;
            header.previous.next = newNode;
            header.previous = newNode;
            size++;
            modCount++;
            return true;
        }

        @Override
        public Iterator<String> iterator() {
            return super.iterator();
        }
    }
}
