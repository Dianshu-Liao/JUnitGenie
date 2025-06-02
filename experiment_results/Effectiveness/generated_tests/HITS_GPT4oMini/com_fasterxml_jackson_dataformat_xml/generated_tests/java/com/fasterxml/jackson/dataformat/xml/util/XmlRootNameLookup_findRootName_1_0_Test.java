package com.fasterxml.jackson.dataformat.xml.util;

import javax.xml.namespace.QName;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.fasterxml.jackson.databind.type.ClassKey;
import com.fasterxml.jackson.databind.util.LRUMap;

public class XmlRootNameLookup_findRootName_1_0_Test {

    private XmlRootNameLookup xmlRootNameLookup;

    @BeforeEach
    public void setUp() {
        xmlRootNameLookup = new XmlRootNameLookup();
    }

    @Test
    public void testFindRootNameWithNonNullClass() {
        // Arrange
        // Example class
        Class<?> clazz = String.class;
        JavaType javaType = TypeFactory.defaultInstance().constructSimpleType(clazz, null);
        // Use a mock or a real instance if needed
        MapperConfig<?> config = null;
        // Act
        QName result = xmlRootNameLookup.findRootName(javaType, config);
        // Assert
        assertNotNull(result);
        // Assuming QName is generated with local part as class name
        assertEquals("String", result.getLocalPart());
    }

    @Test
    public void testFindRootNameWithNullClass() {
        // Arrange
        JavaType javaType = TypeFactory.defaultInstance().constructSimpleType(Object.class, null);
        // Use a mock or a real instance if needed
        MapperConfig<?> config = null;
        // Act
        QName result = xmlRootNameLookup.findRootName(javaType, config);
        // Assert
        assertNotNull(result);
        // Should return ROOT_NAME_FOR_NULL
        assertEquals("null", result.getLocalPart());
    }

    @Test
    public void testFindRootNameWithUnknownType() {
        // Arrange
        JavaType javaType = TypeFactory.defaultInstance().constructSimpleType(Void.class, null);
        // Use a mock or a real instance if needed
        MapperConfig<?> config = null;
        // Act
        QName result = xmlRootNameLookup.findRootName(javaType, config);
        // Assert
        assertNotNull(result);
        // Should return ROOT_NAME_FOR_NULL
        assertEquals("null", result.getLocalPart());
    }
}
