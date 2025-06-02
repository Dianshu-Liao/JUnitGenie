package com.fasterxml.jackson.dataformat.xml.ser;

import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.impl.WritableObjectId;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.dataformat.xml.ser.XmlBeanSerializerBase;
import javax.xml.namespace.QName;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.io.IOException;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.BitSet;
import java.util.Set;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.ObjectIdWriter;
import com.fasterxml.jackson.databind.ser.std.BeanSerializerBase;
import com.fasterxml.jackson.databind.util.NameTransformer;
import com.fasterxml.jackson.dataformat.xml.util.XmlInfo;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import com.fasterxml.jackson.core.*;

class XmlBeanSerializerBase__serializeObjectId_3_2_Test {

    private XmlBeanSerializerBase xmlBeanSerializerBase;

    private JsonGenerator jsonGenerator;

    private SerializerProvider serializerProvider;

    private TypeSerializer typeSerializer;

    private WritableObjectId writableObjectId;

    @BeforeEach
    void setUp() {
        xmlBeanSerializerBase = mock(XmlBeanSerializerBase.class);
        jsonGenerator = mock(ToXmlGenerator.class);
        serializerProvider = mock(SerializerProvider.class);
        typeSerializer = mock(TypeSerializer.class);
        writableObjectId = mock(WritableObjectId.class);
    }

    @Test
    void testSerializeObjectIdWithAttributes() throws Exception {
        // Arrange
        when(typeSerializer.getTypeInclusion()).thenReturn(JsonTypeInfo.As.PROPERTY);
        when(jsonGenerator instanceof ToXmlGenerator).thenReturn(true);
        StringWriter stringWriter = new StringWriter();
        when(((ToXmlGenerator) jsonGenerator).getOutputTarget()).thenReturn(stringWriter);
        // Act
        invokePrivateSerializeObjectId(new Object());
        // Assert
        verify((ToXmlGenerator) jsonGenerator).setNextIsAttribute(true);
        verify(xmlBeanSerializerBase, times(1))._serializeObjectId(any(), eq(jsonGenerator), eq(serializerProvider), eq(typeSerializer), eq(writableObjectId));
    }

    @Test
    void testSerializeObjectIdWithoutAttributes() throws Exception {
        // Arrange
        when(typeSerializer.getTypeInclusion()).thenReturn(JsonTypeInfo.As.EXISTING_PROPERTY);
        when(jsonGenerator instanceof ToXmlGenerator).thenReturn(true);
        // Act
        invokePrivateSerializeObjectId(new Object());
        // Assert
        verify(xmlBeanSerializerBase, times(1))._serializeObjectId(any(), eq(jsonGenerator), eq(serializerProvider), eq(typeSerializer), eq(writableObjectId));
    }

    private void invokePrivateSerializeObjectId(Object bean) throws Exception {
        Method method = XmlBeanSerializerBase.class.getDeclaredMethod("_serializeObjectId", Object.class, JsonGenerator.class, SerializerProvider.class, TypeSerializer.class, WritableObjectId.class);
        method.setAccessible(true);
        method.invoke(xmlBeanSerializerBase, bean, jsonGenerator, serializerProvider, typeSerializer, writableObjectId);
    }
}
