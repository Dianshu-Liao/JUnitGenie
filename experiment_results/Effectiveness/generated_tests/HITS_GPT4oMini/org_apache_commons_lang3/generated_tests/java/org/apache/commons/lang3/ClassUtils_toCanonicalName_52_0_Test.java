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

    private String invokeToCanonicalName(String input) throws Exception {
        Method method = ClassUtils.class.getDeclaredMethod("toCanonicalName", String.class);
        // Allow access to the private method
        method.setAccessible(true);
        return (String) method.invoke(null, input);
    }

    @Test
    public void testToCanonicalName_WithSingleClass() throws Exception {
        String input = "MyClass";
        String expected = "LMyClass;";
        String actual = invokeToCanonicalName(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testToCanonicalName_WithClassWithWhitespace() throws Exception {
        String input = " MyClass ";
        String expected = "LMyClass;";
        String actual = invokeToCanonicalName(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testToCanonicalName_WithArrayClass() throws Exception {
        String input = " MyClass[] ";
        String expected = "[LMyClass;";
        String actual = invokeToCanonicalName(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testToCanonicalName_WithMultiDimensionalArray() throws Exception {
        String input = " MyClass[][] ";
        String expected = "[[LMyClass;";
        String actual = invokeToCanonicalName(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testToCanonicalName_WithPrimitiveArray() throws Exception {
        String input = " int[] ";
        String expected = "[I";
        String actual = invokeToCanonicalName(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testToCanonicalName_WithNullInput() {
        assertThrows(NullPointerException.class, () -> {
            invokeToCanonicalName(null);
        });
    }

    @Test
    public void testToCanonicalName_WithEmptyString() throws Exception {
        String input = " ";
        String expected = "";
        String actual = invokeToCanonicalName(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testToCanonicalName_WithAbbreviatedClassName() throws Exception {
        // Assuming there's an abbreviation mapping for "MyClass" to "M"
        String input = "MyClass";
        String expected = "LMyClass;";
        String actual = invokeToCanonicalName(input);
        assertEquals(expected, actual);
    }
}
