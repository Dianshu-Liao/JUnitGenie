package org.apache.commons.compress.archivers.tar;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
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

class TarArchiveOutputStream_TarArchiveOutputStream_36_0_Test {

    private OutputStream outputStream;

    private TarArchiveOutputStream tarArchiveOutputStream;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        tarArchiveOutputStream = new TarArchiveOutputStream(outputStream, "UTF-8");
    }

    @Test
    void testConstructorWithValidParameters() {
        assertNotNull(tarArchiveOutputStream);
    }

    @Test
    void testConstructorWithNullOutputStream() {
        assertThrows(NullPointerException.class, () -> {
            new TarArchiveOutputStream(null, "UTF-8");
        });
    }

    @Test
    void testConstructorWithEmptyCharset() {
        assertThrows(IllegalArgumentException.class, () -> {
            new TarArchiveOutputStream(outputStream, "");
        });
    }

    @Test
    void testGetBytesWrittenInitially() {
        assertEquals(0, tarArchiveOutputStream.getBytesWritten());
    }

    @Test
    void testSetAddPaxHeadersForNonAsciiNames() {
        tarArchiveOutputStream.setAddPaxHeadersForNonAsciiNames(true);
        assertTrue((Boolean) getPrivateField(tarArchiveOutputStream, "addPaxHeadersForNonAsciiNames"));
    }

    @Test
    void testSetBigNumberMode() {
        tarArchiveOutputStream.setBigNumberMode(2);
        assertEquals(2, getPrivateField(tarArchiveOutputStream, "bigNumberMode"));
    }

    @Test
    void testSetLongFileMode() {
        tarArchiveOutputStream.setLongFileMode(1);
        assertEquals(1, getPrivateField(tarArchiveOutputStream, "longFileMode"));
    }

    private Object getPrivateField(Object obj, String fieldName) {
        try {
            Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(obj);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Failed to access private field: " + e.getMessage());
            return null;
        }
    }
}
