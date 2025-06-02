package org.apache.commons.lang3.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
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

    private String invokeParameterizedTypeToString(ParameterizedType parameterizedType) throws Exception {
        Method method = TypeUtils.class.getDeclaredMethod("parameterizedTypeToString", ParameterizedType.class);
        method.setAccessible(true);
        return (String) method.invoke(null, parameterizedType);
    }

    @Test
    public void testParameterizedTypeToString_NoOwnerType() throws Exception {
        // Arrange
        ParameterizedType parameterizedType = mock(ParameterizedType.class);
        when(parameterizedType.getOwnerType()).thenReturn(null);
        when(parameterizedType.getRawType()).thenReturn(ArrayList.class);
        when(parameterizedType.getActualTypeArguments()).thenReturn(new Type[] { String.class });
        // Act
        String result = invokeParameterizedTypeToString(parameterizedType);
        // Assert
        assertEquals("java.util.ArrayList<String>", result);
    }

    @Test
    public void testParameterizedTypeToString_WithOwnerType() throws Exception {
        // Arrange
        ParameterizedType parameterizedType = mock(ParameterizedType.class);
        when(parameterizedType.getOwnerType()).thenReturn(List.class);
        when(parameterizedType.getRawType()).thenReturn(ArrayList.class);
        when(parameterizedType.getActualTypeArguments()).thenReturn(new Type[] { String.class });
        // Act
        String result = invokeParameterizedTypeToString(parameterizedType);
        // Assert
        assertEquals("java.util.List.ArrayList<String>", result);
    }

    @Test
    public void testParameterizedTypeToString_WithMultipleTypeArguments() throws Exception {
        // Arrange
        ParameterizedType parameterizedType = mock(ParameterizedType.class);
        when(parameterizedType.getOwnerType()).thenReturn(null);
        when(parameterizedType.getRawType()).thenReturn(HashMap.class);
        when(parameterizedType.getActualTypeArguments()).thenReturn(new Type[] { String.class, Integer.class });
        // Act
        String result = invokeParameterizedTypeToString(parameterizedType);
        // Assert
        assertEquals("java.util.HashMap<String, Integer>", result);
    }

    @Test
    public void testParameterizedTypeToString_WithRecursiveType() throws Exception {
        // Arrange
        ParameterizedType parameterizedType = mock(ParameterizedType.class);
        when(parameterizedType.getOwnerType()).thenReturn(null);
        when(parameterizedType.getRawType()).thenReturn(ArrayList.class);
        when(parameterizedType.getActualTypeArguments()).thenReturn(new Type[] { parameterizedType });
        // Act
        String result = invokeParameterizedTypeToString(parameterizedType);
        // Assert
        assertEquals("java.util.ArrayList<java.util.ArrayList>", result);
    }

    @Test
    public void testParameterizedTypeToString_WithNull() throws Exception {
        // Act
        String result = invokeParameterizedTypeToString(null);
        // Assert
        assertNull(result);
    }
}
