package com.fasterxml.jackson.dataformat.xml.ser;

import com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup;
import javax.xml.namespace.QName;
import java.io.IOException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ser.SerializerFactory;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import com.fasterxml.jackson.dataformat.xml.util.TypeUtil;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Map;
import javax.xml.stream.XMLStreamException;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.cfg.CacheProvider;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;

public class XmlSerializerProvider_serializeValue_5_2_Test {

    private XmlSerializerProvider xmlSerializerProvider;

    private XmlRootNameLookup rootNameLookup;

    private JsonGenerator jsonGenerator;

    private JavaType javaType;

    private JsonSerializer<Object> jsonSerializer;

    @BeforeEach
    public void setUp() {
        rootNameLookup = new XmlRootNameLookup();
        xmlSerializerProvider = new XmlSerializerProvider(rootNameLookup);
        jsonGenerator = mock(JsonGenerator.class);
        javaType = mock(JavaType.class);
        jsonSerializer = mock(JsonSerializer.class);
    }

    @Test
    public void testSerializeValue_NullValue() throws IOException {
        xmlSerializerProvider.serializeValue(jsonGenerator, null, javaType, jsonSerializer);
        verify(jsonGenerator, times(1)).writeStartObject();
        verify(jsonGenerator, times(1)).writeEndObject();
    }

    @Test
    public void testSerializeValue_CompatibleType() throws IOException {
        Object value = "Test String";
        when(javaType.getRawClass()).thenReturn((Class) String.class);
        doNothing().when(jsonSerializer).serialize(any(), eq(jsonGenerator), eq(xmlSerializerProvider));
        xmlSerializerProvider.serializeValue(jsonGenerator, value, javaType, jsonSerializer);
        verify(jsonSerializer, times(1)).serialize(value, jsonGenerator, xmlSerializerProvider);
    }

    @Test
    public void testSerializeValue_IncompatibleType() {
        Object value = 123;
        when(javaType.getRawClass()).thenReturn((Class) String.class);
        Exception exception = assertThrows(IOException.class, () -> {
            xmlSerializerProvider.serializeValue(jsonGenerator, value, javaType, jsonSerializer);
        });
        String expectedMessage = "Incompatible type";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testSerializeValue_ArrayType() throws IOException {
        Object[] values = { "item1", "item2" };
        when(javaType.getRawClass()).thenReturn((Class) Object[].class);
        doNothing().when(jsonSerializer).serialize(any(), eq(jsonGenerator), eq(xmlSerializerProvider));
        xmlSerializerProvider.serializeValue(jsonGenerator, values, javaType, jsonSerializer);
        verify(jsonSerializer, times(1)).serialize(values, jsonGenerator, xmlSerializerProvider);
    }
}
