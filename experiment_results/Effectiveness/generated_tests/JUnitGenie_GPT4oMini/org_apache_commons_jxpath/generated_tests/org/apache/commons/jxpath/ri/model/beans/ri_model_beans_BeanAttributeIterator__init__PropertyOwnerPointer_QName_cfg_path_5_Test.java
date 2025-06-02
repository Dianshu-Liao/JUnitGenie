package org.apache.commons.jxpath.ri.model.beans;
import org.apache.commons.jxpath.ri.model.beans.BeanAttributeIterator;
import org.apache.commons.jxpath.ri.model.beans.PropertyOwnerPointer;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.junit.Test;
import static org.junit.Assert.*;

public class ri_model_beans_BeanAttributeIterator__init__PropertyOwnerPointer_QName_cfg_path_5_Test {

    private class TestPropertyOwnerPointer extends PropertyOwnerPointer {
        public TestPropertyOwnerPointer(NodePointer parent) {
            super(parent);
        }

        @Override
        public QName getName() {
            return null; // This will be set in the test
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
            // Create a QName with a non-null prefix
            QName name = new QName("xml", "lang");
            TestPropertyOwnerPointer parent = new TestPropertyOwnerPointer(null);
            BeanAttributeIterator iterator = new BeanAttributeIterator(parent, name);
            assertNotNull(iterator);
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testBeanAttributeIteratorWithNullName() {
        try {
            // Create a QName with a null name
            QName name = new QName(null);
            TestPropertyOwnerPointer parent = new TestPropertyOwnerPointer(null);
            BeanAttributeIterator iterator = new BeanAttributeIterator(parent, name);
            assertNotNull(iterator);
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testBeanAttributeIteratorWithWildcardName() {
        try {
            // Create a QName with a wildcard name
            QName name = new QName("*");
            TestPropertyOwnerPointer parent = new TestPropertyOwnerPointer(null);
            BeanAttributeIterator iterator = new BeanAttributeIterator(parent, name);
            assertNotNull(iterator);
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

}