package org.apache.commons.jxpath.ri;

import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.ri.compiler.Expression;
import org.apache.commons.jxpath.ri.model.NodePointer;
import java.util.ArrayList;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.ref.SoftReference;
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

public class JXPathContextReferenceImpl_removeAll_28_0_Test {

    private JXPathContextReferenceImpl context;

    private NodePointer mockPointer;

    private Expression mockExpression;

    @BeforeEach
    public void setUp() {
        context = new JXPathContextReferenceImpl(null, new Object());
        mockPointer = mock(NodePointer.class);
        mockExpression = mock(Expression.class);
    }

    @Test
    public void testRemoveAll_withValidPointers_removesPointers() {
        List<NodePointer> pointers = new ArrayList<>();
        pointers.add(mockPointer);
        when(mockExpression.iteratePointers(any())).thenReturn(pointers.iterator());
        context.removeAll("validXPath", mockExpression);
        verify(mockPointer, times(1)).remove();
    }

    @Test
    public void testRemoveAll_withMultiplePointers_removesAllPointers() {
        NodePointer anotherMockPointer = mock(NodePointer.class);
        List<NodePointer> pointers = new ArrayList<>();
        pointers.add(mockPointer);
        pointers.add(anotherMockPointer);
        when(mockExpression.iteratePointers(any())).thenReturn(pointers.iterator());
        context.removeAll("validXPath", mockExpression);
        verify(mockPointer, times(1)).remove();
        verify(anotherMockPointer, times(1)).remove();
    }

    @Test
    public void testRemoveAll_withEmptyExpression_doesNotRemoveAnyPointer() {
        when(mockExpression.iteratePointers(any())).thenReturn(new ArrayList<NodePointer>().iterator());
        context.removeAll("validXPath", mockExpression);
        verify(mockPointer, never()).remove();
    }

    @Test
    public void testRemoveAll_withExceptionThrown_throwsJXPathException() {
        when(mockExpression.iteratePointers(any())).thenThrow(new RuntimeException("Error iterating"));
        JXPathException exception = assertThrows(JXPathException.class, () -> {
            context.removeAll("validXPath", mockExpression);
        });
        assertEquals("Exception trying to remove all for xpath validXPath", exception.getMessage());
        assertNotNull(exception.getCause());
        assertEquals("Error iterating", exception.getCause().getMessage());
    }
}
