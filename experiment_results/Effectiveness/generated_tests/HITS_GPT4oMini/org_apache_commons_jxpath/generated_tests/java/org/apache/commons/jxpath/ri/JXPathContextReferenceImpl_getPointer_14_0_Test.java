package org.apache.commons.jxpath.ri;

import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.Pointer;
import org.apache.commons.jxpath.ri.compiler.Expression;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
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
import org.apache.commons.jxpath.ri.axes.InitialContext;
import org.apache.commons.jxpath.ri.axes.RootContext;
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

@ExtendWith(MockitoExtension.class)
public class JXPathContextReferenceImpl_getPointer_14_0_Test {

    private JXPathContextReferenceImpl context;

    private Expression mockExpression;

    @BeforeEach
    public void setUp() {
        context = new JXPathContextReferenceImpl(null, new Object());
        mockExpression = mock(Expression.class);
    }

    @Test
    public void testGetPointer_WithValidExpression_ReturnsPointer() {
        Pointer mockPointer = mock(Pointer.class);
        when(mockExpression.computeValue(any())).thenReturn(mockPointer);
        Pointer result = context.getPointer("validXPath", mockExpression);
        assertNotNull(result);
        assertEquals(mockPointer, result);
    }

    @Test
    public void testGetPointer_WithEvalContextReturningEvalContext_ReturnsPointer() {
        EvalContext mockEvalContext = mock(EvalContext.class);
        Pointer mockPointer = mock(Pointer.class);
        when(mockExpression.computeValue(any())).thenReturn(mockEvalContext);
        when(mockEvalContext.getSingleNodePointer()).thenReturn(mockPointer);
        Pointer result = context.getPointer("validXPath", mockExpression);
        assertNotNull(result);
        assertEquals(mockPointer, result);
    }

    @Test
    public void testGetPointer_WithLenientMode_ReturnsNodePointerForNonActualNode() {
        context = new JXPathContextReferenceImpl(null, new Object());
        NodePointer mockNodePointer = mock(NodePointer.class);
        when(mockNodePointer.isActual()).thenReturn(false);
        when(mockExpression.computeValue(any())).thenReturn(mockNodePointer);
        context.setLenient(true);
        Pointer result = context.getPointer("validXPath", mockExpression);
        assertNotNull(result);
        assertEquals(mockNodePointer, result);
    }

    @Test
    public void testGetPointer_WithNonPointerResult_ThrowsJXPathNotFoundException() {
        when(mockExpression.computeValue(any())).thenReturn("nonPointerResult");
        JXPathException exception = assertThrows(JXPathNotFoundException.class, () -> {
            context.getPointer("invalidXPath", mockExpression);
        });
        assertEquals("No pointer for xpath: invalidXPath", exception.getMessage());
    }

    @Test
    public void testGetPointer_WithNullExpression_ThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () -> {
            context.getPointer("validXPath", null);
        });
    }
}
