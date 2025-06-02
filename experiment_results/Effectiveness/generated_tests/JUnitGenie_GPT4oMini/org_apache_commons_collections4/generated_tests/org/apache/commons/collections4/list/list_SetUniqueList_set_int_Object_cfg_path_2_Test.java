package org.apache.commons.collections4.list;
import org.apache.commons.collections4.list.SetUniqueList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class list_SetUniqueList_set_int_Object_cfg_path_2_Test {
    private SetUniqueList<String> uniqueList;

    @Before
    public void setUp() {
        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        uniqueList = new SetUniqueList<>(list, set);
    }

    @Test(timeout = 4000)
    public void testSetWithUniqueObject() {
        uniqueList.add("A"); // Add an element before setting
        String removed = uniqueList.set(0, "B");
        assertEquals("A", removed);
        assertTrue(uniqueList.contains("B"));
        assertFalse(uniqueList.contains("A"));
    }

    @Test(timeout = 4000)
    public void testSetWithDuplicateObject() {
        uniqueList.add("A"); // Add an element before setting
        uniqueList.add("B"); // Add another element before setting
        String removed = uniqueList.set(1, "A"); // This should remove "B" and add "A" again
        assertEquals("B", removed);
        assertTrue(uniqueList.contains("A"));
        assertFalse(uniqueList.contains("B"));
    }

    @Test(timeout = 4000)
    public void testSetWithSameObject() {
        uniqueList.add("A"); // Add an element before setting
        String removed = uniqueList.set(0, "A"); // Setting the same object should not remove it
        assertNull(removed); // Since "A" is not removed, it should return null
        assertTrue(uniqueList.contains("A"));
    }

}