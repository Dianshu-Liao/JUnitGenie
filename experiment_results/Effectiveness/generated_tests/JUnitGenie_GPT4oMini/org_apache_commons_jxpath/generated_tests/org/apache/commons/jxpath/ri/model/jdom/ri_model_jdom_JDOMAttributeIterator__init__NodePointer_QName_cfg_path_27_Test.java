package org.apache.commons.jxpath.ri.model.jdom;
import org.apache.commons.jxpath.ri.model.jdom.JDOMAttributeIterator;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.QName;
import org.jdom.Element;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Locale;

public class ri_model_jdom_JDOMAttributeIterator__init__NodePointer_QName_cfg_path_27_Test {

    private class TestNodePointer extends NodePointer {
        private Object node;

        public TestNodePointer(Object node) {
            super(null, Locale.getDefault()); // Corrected constructor call
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
    public void testJDOMAttributeIteratorWithNonElementNode() {
        try {
            // Create a TestNodePointer that does not return an Element
            TestNodePointer parent = new TestNodePointer(new Object());
            QName name = new QName("testAttribute");

            // Instantiate JDOMAttributeIterator
            JDOMAttributeIterator iterator = new JDOMAttributeIterator(parent, name);

            // Assert that the iterator is initialized correctly
            assertNotNull(iterator);
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }


}