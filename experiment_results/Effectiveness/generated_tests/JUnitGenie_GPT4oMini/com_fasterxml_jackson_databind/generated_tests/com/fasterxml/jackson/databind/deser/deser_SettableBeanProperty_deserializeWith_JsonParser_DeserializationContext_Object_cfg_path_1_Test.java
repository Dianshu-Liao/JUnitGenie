package com.fasterxml.jackson.databind.deser;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.NullValueProvider;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.junit.Test;
import static org.mockito.Mockito.*;
import java.io.IOException;
import java.lang.annotation.Annotation;

public class deser_SettableBeanProperty_deserializeWith_JsonParser_DeserializationContext_Object_cfg_path_1_Test {

    private static class TestSettableBeanProperty extends SettableBeanProperty {
        protected TestSettableBeanProperty() {
            super(PropertyName.construct("test"), null, null, null);
        }

        @Override
        public AnnotatedMember getMember() {
            return null;
        }

        @Override
        public <A extends Annotation> A getAnnotation(Class<A> aClass) {
            return null;
        }

        @Override
        public SettableBeanProperty withName(PropertyName propertyName) {
            return null;
        }

        @Override
        public void set(Object bean, Object value) {
        }

        @Override
        public void deserializeAndSet(JsonParser p, DeserializationContext ctxt, Object bean) {
        }

        @Override
        public SettableBeanProperty withValueDeserializer(JsonDeserializer<?> valueDeserializer) {
            return null;
        }

        @Override
        public Object setAndReturn(Object bean, Object value) {
            return null;
        }

        @Override
        public SettableBeanProperty withNullProvider(NullValueProvider nullProvider) {
            return null;
        }

        @Override
        public Object deserializeSetAndReturn(JsonParser p, DeserializationContext ctxt, Object bean) {
            return null;
        }
    }



}
