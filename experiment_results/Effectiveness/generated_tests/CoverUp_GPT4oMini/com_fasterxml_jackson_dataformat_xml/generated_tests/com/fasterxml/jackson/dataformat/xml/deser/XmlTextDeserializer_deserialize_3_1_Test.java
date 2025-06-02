package com.fasterxml.jackson.dataformat.xml.deser;

import java.io.IOException;
import java.lang.reflect.Field;
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

public class XmlTextDeserializer_deserialize_3_1_Test {

    private XmlTextDeserializer xmlTextDeserializer;

    private BeanDeserializerBase delegate;

    private SettableBeanProperty xmlTextProperty;

    @BeforeEach
    public void setUp() {
        delegate = mock(BeanDeserializerBase.class);
        xmlTextProperty = mock(SettableBeanProperty.class);
        xmlTextDeserializer = new XmlTextDeserializer(delegate, xmlTextProperty);
    }

    @Test
    public void testDeserializeWithStringToken() throws IOException {
        JsonParser jsonParser = mock(JsonParser.class);
        DeserializationContext deserializationContext = mock(DeserializationContext.class);
        Object bean = new Object();
        when(jsonParser.getCurrentToken()).thenReturn(JsonToken.VALUE_STRING);
        doNothing().when(xmlTextProperty).deserializeAndSet(jsonParser, deserializationContext, bean);
        Object result = xmlTextDeserializer.deserialize(jsonParser, deserializationContext, bean);
        assertEquals(bean, result);
    }

    @Test
    public void testDeserializeWithNonStringToken() throws IOException, NoSuchFieldException, IllegalAccessException {
        JsonParser jsonParser = mock(JsonParser.class);
        DeserializationContext deserializationContext = mock(DeserializationContext.class);
        Object bean = new Object();
        JsonDeserializer<Object> delegateDeserializer = mock(JsonDeserializer.class);
        when(jsonParser.getCurrentToken()).thenReturn(JsonToken.START_OBJECT);
        when(delegate.deserialize(jsonParser, deserializationContext, bean)).thenReturn(bean);
        setDelegatee(delegateDeserializer);
        when(delegateDeserializer.deserialize(jsonParser, deserializationContext, bean)).thenReturn(bean);
        Object result = xmlTextDeserializer.deserialize(jsonParser, deserializationContext, bean);
        assertEquals(bean, result);
    }

    private void setDelegatee(JsonDeserializer<Object> delegatee) throws NoSuchFieldException, IllegalAccessException {
        Field field = XmlTextDeserializer.class.getDeclaredField("_delegatee");
        field.setAccessible(true);
        field.set(xmlTextDeserializer, delegatee);
    }
}
