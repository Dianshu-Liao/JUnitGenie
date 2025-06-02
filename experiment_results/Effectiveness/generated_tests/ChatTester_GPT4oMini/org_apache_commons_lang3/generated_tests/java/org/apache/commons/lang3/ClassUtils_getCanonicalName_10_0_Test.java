package org.apache.commons.lang3;

import java.lang.reflect.Method;
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
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import org.apache.commons.lang3.mutable.MutableObject;

public class ClassUtils_getCanonicalName_10_0_Test {

    private ClassUtils classUtils;

    @BeforeEach
    public void setUp() {
        classUtils = new ClassUtils();
    }

    @Test
    public void testGetCanonicalName_NonNullObject() throws Exception {
        String expected = "java.lang.String";
        String actual = invokeGetCanonicalName("test");
        assertEquals(expected, actual);
    }

    @Test
    public void testGetCanonicalName_NullObject() throws Exception {
        String actual = invokeGetCanonicalName(null);
        assertNull(actual);
    }

    @Test
    public void testGetCanonicalName_IntegerObject() throws Exception {
        String expected = "java.lang.Integer";
        String actual = invokeGetCanonicalName(123);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetCanonicalName_CustomObject() throws Exception {
        // Adjust the package and class name accordingly
        String expected = "com.example.MyClass";
        String actual = invokeGetCanonicalName(new MyClass());
        assertEquals(expected, actual);
    }

    @Test
    public void testGetCanonicalName_ArrayObject() throws Exception {
        String expected = "[Ljava.lang.String;";
        String actual = invokeGetCanonicalName(new String[] { "test" });
        assertEquals(expected, actual);
    }

    private String invokeGetCanonicalName(Object object) throws Exception {
        Method method = ClassUtils.class.getDeclaredMethod("getCanonicalName", Object.class);
        method.setAccessible(true);
        return (String) method.invoke(null, object);
    }

    // Dummy class for testing custom object
    private static class MyClass {
        // Custom class for testing purposes
    }
}
