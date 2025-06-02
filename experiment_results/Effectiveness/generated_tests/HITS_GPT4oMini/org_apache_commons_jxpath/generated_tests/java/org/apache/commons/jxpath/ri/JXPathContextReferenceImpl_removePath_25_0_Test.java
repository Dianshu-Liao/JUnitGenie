package org.apache.commons.jxpath.ri;

import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.ri.model.NodePointer;
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
import org.apache.commons.jxpath.ri.compiler.Expression;
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

public class JXPathContextReferenceImpl_removePath_25_0_Test {

    private JXPathContextReferenceImpl context;

    private NodePointer mockPointer;

    @BeforeEach
    public void setUp() {
        mockPointer = mock(NodePointer.class);
        context = new JXPathContextReferenceImpl(null, new Object());
    }

    @Test
    public void testRemovePath_WhenPointerExists_ShouldRemoveSuccessfully() {
        String xpath = "/test/path";
        Expression mockExpression = mock(Expression.class);
        // Assuming a valid root node
        when(mockPointer.getRootNode()).thenReturn(new Object());
        when(context.getPointer(xpath, mockExpression)).thenReturn(mockPointer);
        context.removePath(xpath);
        verify(mockPointer, times(1)).remove();
    }

    @Test
    public void testRemovePath_WhenPointerDoesNotExist_ShouldNotThrowException() {
        String xpath = "/nonexistent/path";
        Expression mockExpression = mock(Expression.class);
        when(context.getPointer(xpath, mockExpression)).thenReturn(null);
        context.removePath(xpath);
    }

    @Test
    public void testRemovePath_WhenExceptionThrown_ShouldThrowJXPathException() {
        String xpath = "/test/path";
        Expression mockExpression = mock(Expression.class);
        when(context.getPointer(xpath, mockExpression)).thenThrow(new RuntimeException("Test Exception"));
        JXPathException thrown = assertThrows(JXPathException.class, () -> {
            context.removePath(xpath);
        });
        assertEquals("Exception trying to remove xpath " + xpath, thrown.getMessage());
    }
}
