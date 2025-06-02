package org.apache.commons.jxpath.ri.model.dynabeans;
import org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPointer;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.beanutils.DynaBean;
import org.junit.Test;
import static org.junit.Assert.*;

public class ri_model_dynabeans_DynaBeanPointer_equals_Object_cfg_path_13_Test {

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
    public void testEquals_EqualObjects() {
        QName name = new QName("test");
        DynaBean dynaBean = null; // Assuming a valid DynaBean instance is created here
        DynaBeanPointer pointer1 = new DynaBeanPointer(name, dynaBean, null);
        DynaBeanPointer pointer2 = new DynaBeanPointer(name, dynaBean, null);
        assertTrue(pointer1.equals(pointer2));
    }

    @Test(timeout = 4000)
    public void testEquals_NonEqualObjects() {
        QName name1 = new QName("test1");
        QName name2 = new QName("test2");
        DynaBean dynaBean = null; // Assuming a valid DynaBean instance is created here
        DynaBeanPointer pointer1 = new DynaBeanPointer(name1, dynaBean, null);
        DynaBeanPointer pointer2 = new DynaBeanPointer(name2, dynaBean, null);
        assertFalse(pointer1.equals(pointer2));
    }

    @Test(timeout = 4000)
    public void testEquals_NullObject() {
        DynaBeanPointer pointer = new DynaBeanPointer(new QName("test"), null, null);
        assertFalse(pointer.equals(null));
    }

}