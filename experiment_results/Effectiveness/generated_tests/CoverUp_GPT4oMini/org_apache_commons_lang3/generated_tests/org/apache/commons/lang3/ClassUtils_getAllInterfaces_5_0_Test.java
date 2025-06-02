package org.apache.commons.lang3;

import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import org.apache.commons.lang3.mutable.MutableObject;

class ClassUtils_getAllInterfaces_5_0_Test {

    @Test
    void testGetAllInterfaces_NullClass() {
        List<Class<?>> result = ClassUtils.getAllInterfaces(null);
        Assertions.assertNull(result);
    }

    @Test
    void testGetAllInterfaces_NoInterfaces() {
        List<Class<?>> result = ClassUtils.getAllInterfaces(String.class);
        Assertions.assertNotNull(result);
        Assertions.assertTrue(result.isEmpty());
    }

    @Test
    void testGetAllInterfaces_SingleInterface() {
        List<Class<?>> result = ClassUtils.getAllInterfaces(MyClassWithOneInterface.class);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals(MyInterface.class, result.get(0));
    }

    @Test
    void testGetAllInterfaces_MultipleInterfaces() {
        List<Class<?>> result = ClassUtils.getAllInterfaces(MyClassWithMultipleInterfaces.class);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(2, result.size());
        Assertions.assertTrue(result.contains(MyInterface.class));
        Assertions.assertTrue(result.contains(MySecondInterface.class));
    }

    @Test
    void testGetAllInterfaces_Inheritance() {
        List<Class<?>> result = ClassUtils.getAllInterfaces(MySubClass.class);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals(MyInterface.class, result.get(0));
    }

    // Sample classes for testing
    interface MyInterface {
    }

    interface MySecondInterface {
    }

    class MyClassWithOneInterface implements MyInterface {
    }

    class MyClassWithMultipleInterfaces implements MyInterface, MySecondInterface {
    }

    class MyBaseClass implements MyInterface {
    }

    class MySubClass extends MyBaseClass {
    }
}
