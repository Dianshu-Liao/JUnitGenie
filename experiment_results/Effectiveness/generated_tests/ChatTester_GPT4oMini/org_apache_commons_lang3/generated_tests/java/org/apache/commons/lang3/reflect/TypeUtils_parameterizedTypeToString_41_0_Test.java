package org.apache.commons.lang3.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
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
import java.util.List;
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
    public void testParameterizedTypeToString_NoOwnerType() throws Exception {
        // Arrange
        ParameterizedType parameterizedType = mock(ParameterizedType.class);
        Class<?> rawType = String.class;
        when(parameterizedType.getOwnerType()).thenReturn(null);
        when(parameterizedType.getRawType()).thenReturn(rawType);
        when(parameterizedType.getActualTypeArguments()).thenReturn(new Type[] {});
        // Act
        String result = invokePrivateMethod("parameterizedTypeToString", parameterizedType);
        // Assert
        assertEquals("java.lang.String", result);
    }

    @Test
    public void testParameterizedTypeToString_WithOwnerType() throws Exception {
        // Arrange
        ParameterizedType parameterizedType = mock(ParameterizedType.class);
        Class<?> rawType = String.class;
        Class<?> ownerType = Object.class;
        when(parameterizedType.getOwnerType()).thenReturn(ownerType);
        when(parameterizedType.getRawType()).thenReturn(rawType);
        when(parameterizedType.getActualTypeArguments()).thenReturn(new Type[] {});
        // Act
        String result = invokePrivateMethod("parameterizedTypeToString", parameterizedType);
        // Assert
        assertEquals("java.lang.Object.String", result);
    }

    @Test
    public void testParameterizedTypeToString_WithActualTypeArguments() throws Exception {
        // Arrange
        ParameterizedType parameterizedType = mock(ParameterizedType.class);
        Class<?> rawType = String.class;
        Class<?> ownerType = Object.class;
        when(parameterizedType.getOwnerType()).thenReturn(ownerType);
        when(parameterizedType.getRawType()).thenReturn(rawType);
        when(parameterizedType.getActualTypeArguments()).thenReturn(new Type[] { Integer.class, Double.class });
        // Act
        String result = invokePrivateMethod("parameterizedTypeToString", parameterizedType);
        // Assert
        assertEquals("java.lang.Object.String<java.lang.Integer, java.lang.Double>", result);
    }

    @Test
    public void testParameterizedTypeToString_WithRecursiveType() throws Exception {
        // Arrange
        ParameterizedType parameterizedType = mock(ParameterizedType.class);
        Class<?> rawType = String.class;
        Class<?> ownerType = Object.class;
        when(parameterizedType.getOwnerType()).thenReturn(ownerType);
        when(parameterizedType.getRawType()).thenReturn(rawType);
        // Simulating recursive type
        Type[] actualTypeArguments = new Type[] { parameterizedType };
        when(parameterizedType.getActualTypeArguments()).thenReturn(actualTypeArguments);
        // Act
        String result = invokePrivateMethod("parameterizedTypeToString", parameterizedType);
        // Assert
        // Assuming the recursive type is represented as "..."
        assertEquals("java.lang.Object.String<...>", result);
    }

    private String invokePrivateMethod(String methodName, ParameterizedType parameterizedType) throws Exception {
        Method method = TypeUtils.class.getDeclaredMethod(methodName, ParameterizedType.class);
        method.setAccessible(true);
        return (String) method.invoke(null, parameterizedType);
    }
}
