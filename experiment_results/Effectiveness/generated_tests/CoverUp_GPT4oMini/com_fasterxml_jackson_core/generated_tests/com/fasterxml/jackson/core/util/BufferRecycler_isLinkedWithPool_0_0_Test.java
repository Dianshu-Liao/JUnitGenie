package com.fasterxml.jackson.core.util;

import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class BufferRecycler_isLinkedWithPool_0_0_Test {

    private BufferRecycler bufferRecycler;

    private RecyclerPool<BufferRecycler> mockPool;

    @BeforeEach
    void setUp() {
        bufferRecycler = new BufferRecycler();
        mockPool = Mockito.mock(RecyclerPool.class);
    }

    @Test
    void testIsLinkedWithPoolWhenNotLinked() {
        // Test when _pool is null
        assertFalse(invokeIsLinkedWithPool(bufferRecycler));
    }

    @Test
    void testIsLinkedWithPoolWhenLinked() {
        // Link the bufferRecycler with the mockPool
        bufferRecycler.withPool(mockPool);
        // Test when _pool is not null
        assertTrue(invokeIsLinkedWithPool(bufferRecycler));
    }

    private boolean invokeIsLinkedWithPool(BufferRecycler bufferRecycler) {
        try {
            Method method = BufferRecycler.class.getDeclaredMethod("isLinkedWithPool");
            method.setAccessible(true);
            return (boolean) method.invoke(bufferRecycler);
        } catch (Exception e) {
            fail("Reflection invocation failed: " + e.getMessage());
            // This line will never be reached due to fail
            return false;
        }
    }
}
