package org.apache.commons.compress.compressors.bzip2;

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
        // Initialize the Data instance with an appropriate size for testing
        data = new BZip2CompressorOutputStream.Data(100);
        blockSort = new BlockSort(data);
    }

    @Test
    void testBlockSortWithSmallData() {
        // Prepare small data scenario
        int last = 5;
        // Directly set the fmap array values
        int[] fmap = new int[] { 4, 3, 2, 1, 0, 5 };
        System.arraycopy(fmap, 0, data.fmap, 0, fmap.length);
        blockSort.blockSort(data, last);
        // Validate the output after sorting
        assertEquals(0, data.origPtr);
    }

    @Test
    void testBlockSortWithLargeData() {
        // Prepare large data scenario
        int last = 20;
        int[] fmap = new int[] { 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 20 };
        System.arraycopy(fmap, 0, data.fmap, 0, fmap.length);
        blockSort.blockSort(data, last);
        // Validate the output after sorting
        assertEquals(0, data.origPtr);
    }

    @Test
    void testBlockSortWithEmptyData() {
        // Prepare empty data scenario
        int last = -1;
        // Directly set the fmap array to empty
        int[] fmap = new int[0];
        System.arraycopy(fmap, 0, data.fmap, 0, fmap.length);
        blockSort.blockSort(data, last);
        // Validate the output
        assertEquals(-1, data.origPtr);
    }

    @Test
    void testBlockSortWithSingleElement() {
        // Prepare single element scenario
        int last = 0;
        // Directly set the fmap array with one element
        int[] fmap = new int[] { 0 };
        System.arraycopy(fmap, 0, data.fmap, 0, fmap.length);
        blockSort.blockSort(data, last);
        // Validate the output
        assertEquals(0, data.origPtr);
    }
}
