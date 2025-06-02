package com.fasterxml.jackson.dataformat.xml;

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
    public void testStaxClassLoader_WhenClassLoaderIsNull() throws Exception {
        // Invoke the private method using reflection
        Method method = XmlFactoryBuilder.class.getDeclaredMethod("staxClassLoader");
        method.setAccessible(true);
        ClassLoader result = (ClassLoader) method.invoke(xmlFactoryBuilder);
        // Assert that the result is the system class loader
        assertEquals(ClassLoader.getSystemClassLoader(), result);
    }

    @Test
    public void testStaxClassLoader_WhenClassLoaderIsNotNull() throws Exception {
        ClassLoader customClassLoader = new ClassLoader() {
        };
        // Set the _classLoaderForStax field via reflection
        java.lang.reflect.Field field = XmlFactoryBuilder.class.getDeclaredField("_classLoaderForStax");
        field.setAccessible(true);
        field.set(xmlFactoryBuilder, customClassLoader);
        // Invoke the private method using reflection
        Method method = XmlFactoryBuilder.class.getDeclaredMethod("staxClassLoader");
        method.setAccessible(true);
        ClassLoader result = (ClassLoader) method.invoke(xmlFactoryBuilder);
        // Assert that the result is the custom class loader
        assertEquals(customClassLoader, result);
    }
}
