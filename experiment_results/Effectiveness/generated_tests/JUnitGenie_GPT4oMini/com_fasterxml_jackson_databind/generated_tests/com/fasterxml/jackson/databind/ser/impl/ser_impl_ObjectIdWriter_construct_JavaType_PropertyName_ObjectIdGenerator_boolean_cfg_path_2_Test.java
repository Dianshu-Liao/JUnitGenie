package com.fasterxml.jackson.databind.ser.impl;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.databind.ser.impl.ObjectIdWriter;
import com.fasterxml.jackson.core.SerializableString;
import java.util.List;
import com.fasterxml.jackson.databind.type.TypeBindings;
import org.junit.Test;
import static org.junit.Assert.*;

public class ser_impl_ObjectIdWriter_construct_JavaType_PropertyName_ObjectIdGenerator_boolean_cfg_path_2_Test {

    private static class ConcreteJavaType extends JavaType {
        public ConcreteJavaType() {
            super(Object.class, 0, null, null, false);
        }

        @Override
        public boolean equals(Object o) {
            return this == o;
        }

        @Override
        public JavaType findSuperType(Class<?> cls) {
            return null;
        }

        @Override
        public JavaType withContentType(JavaType contentType) {
            return null;
        }

        @Override
        public TypeBindings getBindings() {
            return null;
        }

        @Override
        public JavaType containedType(int index) {
            return null;
        }

        @Override
        public JavaType withTypeHandler(Object h) {
            return null;
        }

        @Override
        public String containedTypeName(int index) {
            return null;
        }

        @Override
        public String toCanonical() {
            return null;
        }

        @Override
        public JavaType getKeyType() {
            return null;
        }

        @Override
        public JavaType getSuperClass() {
            return null;
        }

        @Override
        public JavaType getContentType() {
            return null;
        }

        @Override
        public StringBuilder getGenericSignature(StringBuilder sb) {
            return null;
        }

        @Override
        public JavaType getReferencedType() {
            return null;
        }

        @Override
        public JavaType withValueHandler(Object h) {
            return null;
        }

        @Override
        public JavaType withContentValueHandler(Object h) {
            return null;
        }

        @Override
        public JavaType withStaticTyping() {
            return null;
        }

        @Override
        public boolean isContainerType() {
            return false;
        }

        @Override
        public int containedTypeCount() {
            return 0;
        }

        @Override
        public List<JavaType> getInterfaces() {
            return null;
        }

        @Override
        public JavaType refine(Class<?> cls, TypeBindings bindings, JavaType superClass, JavaType[] interfaces) {
            return null;
        }

        @Override
        public String toString() {
            return "ConcreteJavaType";
        }

        @Override
        public JavaType withContentTypeHandler(Object h) {
            return null;
        }

        @Override
        public JavaType[] findTypeParameters(Class<?> cls) {
            return new JavaType[0];
        }

        @Override
        public StringBuilder getErasedSignature(StringBuilder sb) {
            return null;
        }
    }


}
