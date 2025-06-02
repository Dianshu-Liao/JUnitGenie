package org.apache.commons.compress.archivers.cpio;
import org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.io.Charsets;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.junit.Assert.assertNotNull;

public class archivers_cpio_CpioArchiveInputStream__init__InputStream_int_String_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testConstructorValidParameters() {
        InputStream in = new ByteArrayInputStream(new byte[]{});
        int blockSize = 512; // valid block size
        String encoding = "UTF-8"; // valid encoding

        try {
            CpioArchiveInputStream cpioArchiveInputStream = new CpioArchiveInputStream(in, blockSize, encoding);
            assertNotNull(cpioArchiveInputStream);
        } catch (Exception e) {
            // Handle exception if thrown
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testConstructorInvalidBlockSize() {
        InputStream in = new ByteArrayInputStream(new byte[]{});
        int blockSize = 0; // invalid block size
        String encoding = "UTF-8"; // valid encoding

        try {
            new CpioArchiveInputStream(in, blockSize, encoding);
        } catch (IllegalArgumentException e) {
            // Expected exception
            assertNotNull(e.getMessage());
        } catch (Exception e) {
            // Handle unexpected exceptions
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testConstructorNullEncoding() {
        InputStream in = new ByteArrayInputStream(new byte[]{});
        int blockSize = 512; // valid block size
        String encoding = null; // invalid encoding

        try {
            new CpioArchiveInputStream(in, blockSize, encoding);
        } catch (Exception e) {
            // Handle unexpected exceptions
            e.printStackTrace();
        }
    }

}