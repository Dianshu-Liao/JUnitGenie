package org.apache.commons.jxpath.ri;

import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.Pointer;
import java.util.HashMap;
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
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Vector;
import org.apache.commons.jxpath.CompiledExpression;
import org.apache.commons.jxpath.ExceptionHandler;
import org.apache.commons.jxpath.Function;
import org.apache.commons.jxpath.Functions;
import org.apache.commons.jxpath.JXPathException;
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

    private JXPathContextReferenceImpl context;

    private NamespaceResolver namespaceResolver;

    @BeforeEach
    public void setUp() {
        // Create a mock JXPathContext
        JXPathContext parentContext = JXPathContext.newContext(new Object());
        namespaceResolver = new NamespaceResolver();
        context = new JXPathContextReferenceImpl(parentContext, new Object());
    }

    @Test
    public void testRegisterNamespace_NewNamespace() {
        String prefix = "ns";
        String uri = "http://example.com/ns";
        context.registerNamespace(prefix, uri);
        // Check if the namespace is registered
        assertEquals(uri, context.getNamespaceResolver().namespaceMap.get(prefix));
    }

    @Test
    public void testRegisterNamespace_SealedNamespaceResolver() {
        String prefix = "ns";
        String uri = "http://example.com/ns";
        // Register an initial namespace to seal the resolver
        context.registerNamespace(prefix, uri);
        // Attempt to register a new namespace, expect an exception
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            context.registerNamespace(prefix, uri);
        });
        assertEquals("Cannot register namespaces on a sealed NamespaceResolver", exception.getMessage());
    }

    @Test
    public void testRegisterNamespace_OverwriteExistingNamespace() {
        String prefix = "ns";
        String uri1 = "http://example.com/ns1";
        String uri2 = "http://example.com/ns2";
        context.registerNamespace(prefix, uri1);
        context.registerNamespace(prefix, uri2);
        // Check if the namespace is updated
        assertEquals(uri2, context.getNamespaceResolver().namespaceMap.get(prefix));
    }

    @Test
    public void testRegisterNamespace_MultipleNamespaces() {
        String prefix1 = "ns1";
        String uri1 = "http://example.com/ns1";
        String prefix2 = "ns2";
        String uri2 = "http://example.com/ns2";
        context.registerNamespace(prefix1, uri1);
        context.registerNamespace(prefix2, uri2);
        // Check if both namespaces are registered correctly
        assertEquals(uri1, context.getNamespaceResolver().namespaceMap.get(prefix1));
        assertEquals(uri2, context.getNamespaceResolver().namespaceMap.get(prefix2));
    }

    @Test
    public void testRegisterNamespace_NullPrefix() {
        String uri = "http://example.com/ns";
        // Attempt to register a null prefix, expect an exception
        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            context.registerNamespace(null, uri);
        });
        assertEquals("Prefix cannot be null", exception.getMessage());
    }

    @Test
    public void testRegisterNamespace_NullURI() {
        String prefix = "ns";
        // Attempt to register a null URI, expect an exception
        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            context.registerNamespace(prefix, null);
        });
        assertEquals("Namespace URI cannot be null", exception.getMessage());
    }
}
