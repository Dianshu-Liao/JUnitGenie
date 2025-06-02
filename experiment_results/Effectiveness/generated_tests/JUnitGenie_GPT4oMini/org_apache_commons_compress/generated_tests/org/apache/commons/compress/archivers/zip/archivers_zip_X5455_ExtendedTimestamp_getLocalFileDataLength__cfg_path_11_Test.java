package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp;
import org.apache.commons.compress.archivers.zip.ZipLong;
import org.apache.commons.compress.archivers.zip.ZipShort;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class archivers_zip_X5455_ExtendedTimestamp_getLocalFileDataLength__cfg_path_11_Test {

    @Test(timeout = 4000)
    public void testGetLocalFileDataLength() {
        // Arrange
        X5455_ExtendedTimestamp instance = new X5455_ExtendedTimestamp();
        
        // Use setter methods to set the fields
        instance.setModifyTime(new ZipLong(123456789)); // Corrected to use ZipLong
        instance.setAccessTime(new ZipLong(123456789)); // Not null, adds 4
        instance.setCreateTime(new ZipLong(987654321)); // Not null, adds 4

        // Act
        ZipShort result = instance.getLocalFileDataLength();

        // Assert
        assertEquals(new ZipShort(12), result); // 1 + 4 + 4 + 4 = 12
    }

}