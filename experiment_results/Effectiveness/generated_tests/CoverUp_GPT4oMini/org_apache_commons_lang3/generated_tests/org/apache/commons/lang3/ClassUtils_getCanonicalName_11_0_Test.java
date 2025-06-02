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

public class ClassUtils_getCanonicalName_11_0_Test {

    @Test
    public void testGetCanonicalName_NullObject_ReturnsValueIfNull() {
        String result = ClassUtils.getCanonicalName(null, "default");
        assertEquals("default", result);
    }

    @Test
    public void testGetCanonicalName_ObjectWithCanonicalName_ReturnsCanonicalName() {
        String result = ClassUtils.getCanonicalName(new ArrayList<>(), "default");
        assertEquals("java.util.ArrayList", result);
    }

    @Test
    public void testGetCanonicalName_ObjectWithNullCanonicalName_ReturnsValueIfNull() {
        String result = ClassUtils.getCanonicalName(new Object() {
        }, "default");
        assertEquals("default", result);
    }
}
