package org.apache.commons.jxpath.ri.compiler;

import org.apache.commons.jxpath.Function;
import org.apache.commons.jxpath.JXPathFunctionNotFoundException;
import org.apache.commons.jxpath.NodeSet;
import org.apache.commons.jxpath.ri.EvalContext;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.axes.RootContext;
import org.apache.commons.jxpath.ri.compiler.ExtensionFunction;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import org.apache.commons.jxpath.ri.axes.NodeSetContext;

class ExtensionFunction_computeValue_4_0_Test {

    private ExtensionFunction extensionFunction;

    private QName functionName;

    private EvalContext context;

    private Function mockFunction;

    @BeforeEach
    void setUp() {
        functionName = new QName("testFunction");
        extensionFunction = new ExtensionFunction(functionName, null);
        context = mock(EvalContext.class);
        mockFunction = mock(Function.class);
    }

    @Test
    void testComputeValue_functionNotFound() {
        when(context.getRootContext().getFunction(functionName, null)).thenReturn(null);
        JXPathFunctionNotFoundException exception = assertThrows(JXPathFunctionNotFoundException.class, () -> {
            extensionFunction.computeValue(context);
        });
        assertEquals("No such function: " + functionName + null, exception.getMessage());
    }

    @Test
    void testComputeValue_functionFound() {
        Object[] parameters = new Object[] { 1, 2 };
        when(context.getRootContext().getFunction(functionName, parameters)).thenReturn(mockFunction);
        when(mockFunction.invoke(context, parameters)).thenReturn(3);
        Object result = extensionFunction.computeValue(context);
        assertEquals(3, result);
        verify(mockFunction).invoke(context, parameters);
    }

    @Test
    void testComputeValue_functionReturnsNodeSet() {
        NodeSet mockNodeSet = mock(NodeSet.class);
        when(context.getRootContext().getFunction(functionName, null)).thenReturn(mockFunction);
        when(mockFunction.invoke(context, null)).thenReturn(mockNodeSet);
        Object result = extensionFunction.computeValue(context);
        assertTrue(result instanceof NodeSet);
        assertNotNull(result);
        verify(mockFunction).invoke(context, null);
    }

    @Test
    void testComputeValue_withParameters() throws Exception {
        Object[] parameters = new Object[] { 42 };
        extensionFunction = new ExtensionFunction(functionName, new Expression[] { mock(Expression.class) });
        when(context.getRootContext().getFunction(functionName, new Object[] { 42 })).thenReturn(mockFunction);
        when(mockFunction.invoke(context, new Object[] { 42 })).thenReturn("result");
        Method computeValueMethod = ExtensionFunction.class.getDeclaredMethod("computeValue", EvalContext.class);
        computeValueMethod.setAccessible(true);
        Object result = computeValueMethod.invoke(extensionFunction, context);
        assertEquals("result", result);
        verify(mockFunction).invoke(context, new Object[] { 42 });
    }
}
