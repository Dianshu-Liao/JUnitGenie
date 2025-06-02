package org.apache.commons.compress.compressors.bzip2;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.BitSet;

class BlockSort_blockSort_2_0_Test {

    private BlockSort blockSort;

    private BZip2CompressorOutputStream.Data data;

    @BeforeEach
    void setUp() {
        data = new BZip2CompressorOutputStream.Data();
        blockSort = new BlockSort(data);
    }

    @Test
    void testBlockSort_withFallbackSort() throws Exception {
        // Given
        // last + 1 < 10000
        data.fmap = new int[9999];
        for (int i = 0; i < data.fmap.length; i++) {
            // Populate with some values
            data.fmap[i] = i;
        }
        // When
        invokeBlockSort(9998);
        // Then
        // Expect origPtr to remain -1
        assertEquals(-1, data.origPtr);
    }

    @Test
    void testBlockSort_withMainSort() throws Exception {
        // Given
        // last + 1 >= 10000
        data.fmap = new int[10000];
        for (int i = 0; i < data.fmap.length; i++) {
            // Populate with some values
            data.fmap[i] = i;
        }
        // When
        invokeBlockSort(9999);
        // Then
        // Expect origPtr to be set
        assertNotEquals(-1, data.origPtr);
    }

    @Test
    void testBlockSort_withFirstAttemptAndExceededWorkLimit() throws Exception {
        // Given
        // last + 1 >= 10000
        data.fmap = new int[10000];
        for (int i = 0; i < data.fmap.length; i++) {
            // Populate with some values
            data.fmap[i] = i;
        }
        // Simulate workDone exceeding workLimit
        setPrivateField("workDone", 1001);
        setPrivateField("workLimit", 1000);
        // When
        invokeBlockSort(9999);
        // Then
        // Expect origPtr to be set
        assertNotEquals(-1, data.origPtr);
    }

    private void invokeBlockSort(int last) throws Exception {
        Method method = BlockSort.class.getDeclaredMethod("blockSort", BZip2CompressorOutputStream.Data.class, int.class);
        method.setAccessible(true);
        method.invoke(blockSort, data, last);
    }

    private void setPrivateField(String fieldName, int value) throws Exception {
        Field field = BlockSort.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.setInt(blockSort, value);
    }
}

class BZip2CompressorOutputStream {

    static class Data {

        int[] fmap;

        int origPtr;
    }
}
