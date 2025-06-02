package org.apache.commons.jxpath.ri.model.dynabeans;
import org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPointer;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.beanutils.DynaBean;
import org.junit.Test;
import static org.junit.Assert.*;

public class ri_model_dynabeans_DynaBeanPointer_equals_Object_cfg_path_6_Test {

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
    public void testEquals_DifferentIndex() {
        DynaBeanPointer pointer1 = new DynaBeanPointer(new QName("test"), null, null);
        DynaBeanPointer pointer2 = new DynaBeanPointer(new QName("test"), null, null);
        
        // Instead of directly accessing the index, we will use a method to set the index if available
        pointer1.setIndex(0); // Assuming setIndex method exists
        pointer2.setIndex(1); // Assuming setIndex method exists
        
        assertFalse(pointer1.equals(pointer2));
    }

    @Test(timeout = 4000)
    public void testEquals_NullObject() {
        DynaBeanPointer pointer = new DynaBeanPointer(new QName("test"), null, null);
        assertFalse(pointer.equals(null));
    }


}