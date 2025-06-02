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

class XmlFactoryBuilder_staxClassLoader_24_1_Test {

    private XmlFactoryBuilder xmlFactoryBuilder;

    @BeforeEach
    void setUp() {
        xmlFactoryBuilder = new XmlFactoryBuilder();
    }

    @Test
    void testStaxClassLoader() throws Exception {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        // Invoke the staxClassLoader method using reflection
        Method method = XmlFactoryBuilder.class.getDeclaredMethod("staxClassLoader", ClassLoader.class);
        method.setAccessible(true);
        // Call the method
        XmlFactoryBuilder result = (XmlFactoryBuilder) method.invoke(xmlFactoryBuilder, classLoader);
        // Assertions
        assertNotNull(result);
        assertEquals(classLoader, result._classLoaderForStax);
    }
}
