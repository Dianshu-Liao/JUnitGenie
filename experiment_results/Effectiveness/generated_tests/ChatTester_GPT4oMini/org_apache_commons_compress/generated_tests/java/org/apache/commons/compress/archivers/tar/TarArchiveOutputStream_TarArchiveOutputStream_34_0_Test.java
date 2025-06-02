package org.apache.commons.compress.archivers.tar;

import java.io.OutputStream;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Constructor;
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

public class TarArchiveOutputStream_TarArchiveOutputStream_34_0_Test {

    private OutputStream outputStream;

    private Class<?> tarArchiveOutputStreamClass;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        tarArchiveOutputStreamClass = TarArchiveOutputStream.class;
    }

    @Test
    public void testConstructorWithValidParameters() throws Exception {
        Constructor<?> constructor = tarArchiveOutputStreamClass.getDeclaredConstructor(OutputStream.class, int.class, int.class, String.class);
        constructor.setAccessible(true);
        // Test with valid parameters
        TarArchiveOutputStream tarOutputStream = (TarArchiveOutputStream) constructor.newInstance(outputStream, 512, 512, "UTF-8");
        assertNotNull(tarOutputStream);
    }

    @Test
    public void testConstructorWithInvalidRecordSize() throws Exception {
        Constructor<?> constructor = tarArchiveOutputStreamClass.getDeclaredConstructor(OutputStream.class, int.class, int.class, String.class);
        constructor.setAccessible(true);
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            constructor.newInstance(outputStream, 512, 1024, "UTF-8");
        });
        assertEquals("Tar record size must always be 512 bytes. Attempt to set size of 1024", thrown.getMessage());
    }

    @Test
    public void testConstructorWithNegativeBlockSize() throws Exception {
        Constructor<?> constructor = tarArchiveOutputStreamClass.getDeclaredConstructor(OutputStream.class, int.class, int.class, String.class);
        constructor.setAccessible(true);
        // Test with negative block size
        TarArchiveOutputStream tarOutputStream = (TarArchiveOutputStream) constructor.newInstance(outputStream, -1, 512, "UTF-8");
        assertNotNull(tarOutputStream);
    }
}
