package com.fasterxml.jackson.databind.introspect;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.databind.introspect.ObjectIdInfo;
import com.fasterxml.jackson.databind.PropertyName;
import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.annotation.Annotation;
import com.fasterxml.jackson.annotation.ObjectIdResolver;

public class introspect_JacksonAnnotationIntrospector_findObjectIdInfo_Annotated_cfg_path_1_Test {

    private static class TestAnnotated extends Annotated {
        // Implementing abstract methods
        @Override
        public java.lang.reflect.AnnotatedElement getAnnotated() {
            return null; // Stub implementation
        }

        @Override
        public boolean hasOneOf(java.lang.Class[] classes) {
            return false; // Stub implementation
        }

        @Override
        public boolean equals(java.lang.Object obj) {
            return false; // Stub implementation
        }

        @Override
        public com.fasterxml.jackson.databind.JavaType getType() {
            return null; // Stub implementation
        }

        @Override
        public java.lang.String getName() {
            return "testAnnotated"; // Stub implementation
        }

        @Override
        public Iterable<Annotation> annotations() {
            return null; // Stub implementation
        }

        @Override
        public java.lang.annotation.Annotation getAnnotation(java.lang.Class cls) {
            return null; // Stub implementation
        }

        @Override
        public java.lang.String toString() {
            return "TestAnnotated"; // Stub implementation
        }

        @Override
        public int getModifiers() {
            return 0; // Stub implementation
        }

        @Override
        public java.lang.Class getRawType() {
            return null; // Stub implementation
        }

        @Override
        public boolean hasAnnotation(java.lang.Class cls) {
            return false; // Stub implementation
        }

        @Override
        public int hashCode() {
            return 0; // Stub implementation
        }
    }



}
