package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.X7875_NewUnix;
import java.util.zip.ZipException;
import org.junit.Test;
import static org.junit.Assert.*;

public class archivers_zip_X7875_NewUnix_parseFromLocalFileData_byte_____int_int_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testParseFromLocalFileData_ValidInput() {
        X7875_NewUnix instance = new X7875_NewUnix();
        byte[] data = new byte[] {1, 2, 3, 4}; // Example data
        int offset = 0;
        int length = data.length;

        try {
            instance.parseFromLocalFileData(data, offset, length);
            // Add assertions to verify the state of the instance if necessary
        } catch (ZipException e) {
            fail("Expected no exception, but got: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testParseFromLocalFileData_LengthTooShort() {
        X7875_NewUnix instance = new X7875_NewUnix();
        byte[] data = new byte[] {1}; // Length is too short
        int offset = 0;
        int length = data.length;

        try {
            instance.parseFromLocalFileData(data, offset, length);
            fail("Expected ZipException due to length being too short");
        } catch (ZipException e) {
            assertEquals("X7875_NewUnix length is too short, only 1 bytes", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testParseFromLocalFileData_UidSizeTooLarge() {
        X7875_NewUnix instance = new X7875_NewUnix();
        byte[] data = new byte[] {1, 5, 0, 0}; // uidSize is 5, but length is only 4
        int offset = 0;
        int length = data.length;

        try {
            instance.parseFromLocalFileData(data, offset, length);
            fail("Expected ZipException due to uidSize not fitting into length");
        } catch (ZipException e) {
            assertEquals("X7875_NewUnix invalid: uidSize 5 doesn't fit into 4 bytes", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testParseFromLocalFileData_GidSizeTooLarge() {
        X7875_NewUnix instance = new X7875_NewUnix();
        byte[] data = new byte[] {1, 2, 3, 5, 0}; // uidSize is 2, gidSize is 5, but length is only 5
        int offset = 0;
        int length = data.length;

        try {
            instance.parseFromLocalFileData(data, offset, length);
            fail("Expected ZipException due to gidSize not fitting into length");
        } catch (ZipException e) {
            assertEquals("X7875_NewUnix invalid: gidSize 5 doesn't fit into 5 bytes", e.getMessage());
        }
    }

}