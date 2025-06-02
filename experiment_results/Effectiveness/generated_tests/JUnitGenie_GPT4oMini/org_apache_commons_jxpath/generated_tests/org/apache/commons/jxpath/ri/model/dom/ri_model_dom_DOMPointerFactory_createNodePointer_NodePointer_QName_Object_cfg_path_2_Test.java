package org.apache.commons.jxpath.ri.model.dom;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.model.dom.DOMPointerFactory;
import org.apache.commons.jxpath.ri.QName;
import org.w3c.dom.Node;
import org.junit.Test;
import static org.junit.Assert.assertNull;
import java.util.Locale;

public class ri_model_dom_DOMPointerFactory_createNodePointer_NodePointer_QName_Object_cfg_path_2_Test {

    private class ConcreteNodePointer extends NodePointer {
        protected ConcreteNodePointer(NodePointer parent) {
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
    public void testCreateNodePointerWithNonNodeBean() {
        DOMPointerFactory factory = new DOMPointerFactory();
        NodePointer parent = new ConcreteNodePointer(null); // Pass null as parent
        QName name = new QName("testName");
        Object bean = new Object(); // Not an instance of Node

        NodePointer result = factory.createNodePointer(parent, name, bean);
        assertNull(result); // Expecting null since bean is not a Node
    }


}