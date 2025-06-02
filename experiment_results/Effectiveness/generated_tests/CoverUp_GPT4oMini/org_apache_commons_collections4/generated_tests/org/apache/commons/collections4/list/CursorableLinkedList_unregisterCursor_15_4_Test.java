package org.apache.commons.collections4.list;

import java.lang.reflect.Method;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.ListIterator;

class CursorableLinkedList_unregisterCursor_15_4_Test {

    private CursorableLinkedList<String> list;

    private Cursor<String> cursor1;

    private Cursor<String> cursor2;

    @BeforeEach
    void setUp() {
        list = new CursorableLinkedList<>();
        cursor1 = new Cursor<>(list, "Item1");
        cursor2 = new Cursor<>(list, "Item2");
        addCursor(cursor1);
        addCursor(cursor2);
    }

    @Test
    void testUnregisterCursor_RemovesCursor() throws Exception {
        invokeUnregisterCursor(cursor1);
        assertEquals(1, getCursorsSize());
        assertNull(getCursor(0).get());
    }

    @Test
    void testUnregisterCursor_GarbageCollectedCursor() throws Exception {
        // Allow cursor1 to be garbage collected
        cursor1 = null;
        // Suggest garbage collection
        System.gc();
        invokeUnregisterCursor(cursor2);
        assertEquals(1, getCursorsSize());
        assertNull(getCursor(0).get());
    }

    @Test
    void testUnregisterCursor_NonExistentCursor() throws Exception {
        Cursor<String> cursor3 = new Cursor<>(list, "Item3");
        invokeUnregisterCursor(cursor3);
        // No cursor should be removed
        assertEquals(2, getCursorsSize());
    }

    private void invokeUnregisterCursor(Cursor<String> cursor) throws Exception {
        Method method = CursorableLinkedList.class.getDeclaredMethod("unregisterCursor", Cursor.class);
        method.setAccessible(true);
        method.invoke(list, cursor);
    }

    private void addCursor(Cursor<String> cursor) {
        try {
            Method method = CursorableLinkedList.class.getDeclaredMethod("addCursor", Cursor.class);
            method.setAccessible(true);
            method.invoke(list, cursor);
        } catch (Exception e) {
            fail("Failed to add cursor: " + e.getMessage());
        }
    }

    private int getCursorsSize() {
        try {
            Method method = CursorableLinkedList.class.getDeclaredMethod("getCursorsSize");
            method.setAccessible(true);
            return (int) method.invoke(list);
        } catch (Exception e) {
            fail("Failed to get cursors size: " + e.getMessage());
            return -1;
        }
    }

    private WeakReference<Cursor<String>> getCursor(int index) {
        try {
            Method method = CursorableLinkedList.class.getDeclaredMethod("getCursor", int.class);
            method.setAccessible(true);
            return (WeakReference<Cursor<String>>) method.invoke(list, index);
        } catch (Exception e) {
            fail("Failed to get cursor: " + e.getMessage());
            return null;
        }
    }

    // Mock Cursor class for testing
    private static class Cursor<E> {

        private final CursorableLinkedList<E> list;

        private final E item;

        public Cursor(CursorableLinkedList<E> list, E item) {
            this.list = list;
            this.item = item;
        }
    }
}
