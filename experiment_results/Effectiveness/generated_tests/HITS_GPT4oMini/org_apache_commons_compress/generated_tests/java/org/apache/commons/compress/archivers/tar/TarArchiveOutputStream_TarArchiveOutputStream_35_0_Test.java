package org.apache.commons.compress.archivers.tar;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
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
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.utils.FixedLengthBlockOutputStream;
import org.apache.commons.compress.utils.TimeUtils;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.file.attribute.FileTimes;
import org.apache.commons.io.output.CountingOutputStream;
import org.apache.commons.lang3.ArrayFill;

public class TarArchiveOutputStream_TarArchiveOutputStream_35_0_Test {

    @Test
    public void testConstructorWithValidParameters() throws IOException {
        // Arrange
        OutputStream outputStream = new ByteArrayOutputStream();
        // Valid block size
        int blockSize = 1024;
        // Valid charset
        String charset = "UTF-8";
        // Act
        TarArchiveOutputStream tarOutputStream = new TarArchiveOutputStream(outputStream, blockSize, charset);
        // Assert
        assertNotNull(tarOutputStream);
    }

    @Test
    public void testConstructorWithInvalidBlockSize() {
        // Arrange
        OutputStream outputStream = new ByteArrayOutputStream();
        // Invalid block size (not a multiple of 512)
        int blockSize = 1023;
        // Valid charset
        String charset = "UTF-8";
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new TarArchiveOutputStream(outputStream, blockSize, charset);
        });
    }

    @Test
    public void testConstructorWithNegativeBlockSize() {
        // Arrange
        OutputStream outputStream = new ByteArrayOutputStream();
        // Invalid block size
        int blockSize = -512;
        // Valid charset
        String charset = "UTF-8";
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new TarArchiveOutputStream(outputStream, blockSize, charset);
        });
    }

    @Test
    public void testConstructorWithZeroBlockSize() {
        // Arrange
        OutputStream outputStream = new ByteArrayOutputStream();
        // Invalid block size
        int blockSize = 0;
        // Valid charset
        String charset = "UTF-8";
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new TarArchiveOutputStream(outputStream, blockSize, charset);
        });
    }

    @Test
    public void testConstructorWithNullCharset() {
        // Arrange
        OutputStream outputStream = new ByteArrayOutputStream();
        // Valid block size
        int blockSize = 1024;
        // Invalid charset
        String charset = null;
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new TarArchiveOutputStream(outputStream, blockSize, charset);
        });
    }
}
