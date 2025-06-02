package org.apache.commons.jxpath.ri;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Vector;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
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

class JXPathContextReferenceImpl_createNodeFactoryArray_0_2_Test {

    private JXPathContextReferenceImpl instance;

    @BeforeEach
    void setUp() {
        instance = new JXPathContextReferenceImpl(null, new Object());
    }

    @Test
    void testCreateNodeFactoryArray() throws Exception {
        // Ensure the nodeFactoryArray is initialized to null before calling the method
        assertNull(getNodeFactoryArray());
        // Call the private method using reflection
        invokeCreateNodeFactoryArray();
        // Check that the nodeFactoryArray has been initialized
        assertNotNull(getNodeFactoryArray());
    }

    @Test
    void testCreateNodeFactoryArrayMultipleCalls() throws Exception {
        // Call the method for the first time
        invokeCreateNodeFactoryArray();
        NodePointerFactory[] firstCallArray = getNodeFactoryArray();
        // Call the method again
        invokeCreateNodeFactoryArray();
        NodePointerFactory[] secondCallArray = getNodeFactoryArray();
        // Verify that the array remains the same after multiple calls
        assertSame(firstCallArray, secondCallArray);
    }

    private void invokeCreateNodeFactoryArray() throws Exception {
        Method method = JXPathContextReferenceImpl.class.getDeclaredMethod("createNodeFactoryArray");
        method.setAccessible(true);
        method.invoke(null);
    }

    private NodePointerFactory[] getNodeFactoryArray() throws Exception {
        // Access the private static field nodeFactoryArray using reflection
        java.lang.reflect.Field field = JXPathContextReferenceImpl.class.getDeclaredField("nodeFactoryArray");
        field.setAccessible(true);
        return (NodePointerFactory[]) field.get(null);
    }
}
