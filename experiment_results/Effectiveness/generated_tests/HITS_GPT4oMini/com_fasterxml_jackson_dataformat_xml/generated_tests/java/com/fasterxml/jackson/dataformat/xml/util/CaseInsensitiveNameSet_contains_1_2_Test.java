package com.fasterxml.jackson.dataformat.xml.util;

import java.lang.reflect.Constructor;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.*;

public class CaseInsensitiveNameSet_contains_1_2_Test {

    private CaseInsensitiveNameSet caseInsensitiveNameSet;

    @BeforeEach
    public void setUp() throws Exception {
        Set<String> namesToMatch = new HashSet<>();
        namesToMatch.add("Test");
        namesToMatch.add("Example");
        namesToMatch.add("Sample");
        // Use reflection to access the private constructor
        Constructor<CaseInsensitiveNameSet> constructor = CaseInsensitiveNameSet.class.getDeclaredConstructor(Set.class);
        constructor.setAccessible(true);
        caseInsensitiveNameSet = constructor.newInstance(namesToMatch);
    }

    @Test
    public void testContains_WithExactMatch() {
        assertTrue(caseInsensitiveNameSet.contains("Test"));
    }

    @Test
    public void testContains_WithLowercaseMatch() {
        assertTrue(caseInsensitiveNameSet.contains("test"));
    }

    @Test
    public void testContains_WithDifferentCaseMatch() {
        assertTrue(caseInsensitiveNameSet.contains("ExAmPlE"));
    }

    @Test
    public void testContains_WithNonExistentElement() {
        assertFalse(caseInsensitiveNameSet.contains("NonExistent"));
    }

    @Test
    public void testContains_WithNullInput() {
        assertFalse(caseInsensitiveNameSet.contains(null));
    }

    @Test
    public void testContains_WithEmptyString() {
        assertFalse(caseInsensitiveNameSet.contains(""));
    }

    @Test
    public void testContains_WithDifferentString() {
        assertFalse(caseInsensitiveNameSet.contains("DifferentString"));
    }
}
