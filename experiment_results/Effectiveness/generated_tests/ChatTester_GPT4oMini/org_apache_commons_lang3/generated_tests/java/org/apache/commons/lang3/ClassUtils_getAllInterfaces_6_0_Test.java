package org.apache.commons.lang3;

import java.lang.reflect.Method;
import java.util.HashSet;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import org.apache.commons.lang3.mutable.MutableObject;

public class ClassUtils_getAllInterfaces_6_0_Test {

    private static Class<?> testClass;

    @BeforeAll
    public static void setUp() {
        // A test class to use for our tests
        testClass = TestClass.class;
    }

    @Test
    public void testGetAllInterfaces() throws Exception {
        HashSet<Class<?>> interfacesFound = new HashSet<>();
        // Use reflection to invoke the private method getAllInterfaces
        Method method = ClassUtils.class.getDeclaredMethod("getAllInterfaces", Class.class, HashSet.class);
        method.setAccessible(true);
        method.invoke(null, testClass, interfacesFound);
        // Verify that all interfaces of the test class and its superclasses are found
        assertTrue(interfacesFound.contains(TestInterface.class));
        assertTrue(interfacesFound.contains(SuperInterface.class));
    }

    @Test
    public void testGetAllInterfacesWithNoInterfaces() throws Exception {
        HashSet<Class<?>> interfacesFound = new HashSet<>();
        // Use reflection to invoke the private method getAllInterfaces
        Method method = ClassUtils.class.getDeclaredMethod("getAllInterfaces", Class.class, HashSet.class);
        method.setAccessible(true);
        method.invoke(null, NoInterfaceClass.class, interfacesFound);
        // Verify that no interfaces are found
        assertTrue(interfacesFound.isEmpty());
    }

    // Sample test classes and interfaces
    interface SuperInterface {
    }

    interface TestInterface extends SuperInterface {
    }

    class TestClass implements TestInterface {
    }

    // A class with no interfaces
    class NoInterfaceClass {
    }
}
