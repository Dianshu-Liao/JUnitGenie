package org.apache.commons.lang3.reflect;

import java.io.Serializable;
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

public class TypeUtils_getImplicitBounds_17_0_Test {

    @Test
    public void testGetImplicitBounds_WithNoBounds() {
        TypeVariable<Class<TestClassWithoutBounds>> typeVariable = TestClassWithoutBounds.class.getTypeParameters()[0];
        Type[] expected = new Type[] { Object.class };
        Type[] actual = TypeUtils.getImplicitBounds(typeVariable);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testGetImplicitBounds_WithSingleBound() {
        TypeVariable<Class<TestClassWithSingleBound>> typeVariable = TestClassWithSingleBound.class.getTypeParameters()[0];
        Type[] expected = new Type[] { Number.class };
        Type[] actual = TypeUtils.getImplicitBounds(typeVariable);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testGetImplicitBounds_WithMultipleBounds() {
        TypeVariable<Class<TestClassWithMultipleBounds>> typeVariable = TestClassWithMultipleBounds.class.getTypeParameters()[0];
        Type[] expected = new Type[] { Comparable.class, Serializable.class };
        Type[] actual = TypeUtils.getImplicitBounds(typeVariable);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testGetImplicitBounds_WithNoTypeVariable() {
        assertThrows(NullPointerException.class, () -> {
            TypeUtils.getImplicitBounds(null);
        });
    }

    @Test
    public void testGetImplicitBounds_WithWildcardBounds() {
        TypeVariable<Class<TestClassWithWildcardBound>> typeVariable = TestClassWithWildcardBound.class.getTypeParameters()[0];
        Type[] expected = new Type[] { TypeUtils.WILDCARD_ALL };
        Type[] actual = TypeUtils.getImplicitBounds(typeVariable);
        assertArrayEquals(expected, actual);
    }

    // Sample classes for testing purposes
    private static class TestClassWithoutBounds<T> {
    }

    private static class TestClassWithSingleBound<T extends Number> {
    }

    private static class TestClassWithMultipleBounds<T extends Comparable<T> & Serializable> {
    }

    private static class TestClassWithWildcardBound<T extends Comparable<?>> {
    }
}
