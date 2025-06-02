package org.apache.commons.compress.archivers.tar;

import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
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

public class TarArchiveOutputStream_TarArchiveOutputStream_34_0_Test {

    private ByteArrayOutputStream outputStream;

    // example block size
    private static final int BLOCK_SIZE = 512;

    private static final String ENCODING = "US-ASCII";

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
    }

    @Test
    public void testConstructorWithValidParameters() {
        TarArchiveOutputStream tarOutputStream = new TarArchiveOutputStream(outputStream, BLOCK_SIZE, 512, ENCODING);
        // Here you can add assertions to check the state of tarOutputStream if needed
    }

    @Test
    public void testConstructorWithInvalidRecordSize() {
        // invalid record size
        int invalidRecordSize = 1024;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new TarArchiveOutputStream(outputStream, BLOCK_SIZE, invalidRecordSize, ENCODING);
        });
        assertEquals("Tar record size must always be 512 bytes. Attempt to set size of " + invalidRecordSize, exception.getMessage());
    }

    @Test
    public void testConstructorWithNullOutputStream() {
        assertThrows(NullPointerException.class, () -> {
            new TarArchiveOutputStream(null, BLOCK_SIZE, 512, ENCODING);
        });
    }

    @Test
    public void testConstructorWithNegativeBlockSize() {
        assertThrows(IllegalArgumentException.class, () -> {
            new TarArchiveOutputStream(outputStream, -1, 512, ENCODING);
        });
    }
}
