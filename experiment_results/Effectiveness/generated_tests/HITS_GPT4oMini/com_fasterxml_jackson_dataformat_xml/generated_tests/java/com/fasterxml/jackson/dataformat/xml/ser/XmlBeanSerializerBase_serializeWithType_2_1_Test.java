package com.fasterxml.jackson.dataformat.xml.ser;

import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.impl.ObjectIdWriter;
import com.fasterxml.jackson.databind.ser.std.BeanSerializerBase;
import javax.xml.namespace.QName;
import java.io.IOException;
import java.util.BitSet;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.WritableObjectId;
import com.fasterxml.jackson.databind.util.NameTransformer;
import com.fasterxml.jackson.dataformat.xml.util.XmlInfo;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import com.fasterxml.jackson.core.*;

class XmlBeanSerializerBase_serializeWithType_2_1_Test {

    static class TestXmlBeanSerializer extends XmlBeanSerializerBase {

        protected TestXmlBeanSerializer(BeanSerializerBase src) {
            super(src);
        }

        @Override
        public BeanSerializerBase asArraySerializer() {
            return null;
        }

        @Override
        public void serialize(Object bean, JsonGenerator gen, SerializerProvider provider) throws IOException {
            gen.writeStartObject();
            gen.writeEndObject();
        }

        @Override
        public void serializeWithType(Object bean, JsonGenerator gen, SerializerProvider provider, TypeSerializer typeSer) throws IOException {
            super.serializeWithType(bean, gen, provider, typeSer);
        }

        @Override
        public BeanSerializerBase withProperties(BeanPropertyWriter[] properties, BeanPropertyWriter[] filteredProperties) {
            return new TestXmlBeanSerializer(this);
        }

        @Override
        public BeanSerializerBase withFilterId(Object filterId) {
            return new TestXmlBeanSerializer(this);
        }

        @Override
        public BeanSerializerBase withByNameInclusion(Set<String> toIgnore, Set<String> toInclude) {
            return new TestXmlBeanSerializer(this);
        }

        @Override
        public BeanSerializerBase withObjectIdWriter(ObjectIdWriter objectIdWriter) {
            return new TestXmlBeanSerializer(this);
        }
    }

    @Test
    void testSerializeWithType() throws Exception {
        JsonGenerator mockGen = mock(JsonGenerator.class);
        SerializerProvider mockProvider = mock(SerializerProvider.class);
        TypeSerializer mockTypeSerializer = mock(TypeSerializer.class);
        TestXmlBeanSerializer serializer = new TestXmlBeanSerializer(mock(BeanSerializerBase.class));
        serializer.serializeWithType(new Object(), mockGen, mockProvider, mockTypeSerializer);
        verify(mockGen).writeStartObject();
        verify(mockGen).writeEndObject();
    }
}
