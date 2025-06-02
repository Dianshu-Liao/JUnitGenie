package org.apache.commons.jxpath.ri.compiler;
import org.apache.commons.jxpath.ri.compiler.ExtensionFunction;
import org.apache.commons.jxpath.ri.EvalContext;
import org.apache.commons.jxpath.JXPathFunctionNotFoundException;
import org.apache.commons.jxpath.ri.QName;
import org.junit.Test;
import static org.junit.Assert.*;

public class ri_compiler_ExtensionFunction_computeValue_EvalContext_cfg_path_7_Test {

    private class TestEvalContext extends EvalContext {
        public TestEvalContext(EvalContext parent) {
            super(parent); // Call the constructor of EvalContext with a parent context
        }

        @Override
        public org.apache.commons.jxpath.ri.model.NodePointer getCurrentNodePointer() {
            // Return a mock NodePointer
            return null; // Replace with realistic implementation as needed
        }

        @Override
        public boolean nextNode() {
            return false; // Replace with realistic implementation as needed
        }

    }

    @Test(timeout = 4000)
    public void testComputeValueFunctionNotFound() {
        QName functionName = new QName("testFunction"); // Use the correct constructor for QName
        ExtensionFunction function = new ExtensionFunction(functionName, null);
        EvalContext context = new TestEvalContext(null); // Pass null as the parent context

        try {
            function.computeValue(context);
            fail("Expected JXPathFunctionNotFoundException to be thrown");
        } catch (JXPathFunctionNotFoundException e) {
            assertNotNull(e);
            assertEquals("No such function: testFunction[]", e.getMessage());
        }
    }


}
