package org.apache.commons.jxpath.ri.model.beans;
import static org.junit.Assert.*;
import org.junit.Test;
import org.apache.commons.jxpath.ri.model.beans.BeanAttributeIterator;
import org.apache.commons.jxpath.ri.model.beans.PropertyOwnerPointer;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.NodePointer;
import java.util.Locale;

public class ri_model_beans_BeanAttributeIterator__init__PropertyOwnerPointer_QName_cfg_path_17_Test {

    private class TestPropertyOwnerPointer extends PropertyOwnerPointer {
        public TestPropertyOwnerPointer(NodePointer parent, Locale locale) {
            super(parent, locale);
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
        PropertyOwnerPointer parent = new TestPropertyOwnerPointer(null, Locale.getDefault());
        QName name = new QName("test", "prefix");

        try {
            BeanAttributeIterator iterator = new BeanAttributeIterator(parent, name);
            assertNotNull(iterator);
        } catch (Exception e) {
            fail("Initialization of BeanAttributeIterator threw an exception: " + e.getMessage());
        }

        // Further tests can be added to verify behavior of the iterator
    }

    @Test(timeout = 4000)
    public void testBeanAttributeIteratorWithNullPrefix() {
        PropertyOwnerPointer parent = new TestPropertyOwnerPointer(null, Locale.getDefault());
        QName name = new QName("test", null);

        try {
            BeanAttributeIterator iterator = new BeanAttributeIterator(parent, name);
            assertNotNull(iterator);
        } catch (Exception e) {
            fail("Initialization of BeanAttributeIterator threw an exception: " + e.getMessage());
        }
    }


}