package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField;
import org.apache.commons.compress.archivers.zip.ZipShort;
import org.apache.commons.compress.archivers.zip.ZipEightByteInteger;
import org.apache.commons.compress.archivers.zip.ZipLong;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class archivers_zip_Zip64ExtendedInformationExtraField_getCentralDirectoryLength__cfg_path_11_Test {

    @Test(timeout = 4000)
    public void testGetCentralDirectoryLength_AllFieldsNull() {
        Zip64ExtendedInformationExtraField field = new Zip64ExtendedInformationExtraField();
        try {
            ZipShort result = field.getCentralDirectoryLength();
            assertEquals(0, result.getValue());
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testGetCentralDirectoryLength_OnlySizeNotNull() {
        ZipEightByteInteger size = new ZipEightByteInteger(1);
        Zip64ExtendedInformationExtraField field = new Zip64ExtendedInformationExtraField(size, null, null, null);
        try {
            ZipShort result = field.getCentralDirectoryLength();
            assertEquals(8, result.getValue());
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testGetCentralDirectoryLength_SizeAndCompressedSizeNotNull() {
        ZipEightByteInteger size = new ZipEightByteInteger(1);
        ZipEightByteInteger compressedSize = new ZipEightByteInteger(1);
        Zip64ExtendedInformationExtraField field = new Zip64ExtendedInformationExtraField(size, compressedSize, null, null);
        try {
            ZipShort result = field.getCentralDirectoryLength();
            assertEquals(16, result.getValue());
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testGetCentralDirectoryLength_AllFieldsNotNull() {
        ZipEightByteInteger size = new ZipEightByteInteger(1);
        ZipEightByteInteger compressedSize = new ZipEightByteInteger(1);
        ZipEightByteInteger relativeHeaderOffset = new ZipEightByteInteger(1);
        ZipLong diskStart = new ZipLong(1);
        Zip64ExtendedInformationExtraField field = new Zip64ExtendedInformationExtraField(size, compressedSize, relativeHeaderOffset, diskStart);
        try {
            ZipShort result = field.getCentralDirectoryLength();
            assertEquals(32, result.getValue());
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}