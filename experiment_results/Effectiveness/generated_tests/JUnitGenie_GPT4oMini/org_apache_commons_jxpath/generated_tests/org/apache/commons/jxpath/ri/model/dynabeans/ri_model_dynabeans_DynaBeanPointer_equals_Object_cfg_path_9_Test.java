package org.apache.commons.jxpath.ri.model.dynabeans;
import org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPointer;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.beanutils.DynaBean;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class ri_model_dynabeans_DynaBeanPointer_equals_Object_cfg_path_9_Test {

    @Test(timeout = 4000)
    public void testEquals_SameObject() {
        DynaBeanPointer pointer = new DynaBeanPointer(new QName("test"), null, null);
        assertTrue(pointer.equals(pointer));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentType() {
        DynaBeanPointer pointer = new DynaBeanPointer(new QName("test"), null, null);
        String differentTypeObject = "Not a DynaBeanPointer";
        assertTrue(!pointer.equals(differentTypeObject));
    }

    @Test(timeout = 4000)
    public void testEquals_EqualObjects() {
        QName name = new QName("test");
        DynaBean dynaBean = null; // Assuming a valid DynaBean instance is created here
        DynaBeanPointer pointer1 = new DynaBeanPointer(name, dynaBean, null);
        DynaBeanPointer pointer2 = new DynaBeanPointer(name, dynaBean, null);
        
        // Ensure that equalObjects method is satisfied
        assertTrue(pointer1.equals(pointer2));
    }

    @Test(timeout = 4000)
    public void testEquals_NullObject() {
        DynaBeanPointer pointer = new DynaBeanPointer(new QName("test"), null, null);
        assertTrue(!pointer.equals(null));
    }

}