package org.apache.commons.compress.archivers.cpio;
import org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import static org.junit.Assert.fail;

public class archivers_cpio_CpioArchiveOutputStream_write_byte_____int_int_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testWrite_ThrowsIndexOutOfBoundsException_WhenOffIsNegative() {
        CpioArchiveOutputStream cpioOutputStream = null;
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            cpioOutputStream = new CpioArchiveOutputStream(outputStream);
            byte[] bytes = new byte[10];
            cpioOutputStream.write(bytes, -1, 5);
            fail("Expected IndexOutOfBoundsException to be thrown");
        } catch (IndexOutOfBoundsException e) {
            // expected exception
        } catch (IOException e) {
            fail("Unexpected IOException thrown: " + e.getMessage());
        } finally {
            if (cpioOutputStream != null) {
                try {
                    cpioOutputStream.close();
                } catch (IOException ignored) {
                }
            }
        }
    }
    
    @Test(timeout = 4000)
    public void testWrite_ThrowsIndexOutOfBoundsException_WhenLenIsNegative() {
        CpioArchiveOutputStream cpioOutputStream = null;
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            cpioOutputStream = new CpioArchiveOutputStream(outputStream);
            byte[] bytes = new byte[10];
            cpioOutputStream.write(bytes, 0, -5);
            fail("Expected IndexOutOfBoundsException to be thrown");
        } catch (IndexOutOfBoundsException e) {
            // expected exception
        } catch (IOException e) {
            fail("Unexpected IOException thrown: " + e.getMessage());
        } finally {
            if (cpioOutputStream != null) {
                try {
                    cpioOutputStream.close();
                } catch (IOException ignored) {
                }
            }
        }
    }

    @Test(timeout = 4000)
    public void testWrite_ThrowsIndexOutOfBoundsException_WhenOffPlusLenIsGreaterThanBytesLength() {
        CpioArchiveOutputStream cpioOutputStream = null;
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            cpioOutputStream = new CpioArchiveOutputStream(outputStream);
            byte[] bytes = new byte[10];
            cpioOutputStream.write(bytes, 8, 5); // off=8, len=5, out of bounds
            fail("Expected IndexOutOfBoundsException to be thrown");
        } catch (IndexOutOfBoundsException e) {
            // expected exception
        } catch (IOException e) {
            fail("Unexpected IOException thrown: " + e.getMessage());
        } finally {
            if (cpioOutputStream != null) {
                try {
                    cpioOutputStream.close();
                } catch (IOException ignored) {
                }
            }
        }
    }

}