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

public class ClassUtils_getAllInterfaces_5_0_Test {

    @Test
    public void testGetAllInterfaces_NullClass() {
        // Test case for null input
        List<Class<?>> result = ClassUtils.getAllInterfaces(null);
        assertNull(result, "Expected null when input is null");
    }

    @Test
    public void testGetAllInterfaces_EmptyClass() {
        // Test case for an empty class (no interfaces)
        List<Class<?>> result = ClassUtils.getAllInterfaces(EmptyClass.class);
        assertEquals(0, result.size(), "Expected empty list for class with no interfaces");
    }

    @Test
    public void testGetAllInterfaces_SingleInterface() {
        // Test case for a class that implements a single interface
        List<Class<?>> result = ClassUtils.getAllInterfaces(SingleInterfaceClass.class);
        assertEquals(1, result.size(), "Expected list size of 1 for class implementing a single interface");
        assertEquals(SingleInterface.class, result.get(0), "Expected the interface to be SingleInterface");
    }

    @Test
    public void testGetAllInterfaces_MultipleInterfaces() {
        // Test case for a class that implements multiple interfaces
        List<Class<?>> result = ClassUtils.getAllInterfaces(MultipleInterfacesClass.class);
        assertEquals(2, result.size(), "Expected list size of 2 for class implementing multiple interfaces");
        assertEquals(SingleInterface.class, result.get(0), "Expected first interface to be SingleInterface");
        assertEquals(AnotherInterface.class, result.get(1), "Expected second interface to be AnotherInterface");
    }

    @Test
    public void testGetAllInterfaces_Inheritance() {
        // Test case for a class that implements interfaces from a superclass
        List<Class<?>> result = ClassUtils.getAllInterfaces(SubClass.class);
        assertEquals(2, result.size(), "Expected list size of 2 for subclass implementing interfaces");
        assertEquals(SingleInterface.class, result.get(0), "Expected first interface to be SingleInterface");
        assertEquals(AnotherInterface.class, result.get(1), "Expected second interface to be AnotherInterface");
    }

    // Test classes for the unit tests
    interface SingleInterface {
    }

    interface AnotherInterface {
    }

    class EmptyClass {
    }

    class SingleInterfaceClass implements SingleInterface {
    }

    class MultipleInterfacesClass implements SingleInterface, AnotherInterface {
    }

    class SuperClass implements SingleInterface {
    }

    class SubClass extends SuperClass implements AnotherInterface {
    }
}
