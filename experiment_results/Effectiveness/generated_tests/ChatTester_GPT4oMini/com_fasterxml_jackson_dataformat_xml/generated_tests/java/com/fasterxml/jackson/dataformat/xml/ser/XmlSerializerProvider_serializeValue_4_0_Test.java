package com.fasterxml.jackson.dataformat.xml.ser;

import java.io.IOException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Map;
import javax.xml.namespace.QName;
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
import com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup;

class XmlSerializerProvider_serializeValue_4_0_Test {

    private XmlSerializerProvider xmlSerializerProvider;

    private XmlRootNameLookup mockRootNameLookup;

    @BeforeEach
    void setUp() {
        mockRootNameLookup = mock(XmlRootNameLookup.class);
        xmlSerializerProvider = new XmlSerializerProvider(mockRootNameLookup);
    }

    @Test
    void testSerializeValue() throws IOException {
        JsonGenerator mockJsonGenerator = mock(JsonGenerator.class);
        Object mockValue = new Object();
        JavaType mockRootType = mock(JavaType.class);
        // Invoke the focal method using reflection
        xmlSerializerProvider.serializeValue(mockJsonGenerator, mockValue, mockRootType);
        // Verify interactions with the JsonGenerator
        ArgumentCaptor<Object> valueCaptor = ArgumentCaptor.forClass(Object.class);
        verify(mockJsonGenerator, times(1)).writeObject(valueCaptor.capture());
        assertNotNull(valueCaptor.getValue());
    }
}
