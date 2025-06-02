package org.apache.commons.jxpath.ri.compiler;

import org.apache.commons.jxpath.JXPathInvalidSyntaxException;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
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
import org.apache.commons.jxpath.NodeSet;
import org.apache.commons.jxpath.ri.Compiler;
import org.apache.commons.jxpath.ri.EvalContext;
import org.apache.commons.jxpath.ri.InfoSetUtil;
import org.apache.commons.jxpath.ri.axes.NodeSetContext;
import org.apache.commons.jxpath.ri.model.NodePointer;

public class CoreFunction_assertArgRange_42_0_Test {

    @Test
    public void testAssertArgRange_ValidRange_WithinBounds() throws Exception {
        CoreFunction coreFunction = new CoreFunction(1, new Expression[] {});
        invokeAssertArgRange(coreFunction, 0, 1);
    }

    @Test
    public void testAssertArgRange_ValidRange_AtLowerBound() throws Exception {
        CoreFunction coreFunction = new CoreFunction(1, new Expression[] { Mockito.mock(Expression.class), Mockito.mock(Expression.class) });
        invokeAssertArgRange(coreFunction, 2, 2);
    }

    @Test
    public void testAssertArgRange_ValidRange_AtUpperBound() throws Exception {
        CoreFunction coreFunction = new CoreFunction(1, new Expression[] { Mockito.mock(Expression.class), Mockito.mock(Expression.class) });
        invokeAssertArgRange(coreFunction, 2, 3);
    }

    @Test
    public void testAssertArgRange_InvalidRange_TooFewArguments() throws Exception {
        CoreFunction coreFunction = new CoreFunction(1, new Expression[] {});
        Exception exception = assertThrows(JXPathInvalidSyntaxException.class, () -> {
            invokeAssertArgRange(coreFunction, 1, 2);
        });
        assertEquals("Incorrect number of arguments: " + coreFunction, exception.getMessage());
    }

    @Test
    public void testAssertArgRange_InvalidRange_TooManyArguments() throws Exception {
        CoreFunction coreFunction = new CoreFunction(1, new Expression[] { Mockito.mock(Expression.class), Mockito.mock(Expression.class), Mockito.mock(Expression.class) });
        Exception exception = assertThrows(JXPathInvalidSyntaxException.class, () -> {
            invokeAssertArgRange(coreFunction, 1, 2);
        });
        assertEquals("Incorrect number of arguments: " + coreFunction, exception.getMessage());
    }

    @Test
    public void testAssertArgRange_InvalidRange_ZeroArguments() throws Exception {
        CoreFunction coreFunction = new CoreFunction(1, new Expression[] {});
        Exception exception = assertThrows(JXPathInvalidSyntaxException.class, () -> {
            invokeAssertArgRange(coreFunction, 1, 1);
        });
        assertEquals("Incorrect number of arguments: " + coreFunction, exception.getMessage());
    }

    @Test
    public void testAssertArgRange_ValidRange_ExactlyTwoArguments() throws Exception {
        CoreFunction coreFunction = new CoreFunction(1, new Expression[] { Mockito.mock(Expression.class), Mockito.mock(Expression.class) });
        invokeAssertArgRange(coreFunction, 2, 2);
    }

    @Test
    public void testAssertArgRange_ValidRange_ExactlyThreeArguments() throws Exception {
        CoreFunction coreFunction = new CoreFunction(1, new Expression[] { Mockito.mock(Expression.class), Mockito.mock(Expression.class), Mockito.mock(Expression.class) });
        invokeAssertArgRange(coreFunction, 3, 3);
    }

    private void invokeAssertArgRange(CoreFunction coreFunction, int min, int max) throws Exception {
        Method method = CoreFunction.class.getDeclaredMethod("assertArgRange", int.class, int.class);
        method.setAccessible(true);
        method.invoke(coreFunction, min, max);
    }
}
