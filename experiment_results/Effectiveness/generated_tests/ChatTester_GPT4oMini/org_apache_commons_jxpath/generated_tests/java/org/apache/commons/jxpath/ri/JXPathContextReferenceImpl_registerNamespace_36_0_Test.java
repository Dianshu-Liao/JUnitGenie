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

public class JXPathContextReferenceImpl_registerNamespace_36_0_Test {

    private JXPathContextReferenceImpl jXPathContextReferenceImpl;

    private NamespaceResolver mockNamespaceResolver;

    @BeforeEach
    public void setUp() {
        mockNamespaceResolver = mock(NamespaceResolver.class);
        jXPathContextReferenceImpl = new JXPathContextReferenceImpl(null, new Object()) {

            {
                // Inject mock
                namespaceResolver = mockNamespaceResolver;
            }
        };
    }

    @Test
    public void testRegisterNamespace_WhenNotSealed_ShouldRegisterNamespace() {
        // Arrange
        String prefix = "testPrefix";
        String namespaceURI = "http://test.namespace";
        when(mockNamespaceResolver.isSealed()).thenReturn(false);
        // Act
        jXPathContextReferenceImpl.registerNamespace(prefix, namespaceURI);
        // Assert
        verify(mockNamespaceResolver).registerNamespace(prefix, namespaceURI);
    }

    @Test
    public void testRegisterNamespace_WhenSealed_ShouldCloneAndRegisterNamespace() {
        // Arrange
        String prefix = "testPrefix";
        String namespaceURI = "http://test.namespace";
        when(mockNamespaceResolver.isSealed()).thenReturn(true);
        when(mockNamespaceResolver.clone()).thenReturn(mockNamespaceResolver);
        // Act
        jXPathContextReferenceImpl.registerNamespace(prefix, namespaceURI);
        // Assert
        verify(mockNamespaceResolver).clone();
        verify(mockNamespaceResolver).registerNamespace(prefix, namespaceURI);
    }

    @Test
    public void testRegisterNamespace_WhenSealed_ShouldNotRegisterOnOriginal() {
        // Arrange
        String prefix = "testPrefix";
        String namespaceURI = "http://test.namespace";
        when(mockNamespaceResolver.isSealed()).thenReturn(true);
        NamespaceResolver clonedResolver = mock(NamespaceResolver.class);
        when(mockNamespaceResolver.clone()).thenReturn(clonedResolver);
        // Act
        jXPathContextReferenceImpl.registerNamespace(prefix, namespaceURI);
        // Assert
        verify(clonedResolver).registerNamespace(prefix, namespaceURI);
        verify(mockNamespaceResolver, never()).registerNamespace(prefix, namespaceURI);
    }
}
