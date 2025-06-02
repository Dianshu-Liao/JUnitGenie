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

public class TypeUtils_getClosestParentType_16_0_Test {

    @Test
    public void testGetClosestParentType_WithInterface() throws Exception {
        Class<?> cls = SubClass.class;
        Class<?> superClass = SuperInterface.class;
        Method method = TypeUtils.class.getDeclaredMethod("getClosestParentType", Class.class, Class.class);
        method.setAccessible(true);
        Type result = (Type) method.invoke(null, cls, superClass);
        assertEquals(SuperInterface.class, result);
    }

    @Test
    public void testGetClosestParentType_WithSuperclass() throws Exception {
        Class<?> cls = SubClass.class;
        Class<?> superClass = SuperClass.class;
        Method method = TypeUtils.class.getDeclaredMethod("getClosestParentType", Class.class, Class.class);
        method.setAccessible(true);
        Type result = (Type) method.invoke(null, cls, superClass);
        assertEquals(SuperClass.class, result);
    }

    @Test
    public void testGetClosestParentType_NoMatch() throws Exception {
        Class<?> cls = SubClass.class;
        Class<?> superClass = UnrelatedClass.class;
        Method method = TypeUtils.class.getDeclaredMethod("getClosestParentType", Class.class, Class.class);
        method.setAccessible(true);
        Type result = (Type) method.invoke(null, cls, superClass);
        assertEquals(cls.getGenericSuperclass(), result);
    }

    @Test
    public void testGetClosestParentType_UnexpectedGenericType() throws Exception {
        Class<?> cls = SubClass.class;
        Class<?> superClass = AnotherInterface.class;
        Method method = TypeUtils.class.getDeclaredMethod("getClosestParentType", Class.class, Class.class);
        method.setAccessible(true);
        assertThrows(IllegalStateException.class, () -> {
            method.invoke(null, cls, superClass);
        });
    }

    // Sample classes for testing
    interface SuperInterface {
    }

    class SuperClass {
    }

    class UnrelatedClass {
    }

    class AnotherInterface {
    }

    class SubClass extends SuperClass implements SuperInterface {
    }
}
