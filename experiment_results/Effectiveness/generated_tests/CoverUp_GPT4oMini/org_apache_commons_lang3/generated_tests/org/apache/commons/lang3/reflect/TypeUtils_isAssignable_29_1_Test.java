package org.apache.commons.lang3.reflect;

import org.apache.commons.lang3.reflect.TypeUtils;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.HashMap;
import java.util.Map;
import java.lang.reflect.Method;
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
import java.lang.reflect.TypeVariable;
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

public class TypeUtils_isAssignable_29_1_Test {

    @Test
    void testIsAssignableWithClassType() {
        Class<?> sourceType = String.class;
        GenericArrayType targetType = (GenericArrayType) java.lang.reflect.Array.newInstance(String.class, 0).getClass().getGenericSuperclass();
        Map<TypeVariable<?>, Type> typeVarAssigns = new HashMap<>();
        boolean result = invokeIsAssignable(sourceType, targetType, typeVarAssigns);
        assertTrue(result);
    }

    @Test
    void testIsAssignableWithGenericArrayType() {
        GenericArrayType sourceType = (GenericArrayType) java.lang.reflect.Array.newInstance(Number.class, 0).getClass().getGenericSuperclass();
        GenericArrayType targetType = (GenericArrayType) java.lang.reflect.Array.newInstance(Object.class, 0).getClass().getGenericSuperclass();
        Map<TypeVariable<?>, Type> typeVarAssigns = new HashMap<>();
        boolean result = invokeIsAssignable(sourceType, targetType, typeVarAssigns);
        assertTrue(result);
    }

    @Test
    void testIsAssignableWithWildcardType() {
        WildcardType wildcardType = TypeUtils.WILDCARD_ALL;
        GenericArrayType targetType = (GenericArrayType) java.lang.reflect.Array.newInstance(Object.class, 0).getClass().getGenericSuperclass();
        Map<TypeVariable<?>, Type> typeVarAssigns = new HashMap<>();
        boolean result = invokeIsAssignable(wildcardType, targetType, typeVarAssigns);
        assertTrue(result);
    }

    @Test
    void testIsAssignableWithIncompatibleTypes() {
        Class<?> sourceType = Integer.class;
        GenericArrayType targetType = (GenericArrayType) java.lang.reflect.Array.newInstance(String.class, 0).getClass().getGenericSuperclass();
        Map<TypeVariable<?>, Type> typeVarAssigns = new HashMap<>();
        boolean result = invokeIsAssignable(sourceType, targetType, typeVarAssigns);
        assertFalse(result);
    }

    private boolean invokeIsAssignable(Type type, GenericArrayType toGenericArrayType, Map<TypeVariable<?>, Type> typeVarAssigns) {
        try {
            Method method = TypeUtils.class.getDeclaredMethod("isAssignable", Type.class, GenericArrayType.class, Map.class);
            method.setAccessible(true);
            return (Boolean) method.invoke(null, type, toGenericArrayType, typeVarAssigns);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
