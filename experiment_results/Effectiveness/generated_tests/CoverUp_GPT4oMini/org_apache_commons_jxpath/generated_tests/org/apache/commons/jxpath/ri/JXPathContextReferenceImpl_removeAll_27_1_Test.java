package org.apache.commons.jxpath.ri;

import org.apache.commons.jxpath.ri.JXPathContextReferenceImpl;
import org.apache.commons.jxpath.ri.NamespaceResolver;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.ri.compiler.Expression;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
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
import org.apache.commons.jxpath.JXPathFunctionNotFoundException;
import org.apache.commons.jxpath.JXPathInvalidSyntaxException;
import org.apache.commons.jxpath.JXPathNotFoundException;
import org.apache.commons.jxpath.JXPathTypeConversionException;
import org.apache.commons.jxpath.Pointer;
import org.apache.commons.jxpath.ri.axes.InitialContext;
import org.apache.commons.jxpath.ri.axes.RootContext;
import org.apache.commons.jxpath.ri.compiler.LocationPath;
import org.apache.commons.jxpath.ri.compiler.Path;
import org.apache.commons.jxpath.ri.compiler.TreeCompiler;
import org.apache.commons.jxpath.ri.model.NodePointerFactory;
import org.apache.commons.jxpath.ri.model.VariablePointerFactory;
import org.apache.commons.jxpath.ri.model.beans.BeanPointerFactory;
import org.apache.commons.jxpath.ri.model.beans.CollectionPointerFactory;
import org.apache.commons.jxpath.ri.model.container.ContainerPointerFactory;
import org.apache.commons.jxpath.ri.model.dynamic.DynamicPointerFactory;
import org.apache.commons.jxpath.util.ClassLoaderUtil;
import org.apache.commons.jxpath.util.ReverseComparator;
import org.apache.commons.jxpath.util.TypeUtils;

class JXPathContextReferenceImpl_removeAll_27_1_Test {

    private JXPathContextReferenceImpl contextReference;

    private NamespaceResolver namespaceResolver;

    private NodePointer mockPointer;

    @BeforeEach
    void setUp() {
        namespaceResolver = mock(NamespaceResolver.class);
        mockPointer = mock(NodePointer.class);
        contextReference = new JXPathContextReferenceImpl(null, new Object(), mockPointer);
        contextReference.namespaceResolver = namespaceResolver;
    }

    @Test
    void testRemoveAll() throws Exception {
        String xpath = "/test/xpath";
        Expression mockExpression = mock(Expression.class);
        when(mockExpression.iteratePointers(any())).thenReturn(mockIterator());
        // Use reflection to invoke the private compileExpression method
        Method compileExpressionMethod = JXPathContextReferenceImpl.class.getDeclaredMethod("compileExpression", String.class);
        compileExpressionMethod.setAccessible(true);
        when(compileExpressionMethod.invoke(contextReference, xpath)).thenReturn(mockExpression);
        // Call the focal method
        contextReference.removeAll(xpath);
        // Verify interactions
        verify(mockExpression).iteratePointers(any());
        verify(mockPointer).remove();
    }

    @Test
    void testRemoveAllThrowsException() throws Exception {
        String xpath = "/test/xpath";
        Expression mockExpression = mock(Expression.class);
        when(mockExpression.iteratePointers(any())).thenThrow(new RuntimeException("Test Exception"));
        Method compileExpressionMethod = JXPathContextReferenceImpl.class.getDeclaredMethod("compileExpression", String.class);
        compileExpressionMethod.setAccessible(true);
        when(compileExpressionMethod.invoke(contextReference, xpath)).thenReturn(mockExpression);
        JXPathException exception = assertThrows(JXPathException.class, () -> contextReference.removeAll(xpath));
        assertEquals("Exception trying to remove all for xpath /test/xpath", exception.getMessage());
    }

    private Iterator<NodePointer> mockIterator() {
        return new Iterator<NodePointer>() {

            private int count = 0;

            @Override
            public boolean hasNext() {
                // Return two mock pointers
                return count < 2;
            }

            @Override
            public NodePointer next() {
                count++;
                // Return the same mock pointer
                return mockPointer;
            }
        };
    }
}
