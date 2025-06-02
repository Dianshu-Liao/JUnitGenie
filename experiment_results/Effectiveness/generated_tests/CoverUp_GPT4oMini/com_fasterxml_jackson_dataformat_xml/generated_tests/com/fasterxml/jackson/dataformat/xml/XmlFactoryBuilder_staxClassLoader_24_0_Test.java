package com.fasterxml.jackson.dataformat.xml;

import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import com.fasterxml.jackson.core.TSFBuilder;
import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class XmlFactoryBuilder_staxClassLoader_24_0_Test {

    private XmlFactoryBuilder xmlFactoryBuilder;

    @BeforeEach
    public void setUp() {
        xmlFactoryBuilder = new XmlFactoryBuilder();
    }

    @Test
    public void testStaxClassLoader() throws Exception {
        ClassLoader classLoader = new ClassLoader() {
        };
        // Invoke the focal method
        XmlFactoryBuilder result = invokeStaxClassLoader(xmlFactoryBuilder, classLoader);
        // Verify the result
        assertNotNull(result);
        assertEquals(classLoader, getClassLoaderForStax(xmlFactoryBuilder));
    }

    private XmlFactoryBuilder invokeStaxClassLoader(XmlFactoryBuilder instance, ClassLoader cl) throws Exception {
        Method method = XmlFactoryBuilder.class.getDeclaredMethod("staxClassLoader", ClassLoader.class);
        method.setAccessible(true);
        return (XmlFactoryBuilder) method.invoke(instance, cl);
    }

    private ClassLoader getClassLoaderForStax(XmlFactoryBuilder instance) throws Exception {
        java.lang.reflect.Field field = XmlFactoryBuilder.class.getDeclaredField("_classLoaderForStax");
        field.setAccessible(true);
        return (ClassLoader) field.get(instance);
    }
}
