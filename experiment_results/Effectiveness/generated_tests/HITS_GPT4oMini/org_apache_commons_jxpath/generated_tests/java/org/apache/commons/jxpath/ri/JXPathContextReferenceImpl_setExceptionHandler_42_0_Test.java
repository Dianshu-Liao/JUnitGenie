package org.apache.commons.jxpath.ri;

import org.apache.commons.jxpath.ExceptionHandler;
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

public class JXPathContextReferenceImpl_setExceptionHandler_42_0_Test {

    private JXPathContextReferenceImpl context;

    private NodePointer mockNodePointer;

    private ExceptionHandler mockExceptionHandler;

    @BeforeEach
    public void setUp() {
        mockNodePointer = mock(NodePointer.class);
        context = new JXPathContextReferenceImpl(null, new Object(), mockNodePointer);
        mockExceptionHandler = mock(ExceptionHandler.class);
    }

    @Test
    public void testSetExceptionHandler_WhenRootPointerIsNodePointer() {
        // Arrange
        context.setExceptionHandler(mockExceptionHandler);
        // Act
        context.setExceptionHandler(mockExceptionHandler);
        // Assert
        verify(mockNodePointer, times(2)).setExceptionHandler(mockExceptionHandler);
    }

    @Test
    public void testSetExceptionHandler_WhenRootPointerIsNotNodePointer() {
        // Arrange
        context = new JXPathContextReferenceImpl(null, new Object());
        context.setExceptionHandler(mockExceptionHandler);
        // Act
        context.setExceptionHandler(mockExceptionHandler);
        // Assert
        // No exception should occur, and nothing should be verified on mockNodePointer
        assertDoesNotThrow(() -> context.setExceptionHandler(mockExceptionHandler));
    }

    @Test
    public void testSetExceptionHandler_NullHandler() {
        // Arrange
        context.setExceptionHandler(null);
        // Act
        context.setExceptionHandler(null);
        // Assert
        verify(mockNodePointer, times(1)).setExceptionHandler(null);
    }
}
