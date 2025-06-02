package org.apache.commons.jxpath.ri.compiler;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
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
import org.apache.commons.jxpath.ri.EvalContext;
import org.apache.commons.jxpath.ri.InfoSetUtil;
import org.apache.commons.jxpath.ri.axes.NodeSetContext;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class CoreFunction_functionFloor_37_0_Test {

    private CoreFunction coreFunction;

    private EvalContext context;

    private Expression mockExpression;

    @BeforeEach
    public void setUp() {
        // Initialize the EvalContext and mock Expression
        context = mock(EvalContext.class);
        mockExpression = mock(Expression.class);
        // Initialize the CoreFunction with a valid function code and args
        coreFunction = new CoreFunction(Compiler.FUNCTION_FLOOR, new Expression[] { mockExpression });
    }

    @Test
    public void testFunctionFloor_ValidPositiveValue() {
        when(mockExpression.computeValue(context)).thenReturn(3.7);
        Object result = invokeFunctionFloor(coreFunction, context);
        assertEquals(Double.valueOf(3), result);
    }

    @Test
    public void testFunctionFloor_ValidNegativeValue() {
        when(mockExpression.computeValue(context)).thenReturn(-2.3);
        Object result = invokeFunctionFloor(coreFunction, context);
        assertEquals(Double.valueOf(-3), result);
    }

    @Test
    public void testFunctionFloor_Zero() {
        when(mockExpression.computeValue(context)).thenReturn(0.0);
        Object result = invokeFunctionFloor(coreFunction, context);
        assertEquals(Double.valueOf(0), result);
    }

    @Test
    public void testFunctionFloor_NaN() {
        when(mockExpression.computeValue(context)).thenReturn(Double.NaN);
        Object result = invokeFunctionFloor(coreFunction, context);
        assertEquals(Double.NaN, result);
    }

    @Test
    public void testFunctionFloor_PositiveInfinity() {
        when(mockExpression.computeValue(context)).thenReturn(Double.POSITIVE_INFINITY);
        Object result = invokeFunctionFloor(coreFunction, context);
        assertEquals(Double.POSITIVE_INFINITY, result);
    }

    @Test
    public void testFunctionFloor_NegativeInfinity() {
        when(mockExpression.computeValue(context)).thenReturn(Double.NEGATIVE_INFINITY);
        Object result = invokeFunctionFloor(coreFunction, context);
        assertEquals(Double.NEGATIVE_INFINITY, result);
    }

    private Object invokeFunctionFloor(CoreFunction coreFunction, EvalContext context) {
        try {
            // Fixed line: Use 'getDeclaredMethod' correctly
            java.lang.reflect.Method method = CoreFunction.class.getDeclaredMethod("functionFloor", EvalContext.class);
            method.setAccessible(true);
            return method.invoke(coreFunction, context);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
