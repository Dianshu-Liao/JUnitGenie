package org.apache.commons.jxpath.ri;

import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.Pointer;
import org.apache.commons.jxpath.ri.JXPathContextReferenceImpl;
import org.apache.commons.jxpath.ri.NamespaceResolver;
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

class JXPathContextReferenceImpl_setNamespaceContextPointer_39_1_Test {

    private JXPathContextReferenceImpl context;

    private NamespaceResolver namespaceResolver;

    private Pointer mockPointer;

    @BeforeEach
    void setUp() {
        namespaceResolver = mock(NamespaceResolver.class);
        context = Mockito.spy(new JXPathContextReferenceImpl(null, new Object()));
        context.namespaceResolver = namespaceResolver;
        mockPointer = mock(Pointer.class);
    }

    @Test
    void testSetNamespaceContextPointer_whenNotSealed() {
        when(namespaceResolver.isSealed()).thenReturn(false);
        context.setNamespaceContextPointer(mockPointer);
        verify(namespaceResolver).setNamespaceContextPointer(any(NodePointer.class));
    }

    @Test
    void testSetNamespaceContextPointer_whenSealed() {
        when(namespaceResolver.isSealed()).thenReturn(true);
        when(namespaceResolver.clone()).thenReturn(mock(NamespaceResolver.class));
        context.setNamespaceContextPointer(mockPointer);
        verify(namespaceResolver).setNamespaceContextPointer(any(NodePointer.class));
        assertNotNull(context.namespaceResolver);
    }

    @Test
    void testSetNamespaceContextPointer_withNullPointer() {
        when(namespaceResolver.isSealed()).thenReturn(false);
        context.setNamespaceContextPointer(null);
        verify(namespaceResolver, never()).setNamespaceContextPointer(any(NodePointer.class));
    }

    @Test
    void testSetNamespaceContextPointer_cloningNamespaceResolver() {
        when(namespaceResolver.isSealed()).thenReturn(true);
        NamespaceResolver clonedResolver = mock(NamespaceResolver.class);
        when(namespaceResolver.clone()).thenReturn(clonedResolver);
        context.setNamespaceContextPointer(mockPointer);
        verify(clonedResolver).setNamespaceContextPointer(any(NodePointer.class));
    }
}
