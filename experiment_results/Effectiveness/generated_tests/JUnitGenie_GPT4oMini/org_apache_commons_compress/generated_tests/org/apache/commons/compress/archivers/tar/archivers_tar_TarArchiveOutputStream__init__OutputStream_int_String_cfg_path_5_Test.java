package org.apache.commons.compress.archivers.tar;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import static org.junit.Assert.fail;

public class archivers_tar_TarArchiveOutputStream__init__OutputStream_int_String_cfg_path_5_Test {

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
    public void testConstructorWithNonMultipleOf512BlockSize() {
        OutputStream os = new ByteArrayOutputStream();
        int nonMultipleBlockSize = 1000; // Not a multiple of 512
        String charset = "UTF-8";

        try {
            new TarArchiveOutputStream(os, nonMultipleBlockSize, charset);
            fail("Expected IllegalArgumentException for block size not being a multiple of 512");
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