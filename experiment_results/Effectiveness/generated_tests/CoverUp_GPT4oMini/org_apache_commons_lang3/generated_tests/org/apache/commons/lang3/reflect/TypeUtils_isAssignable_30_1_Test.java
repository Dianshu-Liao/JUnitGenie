package org.apache.commons.lang3.reflect;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.Map;
import java.lang.reflect.Method;
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

class TypeUtils_isAssignable_30_1_Test {

    @Test
    void testIsAssignable_NullType() throws Exception {
        ParameterizedType parameterizedType = createParameterizedType(List.class, String.class);
        Map<TypeVariable<?>, Type> typeVarAssigns = new HashMap<>();
        // Invoke private method
        boolean result = invokeIsAssignable(null, parameterizedType, typeVarAssigns);
        assertTrue(result);
    }

    @Test
    void testIsAssignable_NullParameterizedType() throws Exception {
        Type type = String.class;
        Map<TypeVariable<?>, Type> typeVarAssigns = new HashMap<>();
        // Invoke private method
        boolean result = invokeIsAssignable(type, null, typeVarAssigns);
        assertFalse(result);
    }

    @Test
    void testIsAssignable_GenericArrayType() throws Exception {
        GenericArrayType genericArrayType = createGenericArrayType(String.class);
        ParameterizedType parameterizedType = createParameterizedType(List.class, String.class);
        Map<TypeVariable<?>, Type> typeVarAssigns = new HashMap<>();
        // Invoke private method
        boolean result = invokeIsAssignable(genericArrayType, parameterizedType, typeVarAssigns);
        assertFalse(result);
    }

    @Test
    void testIsAssignable_SameType() throws Exception {
        ParameterizedType parameterizedType = createParameterizedType(List.class, String.class);
        // Invoke private method
        boolean result = invokeIsAssignable(parameterizedType, parameterizedType, new HashMap<>());
        assertTrue(result);
    }

    @Test
    void testIsAssignable_CompatibleTypes() throws Exception {
        ParameterizedType fromType = createParameterizedType(List.class, String.class);
        ParameterizedType toType = createParameterizedType(List.class, Object.class);
        Map<TypeVariable<?>, Type> typeVarAssigns = new HashMap<>();
        // Invoke private method
        boolean result = invokeIsAssignable(fromType, toType, typeVarAssigns);
        assertTrue(result);
    }

    @Test
    void testIsAssignable_IncompatibleTypes() throws Exception {
        ParameterizedType fromType = createParameterizedType(List.class, Integer.class);
        ParameterizedType toType = createParameterizedType(List.class, String.class);
        Map<TypeVariable<?>, Type> typeVarAssigns = new HashMap<>();
        // Invoke private method
        boolean result = invokeIsAssignable(fromType, toType, typeVarAssigns);
        assertFalse(result);
    }

    private boolean invokeIsAssignable(Type type, ParameterizedType toParameterizedType, Map<TypeVariable<?>, Type> typeVarAssigns) throws Exception {
        Method method = TypeUtils.class.getDeclaredMethod("isAssignable", Type.class, ParameterizedType.class, Map.class);
        method.setAccessible(true);
        return (boolean) method.invoke(null, type, toParameterizedType, typeVarAssigns);
    }

    private ParameterizedType createParameterizedType(Class<?> rawType, Class<?>... typeArguments) {
        return new ParameterizedTypeImpl(rawType, typeArguments);
    }

    private GenericArrayType createGenericArrayType(Class<?> componentType) {
        return new GenericArrayTypeImpl(componentType);
    }

    // Mock implementations for ParameterizedType and GenericArrayType
    private static class ParameterizedTypeImpl implements ParameterizedType {

        private final Class<?> rawType;

        private final Type[] actualTypeArguments;

        public ParameterizedTypeImpl(Class<?> rawType, Class<?>... actualTypeArguments) {
            this.rawType = rawType;
            this.actualTypeArguments = actualTypeArguments;
        }

        @Override
        public Type[] getActualTypeArguments() {
            return actualTypeArguments;
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

    private static class GenericArrayTypeImpl implements GenericArrayType {

        private final Type componentType;

        public GenericArrayTypeImpl(Class<?> componentType) {
            this.componentType = componentType;
        }

        @Override
        public Type getGenericComponentType() {
            return componentType;
        }
    }
}
