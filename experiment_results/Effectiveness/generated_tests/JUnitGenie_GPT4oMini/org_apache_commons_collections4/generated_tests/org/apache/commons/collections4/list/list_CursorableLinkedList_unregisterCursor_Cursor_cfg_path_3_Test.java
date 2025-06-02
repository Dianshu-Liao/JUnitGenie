package org.apache.commons.collections4.list;
import org.apache.commons.collections4.list.CursorableLinkedList;
import org.apache.commons.collections4.list.CursorableLinkedList.Cursor;
import org.junit.Test;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.lang.ref.WeakReference;
import static org.junit.Assert.assertTrue;

public class list_CursorableLinkedList_unregisterCursor_Cursor_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testUnregisterCursor() {
        try {
            // Create an instance of CursorableLinkedList
            CursorableLinkedList<String> list = new CursorableLinkedList<>();

            // Create a cursor and add it to the list
            Cursor<String> cursor = list.cursor();
            list.add("Element 1");
            list.add("Element 2");

            // Use reflection to access the private 'unregisterCursor' method
            Method unregisterCursorMethod = CursorableLinkedList.class.getDeclaredMethod("unregisterCursor", Cursor.class);
            unregisterCursorMethod.setAccessible(true);

            // Call the unregisterCursor method with the cursor
            unregisterCursorMethod.invoke(list, cursor);

            // Verify that the cursor has been unregistered
            // Since we cannot directly access the private 'cursors' field, we will check if the cursor is no longer present
            Field cursorsField = CursorableLinkedList.class.getDeclaredField("cursors");
            cursorsField.setAccessible(true);
            List<WeakReference<Cursor<String>>> cursors = (List<WeakReference<Cursor<String>>>) cursorsField.get(list);
            boolean cursorExists = false;
            for (WeakReference<Cursor<String>> ref : cursors) {
                if (ref.get() == cursor) {
                    cursorExists = true;
                    break;
                }
            }

            // Assert that the cursor no longer exists in the cursors list
            assertTrue("Cursor should be unregistered", !cursorExists);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}