package org.apache.commons.jxpath.ri.model.jdom;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.QName;
import org.jdom.Attribute;
import org.jdom.Element;
import org.jdom.Namespace;
import org.junit.Test;
import static org.junit.Assert.*;

public class ri_model_jdom_JDOMAttributeIterator__init__NodePointer_QName_cfg_path_18_Test {

    private class TestNodePointer extends NodePointer {
        private Object node;

        public TestNodePointer(Object node) {
            super(null); // Pass null to the super constructor as NodePointer requires a specific type
            this.node = node;
        }

        @Override
        public Object getImmediateNode() {
            return node;
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
        public void setValue(Object value) {
            // Implementation not needed for this test
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
        public int compareChildNodePointers(NodePointer nodePointer1, NodePointer nodePointer2) {
            return 0;
        }

        @Override
        public int getLength() {
            return 0;
        }

        @Override
        public Object getNode() {
            return node;
        }
    }

    @Test(timeout = 4000)
    public void testJDOMAttributeIterator() {
        try {
            // Create a mock Element with attributes
            Element element = new Element("testElement");
            element.setAttribute("testAttribute", "value");

            // Create a TestNodePointer that returns the mock Element
            TestNodePointer parentPointer = new TestNodePointer(element);
            QName name = new QName("testAttribute");

            // Instantiate JDOMAttributeIterator
            JDOMAttributeIterator iterator = new JDOMAttributeIterator(parentPointer, name);

            // Validate that the attributes list contains the expected attribute
            assertNotNull(iterator);
            // Use reflection to access the private attributes field
            java.lang.reflect.Field attributesField = JDOMAttributeIterator.class.getDeclaredField("attributes");
            attributesField.setAccessible(true);
            Object attributes = attributesField.get(iterator);
            assertNotNull(attributes);
            assertEquals(1, ((java.util.List<?>) attributes).size());
            assertEquals("testAttribute", ((Attribute) ((java.util.List<?>) attributes).get(0)).getName());
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }


}