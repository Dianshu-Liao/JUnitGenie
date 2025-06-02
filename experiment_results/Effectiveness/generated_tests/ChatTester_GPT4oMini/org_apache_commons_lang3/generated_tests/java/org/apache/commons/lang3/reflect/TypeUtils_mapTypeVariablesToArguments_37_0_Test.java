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

class TypeUtils_mapTypeVariablesToArguments_37_0_Test {

    private TypeUtils typeUtils;

    @BeforeEach
    void setUp() {
        typeUtils = new TypeUtils();
    }

    @Test
    void testMapTypeVariablesToArguments() throws Exception {
        // Prepare the test input
        Class<TestClass> cls = TestClass.class;
        ParameterizedType parameterizedType = (ParameterizedType) TestParameterizedClass.class.getGenericSuperclass();
        Map<TypeVariable<?>, Type> typeVarAssigns = new HashMap<>();
        TypeVariable<Class<TestClass>> typeVar = TestClass.class.getTypeParameters()[0];
        // Assigning String to the type variable
        typeVarAssigns.put(typeVar, String.class);
        // Invoke the private method using reflection
        Method method = TypeUtils.class.getDeclaredMethod("mapTypeVariablesToArguments", Class.class, ParameterizedType.class, Map.class);
        method.setAccessible(true);
        method.invoke(null, cls, parameterizedType, typeVarAssigns);
        // Verify the results
        TypeVariable<?>[] typeVariables = TestParameterizedClass.class.getTypeParameters();
        assertTrue(typeVarAssigns.containsKey(typeVariables[0]));
        assertEquals(String.class, typeVarAssigns.get(typeVariables[0]));
    }

    @Test
    void testMapTypeVariablesToArgumentsWithMultipleTypeVars() throws Exception {
        // Prepare the test input
        Class<MultiTypeClass> cls = MultiTypeClass.class;
        ParameterizedType parameterizedType = (ParameterizedType) MultiParameterizedClass.class.getGenericSuperclass();
        Map<TypeVariable<?>, Type> typeVarAssigns = new HashMap<>();
        TypeVariable<Class<MultiTypeClass>> typeVar1 = MultiTypeClass.class.getTypeParameters()[0];
        TypeVariable<Class<MultiTypeClass>> typeVar2 = MultiTypeClass.class.getTypeParameters()[1];
        // Assigning String to the first type variable
        typeVarAssigns.put(typeVar1, String.class);
        // Assigning Integer to the second type variable
        typeVarAssigns.put(typeVar2, Integer.class);
        // Invoke the private method using reflection
        Method method = TypeUtils.class.getDeclaredMethod("mapTypeVariablesToArguments", Class.class, ParameterizedType.class, Map.class);
        method.setAccessible(true);
        method.invoke(null, cls, parameterizedType, typeVarAssigns);
        // Verify the results
        TypeVariable<?>[] typeVariables = MultiParameterizedClass.class.getTypeParameters();
        assertTrue(typeVarAssigns.containsKey(typeVariables[0]));
        assertEquals(String.class, typeVarAssigns.get(typeVariables[0]));
        assertTrue(typeVarAssigns.containsKey(typeVariables[1]));
        assertEquals(Integer.class, typeVarAssigns.get(typeVariables[1]));
    }

    // Sample classes for testing
    static class TestClass<T> {
    }

    static class TestParameterizedClass extends TestClass<String> {
    }

    static class MultiTypeClass<T, U> {
    }

    static class MultiParameterizedClass extends MultiTypeClass<String, Integer> {
    }
}
