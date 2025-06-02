package org.apache.commons.compress.compressors.bzip2;

import org.apache.commons.compress.compressors.bzip2.BZip2CompressorOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import org.apache.commons.compress.compressors.CompressorOutputStream;

class BZip2CompressorOutputStream_BZip2CompressorOutputStream_31_0_Test {

    @Test
    void testConstructorWithValidOutputStream() {
        try (OutputStream out = new ByteArrayOutputStream()) {
            BZip2CompressorOutputStream bzip2OutputStream = new BZip2CompressorOutputStream(out);
            assertNotNull(bzip2OutputStream);
            assertEquals(BZip2CompressorOutputStream.MAX_BLOCKSIZE, bzip2OutputStream.getBlockSize());
        } catch (IOException e) {
            fail("IOException should not be thrown for valid OutputStream");
        }
    }

    @Test
    void testConstructorWithNullOutputStream() {
        assertThrows(IOException.class, () -> {
            new BZip2CompressorOutputStream(null);
        });
    }

    @Test
    void testConstructorWithInvalidBlockSize() {
        assertThrows(IllegalArgumentException.class, () -> {
            new BZip2CompressorOutputStream(new ByteArrayOutputStream(), 0);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new BZip2CompressorOutputStream(new ByteArrayOutputStream(), 10);
        });
    }

    @Test
    void testConstructorWithValidBlockSize() {
        try (OutputStream out = new ByteArrayOutputStream()) {
            BZip2CompressorOutputStream bzip2OutputStream = new BZip2CompressorOutputStream(out, 5);
            assertNotNull(bzip2OutputStream);
            assertEquals(5, bzip2OutputStream.getBlockSize());
        } catch (IOException e) {
            fail("IOException should not be thrown for valid OutputStream");
        }
    }
}
