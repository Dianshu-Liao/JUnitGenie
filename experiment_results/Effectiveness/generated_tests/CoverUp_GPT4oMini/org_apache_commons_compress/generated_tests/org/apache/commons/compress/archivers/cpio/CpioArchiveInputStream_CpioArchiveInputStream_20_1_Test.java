package org.apache.commons.compress.archivers.cpio;

import org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.EOFException;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.utils.ArchiveUtils;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.ParsingUtils;

public class // Additional tests can be added here to cover more scenarios
CpioArchiveInputStream_CpioArchiveInputStream_20_1_Test {

    private InputStream mockInputStream;

    private CpioArchiveInputStream cpioArchiveInputStream;

    @BeforeEach
    public void setUp() {
        // Mock InputStream with some test data
        // Example data
        byte[] testData = new byte[] { 0x00, 0x01, 0x02, 0x03 };
        mockInputStream = new ByteArrayInputStream(testData);
    }

    @Test
    public void testCpioArchiveInputStream_ValidInput() {
        // Test the constructor with valid InputStream and block size
        assertDoesNotThrow(() -> {
            cpioArchiveInputStream = new CpioArchiveInputStream(mockInputStream, 512);
        });
    }

    @Test
    public void testCpioArchiveInputStream_NegativeBlockSize() {
        // Test the constructor with a negative block size
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cpioArchiveInputStream = new CpioArchiveInputStream(mockInputStream, -1);
        });
        assertEquals("Block size must be positive", exception.getMessage());
    }

    @Test
    public void testCpioArchiveInputStream_ZeroBlockSize() {
        // Test the constructor with a zero block size
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cpioArchiveInputStream = new CpioArchiveInputStream(mockInputStream, 0);
        });
        assertEquals("Block size must be positive", exception.getMessage());
    }

    @Test
    public void testCpioArchiveInputStream_NullInputStream() {
        // Test the constructor with a null InputStream
        Exception exception = assertThrows(NullPointerException.class, () -> {
            cpioArchiveInputStream = new CpioArchiveInputStream(null, 512);
        });
        assertEquals("InputStream must not be null", exception.getMessage());
    }
}
