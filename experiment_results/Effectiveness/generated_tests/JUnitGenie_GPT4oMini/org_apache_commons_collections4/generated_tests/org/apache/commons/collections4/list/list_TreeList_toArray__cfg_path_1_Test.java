package org.apache.commons.collections4.list;
import org.apache.commons.collections4.list.TreeList;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class list_TreeList_toArray__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testToArray() {
        // Create an instance of TreeList
        TreeList<Object> treeList = new TreeList<>();

        // Add elements to the TreeList to ensure size() returns a positive integer
        treeList.add("Element 1");
        treeList.add("Element 2");
        treeList.add("Element 3");

        // Expected array
        Object[] expectedArray = new Object[] {"Element 1", "Element 2", "Element 3"};

        // Call the toArray method
        Object[] resultArray = null;
        try {
            resultArray = treeList.toArray();
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }

        // Assert that the result array matches the expected array
        assertArrayEquals(expectedArray, resultArray);
    }

}