package org.apache.commons.collections4.list;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.lang.reflect.Field;
import java.util.Collection;
import java.io.Serializable;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ConcurrentModificationException;
import java.util.ListIterator;

class CursorableLinkedList_broadcastNodeRemoved_3_0_Test {

    private CursorableLinkedList<String> cursorableLinkedList;

    @BeforeEach
    void setUp() {
        cursorableLinkedList = new CursorableLinkedList<>();
    }

    @Test
    void testBroadcastNodeRemovedWithNonNullCursors() throws Exception {
        // Arrange
        MockCursor cursor1 = new MockCursor();
        MockCursor cursor2 = new MockCursor();
        addCursor(cursor1);
        addCursor(cursor2);
        CursorableLinkedList.Node<String> node = new CursorableLinkedList.Node<>("TestNode");
        // Act
        cursorableLinkedList.broadcastNodeRemoved(node);
        // Assert
        assertTrue(cursor1.isNodeRemovedCalled());
        assertTrue(cursor2.isNodeRemovedCalled());
    }

    @Test
    void testBroadcastNodeRemovedWithNullCursors() throws Exception {
        // Arrange
        MockCursor cursor1 = new MockCursor();
        addCursor(cursor1);
        // Simulating a null cursor
        addCursor(null);
        CursorableLinkedList.Node<String> node = new CursorableLinkedList.Node<>("TestNode");
        // Act
        cursorableLinkedList.broadcastNodeRemoved(node);
        // Assert
        assertTrue(cursor1.isNodeRemovedCalled());
        // Ensure the null cursor was removed
        assertEquals(1, getCursorsSize());
    }

    @Test
    void testBroadcastNodeRemovedWithAllNullCursors() throws Exception {
        // Arrange
        addCursor(null);
        addCursor(null);
        CursorableLinkedList.Node<String> node = new CursorableLinkedList.Node<>("TestNode");
        // Act
        cursorableLinkedList.broadcastNodeRemoved(node);
        // Assert
        // Ensure all null cursors were removed
        assertEquals(0, getCursorsSize());
    }

    private void addCursor(MockCursor cursor) throws Exception {
        Field field = CursorableLinkedList.class.getDeclaredField("cursors");
        field.setAccessible(true);
        List<WeakReference<Cursor<String>>> cursors = (List<WeakReference<Cursor<String>>>) field.get(cursorableLinkedList);
        cursors.add(new WeakReference<>(cursor));
    }

    private int getCursorsSize() throws Exception {
        Field field = CursorableLinkedList.class.getDeclaredField("cursors");
        field.setAccessible(true);
        List<WeakReference<Cursor<String>>> cursors = (List<WeakReference<Cursor<String>>>) field.get(cursorableLinkedList);
        return cursors.size();
    }

    // Mock Cursor class for testing
    private static class MockCursor implements Cursor<String> {

        private boolean nodeRemovedCalled = false;

        @Override
        public void nodeRemoved(CursorableLinkedList.Node<String> node) {
            nodeRemovedCalled = true;
        }

        public boolean isNodeRemovedCalled() {
            return nodeRemovedCalled;
        }
    }

    // Cursor interface definition
    interface Cursor<E> {

        void nodeRemoved(CursorableLinkedList.Node<E> node);
    }
}
