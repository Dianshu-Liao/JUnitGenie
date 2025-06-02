package org.apache.commons.lang3;

import java.lang.reflect.Method;
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
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ClassUtils_getAbbreviatedName_4_0_Test {

    @Test
    public void testGetAbbreviatedName_LengthHintLessThanOne() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            ClassUtils.getAbbreviatedName("com.example.ClassName", 0);
        });
        assertEquals("len must be > 0", exception.getMessage());
    }

    @Test
    public void testGetAbbreviatedName_NullClassName() {
        String result = ClassUtils.getAbbreviatedName((String) null, 5);
        assertEquals("", result);
    }

    @Test
    public void testGetAbbreviatedName_ClassNameShorterThanLengthHint() {
        String result = ClassUtils.getAbbreviatedName("com", 10);
        assertEquals("com", result);
    }

    @Test
    public void testGetAbbreviatedName_ClassNameEqualToLengthHint() {
        String result = ClassUtils.getAbbreviatedName("com.example", 12);
        assertEquals("com.example", result);
    }

    @Test
    public void testGetAbbreviatedName_ClassNameLongerThanLengthHint() {
        String result = ClassUtils.getAbbreviatedName("com.example.ClassName", 10);
        assertEquals("com.e.ClassName", result);
    }

    @Test
    public void testGetAbbreviatedName_ComplexClassName() {
        String result = ClassUtils.getAbbreviatedName("org.apache.commons.lang3.StringUtils", 15);
        assertEquals("org.a.c.l.StringUtils", result);
    }

    @Test
    public void testGetAbbreviatedName_ConsecutiveDots() {
        String result = ClassUtils.getAbbreviatedName("com..example.ClassName", 10);
        assertEquals("com..ClassName", result);
    }

    // Reflection test for private method `useFull`
    @Test
    public void testUseFull() throws Exception {
        Class<?> clazz = ClassUtils.class;
        Method method = clazz.getDeclaredMethod("useFull", int.class, int.class, int.class, int.class);
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(null, 5, 10, 20, 10);
        assertTrue(result);
    }
}
