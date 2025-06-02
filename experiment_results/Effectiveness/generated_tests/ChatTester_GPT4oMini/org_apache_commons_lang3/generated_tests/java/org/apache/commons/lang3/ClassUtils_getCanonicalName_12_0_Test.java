package org.apache.commons.lang3;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
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
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import org.apache.commons.lang3.mutable.MutableObject;

class ClassUtils_getCanonicalName_12_0_Test {

    private static final Map<String, String> reverseAbbreviationMap = new HashMap<>();

    static {
        reverseAbbreviationMap.put("I", "int");
        reverseAbbreviationMap.put("Z", "boolean");
        reverseAbbreviationMap.put("B", "byte");
        reverseAbbreviationMap.put("C", "char");
        reverseAbbreviationMap.put("D", "double");
        reverseAbbreviationMap.put("F", "float");
        reverseAbbreviationMap.put("J", "long");
        reverseAbbreviationMap.put("S", "short");
        // Add more mappings as needed
    }

    @Test
    void testGetCanonicalName_withArrayType() throws Exception {
        String input = "[[Ljava.lang.String;";
        String expected = "java.lang.String[][]";
        String actual = invokeGetCanonicalName(input);
        assertEquals(expected, actual);
    }

    @Test
    void testGetCanonicalName_withPrimitiveType() throws Exception {
        // int
        String input = "I";
        String expected = "int";
        String actual = invokeGetCanonicalName(input);
        assertEquals(expected, actual);
    }

    @Test
    void testGetCanonicalName_withObjectType() throws Exception {
        String input = "Ljava.lang.String;";
        String expected = "java.lang.String";
        String actual = invokeGetCanonicalName(input);
        assertEquals(expected, actual);
    }

    @Test
    void testGetCanonicalName_withWhitespace() throws Exception {
        String input = "  Ljava.lang.String;  ";
        String expected = "java.lang.String";
        String actual = invokeGetCanonicalName(input);
        assertEquals(expected, actual);
    }

    @Test
    void testGetCanonicalName_withUnknownType() throws Exception {
        String input = "X";
        // Assuming reverseAbbreviationMap does not contain "X"
        String expected = null;
        String actual = invokeGetCanonicalName(input);
        assertEquals(expected, actual);
    }

    @Test
    void testGetCanonicalName_withNull() throws Exception {
        String input = null;
        String expected = null;
        String actual = invokeGetCanonicalName(input);
        assertEquals(expected, actual);
    }

    private String invokeGetCanonicalName(String className) throws Exception {
        Method method = ClassUtils.class.getDeclaredMethod("getCanonicalName", String.class);
        method.setAccessible(true);
        return (String) method.invoke(null, className);
    }
}
