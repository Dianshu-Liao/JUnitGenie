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

public class JXPathContextReferenceImpl_removePath_25_1_Test {

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
    public void testRemovePathValidXPath() throws Exception {
        String xpath = "/valid/xpath";
        // Mock compileExpression method
        Method compileExpressionMethod = JXPathContextReferenceImpl.class.getDeclaredMethod("compileExpression", String.class);
        compileExpressionMethod.setAccessible(true);
        Object compiledExpression = mock(Expression.class);
        when(compileExpressionMethod.invoke(contextReference, xpath)).thenReturn(compiledExpression);
        // Mock the behavior of setValue using reflection
        Method setValueMethod = JXPathContextReferenceImpl.class.getDeclaredMethod("setValue", String.class, Expression.class, Object.class, boolean.class);
        setValueMethod.setAccessible(true);
        doNothing().when(setValueMethod).invoke(any(), eq(xpath), eq(compiledExpression), any(), eq(false));
        // Invoke removePath using reflection
        Method removePathMethod = JXPathContextReferenceImpl.class.getDeclaredMethod("removePath", String.class);
        removePathMethod.setAccessible(true);
        // Expecting no exception to be thrown for valid xpath
        assertDoesNotThrow(() -> removePathMethod.invoke(contextReference, xpath));
    }

    @Test
    public void testRemovePathInvalidXPath() throws Exception {
        String xpath = "/invalid/xpath";
        // Mock compileExpression method to simulate an exception
        Method compileExpressionMethod = JXPathContextReferenceImpl.class.getDeclaredMethod("compileExpression", String.class);
        compileExpressionMethod.setAccessible(true);
        doThrow(new RuntimeException("Invalid XPath")).when(compileExpressionMethod).invoke(any(), eq(xpath));
        // Invoke removePath using reflection
        Method removePathMethod = JXPathContextReferenceImpl.class.getDeclaredMethod("removePath", String.class);
        removePathMethod.setAccessible(true);
        // Expecting an exception to be thrown
        Exception exception = assertThrows(RuntimeException.class, () -> removePathMethod.invoke(contextReference, xpath));
        assertEquals("Invalid XPath", exception.getMessage());
    }
}
