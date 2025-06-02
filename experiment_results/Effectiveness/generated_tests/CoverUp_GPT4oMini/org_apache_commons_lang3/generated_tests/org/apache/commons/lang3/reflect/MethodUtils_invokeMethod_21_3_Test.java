package org.apache.commons.lang3.reflect;

import org.apache.commons.lang3.reflect.MethodUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.AccessibleObject;
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
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.ClassUtils.Interfaces;
import org.apache.commons.lang3.Validate;

class MethodUtils_invokeMethod_21_3_Test {

    private static class TestClass {

        private String greet(String name) {
            return "Hello, " + name + "!";
        }
    }

    @Test
    void testInvokeMethod_WithValidMethod() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        TestClass testClass = new TestClass();
        String result = (String) MethodUtils.invokeMethod(testClass, true, "greet");
        assertEquals("Hello, null!", result);
    }

    @Test
    void testInvokeMethod_WithValidMethodAndParameter() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        TestClass testClass = new TestClass();
        Method method = TestClass.class.getDeclaredMethod("greet", String.class);
        String result = (String) MethodUtils.invokeMethod(testClass, true, method.getName(), new Object[] { "World" });
        assertEquals("Hello, World!", result);
    }

    @Test
    void testInvokeMethod_WithNoSuchMethod() {
        TestClass testClass = new TestClass();
        assertThrows(NoSuchMethodException.class, () -> {
            MethodUtils.invokeMethod(testClass, true, "nonExistentMethod");
        });
    }

    @Test
    void testInvokeMethod_WithIllegalAccess() {
        class PrivateMethodClass {

            private String secret() {
                return "This is a secret!";
            }
        }
        PrivateMethodClass privateMethodClass = new PrivateMethodClass();
        assertThrows(InvocationTargetException.class, () -> {
            MethodUtils.invokeMethod(privateMethodClass, false, "secret");
        });
    }

    @Test
    void testInvokeMethod_WithNullObject() {
        assertThrows(NullPointerException.class, () -> {
            MethodUtils.invokeMethod(null, true, "greet");
        });
    }

    @Test
    void testInvokeMethod_WithForceAccessFalse() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        TestClass testClass = new TestClass();
        Method method = TestClass.class.getDeclaredMethod("greet", String.class);
        // Set the method accessible
        AccessibleObject.setAccessible(new Method[] { method }, true);
        String result = (String) MethodUtils.invokeMethod(testClass, false, method.getName(), new Object[] { "John" });
        assertEquals("Hello, John!", result);
    }
}
