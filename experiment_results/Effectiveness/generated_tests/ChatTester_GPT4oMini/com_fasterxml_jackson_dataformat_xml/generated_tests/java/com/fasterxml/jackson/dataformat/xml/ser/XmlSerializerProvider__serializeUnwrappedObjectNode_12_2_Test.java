package com.fasterxml.jackson.dataformat.xml.ser;

import com.fasterxml.jackson.databind.node.ObjectNode;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import javax.xml.namespace.QName;
import com.fasterxml.jackson.databind.cfg.CacheProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.SerializerFactory;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;
import com.fasterxml.jackson.dataformat.xml.util.TypeUtil;
import com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;

class XmlSerializerProvider__serializeUnwrappedObjectNode_12_2_Test {

    private XmlSerializerProvider xmlSerializerProvider;

    private ToXmlGenerator toXmlGenerator;

    private ObjectNode objectNode;

    private JsonSerializer<Object> jsonSerializer;

    @BeforeEach
    void setUp() {
        XmlRootNameLookup rootNameLookup = mock(XmlRootNameLookup.class);
        xmlSerializerProvider = new XmlSerializerProvider(rootNameLookup);
        toXmlGenerator = mock(ToXmlGenerator.class);
        objectNode = mock(ObjectNode.class);
        jsonSerializer = mock(JsonSerializer.class);
    }

    @Test
    void testSerializeUnwrappedObjectNode_withValidInputs() throws IOException {
        // Arrange
        Map.Entry<String, JsonNode> entry = mock(Map.Entry.class);
        JsonNode newRoot = mock(JsonNode.class);
        when(objectNode.fields()).thenReturn(new Iterator<Map.Entry<String, JsonNode>>() {

            private boolean hasNext = true;

            @Override
            public boolean hasNext() {
                return hasNext;
            }

            @Override
            public Map.Entry<String, JsonNode> next() {
                hasNext = false;
                return entry;
            }
        });
        when(entry.getKey()).thenReturn("key");
        when(entry.getValue()).thenReturn(newRoot);
        // Fixed Buggy Line: Removed the return null as void methods do not return values
        doNothing().when(jsonSerializer).serialize(eq(newRoot), eq(toXmlGenerator), eq(xmlSerializerProvider));
        // Act
        xmlSerializerProvider._serializeUnwrappedObjectNode(toXmlGenerator, objectNode, jsonSerializer);
        // Assert
        verify(toXmlGenerator).writeStartObject();
        verify(jsonSerializer).serialize(newRoot, toXmlGenerator, xmlSerializerProvider);
    }

    @Test
    void testSerializeUnwrappedObjectNode_withNullSerializer() throws IOException {
        // Arrange
        Map.Entry<String, JsonNode> entry = mock(Map.Entry.class);
        JsonNode newRoot = mock(JsonNode.class);
        when(objectNode.fields()).thenReturn(new Iterator<Map.Entry<String, JsonNode>>() {

            private boolean hasNext = true;

            @Override
            public boolean hasNext() {
                return hasNext;
            }

            @Override
            public Map.Entry<String, JsonNode> next() {
                hasNext = false;
                return entry;
            }
        });
        when(entry.getKey()).thenReturn("key");
        when(entry.getValue()).thenReturn(newRoot);
        // Act & Assert
        assertThrows(IOException.class, () -> {
            xmlSerializerProvider._serializeUnwrappedObjectNode(toXmlGenerator, objectNode, null);
        });
    }

    @Test
    void testSerializeUnwrappedObjectNode_withSerializationException() throws IOException {
        // Arrange
        Map.Entry<String, JsonNode> entry = mock(Map.Entry.class);
        JsonNode newRoot = mock(JsonNode.class);
        when(objectNode.fields()).thenReturn(new Iterator<Map.Entry<String, JsonNode>>() {

            private boolean hasNext = true;

            @Override
            public boolean hasNext() {
                return hasNext;
            }

            @Override
            public Map.Entry<String, JsonNode> next() {
                hasNext = false;
                return entry;
            }
        });
        when(entry.getKey()).thenReturn("key");
        when(entry.getValue()).thenReturn(newRoot);
        doThrow(new IOException("Serialization error")).when(jsonSerializer).serialize(newRoot, toXmlGenerator, xmlSerializerProvider);
        // Act & Assert
        assertThrows(IOException.class, () -> {
            xmlSerializerProvider._serializeUnwrappedObjectNode(toXmlGenerator, objectNode, jsonSerializer);
        });
    }
}
