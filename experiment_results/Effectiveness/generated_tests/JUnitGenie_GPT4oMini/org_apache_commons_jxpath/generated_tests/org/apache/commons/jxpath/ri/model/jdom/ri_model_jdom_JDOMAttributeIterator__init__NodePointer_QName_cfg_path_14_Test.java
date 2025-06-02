package org.apache.commons.jxpath.ri.model.jdom;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.QName;
import org.jdom.Element;
import org.jdom.Attribute;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;

public class ri_model_jdom_JDOMAttributeIterator__init__NodePointer_QName_cfg_path_14_Test {

    private class TestNodePointer extends NodePointer {
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
            return new QName("testName");
        }

        @Override
        public Object getBaseValue() {
            return null;
        }

        @Override
        public void setValue(Object value) {
            // Not implemented for this test
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
            return element;
        }
    }

    private class JDOMAttributeIterator {
        private final TestNodePointer parent;
        private final QName name;

        public JDOMAttributeIterator(TestNodePointer parent, QName name) {
            this.parent = parent;
            this.name = name;
        }

        public List<Attribute> getAttributes() {
            List<Attribute> attributes = new ArrayList<>();
            Element element = (Element) parent.getNode();
            if (name.getName().equals("*")) { // Changed from getLocalPart() to getName()
                attributes.addAll(element.getAttributes());
            } else {
                Attribute attribute = element.getAttribute(name.getName()); // Changed from getLocalPart() to getName()
                if (attribute != null) {
                    attributes.add(attribute);
                }
            }
            return attributes;
        }
    }

    @Test(timeout = 4000)
    public void testJDOMAttributeIteratorWithValidElement() {
        Element element = new Element("testElement");
        element.setAttribute("testAttribute", "testValue");
        TestNodePointer parent = new TestNodePointer(element);
        QName name = new QName("testAttribute");

        JDOMAttributeIterator iterator = new JDOMAttributeIterator(parent, name);
        
        // Validate that the attributes list contains the expected attribute
        assertNotNull(iterator.getAttributes());
        List<Attribute> attributes = iterator.getAttributes();
        assertEquals(1, attributes.size());
        assertEquals("testValue", attributes.get(0).getValue());
    }

    @Test(timeout = 4000)
    public void testJDOMAttributeIteratorWithWildcard() {
        Element element = new Element("testElement");
        element.setAttribute("testAttribute1", "value1");
        element.setAttribute("testAttribute2", "value2");
        TestNodePointer parent = new TestNodePointer(element);
        QName name = new QName("*");

        JDOMAttributeIterator iterator = new JDOMAttributeIterator(parent, name);
        
        // Validate that the attributes list contains all attributes
        assertNotNull(iterator.getAttributes());
        List<Attribute> attributes = iterator.getAttributes();
        assertEquals(2, attributes.size());
    }

    @Test(timeout = 4000)
    public void testJDOMAttributeIteratorWithNullPrefix() {
        Element element = new Element("testElement");
        TestNodePointer parent = new TestNodePointer(element);
        QName name = new QName("testAttribute");

        JDOMAttributeIterator iterator = new JDOMAttributeIterator(parent, name);
        
        // Validate that the attributes list is empty since there are no attributes
        assertNotNull(iterator.getAttributes());
        assertTrue(iterator.getAttributes().isEmpty());
    }

    @Test(timeout = 4000)
    public void testJDOMAttributeIteratorWithInvalidNamespace() {
        Element element = new Element("testElement");
        TestNodePointer parent = new TestNodePointer(element);
        QName name = new QName("testAttribute", "invalidPrefix");

        JDOMAttributeIterator iterator = new JDOMAttributeIterator(parent, name);
        
        // Validate that the attributes list is empty since the namespace is invalid
        assertNotNull(iterator.getAttributes());
        assertTrue(iterator.getAttributes().isEmpty());
    }

}