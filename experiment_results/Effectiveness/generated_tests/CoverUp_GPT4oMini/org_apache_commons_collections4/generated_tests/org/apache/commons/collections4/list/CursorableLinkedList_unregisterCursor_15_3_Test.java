package org.apache.commons.collections4.list;

import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
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

class CursorableLinkedList_unregisterCursor_15_3_Test {

    private CursorableLinkedList<String> cursorableLinkedList;

    private Cursor<String> cursor1;

    private Cursor<String> cursor2;

    @BeforeEach
    void setUp() {
        cursorableLinkedList = new CursorableLinkedList<>();
        cursor1 = new Cursor<>("Cursor1");
        cursor2 = new Cursor<>("Cursor2");
        addCursor(cursor1);
        addCursor(cursor2);
    }

    @Test
    void testUnregisterCursor_RemovesExistingCursor() throws Exception {
        // Act
        invokeUnregisterCursor(cursor1);
        // Assert
        assertEquals(1, getCursorsSize());
        assertNull(getCursor(0));
    }

    @Test
    void testUnregisterCursor_RemovesNullCursor() throws Exception {
        // Simulate garbage collection
        cursor1 = null;
        System.gc();
        // Act
        invokeUnregisterCursor(null);
        // Assert
        assertEquals(1, getCursorsSize());
        assertNotNull(getCursor(0));
    }

    @Test
    void testUnregisterCursor_DoesNotRemoveNonExistingCursor() throws Exception {
        Cursor<String> nonExistentCursor = new Cursor<>("NonExistentCursor");
        // Act
        invokeUnregisterCursor(nonExistentCursor);
        // Assert
        assertEquals(2, getCursorsSize());
    }

    @Test
    void testUnregisterCursor_CleansUpAfterGarbageCollection() throws Exception {
        // Simulate garbage collection
        cursor1 = null;
        System.gc();
        // Act
        invokeUnregisterCursor(cursor2);
        // Assert
        assertEquals(0, getCursorsSize());
    }

    private void invokeUnregisterCursor(Cursor<String> cursor) throws Exception {
        Method method = CursorableLinkedList.class.getDeclaredMethod("unregisterCursor", Cursor.class);
        method.setAccessible(true);
        method.invoke(cursorableLinkedList, cursor);
    }

    private void addCursor(Cursor<String> cursor) {
        try {
            Method method = CursorableLinkedList.class.getDeclaredMethod("addCursor", Cursor.class);
            method.setAccessible(true);
            method.invoke(cursorableLinkedList, cursor);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private int getCursorsSize() {
        try {
            Method method = CursorableLinkedList.class.getDeclaredMethod("getCursorsSize");
            method.setAccessible(true);
            return (int) method.invoke(cursorableLinkedList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Cursor<String> getCursor(int index) {
        try {
            Method method = CursorableLinkedList.class.getDeclaredMethod("getCursor", int.class);
            method.setAccessible(true);
            return (Cursor<String>) method.invoke(cursorableLinkedList, index);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static class Cursor<E> {

        private final E value;

        public Cursor(E value) {
            this.value = value;
        }
    }
}
