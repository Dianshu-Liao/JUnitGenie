package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField;
import org.apache.commons.compress.archivers.zip.ZipShort;
import org.apache.commons.compress.archivers.zip.ZipEightByteInteger;
import org.apache.commons.compress.archivers.zip.ZipLong;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class archivers_zip_Zip64ExtendedInformationExtraField_getCentralDirectoryLength__cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testGetCentralDirectoryLength_diskStartNotNull() {
        ZipEightByteInteger size = new ZipEightByteInteger(0L); // Initialize with a long value
        ZipEightByteInteger compressedSize = new ZipEightByteInteger(0L); // Initialize with a long value
        ZipEightByteInteger relativeHeaderOffset = new ZipEightByteInteger(0L); // Initialize with a long value
        ZipLong diskStart = new ZipLong(1L);

        Zip64ExtendedInformationExtraField zipField = new Zip64ExtendedInformationExtraField(size, compressedSize, relativeHeaderOffset, diskStart);
        
        try {
            ZipShort result = zipField.getCentralDirectoryLength();
            assertNotNull(result);
            // Additional asserts can be placed here to verify the correct value of the result based on the condition
        } catch (Exception e) {
            // Handle exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetCentralDirectoryLength_diskStartNull() {
        ZipEightByteInteger size = new ZipEightByteInteger(0L); // Initialize with a long value
        ZipEightByteInteger compressedSize = new ZipEightByteInteger(0L); // Initialize with a long value
        ZipEightByteInteger relativeHeaderOffset = new ZipEightByteInteger(0L); // Initialize with a long value
        ZipLong diskStart = null;

        Zip64ExtendedInformationExtraField zipField = new Zip64ExtendedInformationExtraField(size, compressedSize, relativeHeaderOffset, diskStart);

        try {
            ZipShort result = zipField.getCentralDirectoryLength();
            assertNotNull(result);
            // Additional asserts can be placed here to verify the correct value of the result based on the condition
        } catch (Exception e) {
            // Handle exception
            e.printStackTrace();
        }
    }


}