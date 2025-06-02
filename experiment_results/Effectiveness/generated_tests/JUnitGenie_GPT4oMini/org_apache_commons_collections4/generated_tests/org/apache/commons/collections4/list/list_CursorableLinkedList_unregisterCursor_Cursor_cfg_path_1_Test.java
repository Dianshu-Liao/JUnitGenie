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
import static org.junit.Assert.assertEquals;

public class list_CursorableLinkedList_unregisterCursor_Cursor_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testUnregisterCursor() {
        try {
            // Create an instance of CursorableLinkedList
            CursorableLinkedList<String> list = new CursorableLinkedList<>();

            // Create a cursor and add it to the list
            Cursor<String> cursor = list.cursor();
            list.add("Element 1");
            list.add("Element 2");

            // Use reflection to access the protected method unregisterCursor
            Method method = CursorableLinkedList.class.getDeclaredMethod("unregisterCursor", Cursor.class);
            method.setAccessible(true);

            // Call the unregisterCursor method
            method.invoke(list, cursor);

            // Verify that the cursor has been unregistered
            // Access the private field 'cursors' using reflection
            Field cursorsField = CursorableLinkedList.class.getDeclaredField("cursors");
            cursorsField.setAccessible(true);
            List<WeakReference<Cursor<String>>> cursorsFieldValue = (List<WeakReference<Cursor<String>>>) cursorsField.get(list);
            assertEquals(0, cursorsFieldValue.size());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}