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

    @Test
    public void testGetAllInterfaces_WithSingleInterface() throws Exception {
        HashSet<Class<?>> interfacesFound = new HashSet<>();
        invokeGetAllInterfaces(SampleClassWithOneInterface.class, interfacesFound);
        assertTrue(interfacesFound.contains(SampleInterface.class), "Should find SampleInterface");
    }

    @Test
    public void testGetAllInterfaces_WithMultipleInterfaces() throws Exception {
        HashSet<Class<?>> interfacesFound = new HashSet<>();
        invokeGetAllInterfaces(SampleClassWithMultipleInterfaces.class, interfacesFound);
        assertTrue(interfacesFound.contains(SampleInterface.class), "Should find SampleInterface");
        assertTrue(interfacesFound.contains(AnotherSampleInterface.class), "Should find AnotherSampleInterface");
    }

    @Test
    public void testGetAllInterfaces_WithInheritance() throws Exception {
        HashSet<Class<?>> interfacesFound = new HashSet<>();
        invokeGetAllInterfaces(SubClass.class, interfacesFound);
        assertTrue(interfacesFound.contains(SampleInterface.class), "Should find SampleInterface");
        assertTrue(interfacesFound.contains(AnotherSampleInterface.class), "Should find AnotherSampleInterface");
    }

    @Test
    public void testGetAllInterfaces_WithNoInterfaces() throws Exception {
        HashSet<Class<?>> interfacesFound = new HashSet<>();
        invokeGetAllInterfaces(NoInterfaceClass.class, interfacesFound);
        assertTrue(interfacesFound.isEmpty(), "Should find no interfaces");
    }

    @Test
    public void testGetAllInterfaces_WithAbstractClass() throws Exception {
        HashSet<Class<?>> interfacesFound = new HashSet<>();
        invokeGetAllInterfaces(AbstractClassWithInterface.class, interfacesFound);
        assertTrue(interfacesFound.contains(SampleInterface.class), "Should find SampleInterface");
    }

    private void invokeGetAllInterfaces(Class<?> cls, HashSet<Class<?>> interfacesFound) throws Exception {
        Method method = ClassUtils.class.getDeclaredMethod("getAllInterfaces", Class.class, HashSet.class);
        method.setAccessible(true);
        method.invoke(null, cls, interfacesFound);
    }

    // Sample classes for testing
    interface SampleInterface {
    }

    interface AnotherSampleInterface {
    }

    class SampleClassWithOneInterface implements SampleInterface {
    }

    class SampleClassWithMultipleInterfaces implements SampleInterface, AnotherSampleInterface {
    }

    class BaseClass {
        // Base class with no interfaces
    }

    class SubClass extends BaseClass implements SampleInterface, AnotherSampleInterface {
    }

    class NoInterfaceClass {
    }

    abstract class AbstractClassWithInterface implements SampleInterface {
    }
}
