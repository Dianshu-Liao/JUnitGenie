package com.fasterxml.jackson.dataformat.xml;

import javax.xml.stream.XMLOutputFactory;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import javax.xml.stream.XMLInputFactory;
import com.fasterxml.jackson.core.TSFBuilder;
import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class XmlFactoryBuilder_xmlOutputFactory_5_0_Test {

    private XmlFactoryBuilder xmlFactoryBuilder;

    @BeforeEach
    public void setUp() {
        xmlFactoryBuilder = new XmlFactoryBuilder();
    }

    @Test
    public void testXmlOutputFactory_WhenOutputFactoryIsNull_ReturnsDefaultOutputFactory() throws Exception {
        // Arrange
        // _xmlOutputFactory is null by default
        // Act
        XMLOutputFactory result = xmlFactoryBuilder.xmlOutputFactory();
        // Assert
        assertNotNull(result, "Expected default output factory to be returned");
    }

    @Test
    public void testXmlOutputFactory_WhenOutputFactoryIsNotNull_ReturnsOutputFactory() throws Exception {
        // Arrange
        XMLOutputFactory expectedOutputFactory = XMLOutputFactory.newInstance();
        setPrivateField(xmlFactoryBuilder, "_xmlOutputFactory", expectedOutputFactory);
        // Act
        XMLOutputFactory result = xmlFactoryBuilder.xmlOutputFactory();
        // Assert
        assertEquals(expectedOutputFactory, result, "Expected the same output factory to be returned");
    }

    private void setPrivateField(Object target, String fieldName, Object value) throws Exception {
        // Fixed line: Use 'Field' instead of 'var'
        java.lang.reflect.Field field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(target, value);
    }
}
