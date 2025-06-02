package org.apache.commons.collections4.list;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.ListIterator;

@ExtendWith(MockitoExtension.class)
class CursorableLinkedList_broadcastNodeRemoved_3_4_Test {

    private CursorableLinkedList<String> cursorableLinkedList;

    @BeforeEach
    void setUp() {
        cursorableLinkedList = new CursorableLinkedList<>();
        setCursorsField(cursorableLinkedList, new ArrayList<>());
    }

    @Test
    void testBroadcastNodeRemovedWithNonNullCursor() throws Exception {
        // Arrange
        Cursor<String> mockCursor = Mockito.mock(Cursor.class);
        Node<String> nodeToRemove = new Node<>("TestNode");
        List<WeakReference<Cursor<String>>> cursors = getCursorsField(cursorableLinkedList);
        cursors.add(new WeakReference<>(mockCursor));
        // Act
        invokeBroadcastNodeRemoved(cursorableLinkedList, nodeToRemove);
        // Assert
        Mockito.verify(mockCursor).nodeRemoved(nodeToRemove);
    }

    @Test
    void testBroadcastNodeRemovedWithNullCursor() throws Exception {
        // Arrange
        Node<String> nodeToRemove = new Node<>("TestNode");
        List<WeakReference<Cursor<String>>> cursors = getCursorsField(cursorableLinkedList);
        // Add a null cursor
        cursors.add(new WeakReference<>(null));
        // Act
        invokeBroadcastNodeRemoved(cursorableLinkedList, nodeToRemove);
        // Assert
        assertTrue(cursors.isEmpty(), "Cursors list should be empty after cleaning up null references.");
    }

    private void invokeBroadcastNodeRemoved(CursorableLinkedList<String> list, Node<String> node) throws Exception {
        Method method = CursorableLinkedList.class.getDeclaredMethod("broadcastNodeRemoved", Node.class);
        // Make the private method accessible
        method.setAccessible(true);
        method.invoke(list, node);
    }

    @SuppressWarnings("unchecked")
    private List<WeakReference<Cursor<String>>> getCursorsField(CursorableLinkedList<String> list) {
        try {
            Field field = CursorableLinkedList.class.getDeclaredField("cursors");
            field.setAccessible(true);
            return (List<WeakReference<Cursor<String>>>) field.get(list);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    private void setCursorsField(CursorableLinkedList<String> list, List<WeakReference<Cursor<String>>> cursors) {
        try {
            Field field = CursorableLinkedList.class.getDeclaredField("cursors");
            field.setAccessible(true);
            field.set(list, cursors);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Mock Node class for testing
    static class Node<E> {

        E value;

        Node(E value) {
            this.value = value;
        }
    }

    // Mock Cursor interface for testing
    interface Cursor<E> {

        void nodeRemoved(Node<E> node);
    }
}
