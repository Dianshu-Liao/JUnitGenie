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

class ClassUtils_toCanonicalName_52_0_Test {

    @Test
    void testToCanonicalName_withArrayType() throws Exception {
        String input = "java.lang.String[]";
        String expected = "Ljava/lang/String;";
        String actual = invokePrivateMethod("toCanonicalName", input);
        assertEquals(expected, actual);
    }

    @Test
    void testToCanonicalName_withNestedArrayType() throws Exception {
        String input = "java.lang.String[][]";
        String expected = "[[Ljava/lang/String;";
        String actual = invokePrivateMethod("toCanonicalName", input);
        assertEquals(expected, actual);
    }

    @Test
    void testToCanonicalName_withNonArrayType() throws Exception {
        String input = "java.lang.String";
        String expected = "Ljava/lang/String;";
        String actual = invokePrivateMethod("toCanonicalName", input);
        assertEquals(expected, actual);
    }

    @Test
    void testToCanonicalName_withWhitespace() throws Exception {
        String input = "   java.lang.String   ";
        String expected = "Ljava/lang/String;";
        String actual = invokePrivateMethod("toCanonicalName", input);
        assertEquals(expected, actual);
    }

    @Test
    void testToCanonicalName_withNullInput() {
        assertThrows(NullPointerException.class, () -> invokePrivateMethod("toCanonicalName", null));
    }

    @Test
    void testToCanonicalName_withAbbreviatedClass() throws Exception {
        String input = "int[]";
        String expected = "[I";
        String actual = invokePrivateMethod("toCanonicalName", input);
        assertEquals(expected, actual);
    }

    private String invokePrivateMethod(String methodName, String parameter) throws Exception {
        Method method = ClassUtils.class.getDeclaredMethod(methodName, String.class);
        method.setAccessible(true);
        return (String) method.invoke(null, parameter);
    }
}
