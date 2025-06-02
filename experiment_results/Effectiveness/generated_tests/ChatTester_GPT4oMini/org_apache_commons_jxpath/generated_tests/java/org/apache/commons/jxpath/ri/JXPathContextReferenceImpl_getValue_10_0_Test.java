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

public class JXPathContextReferenceImpl_getValue_10_0_Test {

    private JXPathContextReferenceImpl context;

    private JXPathContext parentContext;

    private Pointer contextPointer;

    @BeforeEach
    public void setUp() {
        parentContext = mock(JXPathContext.class);
        contextPointer = mock(Pointer.class);
        context = new JXPathContextReferenceImpl(parentContext, new Object(), contextPointer);
    }

    @Test
    public void testGetValueReturnsConvertedValue() {
        String xpath = "/some/xpath";
        Expression expr = mock(Expression.class);
        Class<?> requiredType = String.class;
        Object mockValue = "mockValue";
        when(context.getValue(xpath, expr)).thenReturn(mockValue);
        when(TypeUtils.canConvert(mockValue, requiredType)).thenReturn(true);
        when(TypeUtils.convert(mockValue, requiredType)).thenReturn(mockValue);
        Object result = context.getValue(xpath, expr, requiredType);
        assertEquals(mockValue, result);
    }

    @Test
    public void testGetValueThrowsExceptionOnInvalidType() {
        String xpath = "/some/xpath";
        Expression expr = mock(Expression.class);
        Class<?> requiredType = Integer.class;
        Object mockValue = "mockValue";
        when(context.getValue(xpath, expr)).thenReturn(mockValue);
        when(TypeUtils.canConvert(mockValue, requiredType)).thenReturn(false);
        JXPathTypeConversionException exception = assertThrows(JXPathTypeConversionException.class, () -> {
            context.getValue(xpath, expr, requiredType);
        });
        assertEquals("Invalid expression type. '" + xpath + "' returns java.lang.String. It cannot be converted to java.lang.Integer", exception.getMessage());
    }

    @Test
    public void testGetValueReturnsNullWhenValueIsNull() {
        String xpath = "/some/xpath";
        Expression expr = mock(Expression.class);
        Class<?> requiredType = String.class;
        when(context.getValue(xpath, expr)).thenReturn(null);
        Object result = context.getValue(xpath, expr, requiredType);
        assertNull(result);
    }

    // Reflection test for private method
    @Test
    public void testInvokePrivateMethod() throws Exception {
        Method privateMethod = JXPathContextReferenceImpl.class.getDeclaredMethod("getValue", String.class, Expression.class);
        privateMethod.setAccessible(true);
        Object result = privateMethod.invoke(context, "/some/xpath", mock(Expression.class));
        // Add assertions based on what the private method is expected to return
    }

    @Test
    public void testGetValueHandlesNullRequiredType() {
        String xpath = "/some/xpath";
        Expression expr = mock(Expression.class);
        Object mockValue = "mockValue";
        when(context.getValue(xpath, expr)).thenReturn(mockValue);
        Object result = context.getValue(xpath, expr, null);
        assertEquals(mockValue, result);
    }
}
