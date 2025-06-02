package com.fasterxml.jackson.dataformat.xml.deser;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.deser.*;
import com.fasterxml.jackson.databind.deser.std.DelegatingDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;

@ExtendWith(MockitoExtension.class)
public class XmlTextDeserializer_deserialize_2_2_Test {

    private XmlTextDeserializer xmlTextDeserializer;

    private JsonParser jsonParser;

    private DeserializationContext deserializationContext;

    private ValueInstantiator valueInstantiator;

    private SettableBeanProperty xmlTextProperty;

    @BeforeEach
    public void setUp() throws Exception {
        valueInstantiator = mock(ValueInstantiator.class);
        xmlTextProperty = mock(SettableBeanProperty.class);
        jsonParser = mock(JsonParser.class);
        deserializationContext = mock(DeserializationContext.class);
        // Create an instance of XmlTextDeserializer with required parameters
        xmlTextDeserializer = new XmlTextDeserializer(null, 0);
        // Use reflection to set the final fields if necessary
        // Assuming _xmlTextProperty and _valueInstantiator are accessible
        setField(xmlTextDeserializer, "_xmlTextProperty", xmlTextProperty);
        setField(xmlTextDeserializer, "_valueInstantiator", valueInstantiator);
    }

    @Test
    public void testDeserialize_WithStringToken_CreatesBeanAndSetsProperty() throws Exception {
        when(jsonParser.getCurrentToken()).thenReturn(JsonToken.VALUE_STRING);
        Object bean = new Object();
        when(valueInstantiator.createUsingDefault(deserializationContext)).thenReturn(bean);
        xmlTextProperty.deserializeAndSet(jsonParser, deserializationContext, bean);
        Object result = xmlTextDeserializer.deserialize(jsonParser, deserializationContext);
        assertNotNull(result);
        verify(valueInstantiator).createUsingDefault(deserializationContext);
        verify(xmlTextProperty).deserializeAndSet(jsonParser, deserializationContext, bean);
    }

    @Test
    public void testDeserialize_WithNonStringToken_DelegatesDeserialization() throws Exception {
        JsonToken nonStringToken = JsonToken.START_OBJECT;
        when(jsonParser.getCurrentToken()).thenReturn(nonStringToken);
        XmlTextDeserializer delegatee = mock(XmlTextDeserializer.class);
        // Use reflection to set the _delegatee field
        setField(xmlTextDeserializer, "_delegatee", delegatee);
        xmlTextDeserializer.deserialize(jsonParser, deserializationContext);
        verify(delegatee).deserialize(jsonParser, deserializationContext);
    }

    private void setField(Object target, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(target, value);
    }
}
