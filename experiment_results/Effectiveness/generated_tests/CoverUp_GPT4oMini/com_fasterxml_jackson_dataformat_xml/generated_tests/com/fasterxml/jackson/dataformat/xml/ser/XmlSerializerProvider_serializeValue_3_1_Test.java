package com.fasterxml.jackson.dataformat.xml.ser;

import com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup;
import com.fasterxml.jackson.databind.ser.SerializerFactory;
import javax.xml.namespace.QName;
import java.io.IOException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.dataformat.xml.util.TypeUtil;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;
import java.util.Map;
import javax.xml.stream.XMLStreamException;
import com.fasterxml.jackson.databind.cfg.CacheProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;

@ExtendWith(MockitoExtension.class)
class XmlSerializerProvider_serializeValue_3_1_Test {

    private XmlSerializerProvider xmlSerializerProvider;

    private JsonGenerator jsonGenerator;

    private XmlRootNameLookup rootNameLookup;

    @BeforeEach
    void setUp() {
        rootNameLookup = new XmlRootNameLookup();
        xmlSerializerProvider = new XmlSerializerProvider(rootNameLookup);
        jsonGenerator = mock(JsonGenerator.class);
    }

    @Test
    void testSerializeValue_NullValue() throws IOException {
        xmlSerializerProvider.serializeValue(jsonGenerator, null);
        verify(jsonGenerator, times(1)).writeStartObject();
        verify(jsonGenerator, times(1)).writeFieldName("null");
        verify(jsonGenerator, times(1)).writeEndObject();
    }

    @Test
    void testSerializeValue_WithObjectNode() throws IOException {
        ObjectNode objectNode = mock(ObjectNode.class);
        when(objectNode.size()).thenReturn(1);
        ToXmlGenerator toXmlGenerator = mock(ToXmlGenerator.class);
        when(toXmlGenerator.isEnabled(ToXmlGenerator.Feature.UNWRAP_ROOT_OBJECT_NODE)).thenReturn(true);
        when(xmlSerializerProvider._asXmlGenerator(jsonGenerator)).thenReturn(toXmlGenerator);
        xmlSerializerProvider.serializeValue(jsonGenerator, objectNode);
        verify(toXmlGenerator, times(1)).writeStartObject();
        verify(toXmlGenerator, times(1)).writeFieldName("item");
        verify(toXmlGenerator, times(1)).writeEndObject();
    }

    @Test
    void testSerializeValue_WithValidObject() throws IOException {
        MyTestObject testObject = new MyTestObject("test");
        QName rootName = new QName("testNamespace", "testName");
        when(xmlSerializerProvider._rootNameFromConfig()).thenReturn(rootName);
        ToXmlGenerator toXmlGenerator = mock(ToXmlGenerator.class);
        when(xmlSerializerProvider._asXmlGenerator(jsonGenerator)).thenReturn(toXmlGenerator);
        xmlSerializerProvider.serializeValue(jsonGenerator, testObject);
        verify(toXmlGenerator, times(1)).writeStartObject();
        verify(toXmlGenerator, times(1)).writeFieldName("item");
        verify(toXmlGenerator, times(1)).writeEndObject();
    }

    @Test
    void testSerializeValue_WithRuntimeException() {
        MyTestObject testObject = new MyTestObject("test");
        try {
            when(xmlSerializerProvider.findTypedValueSerializer(any(Class.class), anyBoolean(), any(BeanProperty.class))).thenThrow(new RuntimeException("Test Exception"));
            assertThrows(IOException.class, () -> {
                xmlSerializerProvider.serializeValue(jsonGenerator, testObject);
            });
        } catch (Exception e) {
            fail("Exception should not be thrown here: " + e.getMessage());
        }
    }

    @Test
    void testSerializeValue_WithExceptionInSerialization() {
        MyTestObject testObject = new MyTestObject("test");
        try {
            when(xmlSerializerProvider.findTypedValueSerializer(any(Class.class), anyBoolean(), any(BeanProperty.class))).thenThrow(new JsonMappingException("Mapping Exception"));
            assertThrows(IOException.class, () -> {
                xmlSerializerProvider.serializeValue(jsonGenerator, testObject);
            });
        } catch (Exception e) {
            fail("Exception should not be thrown here: " + e.getMessage());
        }
    }

    private static class MyTestObject {

        private String name;

        public MyTestObject(String name) {
            this.name = name;
        }
    }
}
