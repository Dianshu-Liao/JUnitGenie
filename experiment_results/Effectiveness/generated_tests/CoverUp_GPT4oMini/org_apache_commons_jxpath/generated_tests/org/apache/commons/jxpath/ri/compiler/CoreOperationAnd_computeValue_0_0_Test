package org.apache.commons.jxpath.ri.compiler;

import org.apache.commons.jxpath.ri.EvalContext;
import org.apache.commons.jxpath.ri.compiler.CoreOperationAnd;
import org.apache.commons.jxpath.ri.compiler.Expression;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.ri.InfoSetUtil;

class CoreOperationAnd_computeValue_0_0_Test {

    private CoreOperationAnd coreOperationAnd;

    private Expression mockExpression1;

    private Expression mockExpression2;

    private EvalContext mockContext;

    @BeforeEach
    void setUp() {
        // Create mock expressions
        mockExpression1 = mock(Expression.class);
        mockExpression2 = mock(Expression.class);
        // Initialize CoreOperationAnd with mock expressions
        coreOperationAnd = new CoreOperationAnd(new Expression[] { mockExpression1, mockExpression2 });
        // Create a mock EvalContext
        mockContext = mock(EvalContext.class);
    }

    @Test
    void testComputeValue_AllTrue() {
        when(mockExpression1.computeValue(mockContext)).thenReturn(Boolean.TRUE);
        when(mockExpression2.computeValue(mockContext)).thenReturn(Boolean.TRUE);
        Object result = coreOperationAnd.computeValue(mockContext);
        assertEquals(Boolean.TRUE, result);
    }

    @Test
    void testComputeValue_OneFalse() {
        when(mockExpression1.computeValue(mockContext)).thenReturn(Boolean.TRUE);
        when(mockExpression2.computeValue(mockContext)).thenReturn(Boolean.FALSE);
        Object result = coreOperationAnd.computeValue(mockContext);
        assertEquals(Boolean.FALSE, result);
    }

    @Test
    void testComputeValue_AllFalse() {
        when(mockExpression1.computeValue(mockContext)).thenReturn(Boolean.FALSE);
        when(mockExpression2.computeValue(mockContext)).thenReturn(Boolean.FALSE);
        Object result = coreOperationAnd.computeValue(mockContext);
        assertEquals(Boolean.FALSE, result);
    }

    @Test
    void testComputeValue_NullExpression() {
        when(mockExpression1.computeValue(mockContext)).thenReturn(null);
        when(mockExpression2.computeValue(mockContext)).thenReturn(Boolean.TRUE);
        Object result = coreOperationAnd.computeValue(mockContext);
        assertEquals(Boolean.FALSE, result);
    }

    @Test
    void testComputeValue_EmptyExpression() {
        when(mockExpression1.computeValue(mockContext)).thenReturn("");
        when(mockExpression2.computeValue(mockContext)).thenReturn(Boolean.TRUE);
        Object result = coreOperationAnd.computeValue(mockContext);
        assertEquals(Boolean.FALSE, result);
    }

    @Test
    void testComputeValue_OnlyFirstFalse() {
        when(mockExpression1.computeValue(mockContext)).thenReturn(Boolean.FALSE);
        when(mockExpression2.computeValue(mockContext)).thenReturn(Boolean.TRUE);
        Object result = coreOperationAnd.computeValue(mockContext);
        assertEquals(Boolean.FALSE, result);
    }

    @Test
    void testComputeValue_OnlySecondFalse() {
        when(mockExpression1.computeValue(mockContext)).thenReturn(Boolean.TRUE);
        when(mockExpression2.computeValue(mockContext)).thenReturn(Boolean.FALSE);
        Object result = coreOperationAnd.computeValue(mockContext);
        assertEquals(Boolean.FALSE, result);
    }
}
