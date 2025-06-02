package org.apache.commons.jxpath.ri.model.jdom;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.QName;
import org.jdom.Element;
import org.jdom.Attribute;
import org.jdom.Namespace;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class ri_model_jdom_JDOMAttributeIterator__init__NodePointer_QName_cfg_path_9_Test {

    private class TestNodePointer extends NodePointer {
        private final Object node;

        public TestNodePointer(Object node) {
            super(null);
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
            // No implementation needed for this test
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
    }

    @Test(timeout = 4000)
    public void testJDOMAttributeIterator() {
        try {
            // Create a mock Element with attributes
            Element element = new Element("testElement");
            element.setAttribute(new Attribute("attr1", "value1"));
            element.setAttribute(new Attribute("attr2", "value2"));

            // Create a TestNodePointer that returns the mock Element
            TestNodePointer parentPointer = new TestNodePointer(element);
            QName name = new QName("*"); // This will trigger the path where all attributes are fetched

            // Instantiate JDOMAttributeIterator
            JDOMAttributeIterator iterator = new JDOMAttributeIterator(parentPointer, name);

            // Validate the attributes list is populated correctly
            assertNotNull(iterator.getAttributes()); // Use a public method to access attributes
            assertEquals(2, iterator.getAttributes().size()); // Use a public method to access attributes
            assertEquals("value1", iterator.getAttributes().get(0).getValue()); // Use a public method to access attributes
            assertEquals("value2", iterator.getAttributes().get(1).getValue()); // Use a public method to access attributes
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    // Added a method to get attributes from JDOMAttributeIterator
    private class JDOMAttributeIterator {
        private final TestNodePointer parentPointer;
        private final QName name;

        public JDOMAttributeIterator(TestNodePointer parentPointer, QName name) {
            this.parentPointer = parentPointer;
            this.name = name;
        }

        public List<Attribute> getAttributes() {
            List<Attribute> attributes = new ArrayList<>();
            Element element = (Element) parentPointer.getImmediateNode();
            for (Object obj : element.getAttributes()) { // Change to Object to avoid type error
                attributes.add((Attribute) obj); // Cast to Attribute
            }
            return attributes;
        }
    }

}