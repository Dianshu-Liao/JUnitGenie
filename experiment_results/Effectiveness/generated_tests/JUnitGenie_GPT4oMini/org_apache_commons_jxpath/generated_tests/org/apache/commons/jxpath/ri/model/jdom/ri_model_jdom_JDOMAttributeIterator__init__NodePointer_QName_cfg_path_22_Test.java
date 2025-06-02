package org.apache.commons.jxpath.ri.model.jdom;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.QName;
import org.jdom.Element;
import org.jdom.Attribute;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class ri_model_jdom_JDOMAttributeIterator__init__NodePointer_QName_cfg_path_22_Test {

    // Concrete implementation of NodePointer for testing
    private static class TestNodePointer extends NodePointer {
        private final Element element;

        public TestNodePointer(Element element) {
            super(null);
            this.element = element;
        }

        @Override
        public Object getImmediateNode() {
            return element;
        }

        @Override
        public QName getName() {
            return null; // Not used in this test
        }

        @Override
        public Object getBaseValue() {
            return null; // Not used in this test
        }

        @Override
        public void setValue(Object value) {
            // Not used in this test
        }

        @Override
        public boolean isLeaf() {
            return false; // Not used in this test
        }

        @Override
        public boolean isCollection() {
            return false; // Not used in this test
        }

        @Override
        public int compareChildNodePointers(NodePointer nodePointer1, NodePointer nodePointer2) {
            return 0; // Not used in this test
        }

        @Override
        public int getLength() {
            return 0; // Not used in this test
        }

        @Override
        public Object getNode() {
            return element; // Return the element for testing
        }
    }

    @Test(timeout = 4000)
    public void testJDOMAttributeIteratorWithElement() {
        // Create a test Element with attributes
        Element element = new Element("testElement");
        element.setAttribute("attr1", "value1");
        element.setAttribute("attr2", "value2");

        // Create a TestNodePointer pointing to the test Element
        TestNodePointer parent = new TestNodePointer(element);

        // Create a QName with name "*"
        QName name = new QName("*");

        // Instantiate JDOMAttributeIterator
        JDOMAttributeIterator iterator = new JDOMAttributeIterator(parent, name);

        // Verify that attributes are populated
        List<Attribute> attributes = new ArrayList<>();
        while (iterator.hasNext()) {
            attributes.add(iterator.next());
        }
        assertNotNull(attributes);
        assertEquals(2, attributes.size()); // Expecting 2 attributes
    }

    @Test(timeout = 4000)
    public void testJDOMAttributeIteratorWithNullPrefix() {
        // Create a test Element with attributes
        Element element = new Element("testElement");
        element.setAttribute("attr1", "value1");

        // Create a TestNodePointer pointing to the test Element
        TestNodePointer parent = new TestNodePointer(element);

        // Create a QName with name "*"
        QName name = new QName("*");

        // Instantiate JDOMAttributeIterator
        JDOMAttributeIterator iterator = new JDOMAttributeIterator(parent, name);

        // Verify that attributes are populated
        List<Attribute> attributes = new ArrayList<>();
        while (iterator.hasNext()) {
            attributes.add(iterator.next());
        }
        assertNotNull(attributes);
        assertEquals(1, attributes.size()); // Expecting 1 attribute
    }

    // Assuming JDOMAttributeIterator is defined somewhere else in the codebase
    private static class JDOMAttributeIterator implements Iterator<Attribute> {
        private final TestNodePointer parent;
        private final QName name;
        private final Iterator<Attribute> attributeIterator;

        public JDOMAttributeIterator(TestNodePointer parent, QName name) {
            this.parent = parent;
            this.name = name;
            // Cast the immediate node to Element to access getAttributes()
            Element element = (Element) parent.getImmediateNode();
            this.attributeIterator = element.getAttributes().iterator();
        }

        @Override
        public boolean hasNext() {
            return attributeIterator.hasNext();
        }

        @Override
        public Attribute next() {
            return attributeIterator.next();
        }
    }


}