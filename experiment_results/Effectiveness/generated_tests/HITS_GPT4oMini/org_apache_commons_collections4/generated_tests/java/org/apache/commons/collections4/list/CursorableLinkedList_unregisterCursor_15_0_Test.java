package org.apache.commons.collections4.list;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Field;
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
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.ListIterator;

class CursorableLinkedList_unregisterCursor_15_0_Test {

    private CursorableLinkedList<String> cursorableLinkedList;

    @BeforeEach
    void setUp() {
        cursorableLinkedList = new CursorableLinkedList<>();
        cursorableLinkedList.registerCursor(new CursorableLinkedList.Cursor<>(cursorableLinkedList, 0));
        cursorableLinkedList.registerCursor(new CursorableLinkedList.Cursor<>(cursorableLinkedList, 1));
    }

    @SuppressWarnings("unchecked")
    private List<WeakReference<CursorableLinkedList.Cursor<String>>> getCursors(CursorableLinkedList<String> list) throws NoSuchFieldException, IllegalAccessException {
        Field field = CursorableLinkedList.class.getDeclaredField("cursors");
        field.setAccessible(true);
        return (List<WeakReference<CursorableLinkedList.Cursor<String>>>) field.get(list);
    }

    @Test
    void testUnregisterExistingCursor() throws NoSuchFieldException, IllegalAccessException {
        CursorableLinkedList.Cursor<String> cursor1 = getCursors(cursorableLinkedList).get(0).get();
        cursorableLinkedList.unregisterCursor(cursor1);
        List<WeakReference<CursorableLinkedList.Cursor<String>>> cursors = getCursors(cursorableLinkedList);
        assertFalse(cursors.contains(new WeakReference<>(cursor1)), "Cursor1 should be unregistered.");
        assertTrue(cursors.size() > 0, "At least one cursor should still be registered.");
    }

    @Test
    void testUnregisterNonExistingCursor() throws NoSuchFieldException, IllegalAccessException {
        CursorableLinkedList.Cursor<String> cursor3 = new CursorableLinkedList.Cursor<>(cursorableLinkedList, 2);
        cursorableLinkedList.unregisterCursor(cursor3);
        List<WeakReference<CursorableLinkedList.Cursor<String>>> cursors = getCursors(cursorableLinkedList);
        assertEquals(2, cursors.size(), "Two cursors should still be registered.");
    }

    @Test
    void testUnregisterNullCursor() throws NoSuchFieldException, IllegalAccessException {
        cursorableLinkedList.unregisterCursor(null);
        List<WeakReference<CursorableLinkedList.Cursor<String>>> cursors = getCursors(cursorableLinkedList);
        assertEquals(2, cursors.size(), "Two cursors should still be registered.");
    }
}
