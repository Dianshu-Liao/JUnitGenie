package org.apache.commons.collections4.list;
import org.apache.commons.collections4.list.SetUniqueList;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class list_SetUniqueList_set_int_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testSetMethod() {
        // Create a list and a set for the SetUniqueList
        List<Object> list = new ArrayList<>();
        Set<Object> set = new HashSet<>();
        
        // Instantiate SetUniqueList using reflection
        SetUniqueList<Object> uniqueList = null;
        try {
            java.lang.reflect.Constructor<SetUniqueList> constructor = SetUniqueList.class.getDeclaredConstructor(List.class, Set.class);
            constructor.setAccessible(true);
            uniqueList = constructor.newInstance(list, set);
        } catch (Exception e) {
            fail("Failed to instantiate SetUniqueList: " + e.getMessage());
        }

        // Add an object to the unique list
        Object obj1 = new Object();
        uniqueList.add(obj1); // Use add instead of set to avoid IndexOutOfBoundsException
        
        // Verify that the object is added
        assertTrue(set.contains(obj1));

        // Set a new object at the same index
        Object obj2 = new Object();
        Object removed = uniqueList.set(0, obj2);
        
        // Verify that the old object is removed and the new object is added
        assertEquals(obj1, removed);
        assertTrue(set.contains(obj2));
        assertFalse(set.contains(obj1));
    }


}