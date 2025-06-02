package com.fasterxml.jackson.core.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.ref.SoftReference;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.io.JsonStringEncoder;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class BufferRecyclers_getBufferRecycler_0_0_Test {

    private BufferRecyclers bufferRecyclers;

    @BeforeEach
    void setUp() {
        bufferRecyclers = new BufferRecyclers();
        // Reset the static ThreadLocal variable to ensure a clean state before each test
        clearThreadLocalReferences();
    }

    private void clearThreadLocalReferences() {
        try {
            Method method = BufferRecyclers.class.getDeclaredMethod("clear");
            method.setAccessible(true);
            method.invoke(null);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test
    void testGetBufferRecycler_NewInstance() {
        BufferRecycler recycler = BufferRecyclers.getBufferRecycler();
        assertNotNull(recycler, "BufferRecycler should not be null");
    }

    @Test
    void testGetBufferRecycler_ReuseInstance() {
        BufferRecycler firstCall = BufferRecyclers.getBufferRecycler();
        BufferRecycler secondCall = BufferRecyclers.getBufferRecycler();
        assertSame(firstCall, secondCall, "Subsequent calls should return the same BufferRecycler instance");
    }

    @Test
    void testGetBufferRecycler_WithThreadLocalBufferManager() throws Exception {
        // Use reflection to set the _bufferRecyclerTracker to a mocked instance
        ThreadLocalBufferManager mockedManager = mock(ThreadLocalBufferManager.class);
        setBufferRecyclerTracker(mockedManager);
        BufferRecycler recycler = BufferRecyclers.getBufferRecycler();
        assertNotNull(recycler, "BufferRecycler should not be null");
        // Verify that wrapAndTrack was called
        verify(mockedManager).wrapAndTrack(recycler);
    }

    private void setBufferRecyclerTracker(ThreadLocalBufferManager manager) throws Exception {
        Field field = BufferRecyclers.class.getDeclaredField("_bufferRecyclerTracker");
        field.setAccessible(true);
        field.set(null, manager);
    }
}
