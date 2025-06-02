package org.apache.commons.compress.archivers.tar;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import static org.junit.Assert.fail;

public class archivers_tar_TarArchiveOutputStream__init__OutputStream_int_String_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testConstructorWithInvalidBlockSize() {
        OutputStream os = new ByteArrayOutputStream();
        int invalidBlockSize = -1; // Invalid block size
        String charset = "UTF-8";

        try {
            new TarArchiveOutputStream(os, invalidBlockSize, charset);
            fail("Expected IllegalArgumentException for invalid block size");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }

    @Test(timeout = 4000)
    public void testConstructorWithBlockSizeNotMultipleOf512() {
        OutputStream os = new ByteArrayOutputStream();
        int invalidBlockSize = 600; // Not a multiple of 512
        String charset = "UTF-8";

        try {
            new TarArchiveOutputStream(os, invalidBlockSize, charset);
            fail("Expected IllegalArgumentException for block size not multiple of 512");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }

    @Test(timeout = 4000)
    public void testConstructorWithValidParameters() {
        OutputStream os = new ByteArrayOutputStream();
        int validBlockSize = 512; // Valid block size
        String charset = "UTF-8";

        try {
            TarArchiveOutputStream tarOutputStream = new TarArchiveOutputStream(os, validBlockSize, charset);
            // Additional assertions can be added here to verify the state of tarOutputStream
        } catch (Exception e) {
            fail("Did not expect an exception for valid parameters: " + e.getMessage());
        }
    }

}