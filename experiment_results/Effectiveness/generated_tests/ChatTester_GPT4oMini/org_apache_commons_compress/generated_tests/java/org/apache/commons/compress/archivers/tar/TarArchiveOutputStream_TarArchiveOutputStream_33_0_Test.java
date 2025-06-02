package org.apache.commons.compress.archivers.tar;

import java.io.OutputStream;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
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
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
import org.apache.commons.compress.utils.FixedLengthBlockOutputStream;
import org.apache.commons.compress.utils.TimeUtils;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.file.attribute.FileTimes;
import org.apache.commons.io.output.CountingOutputStream;
import org.apache.commons.lang3.ArrayFill;

public class TarArchiveOutputStream_TarArchiveOutputStream_33_0_Test {

    private TarArchiveOutputStream tarArchiveOutputStream;

    private ByteArrayOutputStream byteArrayOutputStream;

    @BeforeEach
    public void setUp() {
        byteArrayOutputStream = new ByteArrayOutputStream();
    }

    @Test
    public void testTarArchiveOutputStreamWithValidParameters() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // Arrange
        int blockSize = 1024;
        int recordSize = 512;
        // Act
        Constructor<TarArchiveOutputStream> constructor = TarArchiveOutputStream.class.getDeclaredConstructor(OutputStream.class, int.class, int.class);
        constructor.setAccessible(true);
        tarArchiveOutputStream = constructor.newInstance(byteArrayOutputStream, blockSize, recordSize);
        // Assert
        assertNotNull(tarArchiveOutputStream);
    }

    @Test
    public void testTarArchiveOutputStreamWithNegativeBlockSize() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // Arrange
        int blockSize = -1;
        int recordSize = 512;
        // Act
        Constructor<TarArchiveOutputStream> constructor = TarArchiveOutputStream.class.getDeclaredConstructor(OutputStream.class, int.class, int.class);
        constructor.setAccessible(true);
        tarArchiveOutputStream = constructor.newInstance(byteArrayOutputStream, blockSize, recordSize);
        // Assert
        assertNotNull(tarArchiveOutputStream);
    }

    @Test
    public void testTarArchiveOutputStreamWithZeroBlockSize() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // Arrange
        int blockSize = 0;
        int recordSize = 512;
        // Act
        Constructor<TarArchiveOutputStream> constructor = TarArchiveOutputStream.class.getDeclaredConstructor(OutputStream.class, int.class, int.class);
        constructor.setAccessible(true);
        tarArchiveOutputStream = constructor.newInstance(byteArrayOutputStream, blockSize, recordSize);
        // Assert
        assertNotNull(tarArchiveOutputStream);
    }

    @Test
    public void testTarArchiveOutputStreamWithLargeRecordSize() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // Arrange
        int blockSize = 1024;
        int recordSize = Integer.MAX_VALUE;
        // Act
        Constructor<TarArchiveOutputStream> constructor = TarArchiveOutputStream.class.getDeclaredConstructor(OutputStream.class, int.class, int.class);
        constructor.setAccessible(true);
        tarArchiveOutputStream = constructor.newInstance(byteArrayOutputStream, blockSize, recordSize);
        // Assert
        assertNotNull(tarArchiveOutputStream);
    }

    @Test
    public void testTarArchiveOutputStreamWithRecordSizeLessThanZero() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // Arrange
        int blockSize = 1024;
        int recordSize = -1;
        // Act
        Constructor<TarArchiveOutputStream> constructor = TarArchiveOutputStream.class.getDeclaredConstructor(OutputStream.class, int.class, int.class);
        constructor.setAccessible(true);
        tarArchiveOutputStream = constructor.newInstance(byteArrayOutputStream, blockSize, recordSize);
        // Assert
        assertNotNull(tarArchiveOutputStream);
    }
}
