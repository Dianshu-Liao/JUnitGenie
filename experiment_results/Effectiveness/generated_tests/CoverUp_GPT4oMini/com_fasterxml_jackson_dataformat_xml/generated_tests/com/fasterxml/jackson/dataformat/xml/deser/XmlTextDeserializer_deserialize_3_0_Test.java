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

public class XmlTextDeserializer_deserialize_3_0_Test {

    private XmlTextDeserializer xmlTextDeserializer;

    private JsonParser jsonParser;

    private DeserializationContext deserializationContext;

    private SettableBeanProperty xmlTextProperty;

    private Object bean;

    @BeforeEach
    public void setUp() {
        xmlTextProperty = mock(SettableBeanProperty.class);
        BeanDeserializerBase delegate = mock(BeanDeserializerBase.class);
        xmlTextDeserializer = new XmlTextDeserializer(delegate, xmlTextProperty);
        jsonParser = mock(JsonParser.class);
        deserializationContext = mock(DeserializationContext.class);
        bean = new Object();
    }

    @Test
    public void testDeserialize_WithStringToken() throws IOException {
        when(jsonParser.getCurrentToken()).thenReturn(JsonToken.VALUE_STRING);
        doNothing().when(xmlTextProperty).deserializeAndSet(jsonParser, deserializationContext, bean);
        Object result = xmlTextDeserializer.deserialize(jsonParser, deserializationContext, bean);
        verify(xmlTextProperty).deserializeAndSet(jsonParser, deserializationContext, bean);
        verifyNoMoreInteractions(xmlTextProperty);
        assertSame(bean, result);
    }

    @Test
    public void testDeserialize_WithNonStringToken() throws IOException {
        JsonDeserializer<Object> delegate = mock(JsonDeserializer.class);
        when(jsonParser.getCurrentToken()).thenReturn(JsonToken.START_OBJECT);
        when(delegate.deserialize(jsonParser, deserializationContext, bean)).thenReturn(bean);
        // Set delegate in the deserializer
        setDelegatee(xmlTextDeserializer, delegate);
        Object result = xmlTextDeserializer.deserialize(jsonParser, deserializationContext, bean);
        verify(delegate).deserialize(jsonParser, deserializationContext, bean);
        assertSame(bean, result);
    }

    private void setDelegatee(XmlTextDeserializer deserializer, JsonDeserializer<Object> delegate) {
        try {
            java.lang.reflect.Field field = XmlTextDeserializer.class.getDeclaredField("_delegatee");
            field.setAccessible(true);
            field.set(deserializer, delegate);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
