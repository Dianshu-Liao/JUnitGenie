package org.apache.commons.lang3.reflect;

import org.apache.commons.lang3.reflect.TypeUtils;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.HashMap;
import java.util.Map;
import java.lang.reflect.Proxy;
import java.lang.reflect.Method;
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

public class TypeUtils_isAssignable_34_1_Test {

    @Test
    public void testIsAssignableWithNullType() throws Exception {
        WildcardType wildcardType = createWildcardType(new Class<?>[] { Object.class }, new Class<?>[] {});
        assertTrue(invokeIsAssignable(null, wildcardType, new HashMap<>()));
    }

    @Test
    public void testIsAssignableWithNullWildcardType() throws Exception {
        assertFalse(invokeIsAssignable(String.class, null, new HashMap<>()));
    }

    @Test
    public void testIsAssignableWithSameType() throws Exception {
        assertTrue(invokeIsAssignable(String.class, createWildcardType(new Class<?>[] { String.class }, new Class<?>[] {}), new HashMap<>()));
    }

    @Test
    public void testIsAssignableWithUpperBound() throws Exception {
        WildcardType wildcardType = createWildcardType(new Class<?>[] { Number.class }, new Class<?>[] {});
        assertTrue(invokeIsAssignable(Integer.class, wildcardType, new HashMap<>()));
    }

    @Test
    public void testIsNotAssignableWithUpperBound() throws Exception {
        WildcardType wildcardType = createWildcardType(new Class<?>[] { String.class }, new Class<?>[] {});
        assertFalse(invokeIsAssignable(Integer.class, wildcardType, new HashMap<>()));
    }

    @Test
    public void testIsAssignableWithLowerBound() throws Exception {
        WildcardType wildcardType = createWildcardType(new Class<?>[] {}, new Class<?>[] { Number.class });
        assertTrue(invokeIsAssignable(Integer.class, wildcardType, new HashMap<>()));
    }

    @Test
    public void testIsNotAssignableWithLowerBound() throws Exception {
        WildcardType wildcardType = createWildcardType(new Class<?>[] {}, new Class<?>[] { String.class });
        assertFalse(invokeIsAssignable(Integer.class, wildcardType, new HashMap<>()));
    }

    @Test
    public void testIsAssignableWithMultipleBounds() throws Exception {
        WildcardType wildcardType = createWildcardType(new Class<?>[] { Number.class }, new Class<?>[] {});
        assertTrue(invokeIsAssignable(Double.class, wildcardType, new HashMap<>()));
    }

    private WildcardType createWildcardType(Class<?>[] upperBounds, Class<?>[] lowerBounds) throws Exception {
        return (WildcardType) Proxy.newProxyInstance(WildcardType.class.getClassLoader(), new Class[] { WildcardType.class }, (proxy, method, args) -> {
            if ("getUpperBounds".equals(method.getName())) {
                return upperBounds;
            } else if ("getLowerBounds".equals(method.getName())) {
                return lowerBounds;
            }
            return null;
        });
    }

    private boolean invokeIsAssignable(Type type, WildcardType wildcardType, Map<TypeVariable<?>, Type> typeVarAssigns) throws Exception {
        Method method = TypeUtils.class.getDeclaredMethod("isAssignable", Type.class, WildcardType.class, Map.class);
        method.setAccessible(true);
        return (boolean) method.invoke(null, type, wildcardType, typeVarAssigns);
    }
}
