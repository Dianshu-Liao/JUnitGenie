package org.apache.commons.lang3.reflect;

import org.apache.commons.lang3.reflect.TypeUtils;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
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
import java.lang.reflect.TypeVariable;
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

public class TypeUtils_isAssignable_31_0_Test {

    @Test
    public void testIsAssignable_withSameClass() {
        assertTrue(TypeUtils.isAssignable(String.class, String.class));
    }

    @Test
    public void testIsAssignable_withSubclass() {
        assertTrue(TypeUtils.isAssignable(String.class, CharSequence.class));
    }

    @Test
    public void testIsAssignable_withSuperClass() {
        assertFalse(TypeUtils.isAssignable(CharSequence.class, String.class));
    }

    @Test
    public void testIsAssignable_withObject() {
        assertTrue(TypeUtils.isAssignable(Object.class, String.class));
    }

    @Test
    public void testIsAssignable_withWildcard() {
        WildcardType wildcard = TypeUtils.WILDCARD_ALL;
        assertTrue(TypeUtils.isAssignable(wildcard, Object.class));
        assertFalse(TypeUtils.isAssignable(wildcard, String.class));
    }

    @Test
    public void testIsAssignable_withNull() {
        assertFalse(TypeUtils.isAssignable(null, String.class));
        assertFalse(TypeUtils.isAssignable(String.class, null));
        assertTrue(TypeUtils.isAssignable(null, null));
    }

    @Test
    public void testIsAssignable_withDifferentTypes() {
        assertFalse(TypeUtils.isAssignable(Integer.class, String.class));
        assertFalse(TypeUtils.isAssignable(String.class, Integer.class));
    }
}
