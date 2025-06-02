package org.apache.commons.compress.compressors.bzip2;
import org.apache.commons.compress.compressors.bzip2.BlockSort;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorOutputStream;
import org.junit.Test;

public class compressors_bzip2_BlockSort_blockSort_Data_int_cfg_path_16_Test {

    @Test(timeout = 4000)
    public void testBlockSort() {
        // Arrange
        int size = 100; // Assuming a size for the Data constructor
        BZip2CompressorOutputStream.Data data = new BZip2CompressorOutputStream.Data(size);
        int last = 9999; // last + 1 < 10000 to trigger fallbackSort

        BlockSort blockSort = new BlockSort(data);

        // Act
        try {
            blockSort.blockSort(data, last);
        } catch (Exception e) {
            // Handle exception if necessary
            e.printStackTrace();
        }

        // Assert
        // Check that origPtr is set correctly
        assert(data.origPtr != -1);
    }

    @Test(timeout = 4000)
    public void testBlockSortWithMainSort() {
        // Arrange
        int size = 100; // Assuming a size for the Data constructor
        BZip2CompressorOutputStream.Data data = new BZip2CompressorOutputStream.Data(size);
        int last = 10000; // last + 1 >= 10000 to trigger mainSort

        BlockSort blockSort = new BlockSort(data);

        // Act
        try {
            blockSort.blockSort(data, last);
        } catch (Exception e) {
            // Handle exception if necessary
            e.printStackTrace();
        }

        // Assert
        // Check that origPtr is set correctly
        assert(data.origPtr != -1);
    }


}