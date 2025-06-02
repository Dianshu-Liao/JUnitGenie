package org.apache.commons.lang3.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.HashMap;
import java.util.Map;
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

public class TypeUtils_isAssignable_34_0_Test {

    private TypeUtils typeUtils;

    @BeforeEach
    public void setUp() {
        typeUtils = new TypeUtils();
    }

    @Test
    public void testIsAssignable_NullType() throws Exception {
        Method method = TypeUtils.class.getDeclaredMethod("isAssignable", Type.class, WildcardType.class, Map.class);
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(typeUtils, null, null, new HashMap<>());
        assertTrue(result);
    }

    @Test
    public void testIsAssignable_NullWildcardType() throws Exception {
        Method method = TypeUtils.class.getDeclaredMethod("isAssignable", Type.class, WildcardType.class, Map.class);
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(typeUtils, Object.class, null, new HashMap<>());
        assertFalse(result);
    }

    @Test
    public void testIsAssignable_SameType() throws Exception {
        Method method = TypeUtils.class.getDeclaredMethod("isAssignable", Type.class, WildcardType.class, Map.class);
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(typeUtils, Object.class, createWildcardType(Object.class), new HashMap<>());
        assertTrue(result);
    }

    @Test
    public void testIsAssignable_UpperBoundAssignable() throws Exception {
        Method method = TypeUtils.class.getDeclaredMethod("isAssignable", Type.class, WildcardType.class, Map.class);
        method.setAccessible(true);
        Map<TypeVariable<?>, Type> typeVarAssigns = new HashMap<>();
        boolean result = (boolean) method.invoke(typeUtils, createWildcardType(Number.class), createWildcardType(Object.class), typeVarAssigns);
        assertTrue(result);
    }

    @Test
    public void testIsAssignable_LowerBoundNotAssignable() throws Exception {
        Method method = TypeUtils.class.getDeclaredMethod("isAssignable", Type.class, WildcardType.class, Map.class);
        method.setAccessible(true);
        Map<TypeVariable<?>, Type> typeVarAssigns = new HashMap<>();
        boolean result = (boolean) method.invoke(typeUtils, createWildcardType(String.class), createWildcardType(Number.class), typeVarAssigns);
        assertFalse(result);
    }

    @Test
    public void testIsAssignable_ComplexTypeAssignment() throws Exception {
        Method method = TypeUtils.class.getDeclaredMethod("isAssignable", Type.class, WildcardType.class, Map.class);
        method.setAccessible(true);
        Map<TypeVariable<?>, Type> typeVarAssigns = new HashMap<>();
        boolean result = (boolean) method.invoke(typeUtils, createWildcardType(List.class), createWildcardType(Collection.class), typeVarAssigns);
        assertTrue(result);
    }

    private WildcardType createWildcardType(Class<?> clazz) {
        return new WildcardType() {

            @Override
            public Type[] getUpperBounds() {
                return new Type[] { clazz };
            }

            @Override
            public Type[] getLowerBounds() {
                return new Type[0];
            }
        };
    }
}
