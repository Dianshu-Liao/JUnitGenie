package org.apache.commons.lang3;

import org.apache.commons.lang3.ClassUtils;
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
    public void testGetAllInterfaces() throws Exception {
        // Prepare a HashSet to hold the found interfaces
        HashSet<Class<?>> interfacesFound = new HashSet<>();
        // Use reflection to access the private method
        Method method = ClassUtils.class.getDeclaredMethod("getAllInterfaces", Class.class, HashSet.class);
        method.setAccessible(true);
        // Test with a class that implements multiple interfaces
        method.invoke(null, TestClass.class, interfacesFound);
        // Check that all interfaces are found
        assertTrue(interfacesFound.contains(TestInterface1.class));
        assertTrue(interfacesFound.contains(TestInterface2.class));
        assertTrue(interfacesFound.contains(TestInterface3.class));
        assertTrue(interfacesFound.contains(TestInterface4.class));
    }

    // Test class with multiple interfaces
    private static class TestClass extends BaseClass implements TestInterface1, TestInterface2 {
    }

    private static class BaseClass implements TestInterface3 {
    }

    private interface TestInterface1 {
    }

    private interface TestInterface2 {
    }

    private interface TestInterface3 {
    }

    private interface TestInterface4 {
    }
}
