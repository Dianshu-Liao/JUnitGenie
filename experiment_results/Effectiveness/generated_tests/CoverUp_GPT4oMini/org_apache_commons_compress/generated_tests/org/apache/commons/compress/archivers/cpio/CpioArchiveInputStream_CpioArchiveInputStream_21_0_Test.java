package org.apache.commons.compress.archivers.cpio;

import org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.EOFException;
import java.nio.charset.UnsupportedCharsetException;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
import org.apache.commons.compress.utils.ArchiveUtils;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.ParsingUtils;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class CpioArchiveInputStream_CpioArchiveInputStream_21_0_Test {

    private static final String VALID_ENCODING = "UTF-8";

    private static final String INVALID_ENCODING = "INVALID_ENCODING";

    private static final int VALID_BLOCK_SIZE = 512;

    private static final int INVALID_BLOCK_SIZE = 0;

    private InputStream validInputStream;

    private InputStream emptyInputStream;

    @BeforeEach
    void setUp() {
        validInputStream = new ByteArrayInputStream(new byte[] { 0, 1, 2, 3, 4, 5 });
        emptyInputStream = new ByteArrayInputStream(new byte[] {});
    }

    @Test
    void testConstructorWithValidParameters() {
        assertDoesNotThrow(() -> {
            CpioArchiveInputStream cpioInputStream = new CpioArchiveInputStream(validInputStream, VALID_BLOCK_SIZE, VALID_ENCODING);
            assertNotNull(cpioInputStream);
        });
    }

    @Test
    void testConstructorWithInvalidBlockSize() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new CpioArchiveInputStream(validInputStream, INVALID_BLOCK_SIZE, VALID_ENCODING);
        });
        assertEquals("blockSize must be bigger than 0", exception.getMessage());
    }

    @Test
    void testConstructorWithInvalidEncoding() {
        assertThrows(UnsupportedCharsetException.class, () -> {
            new CpioArchiveInputStream(validInputStream, VALID_BLOCK_SIZE, INVALID_ENCODING);
        });
    }

    @Test
    void testConstructorWithEmptyInputStream() {
        assertDoesNotThrow(() -> {
            CpioArchiveInputStream cpioInputStream = new CpioArchiveInputStream(emptyInputStream, VALID_BLOCK_SIZE, VALID_ENCODING);
            assertNotNull(cpioInputStream);
        });
    }
}
