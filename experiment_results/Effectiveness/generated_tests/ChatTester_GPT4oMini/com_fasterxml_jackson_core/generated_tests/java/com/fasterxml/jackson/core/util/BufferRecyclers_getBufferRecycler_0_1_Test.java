package com.fasterxml.jackson.core.util;

import java.lang.reflect.Method;
import java.lang.ref.SoftReference;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.io.JsonStringEncoder;

public class BufferRecyclers_getBufferRecycler_0_1_Test {

    private BufferRecyclers bufferRecyclers;

    @BeforeEach
    public void setUp() {
        bufferRecyclers = new BufferRecyclers();
    }

    @Test
    public void testGetBufferRecycler_NewInstance() throws Exception {
        // Clear the ThreadLocal reference before the test
        clearThreadLocalReference();
        BufferRecycler result = invokeGetBufferRecycler();
        assertNotNull(result, "Expected a new BufferRecycler instance");
    }

    @Test
    public void testGetBufferRecycler_ReusableInstance() throws Exception {
        // First call to create and store a BufferRecycler
        BufferRecycler firstCall = invokeGetBufferRecycler();
        // Clear the ThreadLocal reference to simulate reuse
        clearThreadLocalReference();
        // Second call should return the same instance
        BufferRecycler secondCall = invokeGetBufferRecycler();
        assertSame(firstCall, secondCall, "Expected the same BufferRecycler instance");
    }

    private BufferRecycler invokeGetBufferRecycler() throws Exception {
        Method method = BufferRecyclers.class.getDeclaredMethod("getBufferRecycler");
        method.setAccessible(true);
        return (BufferRecycler) method.invoke(null);
    }

    private void clearThreadLocalReference() throws Exception {
        Method method = ThreadLocal.class.getDeclaredMethod("set", Object.class);
        method.setAccessible(true);
        method.invoke(BufferRecyclers._recyclerRef, null);
    }
}
