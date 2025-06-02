package com.fasterxml.jackson.core.util;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.OutputStream;
import java.util.*;

public class ByteArrayBuilder__allocMore_22_0_Test {

    private ByteArrayBuilder byteArrayBuilder;

    @BeforeEach
    public void setUp() {
        byteArrayBuilder = new ByteArrayBuilder(new BufferRecycler(), 500);
    }

    @Test
    public void testAllocMoreIncreasesPastLen() {
        // Arrange
        byte[] initialBlock = byteArrayBuilder.getCurrentSegment();
        byteArrayBuilder.setCurrentSegmentLength(initialBlock.length);
        // Act
        try {
            invokePrivateAllocMore(byteArrayBuilder);
        } catch (Exception e) {
            fail("Invocation of _allocMore() failed: " + e.getMessage());
        }
        // Assert
        assertEquals(initialBlock.length + byteArrayBuilder.getCurrentSegment().length, byteArrayBuilder.getCurrentSegmentLength());
    }

    @Test
    public void testAllocMoreThrowsExceptionWhenExceedingMaxArraySize() {
        // Arrange
        byte[] largeBlock = new byte[Integer.MAX_VALUE - 1];
        byteArrayBuilder.setCurrentSegmentLength(largeBlock.length);
        try {
            invokePrivateAllocMore(byteArrayBuilder);
        } catch (Exception e) {
            // Ignore exception for the first call
        }
        // Act & Assert
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            invokePrivateAllocMore(byteArrayBuilder);
        });
        String expectedMessage = "Maximum Java array size (2GB) exceeded by `ByteArrayBuilder`";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    private void invokePrivateAllocMore(ByteArrayBuilder byteArrayBuilder) throws Exception {
        Method method = ByteArrayBuilder.class.getDeclaredMethod("_allocMore");
        method.setAccessible(true);
        method.invoke(byteArrayBuilder);
    }
}
