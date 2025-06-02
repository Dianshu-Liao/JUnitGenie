package org.apache.commons.jxpath.ri.compiler;

import org.apache.commons.jxpath.ri.EvalContext;
import org.apache.commons.jxpath.ri.axes.RootContext;
import org.apache.commons.jxpath.ri.compiler.CoreOperationUnion;
import org.apache.commons.jxpath.ri.compiler.Expression;
import org.apache.commons.jxpath.ri.axes.UnionContext;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

class CoreOperationUnion_computeValue_0_1_Test {

    private CoreOperationUnion coreOperationUnion;

    private Expression[] mockExpressions;

    private EvalContext mockContext;

    private RootContext mockRootContext;

    @BeforeEach
    void setUp() {
        // Adjust number of expressions as needed
        mockExpressions = new Expression[2];
        mockContext = mock(EvalContext.class);
        mockRootContext = mock(RootContext.class);
        when(mockContext.getRootContext()).thenReturn(mockRootContext);
        coreOperationUnion = new CoreOperationUnion(mockExpressions);
    }

    @Test
    void testComputeValue_WithEvalContext() throws Exception {
        // Mocking the behavior of the expressions
        for (int i = 0; i < mockExpressions.length; i++) {
            Expression mockExpression = mock(Expression.class);
            // Simulating EvalContext return
            Object mockValue = mock(EvalContext.class);
            when(mockExpression.compute(mockContext)).thenReturn(mockValue);
            mockExpressions[i] = mockExpression;
        }
        // Invoke the computeValue method
        Method method = CoreOperationUnion.class.getDeclaredMethod("computeValue", EvalContext.class);
        method.setAccessible(true);
        UnionContext result = (UnionContext) method.invoke(coreOperationUnion, mockContext);
        // Assert that the result is not null and is an instance of UnionContext
        assertNotNull(result);
    }

    @Test
    void testComputeValue_WithConstantValue() throws Exception {
        // Mocking the behavior of the expressions to return a constant value
        for (int i = 0; i < mockExpressions.length; i++) {
            Expression mockExpression = mock(Expression.class);
            // Simulating a constant return
            Object constantValue = "constantValue";
            when(mockExpression.compute(mockContext)).thenReturn(constantValue);
            mockExpressions[i] = mockExpression;
        }
        // Invoke the computeValue method
        Method method = CoreOperationUnion.class.getDeclaredMethod("computeValue", EvalContext.class);
        method.setAccessible(true);
        UnionContext result = (UnionContext) method.invoke(coreOperationUnion, mockContext);
        // Assert that the result is not null and is an instance of UnionContext
        assertNotNull(result);
    }
}
