package com.fasterxml.jackson.databind.util.internal;
import com.fasterxml.jackson.databind.util.internal.PrivateMaxEntriesMap;
import com.fasterxml.jackson.databind.util.internal.PrivateMaxEntriesMap.DrainStatus;
import org.junit.Test;
import org.junit.Before;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReference;
import static org.mockito.Mockito.*;

public class util_internal_PrivateMaxEntriesMap_drainOnReadIfNeeded_int_long_cfg_path_4_Test {
    private PrivateMaxEntriesMap privateMaxEntriesMap;
    private AtomicLongArray readBufferDrainAtWriteCount;
    private AtomicReference<DrainStatus> drainStatus;

    @Before
    public void setUp() {
        drainStatus = mock(AtomicReference.class);
        readBufferDrainAtWriteCount = new AtomicLongArray(1);
        privateMaxEntriesMap = new PrivateMaxEntriesMap(new PrivateMaxEntriesMap.Builder());
        // Set the final fields using reflection
        setFinalField(privateMaxEntriesMap, "drainStatus", drainStatus);
        setFinalField(privateMaxEntriesMap, "readBufferDrainAtWriteCount", readBufferDrainAtWriteCount);
    }

    @Test(timeout = 4000)
    public void testDrainOnReadIfNeeded_DrainBuffersCalled() {
        int bufferIndex = 0;
        long writeCount = 10L;
        long initialValue = 5L;

        // Set up the mock behavior
        when(drainStatus.get()).thenReturn(mock(DrainStatus.class));
        when(drainStatus.get().shouldDrainBuffers(true)).thenReturn(true);
        readBufferDrainAtWriteCount.set(bufferIndex, initialValue);

        // Call the method under test
        privateMaxEntriesMap.drainOnReadIfNeeded(bufferIndex, writeCount);

        // Verify that tryToDrainBuffers was called
        verify(privateMaxEntriesMap, times(1)).tryToDrainBuffers();
    }

    @Test(timeout = 4000)
    public void testDrainOnReadIfNeeded_DrainBuffersNotCalled() {
        int bufferIndex = 0;
        long writeCount = 10L;
        long initialValue = 8L;

        // Set up the mock behavior
        when(drainStatus.get()).thenReturn(mock(DrainStatus.class));
        when(drainStatus.get().shouldDrainBuffers(false)).thenReturn(false);
        readBufferDrainAtWriteCount.set(bufferIndex, initialValue);

        // Call the method under test
        privateMaxEntriesMap.drainOnReadIfNeeded(bufferIndex, writeCount);

        // Verify that tryToDrainBuffers was not called
        verify(privateMaxEntriesMap, never()).tryToDrainBuffers();
    }

    private void setFinalField(Object target, String fieldName, Object value) {
        try {
            java.lang.reflect.Field field = target.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(target, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}