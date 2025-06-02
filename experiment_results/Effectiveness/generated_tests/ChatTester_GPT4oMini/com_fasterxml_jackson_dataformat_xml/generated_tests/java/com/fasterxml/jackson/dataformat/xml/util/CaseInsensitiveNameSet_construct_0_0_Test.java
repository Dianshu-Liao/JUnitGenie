package com.fasterxml.jackson.dataformat.xml.util;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.*;

public class CaseInsensitiveNameSet_construct_0_0_Test {

    @Test
    public void testConstruct_WithUniqueNames() {
        Set<String> names = new HashSet<>();
        names.add("Alice");
        names.add("Bob");
        CaseInsensitiveNameSet nameSet = CaseInsensitiveNameSet.construct(names);
        assertNotNull(nameSet);
        assertTrue(nameSet.contains("ALICE"));
        assertTrue(nameSet.contains("alice"));
        assertTrue(nameSet.contains("Bob"));
        assertTrue(nameSet.contains("BOB"));
    }

    @Test
    public void testConstruct_WithDuplicateNames() {
        Set<String> names = new HashSet<>();
        names.add("Alice");
        // Duplicate in a case-insensitive manner
        names.add("alice");
        names.add("Bob");
        CaseInsensitiveNameSet nameSet = CaseInsensitiveNameSet.construct(names);
        assertNotNull(nameSet);
        // Should only store unique names
        assertEquals(3, nameSet.size());
    }

    @Test
    public void testConstruct_WithEmptySet() {
        Set<String> names = new HashSet<>();
        CaseInsensitiveNameSet nameSet = CaseInsensitiveNameSet.construct(names);
        assertNotNull(nameSet);
        // Should be empty
        assertEquals(0, nameSet.size());
    }

    @Test
    public void testConstruct_WithNullInput() {
        assertThrows(NullPointerException.class, () -> {
            CaseInsensitiveNameSet.construct(null);
        });
    }
}
