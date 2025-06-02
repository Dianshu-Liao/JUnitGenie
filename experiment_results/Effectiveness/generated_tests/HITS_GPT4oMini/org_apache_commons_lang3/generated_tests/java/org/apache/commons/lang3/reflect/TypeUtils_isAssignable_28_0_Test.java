package org.apache.commons.lang3.reflect;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Array;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import org.apache.commons.lang3.AppendableJoiner;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.Builder;

public class TypeUtils_isAssignable_28_0_Test {

    @Test
    public void testIsAssignable_WithNullTypeAndNullClass() {
        assertTrue(TypeUtils.isAssignable(null, null));
    }

    @Test
    public void testIsAssignable_WithNullTypeAndPrimitiveClass() {
        assertFalse(TypeUtils.isAssignable(null, int.class));
    }

    @Test
    public void testIsAssignable_WithSameClass() {
        assertTrue(TypeUtils.isAssignable(String.class, String.class));
    }

    @Test
    public void testIsAssignable_WithSubclass() {
        assertTrue(TypeUtils.isAssignable(ArrayList.class, List.class));
    }

    @Test
    public void testIsAssignable_WithSuperclass() {
        assertFalse(TypeUtils.isAssignable(List.class, ArrayList.class));
    }

    @Test
    public void testIsAssignable_WithParameterizedType() {
        ParameterizedType parameterizedType = (ParameterizedType) new TypeReference<List<String>>() {
        }.getType();
        assertTrue(TypeUtils.isAssignable(parameterizedType, List.class));
    }

    @Test
    public void testIsAssignable_WithGenericArrayType() {
        GenericArrayType genericArrayType = new GenericArrayTypeImpl(List.class);
        assertTrue(TypeUtils.isAssignable(genericArrayType, List[].class));
        assertFalse(TypeUtils.isAssignable(genericArrayType, Object.class));
    }

    @Test
    public void testIsAssignable_WithTypeVariable() {
        TypeVariable<Class<GenericClass>> typeVariable = GenericClass.class.getTypeParameters()[0];
        assertTrue(TypeUtils.isAssignable(typeVariable, Object.class));
    }

    @Test
    public void testIsAssignable_WithWildcardType() {
        assertFalse(TypeUtils.isAssignable(TypeUtils.WILDCARD_ALL, String.class));
    }

    @Test
    public void testIsAssignable_WithPrimitiveToWrapper() {
        assertTrue(TypeUtils.isAssignable(int.class, Integer.class));
    }

    @Test
    public void testIsAssignable_WithWrapperToPrimitive() {
        assertFalse(TypeUtils.isAssignable(Integer.class, int.class));
    }

    // Helper class to create ParameterizedType for testing
    private static abstract class TypeReference<T> {

        public Type getType() {
            return ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        }
    }

    // Helper class to create GenericArrayType for testing
    private static class GenericArrayTypeImpl implements GenericArrayType {

        private final Type genericComponentType;

        public GenericArrayTypeImpl(Type genericComponentType) {
            this.genericComponentType = genericComponentType;
        }

        @Override
        public Type getGenericComponentType() {
            return genericComponentType;
        }

        @Override
        public String toString() {
            return genericComponentType.getTypeName() + "[]";
        }
    }

    // Helper class for testing TypeVariable
    private static class GenericClass<T> {
    }
}
