package org.apache.commons.jxpath.ri;

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

public class JXPathContextReferenceImpl_setNamespaceContextPointer_39_0_Test {

    private JXPathContextReferenceImpl jXPathContextReferenceImpl;

    private JXPathContext parentContext;

    private Object contextBean;

    private Pointer contextPointer;

    private Pointer pointer;

    private NamespaceResolver namespaceResolver;

    @BeforeEach
    public void setUp() {
        parentContext = mock(JXPathContext.class);
        contextBean = new Object();
        contextPointer = mock(Pointer.class);
        pointer = mock(Pointer.class);
        namespaceResolver = mock(NamespaceResolver.class);
        jXPathContextReferenceImpl = new JXPathContextReferenceImpl(parentContext, contextBean);
        // Set the namespaceResolver field using reflection
        try {
            java.lang.reflect.Field field = JXPathContextReferenceImpl.class.getDeclaredField("namespaceResolver");
            field.setAccessible(true);
            field.set(jXPathContextReferenceImpl, namespaceResolver);
        } catch (Exception e) {
            fail("Failed to set up namespaceResolver: " + e.getMessage());
        }
    }

    @Test
    public void testSetNamespaceContextPointer_WhenNamespaceResolverIsSealed_ShouldCloneNamespaceResolver() {
        // Arrange
        when(namespaceResolver.isSealed()).thenReturn(true);
        NamespaceResolver clonedResolver = mock(NamespaceResolver.class);
        when(namespaceResolver.clone()).thenReturn(clonedResolver);
        // Act
        jXPathContextReferenceImpl.setNamespaceContextPointer(pointer);
        // Assert
        verify(namespaceResolver).clone();
        verify(clonedResolver).setNamespaceContextPointer(any(NodePointer.class));
    }

    @Test
    public void testSetNamespaceContextPointer_WhenNamespaceResolverIsNotSealed_ShouldNotCloneNamespaceResolver() {
        // Arrange
        when(namespaceResolver.isSealed()).thenReturn(false);
        // Act
        jXPathContextReferenceImpl.setNamespaceContextPointer(pointer);
        // Assert
        verify(namespaceResolver, never()).clone();
        verify(namespaceResolver).setNamespaceContextPointer(any(NodePointer.class));
    }

    @Test
    public void testSetNamespaceContextPointer_ShouldSetNamespaceContextPointer() {
        // Arrange
        when(namespaceResolver.isSealed()).thenReturn(false);
        // Act
        jXPathContextReferenceImpl.setNamespaceContextPointer(pointer);
        // Assert
        verify(namespaceResolver).setNamespaceContextPointer(any(NodePointer.class));
    }
}
