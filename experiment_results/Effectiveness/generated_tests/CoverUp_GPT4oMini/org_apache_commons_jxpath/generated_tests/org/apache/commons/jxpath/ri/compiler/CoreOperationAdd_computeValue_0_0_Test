package org.apache.commons.jxpath.ri.compiler;

import org.apache.commons.jxpath.ri.EvalContext;
import org.apache.commons.jxpath.ri.InfoSetUtil;
import org.apache.commons.jxpath.ri.compiler.CoreOperationAdd;
import org.apache.commons.jxpath.ri.compiler.Expression;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class CoreOperationAdd_computeValue_0_0_Test {

    private CoreOperationAdd coreOperationAdd;

    private Expression[] args;

    private EvalContext context;

    @BeforeEach
    public void setUp() {
        // Mocking the Expression array and EvalContext
        args = new Expression[2];
        context = mock(EvalContext.class);
        // Initializing CoreOperationAdd with mocked expressions
        coreOperationAdd = new CoreOperationAdd(args);
    }

    @Test
    public void testComputeValueWithTwoNumberExpressions() {
        Expression expr1 = mock(Expression.class);
        Expression expr2 = mock(Expression.class);
        when(expr1.computeValue(context)).thenReturn(3.0);
        when(expr2.computeValue(context)).thenReturn(5.0);
        args[0] = expr1;
        args[1] = expr2;
        Object result = coreOperationAdd.computeValue(context);
        assertEquals(8.0, result);
    }

    @Test
    public void testComputeValueWithDifferentTypes() {
        Expression expr1 = mock(Expression.class);
        Expression expr2 = mock(Expression.class);
        when(expr1.computeValue(context)).thenReturn(2.0);
        when(expr2.computeValue(context)).thenReturn("3.0");
        args[0] = expr1;
        args[1] = expr2;
        Object result = coreOperationAdd.computeValue(context);
        assertEquals(5.0, result);
    }

    @Test
    public void testComputeValueWithStringAndBooleanExpressions() {
        Expression expr1 = mock(Expression.class);
        Expression expr2 = mock(Expression.class);
        when(expr1.computeValue(context)).thenReturn("4.5");
        when(expr2.computeValue(context)).thenReturn(true);
        args[0] = expr1;
        args[1] = expr2;
        Object result = coreOperationAdd.computeValue(context);
        assertEquals(5.5, result);
    }

    @Test
    public void testComputeValueWithEmptyString() {
        Expression expr1 = mock(Expression.class);
        Expression expr2 = mock(Expression.class);
        when(expr1.computeValue(context)).thenReturn("");
        when(expr2.computeValue(context)).thenReturn(10.0);
        args[0] = expr1;
        args[1] = expr2;
        Object result = coreOperationAdd.computeValue(context);
        assertEquals(10.0, result);
    }

    @Test
    public void testComputeValueWithNaN() {
        Expression expr1 = mock(Expression.class);
        Expression expr2 = mock(Expression.class);
        when(expr1.computeValue(context)).thenReturn("invalid");
        when(expr2.computeValue(context)).thenReturn(5.0);
        args[0] = expr1;
        args[1] = expr2;
        Object result = coreOperationAdd.computeValue(context);
        assertEquals(Double.NaN, result);
    }
}
