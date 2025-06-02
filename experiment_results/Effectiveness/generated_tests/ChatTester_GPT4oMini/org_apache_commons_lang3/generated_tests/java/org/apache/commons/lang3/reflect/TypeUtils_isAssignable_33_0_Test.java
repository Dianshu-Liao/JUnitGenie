package org.apache.commons.lang3.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.WildcardType;
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
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class TypeUtils_isAssignable_33_0_Test {

    private TypeUtils typeUtils;

    @BeforeEach
    void setUp() {
        typeUtils = new TypeUtils();
    }

    @Test
    void testIsAssignable_NullTypeAndVariable() throws Exception {
        // Given
        Type type = null;
        TypeVariable<?> toTypeVariable = null;
        Map<TypeVariable<?>, Type> typeVarAssigns = new HashMap<>();
        // When
        boolean result = invokeIsAssignable(type, toTypeVariable, typeVarAssigns);
        // Then
        assertTrue(result);
    }

    @Test
    void testIsAssignable_NullTypeVariable() throws Exception {
        // Given
        Type type = String.class;
        TypeVariable<?> toTypeVariable = null;
        Map<TypeVariable<?>, Type> typeVarAssigns = new HashMap<>();
        // When
        boolean result = invokeIsAssignable(type, toTypeVariable, typeVarAssigns);
        // Then
        assertFalse(result);
    }

    @Test
    void testIsAssignable_SameType() throws Exception {
        // Given
        Type type = String.class;
        // Assuming String has type parameters
        TypeVariable<?> toTypeVariable = String.class.getTypeParameters()[0];
        Map<TypeVariable<?>, Type> typeVarAssigns = new HashMap<>();
        // When
        boolean result = invokeIsAssignable(type, toTypeVariable, typeVarAssigns);
        // Then
        assertTrue(result);
    }

    @Test
    void testIsAssignable_TypeVariableAssignable() throws Exception {
        // Given
        // Assuming String has type parameters
        TypeVariable<?> typeVariable = String.class.getTypeParameters()[0];
        // Object is a supertype of String
        Type type = Object.class;
        Map<TypeVariable<?>, Type> typeVarAssigns = new HashMap<>();
        // When
        boolean result = invokeIsAssignable(type, typeVariable, typeVarAssigns);
        // Then
        assertTrue(result);
    }

    @Test
    void testIsAssignable_UnhandledType() throws Exception {
        // Given
        // Using a generic Object type
        Type type = new GenericArrayType() {

            @Override
            public Type getGenericComponentType() {
                return Object.class;
            }
        };
        // Assuming String has type parameters
        TypeVariable<?> toTypeVariable = String.class.getTypeParameters()[0];
        Map<TypeVariable<?>, Type> typeVarAssigns = new HashMap<>();
        // When & Then
        assertThrows(IllegalStateException.class, () -> invokeIsAssignable(type, toTypeVariable, typeVarAssigns));
    }

    @Test
    void testIsAssignable_BoundsCheck() throws Exception {
        // Given
        // Assuming String has type parameters
        TypeVariable<?> typeVariable = String.class.getTypeParameters()[0];
        // String is the same as the type variable
        Type type = String.class;
        Map<TypeVariable<?>, Type> typeVarAssigns = new HashMap<>();
        // When
        boolean result = invokeIsAssignable(type, typeVariable, typeVarAssigns);
        // Then
        assertTrue(result);
    }

    private boolean invokeIsAssignable(Type type, TypeVariable<?> toTypeVariable, Map<TypeVariable<?>, Type> typeVarAssigns) throws Exception {
        Method method = TypeUtils.class.getDeclaredMethod("isAssignable", Type.class, TypeVariable.class, Map.class);
        method.setAccessible(true);
        return (boolean) method.invoke(null, type, toTypeVariable, typeVarAssigns);
    }
}
