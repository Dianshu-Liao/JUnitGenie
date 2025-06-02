package com.fasterxml.jackson.core.util;

import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.OutputStream;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class ByteArrayBuilder__allocMore_22_1_Test {

    private ByteArrayBuilder byteArrayBuilder;

    private BufferRecycler bufferRecycler;

    @BeforeEach
    public void setUp() {
        bufferRecycler = new BufferRecycler();
        byteArrayBuilder = new ByteArrayBuilder(bufferRecycler);
    }

    @Test
    public void testAllocMoreUnderLimit() throws Exception {
        // Set up the initial state
        byte[] initialBlock = new byte[500];
        byteArrayBuilder.setCurrentSegmentLength(initialBlock.length);
        // Invoke the private method _allocMore()
        invokePrivateMethod("_allocMore");
        // Validate the state after allocation
        assertNotNull(byteArrayBuilder.getCurrentSegment());
        // 500 * 2
        assertEquals(1000, byteArrayBuilder.getCurrentSegment().length);
    }

    @Test
    public void testAllocMoreAtMaxSize() throws Exception {
        // Set up the initial state
        byteArrayBuilder.setCurrentSegmentLength(32768);
        invokePrivateMethod("_allocMore");
        // Validate that the current block size does not exceed the max size
        assertEquals(32768, byteArrayBuilder.getCurrentSegment().length);
    }

    @Test
    public void testAllocMoreExceedsMaxArraySize() {
        // Set up the initial state to cause the exception
        try {
            for (int i = 0; i < 10; i++) {
                byteArrayBuilder.setCurrentSegmentLength(32768);
                invokePrivateMethod("_allocMore");
            }
            fail("Expected IllegalStateException not thrown");
        } catch (IllegalStateException e) {
            assertEquals("Maximum Java array size (2GB) exceeded by `ByteArrayBuilder`", e.getMessage());
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }

    private void invokePrivateMethod(String methodName) throws Exception {
        Method method = ByteArrayBuilder.class.getDeclaredMethod(methodName);
        method.setAccessible(true);
        method.invoke(byteArrayBuilder);
    }
}
