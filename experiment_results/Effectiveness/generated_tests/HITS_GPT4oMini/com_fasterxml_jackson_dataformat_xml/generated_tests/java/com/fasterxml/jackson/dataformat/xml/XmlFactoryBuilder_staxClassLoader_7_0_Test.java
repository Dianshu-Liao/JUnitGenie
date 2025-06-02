package com.fasterxml.jackson.dataformat.xml;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import com.fasterxml.jackson.core.TSFBuilder;
import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;

public class XmlFactoryBuilder_staxClassLoader_7_0_Test {

    private XmlFactoryBuilder xmlFactoryBuilder;

    @BeforeEach
    public void setUp() {
        xmlFactoryBuilder = new XmlFactoryBuilder();
    }

    @Test
    public void testStaxClassLoader_WhenClassLoaderForStaxIsNull() {
        // Arrange
        // The class loader for Stax is not set, it should use the default class loader.
        // Act
        ClassLoader result = xmlFactoryBuilder.staxClassLoader();
        // Assert
        assertNotNull(result, "The class loader should not be null");
        assertEquals(getClass().getClassLoader(), result, "The class loader should be the default class loader");
    }

    @Test
    public void testStaxClassLoader_WhenClassLoaderForStaxIsNotNull() {
        // Arrange
        ClassLoader customClassLoader = new CustomClassLoader();
        xmlFactoryBuilder._classLoaderForStax = customClassLoader;
        // Act
        ClassLoader result = xmlFactoryBuilder.staxClassLoader();
        // Assert
        assertNotNull(result, "The class loader should not be null");
        assertEquals(customClassLoader, result, "The class loader should be the custom class loader");
    }

    // Custom ClassLoader for testing purposes
    private static class CustomClassLoader extends ClassLoader {
        // Custom implementation can be added if needed
    }
}
