package com.fasterxml.jackson.core.util;
import com.fasterxml.jackson.core.util.BufferRecycler;
import com.fasterxml.jackson.core.util.RecyclerPool;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class util_BufferRecycler_releaseToPool__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testReleaseToPool() {
        // Arrange
        RecyclerPool<BufferRecycler> mockPool = mock(RecyclerPool.class);
        BufferRecycler bufferRecycler = new BufferRecycler();
        
        // Using reflection to set the private field _pool
        try {
            java.lang.reflect.Field field = BufferRecycler.class.getDeclaredField("_pool");
            field.setAccessible(true);
            field.set(bufferRecycler, mockPool);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        // Act
        bufferRecycler.releaseToPool();

        // Assert
        verify(mockPool, times(1)).releasePooled(bufferRecycler);
    }

    @Test(timeout = 4000)
    public void testReleaseToPoolWhenPoolIsNull() {
        // Arrange
        BufferRecycler bufferRecycler = new BufferRecycler();
        
        // Using reflection to set the private field _pool to null
        try {
            java.lang.reflect.Field field = BufferRecycler.class.getDeclaredField("_pool");
            field.setAccessible(true);
            field.set(bufferRecycler, null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        // Act
        bufferRecycler.releaseToPool();

        // Assert
        // No exception should be thrown and no interaction with the pool
        // This is a no-op case, so we don't need to verify anything
    }

}