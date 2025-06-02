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

public class JXPathContextReferenceImpl_getValue_8_0_Test {

    private JXPathContextReferenceImpl context;

    private Expression mockExpression;

    @BeforeEach
    public void setUp() {
        context = new JXPathContextReferenceImpl(null, new Object());
        mockExpression = mock(Expression.class);
    }

    @Test
    public void testGetValue_withValidExpression_returnsValue() {
        // Arrange
        Object expectedValue = "someValue";
        when(mockExpression.computeValue(any())).thenReturn(expectedValue);
        // Act
        Object result = context.getValue("someXPath", mockExpression);
        // Assert
        assertEquals(expectedValue, result);
    }

    @Test
    public void testGetValue_withNullResult_returnsNull() {
        // Arrange
        when(mockExpression.computeValue(any())).thenReturn(null);
        // Act
        Object result = context.getValue("someXPath", mockExpression);
        // Assert
        assertNull(result);
    }

    @Test
    public void testGetValue_withPathExpressionAndNoValue_throwsJXPathNotFoundException() {
        // Arrange
        when(mockExpression.computeValue(any())).thenReturn(null);
        when(mockExpression).thenReturn(mock(Path.class));
        // Act & Assert
        assertThrows(JXPathNotFoundException.class, () -> {
            context.getValue("someXPath", mockExpression);
        });
    }

    @Test
    public void testGetValue_withEvalContext_returnsSingleNodePointerValue() {
        // Arrange
        NodePointer mockPointer = mock(NodePointer.class);
        when(mockPointer.getValue()).thenReturn("pointerValue");
        when(mockExpression.computeValue(any())).thenReturn(mock(EvalContext.class));
        when(((EvalContext) mockExpression.computeValue(any())).getSingleNodePointer()).thenReturn(mockPointer);
        // Act
        Object result = context.getValue("someXPath", mockExpression);
        // Assert
        assertEquals("pointerValue", result);
    }

    @Test
    public void testGetValue_withNodePointer_returnsNodePointerValue() {
        // Arrange
        NodePointer mockPointer = mock(NodePointer.class);
        when(mockPointer.getValue()).thenReturn("nodeValue");
        when(mockExpression.computeValue(any())).thenReturn(mockPointer);
        // Act
        Object result = context.getValue("someXPath", mockExpression);
        // Assert
        assertEquals("nodeValue", result);
    }

    @Test
    public void testGetValue_withNodePointerAndLenientMode_returnsNodePointerValue() {
        // Arrange
        context.setLenient(true);
        NodePointer mockPointer = mock(NodePointer.class);
        when(mockPointer.getValue()).thenReturn(null);
        when(mockExpression.computeValue(any())).thenReturn(mockPointer);
        // Act
        Object result = context.getValue("someXPath", mockExpression);
        // Assert
        assertNull(result);
    }

    @Test
    public void testGetValue_withInvalidExpression_throwsJXPathNotFoundException() {
        // Arrange
        when(mockExpression.computeValue(any())).thenReturn(null);
        when(mockExpression).thenReturn(mock(Path.class));
        context.setLenient(false);
        // Act & Assert
        assertThrows(JXPathNotFoundException.class, () -> {
            context.getValue("someXPath", mockExpression);
        });
    }
}
