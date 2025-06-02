package org.apache.commons.compress.archivers.tar;

import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static java.nio.charset.StandardCharsets.UTF_8;
import java.io.File;
import java.io.IOException;
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
import org.apache.commons.compress.utils.FixedLengthBlockOutputStream;
import org.apache.commons.compress.utils.TimeUtils;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.file.attribute.FileTimes;
import org.apache.commons.io.output.CountingOutputStream;
import org.apache.commons.lang3.ArrayFill;

class TarArchiveOutputStream_TarArchiveOutputStream_32_0_Test {

    private ByteArrayOutputStream outputStream;

    private TarArchiveOutputStream tarArchiveOutputStream;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
    }

    @Test
    void testConstructorWithValidBlockSize() {
        // Example valid block size
        int blockSize = 1024;
        tarArchiveOutputStream = new TarArchiveOutputStream(outputStream, blockSize);
        assertNotNull(tarArchiveOutputStream);
        assertEquals(0, tarArchiveOutputStream.getBytesWritten());
    }

    @Test
    void testConstructorWithNegativeBlockSize() {
        // Invalid block size
        int blockSize = -1;
        tarArchiveOutputStream = new TarArchiveOutputStream(outputStream, blockSize);
        assertNotNull(tarArchiveOutputStream);
        assertEquals(0, tarArchiveOutputStream.getBytesWritten());
    }

    @Test
    void testConstructorWithZeroBlockSize() {
        // Edge case block size
        int blockSize = 0;
        tarArchiveOutputStream = new TarArchiveOutputStream(outputStream, blockSize);
        assertNotNull(tarArchiveOutputStream);
        assertEquals(0, tarArchiveOutputStream.getBytesWritten());
    }

    @Test
    void testConstructorWithLargeBlockSize() {
        // Testing with a large block size
        int blockSize = Integer.MAX_VALUE;
        tarArchiveOutputStream = new TarArchiveOutputStream(outputStream, blockSize);
        assertNotNull(tarArchiveOutputStream);
        assertEquals(0, tarArchiveOutputStream.getBytesWritten());
    }

    @Test
    void testGetBytesWritten() {
        // Valid block size
        int blockSize = 512;
        tarArchiveOutputStream = new TarArchiveOutputStream(outputStream, blockSize);
        assertEquals(0, tarArchiveOutputStream.getBytesWritten());
    }
}
