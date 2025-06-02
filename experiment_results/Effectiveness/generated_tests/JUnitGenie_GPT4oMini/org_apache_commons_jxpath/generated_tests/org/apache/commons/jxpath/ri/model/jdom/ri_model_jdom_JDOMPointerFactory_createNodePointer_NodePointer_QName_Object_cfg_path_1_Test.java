package org.apache.commons.jxpath.ri.model.jdom;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.model.jdom.JDOMPointerFactory;
import org.apache.commons.jxpath.ri.QName;
import org.jdom.Document;
import org.jdom.Element;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Locale;

public class ri_model_jdom_JDOMPointerFactory_createNodePointer_NodePointer_QName_Object_cfg_path_1_Test {

    private class TestNodePointer extends NodePointer {
        protected TestNodePointer(NodePointer parent) {
            super(parent);
        }

        @Override
        public Object getImmediateNode() {
            return null;
        }

        @Override
        public QName getName() {
            return null;
        }

        @Override
        public Object getBaseValue() {
            return null;
        }

        @Override
        public void setValue(Object value) {
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
    public void testCreateNodePointerWithNonDocumentAndNonElement() {
        JDOMPointerFactory factory = new JDOMPointerFactory();
        NodePointer parent = new TestNodePointer(null); // Pass null as parent
        QName name = new QName("testName");
        Object bean = new Object(); // This is neither Document nor Element

        try {
            NodePointer result = factory.createNodePointer(parent, name, bean);
            assertNull(result); // Expecting null since bean is not a Document or Element
        } catch (Exception e) {
            fail("Exception should not be thrown for valid input: " + e.getMessage());
        }
    }


}