package com.fasterxml.jackson.core.util;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

class InternCache_intern_0_0_Test {

    private InternCache internCache;

    // Mirroring the private DEFAULT_MAX_ENTRIES
    private static final int MAX_ENTRIES = 280;

    @BeforeEach
    void setUp() {
        internCache = InternCache.instance;
    }

    @Test
    void testIntern_NewString() {
        String input = "newString";
        String result = internCache.intern(input);
        assertSame(result, input.intern(), "The interned string should match the expected interned result.");
    }

    @Test
    void testIntern_ExistingString() {
        String input = "existingString";
        // Intern the string first
        internCache.intern(input);
        // Intern the same string again
        String result = internCache.intern(input);
        assertSame(result, input.intern(), "The interned string should match the expected interned result.");
    }

    @Test
    void testIntern_MaxEntriesExceeded() {
        // Fill the cache to max entries
        for (int i = 0; i < MAX_ENTRIES; i++) {
            internCache.intern("string" + i);
        }
        // Intern a new string to trigger the clearing mechanism
        String newInput = "newStringAfterMax";
        String result = internCache.intern(newInput);
        assertSame(result, newInput.intern(), "The interned string should match the expected interned result after max entries exceeded.");
    }

    @Test
    void testIntern_ClearingCache() {
        // Fill the cache to max entries
        for (int i = 0; i < MAX_ENTRIES; i++) {
            internCache.intern("string" + i);
        }
        // Intern a new string to trigger the clearing mechanism
        String newInput1 = "newString1";
        String newInput2 = "newString2";
        String result1 = internCache.intern(newInput1);
        String result2 = internCache.intern(newInput2);
        assertSame(result1, newInput1.intern(), "The interned string should match the expected interned result.");
        assertSame(result2, newInput2.intern(), "The interned string should match the expected interned result.");
    }

    @Test
    void testIntern_NullInput() {
        String result = internCache.intern(null);
        assertNull(result, "The result should be null when input is null.");
    }
}
