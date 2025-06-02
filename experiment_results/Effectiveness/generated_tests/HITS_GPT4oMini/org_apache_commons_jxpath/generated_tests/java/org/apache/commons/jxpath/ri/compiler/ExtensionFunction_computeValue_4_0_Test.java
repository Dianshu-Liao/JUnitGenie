package org.apache.commons.jxpath.ri.compiler;

import org.apache.commons.jxpath.Function;
import org.apache.commons.jxpath.JXPathFunctionNotFoundException;
import org.apache.commons.jxpath.NodeSet;
import org.apache.commons.jxpath.ri.EvalContext;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.axes.RootContext;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import org.apache.commons.jxpath.ri.axes.NodeSetContext;

public class ExtensionFunction_computeValue_4_0_Test {

    private ExtensionFunction extensionFunction;

    private EvalContext evalContext;

    private QName functionName;

    private Function mockFunction;

    @BeforeEach
    public void setUp() {
        functionName = new QName("testFunction");
        extensionFunction = new ExtensionFunction(functionName, null);
        evalContext = Mockito.mock(EvalContext.class);
        mockFunction = Mockito.mock(Function.class);
    }

    @Test
    public void testComputeValueFunctionNotFound() {
        Mockito.when(evalContext.getRootContext().getFunction(functionName, null)).thenReturn(null);
        JXPathFunctionNotFoundException thrown = assertThrows(JXPathFunctionNotFoundException.class, () -> {
            extensionFunction.computeValue(evalContext);
        });
        assertEquals("No such function: " + functionName + "[]", thrown.getMessage());
    }

    @Test
    public void testComputeValueValidFunction() {
        Object[] parameters = new Object[] { "param1", "param2" };
        Mockito.when(evalContext.getRootContext().getFunction(functionName, parameters)).thenReturn(mockFunction);
        Mockito.when(mockFunction.invoke(evalContext, parameters)).thenReturn("result");
        Object result = extensionFunction.computeValue(evalContext);
        assertEquals("result", result);
    }

    @Test
    public void testComputeValueWithNodeSetReturn() {
        NodeSet nodeSet = Mockito.mock(NodeSet.class);
        Object[] parameters = new Object[] { "param1" };
        Mockito.when(evalContext.getRootContext().getFunction(functionName, parameters)).thenReturn(mockFunction);
        Mockito.when(mockFunction.invoke(evalContext, parameters)).thenReturn(nodeSet);
        Object result = extensionFunction.computeValue(evalContext);
        assertTrue(result instanceof NodeSetContext);
    }

    @Test
    public void testComputeValueWithNullParameters() {
        extensionFunction = new ExtensionFunction(functionName, null);
        Mockito.when(evalContext.getRootContext().getFunction(functionName, null)).thenReturn(mockFunction);
        Mockito.when(mockFunction.invoke(evalContext, null)).thenReturn("nullParamsResult");
        Object result = extensionFunction.computeValue(evalContext);
        assertEquals("nullParamsResult", result);
    }
}
