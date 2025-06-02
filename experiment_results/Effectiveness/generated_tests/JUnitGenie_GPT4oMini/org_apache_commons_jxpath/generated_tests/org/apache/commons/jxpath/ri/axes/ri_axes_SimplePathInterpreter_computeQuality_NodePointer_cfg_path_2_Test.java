package org.apache.commons.jxpath.ri.axes;
import org.apache.commons.jxpath.ri.axes.SimplePathInterpreter;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.junit.Test;
import org.apache.commons.jxpath.ri.QName;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class ri_axes_SimplePathInterpreter_computeQuality_NodePointer_cfg_path_2_Test {

    private static class TestNodePointer extends NodePointer {
        private boolean actual;
        private TestNodePointer parent;

        public TestNodePointer(boolean actual, TestNodePointer parent) {
            super(parent);
            this.actual = actual;
            this.parent = parent;
        }

        @Override
        public Object getImmediateNode() {
            return null;
        }

        @Override
        public QName getName() {
            return new QName("localPart", "namespaceURI"); // Return a valid QName instance
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
        public int compareChildNodePointers(NodePointer nodePointer, NodePointer nodePointer1) {
            return 0;
        }

        @Override
        public int getLength() {
            return 1; // Ensure valid length
        }

        @Override
        public NodePointer getImmediateParentPointer() {
            return parent;
        }

        @Override
        public boolean isActual() {
            return actual;
        }
    }

    @Test(timeout = 4000)
    public void testComputeQuality() {
        try {
            Method method = SimplePathInterpreter.class.getDeclaredMethod("computeQuality", NodePointer.class);
            method.setAccessible(true);

            // Create a chain of NodePointers
            TestNodePointer child = new TestNodePointer(false, null);
            TestNodePointer parent = new TestNodePointer(false, child);
            TestNodePointer root = new TestNodePointer(true, parent);

            // Call the method with the root NodePointer
            int quality = (int) method.invoke(null, root);
            assertEquals(1000 - 2, quality); // 1000 - 2 because we have two non-actual nodes
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}