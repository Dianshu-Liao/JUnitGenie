package org.apache.commons.jxpath.ri.compiler;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.apache.commons.jxpath.ri.compiler.CoreFunction;
import org.apache.commons.jxpath.ri.EvalContext;
import org.apache.commons.jxpath.ri.compiler.Expression;
import org.junit.Test;
import java.lang.reflect.Method;

public class ri_compiler_CoreFunction_functionFloor_EvalContext_cfg_path_1_Test {

    private class MockEvalContext extends EvalContext {
        public MockEvalContext(EvalContext parent) {
            super(parent); // Call the constructor of EvalContext with a parent context
        }

        @Override
        public org.apache.commons.jxpath.ri.model.NodePointer getCurrentNodePointer() {
            // Implement this method as needed for your test
            return null;
        }

        @Override
        public boolean nextNode() {
            // Implement this method as needed for your test
            return false;
        }
    }

    private class MockExpression extends Expression {
        private Object value;

        public MockExpression(Object value) {
            this.value = value;
        }

        @Override
        public Object computeValue(EvalContext context) {
            return value;
        }

        @Override
        public Object compute(EvalContext context) {
            return computeValue(context); // Implement the abstract method
        }

        @Override
        public boolean computeContextDependent() {
            return false; // Implement the abstract method
        }
    }

    @Test(timeout = 4000)
    public void testFunctionFloorWithValidNumber() {
        try {
            CoreFunction coreFunction = new CoreFunction(1, new Expression[]{new MockExpression(3.14)});
            MockEvalContext context = new MockEvalContext(null); // Pass null as parent context
            
            Method method = CoreFunction.class.getDeclaredMethod("functionFloor", EvalContext.class);
            method.setAccessible(true);
            Object result = method.invoke(coreFunction, context);

            assertEquals(Double.valueOf(Math.floor(3.14)), result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testFunctionFloorWithNaN() {
        try {
            CoreFunction coreFunction = new CoreFunction(1, new Expression[]{new MockExpression(Double.NaN)});
            MockEvalContext context = new MockEvalContext(null); // Pass null as parent context
            
            Method method = CoreFunction.class.getDeclaredMethod("functionFloor", EvalContext.class);
            method.setAccessible(true);
            Object result = method.invoke(coreFunction, context);

            assertTrue(result instanceof Double);
            assertEquals(Double.NaN, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testFunctionFloorWithInfinite() {
        try {
            CoreFunction coreFunction = new CoreFunction(1, new Expression[]{new MockExpression(Double.POSITIVE_INFINITY)});
            MockEvalContext context = new MockEvalContext(null); // Pass null as parent context
            
            Method method = CoreFunction.class.getDeclaredMethod("functionFloor", EvalContext.class);
            method.setAccessible(true);
            Object result = method.invoke(coreFunction, context);

            assertTrue(result instanceof Double);
            assertEquals(Double.POSITIVE_INFINITY, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}