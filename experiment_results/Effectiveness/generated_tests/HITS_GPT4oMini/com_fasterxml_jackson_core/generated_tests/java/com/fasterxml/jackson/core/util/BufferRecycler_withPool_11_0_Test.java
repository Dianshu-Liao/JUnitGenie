package com.fasterxml.jackson.core.util;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReferenceArray;

@ExtendWith(MockitoExtension.class)
class BufferRecycler_withPool_11_0_Test {

    private BufferRecycler bufferRecycler;

    private RecyclerPool<BufferRecycler> mockPool;

    @BeforeEach
    void setUp() {
        bufferRecycler = new BufferRecycler();
        // Create a mock instance of RecyclerPool
        mockPool = Mockito.mock(RecyclerPool.class);
    }

    @Test
    void testWithPool_NullPool() {
        assertThrows(NullPointerException.class, () -> {
            bufferRecycler.withPool(null);
        });
    }

    @Test
    void testWithPool_AlreadyLinkedToPool() {
        bufferRecycler.withPool(mockPool);
        assertThrows(IllegalStateException.class, () -> {
            bufferRecycler.withPool(mockPool);
        });
    }

    @Test
    void testWithPool_ValidPool() {
        BufferRecycler result = bufferRecycler.withPool(mockPool);
        assertSame(bufferRecycler, result);
    }
}
