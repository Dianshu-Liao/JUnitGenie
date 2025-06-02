package org.apache.commons.jxpath.ri.compiler;

import org.apache.commons.jxpath.ri.EvalContext;
import org.apache.commons.jxpath.ri.InfoSetUtil;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
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
import org.apache.commons.jxpath.ri.axes.NodeSetContext;
import org.apache.commons.jxpath.ri.model.NodePointer;

@ExtendWith(MockitoExtension.class)
class CoreFunction_functionFloor_37_2_Test {

    private CoreFunction coreFunction;

    private EvalContext mockEvalContext;

    @BeforeEach
    void setUp() {
        coreFunction = new CoreFunction(Compiler.FUNCTION_FLOOR, new Expression[] { mock(Expression.class) });
        mockEvalContext = mock(EvalContext.class);
    }

    @Test
    void testFunctionFloor_withValidDouble() {
        when(coreFunction.getArg1().computeValue(mockEvalContext)).thenReturn(3.7);
        Object result = invokeFunctionFloor(coreFunction, mockEvalContext);
        assertEquals(Double.valueOf(3.0), result);
    }

    @Test
    void testFunctionFloor_withNegativeDouble() {
        when(coreFunction.getArg1().computeValue(mockEvalContext)).thenReturn(-3.7);
        Object result = invokeFunctionFloor(coreFunction, mockEvalContext);
        assertEquals(Double.valueOf(-4.0), result);
    }

    @Test
    void testFunctionFloor_withZero() {
        when(coreFunction.getArg1().computeValue(mockEvalContext)).thenReturn(0.0);
        Object result = invokeFunctionFloor(coreFunction, mockEvalContext);
        assertEquals(Double.valueOf(0.0), result);
    }

    @Test
    void testFunctionFloor_withNaN() {
        when(coreFunction.getArg1().computeValue(mockEvalContext)).thenReturn(Double.NaN);
        Object result = invokeFunctionFloor(coreFunction, mockEvalContext);
        assertEquals(Double.NaN, result);
    }

    @Test
    void testFunctionFloor_withInfinite() {
        when(coreFunction.getArg1().computeValue(mockEvalContext)).thenReturn(Double.POSITIVE_INFINITY);
        Object result = invokeFunctionFloor(coreFunction, mockEvalContext);
        assertEquals(Double.POSITIVE_INFINITY, result);
    }

    private Object invokeFunctionFloor(CoreFunction coreFunction, EvalContext context) {
        try {
            Method method = CoreFunction.class.getDeclaredMethod("functionFloor", EvalContext.class);
            method.setAccessible(true);
            return method.invoke(coreFunction, context);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
