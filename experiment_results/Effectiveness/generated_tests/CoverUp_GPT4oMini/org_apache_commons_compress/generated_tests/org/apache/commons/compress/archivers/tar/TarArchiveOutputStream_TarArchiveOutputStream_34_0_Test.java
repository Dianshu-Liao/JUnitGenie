package org.apache.commons.compress.archivers.tar;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static java.nio.charset.StandardCharsets.UTF_8;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
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
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
import org.apache.commons.compress.utils.FixedLengthBlockOutputStream;
import org.apache.commons.compress.utils.TimeUtils;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.file.attribute.FileTimes;
import org.apache.commons.io.output.CountingOutputStream;
import org.apache.commons.lang3.ArrayFill;

@ExtendWith(MockitoExtension.class)
class TarArchiveOutputStream_TarArchiveOutputStream_34_0_Test {

    private OutputStream mockOutputStream;

    private ByteArrayOutputStream byteArrayOutputStream;

    @BeforeEach
    void setUp() {
        byteArrayOutputStream = new ByteArrayOutputStream();
        mockOutputStream = mock(OutputStream.class);
    }

    @Test
    void testConstructorThrowsIllegalArgumentExceptionForInvalidRecordSize() {
        int blockSize = 1024;
        // Invalid record size
        int invalidRecordSize = 1024;
        String encoding = "UTF-8";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new TarArchiveOutputStream(mockOutputStream, blockSize, invalidRecordSize, encoding);
        });
        assertEquals("Tar record size must always be 512 bytes. Attempt to set size of " + invalidRecordSize, exception.getMessage());
    }

    @Test
    void testConstructorInitializesFieldsCorrectly() throws IOException {
        int blockSize = 1024;
        // Valid record size
        int recordSize = 512;
        String encoding = "UTF-8";
        TarArchiveOutputStream tarOutputStream = new TarArchiveOutputStream(mockOutputStream, blockSize, recordSize, encoding);
        assertNotNull(tarOutputStream);
        assertEquals(0, tarOutputStream.getBytesWritten());
    }

    @Test
    void testGetRecordSizeReturnsCorrectValue() {
        TarArchiveOutputStream tarOutputStream = new TarArchiveOutputStream(mockOutputStream);
        assertEquals(512, tarOutputStream.getRecordSize());
    }

    @Test
    void testSetAddPaxHeadersForNonAsciiNames() {
        TarArchiveOutputStream tarOutputStream = new TarArchiveOutputStream(mockOutputStream);
        tarOutputStream.setAddPaxHeadersForNonAsciiNames(true);
        // Using reflection to access private field `addPaxHeadersForNonAsciiNames`
        boolean addPaxHeaders = (boolean) getPrivateField(tarOutputStream, "addPaxHeadersForNonAsciiNames");
        assertTrue(addPaxHeaders);
    }

    @Test
    void testSetLongFileMode() {
        TarArchiveOutputStream tarOutputStream = new TarArchiveOutputStream(mockOutputStream);
        tarOutputStream.setLongFileMode(TarArchiveOutputStream.LONGFILE_GNU);
        // Using reflection to access private field `longFileMode`
        int longFileMode = (int) getPrivateField(tarOutputStream, "longFileMode");
        assertEquals(TarArchiveOutputStream.LONGFILE_GNU, longFileMode);
    }

    @Test
    void testSetBigNumberMode() {
        TarArchiveOutputStream tarOutputStream = new TarArchiveOutputStream(mockOutputStream);
        tarOutputStream.setBigNumberMode(TarArchiveOutputStream.BIGNUMBER_POSIX);
        // Using reflection to access private field `bigNumberMode`
        int bigNumberMode = (int) getPrivateField(tarOutputStream, "bigNumberMode");
        assertEquals(TarArchiveOutputStream.BIGNUMBER_POSIX, bigNumberMode);
    }

    private Object getPrivateField(Object obj, String fieldName) {
        try {
            Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
