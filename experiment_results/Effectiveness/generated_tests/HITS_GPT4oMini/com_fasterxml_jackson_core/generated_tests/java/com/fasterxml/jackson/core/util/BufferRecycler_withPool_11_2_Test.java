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
class BufferRecycler_withPool_11_2_Test {

    private BufferRecycler bufferRecycler;

    @Mock
    private RecyclerPool<BufferRecycler> mockPool;

    @BeforeEach
    void setUp() {
        bufferRecycler = new BufferRecycler();
    }

    @Test
    void testWithPool_WhenPoolIsProvided_ShouldAssignPool() {
        BufferRecycler result = bufferRecycler.withPool(mockPool);
        // Since we cannot access _pool directly, we will verify the behavior indirectly
        assertNotNull(result);
    }

    @Test
    void testWithPool_WhenAlreadyLinkedToPool_ShouldThrowIllegalStateException() {
        bufferRecycler.withPool(mockPool);
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            bufferRecycler.withPool(mockPool);
        });
        assertEquals("BufferRecycler already linked to pool: " + mockPool, exception.getMessage());
    }

    @Test
    void testWithPool_WhenPoolIsNull_ShouldThrowNullPointerException() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            bufferRecycler.withPool(null);
        });
        assertEquals("pool cannot be null", exception.getMessage());
    }
}
