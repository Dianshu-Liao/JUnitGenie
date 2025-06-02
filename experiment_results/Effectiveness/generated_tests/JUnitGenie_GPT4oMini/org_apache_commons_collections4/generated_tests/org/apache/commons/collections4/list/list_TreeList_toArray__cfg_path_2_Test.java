package org.apache.commons.collections4.list;
import org.apache.commons.collections4.list.TreeList;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class list_TreeList_toArray__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testToArray() {
        // Arrange
        TreeList treeList = new TreeList();
        // Assuming the TreeList is empty, size() should return 0
        // Act
        Object[] result = treeList.toArray();
        // Assert
        assertArrayEquals(new Object[0], result);
    }

    @Test(timeout = 4000)
    public void testToArrayWithElements() {
        // Arrange
        TreeList treeList = new TreeList();
        treeList.add("Element1");
        treeList.add("Element2");
        // Act
        Object[] result = treeList.toArray();
        // Assert
        assertArrayEquals(new Object[]{"Element1", "Element2"}, result);
    }

}