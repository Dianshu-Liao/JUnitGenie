package org.apache.commons.collections4.list;
import org.apache.commons.collections4.list.PredicatedList;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class list_PredicatedList_equals_Object_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testEquals_SameInstance() {
        PredicatedList<Object> list = new PredicatedList<>(new java.util.ArrayList<>(), o -> true);
        assertTrue(list.equals(list)); // Testing the case where object == this
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentObject() {
        PredicatedList<Object> list1 = new PredicatedList<>(new java.util.ArrayList<>(), o -> true);
        PredicatedList<Object> list2 = new PredicatedList<>(new java.util.ArrayList<>(), o -> true);
        assertTrue(!list1.equals(list2)); // Testing the case where object is a different instance
    }


}