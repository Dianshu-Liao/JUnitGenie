package org.apache.commons.jxpath.ri;

import java.util.Locale;
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

public class JXPathContextReferenceImpl_getPointer_14_0_Test {

    private JXPathContextReferenceImpl context;

    private JXPathContext parentContext;

    private Pointer contextPointer;

    private Expression expression;

    @BeforeEach
    public void setUp() {
        parentContext = mock(JXPathContext.class);
        contextPointer = mock(Pointer.class);
        context = new JXPathContextReferenceImpl(parentContext, new Object(), contextPointer);
        expression = mock(Expression.class);
    }

    @Test
    public void testGetPointerWithEvalContext() {
        EvalContext evalContext = mock(EvalContext.class);
        Pointer expectedPointer = mock(Pointer.class);
        when(expression.computeValue(any())).thenReturn(evalContext);
        when(evalContext.getSingleNodePointer()).thenReturn(expectedPointer);
        Pointer result = context.getPointer("some/xpath", expression);
        assertEquals(expectedPointer, result);
    }

    @Test
    public void testGetPointerWithNonActualPointer() {
        NodePointer nonActualPointer = mock(NodePointer.class);
        when(expression.computeValue(any())).thenReturn(nonActualPointer);
        when(nonActualPointer.isActual()).thenReturn(false);
        when(context.isLenient()).thenReturn(false);
        JXPathNotFoundException exception = assertThrows(JXPathNotFoundException.class, () -> {
            context.getPointer("some/xpath", expression);
        });
        assertEquals("No pointer for xpath: some/xpath", exception.getMessage());
    }

    @Test
    public void testGetPointerWithActualPointer() {
        NodePointer actualPointer = mock(NodePointer.class);
        when(expression.computeValue(any())).thenReturn(actualPointer);
        when(actualPointer.isActual()).thenReturn(true);
        Pointer result = context.getPointer("some/xpath", expression);
        assertEquals(actualPointer, result);
    }

    @Test
    public void testGetPointerWithNonPointerResult() {
        String nonPointerResult = "non-pointer result";
        when(expression.computeValue(any())).thenReturn(nonPointerResult);
        Pointer result = context.getPointer("some/xpath", expression);
        Pointer expectedPointer = NodePointer.newNodePointer(null, nonPointerResult, Locale.getDefault());
        assertEquals(expectedPointer, result);
    }
}
