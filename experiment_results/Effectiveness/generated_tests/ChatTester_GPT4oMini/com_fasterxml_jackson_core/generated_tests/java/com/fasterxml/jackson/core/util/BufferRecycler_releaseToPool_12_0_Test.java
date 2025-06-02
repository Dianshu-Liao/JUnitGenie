package com.fasterxml.jackson.core.util;

import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Objects;

public class BufferRecycler_releaseToPool_12_0_Test {

    private BufferRecycler bufferRecycler;

    private RecyclerPool<BufferRecycler> mockPool;

    @BeforeEach
    public void setUp() {
        mockPool = Mockito.mock(RecyclerPool.class);
        bufferRecycler = new BufferRecycler();
        // Use reflection to set the private _pool field
        setPrivateField(bufferRecycler, "_pool", mockPool);
    }

    @Test
    public void testReleaseToPool_WhenPoolIsNotNull() throws Exception {
        bufferRecycler.releaseToPool();
        Mockito.verify(mockPool).releasePooled(bufferRecycler);
        // Check if _pool is nullified
        assertNull(getPrivateField(bufferRecycler, "_pool"));
    }

    @Test
    public void testReleaseToPool_WhenPoolIsNull() throws Exception {
        // Set the pool to null
        setPrivateField(bufferRecycler, "_pool", null);
        // Call the method
        bufferRecycler.releaseToPool();
        // Verify that releasePooled is not called
        Mockito.verify(mockPool, Mockito.never()).releasePooled(Mockito.any());
    }

    // Reflection methods to access private fields
    private void setPrivateField(Object target, String fieldName, Object value) {
        try {
            Field field = target.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(target, value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Object getPrivateField(Object target, String fieldName) {
        try {
            Field field = target.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(target);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
