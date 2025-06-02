package org.apache.commons.compress.archivers.cpio;
import org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import static org.junit.Assert.fail;

public class archivers_cpio_CpioArchiveOutputStream_write_byte_____int_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testWrite_ThrowsIndexOutOfBoundsException_WhenOffIsNegative() {
        CpioArchiveOutputStream cpioOutputStream = null;
        try {
            cpioOutputStream = new CpioArchiveOutputStream(new ByteArrayOutputStream());
            byte[] data = new byte[10];
            cpioOutputStream.write(data, -1, 5);
            fail("Expected IndexOutOfBoundsException to be thrown");
        } catch (IndexOutOfBoundsException e) {
            // Expected exception
        } catch (IOException e) {
            fail("Unexpected IOException thrown: " + e.getMessage());
        } finally {
            if (cpioOutputStream != null) {
                try {
                    cpioOutputStream.close();
                } catch (IOException e) {
                    // Handle close exception
                }
            }
        }
    }

    @Test(timeout = 4000)
    public void testWrite_ThrowsIndexOutOfBoundsException_WhenLenIsNegative() {
        CpioArchiveOutputStream cpioOutputStream = null;
        try {
            cpioOutputStream = new CpioArchiveOutputStream(new ByteArrayOutputStream());
            byte[] data = new byte[10];
            cpioOutputStream.write(data, 0, -1);
            fail("Expected IndexOutOfBoundsException to be thrown");
        } catch (IndexOutOfBoundsException e) {
            // Expected exception
        } catch (IOException e) {
            fail("Unexpected IOException thrown: " + e.getMessage());
        } finally {
            if (cpioOutputStream != null) {
                try {
                    cpioOutputStream.close();
                } catch (IOException e) {
                    // Handle close exception
                }
            }
        }
    }

}