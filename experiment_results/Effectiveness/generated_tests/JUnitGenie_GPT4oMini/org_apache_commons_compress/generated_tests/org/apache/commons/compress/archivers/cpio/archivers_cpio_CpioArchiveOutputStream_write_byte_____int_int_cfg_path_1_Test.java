package org.apache.commons.compress.archivers.cpio;
import org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import static org.junit.Assert.fail;

public class archivers_cpio_CpioArchiveOutputStream_write_byte_____int_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testWriteThrowsIndexOutOfBoundsException() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        CpioArchiveOutputStream cpioOutputStream = new CpioArchiveOutputStream(outputStream);
        
        byte[] data = new byte[10];
        int off = -1; // Invalid offset
        int len = 5;

        try {
            cpioOutputStream.write(data, off, len);
            fail("Expected IndexOutOfBoundsException to be thrown");
        } catch (IndexOutOfBoundsException e) {
            // Exception is expected
        } catch (IOException e) {
            fail("Expected IndexOutOfBoundsException, but got IOException: " + e.getMessage());
        }
    }

}