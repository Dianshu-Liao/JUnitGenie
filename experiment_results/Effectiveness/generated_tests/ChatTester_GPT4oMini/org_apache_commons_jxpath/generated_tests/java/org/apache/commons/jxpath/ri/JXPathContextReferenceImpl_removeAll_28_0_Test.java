// Test method
package org.apache.commons.jxpath.ri;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
// Importing the Method class
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
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

class JXPathContextReferenceImpl_removeAll_28_0_Test {

    private JXPathContextReferenceImpl context;

    private JXPathContext parentContext;

    private Pointer contextPointer;

    private Expression expression;

    @BeforeEach
    void setUp() {
        parentContext = mock(JXPathContext.class);
        contextPointer = mock(Pointer.class);
        context = new JXPathContextReferenceImpl(parentContext, new Object(), contextPointer);
        expression = mock(Expression.class);
    }

    @Test
    void testRemoveAll_EmptyExpression() {
        when(expression.iteratePointers(any())).thenReturn(Collections.emptyList().iterator());
        assertDoesNotThrow(() -> context.removeAll("some/xpath", expression));
    }

    @Test
    void testRemoveAll_SinglePointer() {
        NodePointer pointer = mock(NodePointer.class);
        when(expression.iteratePointers(any())).thenReturn(Collections.singletonList(pointer).iterator());
        context.removeAll("some/xpath", expression);
        verify(pointer, times(1)).remove();
    }

    @Test
    void testRemoveAll_MultiplePointers() {
        NodePointer pointer1 = mock(NodePointer.class);
        NodePointer pointer2 = mock(NodePointer.class);
        when(expression.iteratePointers(any())).thenReturn(Arrays.asList(pointer1, pointer2).iterator());
        context.removeAll("some/xpath", expression);
        verify(pointer1, times(1)).remove();
        verify(context, times(1)).removePath(pointer2.asPath());
    }

    @Test
    void testRemoveAll_ThrowsException() {
        when(expression.iteratePointers(any())).thenThrow(new RuntimeException("Test exception"));
        JXPathException exception = assertThrows(JXPathException.class, () -> context.removeAll("some/xpath", expression));
        assertEquals("Exception trying to remove all for xpath some/xpath", exception.getMessage());
        assertNotNull(exception.getCause());
        assertEquals("Test exception", exception.getCause().getMessage());
    }

    // Reflection to invoke private methods if needed
    private void invokePrivateMethod(String methodName, Class<?>... parameterTypes) throws Exception {
        Method method = JXPathContextReferenceImpl.class.getDeclaredMethod(methodName, parameterTypes);
        method.setAccessible(true);
        method.invoke(context);
    }
}
