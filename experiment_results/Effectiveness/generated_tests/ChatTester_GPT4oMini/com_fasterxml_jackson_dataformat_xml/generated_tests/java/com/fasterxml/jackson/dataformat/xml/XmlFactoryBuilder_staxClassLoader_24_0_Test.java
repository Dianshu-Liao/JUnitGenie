package com.fasterxml.jackson.dataformat.xml;

import java.lang.reflect.Field;
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

    private XmlFactoryBuilder xmlFactoryBuilder;

    @BeforeEach
    public void setUp() {
        // Assuming default constructor is available.
        xmlFactoryBuilder = new XmlFactoryBuilder();
    }

    @Test
    public void testStaxClassLoader() throws Exception {
        // Arrange
        // Create a new anonymous ClassLoader
        ClassLoader classLoader = new ClassLoader() {
        };
        // Act
        XmlFactoryBuilder result = xmlFactoryBuilder.staxClassLoader(classLoader);
        // Assert
        assertEquals(classLoader, getPrivateField(xmlFactoryBuilder, "_classLoaderForStax"));
        assertEquals(xmlFactoryBuilder, result);
    }

    // Reflection method to access private fields
    private Object getPrivateField(Object obj, String fieldName) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(obj);
    }
}
