package org.apache.commons.collections4.list;
import org.apache.commons.collections4.list.TreeList;
import org.junit.Test;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;

public class list_TreeList__init__Collection_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testConstructorWithNonEmptyCollection() {
        Collection<Integer> collection = Arrays.asList(1, 2, 3);
        TreeList<Integer> treeList = new TreeList<>(collection);
        
        // Verify that the size of the TreeList is equal to the size of the input collection
        assertEquals(3, treeList.size());
    }

    @Test(timeout = 4000)
    public void testConstructorWithEmptyCollection() {
        Collection<Integer> collection = Arrays.asList();
        TreeList<Integer> treeList = new TreeList<>(collection);
        
        // Verify that the size of the TreeList is equal to the size of the input collection
        assertEquals(0, treeList.size());
    }

}