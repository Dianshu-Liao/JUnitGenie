package org.apache.commons.compress.archivers.cpio;
import org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class archivers_cpio_CpioArchiveOutputStream_write_byte_____int_int_cfg_path_9_Test {

    @Test(timeout = 4000)
    public void testWriteWithValidParameters() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try (CpioArchiveOutputStream cpioOutputStream = new CpioArchiveOutputStream(outputStream)) {
            // Create a new CPIO entry before writing
            cpioOutputStream.putArchiveEntry(new CpioArchiveEntry("testEntry", 5));
            
            byte[] data = new byte[]{1, 2, 3, 4, 5};
            
            cpioOutputStream.write(data, 0, 5);
            cpioOutputStream.closeArchiveEntry(); // Close the entry after writing
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteWithNegativeOffset() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try (CpioArchiveOutputStream cpioOutputStream = new CpioArchiveOutputStream(outputStream)) {
            // Create a new CPIO entry before writing
            cpioOutputStream.putArchiveEntry(new CpioArchiveEntry("testEntry", 5));
            byte[] data = new byte[]{1, 2, 3, 4, 5};

            try {
                cpioOutputStream.write(data, -1, 5);
            } catch (IndexOutOfBoundsException e) {
                // Expected exception
            }
            cpioOutputStream.closeArchiveEntry(); // Ensure the entry is closed
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteWithNegativeLength() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try (CpioArchiveOutputStream cpioOutputStream = new CpioArchiveOutputStream(outputStream)) {
            // Create a new CPIO entry before writing
            cpioOutputStream.putArchiveEntry(new CpioArchiveEntry("testEntry", 5));
            byte[] data = new byte[]{1, 2, 3, 4, 5};

            try {
                cpioOutputStream.write(data, 0, -1);
            } catch (IndexOutOfBoundsException e) {
                // Expected exception
            }
            cpioOutputStream.closeArchiveEntry(); // Ensure the entry is closed
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteWithOffsetGreaterThanLength() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try (CpioArchiveOutputStream cpioOutputStream = new CpioArchiveOutputStream(outputStream)) {
            // Create a new CPIO entry before writing
            cpioOutputStream.putArchiveEntry(new CpioArchiveEntry("testEntry", 5));
            byte[] data = new byte[]{1, 2, 3, 4, 5};

            try {
                cpioOutputStream.write(data, 6, 1);
            } catch (IndexOutOfBoundsException e) {
                // Expected exception
            }
            cpioOutputStream.closeArchiveEntry(); // Ensure the entry is closed
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteWithZeroLength() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try (CpioArchiveOutputStream cpioOutputStream = new CpioArchiveOutputStream(outputStream)) {
            // Create a new CPIO entry before writing
            cpioOutputStream.putArchiveEntry(new CpioArchiveEntry("testEntry", 0));
            byte[] data = new byte[]{1, 2, 3, 4, 5};

            try {
                cpioOutputStream.write(data, 0, 0);
                // No exception should be thrown
            } catch (IOException e) {
                // Handle the exception
                e.printStackTrace();
            }
            cpioOutputStream.closeArchiveEntry(); // Ensure the entry is closed
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

}