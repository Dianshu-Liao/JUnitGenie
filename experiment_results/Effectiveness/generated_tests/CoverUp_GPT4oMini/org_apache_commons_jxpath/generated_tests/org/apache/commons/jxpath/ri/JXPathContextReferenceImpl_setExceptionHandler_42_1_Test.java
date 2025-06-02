package org.apache.commons.jxpath.ri;

import org.apache.commons.jxpath.ExceptionHandler;
import org.apache.commons.jxpath.ri.JXPathContextReferenceImpl;
import org.apache.commons.jxpath.ri.model.NodePointer;
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
import org.apache.commons.jxpath.ri.model.NodePointerFactory;
import org.apache.commons.jxpath.ri.model.VariablePointerFactory;
import org.apache.commons.jxpath.ri.model.beans.BeanPointerFactory;
import org.apache.commons.jxpath.ri.model.beans.CollectionPointerFactory;
import org.apache.commons.jxpath.ri.model.container.ContainerPointerFactory;
import org.apache.commons.jxpath.ri.model.dynamic.DynamicPointerFactory;
import org.apache.commons.jxpath.util.ClassLoaderUtil;
import org.apache.commons.jxpath.util.ReverseComparator;
import org.apache.commons.jxpath.util.TypeUtils;

class JXPathContextReferenceImpl_setExceptionHandler_42_1_Test {

    private JXPathContextReferenceImpl context;

    private NodePointer mockNodePointer;

    @BeforeEach
    void setUp() {
        mockNodePointer = mock(NodePointer.class);
        context = new JXPathContextReferenceImpl(null, new Object());
        // Set the rootPointer to the mocked NodePointer
        setRootPointer(context, mockNodePointer);
    }

    @Test
    void testSetExceptionHandler() {
        ExceptionHandler mockExceptionHandler = mock(ExceptionHandler.class);
        // Act
        context.setExceptionHandler(mockExceptionHandler);
        // Assert
        verify(mockNodePointer, times(1)).setExceptionHandler(mockExceptionHandler);
    }

    @Test
    void testSetExceptionHandlerWhenRootPointerIsNotNodePointer() {
        // Change rootPointer to null to simulate a case where it's not a NodePointer
        setRootPointer(context, null);
        ExceptionHandler mockExceptionHandler = mock(ExceptionHandler.class);
        // Act
        context.setExceptionHandler(mockExceptionHandler);
        // Assert
        verify(mockNodePointer, never()).setExceptionHandler(any());
    }

    private void setRootPointer(JXPathContextReferenceImpl context, NodePointer pointer) {
        try {
            Method method = JXPathContextReferenceImpl.class.getDeclaredMethod("setValue", Pointer.class);
            method.setAccessible(true);
            method.invoke(context, pointer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
