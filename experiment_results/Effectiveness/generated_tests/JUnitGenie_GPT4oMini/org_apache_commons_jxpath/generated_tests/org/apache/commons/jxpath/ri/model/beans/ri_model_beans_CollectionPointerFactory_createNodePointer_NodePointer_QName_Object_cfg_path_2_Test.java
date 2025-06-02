package org.apache.commons.jxpath.ri.model.beans;
import org.apache.commons.jxpath.ri.model.beans.CollectionPointerFactory;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.Container;
import org.junit.Test;
import static org.junit.Assert.assertNull;
import java.util.Locale;

public class ri_model_beans_CollectionPointerFactory_createNodePointer_NodePointer_QName_Object_cfg_path_2_Test {

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
            return new QName("test");
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
    public void testCreateNodePointerWithNullBean() {
        CollectionPointerFactory factory = new CollectionPointerFactory();
        NodePointer parent = new TestNodePointer(null); // Pass null as parent
        QName name = new QName("testName");
        Object bean = new Container() {
            @Override
            public Object getValue() {
                return null; // This satisfies the constraint
            }

            @Override
            public void setValue(Object value) {
                // No implementation needed for this test
            }
        };

        try {
            NodePointer result = factory.createNodePointer(parent, name, bean);
            assertNull(result); // Expecting null since bean is not a collection
        } catch (Exception e) {
            // Handle the exception as per rule 4
            e.printStackTrace();
        }
    }


}