package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField;
import org.apache.commons.compress.archivers.zip.ZipEightByteInteger;
import org.junit.Test;
import static org.junit.Assert.*;

public class archivers_zip_Zip64ExtendedInformationExtraField_getLocalFileDataData__cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testGetLocalFileDataDataBothSizesNull() {
        Zip64ExtendedInformationExtraField zipField = new Zip64ExtendedInformationExtraField();
        // Using setter methods to simulate size being null
        zipField.setSize(null); 
        zipField.setCompressedSize(null); 

        byte[] result = zipField.getLocalFileDataData();
        assertArrayEquals(new byte[0], result); // Expecting an empty byte array
    }

    @Test(timeout = 4000)
    public void testGetLocalFileDataDataOneSizeNull() {
        Zip64ExtendedInformationExtraField zipField = new Zip64ExtendedInformationExtraField();
        zipField.setSize(new ZipEightByteInteger(1)); // Simulating size being initialized
        zipField.setCompressedSize(null); // Simulating compressedSize being null

        try {
            zipField.getLocalFileDataData();
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("LFH_MUST_HAVE_BOTH_SIZES_MSG", e.getMessage()); // Check the exception message
        }
    }

    @Test(timeout = 4000)
    public void testGetLocalFileDataDataBothSizesInitialized() {
        Zip64ExtendedInformationExtraField zipField = new Zip64ExtendedInformationExtraField();
        zipField.setSize(new ZipEightByteInteger(1)); // Simulating size being initialized
        zipField.setCompressedSize(new ZipEightByteInteger(1)); // Simulating compressedSize being initialized

        byte[] result = zipField.getLocalFileDataData();
        assertNotNull(result); // Ensure result is not null
        assertEquals(16, result.length); // Expecting a byte array of length 16
    }


}