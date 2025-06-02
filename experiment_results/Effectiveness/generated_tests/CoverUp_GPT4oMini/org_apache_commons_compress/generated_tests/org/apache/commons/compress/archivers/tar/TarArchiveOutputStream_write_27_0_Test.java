package org.apache.commons.compress.archivers.tar;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
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

public class TarArchiveOutputStream_write_27_0_Test {

    private ByteArrayOutputStream byteArrayOutputStream;

    private TarArchiveOutputStream tarArchiveOutputStream;

    @BeforeEach
    public void setUp() {
        byteArrayOutputStream = new ByteArrayOutputStream();
        tarArchiveOutputStream = new TarArchiveOutputStream(byteArrayOutputStream);
    }

    @Test
    public void testWriteNoCurrentEntry() {
        byte[] data = new byte[10];
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            tarArchiveOutputStream.write(data, 0, data.length);
        });
        assertEquals("No current tar entry", exception.getMessage());
    }

    @Test
    public void testWriteExceedsCurrentSize() throws IOException {
        setCurrentEntry(10);
        byte[] data = new byte[15];
        Exception exception = assertThrows(IOException.class, () -> {
            tarArchiveOutputStream.write(data, 0, data.length);
        });
        assertEquals("Request to write '15' bytes exceeds size in header of '10' bytes for entry 'testEntry'", exception.getMessage());
    }

    @Test
    public void testWriteSuccessful() throws IOException {
        setCurrentEntry(10);
        byte[] data = "HelloWorld".getBytes();
        tarArchiveOutputStream.write(data, 0, data.length);
        assertEquals(data.length, tarArchiveOutputStream.getBytesWritten());
    }

    private void setCurrentEntry(long size) throws IOException {
        try {
            java.lang.reflect.Field currSizeField = TarArchiveOutputStream.class.getDeclaredField("currSize");
            currSizeField.setAccessible(true);
            currSizeField.set(tarArchiveOutputStream, size);
            java.lang.reflect.Field currBytesField = TarArchiveOutputStream.class.getDeclaredField("currBytes");
            currBytesField.setAccessible(true);
            currBytesField.set(tarArchiveOutputStream, 0);
            java.lang.reflect.Field haveUnclosedEntryField = TarArchiveOutputStream.class.getDeclaredField("haveUnclosedEntry");
            haveUnclosedEntryField.setAccessible(true);
            haveUnclosedEntryField.set(tarArchiveOutputStream, true);
            java.lang.reflect.Field currNameField = TarArchiveOutputStream.class.getDeclaredField("currName");
            currNameField.setAccessible(true);
            currNameField.set(tarArchiveOutputStream, "testEntry");
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new IOException("Failed to set current entry", e);
        }
    }
}
