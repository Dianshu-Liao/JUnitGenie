package org.apache.commons.compress.archivers.cpio;
import org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.junit.Assert.fail;

public class archivers_cpio_CpioArchiveInputStream__init__InputStream_int_String_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testConstructorWithValidParameters() {
        InputStream in = new ByteArrayInputStream(new byte[]{});
        int blockSize = 1024; // valid block size
        String encoding = "UTF-8";

        // This should not throw an exception
        try {
            CpioArchiveInputStream cpioInputStream = new CpioArchiveInputStream(in, blockSize, encoding);
        } catch (IllegalArgumentException e) {
            fail("Constructor should not throw IllegalArgumentException for valid parameters");
        }
    }

    @Test(timeout = 4000)
    public void testConstructorWithZeroBlockSize() {
        InputStream in = new ByteArrayInputStream(new byte[]{});
        int blockSize = 0; // invalid block size
        String encoding = "UTF-8";

        // This should throw an IllegalArgumentException
        try {
            CpioArchiveInputStream cpioInputStream = new CpioArchiveInputStream(in, blockSize, encoding);
            fail("Constructor should throw IllegalArgumentException for blockSize <= 0");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }

    @Test(timeout = 4000)
    public void testConstructorWithNegativeBlockSize() {
        InputStream in = new ByteArrayInputStream(new byte[]{});
        int blockSize = -1; // invalid block size
        String encoding = "UTF-8";

        // This should throw an IllegalArgumentException
        try {
            CpioArchiveInputStream cpioInputStream = new CpioArchiveInputStream(in, blockSize, encoding);
            fail("Constructor should throw IllegalArgumentException for blockSize <= 0");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }

}