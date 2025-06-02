package org.apache.commons.jxpath.ri.model.beans;
import org.apache.commons.jxpath.ri.model.beans.BeanAttributeIterator;
import org.apache.commons.jxpath.ri.model.beans.PropertyOwnerPointer;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.junit.Test;
import static org.junit.Assert.*;

public class ri_model_beans_BeanAttributeIterator__init__PropertyOwnerPointer_QName_cfg_path_10_Test {

    // Creating a concrete implementation of PropertyOwnerPointer for testing
    private static class TestPropertyOwnerPointer extends PropertyOwnerPointer {
        public TestPropertyOwnerPointer(NodePointer base) {
            super(base);
        }

        @Override
        public QName getName() {
            return new QName("lang");
        }

        @Override
        public Object getBaseValue() {
            return null;
        }

        @Override
        public boolean isLeaf() {
            return true;
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
            // Create an instance of TestPropertyOwnerPointer
            TestPropertyOwnerPointer parent = new TestPropertyOwnerPointer(null);
            // Instantiate BeanAttributeIterator
            BeanAttributeIterator iterator = new BeanAttributeIterator(parent, name);
            assertNotNull(iterator);
        } catch (Exception e) {
            fail("Exception thrown during BeanAttributeIterator initialization: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testBeanAttributeIteratorWithWildcardName() {
        try {
            // Create a QName that uses wildcard
            QName name = new QName("xml", "*");
            // Create an instance of TestPropertyOwnerPointer
            TestPropertyOwnerPointer parent = new TestPropertyOwnerPointer(null);
            // Instantiate BeanAttributeIterator
            BeanAttributeIterator iterator = new BeanAttributeIterator(parent, name);
            assertNotNull(iterator);
        } catch (Exception e) {
            fail("Exception thrown during BeanAttributeIterator initialization: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testBeanAttributeIteratorWithNullPrefix() {
        try {
            // Create a QName with a null prefix
            QName name = new QName(null, "lang");
            // Create an instance of TestPropertyOwnerPointer
            TestPropertyOwnerPointer parent = new TestPropertyOwnerPointer(null);
            // Instantiate BeanAttributeIterator
            BeanAttributeIterator iterator = new BeanAttributeIterator(parent, name);
            assertNotNull(iterator);
        } catch (Exception e) {
            fail("Exception thrown during BeanAttributeIterator initialization: " + e.getMessage());
        }
    }

}