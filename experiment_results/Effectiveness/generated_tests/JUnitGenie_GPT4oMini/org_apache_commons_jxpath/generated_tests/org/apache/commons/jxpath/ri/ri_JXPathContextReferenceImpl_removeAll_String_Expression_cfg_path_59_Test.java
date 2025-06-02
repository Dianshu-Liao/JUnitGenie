package org.apache.commons.jxpath.ri;
import org.apache.commons.jxpath.ri.JXPathContextReferenceImpl;
import org.apache.commons.jxpath.ri.compiler.Expression;
import org.apache.commons.jxpath.ri.EvalContext;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.util.ReverseComparator;
import org.apache.commons.jxpath.JXPathContext;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class ri_JXPathContextReferenceImpl_removeAll_String_Expression_cfg_path_59_Test {

    private class TestExpression extends Expression {
        @Override
        public Object computeValue(EvalContext context) {
            return new ArrayList(); // Return a non-empty list for testing
        }

        @Override
        public boolean computeContextDependent() {
            return false;
        }

        @Override
        public Object compute(EvalContext context) {
            return new ArrayList(); // Return a non-empty list for testing
        }
    }

    @Test(timeout = 4000)
    public void testRemoveAll() {
        JXPathContext context = JXPathContext.newContext(new Object()); // Use JXPathContext's static method to create a context
        JXPathContextReferenceImpl referenceContext = new JXPathContextReferenceImpl(context, new Object());
        String xpath = "some/xpath/expression";
        Expression expr = new TestExpression();

        try {
            referenceContext.removeAll(xpath, expr);
        } catch (JXPathException e) {
            fail("Expected no exception, but got: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testRemoveAllThrowsException() {
        JXPathContext context = JXPathContext.newContext(new Object()); // Use JXPathContext's static method to create a context
        JXPathContextReferenceImpl referenceContext = new JXPathContextReferenceImpl(context, new Object());
        String xpath = "some/xpath/expression";
        Expression expr = new Expression() {
            @Override
            public Object computeValue(EvalContext context) {
                throw new RuntimeException("Forced exception for testing");
            }

            @Override
            public boolean computeContextDependent() {
                return false;
            }

            @Override
            public Object compute(EvalContext context) {
                return null; // Return null to trigger exception
            }
        };

        try {
            referenceContext.removeAll(xpath, expr);
            fail("Expected JXPathException to be thrown");
        } catch (JXPathException e) {
            assertTrue(e.getMessage().contains("Exception trying to remove all for xpath " + xpath));
        }
    }


}