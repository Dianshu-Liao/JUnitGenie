package com.fasterxml.jackson.databind.util.internal;
import com.fasterxml.jackson.databind.util.internal.PrivateMaxEntriesMap;
import com.fasterxml.jackson.databind.util.internal.PrivateMaxEntriesMap.DrainStatus;
import org.junit.Test;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReference;
import static org.mockito.Mockito.*;

public class util_internal_PrivateMaxEntriesMap_drainOnReadIfNeeded_int_long_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testDrainOnReadIfNeeded() {
        // Arrange
        PrivateMaxEntriesMap privateMaxEntriesMap = new PrivateMaxEntriesMap(new PrivateMaxEntriesMap.Builder());
        AtomicLongArray mockReadBufferDrainAtWriteCount = mock(AtomicLongArray.class);
        AtomicReference<DrainStatus> mockDrainStatus = mock(AtomicReference.class);
        DrainStatus mockStatus = mock(DrainStatus.class);

        // Use reflection to set the final fields
        try {
            java.lang.reflect.Field readBufferDrainAtWriteCountField = PrivateMaxEntriesMap.class.getDeclaredField("readBufferDrainAtWriteCount");
            readBufferDrainAtWriteCountField.setAccessible(true);
            readBufferDrainAtWriteCountField.set(privateMaxEntriesMap, mockReadBufferDrainAtWriteCount);

            java.lang.reflect.Field drainStatusField = PrivateMaxEntriesMap.class.getDeclaredField("drainStatus");
            drainStatusField.setAccessible(true);
            drainStatusField.set(privateMaxEntriesMap, mockDrainStatus);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        int bufferIndex = 0;
        long writeCount = 10L;

        // Mock behavior
        when(mockReadBufferDrainAtWriteCount.get(bufferIndex)).thenReturn(5L);
        when(mockDrainStatus.get()).thenReturn(mockStatus);
        when(mockStatus.shouldDrainBuffers(anyBoolean())).thenReturn(true);

        // Act
        try {
            privateMaxEntriesMap.drainOnReadIfNeeded(bufferIndex, writeCount);
        } catch (Exception e) {
            // Handle exception if necessary
        }

        // Assert
        verify(mockReadBufferDrainAtWriteCount).get(bufferIndex);
        verify(mockStatus).shouldDrainBuffers(true);
        verify(privateMaxEntriesMap).tryToDrainBuffers();
    }


}