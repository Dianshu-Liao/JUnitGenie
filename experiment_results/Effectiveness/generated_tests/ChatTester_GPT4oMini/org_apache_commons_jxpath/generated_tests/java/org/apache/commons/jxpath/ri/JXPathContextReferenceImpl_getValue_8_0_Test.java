// Test method
package org.apache.commons.jxpath.ri;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Vector;
import org.apache.commons.jxpath.CompiledExpression;
import org.apache.commons.jxpath.ExceptionHandler;
import org.apache.commons.jxpath.Function;
import org.apache.commons.jxpath.Functions;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.JXPathFunctionNotFoundException;
import org.apache.commons.jxpath.JXPathInvalidSyntaxException;
import org.apache.commons.jxpath.JXPathNotFoundException;
import org.apache.commons.jxpath.JXPathTypeConversionException;
import org.apache.commons.jxpath.Pointer;
import org.apache.commons.jxpath.ri.axes.InitialContext;
import org.apache.commons.jxpath.ri.axes.RootContext;
import org.apache.commons.jxpath.ri.compiler.Expression;
import org.apache.commons.jxpath.ri.compiler.LocationPath;
import org.apache.commons.jxpath.ri.compiler.Path;
import org.apache.commons.jxpath.ri.compiler.TreeCompiler;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.model.NodePointerFactory;
import org.apache.commons.jxpath.ri.model.VariablePointerFactory;
import org.apache.commons.jxpath.ri.model.beans.BeanPointerFactory;
import org.apache.commons.jxpath.ri.model.beans.CollectionPointerFactory;
import org.apache.commons.jxpath.ri.model.container.ContainerPointerFactory;
import org.apache.commons.jxpath.ri.model.dynamic.DynamicPointerFactory;
import org.apache.commons.jxpath.util.ClassLoaderUtil;
import org.apache.commons.jxpath.util.ReverseComparator;
import org.apache.commons.jxpath.util.TypeUtils;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class JXPathContextReferenceImpl_getValue_8_0_Test {

    private JXPathContextReferenceImpl context;

    private JXPathContext parentContext;

    private Pointer contextPointer;

    @BeforeEach
    public void setUp() {
        parentContext = mock(JXPathContext.class);
        contextPointer = mock(Pointer.class);
        context = new JXPathContextReferenceImpl(parentContext, new Object(), contextPointer);
    }

    @Test
    public void testGetValue_WithValidExpression_ReturnsValue() {
        Expression expr = mock(Expression.class);
        Object expectedValue = "someValue";
        when(expr.computeValue(any())).thenReturn(expectedValue);
        Object result = context.getValue("valid/xpath", expr);
        assertEquals(expectedValue, result);
    }

    @Test
    public void testGetValue_WithNullResultAndPathExpression_ThrowsException() {
        Expression expr = mock(Expression.class);
        when(expr.computeValue(any())).thenReturn(null);
        when(expr instanceof Path).thenReturn(true);
        when(context.isLenient()).thenReturn(false);
        JXPathNotFoundException exception = assertThrows(JXPathNotFoundException.class, () -> {
            context.getValue("invalid/xpath", expr);
        });
        assertEquals("No value for xpath: invalid/xpath", exception.getMessage());
    }

    @Test
    public void testGetValue_WithNullResult_ReturnsNull() {
        Expression expr = mock(Expression.class);
        when(expr.computeValue(any())).thenReturn(null);
        when(context.isLenient()).thenReturn(true);
        Object result = context.getValue("valid/xpath", expr);
        assertNull(result);
    }

    @Test
    public void testGetValue_WithEvalContext_ReturnsSingleNodePointerValue() {
        Expression expr = mock(Expression.class);
        EvalContext evalContext = mock(EvalContext.class);
        NodePointer nodePointer = mock(NodePointer.class);
        Object expectedValue = "nodeValue";
        when(expr.computeValue(any())).thenReturn(evalContext);
        when(evalContext.getSingleNodePointer()).thenReturn(nodePointer);
        when(nodePointer.getValuePointer()).thenReturn(nodePointer);
        when(nodePointer.getValue()).thenReturn(expectedValue);
        Object result = context.getValue("valid/xpath", expr);
        assertEquals(expectedValue, result);
    }
}
