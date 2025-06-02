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

public class XmlFactoryBuilder_staxClassLoader_24_0_Test {

    @Test
    public void testStaxClassLoader_NullClassLoader() {
        // Arrange
        XmlFactoryBuilder builder = new XmlFactoryBuilder();
        ClassLoader cl = null;
        // Act
        XmlFactoryBuilder result = builder.staxClassLoader(cl);
        // Assert
        Assertions.assertNotNull(result);
        Assertions.assertNull(result._classLoaderForStax);
    }

    @Test
    public void testStaxClassLoader_ValidClassLoader() {
        // Arrange
        XmlFactoryBuilder builder = new XmlFactoryBuilder();
        ClassLoader cl = new ClassLoader() {
        };
        // Act
        XmlFactoryBuilder result = builder.staxClassLoader(cl);
        // Assert
        Assertions.assertNotNull(result);
        Assertions.assertEquals(cl, result._classLoaderForStax);
    }

    @Test
    public void testStaxClassLoader_SameInstanceReturned() {
        // Arrange
        XmlFactoryBuilder builder = new XmlFactoryBuilder();
        ClassLoader cl = new ClassLoader() {
        };
        // Act
        XmlFactoryBuilder result = builder.staxClassLoader(cl);
        // Assert
        Assertions.assertSame(builder, result);
    }
}
