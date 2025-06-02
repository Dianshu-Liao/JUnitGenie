package org.apache.commons.jxpath.ri.compiler;

import org.apache.commons.jxpath.ri.EvalContext;
import org.apache.commons.jxpath.ri.axes.UnionContext;
import org.apache.commons.jxpath.ri.compiler.Expression;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.NodeSet;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class CoreOperationUnion_computeValue_0_0_Test {

    private CoreOperationUnion coreOperationUnion;

    @BeforeEach
    public void setUp() {
        // Create an array for Expression
        Expression[] args = new Expression[1];
        coreOperationUnion = new CoreOperationUnion(args);
    }

    @Test
    public void testComputeValue_WithEvalContext() {
        // Arrange
        EvalContext mockContext = mock(EvalContext.class);
        Expression mockExpression = mock(Expression.class);
        when(mockExpression.compute(mockContext)).thenReturn(mockContext);
        // Set the mock expression
        coreOperationUnion.args[0] = mockExpression;
        // Act
        Object result = coreOperationUnion.computeValue(mockContext);
        // Assert
        assertNotNull(result);
        assertTrue(result instanceof UnionContext);
    }

    @Test
    public void testComputeValue_WithConstantValue() {
        // Arrange
        EvalContext mockContext = mock(EvalContext.class);
        Object constantValue = "Test Constant";
        Expression mockExpression = mock(Expression.class);
        when(mockExpression.compute(mockContext)).thenReturn(constantValue);
        when(mockContext.getRootContext().getConstantContext(constantValue)).thenReturn(mockContext);
        // Set the mock expression
        coreOperationUnion.args[0] = mockExpression;
        // Act
        Object result = coreOperationUnion.computeValue(mockContext);
        // Assert
        assertNotNull(result);
        assertTrue(result instanceof UnionContext);
    }

    @Test
    public void testComputeValue_WithMultipleArgs() {
        // Arrange
        EvalContext mockContext = mock(EvalContext.class);
        Expression mockExpression1 = mock(Expression.class);
        Expression mockExpression2 = mock(Expression.class);
        when(mockExpression1.compute(mockContext)).thenReturn(mockContext);
        when(mockExpression2.compute(mockContext)).thenReturn("Another Constant");
        // Set multiple expressions
        coreOperationUnion.args = new Expression[] { mockExpression1, mockExpression2 };
        // Act
        Object result = coreOperationUnion.computeValue(mockContext);
        // Assert
        assertNotNull(result);
        assertTrue(result instanceof UnionContext);
    }

    @Test
    public void testComputeValue_WithNullArgs() {
        // Arrange
        EvalContext mockContext = mock(EvalContext.class);
        // Passing null as an argument
        coreOperationUnion.args = new Expression[] { null };
        // Act
        Object result = coreOperationUnion.computeValue(mockContext);
        // Assert
        assertNotNull(result);
        assertTrue(result instanceof UnionContext);
    }
}
