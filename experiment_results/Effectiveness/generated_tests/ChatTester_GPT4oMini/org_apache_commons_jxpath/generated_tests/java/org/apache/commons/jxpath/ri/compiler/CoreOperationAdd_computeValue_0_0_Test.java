package org.apache.commons.jxpath.ri.compiler;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.ri.EvalContext;
import org.apache.commons.jxpath.ri.InfoSetUtil;

public class CoreOperationAdd_computeValue_0_0_Test {

    private CoreOperationAdd coreOperationAdd;

    private Expression[] expressions;

    private EvalContext evalContext;

    @BeforeEach
    public void setUp() {
        // Mock the dependencies
        expressions = new Expression[3];
        for (int i = 0; i < expressions.length; i++) {
            expressions[i] = mock(Expression.class);
        }
        evalContext = mock(EvalContext.class);
        // Initialize the CoreOperationAdd with mocked expressions
        coreOperationAdd = new CoreOperationAdd(expressions);
    }

    @Test
    public void testComputeValue_SumOfValues() {
        // Arrange: Set up the expected behavior of the mocked expressions
        when(expressions[0].computeValue(evalContext)).thenReturn(2.0);
        when(expressions[1].computeValue(evalContext)).thenReturn(3.0);
        when(expressions[2].computeValue(evalContext)).thenReturn(5.0);
        // Act: Call the computeValue method
        Object result = coreOperationAdd.computeValue(evalContext);
        // Assert: Verify the result
        assertEquals(Double.valueOf(10.0), result);
    }

    @Test
    public void testComputeValue_EmptyExpressions() {
        // Arrange: Create an instance with no expressions
        coreOperationAdd = new CoreOperationAdd(new Expression[0]);
        // Act: Call the computeValue method
        Object result = coreOperationAdd.computeValue(evalContext);
        // Assert: Verify the result
        assertEquals(Double.valueOf(0.0), result);
    }

    @Test
    public void testComputeValue_NegativeValues() {
        // Arrange: Set up the expected behavior of the mocked expressions with negative values
        when(expressions[0].computeValue(evalContext)).thenReturn(-1.0);
        when(expressions[1].computeValue(evalContext)).thenReturn(-2.0);
        when(expressions[2].computeValue(evalContext)).thenReturn(-3.0);
        // Act: Call the computeValue method
        Object result = coreOperationAdd.computeValue(evalContext);
        // Assert: Verify the result
        assertEquals(Double.valueOf(-6.0), result);
    }

    @Test
    public void testComputeValue_MixedValues() {
        // Arrange: Set up the expected behavior of the mocked expressions with mixed values
        when(expressions[0].computeValue(evalContext)).thenReturn(4.0);
        when(expressions[1].computeValue(evalContext)).thenReturn(-2.0);
        when(expressions[2].computeValue(evalContext)).thenReturn(3.0);
        // Act: Call the computeValue method
        Object result = coreOperationAdd.computeValue(evalContext);
        // Assert: Verify the result
        assertEquals(Double.valueOf(5.0), result);
    }

    @Test
    public void testComputeValue_AllZeroValues() {
        // Arrange: Set up the expected behavior of the mocked expressions with all zero values
        when(expressions[0].computeValue(evalContext)).thenReturn(0.0);
        when(expressions[1].computeValue(evalContext)).thenReturn(0.0);
        when(expressions[2].computeValue(evalContext)).thenReturn(0.0);
        // Act: Call the computeValue method
        Object result = coreOperationAdd.computeValue(evalContext);
        // Assert: Verify the result
        assertEquals(Double.valueOf(0.0), result);
    }
}
