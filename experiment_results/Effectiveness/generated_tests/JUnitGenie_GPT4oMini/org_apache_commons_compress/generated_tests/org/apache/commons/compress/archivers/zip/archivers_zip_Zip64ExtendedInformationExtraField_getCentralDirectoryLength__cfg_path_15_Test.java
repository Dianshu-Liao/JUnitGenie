package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField;
import org.apache.commons.compress.archivers.zip.ZipShort;
import org.apache.commons.compress.archivers.zip.ZipEightByteInteger;
import org.apache.commons.compress.archivers.zip.ZipLong;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class archivers_zip_Zip64ExtendedInformationExtraField_getCentralDirectoryLength__cfg_path_15_Test {

    @Test(timeout = 4000)
    public void testGetCentralDirectoryLength_AllPropertiesNull() {
        Zip64ExtendedInformationExtraField zipField = new Zip64ExtendedInformationExtraField();
        try {
            ZipShort result = zipField.getCentralDirectoryLength();
            assertEquals(0, result.getValue()); // Expecting 0 since all properties are null
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetCentralDirectoryLength_SomePropertiesSet() {
        ZipEightByteInteger size = new ZipEightByteInteger(8);
        ZipEightByteInteger compressedSize = new ZipEightByteInteger(8);
        ZipEightByteInteger relativeHeaderOffset = new ZipEightByteInteger(8);
        ZipLong diskStart = new ZipLong(0);

        Zip64ExtendedInformationExtraField zipField = new Zip64ExtendedInformationExtraField(size, compressedSize, relativeHeaderOffset, diskStart);
        try {
            ZipShort result = zipField.getCentralDirectoryLength();
            assertEquals(32, result.getValue()); // Expecting 32 since all properties are set to 8
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetCentralDirectoryLength_OnlyDiskStartSet() {
        ZipLong diskStart = new ZipLong(0);
        Zip64ExtendedInformationExtraField zipField = new Zip64ExtendedInformationExtraField(null, null, null, diskStart);
        try {
            ZipShort result = zipField.getCentralDirectoryLength();
            assertEquals(0, result.getValue()); // Expecting 0 since only diskStart is set
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}