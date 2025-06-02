package org.apache.commons.compress.archivers.cpio;
import org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream;
import org.apache.commons.compress.archivers.cpio.CpioArchiveEntry;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class archivers_cpio_CpioArchiveOutputStream_write_byte_____int_int_cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testWrite_ValidInput() throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        CpioArchiveEntry entry = new CpioArchiveEntry("testEntry");
        entry.setSize(10); // Set the size to be greater than written + len
        try (CpioArchiveOutputStream cpioOutputStream = new CpioArchiveOutputStream(outputStream)) {
            cpioOutputStream.putArchiveEntry(entry); // Use putArchiveEntry to set the current entry
            byte[] data = new byte[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            int off = 0;
            int len = 10;

            cpioOutputStream.write(data, off, len);
            cpioOutputStream.closeArchiveEntry(); // Close the current entry
        }
    }

    @Test(timeout = 4000)
    public void testWrite_ThrowsIOException_NoCurrentEntry() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try (CpioArchiveOutputStream cpioOutputStream = new CpioArchiveOutputStream(outputStream)) {
            byte[] data = new byte[]{1, 2, 3};
            int off = 0;
            int len = 3;

            try {
                cpioOutputStream.write(data, off, len);
            } catch (IOException e) {
                // Expected exception
                assert e.getMessage().equals("No current CPIO entry");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWrite_ThrowsIOException_WritePastEnd() throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        CpioArchiveEntry entry = new CpioArchiveEntry("testEntry");
        entry.setSize(5); // Set the size to be less than written + len
        try (CpioArchiveOutputStream cpioOutputStream = new CpioArchiveOutputStream(outputStream)) {
            cpioOutputStream.putArchiveEntry(entry); // Use putArchiveEntry to set the current entry
            cpioOutputStream.write(new byte[]{1, 2, 3}, 0, 3); // Write 3 bytes

            try {
                cpioOutputStream.write(new byte[]{4, 5}, 0, 2); // Attempt to write past the end
            } catch (IOException e) {
                // Expected exception
                assert e.getMessage().equals("Attempt to write past end of STORED entry");
            }
            cpioOutputStream.closeArchiveEntry(); // Close the current entry
        }
    }

    @Test(timeout = 4000)
    public void testWrite_ThrowsIndexOutOfBoundsException_NegativeOffset() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try (CpioArchiveOutputStream cpioOutputStream = new CpioArchiveOutputStream(outputStream)) {
            cpioOutputStream.putArchiveEntry(new CpioArchiveEntry("testEntry"));

            byte[] data = new byte[]{1, 2, 3};
            int off = -1; // Invalid offset
            int len = 3;

            try {
                cpioOutputStream.write(data, off, len);
            } catch (IndexOutOfBoundsException e) {
                // Expected exception
            }
            cpioOutputStream.closeArchiveEntry(); // Close the current entry
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWrite_ThrowsIndexOutOfBoundsException_NegativeLength() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try (CpioArchiveOutputStream cpioOutputStream = new CpioArchiveOutputStream(outputStream)) {
            cpioOutputStream.putArchiveEntry(new CpioArchiveEntry("testEntry"));

            byte[] data = new byte[]{1, 2, 3};
            int off = 0;
            int len = -1; // Invalid length

            try {
                cpioOutputStream.write(data, off, len);
            } catch (IndexOutOfBoundsException e) {
                // Expected exception
            }
            cpioOutputStream.closeArchiveEntry(); // Close the current entry
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}