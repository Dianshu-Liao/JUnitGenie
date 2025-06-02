package org.apache.commons.compress.archivers.tar;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static java.nio.charset.StandardCharsets.UTF_8;
import java.io.File;
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

public class TarArchiveOutputStream_TarArchiveOutputStream_35_0_Test {

    private OutputStream mockOutputStream;

    private ByteArrayOutputStream byteArrayOutputStream;

    @BeforeEach
    public void setUp() {
        mockOutputStream = mock(OutputStream.class);
        byteArrayOutputStream = new ByteArrayOutputStream();
    }

    @Test
    public void testConstructorWithValidParameters() throws IOException {
        TarArchiveOutputStream tarOutputStream = new TarArchiveOutputStream(mockOutputStream, 1024, "UTF-8");
        assertNotNull(tarOutputStream);
    }

    @Test
    public void testConstructorWithInvalidBlockSize() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new TarArchiveOutputStream(mockOutputStream, 0, "UTF-8");
        });
        assertTrue(exception.getMessage().contains("Block size must be a multiple of 512 bytes"));
    }

    @Test
    public void testConstructorWithNegativeBlockSize() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new TarArchiveOutputStream(mockOutputStream, -512, "UTF-8");
        });
        assertTrue(exception.getMessage().contains("Block size must be a multiple of 512 bytes"));
    }

    @Test
    public void testConstructorWithUnspecifiedBlockSize() throws IOException {
        TarArchiveOutputStream tarOutputStream = new TarArchiveOutputStream(mockOutputStream, -511, "UTF-8");
        assertNotNull(tarOutputStream);
    }

    @Test
    public void testGetBytesWritten() throws IOException {
        TarArchiveOutputStream tarOutputStream = new TarArchiveOutputStream(byteArrayOutputStream, 1024, "UTF-8");
        byte[] data = "Hello, World!".getBytes();
        byteArrayOutputStream.write(data);
        assertEquals(data.length, tarOutputStream.getBytesWritten());
    }

    @Test
    public void testSetAddPaxHeadersForNonAsciiNames() {
        TarArchiveOutputStream tarOutputStream = new TarArchiveOutputStream(mockOutputStream, 1024, "UTF-8");
        tarOutputStream.setAddPaxHeadersForNonAsciiNames(true);
        // Verify internal state if needed using reflection (not shown here)
    }

    @Test
    public void testSetBigNumberMode() {
        TarArchiveOutputStream tarOutputStream = new TarArchiveOutputStream(mockOutputStream, 1024, "UTF-8");
        tarOutputStream.setBigNumberMode(1);
        // Verify internal state if needed using reflection (not shown here)
    }

    @Test
    public void testSetLongFileMode() {
        TarArchiveOutputStream tarOutputStream = new TarArchiveOutputStream(mockOutputStream, 1024, "UTF-8");
        tarOutputStream.setLongFileMode(2);
        // Verify internal state if needed using reflection (not shown here)
    }
}
