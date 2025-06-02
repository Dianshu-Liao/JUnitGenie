package org.apache.commons.lang3.reflect;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
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
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.WildcardType;
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

public class TypeUtils_getImplicitBounds_17_1_Test {

    @Test
    public void testGetImplicitBounds_NullTypeVariable_ThrowsNullPointerException() {
        // Arrange
        TypeVariable<?> typeVariable = null;
        // Act & Assert
        Assertions.assertThrows(NullPointerException.class, () -> {
            TypeUtils.getImplicitBounds(typeVariable);
        });
    }

    @Test
    public void testGetImplicitBounds_EmptyBounds_ReturnsObjectClass() {
        // Arrange
        TypeVariable<Class<ExampleClass>> typeVariable = ExampleClass.class.getTypeParameters()[0];
        // Act
        Type[] result = TypeUtils.getImplicitBounds(typeVariable);
        // Assert
        Assertions.assertEquals(1, result.length);
        Assertions.assertEquals(Object.class, result[0]);
    }

    @Test
    public void testGetImplicitBounds_SingleUpperBound_ReturnsSingleBound() {
        // Arrange
        TypeVariable<Class<ExampleClassWithSingleBound>> typeVariable = ExampleClassWithSingleBound.class.getTypeParameters()[0];
        // Act
        Type[] result = TypeUtils.getImplicitBounds(typeVariable);
        // Assert
        Assertions.assertEquals(1, result.length);
        Assertions.assertEquals(Number.class, result[0]);
    }

    @Test
    public void testGetImplicitBounds_MultipleUpperBounds_ReturnsNormalizedBounds() {
        // Arrange
        TypeVariable<Class<ExampleClassWithMultipleBounds>> typeVariable = ExampleClassWithMultipleBounds.class.getTypeParameters()[0];
        // Act
        Type[] result = TypeUtils.getImplicitBounds(typeVariable);
        // Assert
        Assertions.assertEquals(2, result.length);
        Assertions.assertTrue(Arrays.asList(result).contains(Number.class));
        Assertions.assertTrue(Arrays.asList(result).contains(CharSequence.class));
    }

    // Example classes for testing purposes
    private static class ExampleClass {

        <T> void exampleMethod(T param) {
        }
    }

    private static class ExampleClassWithSingleBound extends ExampleClass {

        <T extends Number> void exampleMethod(T param) {
        }
    }

    private static class ExampleClassWithMultipleBounds extends ExampleClass {

        <T extends Number & CharSequence> void exampleMethod(T param) {
        }
    }
}
