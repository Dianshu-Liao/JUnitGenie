package org.apache.commons.lang3.reflect;

import org.apache.commons.lang3.reflect.TypeUtils;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
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

public class TypeUtils_getClosestParentType_16_2_Test {

    @Test
    public void testGetClosestParentType_WithInterface() {
        Class<?> cls = ChildClass.class;
        Class<?> superClass = ParentInterface.class;
        Type result = invokeGetClosestParentType(cls, superClass);
        assertEquals(ChildClass.class.getGenericInterfaces()[0], result);
    }

    @Test
    public void testGetClosestParentType_WithSuperclass() {
        Class<?> cls = ChildClass.class;
        Class<?> superClass = ParentClass.class;
        Type result = invokeGetClosestParentType(cls, superClass);
        assertEquals(ParentClass.class, result);
    }

    @Test
    public void testGetClosestParentType_WithNoMatch() {
        Class<?> cls = ChildClass.class;
        Class<?> superClass = UnrelatedClass.class;
        Type result = invokeGetClosestParentType(cls, superClass);
        assertEquals(ChildClass.class.getGenericSuperclass(), result);
    }

    @Test
    public void testGetClosestParentType_WithInvalidType() {
        Class<?> cls = ChildClass.class;
        Class<?> superClass = InvalidInterface.class;
        assertThrows(IllegalStateException.class, () -> {
            invokeGetClosestParentType(cls, superClass);
        });
    }

    private Type invokeGetClosestParentType(Class<?> cls, Class<?> superClass) {
        try {
            Method method = TypeUtils.class.getDeclaredMethod("getClosestParentType", Class.class, Class.class);
            method.setAccessible(true);
            return (Type) method.invoke(null, cls, superClass);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Sample classes for testing
    interface ParentInterface {
    }

    class ParentClass {
    }

    class ChildClass extends ParentClass implements ParentInterface {
    }

    class UnrelatedClass {
    }

    interface InvalidInterface {
    }
}
