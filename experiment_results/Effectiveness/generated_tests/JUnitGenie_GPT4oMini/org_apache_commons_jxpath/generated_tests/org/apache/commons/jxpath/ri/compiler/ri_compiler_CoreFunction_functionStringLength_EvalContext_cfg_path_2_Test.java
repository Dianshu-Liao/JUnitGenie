package org.apache.commons.jxpath.ri.compiler;
import org.apache.commons.jxpath.ri.compiler.CoreFunction;
import org.apache.commons.jxpath.ri.EvalContext;
import org.apache.commons.jxpath.ri.compiler.Expression;
import org.apache.commons.jxpath.ri.InfoSetUtil;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.lang.reflect.Method;

public class ri_compiler_CoreFunction_functionStringLength_EvalContext_cfg_path_2_Test {

    private class TestEvalContext extends EvalContext {
        public TestEvalContext(EvalContext parent) {
            super(parent); // Call the superclass constructor with a parent context
        }

        @Override
        public org.apache.commons.jxpath.ri.model.NodePointer getCurrentNodePointer() {
            // Mock implementation
            return null; // Replace with actual NodePointer if needed
        }

        @Override
        public boolean nextNode() {
            // Mock implementation
            return false; // Replace with actual logic if needed
        }
    }

    @Test(timeout = 4000)
    public void testFunctionStringLengthWithArgumentCountZero() {
        try {
            CoreFunction coreFunction = new CoreFunction(1, new Expression[0]);
            TestEvalContext context = new TestEvalContext(null); // Pass null as parent context
            Method method = CoreFunction.class.getDeclaredMethod("functionStringLength", EvalContext.class);
            method.setAccessible(true);
            Object result = method.invoke(coreFunction, context);
            assertEquals(Double.valueOf(0), result); // Assuming the current node pointer returns an empty string
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testFunctionStringLengthWithArgumentCountOne() {
        try {
            // Mocking the necessary components
            Expression mockExpression = new Expression() {
                @Override
                public Object computeValue(EvalContext context) {
                    return "test"; // Mock return value
                }

                @Override
                public Object compute(EvalContext context) {
                    return computeValue(context); // Implementing the abstract method
                }

                @Override
                public boolean computeContextDependent() {
                    return false; // Implementing the abstract method
                }
            };
            CoreFunction coreFunction = new CoreFunction(1, new Expression[]{mockExpression});
            TestEvalContext context = new TestEvalContext(null); // Pass null as parent context
            Method method = CoreFunction.class.getDeclaredMethod("functionStringLength", EvalContext.class);
            method.setAccessible(true);
            Object result = method.invoke(coreFunction, context);
            assertEquals(Double.valueOf(4), result); // Length of "test" is 4
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}