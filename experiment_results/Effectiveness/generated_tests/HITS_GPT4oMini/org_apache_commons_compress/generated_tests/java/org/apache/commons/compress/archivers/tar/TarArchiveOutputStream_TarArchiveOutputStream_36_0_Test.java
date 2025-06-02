package org.apache.commons.compress.archivers.tar;

import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.charset.UnsupportedCharsetException;
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

class TarArchiveOutputStream_TarArchiveOutputStream_36_0_Test {

    private TarArchiveOutputStream tarArchiveOutputStream;

    private ByteArrayOutputStream byteArrayOutputStream;

    @BeforeEach
    void setUp() {
        byteArrayOutputStream = new ByteArrayOutputStream();
    }

    @Test
    void testConstructorWithValidOutputStreamAndCharset() {
        assertDoesNotThrow(() -> {
            tarArchiveOutputStream = new TarArchiveOutputStream(byteArrayOutputStream, StandardCharsets.UTF_8.name());
        });
        assertNotNull(tarArchiveOutputStream);
    }

    @Test
    void testConstructorWithValidOutputStreamAndNullCharset() {
        assertDoesNotThrow(() -> {
            tarArchiveOutputStream = new TarArchiveOutputStream(byteArrayOutputStream, null);
        });
        assertNotNull(tarArchiveOutputStream);
    }

    @Test
    void testConstructorWithValidOutputStreamAndEmptyCharset() {
        assertDoesNotThrow(() -> {
            tarArchiveOutputStream = new TarArchiveOutputStream(byteArrayOutputStream, "");
        });
        assertNotNull(tarArchiveOutputStream);
    }

    @Test
    void testConstructorWithValidOutputStreamAndInvalidCharset() {
        assertThrows(UnsupportedCharsetException.class, () -> {
            tarArchiveOutputStream = new TarArchiveOutputStream(byteArrayOutputStream, "invalid-charset");
        });
    }

    @Test
    void testConstructorWithOutputStream() {
        assertDoesNotThrow(() -> {
            tarArchiveOutputStream = new TarArchiveOutputStream(byteArrayOutputStream, StandardCharsets.UTF_8.name());
            assertNotNull(tarArchiveOutputStream);
        });
    }

    @Test
    void testConstructorWithOutputStreamAndCharsetName() {
        String charsetName = StandardCharsets.UTF_8.name();
        tarArchiveOutputStream = new TarArchiveOutputStream(byteArrayOutputStream, charsetName);
        assertEquals(charsetName, tarArchiveOutputStream.charsetName);
    }

    @Test
    void testConstructorWithOutputStreamAndASCIICharset() {
        tarArchiveOutputStream = new TarArchiveOutputStream(byteArrayOutputStream, StandardCharsets.US_ASCII.name());
        assertEquals(StandardCharsets.US_ASCII.name(), tarArchiveOutputStream.charsetName);
    }
}
