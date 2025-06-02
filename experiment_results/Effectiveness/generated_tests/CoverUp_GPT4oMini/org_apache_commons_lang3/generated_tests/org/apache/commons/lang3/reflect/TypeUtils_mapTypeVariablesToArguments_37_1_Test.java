package org.apache.commons.lang3.reflect;

import org.apache.commons.lang3.reflect.TypeUtils;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
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
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
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

class TypeUtils_mapTypeVariablesToArguments_37_1_Test {

    private static class GenericClass<T> {
    }

    private static class SubClass extends GenericClass<String> {
    }

    private Map<TypeVariable<?>, Type> typeVarAssigns;

    @BeforeEach
    void setUp() {
        typeVarAssigns = new HashMap<>();
    }

    @Test
    void testMapTypeVariablesToArgumentsWithParameterizedType() throws Exception {
        ParameterizedType parameterizedType = (ParameterizedType) SubClass.class.getGenericSuperclass();
        invokeMapTypeVariablesToArguments(SubClass.class, parameterizedType);
        TypeVariable<? extends Class<?>>[] typeParameters = SubClass.class.getTypeParameters();
        assertEquals(1, typeVarAssigns.size());
        assertTrue(typeVarAssigns.containsKey(typeParameters[0]));
        assertEquals(String.class, typeVarAssigns.get(typeParameters[0]));
    }

    @Test
    void testMapTypeVariablesToArgumentsWithNestedParameterizedType() throws Exception {
        ParameterizedType parameterizedType = (ParameterizedType) GenericClass.class.getGenericSuperclass();
        invokeMapTypeVariablesToArguments(GenericClass.class, parameterizedType);
        TypeVariable<? extends Class<?>>[] typeParameters = GenericClass.class.getTypeParameters();
        assertTrue(typeVarAssigns.isEmpty());
    }

    @Test
    void testMapTypeVariablesToArgumentsWithNoTypeVariables() throws Exception {
        ParameterizedType parameterizedType = (ParameterizedType) GenericClass.class.getGenericSuperclass();
        invokeMapTypeVariablesToArguments(Object.class, parameterizedType);
        assertTrue(typeVarAssigns.isEmpty());
    }

    @Test
    void testMapTypeVariablesToArgumentsWithMultipleTypeVariables() throws Exception {
        ParameterizedType parameterizedType = (ParameterizedType) SubClass.class.getGenericSuperclass();
        typeVarAssigns.put(SubClass.class.getTypeParameters()[0], String.class);
        invokeMapTypeVariablesToArguments(SubClass.class, parameterizedType);
        assertEquals(1, typeVarAssigns.size());
        assertTrue(typeVarAssigns.containsKey(SubClass.class.getTypeParameters()[0]));
        assertEquals(String.class, typeVarAssigns.get(SubClass.class.getTypeParameters()[0]));
    }

    private void invokeMapTypeVariablesToArguments(Class<?> cls, ParameterizedType parameterizedType) throws Exception {
        Method method = TypeUtils.class.getDeclaredMethod("mapTypeVariablesToArguments", Class.class, ParameterizedType.class, Map.class);
        method.setAccessible(true);
        method.invoke(null, cls, parameterizedType, typeVarAssigns);
    }
}
