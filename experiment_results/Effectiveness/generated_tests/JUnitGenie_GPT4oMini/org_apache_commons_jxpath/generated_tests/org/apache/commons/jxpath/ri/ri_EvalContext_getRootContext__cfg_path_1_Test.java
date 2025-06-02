package org.apache.commons.jxpath.ri;
import org.apache.commons.jxpath.ri.EvalContext;
import org.apache.commons.jxpath.ri.axes.RootContext;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class ri_EvalContext_getRootContext__cfg_path_1_Test {

    private class ConcreteEvalContext extends EvalContext {
        public ConcreteEvalContext(EvalContext parent) {
            super(parent);
        }

        @Override
        public NodePointer getCurrentNodePointer() {
            return null; // Implement as needed for your tests
        }

        @Override
        public boolean nextNode() {
            return false; // Implement as needed for your tests
        }
    }

    @Test(timeout = 4000)
    public void testGetRootContext() {
        ConcreteEvalContext context = new ConcreteEvalContext(null);
        // Create a mock or a valid parent context to avoid NullPointerException
        RootContext rootContext = context.getRootContext();
        assertNotNull("RootContext should not be null", rootContext);
    }


}