package com.fasterxml.jackson.dataformat.xml.util;

import javax.xml.namespace.QName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.fasterxml.jackson.databind.type.ClassKey;
import com.fasterxml.jackson.databind.util.LRUMap;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import com.fasterxml.jackson.databind.*;

class XmlRootNameLookup_readResolve_0_0_Test {

    private XmlRootNameLookup xmlRootNameLookup;

    @BeforeEach
    void setUp() {
        xmlRootNameLookup = new XmlRootNameLookup();
    }

    @Test
    void testReadResolve_WithNullRootNames() throws Exception {
        // Set _rootNames to null using reflection
        java.lang.reflect.Field rootNamesField = XmlRootNameLookup.class.getDeclaredField("_rootNames");
        rootNamesField.setAccessible(true);
        rootNamesField.set(xmlRootNameLookup, null);
        // Invoke readResolve using reflection
        java.lang.reflect.Method readResolveMethod = XmlRootNameLookup.class.getDeclaredMethod("readResolve");
        readResolveMethod.setAccessible(true);
        // Execute the method and get the result
        Object result = readResolveMethod.invoke(xmlRootNameLookup);
        // Verify that a new instance is returned
        assertNotNull(result);
        assertNotSame(xmlRootNameLookup, result);
    }

    @Test
    void testReadResolve_WithNonNullRootNames() throws Exception {
        // Set _rootNames to a non-null value
        java.lang.reflect.Field rootNamesField = XmlRootNameLookup.class.getDeclaredField("_rootNames");
        rootNamesField.setAccessible(true);
        // Fixed constructor parameters
        rootNamesField.set(xmlRootNameLookup, new LRUMap<ClassKey, QName>(10, 10));
        // Invoke readResolve using reflection
        java.lang.reflect.Method readResolveMethod = XmlRootNameLookup.class.getDeclaredMethod("readResolve");
        readResolveMethod.setAccessible(true);
        // Execute the method and get the result
        Object result = readResolveMethod.invoke(xmlRootNameLookup);
        // Verify that the same instance is returned
        assertNotNull(result);
        assertSame(xmlRootNameLookup, result);
    }
}
