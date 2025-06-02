package org.apache.commons.collections4.list;
import org.apache.commons.collections4.list.PredicatedList;
import org.apache.commons.collections4.Predicate;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class list_PredicatedList_equals_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testEquals_SameInstance() {
        PredicatedList<Object> list = new PredicatedList<>(new ArrayList<>(), null);
        assertTrue(list.equals(list));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentObject() {
        PredicatedList<Object> list1 = new PredicatedList<>(new ArrayList<>(), null);
        PredicatedList<Object> list2 = new PredicatedList<>(new ArrayList<>(), null);
        assertFalse(list1.equals(list2));
    }

    @Test(timeout = 4000)
    public void testEquals_NullObject() {
        PredicatedList<Object> list = new PredicatedList<>(new ArrayList<>(), null);
        assertFalse(list.equals(null));
    }

    @Test(timeout = 4000)
    public void testEquals_EqualDecoratedList() {
        List<Object> decoratedList = new ArrayList<>();
        decoratedList.add(new Object());
        
        // Create a non-null predicate using the correct Predicate interface
        Predicate<Object> predicate = new Predicate<Object>() {
            @Override
            public boolean evaluate(Object obj) {
                return true; // Example predicate that accepts all objects
            }
        };
        
        PredicatedList<Object> list = new PredicatedList<>(decoratedList, predicate);
        
        // Create a new object that is not equal to the decorated list
        Object differentObject = new Object();
        
        // Ensure the decorated list is not equal to the different object
        assertFalse(list.equals(differentObject));
    }


}