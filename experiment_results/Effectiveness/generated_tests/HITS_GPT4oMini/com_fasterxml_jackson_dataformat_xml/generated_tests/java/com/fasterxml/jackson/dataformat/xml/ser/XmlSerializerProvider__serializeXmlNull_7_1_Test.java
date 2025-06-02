package com.fasterxml.jackson.dataformat.xml.ser;

import com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup;
import javax.xml.namespace.QName;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
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

public class XmlSerializerProvider__serializeXmlNull_7_1_Test {

    private XmlSerializerProvider xmlSerializerProvider;

    private JsonGenerator jsonGenerator;

    @BeforeEach
    public void setUp() {
        XmlRootNameLookup rootNameLookup = new XmlRootNameLookup();
        xmlSerializerProvider = new XmlSerializerProvider(rootNameLookup);
        jsonGenerator = mock(JsonGenerator.class);
    }

    @Test
    public void testSerializeXmlNullWithDefaultRootName() throws Exception {
        // Arrange
        when(jsonGenerator instanceof ToXmlGenerator).thenReturn(true);
        ToXmlGenerator toXmlGenerator = mock(ToXmlGenerator.class);
        when((ToXmlGenerator) jsonGenerator).thenReturn(toXmlGenerator);
        // Act
        xmlSerializerProvider._serializeXmlNull(jsonGenerator);
        // Assert
        verify(toXmlGenerator).setNextNameIfMissing(XmlRootNameLookup.ROOT_NAME_FOR_NULL);
        verify(jsonGenerator).writeNull();
    }

    @Test
    public void testSerializeXmlNullWithCustomRootName() throws Exception {
        // Arrange
        QName customRootName = new QName("customNamespace", "customRoot");
        XmlRootNameLookup rootNameLookup = new XmlRootNameLookup();
        xmlSerializerProvider = new XmlSerializerProvider(rootNameLookup) {

            @Override
            protected QName _rootNameFromConfig() {
                return customRootName;
            }
        };
        when(jsonGenerator instanceof ToXmlGenerator).thenReturn(true);
        ToXmlGenerator toXmlGenerator = mock(ToXmlGenerator.class);
        when((ToXmlGenerator) jsonGenerator).thenReturn(toXmlGenerator);
        // Act
        xmlSerializerProvider._serializeXmlNull(jsonGenerator);
        // Assert
        verify(toXmlGenerator).setNextNameIfMissing(customRootName);
        verify(jsonGenerator).writeNull();
    }

    @Test
    public void testSerializeXmlNullWithNoRootName() throws Exception {
        // Arrange
        XmlRootNameLookup rootNameLookup = new XmlRootNameLookup();
        xmlSerializerProvider = new XmlSerializerProvider(rootNameLookup) {

            @Override
            protected QName _rootNameFromConfig() {
                return null;
            }
        };
        when(jsonGenerator instanceof ToXmlGenerator).thenReturn(true);
        ToXmlGenerator toXmlGenerator = mock(ToXmlGenerator.class);
        when((ToXmlGenerator) jsonGenerator).thenReturn(toXmlGenerator);
        // Act
        xmlSerializerProvider._serializeXmlNull(jsonGenerator);
        // Assert
        verify(toXmlGenerator).setNextNameIfMissing(XmlRootNameLookup.ROOT_NAME_FOR_NULL);
        verify(jsonGenerator).writeNull();
    }
}
