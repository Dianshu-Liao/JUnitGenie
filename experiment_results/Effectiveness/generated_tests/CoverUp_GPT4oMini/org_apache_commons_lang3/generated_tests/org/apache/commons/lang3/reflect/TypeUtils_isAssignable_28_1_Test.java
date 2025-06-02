package org.apache.commons.lang3.reflect;

import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.reflect.TypeUtils;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Array;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import org.apache.commons.lang3.AppendableJoiner;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.Builder;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class TypeUtils_isAssignable_28_1_Test {

    @Test
    public void testIsAssignable_NullTypeAndNullClass() {
        assertTrue(invokeIsAssignable(null, null));
    }

    @Test
    public void testIsAssignable_NullTypeAndPrimitiveClass() {
        assertFalse(invokeIsAssignable(null, int.class));
    }

    @Test
    public void testIsAssignable_SameClass() {
        assertTrue(invokeIsAssignable(String.class, String.class));
    }

    @Test
    public void testIsAssignable_ClassToSubclass() {
        assertTrue(invokeIsAssignable(String.class, CharSequence.class));
    }

    @Test
    public void testIsAssignable_SubclassToClass() {
        assertFalse(invokeIsAssignable(CharSequence.class, String.class));
    }

    @Test
    public void testIsAssignable_ParameterizedType() throws Exception {
        ParameterizedType paramType = (ParameterizedType) new GenericTypeReference<List<String>>() {
        }.getType();
        assertTrue(invokeIsAssignable(paramType, List.class));
    }

    @Test
    public void testIsAssignable_GenericArrayType() throws Exception {
        GenericArrayType genericArrayType = (GenericArrayType) new GenericArrayTypeImpl(String.class);
        assertTrue(invokeIsAssignable(genericArrayType, String[].class));
        assertFalse(invokeIsAssignable(genericArrayType, Object.class));
    }

    @Test
    public void testIsAssignable_WildcardType() throws Exception {
        WildcardType wildcardType = (WildcardType) new WildcardTypeImpl();
        assertFalse(invokeIsAssignable(wildcardType, String.class));
    }

    @Test
    public void testIsAssignable_GenericArrayTypeToObject() throws Exception {
        GenericArrayType genericArrayType = (GenericArrayType) new GenericArrayTypeImpl(String.class);
        assertTrue(invokeIsAssignable(genericArrayType, Object.class));
    }

    @Test
    public void testIsAssignable_TypeVariable() throws Exception {
        TypeVariable<Class<TypeUtils_isAssignable_28_1_Test>> typeVariable = TypeUtils_isAssignable_28_1_Test.class.getTypeParameters()[0];
        assertTrue(invokeIsAssignable(typeVariable, Object.class));
    }

    private boolean invokeIsAssignable(Type type, Class<?> toClass) {
        try {
            return (boolean) TypeUtils.class.getDeclaredMethod("isAssignable", Type.class, Class.class).invoke(null, type, toClass);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Helper classes for testing
    private static class GenericTypeReference<T> {

        public Type getType() {
            return ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        }
    }

    private static class GenericArrayTypeImpl implements GenericArrayType {

        private final Type componentType;

        public GenericArrayTypeImpl(Type componentType) {
            this.componentType = componentType;
        }

        @Override
        public Type getGenericComponentType() {
            return componentType;
        }
    }

    private static class WildcardTypeImpl implements WildcardType {

        @Override
        public Type[] getUpperBounds() {
            return new Type[] { Object.class };
        }

        @Override
        public Type[] getLowerBounds() {
            return new Type[0];
        }
    }
}
