package org.apache.commons.jxpath.ri.model.beans;
import org.apache.commons.jxpath.ri.model.beans.CollectionPointer;
import org.apache.commons.jxpath.JXPathIntrospector;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import java.util.Locale;

public class ri_model_beans_CollectionPointer_isLeaf__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testIsLeafWithNullNode() {
        CollectionPointer pointer = new CollectionPointer((Object) null, Locale.getDefault()); // Cast to Object to resolve ambiguity
        boolean result = pointer.isLeaf();
        assertTrue("Expected isLeaf() to return true when node is null", result);
    }

    @Test(timeout = 4000)
    public void testIsLeafWithAtomicNode() {
        // Create a mock object that simulates an atomic class
        Object atomicNode = new String("test");
        CollectionPointer pointer = new CollectionPointer(atomicNode, Locale.getDefault()); // Specify Locale to resolve ambiguity
        
        try {
            boolean result = pointer.isLeaf();
            assertTrue("Expected isLeaf() to return true for atomic node", result);
        } catch (Exception e) {
            // Handle the exception as per rule 4
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIsLeafWithNonAtomicNode() {
        // Create a mock object that simulates a non-atomic class
        Object nonAtomicNode = new Object(); // Replace with a proper non-atomic class if needed
        CollectionPointer pointer = new CollectionPointer(nonAtomicNode, Locale.getDefault()); // Specify Locale to resolve ambiguity
        
        try {
            boolean result = pointer.isLeaf();
            assertFalse("Expected isLeaf() to return false for non-atomic node", result);
        } catch (Exception e) {
            // Handle the exception as per rule 4
            e.printStackTrace();
        }
    }

}