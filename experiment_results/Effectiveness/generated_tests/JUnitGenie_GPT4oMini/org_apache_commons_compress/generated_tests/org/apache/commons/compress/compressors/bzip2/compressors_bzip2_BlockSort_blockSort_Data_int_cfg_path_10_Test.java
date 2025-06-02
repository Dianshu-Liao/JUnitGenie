package org.apache.commons.compress.compressors.bzip2;
import org.apache.commons.compress.compressors.bzip2.BlockSort;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorOutputStream;
import org.junit.Test;
import static org.junit.Assert.*;

public class compressors_bzip2_BlockSort_blockSort_Data_int_cfg_path_10_Test {

    @Test(timeout = 4000)
    public void testBlockSort() {
        // Arrange
        int initialSize = 100; // Assuming a default size for the Data object
        BZip2CompressorOutputStream.Data data = new BZip2CompressorOutputStream.Data(initialSize);
        int last = 9999; // This value is less than 10000 to test the fallbackSort path

        BlockSort blockSort = new BlockSort(data);

        // Act
        try {
            blockSort.blockSort(data, last);
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }

        // Assert
        assertNotEquals(-1, data.origPtr); // Ensure origPtr is set correctly
    }

    @Test(timeout = 4000)
    public void testBlockSortWithMainSort() {
        // Arrange
        int initialSize = 100; // Assuming a default size for the Data object
        BZip2CompressorOutputStream.Data data = new BZip2CompressorOutputStream.Data(initialSize);
        int last = 10000; // This value is equal to 10000 to test the mainSort path

        BlockSort blockSort = new BlockSort(data);

        // Act
        try {
            blockSort.blockSort(data, last);
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }

        // Assert
        assertNotEquals(-1, data.origPtr); // Ensure origPtr is set correctly
    }


}