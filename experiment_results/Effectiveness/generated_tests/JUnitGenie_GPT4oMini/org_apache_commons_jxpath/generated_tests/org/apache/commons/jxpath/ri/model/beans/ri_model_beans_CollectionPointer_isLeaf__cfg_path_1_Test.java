package org.apache.commons.jxpath.ri.model.beans;
import org.apache.commons.jxpath.ri.model.beans.CollectionPointer;
import org.apache.commons.jxpath.JXPathIntrospector;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Locale;

public class ri_model_beans_CollectionPointer_isLeaf__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testIsLeafWithNullNode() {
        // Specify the constructor explicitly to avoid ambiguity
        CollectionPointer pointer = new CollectionPointer((Object) null, (Locale) null);
        assertTrue("Expected isLeaf() to return true when node is null", pointer.isLeaf());
    }

    @Test(timeout = 4000)
    public void testIsLeafWithAtomicNode() {
        CollectionPointer pointer = new CollectionPointer("Some atomic value", (Locale) null);
        // Mocking bean info to return atomic
        JXPathIntrospector.getBeanInfo(String.class).isAtomic();
        assertTrue("Expected isLeaf() to return true for atomic node", pointer.isLeaf());
    }

    @Test(timeout = 4000)
    public void testIsLeafWithNonAtomicNode() {
        CollectionPointer pointer = new CollectionPointer(new Object(), (Locale) null);
        // Mocking behavior of non-atomic node
        JXPathIntrospector.getBeanInfo(Object.class).isAtomic();
        assertFalse("Expected isLeaf() to return false for non-atomic node", pointer.isLeaf());
    }


}