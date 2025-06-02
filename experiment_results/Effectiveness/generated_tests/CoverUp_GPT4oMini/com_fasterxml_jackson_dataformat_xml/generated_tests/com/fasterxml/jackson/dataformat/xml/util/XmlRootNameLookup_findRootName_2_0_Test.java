package com.fasterxml.jackson.dataformat.xml.util;

import javax.xml.namespace.QName;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.fasterxml.jackson.databind.type.ClassKey;
import com.fasterxml.jackson.databind.util.LRUMap;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import com.fasterxml.jackson.databind.*;

public class XmlRootNameLookup_findRootName_2_0_Test {

    private XmlRootNameLookup xmlRootNameLookup;

    @BeforeEach
    public void setUp() {
        xmlRootNameLookup = new XmlRootNameLookup();
    }

    @Test
    public void testFindRootNameWithNullClass() {
        QName result = xmlRootNameLookup.findRootName((Class<?>) null, null);
        assertEquals(XmlRootNameLookup.ROOT_NAME_FOR_NULL, result);
    }

    @Test
    public void testFindRootNameWithCachedValue() {
        QName expectedName = new QName("test");
        Class<?> testClass = String.class;
        // Mock or provide a suitable MapperConfig if needed
        MapperConfig<?> config = null;
        // Simulate putting a value in the cache
        xmlRootNameLookup.findRootName(testClass, config);
        // Now retrieve it again
        QName result = xmlRootNameLookup.findRootName(testClass, config);
        assertEquals(expectedName, result);
    }

    @Test
    public void testFindRootNameWithNewClass() {
        QName expectedName = new QName("newClass");
        // Use a different class
        Class<?> testClass = Integer.class;
        // Mock or provide a suitable MapperConfig if needed
        MapperConfig<?> config = null;
        // Invoke the method
        QName result = xmlRootNameLookup.findRootName(testClass, config);
        // Assuming _findRootName would return expectedName for Integer.class
        assertEquals(expectedName, result);
    }

    @Test
    public void testFindRootNameWithNonCachedClass() {
        QName expectedName = new QName("nonCachedClass");
        // Use another class
        Class<?> testClass = Double.class;
        // Mock or provide a suitable MapperConfig if needed
        MapperConfig<?> config = null;
        // Invoke the method
        QName result = xmlRootNameLookup.findRootName(testClass, config);
        // Assuming _findRootName would return expectedName for Double.class
        assertEquals(expectedName, result);
    }

    @Test
    public void testFindRootNameWithEmptyCache() {
        QName result = xmlRootNameLookup.findRootName(Object.class, null);
        // Assuming _findRootName returns null for Object.class
        assertNull(result);
    }
}
