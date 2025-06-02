package com.fasterxml.jackson.dataformat.xml;

import com.fasterxml.jackson.dataformat.xml.XmlFactoryBuilder;
import java.lang.reflect.Method;
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
    public void testStaxClassLoader_withNullClassLoader() throws Exception {
        // Arrange
        // _classLoaderForStax is null by default
        // Act
        ClassLoader result = invokeStaxClassLoader(xmlFactoryBuilder);
        // Assert
        assertEquals(getClass().getClassLoader(), result);
    }

    @Test
    public void testStaxClassLoader_withNonNullClassLoader() throws Exception {
        // Arrange
        ClassLoader expectedClassLoader = new ClassLoader() {
        };
        setPrivateField(xmlFactoryBuilder, "_classLoaderForStax", expectedClassLoader);
        // Act
        ClassLoader result = invokeStaxClassLoader(xmlFactoryBuilder);
        // Assert
        assertEquals(expectedClassLoader, result);
    }

    private ClassLoader invokeStaxClassLoader(XmlFactoryBuilder instance) throws Exception {
        Method method = XmlFactoryBuilder.class.getDeclaredMethod("staxClassLoader");
        method.setAccessible(true);
        return (ClassLoader) method.invoke(instance);
    }

    private void setPrivateField(XmlFactoryBuilder instance, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = XmlFactoryBuilder.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(instance, value);
    }
}
