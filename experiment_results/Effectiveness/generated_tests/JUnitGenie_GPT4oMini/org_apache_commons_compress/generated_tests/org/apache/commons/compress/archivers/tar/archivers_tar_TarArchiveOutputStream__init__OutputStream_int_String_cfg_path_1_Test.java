package org.apache.commons.compress.archivers.tar;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.apache.commons.io.output.CountingOutputStream;
import org.apache.commons.io.Charsets;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import static org.junit.Assert.*;

public class archivers_tar_TarArchiveOutputStream__init__OutputStream_int_String_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testConstructorWithValidParameters() {
        try {
            OutputStream os = new ByteArrayOutputStream();
            int blockSize = 512; // valid block size
            String charset = "UTF-8"; // valid charset
            TarArchiveOutputStream tarOutputStream = new TarArchiveOutputStream(os, blockSize, charset);
            assertNotNull(tarOutputStream);
        } catch (Exception e) {
            fail("Constructor should not throw an exception for valid parameters: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testConstructorWithInvalidBlockSize() {
        try {
            OutputStream os = new ByteArrayOutputStream();
            int blockSize = 511; // invalid block size
            String charset = "UTF-8"; // valid charset
            new TarArchiveOutputStream(os, blockSize, charset);
            fail("Expected IllegalArgumentException for invalid block size");
        } catch (IllegalArgumentException e) {
            assertEquals("Block size must be a multiple of 512 bytes. Attempt to use set size of 511", e.getMessage());
        } catch (Exception e) {
            fail("Expected IllegalArgumentException but got: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testConstructorWithZeroBlockSize() {
        try {
            OutputStream os = new ByteArrayOutputStream();
            int blockSize = 0; // invalid block size
            String charset = "UTF-8"; // valid charset
            new TarArchiveOutputStream(os, blockSize, charset);
            fail("Expected IllegalArgumentException for zero block size");
        } catch (IllegalArgumentException e) {
            assertEquals("Block size must be a multiple of 512 bytes. Attempt to use set size of 0", e.getMessage());
        } catch (Exception e) {
            fail("Expected IllegalArgumentException but got: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testConstructorWithNullCharset() {
        try {
            OutputStream os = new ByteArrayOutputStream();
            int blockSize = 512; // valid block size
            String charset = null; // invalid charset
            new TarArchiveOutputStream(os, blockSize, charset);
            fail("Expected NullPointerException for null charset");
        } catch (NullPointerException e) {
            assertEquals("Charset cannot be null", e.getMessage());
        } catch (Exception e) {
            fail("Expected NullPointerException but got: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testConstructorWithInvalidCharset() {
        try {
            OutputStream os = new ByteArrayOutputStream();
            int blockSize = 512; // valid block size
            String charset = "INVALID_CHARSET"; // invalid charset
            new TarArchiveOutputStream(os, blockSize, charset);
            fail("Expected IllegalArgumentException for invalid charset");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("Unsupported charset"));
        } catch (Exception e) {
            fail("Expected IllegalArgumentException but got: " + e.getMessage());
        }
    }

}