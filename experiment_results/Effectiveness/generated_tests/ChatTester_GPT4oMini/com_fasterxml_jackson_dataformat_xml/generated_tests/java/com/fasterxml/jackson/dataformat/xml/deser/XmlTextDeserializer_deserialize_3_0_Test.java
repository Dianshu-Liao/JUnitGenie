package com.fasterxml.jackson.dataformat.xml.deser;

import java.io.IOException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.deser.*;
import com.fasterxml.jackson.databind.deser.std.DelegatingDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;

class XmlTextDeserializer_deserialize_3_0_Test {

    private XmlTextDeserializer xmlTextDeserializer;

    private JsonParser jsonParser;

    private DeserializationContext deserializationContext;

    private Object bean;

    private SettableBeanProperty settableBeanProperty;

    private BeanDeserializerBase beanDeserializerBase;

    @BeforeEach
    void setUp() {
        settableBeanProperty = mock(SettableBeanProperty.class);
        beanDeserializerBase = mock(BeanDeserializerBase.class);
        xmlTextDeserializer = new XmlTextDeserializer(beanDeserializerBase, settableBeanProperty);
        jsonParser = mock(JsonParser.class);
        deserializationContext = mock(DeserializationContext.class);
        bean = new Object();
    }

    @Test
    void testDeserializeWithStringValue() throws IOException {
        // Arrange
        when(jsonParser.getCurrentToken()).thenReturn(JsonToken.VALUE_STRING);
        // Act
        Object result = xmlTextDeserializer.deserialize(jsonParser, deserializationContext, bean);
        // Assert
        verify(settableBeanProperty).deserializeAndSet(jsonParser, deserializationContext, bean);
        assertEquals(bean, result);
    }

    @Test
    void testDeserializeWithNonStringValue() throws IOException {
        // Arrange
        when(jsonParser.getCurrentToken()).thenReturn(JsonToken.START_OBJECT);
        JsonDeserializer<Object> mockDeserializer = mock(JsonDeserializer.class);
        when(beanDeserializerBase.deserialize(jsonParser, deserializationContext, bean)).thenReturn(bean);
        // Act
        Object result = xmlTextDeserializer.deserialize(jsonParser, deserializationContext, bean);
        // Assert
        verify(beanDeserializerBase).deserialize(jsonParser, deserializationContext, bean);
        assertEquals(bean, result);
    }
}
