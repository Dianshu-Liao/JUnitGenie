package org.apache.commons.collections4.list;
import org.apache.commons.collections4.list.TreeList;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class list_TreeList_indexOf_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testIndexOfWithNonNullRoot() {
        TreeList treeList = new TreeList();
        // Assuming we have a method to add elements to the TreeList
        // treeList.add("testObject"); // Uncomment and implement if necessary

        Object testObject = "testObject"; // Replace with an actual object that exists in the TreeList
        int expectedIndex = 0; // Replace with the expected index of the testObject
        try {
            int actualIndex = treeList.indexOf(testObject);
            assertEquals(expectedIndex, actualIndex);
        } catch (Exception e) {
            // Handle the exception if necessary
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIndexOfWithNullRoot() {
        TreeList treeList = new TreeList();
        // Simulate a null root by not adding any elements
        Object testObject = "nonExistentObject";
        int expectedIndex = -1; // Since the root is null, we expect -1
        try {
            int actualIndex = treeList.indexOf(testObject);
            assertEquals(expectedIndex, actualIndex);
        } catch (Exception e) {
            // Handle the exception if necessary
            e.printStackTrace();
        }
    }

}