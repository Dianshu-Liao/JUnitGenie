package org.apache.commons.lang3.reflect;

import org.apache.commons.lang3.reflect.MethodUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ClassUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.lang3.ClassUtils.Interfaces;
import org.apache.commons.lang3.Validate;

class MethodUtils_invokeMethod_22_0_Test {

    private TestClass testObject;

    @BeforeEach
    void setUp() {
        testObject = new TestClass();
    }

    @Test
    void testInvokeMethodWithValidMethod() throws Exception {
        String result = (String) MethodUtils.invokeMethod(testObject, true, "greet", "World");
        assertEquals("Hello, World", result);
    }

    @Test
    void testInvokeMethodWithNoArgs() throws Exception {
        String result = (String) MethodUtils.invokeMethod(testObject, true, "getDefaultGreeting");
        assertEquals("Hello, User", result);
    }

    @Test
    void testInvokeMethodWithNullArgs() throws Exception {
        String result = (String) MethodUtils.invokeMethod(testObject, true, "greet", (Object[]) null);
        assertEquals("Hello, null", result);
    }

    @Test
    void testInvokeMethodWithNonExistentMethod() {
        Exception exception = assertThrows(NoSuchMethodException.class, () -> {
            MethodUtils.invokeMethod(testObject, true, "nonExistentMethod");
        });
        assertTrue(exception.getMessage().contains("No such method: nonExistentMethod() on object: TestClass"));
    }

    @Test
    void testInvokeMethodWithPrivateMethod() throws Exception {
        String result = (String) MethodUtils.invokeMethod(testObject, true, "privateGreet", "JUnit");
        assertEquals("Hello from private method, JUnit", result);
    }

    static class TestClass {

        public String greet(String name) {
            return "Hello, " + name;
        }

        public String getDefaultGreeting() {
            return "Hello, User";
        }

        private String privateGreet(String name) {
            return "Hello from private method, " + name;
        }
    }
}
