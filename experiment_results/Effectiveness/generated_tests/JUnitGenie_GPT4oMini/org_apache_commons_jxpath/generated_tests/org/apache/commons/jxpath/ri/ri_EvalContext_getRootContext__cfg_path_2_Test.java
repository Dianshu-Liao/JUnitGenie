package org.apache.commons.jxpath.ri;
import org.apache.commons.jxpath.ri.EvalContext;
import org.apache.commons.jxpath.ri.axes.RootContext;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class ri_EvalContext_getRootContext__cfg_path_2_Test {

    private class TestEvalContext extends EvalContext {
        public TestEvalContext(EvalContext parentContext) {
            super(parentContext);
        }

        @Override
        public NodePointer getCurrentNodePointer() {
            return null; // Implement as needed for the test
        }

        @Override
        public boolean nextNode() {
            return false; // Implement as needed for the test
        }
    }

    @Test(timeout = 4000)
    public void testGetRootContextReturnsNull() {
        // Arrange
        TestEvalContext context = new TestEvalContext(null);
        // Ensure rootContext is null
        context.rootContext = null;

        // Act
        RootContext result = context.getRootContext();

        // Assert
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testGetRootContextWithParentContext() {
        // Arrange
        TestEvalContext parentContext = new TestEvalContext(null);
        parentContext.rootContext = null; // Ensure parent's rootContext is null
        TestEvalContext context = new TestEvalContext(parentContext);

        // Act
        RootContext result = context.getRootContext();

        // Assert
        assertNull(result);
    }

    // Add a method to set rootContext in TestEvalContext for testing purposes
    private void setRootContext(TestEvalContext context, RootContext rootContext) {
        context.rootContext = rootContext;
    }

}