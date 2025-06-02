package com.fasterxml.jackson.core.util;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReferenceArray;

class BufferRecycler_withPool_11_0_Test {

    private BufferRecycler bufferRecycler;

    private RecyclerPool<BufferRecycler> mockPool;

    @BeforeEach
    void setUp() {
        bufferRecycler = new BufferRecycler();
        mockPool = Mockito.mock(RecyclerPool.class);
    }

    @Test
    void testWithPool_WhenPoolIsNull_ShouldThrowException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            bufferRecycler.withPool(null);
        });
        assertEquals("pool cannot be null", exception.getMessage());
    }

    @Test
    void testWithPool_WhenPoolIsAlreadySet_ShouldThrowException() {
        bufferRecycler.withPool(mockPool);
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            bufferRecycler.withPool(mockPool);
        });
        assertEquals("BufferRecycler already linked to pool: " + mockPool, exception.getMessage());
    }

    @Test
    void testWithPool_WhenValidPoolIsProvided_ShouldSetPool() {
        BufferRecycler result = bufferRecycler.withPool(mockPool);
        assertSame(bufferRecycler, result);
        // Using reflection to access the private _pool field
        try {
            java.lang.reflect.Field field = BufferRecycler.class.getDeclaredField("_pool");
            field.setAccessible(true);
            RecyclerPool<BufferRecycler> actualPool = (RecyclerPool<BufferRecycler>) field.get(bufferRecycler);
            assertSame(mockPool, actualPool);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Reflection failed: " + e.getMessage());
        }
    }
}
