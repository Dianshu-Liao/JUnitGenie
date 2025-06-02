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

public class JXPathContextReferenceImpl_removeAll_27_0_Test {

    private JXPathContextReferenceImpl context;

    private JXPathContext parentContext;

    private Pointer contextPointer;

    private NamespaceResolver namespaceResolver;

    @BeforeEach
    public void setUp() {
        parentContext = mock(JXPathContext.class);
        contextPointer = mock(Pointer.class);
        namespaceResolver = mock(NamespaceResolver.class);
        context = new JXPathContextReferenceImpl(parentContext, new Object(), contextPointer);
        context.namespaceResolver = namespaceResolver;
    }

    @Test
    public void testRemoveAll() throws Exception {
        // Arrange
        String xpath = "/test/xpath";
        Expression mockExpression = mock(Expression.class);
        // Use reflection to access the private method compileExpression
        java.lang.reflect.Method compileExpressionMethod = JXPathContextReferenceImpl.class.getDeclaredMethod("compileExpression", String.class);
        compileExpressionMethod.setAccessible(true);
        when(compileExpressionMethod.invoke(context, xpath)).thenReturn(mockExpression);
        // Mock behavior for the removeAll method
        doNothing().when(context).removeAll(xpath, mockExpression);
        // Act
        context.removeAll(xpath);
        // Assert
        verify(context, times(1)).removeAll(xpath, mockExpression);
    }

    @Test
    public void testRemoveAllWithNullExpression() throws Exception {
        // Use reflection to access the private method compileExpression
        String xpath = "/test/xpath";
        java.lang.reflect.Method compileExpressionMethod = JXPathContextReferenceImpl.class.getDeclaredMethod("compileExpression", String.class);
        compileExpressionMethod.setAccessible(true);
        when(compileExpressionMethod.invoke(context, xpath)).thenReturn(null);
        // Act and Assert
        assertThrows(JXPathException.class, () -> {
            context.removeAll(xpath);
        });
    }

    @Test
    public void testRemoveAllWithException() throws Exception {
        // Arrange
        String xpath = "/test/xpath";
        // Use reflection to access the private method compileExpression
        Expression mockExpression = mock(Expression.class);
        java.lang.reflect.Method compileExpressionMethod = JXPathContextReferenceImpl.class.getDeclaredMethod("compileExpression", String.class);
        compileExpressionMethod.setAccessible(true);
        when(compileExpressionMethod.invoke(context, xpath)).thenReturn(mockExpression);
        doThrow(new JXPathException("Error")).when(context).removeAll(xpath, mockExpression);
        // Act and Assert
        JXPathException exception = assertThrows(JXPathException.class, () -> {
            context.removeAll(xpath);
        });
        assertEquals("Exception trying to remove all with xpath " + xpath, exception.getMessage());
    }
}
