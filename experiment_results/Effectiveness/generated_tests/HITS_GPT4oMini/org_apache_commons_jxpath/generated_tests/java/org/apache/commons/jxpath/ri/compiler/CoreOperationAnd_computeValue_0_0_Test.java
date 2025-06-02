package org.apache.commons.jxpath.ri.compiler;

import org.apache.commons.jxpath.ri.EvalContext;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.ri.InfoSetUtil;

class CoreOperationAnd_computeValue_0_0_Test {

    @Test
    void testComputeValueAllTrue() {
        // Arrange
        Expression trueExpr1 = mock(Expression.class);
        Expression trueExpr2 = mock(Expression.class);
        when(trueExpr1.computeValue(any(EvalContext.class))).thenReturn(Boolean.TRUE);
        when(trueExpr2.computeValue(any(EvalContext.class))).thenReturn(Boolean.TRUE);
        CoreOperationAnd coreOperationAnd = new CoreOperationAnd(new Expression[] { trueExpr1, trueExpr2 });
        // Act
        Object result = coreOperationAnd.computeValue(mock(EvalContext.class));
        // Assert
        assertEquals(Boolean.TRUE, result);
    }

    @Test
    void testComputeValueOneFalse() {
        // Arrange
        Expression trueExpr = mock(Expression.class);
        Expression falseExpr = mock(Expression.class);
        when(trueExpr.computeValue(any(EvalContext.class))).thenReturn(Boolean.TRUE);
        when(falseExpr.computeValue(any(EvalContext.class))).thenReturn(Boolean.FALSE);
        CoreOperationAnd coreOperationAnd = new CoreOperationAnd(new Expression[] { trueExpr, falseExpr });
        // Act
        Object result = coreOperationAnd.computeValue(mock(EvalContext.class));
        // Assert
        assertEquals(Boolean.FALSE, result);
    }

    @Test
    void testComputeValueAllFalse() {
        // Arrange
        Expression falseExpr1 = mock(Expression.class);
        Expression falseExpr2 = mock(Expression.class);
        when(falseExpr1.computeValue(any(EvalContext.class))).thenReturn(Boolean.FALSE);
        when(falseExpr2.computeValue(any(EvalContext.class))).thenReturn(Boolean.FALSE);
        CoreOperationAnd coreOperationAnd = new CoreOperationAnd(new Expression[] { falseExpr1, falseExpr2 });
        // Act
        Object result = coreOperationAnd.computeValue(mock(EvalContext.class));
        // Assert
        assertEquals(Boolean.FALSE, result);
    }
}
