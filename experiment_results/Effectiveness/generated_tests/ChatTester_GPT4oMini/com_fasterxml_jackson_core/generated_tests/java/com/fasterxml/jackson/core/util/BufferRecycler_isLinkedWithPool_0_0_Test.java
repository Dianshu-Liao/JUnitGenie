// Test method
package com.fasterxml.jackson.core.util;

import java.lang.reflect.Field;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class BufferRecycler_isLinkedWithPool_0_0_Test {

    private BufferRecycler bufferRecycler;

    @BeforeEach
    public void setUp() {
        bufferRecycler = new BufferRecycler();
    }

    @Test
    public void testIsLinkedWithPool_WhenPoolIsNull_ShouldReturnFalse() {
        // Arrange
        // No action needed, _pool is null by default
        // Act
        boolean result = bufferRecycler.isLinkedWithPool();
        // Assert
        assertFalse(result, "Expected isLinkedWithPool() to return false when _pool is null");
    }

    @Test
    public void testIsLinkedWithPool_WhenPoolIsNotNull_ShouldReturnTrue() throws Exception {
        // Arrange
        // Use reflection to set the _pool field to a non-null value
        setPrivateField(bufferRecycler, "_pool", new RecyclerPool<>());
        // Act
        boolean result = bufferRecycler.isLinkedWithPool();
        // Assert
        assertTrue(result, "Expected isLinkedWithPool() to return true when _pool is not null");
    }

    private void setPrivateField(Object target, String fieldName, Object value) throws Exception {
        // Fixed line
        Field field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(target, value);
    }

    // Mock class for RecyclerPool to use in the test
    private static class RecyclerPool<T> {
        // Implementation details for the mock class can be added here if needed
    }
}
