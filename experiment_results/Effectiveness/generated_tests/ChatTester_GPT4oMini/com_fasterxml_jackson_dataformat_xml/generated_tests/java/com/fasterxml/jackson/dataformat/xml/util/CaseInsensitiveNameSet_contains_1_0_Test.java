package com.fasterxml.jackson.dataformat.xml.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class CaseInsensitiveNameSet_contains_1_0_Test {

    private CaseInsensitiveNameSet caseInsensitiveNameSet;

    @BeforeEach
    void setUp() throws Exception {
        Set<String> namesToMatch = new HashSet<>();
        namesToMatch.add("example");
        namesToMatch.add("test");
        namesToMatch.add("sample");
        // Using reflection to access the private constructor
        Constructor<CaseInsensitiveNameSet> constructor = CaseInsensitiveNameSet.class.getDeclaredConstructor(Set.class);
        constructor.setAccessible(true);
        caseInsensitiveNameSet = constructor.newInstance(namesToMatch);
    }

    @Test
    void testContainsExactMatch() {
        assertTrue(caseInsensitiveNameSet.contains("example"));
        assertTrue(caseInsensitiveNameSet.contains("test"));
        assertTrue(caseInsensitiveNameSet.contains("sample"));
    }

    @Test
    void testContainsCaseInsensitiveMatch() {
        assertTrue(caseInsensitiveNameSet.contains("EXAMPLE"));
        assertTrue(caseInsensitiveNameSet.contains("Test"));
        assertTrue(caseInsensitiveNameSet.contains("Sample"));
    }

    @Test
    void testContainsNoMatch() {
        assertFalse(caseInsensitiveNameSet.contains("nonexistent"));
        assertFalse(caseInsensitiveNameSet.contains("anotherTest"));
    }

    @Test
    void testContainsNull() {
        assertFalse(caseInsensitiveNameSet.contains(null));
    }

    @Test
    void testContainsDifferentType() {
        // Testing with an integer
        assertFalse(caseInsensitiveNameSet.contains(123));
        // Testing with a different object
        assertFalse(caseInsensitiveNameSet.contains(new Object()));
    }

    @Test
    void testContainsEmptyString() {
        assertFalse(caseInsensitiveNameSet.contains(""));
    }

    @Test
    void testContainsSameLowerCaseReference() {
        String key = "example";
        assertTrue(caseInsensitiveNameSet.contains(key));
        // Should not trigger the lower case check
        assertFalse(caseInsensitiveNameSet.contains(key.toLowerCase()));
    }

    // Reflection test for private methods if needed
    private boolean invokePrivateContains(Object key) throws Exception {
        Method method = CaseInsensitiveNameSet.class.getDeclaredMethod("contains", Object.class);
        method.setAccessible(true);
        return (boolean) method.invoke(caseInsensitiveNameSet, key);
    }
}
