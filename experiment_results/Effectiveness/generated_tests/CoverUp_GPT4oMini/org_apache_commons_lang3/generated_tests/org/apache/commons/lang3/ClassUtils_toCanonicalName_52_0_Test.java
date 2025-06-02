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

public class ClassUtils_toCanonicalName_52_0_Test {

    private static ClassUtils classUtils;

    @BeforeAll
    public static void setUp() {
        classUtils = new ClassUtils();
    }

    @Test
    public void testToCanonicalName_SingleClass() throws Exception {
        String className = "java.lang.String";
        String expected = "Ljava.lang.String;";
        String actual = invokeToCanonicalName(className);
        assertEquals(expected, actual);
    }

    @Test
    public void testToCanonicalName_ArrayClass() throws Exception {
        String className = "java.lang.String[]";
        String expected = "[Ljava.lang.String;";
        String actual = invokeToCanonicalName(className);
        assertEquals(expected, actual);
    }

    @Test
    public void testToCanonicalName_NestedClass() throws Exception {
        String className = "java.util.Map$Entry";
        String expected = "Ljava.util.Map$Entry;";
        String actual = invokeToCanonicalName(className);
        assertEquals(expected, actual);
    }

    @Test
    public void testToCanonicalName_Whitespace() throws Exception {
        String className = "  java.lang.String  ";
        String expected = "Ljava.lang.String;";
        String actual = invokeToCanonicalName(className);
        assertEquals(expected, actual);
    }

    @Test
    public void testToCanonicalName_NullInput() {
        assertThrows(NullPointerException.class, () -> invokeToCanonicalName(null));
    }

    @Test
    public void testToCanonicalName_EmptyInput() throws Exception {
        String className = "";
        String expected = "";
        String actual = invokeToCanonicalName(className);
        assertEquals(expected, actual);
    }

    private String invokeToCanonicalName(String className) throws Exception {
        Method method = ClassUtils.class.getDeclaredMethod("toCanonicalName", String.class);
        method.setAccessible(true);
        return (String) method.invoke(classUtils, className);
    }
}
