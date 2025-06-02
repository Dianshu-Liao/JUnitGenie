package org.apache.commons.jxpath.ri.compiler;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.text.NumberFormat;
import java.util.Collection;
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

public class CoreFunction_functionFormatNumber_40_0_Test {

    private CoreFunction coreFunction;

    private EvalContext context;

    private Expression arg1;

    private Expression arg2;

    private Expression arg3;

    @BeforeEach
    public void setUp() {
        arg1 = mock(Expression.class);
        arg2 = mock(Expression.class);
        arg3 = mock(Expression.class);
        coreFunction = new CoreFunction(1, new Expression[] { arg1, arg2, arg3 });
        context = mock(EvalContext.class);
    }

    @Test
    public void testFunctionFormatNumberWithTwoArgs() throws Exception {
        when(arg1.computeValue(context)).thenReturn(123.456);
        when(arg2.computeValue(context)).thenReturn("#,##0.00");
        when(context.getCurrentNodePointer()).thenReturn(null);
        when(context.getJXPathContext().getLocale()).thenReturn(Locale.US);
        // Invoke the private method using reflection
        Object result = invokePrivateFunction("functionFormatNumber", context);
        assertEquals("123.46", result);
    }

    @Test
    public void testFunctionFormatNumberWithThreeArgs() throws Exception {
        when(arg1.computeValue(context)).thenReturn(123.456);
        when(arg2.computeValue(context)).thenReturn("#,##0.00");
        when(arg3.computeValue(context)).thenReturn("US");
        when(context.getJXPathContext().getDecimalFormatSymbols("US")).thenReturn(new DecimalFormatSymbols(Locale.US));
        // Invoke the private method using reflection
        Object result = invokePrivateFunction("functionFormatNumber", context);
        assertEquals("123.46", result);
    }

    @Test
    public void testFunctionFormatNumberWithNullPointer() throws Exception {
        when(arg1.computeValue(context)).thenReturn(123.456);
        when(arg2.computeValue(context)).thenReturn("#,##0.00");
        when(context.getCurrentNodePointer()).thenReturn(null);
        when(context.getJXPathContext().getLocale()).thenReturn(Locale.US);
        // Invoke the private method using reflection
        Object result = invokePrivateFunction("functionFormatNumber", context);
        assertEquals("123.46", result);
    }

    @Test
    public void testFunctionFormatNumberWithDifferentLocale() throws Exception {
        when(arg1.computeValue(context)).thenReturn(123456.789);
        when(arg2.computeValue(context)).thenReturn("#,##0.00");
        when(context.getCurrentNodePointer()).thenReturn(null);
        when(context.getJXPathContext().getLocale()).thenReturn(Locale.GERMANY);
        // Invoke the private method using reflection
        Object result = invokePrivateFunction("functionFormatNumber", context);
        // German format
        assertEquals("123.456,79", result);
    }

    private Object invokePrivateFunction(String methodName, EvalContext context) throws Exception {
        java.lang.reflect.Method method = CoreFunction.class.getDeclaredMethod(methodName, EvalContext.class);
        method.setAccessible(true);
        return method.invoke(coreFunction, context);
    }
}
