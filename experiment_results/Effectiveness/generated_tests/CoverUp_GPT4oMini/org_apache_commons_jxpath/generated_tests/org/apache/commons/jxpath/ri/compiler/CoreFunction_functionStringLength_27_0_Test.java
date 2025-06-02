package org.apache.commons.jxpath.ri.compiler;

import org.apache.commons.jxpath.ri.Compiler;
import org.apache.commons.jxpath.ri.EvalContext;
import org.apache.commons.jxpath.ri.InfoSetUtil;
import org.apache.commons.jxpath.ri.compiler.CoreFunction;
import org.apache.commons.jxpath.ri.model.NodePointer;
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
import org.apache.commons.jxpath.JXPathInvalidSyntaxException;
import org.apache.commons.jxpath.NodeSet;
import org.apache.commons.jxpath.ri.axes.NodeSetContext;

class CoreFunction_functionStringLength_27_0_Test {

    private CoreFunction coreFunction;

    private EvalContext evalContext;

    @BeforeEach
    void setUp() {
        coreFunction = new CoreFunction(Compiler.FUNCTION_STRING_LENGTH, null);
        evalContext = mock(EvalContext.class);
    }

    @Test
    void testFunctionStringLengthWithNoArguments() throws Exception {
        NodePointer nodePointer = mock(NodePointer.class);
        when(evalContext.getCurrentNodePointer()).thenReturn(nodePointer);
        when(InfoSetUtil.stringValue(nodePointer)).thenReturn("Hello");
        Method method = CoreFunction.class.getDeclaredMethod("functionStringLength", EvalContext.class);
        method.setAccessible(true);
        Object result = method.invoke(coreFunction, evalContext);
        assertEquals(Double.valueOf(5), result);
    }

    @Test
    void testFunctionStringLengthWithOneArgument() throws Exception {
        // Mocking the argument
        NodePointer arg1Pointer = mock(NodePointer.class);
        when(arg1Pointer.getValue()).thenReturn("World");
        // Mocking the behavior of getArg1
        Expression[] args = new Expression[1];
        args[0] = mock(Expression.class);
        when(args[0].computeValue(evalContext)).thenReturn(arg1Pointer);
        // Set the args in the coreFunction
        Method setArgsMethod = CoreFunction.class.getDeclaredMethod("setArgs", Expression[].class);
        setArgsMethod.setAccessible(true);
        setArgsMethod.invoke(coreFunction, (Object) args);
        Method method = CoreFunction.class.getDeclaredMethod("functionStringLength", EvalContext.class);
        method.setAccessible(true);
        Object result = method.invoke(coreFunction, evalContext);
        assertEquals(Double.valueOf(5), result);
    }

    @Test
    void testFunctionStringLengthWithEmptyString() throws Exception {
        NodePointer nodePointer = mock(NodePointer.class);
        when(evalContext.getCurrentNodePointer()).thenReturn(nodePointer);
        when(InfoSetUtil.stringValue(nodePointer)).thenReturn("");
        Method method = CoreFunction.class.getDeclaredMethod("functionStringLength", EvalContext.class);
        method.setAccessible(true);
        Object result = method.invoke(coreFunction, evalContext);
        assertEquals(Double.valueOf(0), result);
    }

    @Test
    void testFunctionStringLengthWithNull() throws Exception {
        NodePointer nodePointer = mock(NodePointer.class);
        when(evalContext.getCurrentNodePointer()).thenReturn(nodePointer);
        when(InfoSetUtil.stringValue(nodePointer)).thenReturn(null);
        Method method = CoreFunction.class.getDeclaredMethod("functionStringLength", EvalContext.class);
        method.setAccessible(true);
        Object result = method.invoke(coreFunction, evalContext);
        assertEquals(Double.valueOf(0), result);
    }
}
