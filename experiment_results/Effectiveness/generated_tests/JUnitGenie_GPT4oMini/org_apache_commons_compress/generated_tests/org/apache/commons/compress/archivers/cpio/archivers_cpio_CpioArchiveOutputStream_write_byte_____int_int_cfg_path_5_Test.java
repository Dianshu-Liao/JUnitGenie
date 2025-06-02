package org.apache.commons.compress.archivers.cpio;
import org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream;
import org.apache.commons.compress.archivers.cpio.CpioArchiveEntry;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import static org.junit.Assert.*;

public class archivers_cpio_CpioArchiveOutputStream_write_byte_____int_int_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testWriteValidData() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        CpioArchiveOutputStream cpioOutputStream = null;
        try {
            cpioOutputStream = new CpioArchiveOutputStream(outputStream);
            CpioArchiveEntry entry = new CpioArchiveEntry("testEntry");
            entry.setSize(10);
            cpioOutputStream.putArchiveEntry(entry); // Correctly add the entry to the output stream

            byte[] data = new byte[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            cpioOutputStream.write(data, 0, 10);
            cpioOutputStream.closeArchiveEntry(); // Close the entry after writing
        } catch (IOException e) {
            fail("IOException should not have been thrown");
        } finally {
            if (cpioOutputStream != null) {
                try {
                    cpioOutputStream.close();
                } catch (IOException e) {
                    fail("IOException should not have been thrown during close");
                }
            }
        }
    }

    @Test(timeout = 4000)
    public void testWriteWithNegativeOffset() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        CpioArchiveOutputStream cpioOutputStream = null;
        try {
            cpioOutputStream = new CpioArchiveOutputStream(outputStream);
            CpioArchiveEntry entry = new CpioArchiveEntry("testEntry");
            entry.setSize(10);
            cpioOutputStream.putArchiveEntry(entry); // Correctly add the entry to the output stream

            byte[] data = new byte[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            try {
                cpioOutputStream.write(data, -1, 5);
                fail("Expected IndexOutOfBoundsException was not thrown");
            } catch (IndexOutOfBoundsException e) {
                // Expected exception
            }
        } catch (IOException e) {
            fail("IOException should not have been thrown");
        } finally {
            if (cpioOutputStream != null) {
                try {
                    cpioOutputStream.closeArchiveEntry(); // Ensure the entry is closed
                } catch (IOException e) {
                    fail("IOException should not have been thrown during close");
                }
            }
        }
    }

    @Test(timeout = 4000)
    public void testWriteWithNegativeLength() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        CpioArchiveOutputStream cpioOutputStream = null;
        try {
            cpioOutputStream = new CpioArchiveOutputStream(outputStream);
            CpioArchiveEntry entry = new CpioArchiveEntry("testEntry");
            entry.setSize(10);
            cpioOutputStream.putArchiveEntry(entry); // Correctly add the entry to the output stream

            byte[] data = new byte[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            try {
                cpioOutputStream.write(data, 0, -1);
                fail("Expected IndexOutOfBoundsException was not thrown");
            } catch (IndexOutOfBoundsException e) {
                // Expected exception
            }
        } catch (IOException e) {
            fail("IOException should not have been thrown");
        } finally {
            if (cpioOutputStream != null) {
                try {
                    cpioOutputStream.closeArchiveEntry(); // Ensure the entry is closed
                } catch (IOException e) {
                    fail("IOException should not have been thrown during close");
                }
            }
        }
    }

    @Test(timeout = 4000)
    public void testWriteWithZeroLength() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        CpioArchiveOutputStream cpioOutputStream = null;
        try {
            cpioOutputStream = new CpioArchiveOutputStream(outputStream);
            CpioArchiveEntry entry = new CpioArchiveEntry("testEntry");
            entry.setSize(10);
            cpioOutputStream.putArchiveEntry(entry); // Correctly add the entry to the output stream

            byte[] data = new byte[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            cpioOutputStream.write(data, 0, 0);
        } catch (IOException e) {
            fail("IOException should not have been thrown");
        } finally {
            if (cpioOutputStream != null) {
                try {
                    cpioOutputStream.closeArchiveEntry(); // Ensure the entry is closed
                } catch (IOException e) {
                    fail("IOException should not have been thrown during close");
                }
            }
        }
    }

    @Test(timeout = 4000)
    public void testWriteExceedingEntrySize() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        CpioArchiveOutputStream cpioOutputStream = null;
        try {
            cpioOutputStream = new CpioArchiveOutputStream(outputStream);
            CpioArchiveEntry entry = new CpioArchiveEntry("testEntry");
            entry.setSize(5);
            cpioOutputStream.putArchiveEntry(entry); // Correctly add the entry to the output stream

            byte[] data = new byte[]{1, 2, 3, 4, 5, 6};
            try {
                cpioOutputStream.write(data, 0, 6);
                fail("Expected IOException was not thrown");
            } catch (IOException e) {
                // Expected exception
            }
        } catch (IOException e) {
            fail("IOException should not have been thrown");
        } finally {
            if (cpioOutputStream != null) {
                try {
                    cpioOutputStream.closeArchiveEntry(); // Ensure the entry is closed
                } catch (IOException e) {
                    fail("IOException should not have been thrown during close");
                }
            }
        }
    }



}
