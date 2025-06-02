package org.apache.commons.jxpath.ri.model.dynabeans;
import org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPointer;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.BasicDynaBean;
import org.apache.commons.beanutils.DynaClass;
import org.apache.commons.beanutils.DynaProperty;
import org.junit.Test;
import static org.junit.Assert.*;

public class ri_model_dynabeans_DynaBeanPointer_equals_Object_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testEquals_SameObject() {
        DynaBeanPointer pointer = new DynaBeanPointer(new QName("test"), new BasicDynaBean(new DynaClassImpl()), null);
        assertTrue(pointer.equals(pointer));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentType() {
        DynaBeanPointer pointer = new DynaBeanPointer(new QName("test"), new BasicDynaBean(new DynaClassImpl()), null);
        assertFalse(pointer.equals(new Object()));
    }

    @Test(timeout = 4000)
    public void testEquals_Null() {
        DynaBeanPointer pointer = new DynaBeanPointer(new QName("test"), new BasicDynaBean(new DynaClassImpl()), null);
        assertFalse(pointer.equals(null));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentDynaBeanPointer() {
        DynaBean dynaBean1 = new BasicDynaBean(new DynaClassImpl());
        DynaBean dynaBean2 = new BasicDynaBean(new DynaClassImpl());
        DynaBeanPointer pointer1 = new DynaBeanPointer(new QName("test1"), dynaBean1, null);
        DynaBeanPointer pointer2 = new DynaBeanPointer(new QName("test1"), dynaBean2, null);
        assertFalse(pointer1.equals(pointer2));
    }

    @Test(timeout = 4000)
    public void testEquals_SameDynaBeanPointer() {
        DynaBean dynaBean = new BasicDynaBean(new DynaClassImpl());
        DynaBeanPointer pointer1 = new DynaBeanPointer(new QName("test"), dynaBean, null);
        DynaBeanPointer pointer2 = new DynaBeanPointer(new QName("test"), dynaBean, null);
        assertTrue(pointer1.equals(pointer2));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentIndex() {
        DynaBeanPointer pointer1 = new DynaBeanPointer(new QName("test"), new BasicDynaBean(new DynaClassImpl()), null);
        DynaBeanPointer pointer2 = new DynaBeanPointer(new QName("test"), new BasicDynaBean(new DynaClassImpl()), null);
        // Assuming we can set the index through a method or constructor instead of directly
        pointer1.setIndex(0); // Assuming setIndex is a method to set the index
        pointer2.setIndex(1); // Assuming setIndex is a method to set the index
        assertFalse(pointer1.equals(pointer2));
    }

    // Dummy implementation of DynaClass for testing purposes
    private static class DynaClassImpl implements DynaClass {
        @Override
        public String getName() {
            return "DynaClassImpl";
        }

        @Override
        public DynaBean newInstance() {
            return new BasicDynaBean(this);
        }



        @Override
        public DynaProperty getDynaProperty(String name) {
            return null; // Return null for simplicity
        }

        @Override
        public DynaProperty[] getDynaProperties() {
            return new DynaProperty[0]; // Return an empty array for simplicity
        }
    }

}
