package org.apache.commons.jxpath.ri;

import org.apache.commons.jxpath.ri.JXPathContextReferenceImpl;
import org.apache.commons.jxpath.ri.NamespaceResolver;
import org.apache.commons.jxpath.Pointer;
import org.apache.commons.jxpath.JXPathContext;
import java.lang.reflect.Field;
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

class JXPathContextReferenceImpl_registerNamespace_36_0_Test {

    private JXPathContextReferenceImpl context;

    @BeforeEach
    void setUp() {
        // Mock or create a parent context if necessary
        JXPathContext parentContext = null;
        context = new JXPathContextReferenceImpl(parentContext, new Object());
    }

    @Test
    void testRegisterNamespace() {
        String prefix = "ns";
        String namespaceURI = "http://example.com/ns";
        // Ensure the namespace is initially not registered
        NamespaceResolver resolver = context.getNamespaceResolver();
        assertNull(resolver.namespaceMap.get(prefix));
        // Register the namespace
        context.registerNamespace(prefix, namespaceURI);
        // Verify the namespace is registered
        assertEquals(namespaceURI, resolver.namespaceMap.get(prefix));
    }

    @Test
    void testRegisterNamespaceSealed() {
        String prefix = "ns";
        String namespaceURI = "http://example.com/ns";
        // Register the namespace first
        context.registerNamespace(prefix, namespaceURI);
        // Seal the namespace resolver to prevent further modifications
        sealNamespaceResolver(context);
        // Attempt to register a new namespace and expect an exception
        assertThrows(IllegalStateException.class, () -> {
            context.registerNamespace("newNs", "http://example.com/newNs");
        });
    }

    private void sealNamespaceResolver(JXPathContextReferenceImpl context) {
        try {
            Field resolverField = JXPathContextReferenceImpl.class.getDeclaredField("namespaceResolver");
            resolverField.setAccessible(true);
            NamespaceResolver resolver = (NamespaceResolver) resolverField.get(context);
            Field sealedField = NamespaceResolver.class.getDeclaredField("sealed");
            sealedField.setAccessible(true);
            sealedField.set(resolver, true);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Failed to seal the NamespaceResolver: " + e.getMessage());
        }
    }
}
