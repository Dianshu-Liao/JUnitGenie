// Test method
package org.apache.commons.compress.archivers.tar;

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
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
import org.apache.commons.compress.utils.FixedLengthBlockOutputStream;
import org.apache.commons.compress.utils.TimeUtils;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.file.attribute.FileTimes;
import org.apache.commons.io.output.CountingOutputStream;
import org.apache.commons.lang3.ArrayFill;

public class TarArchiveOutputStream_write_27_0_Test {

    private ByteArrayOutputStream byteArrayOutputStream;

    private TarArchiveOutputStream tarArchiveOutputStream;

    @BeforeEach
    public void setUp() {
        byteArrayOutputStream = new ByteArrayOutputStream();
        tarArchiveOutputStream = new TarArchiveOutputStream(byteArrayOutputStream);
        // Set up the state to simulate an open entry
        setHaveUnclosedEntry(true);
        setCurrSize(10);
        setCurrName("testEntry");
    }

    private void setHaveUnclosedEntry(boolean value) {
        try {
            Field field = TarArchiveOutputStream.class.getDeclaredField("haveUnclosedEntry");
            field.setAccessible(true);
            field.set(tarArchiveOutputStream, value);
        } catch (Exception e) {
            fail("Failed to set haveUnclosedEntry: " + e.getMessage());
        }
    }

    private void setCurrSize(long size) {
        try {
            Field field = TarArchiveOutputStream.class.getDeclaredField("currSize");
            field.setAccessible(true);
            field.set(tarArchiveOutputStream, size);
        } catch (Exception e) {
            fail("Failed to set currSize: " + e.getMessage());
        }
    }

    private void setCurrName(String name) {
        try {
            Field field = TarArchiveOutputStream.class.getDeclaredField("currName");
            field.setAccessible(true);
            field.set(tarArchiveOutputStream, name);
        } catch (Exception e) {
            fail("Failed to set currName: " + e.getMessage());
        }
    }

    @Test
    public void testWriteWithNoCurrentEntry() {
        setHaveUnclosedEntry(false);
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            tarArchiveOutputStream.write(new byte[10], 0, 10);
        });
        assertEquals("No current tar entry", exception.getMessage());
    }

    @Test
    public void testWriteExceedsCurrSize() {
        byte[] data = new byte[15];
        Exception exception = assertThrows(IOException.class, () -> {
            tarArchiveOutputStream.write(data, 0, data.length);
        });
        assertEquals("Request to write '15' bytes exceeds size in header of '10' bytes for entry 'testEntry'", exception.getMessage());
    }

    @Test
    public void testWriteSuccessful() throws IOException {
        byte[] data = new byte[5];
        tarArchiveOutputStream.write(data, 0, data.length);
        assertEquals(5, byteArrayOutputStream.size());
    }

    @Test
    public void testWriteExactlyCurrSize() throws IOException {
        byte[] data = new byte[10];
        tarArchiveOutputStream.write(data, 0, data.length);
        assertEquals(10, byteArrayOutputStream.size());
    }

    @Test
    public void testWritePartialData() throws IOException {
        // Writing less than current size
        byte[] data = new byte[8];
        tarArchiveOutputStream.write(data, 0, 8);
        assertEquals(8, byteArrayOutputStream.size());
    }

    @Test
    public void testWriteZeroBytes() throws IOException {
        // Writing zero bytes
        byte[] data = new byte[0];
        tarArchiveOutputStream.write(data, 0, 0);
        assertEquals(0, byteArrayOutputStream.size());
    }
}
