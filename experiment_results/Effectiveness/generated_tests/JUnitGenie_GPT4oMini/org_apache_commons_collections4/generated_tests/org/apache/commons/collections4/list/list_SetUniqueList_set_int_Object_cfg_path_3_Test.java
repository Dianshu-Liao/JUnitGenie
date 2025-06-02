package org.apache.commons.collections4.list;
import org.apache.commons.collections4.list.SetUniqueList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.HashSet;

public class list_SetUniqueList_set_int_Object_cfg_path_3_Test {
    
    private SetUniqueList<String> uniqueList;

    @Before
    public void setUp() {
        uniqueList = new SetUniqueList<>(new ArrayList<>(), new HashSet<>());
    }

    @Test(timeout = 4000)
    public void testSetMethod_RemovesDuplicateAndReturnsRemoved() {
        uniqueList.add("A");
        uniqueList.add("B");

        // This should not result in duplicates
        String removed = uniqueList.set(0, "A");  // Attempt to set "A" again

        assertEquals("B", removed);  // "B" should be removed and returned
        assertTrue(uniqueList.contains("A"));
        assertFalse(uniqueList.contains("B"));
    }

    @Test(timeout = 4000)
    public void testSetMethod_WhenSettingNewItem() {
        uniqueList.add("A");
        uniqueList.add("B");

        // Set item "C" at index 0
        String removed = uniqueList.set(0, "C");  

        assertEquals("A", removed);  // "A" should be removed and returned
        assertTrue(uniqueList.contains("C"));
        assertFalse(uniqueList.contains("A"));
    }

    @Test(timeout = 4000)
    public void testSetMethod_WhenIndexIsOutOfBounds() {
        try {
            uniqueList.set(5, "D"); // Attempt to set at out-of-bounds index
            fail("Expected IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            // Expected exception
        }
    }

}