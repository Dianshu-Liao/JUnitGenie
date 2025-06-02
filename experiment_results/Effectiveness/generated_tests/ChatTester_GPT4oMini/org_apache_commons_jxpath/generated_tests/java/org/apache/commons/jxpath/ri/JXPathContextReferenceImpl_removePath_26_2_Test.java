package org.apache.commons.jxpath.ri;

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

public class JXPathContextReferenceImpl_removePath_26_2_Test {

    private JXPathContextReferenceImpl contextReference;

    private JXPathContext parentContext;

    private Object contextBean;

    private Pointer contextPointer;

    @BeforeEach
    public void setUp() {
        parentContext = mock(JXPathContext.class);
        contextBean = new Object();
        contextPointer = mock(Pointer.class);
        contextReference = new JXPathContextReferenceImpl(parentContext, contextBean, contextPointer);
    }

    @Test
    public void testRemovePath_WithValidPointer_ShouldRemoveSuccessfully() throws Exception {
        String xpath = "/valid/xpath";
        Expression expr = mock(Expression.class);
        NodePointer pointer = mock(NodePointer.class);
        // Use reflection to set the private method getPointer to return our mock pointer
        Method getPointerMethod = JXPathContextReferenceImpl.class.getDeclaredMethod("getPointer", String.class, Expression.class);
        getPointerMethod.setAccessible(true);
        when(getPointerMethod.invoke(contextReference, xpath, expr)).thenReturn(pointer);
        // Call the focal method
        contextReference.removePath(xpath, expr);
        // Verify that remove was called on the pointer
        verify(pointer).remove();
    }

    @Test
    public void testRemovePath_WithNullPointer_ShouldNotThrowException() throws Exception {
        String xpath = "/invalid/xpath";
        Expression expr = mock(Expression.class);
        // Use reflection to set the private method getPointer to return null
        Method getPointerMethod = JXPathContextReferenceImpl.class.getDeclaredMethod("getPointer", String.class, Expression.class);
        getPointerMethod.setAccessible(true);
        when(getPointerMethod.invoke(contextReference, xpath, expr)).thenReturn(null);
        // Call the focal method
        contextReference.removePath(xpath, expr);
        // No exception should be thrown, just verify that remove was not called
        // No verification needed, just ensuring it runs without exception
    }

    @Test
    public void testRemovePath_WithExceptionInGetPointer_ShouldThrowJXPathException() throws Exception {
        String xpath = "/invalid/xpath";
        Expression expr = mock(Expression.class);
        // Use reflection to set the private method getPointer to throw an exception
        Method getPointerMethod = JXPathContextReferenceImpl.class.getDeclaredMethod("getPointer", String.class, Expression.class);
        getPointerMethod.setAccessible(true);
        when(getPointerMethod.invoke(contextReference, xpath, expr)).thenThrow(new RuntimeException("GetPointer error"));
        // Call the focal method and expect JXPathException
        JXPathException thrown = assertThrows(JXPathException.class, () -> {
            contextReference.removePath(xpath, expr);
        });
        assertEquals("Exception trying to remove xpath /invalid/xpath", thrown.getMessage());
        assertTrue(thrown.getCause() instanceof RuntimeException);
    }
}
