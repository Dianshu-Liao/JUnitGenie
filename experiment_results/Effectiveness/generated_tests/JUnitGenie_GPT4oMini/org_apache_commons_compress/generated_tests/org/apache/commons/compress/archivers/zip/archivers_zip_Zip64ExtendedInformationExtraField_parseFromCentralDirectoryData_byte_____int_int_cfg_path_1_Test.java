package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField;
import org.junit.Test;
import static org.junit.Assert.*;

public class archivers_zip_Zip64ExtendedInformationExtraField_parseFromCentralDirectoryData_byte_____int_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testParseFromCentralDirectoryData() {
        Zip64ExtendedInformationExtraField zipField = new Zip64ExtendedInformationExtraField();
        byte[] buffer = new byte[32]; // Example buffer with sufficient length
        int offset = 0;
        int length = 24; // Length that triggers the specific path in the method

        try {
            zipField.parseFromCentralDirectoryData(buffer, offset, length);
            // Assertions can be added here to verify the state of the zipField object
            assertNotNull(zipField.getSize());
            assertNotNull(zipField.getCompressedSize());
            assertNotNull(zipField.getRelativeHeaderOffset());
        } catch (Exception e) { // Catching general Exception instead of ZipException
            fail("Exception should not have been thrown for valid input");
        }
    }

    @Test(timeout = 4000)
    public void testParseFromCentralDirectoryDataWithInvalidLength() {
        Zip64ExtendedInformationExtraField zipField = new Zip64ExtendedInformationExtraField();
        byte[] buffer = new byte[32]; // Example buffer
        int offset = 0;
        int length = 20; // Length that does not meet the conditions

        try {
            zipField.parseFromCentralDirectoryData(buffer, offset, length);
            // Assertions can be added here to verify the state of the zipField object
            assertNull(zipField.getSize());
            assertNull(zipField.getCompressedSize());
            assertNull(zipField.getRelativeHeaderOffset());
        } catch (Exception e) { // Catching general Exception instead of ZipException
            fail("Exception should not have been thrown for valid input");
        }
    }

    @Test(timeout = 4000)
    public void testParseFromCentralDirectoryDataWithNullBuffer() {
        Zip64ExtendedInformationExtraField zipField = new Zip64ExtendedInformationExtraField();
        byte[] buffer = null; // Invalid buffer
        int offset = 0;
        int length = 24; // Length that triggers the specific path in the method

        try {
            zipField.parseFromCentralDirectoryData(buffer, offset, length);
            fail("Expected Exception due to null buffer");
        } catch (Exception e) { // Catching general Exception instead of ZipException
            // Expected exception
        }
    }

    @Test(timeout = 4000)
    public void testParseFromCentralDirectoryDataWithInvalidOffset() {
        Zip64ExtendedInformationExtraField zipField = new Zip64ExtendedInformationExtraField();
        byte[] buffer = new byte[32]; // Example buffer
        int offset = 35; // Invalid offset
        int length = 24; // Length that triggers the specific path in the method

        try {
            zipField.parseFromCentralDirectoryData(buffer, offset, length);
            fail("Expected Exception due to invalid offset");
        } catch (Exception e) { // Catching general Exception instead of ZipException
            // Expected exception
        }
    }

}