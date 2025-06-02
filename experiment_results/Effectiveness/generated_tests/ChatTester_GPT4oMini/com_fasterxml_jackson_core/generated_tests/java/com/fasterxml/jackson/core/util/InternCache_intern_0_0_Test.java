package com.fasterxml.jackson.core.util;

import java.lang.reflect.Method;
import java.util.concurrent.locks.ReentrantLock;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.concurrent.ConcurrentHashMap;

class InternCache_intern_0_0_Test {

    private InternCache internCache;

    @BeforeEach
    void setUp() {
        internCache = InternCache.instance;
    }

    @Test
    void testIntern_WhenInputIsNull_ShouldReturnNull() {
        String result = internCache.intern(null);
        assertNull(result);
    }

    @Test
    void testIntern_WhenInputIsEmpty_ShouldReturnInternedEmptyString() {
        String input = "";
        String result = internCache.intern(input);
        assertSame(result, input);
    }

    @Test
    void testIntern_WhenInputIsNewString_ShouldInternAndStore() {
        String input = "newString";
        String result = internCache.intern(input);
        assertSame(result, input.intern());
    }

    @Test
    void testIntern_WhenCacheIsFull_ShouldClearCacheAndInternNewString() {
        // Simulate filling the cache to the limit
        for (int i = 0; i < 280; i++) {
            internCache.intern("string" + i);
        }
        // Now intern a new string, which should trigger a cache clear
        String newInput = "newString";
        String result = internCache.intern(newInput);
        assertSame(result, newInput.intern());
    }

    @Test
    void testIntern_WhenExistingString_ShouldReturnExistingInternedString() {
        String input = "existingString";
        // Intern the string first
        internCache.intern(input);
        // Intern again
        String result = internCache.intern(input);
        // Should return the same interned instance
        assertSame(result, input.intern());
    }

    @Test
    void testIntern_LockMechanism_ShouldAllowConcurrentInterning() throws Exception {
        // Use reflection to access and invoke the private methods
        Method clearMethod = InternCache.class.getDeclaredMethod("clear");
        clearMethod.setAccessible(true);
        // Simulate concurrent access
        new Thread(() -> {
            try {
                internCache.intern("threadString1");
                // Clear from another thread
                clearMethod.invoke(internCache);
            } catch (Exception e) {
                fail("Thread execution failed");
            }
        }).start();
        String result = internCache.intern("threadString2");
        assertSame(result, "threadString2".intern());
    }

    @Test
    void testIntern_WhenCacheIsCleared_ShouldInternNewString() {
        // Fill the cache to the limit
        for (int i = 0; i < 280; i++) {
            internCache.intern("string" + i);
        }
        // Intern a new string to trigger cache clear
        String newInput = "newInternedString";
        String result = internCache.intern(newInput);
        // Assert that the new string is interned correctly
        assertSame(result, newInput.intern());
    }
}
