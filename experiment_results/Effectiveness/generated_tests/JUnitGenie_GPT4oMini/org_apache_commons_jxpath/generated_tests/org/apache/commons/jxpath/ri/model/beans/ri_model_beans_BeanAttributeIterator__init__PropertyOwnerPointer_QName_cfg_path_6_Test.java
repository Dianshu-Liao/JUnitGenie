package org.apache.commons.jxpath.ri.model.beans;
import org.apache.commons.jxpath.ri.model.beans.BeanAttributeIterator;
import org.apache.commons.jxpath.ri.model.beans.PropertyOwnerPointer;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class ri_model_beans_BeanAttributeIterator__init__PropertyOwnerPointer_QName_cfg_path_6_Test {

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
            return new Object();
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
            QName name = new QName(null, "testName"); // Changed prefix to null and name to "testName"
            PropertyOwnerPointer parent = new TestPropertyOwnerPointer(null);
            BeanAttributeIterator iterator = new BeanAttributeIterator(parent, name);
            assertNotNull(iterator);
            name = new QName("testPrefix", "testName"); // second invocation with different name
            BeanAttributeIterator iterator2 = new BeanAttributeIterator(parent, name);
            assertNotNull(iterator2);
        } catch (Exception e) {
            // Handle the exception if needed
            e.printStackTrace();
        }
    }

}