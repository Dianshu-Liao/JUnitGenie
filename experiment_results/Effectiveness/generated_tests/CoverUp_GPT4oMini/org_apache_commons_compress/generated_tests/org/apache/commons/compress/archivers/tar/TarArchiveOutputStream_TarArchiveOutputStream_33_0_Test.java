package org.apache.commons.compress.archivers.tar;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
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
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class TarArchiveOutputStream_TarArchiveOutputStream_33_0_Test {

    private ByteArrayOutputStream outputStream;

    private TarArchiveOutputStream tarArchiveOutputStream;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
    }

    @Test
    void testConstructorWithValidParameters() throws IOException {
        tarArchiveOutputStream = new TarArchiveOutputStream(outputStream, 1024, 512);
        assertNotNull(tarArchiveOutputStream);
    }

    @Test
    void testConstructorWithNegativeBlockSize() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            tarArchiveOutputStream = new TarArchiveOutputStream(outputStream, -1, 512);
        });
        assertEquals("Block size must be positive", exception.getMessage());
    }

    @Test
    void testConstructorWithNegativeRecordSize() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            tarArchiveOutputStream = new TarArchiveOutputStream(outputStream, 1024, -1);
        });
        assertEquals("Record size must be positive", exception.getMessage());
    }

    @Test
    void testGetBytesWritten() throws IOException {
        tarArchiveOutputStream = new TarArchiveOutputStream(outputStream, 1024, 512);
        assertEquals(0, tarArchiveOutputStream.getBytesWritten());
        // Simulate writing data
        outputStream.write(new byte[100]);
        assertEquals(100, tarArchiveOutputStream.getBytesWritten());
    }

    @Test
    void testSetAddPaxHeadersForNonAsciiNames() throws Exception {
        tarArchiveOutputStream = new TarArchiveOutputStream(outputStream, 1024, 512);
        tarArchiveOutputStream.setAddPaxHeadersForNonAsciiNames(true);
        // Use reflection to access private field
        java.lang.reflect.Field field = TarArchiveOutputStream.class.getDeclaredField("addPaxHeadersForNonAsciiNames");
        field.setAccessible(true);
        assertTrue(field.getBoolean(tarArchiveOutputStream));
    }

    @Test
    void testSetBigNumberMode() throws Exception {
        tarArchiveOutputStream = new TarArchiveOutputStream(outputStream, 1024, 512);
        tarArchiveOutputStream.setBigNumberMode(TarArchiveOutputStream.BIGNUMBER_POSIX);
        // Use reflection to verify the value
        java.lang.reflect.Field field = TarArchiveOutputStream.class.getDeclaredField("bigNumberMode");
        field.setAccessible(true);
        assertEquals(TarArchiveOutputStream.BIGNUMBER_POSIX, field.getInt(tarArchiveOutputStream));
    }

    @Test
    void testSetLongFileMode() throws Exception {
        tarArchiveOutputStream = new TarArchiveOutputStream(outputStream, 1024, 512);
        tarArchiveOutputStream.setLongFileMode(TarArchiveOutputStream.LONGFILE_GNU);
        // Use reflection to verify the value
        java.lang.reflect.Field field = TarArchiveOutputStream.class.getDeclaredField("longFileMode");
        field.setAccessible(true);
        assertEquals(TarArchiveOutputStream.LONGFILE_GNU, field.getInt(tarArchiveOutputStream));
    }
}
