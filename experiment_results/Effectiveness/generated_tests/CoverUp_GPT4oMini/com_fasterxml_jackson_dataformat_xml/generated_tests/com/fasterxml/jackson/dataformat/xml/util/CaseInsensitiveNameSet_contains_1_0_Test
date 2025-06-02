package com.fasterxml.jackson.dataformat.xml.util;

import java.lang.reflect.Constructor;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.*;

public class CaseInsensitiveNameSet_contains_1_0_Test {

    private CaseInsensitiveNameSet caseInsensitiveNameSet;

    @BeforeEach
    public void setUp() throws Exception {
        Set<String> namesToMatch = new HashSet<>();
        namesToMatch.add("example");
        namesToMatch.add("test");
        Constructor<CaseInsensitiveNameSet> constructor = CaseInsensitiveNameSet.class.getDeclaredConstructor(Set.class);
        constructor.setAccessible(true);
        caseInsensitiveNameSet = constructor.newInstance(namesToMatch);
    }

    @Test
    public void testContainsWithExactMatch() {
        assertTrue(caseInsensitiveNameSet.contains("example"));
    }

    @Test
    public void testContainsWithLowerCaseMatch() {
        assertTrue(caseInsensitiveNameSet.contains("EXAMPLE"));
    }

    @Test
    public void testContainsWithDifferentCase() {
        assertTrue(caseInsensitiveNameSet.contains("TeSt"));
    }

    @Test
    public void testContainsWithNoMatch() {
        assertFalse(caseInsensitiveNameSet.contains("nonexistent"));
    }

    @Test
    public void testContainsWithNull() {
        assertFalse(caseInsensitiveNameSet.contains(null));
    }

    @Test
    public void testContainsWithDifferentType() {
        assertFalse(caseInsensitiveNameSet.contains(123));
    }

    @Test
    public void testContainsWithSameStringReference() {
        String key = "example";
        assertTrue(caseInsensitiveNameSet.contains(key));
    }

    @Test
    public void testContainsWithLowerCaseSameReference() {
        String key = "EXAMPLE".toLowerCase();
        assertTrue(caseInsensitiveNameSet.contains(key));
    }

    @Test
    public void testContainsWithDifferentLowerCaseSameReference() {
        String key = "TeSt".toLowerCase();
        assertTrue(caseInsensitiveNameSet.contains(key));
    }
}
