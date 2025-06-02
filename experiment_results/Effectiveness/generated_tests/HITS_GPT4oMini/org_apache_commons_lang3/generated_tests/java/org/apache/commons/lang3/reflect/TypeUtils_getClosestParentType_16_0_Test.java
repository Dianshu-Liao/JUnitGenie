package org.apache.commons.lang3.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
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

class TypeUtils_getClosestParentType_16_0_Test {

    private Type invokeGetClosestParentType(Class<?> cls, Class<?> superClass) throws Exception {
        Method method = TypeUtils.class.getDeclaredMethod("getClosestParentType", Class.class, Class.class);
        method.setAccessible(true);
        return (Type) method.invoke(null, cls, superClass);
    }

    // Sample classes for testing
    interface Animal {
    }

    interface Pet extends Animal {
    }

    class LivingBeing {
    }

    class Dog extends LivingBeing implements Pet {
    }

    class GenericAnimal<T> {
    }

    class GenericDog extends GenericAnimal<Dog> {
    }

    class Unknown {
    }

    // Test case for a class that directly implements an interface
    @Test
    void testGetClosestParentType_DirectInterface() throws Exception {
        Type result = invokeGetClosestParentType(Dog.class, Animal.class);
        assertEquals(Animal.class, result);
    }

    // Test case for a class that implements multiple interfaces
    @Test
    void testGetClosestParentType_MultipleInterfaces() throws Exception {
        Type result = invokeGetClosestParentType(Dog.class, Pet.class);
        assertEquals(Pet.class, result);
    }

    // Test case for a class that extends a superclass that implements an interface
    @Test
    void testGetClosestParentType_SuperClass() throws Exception {
        Type result = invokeGetClosestParentType(Dog.class, LivingBeing.class);
        assertEquals(LivingBeing.class, result);
    }

    // Test case for a class with no direct relationship to the superclass
    @Test
    void testGetClosestParentType_NoDirectRelationship() throws Exception {
        Type result = invokeGetClosestParentType(Dog.class, Object.class);
        assertEquals(Object.class, result);
    }

    // Test case for generic types
    @Test
    void testGetClosestParentType_GenericType() throws Exception {
        Type result = invokeGetClosestParentType(GenericDog.class, GenericAnimal.class);
        assertTrue(result instanceof ParameterizedType);
    }

    // Test case for an interface that is not implemented
    @Test
    void testGetClosestParentType_InterfaceNotImplemented() throws Exception {
        Type result = invokeGetClosestParentType(Dog.class, Unknown.class);
        assertEquals(Object.class, result);
    }

    // Test case for a class that does not extend any class
    static class NoSuperClass {
    }

    @Test
    void testGetClosestParentType_NoSuperClass() throws Exception {
        Type result = invokeGetClosestParentType(NoSuperClass.class, Object.class);
        assertEquals(Object.class, result);
    }
}
