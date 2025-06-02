package org.apache.commons.compress.archivers.tar;

import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
import org.apache.commons.io.output.CountingOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static java.nio.charset.StandardCharsets.UTF_8;
import java.io.File;
import java.io.OutputStream;
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
import org.apache.commons.lang3.ArrayFill;

public class TarArchiveOutputStream_write_27_0_Test {

    private TarArchiveOutputStream tarArchiveOutputStream;

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() throws Exception {
        outputStream = new ByteArrayOutputStream();
        CountingOutputStream countingOutputStream = new CountingOutputStream(outputStream);
        tarArchiveOutputStream = new TarArchiveOutputStream(countingOutputStream);
        // Use reflection to set private fields
        setPrivateField(tarArchiveOutputStream, "currSize", 10L);
        setPrivateField(tarArchiveOutputStream, "currBytes", 0L);
        setPrivateField(tarArchiveOutputStream, "currName", "testEntry");
        setPrivateField(tarArchiveOutputStream, "haveUnclosedEntry", true);
    }

    private void setPrivateField(Object obj, String fieldName, Object value) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }

    @Test
    public void testWriteWithinSize() throws IOException {
        byte[] data = "HelloWorld".getBytes();
        tarArchiveOutputStream.write(data, 0, 10);
        // Check that the written bytes match the expected output
        assertEquals("HelloWorld", outputStream.toString());
    }

    @Test
    public void testWriteExceedsSizeThrowsIOException() {
        byte[] data = "HelloWorld".getBytes();
        assertThrows(IOException.class, () -> {
            tarArchiveOutputStream.write(data, 0, 20);
        });
    }

    @Test
    public void testWriteWithoutOpenEntryThrowsIllegalStateException() throws Exception {
        setPrivateField(tarArchiveOutputStream, "haveUnclosedEntry", false);
        byte[] data = "HelloWorld".getBytes();
        assertThrows(IllegalStateException.class, () -> {
            tarArchiveOutputStream.write(data, 0, 10);
        });
    }

    @Test
    public void testWriteZeroBytes() throws IOException {
        byte[] data = "HelloWorld".getBytes();
        tarArchiveOutputStream.write(data, 0, 0);
        // Ensure no data was written
        assertTrue(outputStream.toString().isEmpty());
    }
}
