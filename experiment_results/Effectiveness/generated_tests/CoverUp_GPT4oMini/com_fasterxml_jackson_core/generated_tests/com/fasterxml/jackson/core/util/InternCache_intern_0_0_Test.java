package com.fasterxml.jackson.core.util;

import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.concurrent.locks.ReentrantLock;

public class InternCache_intern_0_0_Test {

    private InternCache internCache;

    @BeforeEach
    public void setUp() {
        internCache = InternCache.instance;
    }

    @Test
    public void testIntern_NewString() {
        String input = "newString";
        String result = internCache.intern(input);
        assertSame(input, result);
    }

    @Test
    public void testIntern_ExistingString() {
        String input = "existingString";
        internCache.intern(input);
        String result = internCache.intern(input);
        assertSame(input, result);
    }

    @Test
    public void testIntern_ExceedsMaxEntries() throws Exception {
        // Use reflection to access private methods
        Method putMethod = InternCache.class.getDeclaredMethod("put", String.class, String.class);
        putMethod.setAccessible(true);
        // Fill cache to exceed max entries
        for (int i = 0; i < 300; i++) {
            putMethod.invoke(internCache, "string" + i, "string" + i);
        }
        // Now intern a new string and check if it works
        String input = "newStringAfterClear";
        String result = internCache.intern(input);
        assertSame(input, result);
    }

    @Test
    public void testIntern_ConcurrentAccess() throws InterruptedException {
        Runnable task = () -> {
            for (int i = 0; i < 100; i++) {
                internCache.intern("concurrentString" + i);
            }
        };
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        // Verify that the strings are interned correctly
        for (int i = 0; i < 100; i++) {
            String input = "concurrentString" + i;
            String result = internCache.intern(input);
            assertSame(input, result);
        }
    }
}
