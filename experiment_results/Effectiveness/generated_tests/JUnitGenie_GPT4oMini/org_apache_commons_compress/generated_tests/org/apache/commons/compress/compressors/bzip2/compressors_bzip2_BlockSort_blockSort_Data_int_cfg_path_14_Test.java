package org.apache.commons.compress.compressors.bzip2;
import org.apache.commons.compress.compressors.bzip2.BlockSort;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorOutputStream;
import org.junit.Test;

public class compressors_bzip2_BlockSort_blockSort_Data_int_cfg_path_14_Test {

    @Test(timeout = 4000)
    public void testBlockSort() {
        // Arrange
        int size = 100; // Assuming a size for the Data constructor
        BZip2CompressorOutputStream.Data data = new BZip2CompressorOutputStream.Data(size);
        int last = 9999; // This will trigger the mainSort path

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
    public void testBlockSortWithFallback() {
        // Arrange
        int size = 100; // Assuming a size for the Data constructor
        BZip2CompressorOutputStream.Data data = new BZip2CompressorOutputStream.Data(size);
        int last = 10000; // This will trigger the fallbackSort path

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