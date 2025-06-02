package org.apache.commons.jxpath.ri.model.beans;
import org.apache.commons.jxpath.ri.model.beans.BeanAttributeIterator;
import org.apache.commons.jxpath.ri.model.beans.PropertyOwnerPointer;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.junit.Test;
import static org.junit.Assert.*;

public class ri_model_beans_BeanAttributeIterator__init__PropertyOwnerPointer_QName_cfg_path_4_Test {

    private static class TestPropertyOwnerPointer extends PropertyOwnerPointer {
        public TestPropertyOwnerPointer(NodePointer parent) {
            super(parent);
        }

        @Override
        public QName getName() {
            return new QName("testName");
        }

        @Override
        public Object getBaseValue() {
            return null;
        }

        @Override
        public boolean isLeaf() {
            return false;
        }

        @Override
        public boolean isCollection() {
            return false;
        }

        @Override
        public PropertyPointer getPropertyPointer() {
            return null;
        }

        @Override
        public int getLength() {
            return 0;
        }
    }

    @Test(timeout = 4000)
    public void testBeanAttributeIterator() {
        try {
            PropertyOwnerPointer parent = new TestPropertyOwnerPointer(null);
            QName name = new QName("xml", "lang");
            BeanAttributeIterator iterator = new BeanAttributeIterator(parent, name);
            assertNotNull(iterator);
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testBeanAttributeIteratorWithWildcardName() {
        try {
            PropertyOwnerPointer parent = new TestPropertyOwnerPointer(null);
            QName name = new QName("*");
            BeanAttributeIterator iterator = new BeanAttributeIterator(parent, name);
            assertNotNull(iterator);
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }


}