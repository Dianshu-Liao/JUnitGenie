package org.apache.commons.jxpath.ri.model.dynabeans;
import org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPointer;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.BasicDynaBean;
import org.apache.commons.beanutils.DynaClass;
import org.apache.commons.beanutils.BasicDynaClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ri_model_dynabeans_DynaBeanPointer_equals_Object_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testEquals_SameObject() {
        DynaBeanPointer pointer = new DynaBeanPointer(new QName("test"), new BasicDynaBean(new BasicDynaClass()), null);
        assertTrue(pointer.equals(pointer));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentType() {
        DynaBeanPointer pointer = new DynaBeanPointer(new QName("test"), new BasicDynaBean(new BasicDynaClass()), null);
        assertFalse(pointer.equals(new Object()));
    }

    @Test(timeout = 4000)
    public void testEquals_Null() {
        DynaBeanPointer pointer = new DynaBeanPointer(new QName("test"), new BasicDynaBean(new BasicDynaClass()), null);
        assertFalse(pointer.equals(null));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentDynaBeanPointer() {
        DynaBeanPointer pointer1 = new DynaBeanPointer(new QName("test1"), new BasicDynaBean(new BasicDynaClass()), null);
        DynaBeanPointer pointer2 = new DynaBeanPointer(new QName("test1"), new BasicDynaBean(new BasicDynaClass()), null);
        assertTrue(pointer1.equals(pointer2));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentName() {
        DynaBeanPointer pointer1 = new DynaBeanPointer(new QName("test1"), new BasicDynaBean(new BasicDynaClass()), null);
        DynaBeanPointer pointer2 = new DynaBeanPointer(new QName("test2"), new BasicDynaBean(new BasicDynaClass()), null);
        assertFalse(pointer1.equals(pointer2));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentIndex() {
        DynaBeanPointer pointer1 = new DynaBeanPointer(new QName("test"), new BasicDynaBean(new BasicDynaClass()), null);
        DynaBeanPointer pointer2 = new DynaBeanPointer(new QName("test"), new BasicDynaBean(new BasicDynaClass()), null);
        // Use reflection to set the index for testing
        setIndex(pointer1, 0);
        setIndex(pointer2, 1);
        assertFalse(pointer1.equals(pointer2));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentDynaBean() {
        DynaBean dynaBean1 = new BasicDynaBean(new BasicDynaClass()); // Using BasicDynaBean with BasicDynaClass
        DynaBean dynaBean2 = new BasicDynaBean(new BasicDynaClass()); // Using BasicDynaBean with BasicDynaClass
        DynaBeanPointer pointer1 = new DynaBeanPointer(new QName("test"), dynaBean1, null);
        DynaBeanPointer pointer2 = new DynaBeanPointer(new QName("test"), dynaBean2, null);
        assertFalse(pointer1.equals(pointer2));
    }

    // Helper method to set index using reflection
    private void setIndex(DynaBeanPointer pointer, int index) {
        try {
            java.lang.reflect.Field field = DynaBeanPointer.class.getDeclaredField("index");
            field.setAccessible(true);
            field.setInt(pointer, index);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}