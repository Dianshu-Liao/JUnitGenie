package org.apache.commons.collections4.list;
import org.apache.commons.collections4.list.AbstractLinkedList;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.LinkedList;

public class list_AbstractLinkedList_contains_Object_cfg_path_1_Test extends AbstractLinkedList<Object> {

    private LinkedList<Object> internalList;

    // Corrected constructor name to match the class name
    public list_AbstractLinkedList_contains_Object_cfg_path_1_Test() {
        super(); // Call the protected constructor using reflection
        internalList = new LinkedList<>(); // Initialize the internal list
    }

    @Override
    public void add(int index, Object element) {
        internalList.add(index, element); // Add element to the internal list
    }

    @Override
    public Object remove(int index) {
        return internalList.remove(index); // Remove element from the internal list
    }

    @Override
    public Object get(int index) {
        return internalList.get(index); // Get element from the internal list
    }

    @Override
    public int size() {
        return internalList.size(); // Return size of the internal list
    }

    @Test(timeout = 4000)
    public void testContains() {
        list_AbstractLinkedList_contains_Object_cfg_path_1_Test list = new list_AbstractLinkedList_contains_Object_cfg_path_1_Test();
        list.add(0, "test"); // Adding an element to the list

        // Test for an existing element
        assertTrue(list.contains("test"));

        // Test for a non-existing element
        assertFalse(list.contains("nonexistent"));
    }

}