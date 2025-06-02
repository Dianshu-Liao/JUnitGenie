package org.apache.commons.jxpath.ri;

import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.ri.compiler.Expression;
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

public class JXPathContextReferenceImpl_removePath_26_0_Test {

    private JXPathContextReferenceImpl context;

    private NodePointer mockPointer;

    private Expression mockExpression;

    @BeforeEach
    public void setUp() {
        // Initialize the context and mocks before each test
        context = new JXPathContextReferenceImpl(null, new Object());
        mockPointer = Mockito.mock(NodePointer.class);
        mockExpression = Mockito.mock(Expression.class);
    }

    @Test
    public void testRemovePath_Success() {
        // Arrange
        String xpath = "/some/path";
        when(context.getPointer(xpath, mockExpression)).thenReturn(mockPointer);
        // Act
        context.removePath(xpath, mockExpression);
        // Assert
        verify(mockPointer, times(1)).remove();
    }

    @Test
    public void testRemovePath_NullPointer() {
        // Arrange
        String xpath = "/some/path";
        when(context.getPointer(xpath, mockExpression)).thenReturn(null);
        // Act
        context.removePath(xpath, mockExpression);
        // Assert: No exception thrown, nothing to remove
        verify(mockPointer, never()).remove();
    }

    @Test
    public void testRemovePath_ThrowsJXPathException() {
        // Arrange
        String xpath = "/some/path";
        when(context.getPointer(xpath, mockExpression)).thenThrow(new RuntimeException("Error"));
        // Act & Assert
        JXPathException exception = assertThrows(JXPathException.class, () -> {
            context.removePath(xpath, mockExpression);
        });
        // Verify the exception message
        assertEquals("Exception trying to remove xpath " + xpath, exception.getMessage());
    }
}
