package org.apache.commons.compress.archivers.tar;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.apache.commons.io.output.CountingOutputStream;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import java.io.OutputStream;
import java.io.ByteArrayOutputStream;
import org.junit.Test;
import static org.junit.Assert.*;

public class archivers_tar_TarArchiveOutputStream__init__OutputStream_int_String_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testTarArchiveOutputStreamWithValidInputs() {
        // Arrange
        OutputStream outputStream = new ByteArrayOutputStream();
        int blockSize = 1024; // valid block size (multiple of 512)
        String charset = "UTF-8"; // valid charset

        // Act
        TarArchiveOutputStream taos = null;
        try {
            taos = new TarArchiveOutputStream(outputStream, blockSize, charset);
        } catch (Exception e) {
            fail("Exception should not have been thrown for valid input: " + e.getMessage());
        }

        // Assert
        assertNotNull(taos);
    }

    @Test(timeout = 4000)
    public void testTarArchiveOutputStreamWithUnsuitableBlockSize() {
        // Arrange
        OutputStream outputStream = new ByteArrayOutputStream();
        int blockSize = 513; // invalid block size (not a multiple of 512)
        String charset = "UTF-8"; // valid charset

        // Act
        try {
            new TarArchiveOutputStream(outputStream, blockSize, charset);
            fail("Expected IllegalArgumentException for invalid block size.");
        } catch (IllegalArgumentException e) {
            // Expected
        } catch (Exception e) {
            fail("Unexpected exception type: " + e.getClass().getName());
        }
    }

    @Test(timeout = 4000)
    public void testTarArchiveOutputStreamWithZeroBlockSize() {
        // Arrange
        OutputStream outputStream = new ByteArrayOutputStream();
        int blockSize = 0; // invalid block size
        String charset = "UTF-8"; // valid charset

        // Act
        try {
            new TarArchiveOutputStream(outputStream, blockSize, charset);
            fail("Expected IllegalArgumentException for block size <= 0.");
        } catch (IllegalArgumentException e) {
            // Expected
        } catch (Exception e) {
            fail("Unexpected exception type: " + e.getClass().getName());
        }
    }

    @Test(timeout = 4000)
    public void testTarArchiveOutputStreamWithNullCharset() {
        // Arrange
        OutputStream outputStream = new ByteArrayOutputStream();
        int blockSize = 512; // valid block size
        String charset = null; // null charset

        // Act
        TarArchiveOutputStream taos = null;
        try {
            taos = new TarArchiveOutputStream(outputStream, blockSize, charset);
        } catch (Exception e) {
            fail("Exception should not have been thrown for null charset: " + e.getMessage());
        }

        // Assert
        assertNotNull(taos);
    }

}