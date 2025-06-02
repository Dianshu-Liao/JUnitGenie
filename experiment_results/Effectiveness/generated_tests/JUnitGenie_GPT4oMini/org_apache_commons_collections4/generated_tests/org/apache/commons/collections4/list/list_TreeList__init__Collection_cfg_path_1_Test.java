package org.apache.commons.collections4.list;
import org.apache.commons.collections4.list.TreeList;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Collection;
import static org.junit.Assert.assertEquals;

public class list_TreeList__init__Collection_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testConstructorWithNonEmptyCollection() {
        // Arrange
        Collection<Integer> collection = new ArrayList<>();
        collection.add(1);
        collection.add(2);
        collection.add(3);

        // Act
        TreeList<Integer> treeList = new TreeList<>(collection);

        // Assert
        assertEquals(3, treeList.size());
    }

    @Test(timeout = 4000)
    public void testConstructorWithEmptyCollection() {
        // Arrange
        Collection<Integer> collection = new ArrayList<>();

        // Act
        TreeList<Integer> treeList = new TreeList<>(collection);

        // Assert
        assertEquals(0, treeList.size());
    }

}