package org.apache.commons.collections4.bidimap;
import org.apache.commons.collections4.bidimap.TreeBidiMap;
import org.apache.commons.collections4.bidimap.TreeBidiMap.Node;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.*;

public class bidimap_TreeBidiMap_doRedBlackDelete_Node_cfg_path_29_Test {

    @Test(timeout = 4000)
    public void testDoRedBlackDelete() {
        try {
            // Create an instance of TreeBidiMap
            TreeBidiMap<Integer, String> treeBidiMap = new TreeBidiMap<>();

            // Create a Node to delete
            Node<Integer, String> deletedNode = new Node<>(1, "One");
            // Assuming we have a method to add nodes to the TreeBidiMap
            treeBidiMap.put(1, "One");
            treeBidiMap.put(2, "Two");
            treeBidiMap.put(3, "Three");

            // Use reflection to access the private method
            Method method = TreeBidiMap.class.getDeclaredMethod("doRedBlackDelete", Node.class);
            method.setAccessible(true);

            // Invoke the method with the deletedNode
            method.invoke(treeBidiMap, deletedNode);

            // Validate the state of the TreeBidiMap after deletion
            assertNull(treeBidiMap.get(1)); // Ensure the deleted node is no longer present
            assertNotNull(treeBidiMap.get(2)); // Ensure other nodes are still present
            assertNotNull(treeBidiMap.get(3)); // Ensure other nodes are still present

        } catch (Exception e) {
            e.printStackTrace();
            fail("Exception occurred during test: " + e.getMessage());
        }
    }

}