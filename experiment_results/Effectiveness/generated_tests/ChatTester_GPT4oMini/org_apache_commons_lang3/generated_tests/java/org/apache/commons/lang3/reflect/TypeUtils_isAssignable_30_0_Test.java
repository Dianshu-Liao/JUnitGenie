package org.apache.commons.lang3.reflect;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.Map;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Array;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import org.apache.commons.lang3.AppendableJoiner;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.Builder;

class TypeUtils_isAssignable_30_0_Test {

    @Test
    void testIsAssignable_NullType() throws Exception {
        Method method = TypeUtils.class.getDeclaredMethod("isAssignable", Type.class, ParameterizedType.class, Map.class);
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(null, null, null, null);
        assertTrue(result);
    }

    @Test
    void testIsAssignable_NullParameterizedType() throws Exception {
        Method method = TypeUtils.class.getDeclaredMethod("isAssignable", Type.class, ParameterizedType.class, Map.class);
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(null, String.class, null, null);
        assertFalse(result);
    }

    @Test
    void testIsAssignable_GenericArrayType() throws Exception {
        Method method = TypeUtils.class.getDeclaredMethod("isAssignable", Type.class, ParameterizedType.class, Map.class);
        method.setAccessible(true);
        Type genericArrayType = new GenericArrayTypeImpl(String.class);
        boolean result = (boolean) method.invoke(null, genericArrayType, (ParameterizedType) null, null);
        assertFalse(result);
    }

    @Test
    void testIsAssignable_SameType() throws Exception {
        Method method = TypeUtils.class.getDeclaredMethod("isAssignable", Type.class, ParameterizedType.class, Map.class);
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(null, String.class, String.class, null);
        assertTrue(result);
    }

    @Test
    void testIsAssignable_CompatibleTypes() throws Exception {
        Method method = TypeUtils.class.getDeclaredMethod("isAssignable", Type.class, ParameterizedType.class, Map.class);
        method.setAccessible(true);
        ParameterizedType parameterizedType = new ParameterizedTypeImpl(String.class);
        boolean result = (boolean) method.invoke(null, String.class, parameterizedType, null);
        assertTrue(result);
    }

    @Test
    void testIsAssignable_IncompatibleTypes() throws Exception {
        Method method = TypeUtils.class.getDeclaredMethod("isAssignable", Type.class, ParameterizedType.class, Map.class);
        method.setAccessible(true);
        ParameterizedType parameterizedType = new ParameterizedTypeImpl(Integer.class);
        boolean result = (boolean) method.invoke(null, String.class, parameterizedType, null);
        assertFalse(result);
    }

    @Test
    void testIsAssignable_WithTypeArguments() throws Exception {
        Method method = TypeUtils.class.getDeclaredMethod("isAssignable", Type.class, ParameterizedType.class, Map.class);
        method.setAccessible(true);
        ParameterizedType parameterizedType = new ParameterizedTypeImpl(Map.class);
        Map<TypeVariable<?>, Type> typeVarAssigns = new HashMap<>();
        boolean result = (boolean) method.invoke(null, HashMap.class, parameterizedType, typeVarAssigns);
        assertTrue(result);
    }

    @Test
    void testIsAssignable_WithWildcardType() throws Exception {
        Method method = TypeUtils.class.getDeclaredMethod("isAssignable", Type.class, ParameterizedType.class, Map.class);
        method.setAccessible(true);
        ParameterizedType wildcardType = new ParameterizedTypeImpl(new WildcardTypeImpl());
        boolean result = (boolean) method.invoke(null, String.class, wildcardType, null);
        assertTrue(result);
    }

    // Helper classes to create generic types for testing
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

    private static class ParameterizedTypeImpl implements ParameterizedType {

        private final Type rawType;

        public ParameterizedTypeImpl(Type rawType) {
            this.rawType = rawType;
        }

        @Override
        public Type[] getActualTypeArguments() {
            return new Type[0];
        }

        @Override
        public Type getRawType() {
            return rawType;
        }

        @Override
        public Type getOwnerType() {
            return null;
        }
    }

    private static class WildcardTypeImpl implements java.lang.reflect.WildcardType {

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
