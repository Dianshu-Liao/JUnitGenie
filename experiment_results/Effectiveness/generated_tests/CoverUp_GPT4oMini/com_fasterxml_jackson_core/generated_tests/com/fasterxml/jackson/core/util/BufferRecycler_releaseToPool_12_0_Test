package com.fasterxml.jackson.core.util;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Objects;

class BufferRecycler_releaseToPool_12_0_Test {

    private BufferRecycler bufferRecycler;

    private RecyclerPool<BufferRecycler> mockPool;

    @BeforeEach
    void setUp() {
        mockPool = Mockito.mock(RecyclerPool.class);
        bufferRecycler = new BufferRecycler();
        // Set the pool using reflection since it's private
        setField(bufferRecycler, "_pool", mockPool);
    }

    @Test
    void testReleaseToPool_WithPool() throws Exception {
        // Arrange
        // Ensure the pool is not null
        assertNotNull(bufferRecycler);
        // Act
        bufferRecycler.releaseToPool();
        // Assert
        verify(mockPool, times(1)).releasePooled(bufferRecycler);
        // Check that the pool reference is nulled
        assertNull(getField(bufferRecycler, "_pool"));
    }

    @Test
    void testReleaseToPool_WithoutPool() throws Exception {
        // Arrange
        // Set pool to null using reflection
        setField(bufferRecycler, "_pool", null);
        // Act
        bufferRecycler.releaseToPool();
        // Assert
        verify(mockPool, never()).releasePooled(any());
        // Check that the pool reference is still null
        assertNull(getField(bufferRecycler, "_pool"));
    }

    // Helper method to set private fields using reflection
    private void setField(Object obj, String fieldName, Object value) {
        try {
            Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(obj, value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Helper method to get private fields using reflection
    private Object getField(Object obj, String fieldName) {
        try {
            Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
