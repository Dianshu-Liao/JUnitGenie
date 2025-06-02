package org.apache.commons.compress.compressors.bzip2;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorOutputStream;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import static org.junit.Assert.fail;

public class compressors_bzip2_BZip2CompressorOutputStream__init__OutputStream_int_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testConstructorWithValidParameters() {
        OutputStream out = new ByteArrayOutputStream();
        int blockSize = 1; // valid block size

        try {
            BZip2CompressorOutputStream compressor = new BZip2CompressorOutputStream(out, blockSize);
            // Additional assertions can be added here to verify the state of the compressor if needed
        } catch (IOException e) {
            fail("IOException should not have been thrown for valid parameters");
        } catch (IllegalArgumentException e) {
            fail("IllegalArgumentException should not have been thrown for valid parameters");
        }
    }

    @Test(timeout = 4000)
    public void testConstructorWithBlockSizeLessThanOne() {
        OutputStream out = new ByteArrayOutputStream();
        int blockSize = 0; // invalid block size

        try {
            new BZip2CompressorOutputStream(out, blockSize);
            fail("Expected IllegalArgumentException for blockSize < 1");
        } catch (IllegalArgumentException e) {
            // Expected exception
        } catch (IOException e) {
            fail("IOException should not have been thrown for invalid parameters");
        }
    }

    @Test(timeout = 4000)
    public void testConstructorWithBlockSizeGreaterThanNine() {
        OutputStream out = new ByteArrayOutputStream();
        int blockSize = 10; // invalid block size

        try {
            new BZip2CompressorOutputStream(out, blockSize);
            fail("Expected IllegalArgumentException for blockSize > 9");
        } catch (IllegalArgumentException e) {
            // Expected exception
        } catch (IOException e) {
            fail("IOException should not have been thrown for invalid parameters");
        }
    }

}