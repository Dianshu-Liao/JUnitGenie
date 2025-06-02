package com.fasterxml.jackson.dataformat.xml.ser;

import com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup;
import javax.xml.namespace.QName;
import java.io.IOException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Map;
import javax.xml.stream.XMLStreamException;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.cfg.CacheProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ser.SerializerFactory;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;
import com.fasterxml.jackson.dataformat.xml.util.TypeUtil;

public class XmlSerializerProvider__serializeXmlNull_7_0_Test {

    private XmlSerializerProvider xmlSerializerProvider;

    private JsonGenerator jsonGenerator;

    private XmlRootNameLookup xmlRootNameLookup;

    @BeforeEach
    public void setUp() {
        xmlRootNameLookup = new XmlRootNameLookup();
        xmlSerializerProvider = new XmlSerializerProvider(xmlRootNameLookup);
        jsonGenerator = Mockito.mock(JsonGenerator.class);
    }

    @Test
    public void testSerializeXmlNull_WithNullRootName() throws IOException {
        // Arrange
        when(xmlSerializerProvider._rootNameFromConfig()).thenReturn(null);
        // Act
        xmlSerializerProvider._serializeXmlNull(jsonGenerator);
        // Assert
        verify(jsonGenerator, times(1)).writeStartObject();
        verify(jsonGenerator, times(1)).writeEndObject();
    }

    @Test
    public void testSerializeXmlNull_WithConfiguredRootName() throws IOException {
        // Arrange
        QName configuredRootName = new QName("configuredRoot");
        when(xmlSerializerProvider._rootNameFromConfig()).thenReturn(configuredRootName);
        doNothing().when(jsonGenerator).writeStartObject();
        doNothing().when(jsonGenerator).writeEndObject();
        // Act
        xmlSerializerProvider._serializeXmlNull(jsonGenerator);
        // Assert
        verify(jsonGenerator, times(1)).writeStartObject();
        verify(jsonGenerator, times(1)).writeEndObject();
    }

    @Test
    public void testSerializeXmlNull_WithToXmlGenerator() throws IOException {
        // Arrange
        ToXmlGenerator toXmlGenerator = Mockito.mock(ToXmlGenerator.class);
        QName rootName = new QName("rootName");
        when(xmlSerializerProvider._rootNameFromConfig()).thenReturn(rootName);
        xmlSerializerProvider._initWithRootName(toXmlGenerator, rootName);
        // Act
        xmlSerializerProvider._serializeXmlNull(toXmlGenerator);
        // Assert
        verify(toXmlGenerator, times(1)).setNextNameIfMissing(rootName);
        verify(toXmlGenerator, times(1)).initGenerator();
    }
}
