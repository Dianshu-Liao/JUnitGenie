package org.apache.commons.lang3.reflect;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.Map;
import java.lang.reflect.WildcardType;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Array;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
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

public class TypeUtils_isAssignable_29_0_Test {

    @Test
    public void testIsAssignableWithClassArray() {
        Class<?> type = String[].class;
        Class<?> genericArrayType = String[].class;
        assertTrue(TypeUtils.isAssignable(type, genericArrayType));
    }

    @Test
    public void testIsAssignableWithGenericArrayType() {
        Class<?> type = Number[].class;
        Class<?> genericArrayType = Number[].class;
        assertTrue(TypeUtils.isAssignable(type, genericArrayType));
    }

    @Test
    public void testIsAssignableWithDifferentComponentType() {
        Class<?> type = Integer[].class;
        Class<?> genericArrayType = Number[].class;
        assertFalse(TypeUtils.isAssignable(type, genericArrayType));
    }

    @Test
    public void testIsAssignableWithNullType() {
        Class<?> type = null;
        Class<?> genericArrayType = String[].class;
        assertTrue(TypeUtils.isAssignable(type, genericArrayType));
    }

    @Test
    public void testIsAssignableWithWildcardType() {
        Class<?> type = Object[].class;
        WildcardType wildcardType = new WildcardTypeImpl();
        assertTrue(TypeUtils.isAssignable(type, wildcardType));
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

        @Override
        public String toString() {
            return "?";
        }
    }
}
