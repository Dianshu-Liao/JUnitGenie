package com.fasterxml.jackson.databind.deser.impl;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.impl.PropertyValueBuffer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.NullValueProvider;
import org.junit.Test;
import java.lang.annotation.Annotation;
import static org.junit.Assert.*;

public class deser_impl_PropertyValueBuffer_getParameter_SettableBeanProperty_cfg_path_10_Test {

    private class TestSettableBeanProperty extends SettableBeanProperty {
        private final int creatorIndex;
        private final String name;

        public TestSettableBeanProperty(int creatorIndex, String name) {
            super(PropertyName.construct(name), null, null, null);
            this.creatorIndex = creatorIndex;
            this.name = name;
        }

        @Override
        public int getCreatorIndex() {
            return creatorIndex;
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
            return this;
        }

        @Override
        public void set(Object bean, Object value) {}

        @Override
        public void deserializeAndSet(JsonParser p, DeserializationContext ctxt, Object bean) {}

        @Override
        public SettableBeanProperty withValueDeserializer(JsonDeserializer<?> deser) {
            return this;
        }

        @Override
        public Object setAndReturn(Object bean, Object value) {
            return null;
        }

        @Override
        public SettableBeanProperty withNullProvider(NullValueProvider nullProvider) {
            return this;
        }

        @Override
        public Object deserializeSetAndReturn(JsonParser p, DeserializationContext ctxt, Object bean) {
            return null;
        }
    }




}
