package org.apache.commons.jxpath.ri.compiler;

import org.apache.commons.jxpath.ri.EvalContext;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.compiler.Expression;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Collection;
import java.util.Locale;
import org.apache.commons.jxpath.BasicNodeSet;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.JXPathInvalidSyntaxException;
import org.apache.commons.jxpath.NodeSet;
import org.apache.commons.jxpath.ri.Compiler;
import org.apache.commons.jxpath.ri.InfoSetUtil;
import org.apache.commons.jxpath.ri.axes.NodeSetContext;

@ExtendWith(MockitoExtension.class)
class CoreFunction_functionFloor_37_3_Test {

    private static class MockEvalContext extends EvalContext {

        private final NodePointer pointer;

        public MockEvalContext(NodePointer pointer) {
            super(null);
            this.pointer = pointer;
        }

        @Override
        public NodePointer getSingleNodePointer() {
            return pointer;
        }

        @Override
        public NodePointer getCurrentNodePointer() {
            return pointer;
        }

        @Override
        public boolean nextNode() {
            // No need to implement for these tests
            return false;
        }
    }

    private static class MockExpression extends Expression {

        private final Object value;

        public MockExpression(Object value) {
            this.value = value;
        }

        @Override
        public Object compute(EvalContext context) {
            return value;
        }

        @Override
        public Object computeValue(EvalContext context) {
            return compute(context);
        }

        @Override
        public boolean computeContextDependent() {
            // Default implementation
            return false;
        }
    }

    @Test
    void testFunctionFloorWithPositiveValue() {
        CoreFunction function = new CoreFunction(Compiler.FUNCTION_FLOOR, new Expression[] { new MockExpression(3.7) });
        EvalContext context = new MockEvalContext(null);
        Object result = function.functionFloor(context);
        assertEquals(Double.valueOf(3), result);
    }

    @Test
    void testFunctionFloorWithNegativeValue() {
        CoreFunction function = new CoreFunction(Compiler.FUNCTION_FLOOR, new Expression[] { new MockExpression(-2.3) });
        EvalContext context = new MockEvalContext(null);
        Object result = function.functionFloor(context);
        assertEquals(Double.valueOf(-3), result);
    }

    @Test
    void testFunctionFloorWithNaN() {
        CoreFunction function = new CoreFunction(Compiler.FUNCTION_FLOOR, new Expression[] { new MockExpression(Double.NaN) });
        EvalContext context = new MockEvalContext(null);
        Object result = function.functionFloor(context);
        assertTrue(Double.isNaN((Double) result));
    }

    @Test
    void testFunctionFloorWithInfiniteValue() {
        CoreFunction function = new CoreFunction(Compiler.FUNCTION_FLOOR, new Expression[] { new MockExpression(Double.POSITIVE_INFINITY) });
        EvalContext context = new MockEvalContext(null);
        Object result = function.functionFloor(context);
        assertEquals(Double.POSITIVE_INFINITY, result);
    }

    @Test
    void testFunctionFloorWithZero() {
        CoreFunction function = new CoreFunction(Compiler.FUNCTION_FLOOR, new Expression[] { new MockExpression(0) });
        EvalContext context = new MockEvalContext(null);
        Object result = function.functionFloor(context);
        assertEquals(Double.valueOf(0), result);
    }
}
