package org.apache.commons.lang3.reflect;

import org.apache.commons.lang3.reflect.TypeUtils;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.WildcardType;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
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
// Added import for Serializable
import java.io.Serializable;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.lang3.AppendableJoiner;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.Builder;

public class TypeUtils_getImplicitBounds_17_2_Test {

    @Test
    public void testGetImplicitBounds_WithNoBounds() {
        TypeVariable<Class<ExampleClass>> typeVariable = ExampleClass.class.getTypeParameters()[0];
        Type[] expected = new Type[] { Object.class };
        Type[] actual = TypeUtils.getImplicitBounds(typeVariable);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testGetImplicitBounds_WithSingleBound() {
        TypeVariable<Class<ExampleClass>> typeVariable = ExampleClass.class.getTypeParameters()[1];
        Type[] expected = new Type[] { Number.class };
        Type[] actual = TypeUtils.getImplicitBounds(typeVariable);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testGetImplicitBounds_WithMultipleBounds() {
        TypeVariable<Class<ExampleClass>> typeVariable = ExampleClass.class.getTypeParameters()[2];
        // No change needed here
        Type[] expected = new Type[] { Comparable.class, Serializable.class };
        Type[] actual = TypeUtils.getImplicitBounds(typeVariable);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testGetImplicitBounds_WithNull() {
        assertThrows(NullPointerException.class, () -> TypeUtils.getImplicitBounds(null));
    }

    // Example class for testing
    public static class ExampleClass<T, U extends Number, V extends Comparable<V> & Serializable> {
        // Type parameters for testing
    }
}
