package org.apache.commons.collections4.list;

import java.util.Arrays;
import java.util.Collection;
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
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.OrderedIterator;

class AbstractLinkedList_toString_45_0_Test {

    private AbstractLinkedList linkedList;

    @BeforeEach
    void setUp() {
        linkedList = Mockito.mock(AbstractLinkedList.class, Mockito.withSettings().useConstructor().defaultAnswer(Mockito.CALLS_REAL_METHODS));
    }

    @Test
    void testToString_EmptyList() {
        when(linkedList.isEmpty()).thenReturn(true);
        String result = linkedList.toString();
        assertEquals("[]", result);
    }

    @Test
    void testToString_NonEmptyList() {
        when(linkedList.isEmpty()).thenReturn(false);
        when(linkedList.size()).thenReturn(3);
        Collection<Object> collection = Arrays.asList("A", "B", "C");
        Iterator<Object> iterator = collection.iterator();
        when(linkedList.iterator()).thenReturn(iterator);
        String result = linkedList.toString();
        assertEquals("[A, B, C]", result);
    }

    @Test
    void testToString_SelfReference() {
        when(linkedList.isEmpty()).thenReturn(false);
        when(linkedList.size()).thenReturn(2);
        Collection<Object> collection = Arrays.asList(linkedList, "B");
        Iterator<Object> iterator = collection.iterator();
        when(linkedList.iterator()).thenReturn(iterator);
        String result = linkedList.toString();
        assertEquals("[(this Collection), B]", result);
    }

    @Test
    void testToString_SingleElement() {
        when(linkedList.isEmpty()).thenReturn(false);
        when(linkedList.size()).thenReturn(1);
        Collection<Object> collection = Arrays.asList("A");
        Iterator<Object> iterator = collection.iterator();
        when(linkedList.iterator()).thenReturn(iterator);
        String result = linkedList.toString();
        assertEquals("[A]", result);
    }
}
