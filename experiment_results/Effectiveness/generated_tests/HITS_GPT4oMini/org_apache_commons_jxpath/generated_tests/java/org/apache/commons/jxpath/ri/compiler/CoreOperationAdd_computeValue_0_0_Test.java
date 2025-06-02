package org.apache.commons.jxpath.ri.compiler;

import org.apache.commons.jxpath.ri.compiler.Expression;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.Pointer;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.ri.EvalContext;
import org.apache.commons.jxpath.ri.InfoSetUtil;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class CoreOperationAdd_computeValue_0_0_Test {

    private CoreOperationAdd coreOperationAdd;

    private EvalContext evalContext;

    private Expression mockExpression1;

    private Expression mockExpression2;

    @BeforeEach
    public void setUp() {
        mockExpression1 = mock(Expression.class);
        mockExpression2 = mock(Expression.class);
        coreOperationAdd = new CoreOperationAdd(new Expression[] { mockExpression1, mockExpression2 });
        evalContext = mock(EvalContext.class);
    }

    @Test
    public void testComputeValue_withTwoNumericExpressions() {
        when(mockExpression1.computeValue(evalContext)).thenReturn(5);
        when(mockExpression2.computeValue(evalContext)).thenReturn(10);
        Double result = (Double) coreOperationAdd.computeValue(evalContext);
        assertEquals(15.0, result);
    }

    @Test
    public void testComputeValue_withOneNumericAndOneStringExpression() {
        when(mockExpression1.computeValue(evalContext)).thenReturn(3);
        when(mockExpression2.computeValue(evalContext)).thenReturn("4");
        Double result = (Double) coreOperationAdd.computeValue(evalContext);
        assertEquals(7.0, result);
    }

    @Test
    public void testComputeValue_withNonNumericExpressions() {
        when(mockExpression1.computeValue(evalContext)).thenReturn("not a number");
        when(mockExpression2.computeValue(evalContext)).thenReturn(true);
        Double result = (Double) coreOperationAdd.computeValue(evalContext);
        assertEquals(0.0, result);
    }

    @Test
    public void testComputeValue_withEmptyStringExpression() {
        when(mockExpression1.computeValue(evalContext)).thenReturn("");
        when(mockExpression2.computeValue(evalContext)).thenReturn(10);
        Double result = (Double) coreOperationAdd.computeValue(evalContext);
        assertEquals(10.0, result);
    }

    @Test
    public void testComputeValue_withNoExpressions() {
        coreOperationAdd = new CoreOperationAdd(new Expression[] {});
        Double result = (Double) coreOperationAdd.computeValue(evalContext);
        assertEquals(0.0, result);
    }

    @Test
    public void testComputeValue_withNullExpressions() {
        when(mockExpression1.computeValue(evalContext)).thenReturn(null);
        when(mockExpression2.computeValue(evalContext)).thenReturn(null);
        Double result = (Double) coreOperationAdd.computeValue(evalContext);
        assertEquals(0.0, result);
    }
}
