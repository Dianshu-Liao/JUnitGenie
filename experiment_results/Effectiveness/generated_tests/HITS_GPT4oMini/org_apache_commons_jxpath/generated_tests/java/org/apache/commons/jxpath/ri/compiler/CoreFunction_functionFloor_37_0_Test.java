package org.apache.commons.jxpath.ri.compiler;

import org.apache.commons.jxpath.ri.EvalContext;
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
import org.apache.commons.jxpath.JXPathInvalidSyntaxException;
import org.apache.commons.jxpath.NodeSet;
import org.apache.commons.jxpath.ri.Compiler;
import org.apache.commons.jxpath.ri.InfoSetUtil;
import org.apache.commons.jxpath.ri.axes.NodeSetContext;
import org.apache.commons.jxpath.ri.model.NodePointer;

public class CoreFunction_functionFloor_37_0_Test {

    private CoreFunction coreFunction;

    private EvalContext evalContext;

    @BeforeEach
    public void setUp() {
        coreFunction = new CoreFunction(Compiler.FUNCTION_FLOOR, new Expression[] { mock(Expression.class) });
        evalContext = mock(EvalContext.class);
    }

    @Test
    public void testFunctionFloor_WithValidNumber() {
        when(coreFunction.getArg1().computeValue(evalContext)).thenReturn(3.7);
        Double result = (Double) coreFunction.functionFloor(evalContext);
        assertEquals(Double.valueOf(3), result);
    }

    @Test
    public void testFunctionFloor_WithNegativeNumber() {
        when(coreFunction.getArg1().computeValue(evalContext)).thenReturn(-2.3);
        Double result = (Double) coreFunction.functionFloor(evalContext);
        assertEquals(Double.valueOf(-3), result);
    }

    @Test
    public void testFunctionFloor_WithZero() {
        when(coreFunction.getArg1().computeValue(evalContext)).thenReturn(0.0);
        Double result = (Double) coreFunction.functionFloor(evalContext);
        assertEquals(Double.valueOf(0), result);
    }

    @Test
    public void testFunctionFloor_WithNaN() {
        when(coreFunction.getArg1().computeValue(evalContext)).thenReturn(Double.NaN);
        Double result = (Double) coreFunction.functionFloor(evalContext);
        assertTrue(Double.isNaN(result));
    }

    @Test
    public void testFunctionFloor_WithInfinite() {
        when(coreFunction.getArg1().computeValue(evalContext)).thenReturn(Double.POSITIVE_INFINITY);
        Double result = (Double) coreFunction.functionFloor(evalContext);
        assertEquals(Double.POSITIVE_INFINITY, result);
        when(coreFunction.getArg1().computeValue(evalContext)).thenReturn(Double.NEGATIVE_INFINITY);
        result = (Double) coreFunction.functionFloor(evalContext);
        assertEquals(Double.NEGATIVE_INFINITY, result);
    }

    @Test
    public void testFunctionFloor_ArgumentCountAssertion() {
        // Since the method under test is protected, we cannot directly check the assertion.
        // We can indirectly test it by creating a CoreFunction with an incorrect number of arguments.
        assertThrows(AssertionError.class, () -> {
            new CoreFunction(Compiler.FUNCTION_FLOOR, new Expression[] { mock(Expression.class), mock(Expression.class) });
        });
    }
}
