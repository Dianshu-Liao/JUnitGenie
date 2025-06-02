package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField;
import org.apache.commons.compress.archivers.zip.ZipShort;
import org.apache.commons.compress.archivers.zip.ZipEightByteInteger;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class archivers_zip_Zip64ExtendedInformationExtraField_getLocalFileDataLength__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testGetLocalFileDataLengthWhenSizeIsNull() {
        Zip64ExtendedInformationExtraField zipField = new Zip64ExtendedInformationExtraField();
        ZipShort result = zipField.getLocalFileDataLength();
        assertEquals(new ZipShort(0), result);
    }

    @Test(timeout = 4000)
    public void testGetLocalFileDataLengthWhenSizeIsNotNull() {
        ZipEightByteInteger size = new ZipEightByteInteger(1); // Assuming a valid constructor
        Zip64ExtendedInformationExtraField zipField = new Zip64ExtendedInformationExtraField(size, size, size, new ZipLong(0)); // Using one of the constructors
        ZipShort result = zipField.getLocalFileDataLength();
        assertEquals(new ZipShort(16), result); // Expecting 2 * 16 = 32, but since size is not null, we expect 16
    }

}