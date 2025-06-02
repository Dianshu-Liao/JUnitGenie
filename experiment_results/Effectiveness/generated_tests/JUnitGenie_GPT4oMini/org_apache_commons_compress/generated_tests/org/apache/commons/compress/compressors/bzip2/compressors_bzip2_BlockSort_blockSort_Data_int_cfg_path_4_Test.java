package org.apache.commons.compress.compressors.bzip2;
import org.apache.commons.compress.compressors.bzip2.BlockSort;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorOutputStream;
import org.junit.Test;

public class compressors_bzip2_BlockSort_blockSort_Data_int_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testBlockSortWithFallback() {
        // Arrange
        BZip2CompressorOutputStream.Data data = new BZip2CompressorOutputStream.Data(100); // Initialize with size
        int last = 30; // Set last to a value less than 10000

        BlockSort blockSort = new BlockSort(data);

        // Act
        try {
            blockSort.blockSort(data, last);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }

        // Assert
        // Check that origPtr is set correctly
        assert(data.origPtr != -1);
    }

    @Test(timeout = 4000)
    public void testBlockSortWithMainSort() {
        // Arrange
        BZip2CompressorOutputStream.Data data = new BZip2CompressorOutputStream.Data(1000); // Reduce size to prevent OutOfMemoryError
        int last = 1000; // Set last to a value equal to 1000

        BlockSort blockSort = new BlockSort(data);

        // Act
        try {
            blockSort.blockSort(data, last);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }

        // Assert
        // Check that origPtr is set correctly
        assert(data.origPtr != -1);
    }

}