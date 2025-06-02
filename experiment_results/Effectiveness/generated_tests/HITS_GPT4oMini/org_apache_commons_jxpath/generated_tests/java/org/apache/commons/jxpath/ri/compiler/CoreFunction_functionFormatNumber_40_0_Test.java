package org.apache.commons.jxpath.ri.compiler;

import org.apache.commons.jxpath.ri.EvalContext;
import org.apache.commons.jxpath.ri.InfoSetUtil;
import org.apache.commons.jxpath.ri.model.NodePointer;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Collection;
import org.apache.commons.jxpath.BasicNodeSet;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.JXPathInvalidSyntaxException;
import org.apache.commons.jxpath.NodeSet;
import org.apache.commons.jxpath.ri.Compiler;
import org.apache.commons.jxpath.ri.axes.NodeSetContext;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class CoreFunction_functionFormatNumber_40_0_Test {

    private CoreFunction coreFunction;

    private EvalContext context;

    private Expression arg1;

    private Expression arg2;

    private Expression arg3;

    @BeforeEach
    public void setUp() {
        context = mock(EvalContext.class);
        arg1 = mock(Expression.class);
        arg2 = mock(Expression.class);
        arg3 = mock(Expression.class);
        coreFunction = new CoreFunction(Compiler.FUNCTION_FORMAT_NUMBER, new Expression[] { arg1, arg2, arg3 });
    }

    private String invokeFunctionFormatNumber(EvalContext context) throws Exception {
        Method method = CoreFunction.class.getDeclaredMethod("functionFormatNumber", EvalContext.class);
        method.setAccessible(true);
        return (String) method.invoke(coreFunction, context);
    }

    @Test
    public void testFunctionFormatNumber_WithTwoArguments() throws Exception {
        double number = 12345.6789;
        String pattern = "#,##0.00";
        when(arg1.computeValue(context)).thenReturn(number);
        when(arg2.computeValue(context)).thenReturn(pattern);
        when(context.getCurrentNodePointer()).thenReturn(null);
        when(context.getJXPathContext().getLocale()).thenReturn(Locale.US);
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        when(context.getJXPathContext().getDecimalFormatSymbols(anyString())).thenReturn(symbols);
        // Call the function through reflection
        String result = invokeFunctionFormatNumber(context);
        assertEquals("12,345.68", result);
    }

    @Test
    public void testFunctionFormatNumber_WithThreeArguments() throws Exception {
        double number = 12345.6789;
        String pattern = "#,##0.00";
        String symbolsName = "US";
        when(arg1.computeValue(context)).thenReturn(number);
        when(arg2.computeValue(context)).thenReturn(pattern);
        when(arg3.computeValue(context)).thenReturn(symbolsName);
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        when(context.getJXPathContext().getDecimalFormatSymbols(symbolsName)).thenReturn(symbols);
        // Call the function through reflection
        String result = invokeFunctionFormatNumber(context);
        assertEquals("12,345.68", result);
    }

    @Test
    public void testFunctionFormatNumber_WithInvalidNumber() throws Exception {
        String invalidNumber = "invalid";
        String pattern = "#,##0.00";
        when(arg1.computeValue(context)).thenReturn(invalidNumber);
        when(arg2.computeValue(context)).thenReturn(pattern);
    }
}
