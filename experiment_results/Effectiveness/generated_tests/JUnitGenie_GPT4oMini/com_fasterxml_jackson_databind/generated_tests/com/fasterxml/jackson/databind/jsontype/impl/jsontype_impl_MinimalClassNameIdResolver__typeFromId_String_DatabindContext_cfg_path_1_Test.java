package com.fasterxml.jackson.databind.jsontype.impl;
import com.fasterxml.jackson.databind.DatabindContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.jsontype.impl.MinimalClassNameIdResolver;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import java.io.IOException;

public class jsontype_impl_MinimalClassNameIdResolver__typeFromId_String_DatabindContext_cfg_path_1_Test {

    private class TestDatabindContext extends DatabindContext {
        @Override
        public com.fasterxml.jackson.annotation.JsonFormat.Value getDefaultPropertyFormat(Class<?> aClass) {
            return null;
        }

        @Override
        public Class<?> getActiveView() {
            return null;
        }

        @Override
        public boolean isEnabled(com.fasterxml.jackson.databind.cfg.DatatypeFeature datatypeFeature) {
            return false;
        }

        @Override
        public Object getAttribute(Object key) {
            return null;
        }

        @Override
        public com.fasterxml.jackson.databind.AnnotationIntrospector getAnnotationIntrospector() {
            return null;
        }

        @Override
        public com.fasterxml.jackson.databind.cfg.DatatypeFeatures getDatatypeFeatures() {
            return null;
        }

        @Override
        public java.util.Locale getLocale() {
            return null;
        }

        @Override
        public com.fasterxml.jackson.databind.type.TypeFactory getTypeFactory() {
            return null;
        }

        @Override
        public com.fasterxml.jackson.databind.cfg.MapperConfig getConfig() {
            return null;
        }

        @Override
        public DatabindContext setAttribute(Object key, Object value) {
            return this;
        }

        @Override
        public JavaType constructSpecializedType(JavaType baseType, Class<?> subclass) {
            return null;
        }

        @Override
        public boolean isEnabled(com.fasterxml.jackson.databind.MapperFeature mapperFeature) {
            return false;
        }

        @Override
        public Object reportBadTypeDefinition(com.fasterxml.jackson.databind.BeanDescription beanDescription, String message, Object... args) {
            return null;
        }

        @Override
        public boolean canOverrideAccessModifiers() {
            return false;
        }

        @Override
        public com.fasterxml.jackson.databind.JsonMappingException invalidTypeIdException(JavaType type, String id, String message) {
            return null;
        }

        @Override
        public Object reportBadDefinition(JavaType type, String message) {
            return null;
        }

        @Override
        public java.util.TimeZone getTimeZone() {
            return null;
        }
    }


}
