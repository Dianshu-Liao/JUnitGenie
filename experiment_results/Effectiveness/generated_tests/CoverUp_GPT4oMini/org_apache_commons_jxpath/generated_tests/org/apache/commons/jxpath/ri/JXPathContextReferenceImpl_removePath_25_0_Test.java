package org.apache.commons.jxpath.ri;

import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.Pointer;
import org.apache.commons.jxpath.ri.JXPathContextReferenceImpl;
import org.apache.commons.jxpath.ri.NamespaceResolver;
import org.apache.commons.jxpath.ri.model.NodePointer;
import java.lang.reflect.Method;
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

class JXPathContextReferenceImpl_removePath_25_0_Test {

    private JXPathContextReferenceImpl context;

    private Pointer mockPointer;

    private NamespaceResolver mockNamespaceResolver;

    @BeforeEach
    void setUp() {
        mockPointer = mock(Pointer.class);
        mockNamespaceResolver = mock(NamespaceResolver.class);
        context = new JXPathContextReferenceImpl(null, new Object(), mockPointer);
        context.namespaceResolver = mockNamespaceResolver;
    }

    @Test
    void testRemovePath_success() throws Exception {
        String xpath = "/test/path";
        Method compileExpressionMethod = JXPathContextReferenceImpl.class.getDeclaredMethod("compileExpression", String.class);
        compileExpressionMethod.setAccessible(true);
        Object mockExpression = compileExpressionMethod.invoke(context, xpath);
        // Mock behavior of getPointer to return a valid NodePointer
        when(context.getPointer(eq(xpath), any())).thenReturn(mockPointer);
        // Invoke removePath
        context.removePath(xpath);
        // Verify that remove was called on the pointer
        // Assuming removePath sets the value to null
        verify(mockPointer).setValue(null);
    }

    @Test
    void testRemovePath_pointerNotFound() {
        String xpath = "/test/path";
        // Mock behavior of getPointer to return null
        when(context.getPointer(eq(xpath), any())).thenReturn(null);
        // Invoke removePath and expect no exception
        assertDoesNotThrow(() -> context.removePath(xpath));
    }

    @Test
    void testRemovePath_exceptionThrown() throws Exception {
        String xpath = "/test/path";
        Method compileExpressionMethod = JXPathContextReferenceImpl.class.getDeclaredMethod("compileExpression", String.class);
        compileExpressionMethod.setAccessible(true);
        Object mockExpression = compileExpressionMethod.invoke(context, xpath);
        // Mock behavior of getPointer to throw an exception
        when(context.getPointer(eq(xpath), any())).thenThrow(new RuntimeException("Test Exception"));
        // Invoke removePath and expect JXPathException
        JXPathException thrown = assertThrows(JXPathException.class, () -> context.removePath(xpath));
        assertEquals("Exception trying to remove xpath /test/path", thrown.getMessage());
        assertTrue(thrown.getCause() instanceof RuntimeException);
    }
}
