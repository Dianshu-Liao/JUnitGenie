package com.fasterxml.jackson.dataformat.xml.util;

import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import javax.xml.namespace.QName;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.fasterxml.jackson.databind.type.ClassKey;
import com.fasterxml.jackson.databind.util.LRUMap;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import com.fasterxml.jackson.databind.*;

public class XmlRootNameLookup_readResolve_0_0_Test {

    private XmlRootNameLookup xmlRootNameLookup;

    @BeforeEach
    public void setUp() {
        xmlRootNameLookup = new XmlRootNameLookup();
    }

    @Test
    public void testReadResolve_NullRootNames() throws Exception {
        // Set _rootNames to null using reflection
        setField(xmlRootNameLookup, "_rootNames", null);
        // Invoke readResolve method using reflection
        Method readResolveMethod = XmlRootNameLookup.class.getDeclaredMethod("readResolve");
        readResolveMethod.setAccessible(true);
        Object result = readResolveMethod.invoke(xmlRootNameLookup);
        // Assert that the result is a new instance of XmlRootNameLookup
        assertNotNull(result);
        assertSame(XmlRootNameLookup.class, result.getClass());
    }

    @Test
    public void testReadResolve_NonNullRootNames() throws Exception {
        // Initialize _rootNames with a new LRUMap instance
        setField(xmlRootNameLookup, "_rootNames", new LRUMap<ClassKey, QName>(16, 16));
        // Invoke readResolve method using reflection
        Method readResolveMethod = XmlRootNameLookup.class.getDeclaredMethod("readResolve");
        readResolveMethod.setAccessible(true);
        Object result = readResolveMethod.invoke(xmlRootNameLookup);
        // Assert that the result is the same instance
        assertSame(xmlRootNameLookup, result);
    }

    private void setField(Object target, String fieldName, Object value) throws Exception {
        // Fixed the buggy line by replacing 'var' with 'java.lang.reflect.Field'
        java.lang.reflect.Field field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(target, value);
    }
}
