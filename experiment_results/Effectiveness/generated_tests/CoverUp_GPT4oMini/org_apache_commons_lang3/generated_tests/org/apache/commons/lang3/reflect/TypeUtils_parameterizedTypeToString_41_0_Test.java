package org.apache.commons.lang3.reflect;

import org.apache.commons.lang3.reflect.TypeUtils;
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
import java.lang.reflect.GenericArrayType;
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

public class TypeUtils_parameterizedTypeToString_41_0_Test {

    @Test
    public void testParameterizedTypeToStringWithNoOwnerType() {
        ParameterizedType parameterizedType = new ParameterizedTypeImpl(ArrayList.class, new Type[] { String.class }, null);
        String result = invokeParameterizedTypeToString(parameterizedType);
        assertEquals("java.util.ArrayList<String>", result);
    }

    @Test
    public void testParameterizedTypeToStringWithOwnerType() {
        ParameterizedType parameterizedType = new ParameterizedTypeImpl(ListWithOwner.class, new Type[] { String.class }, ListWithOwner.class);
        String result = invokeParameterizedTypeToString(parameterizedType);
        assertEquals("TypeUtilsTest$ListWithOwner.String", result);
    }

    @Test
    public void testParameterizedTypeToStringWithMultipleTypeArguments() {
        ParameterizedType parameterizedType = new ParameterizedTypeImpl(List.class, new Type[] { String.class, Integer.class }, null);
        String result = invokeParameterizedTypeToString(parameterizedType);
        assertEquals("java.util.List<String, Integer>", result);
    }

    private String invokeParameterizedTypeToString(ParameterizedType parameterizedType) {
        try {
            java.lang.reflect.Method method = TypeUtils.class.getDeclaredMethod("parameterizedTypeToString", ParameterizedType.class);
            method.setAccessible(true);
            return (String) method.invoke(null, parameterizedType);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static class ListWithOwner<T> extends ArrayList<T> {
    }

    private static class ParameterizedTypeImpl implements ParameterizedType {

        private final Class<?> raw;

        private final Type[] actualTypeArguments;

        private final Type ownerType;

        public ParameterizedTypeImpl(Class<?> raw, Type[] actualTypeArguments, Type ownerType) {
            this.raw = raw;
            this.actualTypeArguments = actualTypeArguments;
            this.ownerType = ownerType;
        }

        @Override
        public Type[] getActualTypeArguments() {
            return actualTypeArguments;
        }

        @Override
        public Type getRawType() {
            return raw;
        }

        @Override
        public Type getOwnerType() {
            return ownerType;
        }
    }
}
