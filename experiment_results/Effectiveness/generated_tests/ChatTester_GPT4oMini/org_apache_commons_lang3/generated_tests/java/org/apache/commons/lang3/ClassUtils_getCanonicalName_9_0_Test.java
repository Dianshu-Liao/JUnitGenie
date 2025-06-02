package org.apache.commons.lang3;

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

public class ClassUtils_getCanonicalName_9_0_Test {

    @Test
    public void testGetCanonicalName_WithNonNullClass_ReturnsCanonicalName() {
        // Arrange
        Class<?> cls = String.class;
        String defaultValue = "default";
        // Act
        String result = ClassUtils.getCanonicalName(cls, defaultValue);
        // Assert
        assertEquals("java.lang.String", result);
    }

    @Test
    public void testGetCanonicalName_WithNullClass_ReturnsDefaultValue() {
        // Arrange
        Class<?> cls = null;
        String defaultValue = "default";
        // Act
        String result = ClassUtils.getCanonicalName(cls, defaultValue);
        // Assert
        assertEquals(defaultValue, result);
    }

    @Test
    public void testGetCanonicalName_WithClassHavingNoCanonicalName_ReturnsDefaultValue() {
        // Arrange
        // Assuming AnonymousClass is an anonymous class
        Class<?> cls = AnonymousClass.class;
        String defaultValue = "default";
        // Act
        String result = ClassUtils.getCanonicalName(cls, defaultValue);
        // Assert
        assertEquals(defaultValue, result);
    }

    // Anonymous class for testing purposes
    private static class AnonymousClass {
    }

    @Test
    public void testGetCanonicalName_WithPrimitiveClass_ReturnsDefaultValue() {
        // Arrange
        // Primitive class
        Class<?> cls = int.class;
        String defaultValue = "default";
        // Act
        String result = ClassUtils.getCanonicalName(cls, defaultValue);
        // Assert
        assertEquals(defaultValue, result);
    }
}
