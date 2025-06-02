package org.apache.commons.lang3;

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
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class ClassUtils_getCanonicalName_11_0_Test {

    @Test
    void testGetCanonicalName_NullObject_ReturnsValueIfNull() {
        String result = ClassUtils.getCanonicalName(null, "default");
        assertEquals("default", result);
    }

    @Test
    void testGetCanonicalName_NonNullObject_ReturnsCanonicalName() {
        String result = ClassUtils.getCanonicalName(new String(), "default");
        assertEquals("java.lang.String", result);
    }

    @Test
    void testGetCanonicalName_NonNullObjectWithNullCanonicalName_ReturnsValueIfNull() {
        Object object = new Object() {

            // Fixed: Correctly override the toString method instead of a non-existent getCanonicalName method
            @Override
            public String toString() {
                return null;
            }
        };
        String result = ClassUtils.getCanonicalName(object, "default");
        assertEquals("default", result);
    }

    @Test
    void testGetCanonicalName_NonNullObjectWithCustomClass_ReturnsCanonicalName() {
        class CustomClass {
        }
        String result = ClassUtils.getCanonicalName(new CustomClass(), "default");
        // Inner class name format
        assertEquals("ClassUtils_getCanonicalName_11_0_Test$1", result);
    }

    @Test
    void testGetCanonicalName_NonNullObjectWithAnonymousClass_ReturnsCanonicalName() {
        Object object = new Object() {
        };
        String result = ClassUtils.getCanonicalName(object, "default");
        // Check for anonymous class prefix
        assertTrue(result.startsWith("ClassUtils_getCanonicalName_11_0_Test$"));
    }
}
