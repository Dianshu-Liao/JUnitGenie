package org.apache.commons.lang3.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
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

public class TypeUtils_mapTypeVariablesToArguments_37_0_Test {

    private static class SimpleGenericClass<T> {
    }

    private static class NestedGenericClass<T> extends SimpleGenericClass<T> {
    }

    @Test
    public void testMapTypeVariablesToArguments_SimpleCase() throws Exception {
        Map<TypeVariable<?>, Type> typeVarAssigns = new HashMap<>();
        TypeVariable<Class<SimpleGenericClass>>[] typeParams = (TypeVariable<Class<SimpleGenericClass>>[]) SimpleGenericClass.class.getTypeParameters();
        typeVarAssigns.put(typeParams[0], String.class);
        ParameterizedType parameterizedType = (ParameterizedType) SimpleGenericClass.class.getGenericSuperclass();
        // Accessing the private method using reflection
        Method method = TypeUtils.class.getDeclaredMethod("mapTypeVariablesToArguments", Class.class, ParameterizedType.class, Map.class);
        // Make the private method accessible
        method.setAccessible(true);
        method.invoke(null, SimpleGenericClass.class, parameterizedType, typeVarAssigns);
        assertEquals(String.class, typeVarAssigns.get(typeParams[0]));
    }

    @Test
    public void testMapTypeVariablesToArguments_NestedGenerics() throws Exception {
        Map<TypeVariable<?>, Type> typeVarAssigns = new HashMap<>();
        TypeVariable<Class<NestedGenericClass>>[] typeParams = (TypeVariable<Class<NestedGenericClass>>[]) NestedGenericClass.class.getTypeParameters();
        typeVarAssigns.put(typeParams[0], Integer.class);
        ParameterizedType parameterizedType = (ParameterizedType) NestedGenericClass.class.getGenericSuperclass();
        // Accessing the private method using reflection
        Method method = TypeUtils.class.getDeclaredMethod("mapTypeVariablesToArguments", Class.class, ParameterizedType.class, Map.class);
        // Make the private method accessible
        method.setAccessible(true);
        method.invoke(null, NestedGenericClass.class, parameterizedType, typeVarAssigns);
        assertEquals(Integer.class, typeVarAssigns.get(typeParams[0]));
    }
}
