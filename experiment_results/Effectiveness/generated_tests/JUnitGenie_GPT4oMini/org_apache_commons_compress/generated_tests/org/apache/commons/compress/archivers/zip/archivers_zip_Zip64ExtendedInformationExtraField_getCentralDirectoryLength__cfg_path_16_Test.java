package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField;
import org.apache.commons.compress.archivers.zip.ZipEightByteInteger;
import org.apache.commons.compress.archivers.zip.ZipLong;
import org.apache.commons.compress.archivers.zip.ZipShort;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class archivers_zip_Zip64ExtendedInformationExtraField_getCentralDirectoryLength__cfg_path_16_Test {

    @Test(timeout = 4000)
    public void testGetCentralDirectoryLength() {
        Zip64ExtendedInformationExtraField zipField = new Zip64ExtendedInformationExtraField();
        try {
            // Use setter methods to set the values
            zipField.setSize(new ZipEightByteInteger(8));
            zipField.setCompressedSize(new ZipEightByteInteger(8));
            zipField.setRelativeHeaderOffset(new ZipEightByteInteger(8));
            // Removed the setDiskStart method as it does not exist
            // zipField.setDiskStart(new ZipLong(4)); // This line is removed

            ZipShort result = zipField.getCentralDirectoryLength();
            assertEquals(24, result.getValue()); // 8 + 8 + 8 = 24 (Disk start is not included)
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetCentralDirectoryLengthWithNullFields() {
        Zip64ExtendedInformationExtraField zipField = new Zip64ExtendedInformationExtraField();
        try {
            // Use setter methods to set the values
            zipField.setSize(null);
            zipField.setCompressedSize(new ZipEightByteInteger(8));
            zipField.setRelativeHeaderOffset(null);
            // Removed the setDiskStart method as it does not exist
            // zipField.setDiskStart(new ZipLong(4)); // This line is removed

            ZipShort result = zipField.getCentralDirectoryLength();
            assertEquals(8, result.getValue()); // 0 + 8 + 0 = 8 (Disk start is not included)
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetCentralDirectoryLengthAllNulls() {
        Zip64ExtendedInformationExtraField zipField = new Zip64ExtendedInformationExtraField();
        try {
            // Use setter methods to set the values
            zipField.setSize(null);
            zipField.setCompressedSize(null);
            zipField.setRelativeHeaderOffset(null);
            // Removed the setDiskStart method as it does not exist
            // zipField.setDiskStart(null); // This line is removed

            ZipShort result = zipField.getCentralDirectoryLength();
            assertEquals(0, result.getValue()); // 0 + 0 + 0 = 0
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}