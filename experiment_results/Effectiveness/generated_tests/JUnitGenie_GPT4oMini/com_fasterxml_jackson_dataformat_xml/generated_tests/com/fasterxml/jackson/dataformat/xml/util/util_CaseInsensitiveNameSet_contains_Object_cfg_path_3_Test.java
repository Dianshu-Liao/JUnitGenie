package com.fasterxml.jackson.dataformat.xml.util;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import java.util.HashSet;
import java.util.Set;

public class util_CaseInsensitiveNameSet_contains_Object_cfg_path_3_Test {

    private CaseInsensitiveNameSet caseInsensitiveNameSet;

    @Before
    public void setUp() throws Exception {
        // Using reflection to access the private constructor
        Set<String> names = new HashSet<>();
        names.add("Key1");
        names.add("key2");
        caseInsensitiveNameSet = CaseInsensitiveNameSet.class
            .getDeclaredConstructor(Set.class)
            .newInstance(names);
    }

    @Test(timeout = 4000)
    public void testContainsKeyFound() {
        // Test for case sensitivity
        assertTrue(caseInsensitiveNameSet.contains("Key1")); // Should be true
    }

    @Test(timeout = 4000)
    public void testContainsLowercaseKeyFound() {
        // Test for case insensitive match
        assertTrue(caseInsensitiveNameSet.contains("key2")); // Should be true
    }

    @Test(timeout = 4000)
    public void testContainsKeyNotFound() {
        // Test for a key that does not exist
        assertFalse(caseInsensitiveNameSet.contains("KeyNotFound")); // Should be false
    }

    @Test(timeout = 4000)
    public void testContainsSameCaseKeyFound() {
        // Test for a key with the same case
        assertFalse(caseInsensitiveNameSet.contains("key1")); // Should be false when no match is found
    }

}