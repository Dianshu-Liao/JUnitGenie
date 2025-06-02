package org.apache.commons.lang3;

import org.apache.commons.lang3.ClassUtils;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Method;
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

    @Test
    public void testGetCanonicalName_NullObject_ReturnsEmptyString() {
        // Arrange
        Object input = null;
        String expected = "";
        // Act
        String result = invokeGetCanonicalName(input);
        // Assert
        assertEquals(expected, result);
    }

    @Test
    public void testGetCanonicalName_ObjectWithNoCanonicalName_ReturnsEmptyString() {
        // Arrange
        Object input = new Object() {
        };
        String expected = "";
        // Act
        String result = invokeGetCanonicalName(input);
        // Assert
        assertEquals(expected, result);
    }

    @Test
    public void testGetCanonicalName_RegularObject_ReturnsCanonicalName() {
        // Arrange
        Object input = new String("test");
        String expected = "java.lang.String";
        // Act
        String result = invokeGetCanonicalName(input);
        // Assert
        assertEquals(expected, result);
    }

    private String invokeGetCanonicalName(Object object) {
        try {
            Method method = ClassUtils.class.getDeclaredMethod("getCanonicalName", Object.class);
            method.setAccessible(true);
            return (String) method.invoke(null, object);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
