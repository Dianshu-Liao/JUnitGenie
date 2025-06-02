package org.apache.commons.jxpath.ri.model.dynabeans;
import org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPointer;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.beanutils.DynaBean;
import org.junit.Test;
import static org.junit.Assert.*;

public class ri_model_dynabeans_DynaBeanPointer_equals_Object_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testEquals_SameObject() {
        DynaBeanPointer pointer = new DynaBeanPointer(new QName("test"), null, null);
        assertTrue(pointer.equals(pointer));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentType() {
        DynaBeanPointer pointer = new DynaBeanPointer(new QName("test"), null, null);
        String differentTypeObject = "Not a DynaBeanPointer";
        assertFalse(pointer.equals(differentTypeObject));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentObjects() {
        DynaBeanPointer pointer1 = new DynaBeanPointer(new QName("test"), null, null);
        DynaBeanPointer pointer2 = new DynaBeanPointer(new QName("test"), null, null);
        assertTrue(pointer1.equals(pointer2));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentNames() {
        DynaBeanPointer pointer1 = new DynaBeanPointer(new QName("test1"), null, null);
        DynaBeanPointer pointer2 = new DynaBeanPointer(new QName("test2"), null, null);
        assertFalse(pointer1.equals(pointer2));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentIndex() {
        DynaBeanPointer pointer1 = new DynaBeanPointer(new QName("test"), null, null);
        DynaBeanPointer pointer2 = new DynaBeanPointer(new QName("test"), null, null);
        setIndex(pointer1, 1); // Use a setter method to set index
        setIndex(pointer2, 2); // Use a setter method to set index
        assertFalse(pointer1.equals(pointer2));
    }

    @Test(timeout = 4000)
    public void testEquals_WholeCollectionIndex() {
        DynaBeanPointer pointer1 = new DynaBeanPointer(new QName("test"), null, null);
        DynaBeanPointer pointer2 = new DynaBeanPointer(new QName("test"), null, null);
        setIndex(pointer1, DynaBeanPointer.WHOLE_COLLECTION); // Use a setter method to set index
        setIndex(pointer2, DynaBeanPointer.WHOLE_COLLECTION); // Use a setter method to set index
        assertTrue(pointer1.equals(pointer2));
    }

    // Helper method to set index
    private void setIndex(DynaBeanPointer pointer, int index) {
        // Assuming DynaBeanPointer has a method to set index
        // This method should be implemented in the DynaBeanPointer class
        pointer.setIndex(index);
    }

}