package org.apache.commons.jxpath.ri.model.beans;
import org.apache.commons.jxpath.ri.model.beans.CollectionPointerFactory;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.util.ValueUtils;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Locale;

public class ri_model_beans_CollectionPointerFactory_createNodePointer_NodePointer_QName_Object_cfg_path_1_Test {

    private class TestNodePointer extends NodePointer {
        // Implementing abstract methods
        protected TestNodePointer(NodePointer parent) {
            super(parent);
        }

        @Override
        public Object getImmediateNode() {
            return null;
        }

        @Override
        public QName getName() {
            return new QName("test");
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
            return true;
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
    public void testCreateNodePointerWithCollection() {
        CollectionPointerFactory factory = new CollectionPointerFactory();
        TestNodePointer parent = new TestNodePointer(null);
        QName name = new QName("testName");
        Object bean = new Object[] { "item1", "item2" }; // This should be a collection

        try {
            NodePointer result = factory.createNodePointer(parent, name, bean);
            assertNotNull(result);
            assertTrue(result instanceof CollectionPointer);
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testCreateNodePointerWithNullBean() {
        CollectionPointerFactory factory = new CollectionPointerFactory();
        TestNodePointer parent = new TestNodePointer(null);
        QName name = new QName("testName");
        Object bean = null; // This should not create a CollectionPointer

        try {
            NodePointer result = factory.createNodePointer(parent, name, bean);
            assertNull(result);
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testCreateNodePointerWithNonCollectionBean() {
        CollectionPointerFactory factory = new CollectionPointerFactory();
        TestNodePointer parent = new TestNodePointer(null);
        QName name = new QName("testName");
        Object bean = "not a collection"; // This should not create a CollectionPointer

        try {
            NodePointer result = factory.createNodePointer(parent, name, bean);
            assertNull(result);
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }


}