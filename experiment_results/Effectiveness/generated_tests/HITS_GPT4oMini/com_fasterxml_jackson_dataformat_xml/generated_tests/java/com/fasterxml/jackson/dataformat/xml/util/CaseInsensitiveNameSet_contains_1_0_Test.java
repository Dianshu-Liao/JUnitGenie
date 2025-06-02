package com.fasterxml.jackson.dataformat.xml.util;

import java.lang.reflect.Constructor;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.*;

class CaseInsensitiveNameSet_contains_1_0_Test {

    private CaseInsensitiveNameSet caseInsensitiveNameSet;

    @BeforeEach
    void setUp() throws Exception {
        Set<String> names = new HashSet<>();
        names.add("TestName");
        names.add("AnotherName");
        // Using reflection to access the private constructor
        Constructor<CaseInsensitiveNameSet> constructor = CaseInsensitiveNameSet.class.getDeclaredConstructor(Set.class);
        constructor.setAccessible(true);
        caseInsensitiveNameSet = constructor.newInstance(names);
    }

    @Test
    void testContainsExactMatch() {
        assertTrue(caseInsensitiveNameSet.contains("TestName"));
    }

    @Test
    void testContainsLowerCaseMatch() {
        assertTrue(caseInsensitiveNameSet.contains("testname"));
    }

    @Test
    void testContainsDifferentCaseMatch() {
        assertTrue(caseInsensitiveNameSet.contains("ANOTHERNAME"));
    }

    @Test
    void testContainsNoMatch() {
        assertFalse(caseInsensitiveNameSet.contains("NonExistentName"));
    }

    @Test
    void testContainsNull() {
        assertFalse(caseInsensitiveNameSet.contains(null));
    }
}
