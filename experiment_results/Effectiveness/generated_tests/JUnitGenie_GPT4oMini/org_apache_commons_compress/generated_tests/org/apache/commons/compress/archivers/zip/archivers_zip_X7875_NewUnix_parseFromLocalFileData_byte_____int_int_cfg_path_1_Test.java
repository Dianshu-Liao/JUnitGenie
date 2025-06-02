package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.X7875_NewUnix;
import org.junit.Test;
import java.util.zip.ZipException;

public class archivers_zip_X7875_NewUnix_parseFromLocalFileData_byte_____int_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testParseFromLocalFileData_LengthTooShort() {
        X7875_NewUnix instance = new X7875_NewUnix();
        byte[] data = new byte[2]; // Length is less than 3
        int offset = 0;
        int length = data.length;

        try {
            instance.parseFromLocalFileData(data, offset, length);
        } catch (ZipException e) {
            // Expected exception
            assert e.getMessage().equals("X7875_NewUnix length is too short, only 2 bytes");
        }
    }

}