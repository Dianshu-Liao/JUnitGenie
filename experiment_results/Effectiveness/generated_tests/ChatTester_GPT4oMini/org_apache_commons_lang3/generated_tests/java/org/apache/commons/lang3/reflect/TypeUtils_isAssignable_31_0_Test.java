package org.apache.commons.lang3.reflect;

import java.lang.reflect.Method;
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
import java.lang.reflect.ParameterizedType;
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

class TypeUtils_isAssignable_31_0_Test {

    @Test
    void testIsAssignableWithCompatibleTypes() throws Exception {
        // Example of a compatible type
        Type type = String.class;
        // Example of a compatible supertype
        Type toType = CharSequence.class;
        // Invoke the method using reflection
        Method method = TypeUtils.class.getDeclaredMethod("isAssignable", Type.class, Type.class);
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(null, type, toType);
        assertTrue(result);
    }

    @Test
    void testIsAssignableWithIncompatibleTypes() throws Exception {
        // Example of an incompatible type
        Type type = Integer.class;
        // Example of an incompatible type
        Type toType = String.class;
        // Invoke the method using reflection
        Method method = TypeUtils.class.getDeclaredMethod("isAssignable", Type.class, Type.class);
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(null, type, toType);
        assertFalse(result);
    }

    @Test
    void testIsAssignableWithNullType() throws Exception {
        // Null type
        Type type = null;
        // Example of a type to check against
        Type toType = String.class;
        // Invoke the method using reflection
        Method method = TypeUtils.class.getDeclaredMethod("isAssignable", Type.class, Type.class);
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(null, type, toType);
        assertFalse(result);
    }

    @Test
    void testIsAssignableWithNullToType() throws Exception {
        // Example of a type
        Type type = String.class;
        // Null type to check against
        Type toType = null;
        // Invoke the method using reflection
        Method method = TypeUtils.class.getDeclaredMethod("isAssignable", Type.class, Type.class);
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(null, type, toType);
        assertFalse(result);
    }

    @Test
    void testIsAssignableWithBothNull() throws Exception {
        // Null type
        Type type = null;
        // Null type to check against
        Type toType = null;
        // Invoke the method using reflection
        Method method = TypeUtils.class.getDeclaredMethod("isAssignable", Type.class, Type.class);
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(null, type, toType);
        assertFalse(result);
    }
}
