package com.fasterxml.jackson.dataformat.xml.deser;

import java.io.IOException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.databind.deser.std.DelegatingDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.deser.*;

class XmlTextDeserializer_deserialize_2_0_Test {

    private XmlTextDeserializer xmlTextDeserializer;

    private BeanDeserializerBase delegate;

    private SettableBeanProperty property;

    private ValueInstantiator valueInstantiator;

    @BeforeEach
    void setUp() {
        delegate = mock(BeanDeserializerBase.class);
        property = mock(SettableBeanProperty.class);
        valueInstantiator = mock(ValueInstantiator.class);
        xmlTextDeserializer = new XmlTextDeserializer(delegate, property);
        // Using reflection to set the _valueInstantiator field
        setPrivateField(xmlTextDeserializer, "_valueInstantiator", valueInstantiator);
    }

    @Test
    void testDeserializeWithStringValue() throws IOException {
        JsonParser parser = mock(JsonParser.class);
        DeserializationContext context = mock(DeserializationContext.class);
        Object bean = new Object();
        when(parser.getCurrentToken()).thenReturn(JsonToken.VALUE_STRING);
        when(valueInstantiator.createUsingDefault(context)).thenReturn(bean);
        // Fixed the buggy line
        doNothing().when(property).deserializeAndSet(parser, context, bean);
        Object result = xmlTextDeserializer.deserialize(parser, context);
        assertEquals(bean, result);
        verify(valueInstantiator).createUsingDefault(context);
        verify(property).deserializeAndSet(parser, context, bean);
    }

    @Test
    void testDeserializeWithNonStringValue() throws IOException {
        JsonParser parser = mock(JsonParser.class);
        DeserializationContext context = mock(DeserializationContext.class);
        when(parser.getCurrentToken()).thenReturn(JsonToken.START_OBJECT);
        Object result = xmlTextDeserializer.deserialize(parser, context);
        // Assuming delegate returns null for this test case
        assertEquals(null, result);
        verify(delegate).deserialize(parser, context);
    }

    private void setPrivateField(Object target, String fieldName, Object value) {
        try {
            // Repaired line: changed 'var' to 'Field'
            java.lang.reflect.Field field = target.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(target, value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
