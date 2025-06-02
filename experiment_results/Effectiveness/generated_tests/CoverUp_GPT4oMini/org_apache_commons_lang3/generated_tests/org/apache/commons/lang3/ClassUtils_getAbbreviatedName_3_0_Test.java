package org.apache.commons.lang3;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
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

class ClassUtils_getAbbreviatedName_3_0_Test {

    @Test
    void testGetAbbreviatedName_NullClass() {
        String result = ClassUtils.getAbbreviatedName((Class<?>) null, 10);
        assertEquals("", result);
    }

    @Test
    void testGetAbbreviatedName_EmptyClassName() {
        String result = ClassUtils.getAbbreviatedName(String.class, 10);
        assertEquals("java.lang.String", result);
    }

    @Test
    void testGetAbbreviatedName_ShortClassName() {
        String result = ClassUtils.getAbbreviatedName(String.class, 50);
        assertEquals("java.lang.String", result);
    }

    @Test
    void testGetAbbreviatedName_ExactLength() {
        String result = ClassUtils.getAbbreviatedName("java.lang.String", 17);
        assertEquals("java.lang.String", result);
    }

    @Test
    void testGetAbbreviatedName_LengthHintTooShort() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ClassUtils.getAbbreviatedName("java.lang.String", 0);
        });
        assertEquals("len must be > 0", exception.getMessage());
    }

    @Test
    void testGetAbbreviatedName_LengthHintOne() {
        String result = ClassUtils.getAbbreviatedName("java.lang.String", 1);
        assertEquals("j", result);
    }

    @Test
    void testGetAbbreviatedName_LengthHintTwo() {
        String result = ClassUtils.getAbbreviatedName("java.lang.String", 2);
        assertEquals("j.l", result);
    }

    @Test
    void testGetAbbreviatedName_LengthHintThree() {
        String result = ClassUtils.getAbbreviatedName("java.lang.String", 3);
        assertEquals("j.l.S", result);
    }

    @Test
    void testGetAbbreviatedName_LengthHintFour() {
        String result = ClassUtils.getAbbreviatedName("java.lang.String", 4);
        assertEquals("j.l.S", result);
    }

    @Test
    void testGetAbbreviatedName_LengthHintFive() {
        String result = ClassUtils.getAbbreviatedName("java.lang.String", 5);
        assertEquals("j.l.S", result);
    }
}
