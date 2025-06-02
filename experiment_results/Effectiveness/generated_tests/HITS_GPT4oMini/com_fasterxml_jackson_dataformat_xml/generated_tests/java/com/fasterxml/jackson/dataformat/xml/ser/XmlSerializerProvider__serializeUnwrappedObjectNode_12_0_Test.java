package com.fasterxml.jackson.dataformat.xml.ser;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup;
import javax.xml.namespace.QName;
import java.io.IOException;
import java.util.Collections;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Map;
import javax.xml.stream.XMLStreamException;
import com.fasterxml.jackson.databind.cfg.CacheProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.SerializerFactory;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;
import com.fasterxml.jackson.dataformat.xml.util.TypeUtil;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;

public class XmlSerializerProvider__serializeUnwrappedObjectNode_12_0_Test {

    private XmlSerializerProvider xmlSerializerProvider;

    private ToXmlGenerator toXmlGenerator;

    private JsonSerializer<Object> jsonSerializer;

    private ObjectNode objectNode;

    @BeforeEach
    public void setUp() {
        XmlRootNameLookup rootNameLookup = new XmlRootNameLookup();
        xmlSerializerProvider = new XmlSerializerProvider(rootNameLookup);
        toXmlGenerator = mock(ToXmlGenerator.class);
        jsonSerializer = mock(JsonSerializer.class);
        objectNode = mock(ObjectNode.class);
    }

    @Test
    public void testSerializeUnwrappedObjectNode_withValidInput() throws IOException {
        // Arrange
        JsonNode mockJsonNode = mock(JsonNode.class);
        when(objectNode.fields()).thenReturn(Collections.singletonMap("rootNode", mockJsonNode).entrySet().iterator());
        when(toXmlGenerator.setNextNameIfMissing(any(QName.class))).thenReturn(true);
        // Act
        xmlSerializerProvider._serializeUnwrappedObjectNode(toXmlGenerator, objectNode, jsonSerializer);
        // Assert
        verify(toXmlGenerator).setNextNameIfMissing(new QName("rootNode"));
        verify(jsonSerializer).serialize(eq(mockJsonNode), eq(toXmlGenerator), eq(xmlSerializerProvider));
    }

    @Test
    public void testSerializeUnwrappedObjectNode_withNullSerializer() throws IOException {
        // Arrange
        JsonNode mockJsonNode = mock(JsonNode.class);
        when(objectNode.fields()).thenReturn(Collections.singletonMap("rootNode", mockJsonNode).entrySet().iterator());
        when(toXmlGenerator.setNextNameIfMissing(any(QName.class))).thenReturn(true);
        when(xmlSerializerProvider.findTypedValueSerializer(eq(mockJsonNode.getClass()), anyBoolean(), any())).thenReturn(jsonSerializer);
        // Act
        xmlSerializerProvider._serializeUnwrappedObjectNode(toXmlGenerator, objectNode, null);
        // Assert
        verify(toXmlGenerator).setNextNameIfMissing(new QName("rootNode"));
        verify(jsonSerializer).serialize(eq(mockJsonNode), eq(toXmlGenerator), eq(xmlSerializerProvider));
    }
}
