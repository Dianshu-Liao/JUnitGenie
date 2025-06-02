package org.apache.commons.jxpath.ri;

import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.Pointer;
import org.apache.commons.jxpath.ri.JXPathContextReferenceImpl;
import org.apache.commons.jxpath.ri.NamespaceResolver;
import org.apache.commons.jxpath.ri.compiler.Expression;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.ri.axes.InitialContext;
import org.apache.commons.jxpath.ri.axes.RootContext;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
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
import org.apache.commons.jxpath.JXPathFunctionNotFoundException;
import org.apache.commons.jxpath.JXPathInvalidSyntaxException;
import org.apache.commons.jxpath.JXPathNotFoundException;
import org.apache.commons.jxpath.JXPathTypeConversionException;
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

class JXPathContextReferenceImpl_getPointer_13_0_Test {

    private JXPathContextReferenceImpl jXPathContext;

    private NamespaceResolver namespaceResolverMock;

    @BeforeEach
    void setUp() {
        namespaceResolverMock = mock(NamespaceResolver.class);
        jXPathContext = new JXPathContextReferenceImpl(null, new Object(), null);
        jXPathContext.namespaceResolver = namespaceResolverMock;
    }

    @Test
    void testGetPointer_validXPath() throws Exception {
        String xpath = "/valid/xpath";
        Expression expressionMock = mock(Expression.class);
        Pointer pointerMock = mock(Pointer.class);
        // Use reflection to access the private compileExpression method
        Method compileExpressionMethod = JXPathContextReferenceImpl.class.getDeclaredMethod("compileExpression", String.class);
        compileExpressionMethod.setAccessible(true);
        when(compileExpressionMethod.invoke(jXPathContext, xpath)).thenReturn(expressionMock);
        when(expressionMock.computeValue(any())).thenReturn(pointerMock);
        // Mocking getNode() instead of isActual()
        when(pointerMock.getNode()).thenReturn(new Object());
        Pointer resultPointer = jXPathContext.getPointer(xpath);
        assertNotNull(resultPointer);
        assertEquals(pointerMock, resultPointer);
    }

    @Test
    void testGetPointer_invalidXPath() throws Exception {
        String xpath = "/invalid/xpath";
        Expression expressionMock = mock(Expression.class);
        Method compileExpressionMethod = JXPathContextReferenceImpl.class.getDeclaredMethod("compileExpression", String.class);
        compileExpressionMethod.setAccessible(true);
        when(compileExpressionMethod.invoke(jXPathContext, xpath)).thenReturn(expressionMock);
        when(expressionMock.computeValue(any())).thenThrow(new JXPathException("Invalid XPath"));
        assertThrows(JXPathException.class, () -> jXPathContext.getPointer(xpath));
    }

    @Test
    void testGetPointer_noPointerFound() throws Exception {
        String xpath = "/no/pointer";
        Expression expressionMock = mock(Expression.class);
        Pointer pointerMock = mock(Pointer.class);
        Method compileExpressionMethod = JXPathContextReferenceImpl.class.getDeclaredMethod("compileExpression", String.class);
        compileExpressionMethod.setAccessible(true);
        when(compileExpressionMethod.invoke(jXPathContext, xpath)).thenReturn(expressionMock);
        when(expressionMock.computeValue(any())).thenReturn(pointerMock);
        // Mocking getNode() to return null
        when(pointerMock.getNode()).thenReturn(null);
        assertThrows(JXPathException.class, () -> jXPathContext.getPointer(xpath));
    }
}
