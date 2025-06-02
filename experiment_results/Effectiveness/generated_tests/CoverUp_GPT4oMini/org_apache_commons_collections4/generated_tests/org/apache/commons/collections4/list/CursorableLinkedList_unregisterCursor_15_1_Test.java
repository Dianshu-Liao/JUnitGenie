package org.apache.commons.collections4.list;

import java.lang.reflect.Method;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Collection;
import java.util.ConcurrentModificationException;
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
import java.util.ListIterator;

class CursorableLinkedList_unregisterCursor_15_1_Test {

    private CursorableLinkedList<String> cursorableLinkedList;

    @BeforeEach
    void setUp() {
        cursorableLinkedList = new CursorableLinkedList<>();
        // Initialize the cursors list using reflection
        try {
            Method method = CursorableLinkedList.class.getDeclaredMethod("initializeCursors");
            method.setAccessible(true);
            method.invoke(cursorableLinkedList);
        } catch (Exception e) {
            fail("Failed to initialize cursors list: " + e.getMessage());
        }
    }

    @Test
    void testUnregisterCursor_RemovesExistingCursor() throws Exception {
        Cursor<String> cursor = new Cursor<>();
        addCursor(cursor);
        invokeUnregisterCursor(cursor);
        assertTrue(getCursors().isEmpty());
    }

    @Test
    void testUnregisterCursor_RemovesNullCursorReference() throws Exception {
        Cursor<String> cursor = new Cursor<>();
        addCursor(cursor);
        addCursor(null);
        invokeUnregisterCursor(cursor);
        assertEquals(1, getCursors().size());
        assertNull(getCursors().get(0).get());
    }

    @Test
    void testUnregisterCursor_DoesNotRemoveUnrelatedCursor() throws Exception {
        Cursor<String> cursor1 = new Cursor<>();
        Cursor<String> cursor2 = new Cursor<>();
        addCursor(cursor1);
        addCursor(cursor2);
        invokeUnregisterCursor(cursor1);
        assertEquals(1, getCursors().size());
        assertNotNull(getCursors().get(0).get());
    }

    @Test
    void testUnregisterCursor_HandlesConcurrentModification() throws Exception {
        Cursor<String> cursor = new Cursor<>();
        addCursor(cursor);
        addCursor(null);
        invokeUnregisterCursor(cursor);
        assertTrue(getCursors().isEmpty());
    }

    private void invokeUnregisterCursor(Cursor<String> cursor) throws Exception {
        Method method = CursorableLinkedList.class.getDeclaredMethod("unregisterCursor", Cursor.class);
        method.setAccessible(true);
        method.invoke(cursorableLinkedList, cursor);
    }

    private void addCursor(Cursor<String> cursor) {
        try {
            Method method = CursorableLinkedList.class.getDeclaredMethod("addCursor", WeakReference.class);
            method.setAccessible(true);
            method.invoke(cursorableLinkedList, new WeakReference<>(cursor));
        } catch (Exception e) {
            fail("Failed to add cursor: " + e.getMessage());
        }
    }

    private List<WeakReference<Cursor<String>>> getCursors() {
        try {
            Method method = CursorableLinkedList.class.getDeclaredMethod("getCursors");
            method.setAccessible(true);
            return (List<WeakReference<Cursor<String>>>) method.invoke(cursorableLinkedList);
        } catch (Exception e) {
            fail("Failed to get cursors: " + e.getMessage());
            // Fallback to prevent compilation error
            return new ArrayList<>();
        }
    }

    private static class Cursor<E> {
        // Simulated cursor class for testing
    }
}
