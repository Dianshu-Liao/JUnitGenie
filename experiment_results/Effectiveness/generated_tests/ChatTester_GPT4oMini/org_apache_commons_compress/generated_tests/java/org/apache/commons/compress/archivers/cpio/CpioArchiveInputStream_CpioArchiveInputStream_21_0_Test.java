package org.apache.commons.compress.archivers.cpio;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.EOFException;
import java.io.IOException;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
import org.apache.commons.compress.utils.ArchiveUtils;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.ParsingUtils;

class CpioArchiveInputStream_CpioArchiveInputStream_21_0_Test {

    private InputStream validInputStream;

    private String validEncoding;

    private int validBlockSize;

    @BeforeEach
    void setUp() {
        validInputStream = new ByteArrayInputStream(new byte[] { 1, 2, 3 });
        validEncoding = "UTF-8";
        // a valid block size
        validBlockSize = 1024;
    }

    @Test
    void testConstructorWithValidParameters() {
        CpioArchiveInputStream archiveInputStream = new CpioArchiveInputStream(validInputStream, validBlockSize, validEncoding);
        assertNotNull(archiveInputStream);
    }

    @Test
    void testConstructorWithZeroBlockSize() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new CpioArchiveInputStream(validInputStream, 0, validEncoding);
        });
        assertEquals("blockSize must be bigger than 0", exception.getMessage());
    }

    @Test
    void testConstructorWithNegativeBlockSize() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new CpioArchiveInputStream(validInputStream, -1, validEncoding);
        });
        assertEquals("blockSize must be bigger than 0", exception.getMessage());
    }

    @Test
    void testConstructorWithNullInputStream() {
        assertThrows(NullPointerException.class, () -> {
            new CpioArchiveInputStream(null, validBlockSize, validEncoding);
        });
    }

    @Test
    void testConstructorWithNullEncoding() {
        CpioArchiveInputStream archiveInputStream = new CpioArchiveInputStream(validInputStream, validBlockSize, null);
        assertNotNull(archiveInputStream);
    }
}
