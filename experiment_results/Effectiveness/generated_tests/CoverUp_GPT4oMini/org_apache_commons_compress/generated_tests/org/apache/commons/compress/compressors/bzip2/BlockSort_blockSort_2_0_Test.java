package org.apache.commons.compress.compressors.bzip2;

import org.apache.commons.compress.compressors.bzip2.BlockSort;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorOutputStream;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.BitSet;

class BlockSort_blockSort_2_0_Test {

    private BlockSort blockSort;

    private BZip2CompressorOutputStream.Data data;

    @BeforeEach
    void setUp() {
        // Mocking data with necessary attributes
        // Assuming the constructor takes an int for size
        data = new BZip2CompressorOutputStream.Data(100);
        blockSort = new BlockSort(data);
    }

    @Test
    void testBlockSortWithFallback() throws Exception {
        // Test case where last < 10000
        int last = 9999;
        blockSort.blockSort(data, last);
        // Verify that origPtr is set correctly
        assertEquals(0, data.origPtr);
    }

    @Test
    void testBlockSortWithMainSort() throws Exception {
        // Test case where last >= 10000
        int last = 10000;
        blockSort.blockSort(data, last);
        // Verify that origPtr is set correctly
        assertEquals(0, data.origPtr);
    }

    @Test
    void testBlockSortFirstAttemptFallback() throws Exception {
        // Test case to ensure fallback is called when workDone exceeds workLimit
        int last = 10000;
        // Simulate work done exceeding the limit
        setPrivateField(blockSort, "workDone", 1001);
        setPrivateField(blockSort, "workLimit", 1000);
        blockSort.blockSort(data, last);
        // Verify that origPtr is set correctly
        assertEquals(0, data.origPtr);
    }

    private void setPrivateField(Object obj, String fieldName, Object value) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }

    @Test
    void testBlockSortWithEmptyFmap() throws Exception {
        // Test case where fmap is empty
        int last = 0;
        // Empty fmap
        // Using reflection to set the final variable
        setPrivateField(data, "fmap", new int[] { 0 });
        blockSort.blockSort(data, last);
        // Verify that origPtr is set correctly
        assertEquals(0, data.origPtr);
    }
}
