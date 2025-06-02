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

public class ClassUtils_getAbbreviatedName_3_0_Test {

    @Test
    public void testGetAbbreviatedName_NullClass() {
        String result = ClassUtils.getAbbreviatedName((Class<?>) null, 5);
        assertEquals("", result);
    }

    @Test
    public void testGetAbbreviatedName_ValidClass() {
        String result = ClassUtils.getAbbreviatedName(String.class, 5);
        assertEquals("java.lang.String", result);
    }

    @Test
    public void testGetAbbreviatedName_EmptyClassName() {
        String result = ClassUtils.getAbbreviatedName(ClassUtils.class, 0);
        assertEquals("ClassUtils", result);
    }

    @Test
    public void testGetAbbreviatedName_ExactLength() {
        String result = ClassUtils.getAbbreviatedName(Integer.class, 5);
        assertEquals("java.lang.Integer", result);
    }

    @Test
    public void testGetAbbreviatedName_TooShortLength() {
        String result = ClassUtils.getAbbreviatedName(Double.class, 2);
        assertEquals("java.lang.Double", result);
    }

    @Test
    public void testGetAbbreviatedName_ClassWithAbbreviation() {
        String result = ClassUtils.getAbbreviatedName(java.util.List.class, 4);
        assertEquals("List", result);
    }
}
