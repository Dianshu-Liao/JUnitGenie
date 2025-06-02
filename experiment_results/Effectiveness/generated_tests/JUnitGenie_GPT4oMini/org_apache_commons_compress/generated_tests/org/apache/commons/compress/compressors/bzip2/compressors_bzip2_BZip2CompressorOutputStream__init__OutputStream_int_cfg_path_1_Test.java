package org.apache.commons.compress.compressors.bzip2;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorOutputStream;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import static org.junit.Assert.fail;

public class compressors_bzip2_BZip2CompressorOutputStream__init__OutputStream_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testConstructorWithValidBlockSize() {
        OutputStream out = new ByteArrayOutputStream();
        int blockSize = 5; // Valid block size between 1 and 9
        try {
            BZip2CompressorOutputStream compressor = new BZip2CompressorOutputStream(out, blockSize);
            // Additional assertions can be added here to verify the state of the compressor if needed
        } catch (IOException e) {
            fail("IOException should not have been thrown for valid block size");
        }
    }

    @Test(timeout = 4000)
    public void testConstructorWithBlockSizeLessThanOne() {
        OutputStream out = new ByteArrayOutputStream();
        int blockSize = 0; // Invalid block size
        try {
            new BZip2CompressorOutputStream(out, blockSize);
            fail("Expected IllegalArgumentException for blockSize < 1");
        } catch (IllegalArgumentException e) {
            // Expected exception
        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }
    }

    @Test(timeout = 4000)
    public void testConstructorWithBlockSizeGreaterThanNine() {
        OutputStream out = new ByteArrayOutputStream();
        int blockSize = 10; // Invalid block size
        try {
            new BZip2CompressorOutputStream(out, blockSize);
            fail("Expected IllegalArgumentException for blockSize > 9");
        } catch (IllegalArgumentException e) {
            // Expected exception
        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }
    }

}