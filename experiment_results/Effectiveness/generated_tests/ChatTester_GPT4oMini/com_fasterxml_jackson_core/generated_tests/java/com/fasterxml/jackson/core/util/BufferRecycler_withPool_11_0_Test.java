package com.fasterxml.jackson.core.util;

import java.lang.reflect.Field;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReferenceArray;

@ExtendWith(MockitoExtension.class)
public class BufferRecycler_withPool_11_0_Test {

    private BufferRecycler bufferRecycler;

    private RecyclerPool<BufferRecycler> mockPool;

    @BeforeEach
    public void setUp() {
        bufferRecycler = new BufferRecycler();
        // Fixed the instantiation issue
        mockPool = mock(RecyclerPool.class);
    }

    @Test
    public void testWithPool_WhenPoolIsNull_ShouldThrowNullPointerException() {
        assertThrows(NullPointerException.class, () -> {
            bufferRecycler.withPool(null);
        });
    }

    @Test
    public void testWithPool_WhenPoolIsAlreadySet_ShouldThrowIllegalStateException() {
        bufferRecycler.withPool(mockPool);
        assertThrows(IllegalStateException.class, () -> {
            bufferRecycler.withPool(mockPool);
        });
    }

    @Test
    public void testWithPool_WhenPoolIsValid_ShouldAssignPool() {
        BufferRecycler result = bufferRecycler.withPool(mockPool);
        assertEquals(bufferRecycler, result);
        // Using reflection to access the private _pool field
        try {
            Field poolField = BufferRecycler.class.getDeclaredField("_pool");
            poolField.setAccessible(true);
            RecyclerPool<BufferRecycler> assignedPool = (RecyclerPool<BufferRecycler>) poolField.get(bufferRecycler);
            assertEquals(mockPool, assignedPool);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Reflection access failed: " + e.getMessage());
        }
    }
}
