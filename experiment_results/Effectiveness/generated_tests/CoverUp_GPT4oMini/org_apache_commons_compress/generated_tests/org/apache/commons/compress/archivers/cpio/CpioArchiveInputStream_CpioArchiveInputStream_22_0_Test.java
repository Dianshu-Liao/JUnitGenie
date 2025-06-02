package org.apache.commons.compress.archivers.cpio;

import org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.EOFException;
// Fixed import
import java.nio.charset.UnsupportedCharsetException;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
import org.apache.commons.compress.utils.ArchiveUtils;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.ParsingUtils;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class CpioArchiveInputStream_CpioArchiveInputStream_22_0_Test {

    private static final String ENCODING = "UTF-8";

    private InputStream inputStream;

    @BeforeEach
    public void setUp() {
        // Initialize InputStream with some dummy data
        byte[] dummyData = new byte[] { 0x0, 0x1, 0x2, 0x3 };
        inputStream = new ByteArrayInputStream(dummyData);
    }

    @Test
    public void testConstructorWithInputStreamAndEncoding() {
        assertDoesNotThrow(() -> {
            CpioArchiveInputStream cpio = new CpioArchiveInputStream(inputStream, ENCODING);
            assertNotNull(cpio);
        });
    }

    @Test
    public void testConstructorWithInputStreamAndNullEncoding() {
        assertThrows(NullPointerException.class, () -> {
            new CpioArchiveInputStream(inputStream, null);
        });
    }

    @Test
    public void testConstructorWithInputStream() {
        assertDoesNotThrow(() -> {
            CpioArchiveInputStream cpio = new CpioArchiveInputStream(inputStream);
            assertNotNull(cpio);
        });
    }

    @Test
    public void testConstructorWithInputStreamAndBlockSize() {
        assertDoesNotThrow(() -> {
            CpioArchiveInputStream cpio = new CpioArchiveInputStream(inputStream, 512);
            assertNotNull(cpio);
        });
    }

    @Test
    public void testConstructorWithInputStreamAndBlockSizeAndEncoding() {
        assertDoesNotThrow(() -> {
            CpioArchiveInputStream cpio = new CpioArchiveInputStream(inputStream, 512, ENCODING);
            assertNotNull(cpio);
        });
    }

    @Test
    public void testConstructorWithInputStreamAndInvalidEncoding() {
        assertThrows(UnsupportedCharsetException.class, () -> {
            new CpioArchiveInputStream(inputStream, "Invalid-Encoding");
        });
    }
}
