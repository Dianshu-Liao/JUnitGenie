package com.fasterxml.jackson.dataformat.xml.ser;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup;
import javax.xml.namespace.QName;
import java.io.IOException;
import java.util.Iterator;
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
import com.fasterxml.jackson.databind.ser.SerializerFactory;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;
import com.fasterxml.jackson.dataformat.xml.util.TypeUtil;

class XmlSerializerProvider__serializeUnwrappedObjectNode_12_2_Test {

    private XmlSerializerProvider xmlSerializerProvider;

    private ToXmlGenerator toXmlGenerator;

    private ObjectNode objectNode;

    private JsonSerializer<Object> jsonSerializer;

    @BeforeEach
    void setUp() {
        XmlRootNameLookup rootNameLookup = new XmlRootNameLookup();
        xmlSerializerProvider = new XmlSerializerProvider(rootNameLookup);
        toXmlGenerator = mock(ToXmlGenerator.class);
        objectNode = mock(ObjectNode.class);
        jsonSerializer = mock(JsonSerializer.class);
    }

    @Test
    void testSerializeUnwrappedObjectNodeWithNullSerializer() throws IOException {
        // Arrange
        Iterator<Map.Entry<String, JsonNode>> fieldsIterator = mock(Iterator.class);
        Map.Entry<String, JsonNode> entry = mock(Map.Entry.class);
        JsonNode jsonNode = mock(JsonNode.class);
        when(objectNode.fields()).thenReturn(fieldsIterator);
        when(fieldsIterator.hasNext()).thenReturn(true);
        when(fieldsIterator.next()).thenReturn(entry);
        when(entry.getKey()).thenReturn("root");
        when(entry.getValue()).thenReturn(jsonNode);
        // Act
        xmlSerializerProvider._serializeUnwrappedObjectNode(toXmlGenerator, objectNode, null);
        // Assert
        verify(toXmlGenerator).setNextNameIfMissing(new QName("root"));
        verify(jsonSerializer).serialize(jsonNode, toXmlGenerator, xmlSerializerProvider);
    }

    @Test
    void testSerializeUnwrappedObjectNodeWithCustomSerializer() throws IOException {
        // Arrange
        Iterator<Map.Entry<String, JsonNode>> fieldsIterator = mock(Iterator.class);
        Map.Entry<String, JsonNode> entry = mock(Map.Entry.class);
        JsonNode jsonNode = mock(JsonNode.class);
        when(objectNode.fields()).thenReturn(fieldsIterator);
        when(fieldsIterator.hasNext()).thenReturn(true);
        when(fieldsIterator.next()).thenReturn(entry);
        when(entry.getKey()).thenReturn("root");
        when(entry.getValue()).thenReturn(jsonNode);
        // Act
        xmlSerializerProvider._serializeUnwrappedObjectNode(toXmlGenerator, objectNode, jsonSerializer);
        // Assert
        verify(toXmlGenerator).setNextNameIfMissing(new QName("root"));
        verify(jsonSerializer).serialize(jsonNode, toXmlGenerator, xmlSerializerProvider);
    }

    @Test
    void testSerializeUnwrappedObjectNodeThrowsIOException() throws IOException {
        // Arrange
        Iterator<Map.Entry<String, JsonNode>> fieldsIterator = mock(Iterator.class);
        Map.Entry<String, JsonNode> entry = mock(Map.Entry.class);
        JsonNode jsonNode = mock(JsonNode.class);
        when(objectNode.fields()).thenReturn(fieldsIterator);
        when(fieldsIterator.hasNext()).thenReturn(true);
        when(fieldsIterator.next()).thenReturn(entry);
        when(entry.getKey()).thenReturn("root");
        when(entry.getValue()).thenReturn(jsonNode);
        doThrow(new IOException("Serialization Error")).when(jsonSerializer).serialize(jsonNode, toXmlGenerator, xmlSerializerProvider);
        // Act & Assert
        try {
            xmlSerializerProvider._serializeUnwrappedObjectNode(toXmlGenerator, objectNode, jsonSerializer);
        } catch (IOException e) {
            assertEquals("Serialization Error", e.getMessage());
        }
    }
}
