package org.apache.commons.lang3;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
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

public class ClassUtils_getAbbreviatedName_4_0_Test {

    @Test
    public void testGetAbbreviatedName_NullClassName() {
        String result = ClassUtils.getAbbreviatedName((String) null, 5);
        assertEquals("", result);
    }

    @Test
    public void testGetAbbreviatedName_LengthHintLessThanOrEqualToZero() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            ClassUtils.getAbbreviatedName("org.apache.commons.lang3.ClassUtils", 0);
        });
        assertEquals("len must be > 0", thrown.getMessage());
    }

    @Test
    public void testGetAbbreviatedName_ClassNameShorterThanLengthHint() {
        String result = ClassUtils.getAbbreviatedName("org", 10);
        assertEquals("org", result);
    }

    @Test
    public void testGetAbbreviatedName_ClassNameEqualToLengthHint() {
        String result = ClassUtils.getAbbreviatedName("org", 3);
        assertEquals("org", result);
    }

    @Test
    public void testGetAbbreviatedName_ClassNameLongerThanLengthHint() {
        String result = ClassUtils.getAbbreviatedName("org.apache.commons.lang3.ClassUtils", 10);
        assertEquals("org.ap...ClassUtils", result);
    }

    @Test
    public void testGetAbbreviatedName_ClassNameWithMultipleParts() {
        String result = ClassUtils.getAbbreviatedName("com.example.project.module.ClassName", 15);
        assertEquals("com.ex...ClassName", result);
    }

    @Test
    public void testGetAbbreviatedName_ClassNameWithInnerClass() {
        String result = ClassUtils.getAbbreviatedName("com.example.ClassName$InnerClass", 25);
        assertEquals("com.example.ClassName$InnerClass", result);
    }

    @Test
    public void testGetAbbreviatedName_ClassNameWithMultipleDots() {
        String result = ClassUtils.getAbbreviatedName("a.b.c.d.e.f.g.h.i.j.k.l.m.n.o.p.q.r.s.t.u.v.w.x.y.z", 50);
        assertEquals("a.b.c.d.e.f.g.h.i.j.k.l.m.n.o.p.q.r.s.t.u.v.w.x.y.z", result);
    }

    @Test
    public void testGetAbbreviatedName_ClassNameWithLengthHintEqualToParts() {
        String result = ClassUtils.getAbbreviatedName("a.b.c.d.e", 5);
        assertEquals("a.b.c.d.e", result);
    }

    // Reflection test for private method
    @Test
    public void testUseFull() throws Exception {
        Method method = ClassUtils.class.getDeclaredMethod("useFull", int.class, int.class, int.class, int.class);
        method.setAccessible(true);
        boolean result = (Boolean) method.invoke(null, 5, 10, 20, 15);
        assertTrue(result);
        result = (Boolean) method.invoke(null, 5, 10, 20, 25);
        assertFalse(result);
    }
}
