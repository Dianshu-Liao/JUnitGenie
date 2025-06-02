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

public class XmlTextDeserializer_deserialize_2_0_Test {

    private XmlTextDeserializer xmlTextDeserializer;

    private SettableBeanProperty mockProperty;

    private ValueInstantiator mockValueInstantiator;

    private JsonParser mockParser;

    private DeserializationContext mockContext;

    @BeforeEach
    public void setUp() {
        mockProperty = mock(SettableBeanProperty.class);
        mockValueInstantiator = mock(ValueInstantiator.class);
        xmlTextDeserializer = new XmlTextDeserializer(mock(BeanDeserializerBase.class), mockProperty);
        mockParser = mock(JsonParser.class);
        mockContext = mock(DeserializationContext.class);
    }

    @Test
    public void testDeserialize_ValueString() throws IOException {
        // Arrange
        when(mockParser.getCurrentToken()).thenReturn(JsonToken.VALUE_STRING);
        Object mockBean = new Object();
        when(mockValueInstantiator.createUsingDefault(mockContext)).thenReturn(mockBean);
        doNothing().when(mockProperty).deserializeAndSet(mockParser, mockContext, mockBean);
        // Act
        Object result = xmlTextDeserializer.deserialize(mockParser, mockContext);
        // Assert
        assertNotNull(result);
        verify(mockValueInstantiator).createUsingDefault(mockContext);
        verify(mockProperty).deserializeAndSet(mockParser, mockContext, mockBean);
    }

    @Test
    public void testDeserialize_NotValueString() throws IOException {
        // Arrange
        when(mockParser.getCurrentToken()).thenReturn(JsonToken.START_OBJECT);
        BeanDeserializerBase mockDelegate = mock(BeanDeserializerBase.class);
        xmlTextDeserializer = new XmlTextDeserializer(mockDelegate, mockProperty);
        // Act
        xmlTextDeserializer.deserialize(mockParser, mockContext);
        // Assert
        verify(mockDelegate).deserialize(mockParser, mockContext);
    }
}
