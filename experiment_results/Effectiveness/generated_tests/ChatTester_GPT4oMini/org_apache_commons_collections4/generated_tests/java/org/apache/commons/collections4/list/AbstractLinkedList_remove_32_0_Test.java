package org.apache.commons.collections4.list;

import java.util.NoSuchElementException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.InvocationTargetException;
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
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class AbstractLinkedList_remove_32_0_Test {

    private AbstractLinkedList<Integer> list;

    @BeforeEach
    public void setUp() {
        list = Mockito.mock(AbstractLinkedList.class, Mockito.withSettings().useConstructor().defaultAnswer(Mockito.CALLS_REAL_METHODS));
    }

    @Test
    public void testRemoveValidIndex() throws Exception {
        // Arrange
        AbstractLinkedList.Node<Integer> node = new AbstractLinkedList.Node<>(10);
        Mockito.when(list.getNode(0, false)).thenReturn(node);
        Mockito.when(node.getValue()).thenReturn(10);
        // Act
        Integer result = invokeRemoveMethod(0);
        assertEquals(10, result);
        Mockito.verify(list).removeNode(node);
    }

    @Test
    public void testRemoveInvalidIndex() throws Exception {
        // Arrange
        Mockito.when(list.getNode(-1, false)).thenThrow(IndexOutOfBoundsException.class);
        // Act & Assert
        assertThrows(IndexOutOfBoundsException.class, () -> invokeRemoveMethod(-1));
    }

    @Test
    public void testRemoveFromEmptyList() throws Exception {
        // Arrange
        Mockito.when(list.getNode(0, false)).thenThrow(IndexOutOfBoundsException.class);
        // Act & Assert
        assertThrows(IndexOutOfBoundsException.class, () -> invokeRemoveMethod(0));
    }

    @Test
    public void testRemoveLastElement() throws Exception {
        // Arrange
        AbstractLinkedList.Node<Integer> node = new AbstractLinkedList.Node<>(20);
        Mockito.when(list.getNode(0, false)).thenReturn(node);
        Mockito.when(node.getValue()).thenReturn(20);
        // Act
        Integer result = invokeRemoveMethod(0);
        assertEquals(20, result);
        Mockito.verify(list).removeNode(node);
    }

    private Integer invokeRemoveMethod(int index) throws Exception {
        java.lang.reflect.Method method = AbstractLinkedList.class.getDeclaredMethod("remove", int.class);
        method.setAccessible(true);
        return (Integer) method.invoke(list, index);
    }
}
