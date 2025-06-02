package org.apache.commons.compress.archivers.cpio;

import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.UnsupportedCharsetException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.EOFException;
import java.io.IOException;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.utils.ArchiveUtils;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.ParsingUtils;

class CpioArchiveInputStream_CpioArchiveInputStream_22_0_Test {

    private static final String TEST_ENCODING = "UTF-8";

    private InputStream inputStream;

    @BeforeEach
    void setUp() {
        // Set up a simple input stream for testing
        // Example byte data
        byte[] testData = new byte[] { 0x01, 0x02, 0x03, 0x04 };
        inputStream = new ByteArrayInputStream(testData);
    }

    @Test
    void testCpioArchiveInputStream_ValidInput() {
        assertDoesNotThrow(() -> {
            CpioArchiveInputStream cpioInputStream = new CpioArchiveInputStream(inputStream, TEST_ENCODING);
            assertNotNull(cpioInputStream);
        });
    }

    @Test
    void testCpioArchiveInputStream_NullInputStream() {
        assertThrows(NullPointerException.class, () -> {
            new CpioArchiveInputStream(null, TEST_ENCODING);
        });
    }

    @Test
    void testCpioArchiveInputStream_NullEncoding() {
        assertThrows(NullPointerException.class, () -> {
            new CpioArchiveInputStream(inputStream, null);
        });
    }

    @Test
    void testCpioArchiveInputStream_EmptyEncoding() {
        assertDoesNotThrow(() -> {
            CpioArchiveInputStream cpioInputStream = new CpioArchiveInputStream(inputStream, "");
            assertNotNull(cpioInputStream);
        });
    }

    @Test
    void testCpioArchiveInputStream_InvalidEncoding() {
        assertThrows(UnsupportedCharsetException.class, () -> {
            new CpioArchiveInputStream(inputStream, "invalid-encoding");
        });
    }

    @Test
    void testCpioArchiveInputStream_ValidEncoding() {
        assertDoesNotThrow(() -> {
            ZipEncoding encoding = ZipEncodingHelper.getZipEncoding(TEST_ENCODING);
            CpioArchiveInputStream cpioInputStream = new CpioArchiveInputStream(inputStream, TEST_ENCODING);
            assertNotNull(cpioInputStream);
        });
    }
}
