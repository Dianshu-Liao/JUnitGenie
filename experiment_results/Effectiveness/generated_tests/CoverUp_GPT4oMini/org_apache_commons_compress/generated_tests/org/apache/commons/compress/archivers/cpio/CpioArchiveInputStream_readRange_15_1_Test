package org.apache.commons.compress.archivers.cpio;

import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
import org.apache.commons.compress.utils.ArchiveUtils;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.ParsingUtils;

public class CpioArchiveInputStream_readRange_15_1_Test {

    private InputStream mockInputStream;

    private CpioArchiveInputStream cpioArchiveInputStream;

    @BeforeEach
    public void setUp() {
        // Prepare a mock InputStream with predefined data
        byte[] data = "Test data for reading.".getBytes();
        mockInputStream = new ByteArrayInputStream(data);
        cpioArchiveInputStream = new CpioArchiveInputStream(mockInputStream);
    }

    @Test
    public void testReadRange_ValidLength() throws IOException {
        // Test reading a valid length
        byte[] result = invokeReadRange(cpioArchiveInputStream, 20);
        assertArrayEquals("Test data for readin".getBytes(), result);
    }

    @Test
    public void testReadRange_LengthExceedsInput() {
        // Test reading a length that exceeds the available data
        assertThrows(EOFException.class, () -> {
            invokeReadRange(cpioArchiveInputStream, 30);
        });
    }

    @Test
    public void testReadRange_ExactLength() throws IOException {
        // Test reading the exact length of available data
        byte[] result = invokeReadRange(cpioArchiveInputStream, 22);
        assertArrayEquals("Test data for reading.".getBytes(), result);
    }

    private byte[] invokeReadRange(CpioArchiveInputStream cpioArchiveInputStream, int len) throws IOException {
        try {
            java.lang.reflect.Method method = CpioArchiveInputStream.class.getDeclaredMethod("readRange", int.class);
            method.setAccessible(true);
            return (byte[]) method.invoke(cpioArchiveInputStream, len);
        } catch (Exception e) {
            throw new IOException("Reflection invocation failed", e);
        }
    }
}
