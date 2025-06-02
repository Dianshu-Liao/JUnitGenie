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

public class ClassUtils_getCanonicalName_8_0_Test {

    private static Class<?> testClass;

    @BeforeAll
    public static void setUp() {
        // Example class for testing
        testClass = String.class;
    }

    @Test
    public void testGetCanonicalName() throws Exception {
        // Invoke the private method using reflection
        Method method = ClassUtils.class.getDeclaredMethod("getCanonicalName", Class.class, String.class);
        method.setAccessible(true);
        // Test with a class
        String result = (String) method.invoke(null, testClass, "");
        assertEquals("java.lang.String", result);
        // Additional tests can be added here for different classes
        result = (String) method.invoke(null, Integer.class, "");
        assertEquals("java.lang.Integer", result);
        result = (String) method.invoke(null, Double.class, "");
        assertEquals("java.lang.Double", result);
        result = (String) method.invoke(null, void.class, "");
        assertEquals("void", result);
        result = (String) method.invoke(null, int.class, "");
        assertEquals("int", result);
        result = (String) method.invoke(null, String[].class, "");
        assertEquals("java.lang.String[]", result);
        result = (String) method.invoke(null, ClassUtils.class, "");
        assertEquals("ClassUtils", result);
    }
}
