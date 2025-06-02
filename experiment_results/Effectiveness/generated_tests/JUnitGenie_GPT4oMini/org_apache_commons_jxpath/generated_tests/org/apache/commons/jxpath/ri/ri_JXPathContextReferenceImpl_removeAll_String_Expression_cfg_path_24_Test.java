package org.apache.commons.jxpath.ri;
import org.apache.commons.jxpath.ri.JXPathContextReferenceImpl;
import org.apache.commons.jxpath.ri.compiler.Expression;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.ri.EvalContext;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Iterator;

public class ri_JXPathContextReferenceImpl_removeAll_String_Expression_cfg_path_24_Test {

    private class TestExpression extends Expression {
        @Override
        public Object computeValue(EvalContext context) {
            return new Object(); // Return a non-null value to ensure iteratePointers works
        }

        @Override
        public boolean computeContextDependent() {
            return false;
        }

        @Override
        public Object compute(EvalContext context) {
            return new Object(); // Ensure compute does not return null
        }
    }

    @Test(timeout = 4000)
    public void testRemoveAll() {
        JXPathContext context = JXPathContext.newContext(new Object());
        JXPathContextReferenceImpl jXPathContext = new JXPathContextReferenceImpl(context, new Object());
        String xpath = "some/xpath";
        Expression expr = new TestExpression();

        try {
            jXPathContext.removeAll(xpath, expr);
        } catch (JXPathException e) {
            fail("Expected no exception, but got: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testRemoveAllThrowsException() {
        JXPathContext context = JXPathContext.newContext(new Object());
        JXPathContextReferenceImpl jXPathContext = new JXPathContextReferenceImpl(context, new Object());
        String xpath = "some/xpath";
        Expression expr = new TestExpression() {
            @Override
            public Iterator iteratePointers(EvalContext context) {
                throw new RuntimeException("Simulated exception");
            }
        };

        try {
            jXPathContext.removeAll(xpath, expr);
            fail("Expected JXPathException to be thrown");
        } catch (JXPathException e) {
            assertTrue(e.getMessage().contains("Exception trying to remove all for xpath " + xpath));
        }
    }

}