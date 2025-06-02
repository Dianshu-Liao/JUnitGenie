package org.apache.commons.compress.archivers.tar;

import java.io.ByteArrayOutputStream;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static java.nio.charset.StandardCharsets.UTF_8;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
import org.apache.commons.compress.utils.FixedLengthBlockOutputStream;
import org.apache.commons.compress.utils.TimeUtils;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.file.attribute.FileTimes;
import org.apache.commons.io.output.CountingOutputStream;
import org.apache.commons.lang3.ArrayFill;

class TarArchiveOutputStream_TarArchiveOutputStream_35_0_Test {

    private ByteArrayOutputStream byteArrayOutputStream;

    private TarArchiveOutputStream tarArchiveOutputStream;

    @BeforeEach
    void setUp() {
        byteArrayOutputStream = new ByteArrayOutputStream();
    }

    @Test
    void testConstructorWithValidBlockSizeAndCharset() {
        // Test with a valid block size that is a multiple of RECORD_SIZE
        assertDoesNotThrow(() -> {
            tarArchiveOutputStream = new TarArchiveOutputStream(byteArrayOutputStream, 1024, "UTF-8");
        });
    }

    @Test
    void testConstructorWithUnspecifiedBlockSize() {
        // Test with BLOCK_SIZE_UNSPECIFIED
        assertDoesNotThrow(() -> {
            // Fixed Buggy Line: Accessing BLOCK_SIZE_UNSPECIFIED using reflection
            java.lang.reflect.Field field = TarArchiveOutputStream.class.getDeclaredField("BLOCK_SIZE_UNSPECIFIED");
            field.setAccessible(true);
            int blockSizeUnspecified = (int) field.get(null);
            tarArchiveOutputStream = new TarArchiveOutputStream(byteArrayOutputStream, blockSizeUnspecified, "UTF-8");
        });
    }

    @Test
    void testConstructorWithInvalidBlockSize() {
        // Test with an invalid block size (negative)
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            tarArchiveOutputStream = new TarArchiveOutputStream(byteArrayOutputStream, -512, "UTF-8");
        });
        assertEquals("Block size must be a multiple of 512 bytes. Attempt to use set size of -512", exception.getMessage());
    }

    @Test
    void testConstructorWithNonMultipleBlockSize() {
        // Test with a block size that is not a multiple of RECORD_SIZE
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            tarArchiveOutputStream = new TarArchiveOutputStream(byteArrayOutputStream, 600, "UTF-8");
        });
        assertEquals("Block size must be a multiple of 512 bytes. Attempt to use set size of 600", exception.getMessage());
    }

    @Test
    void testConstructorWithNullCharset() {
        // Test with a null charset
        assertThrows(NullPointerException.class, () -> {
            tarArchiveOutputStream = new TarArchiveOutputStream(byteArrayOutputStream, 1024, null);
        });
    }

    @Test
    void testConstructorWithEmptyCharset() {
        // Test with an empty charset
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            tarArchiveOutputStream = new TarArchiveOutputStream(byteArrayOutputStream, 1024, "");
        });
        assertEquals("Charset cannot be empty", exception.getMessage());
    }

    @Test
    void testConstructorWithValidCharset() {
        // Test with a valid charset
        assertDoesNotThrow(() -> {
            tarArchiveOutputStream = new TarArchiveOutputStream(byteArrayOutputStream, 1024, "UTF-8");
            assertNotNull(tarArchiveOutputStream);
        });
    }

    @Test
    void testConstructorWithUnsupportedCharset() {
        // Test with an unsupported charset
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            tarArchiveOutputStream = new TarArchiveOutputStream(byteArrayOutputStream, 1024, "unsupported-charset");
        });
        assertEquals("Charset 'unsupported-charset' is not supported", exception.getMessage());
    }
}
