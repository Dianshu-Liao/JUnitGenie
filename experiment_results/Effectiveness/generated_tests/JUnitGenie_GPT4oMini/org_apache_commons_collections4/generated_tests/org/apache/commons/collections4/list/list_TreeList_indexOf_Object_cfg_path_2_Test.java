package org.apache.commons.collections4.list;
import org.apache.commons.collections4.list.TreeList;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class list_TreeList_indexOf_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testIndexOfWithNullRoot() {
        TreeList treeList = new TreeList(); // Using the default constructor
        int result = -1;

        try {
            result = treeList.indexOf(new Object());
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }

        assertEquals("Expected indexOf to return -1 when root is null", result, -1);
    }

}