package org.apache.commons.compress.archivers.cpio;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;

public class CpioArchiveOutputStream_write_8_0_Test {

    private CpioArchiveOutputStream cpioOutputStream;

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        cpioOutputStream = new CpioArchiveOutputStream(outputStream);
    }

    @Test
    public void testWrite_ValidInput() throws IOException {
        setEntry(new CpioArchiveEntry("testEntry", 10));
        cpioOutputStream.write(new byte[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, 0, 10);
        assertEquals(10, outputStream.size());
    }

    @Test
    public void testWrite_NoCurrentEntry() {
        assertThrows(IOException.class, () -> {
            cpioOutputStream.write(new byte[] { 1, 2, 3 }, 0, 3);
        });
    }

    @Test
    public void testWrite_ExceedingEntrySize() throws IOException {
        setEntry(new CpioArchiveEntry("testEntry", 5));
        assertThrows(IOException.class, () -> {
            cpioOutputStream.write(new byte[] { 1, 2, 3, 4, 5, 6 }, 0, 6);
        });
    }

    @Test
    public void testWrite_NegativeOffset() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            cpioOutputStream.write(new byte[] { 1, 2, 3 }, -1, 3);
        });
    }

    @Test
    public void testWrite_NegativeLength() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            cpioOutputStream.write(new byte[] { 1, 2, 3 }, 0, -1);
        });
    }

    @Test
    public void testWrite_LengthExceedsArray() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            cpioOutputStream.write(new byte[] { 1, 2, 3 }, 1, 3);
        });
    }

    @Test
    public void testWrite_ZeroLength() throws IOException {
        setEntry(new CpioArchiveEntry("testEntry", 10));
        cpioOutputStream.write(new byte[] { 1, 2, 3 }, 0, 0);
        assertEquals(0, outputStream.size());
    }

    @Test
    public void testWrite_ValidInputWithCRC() throws IOException {
        setEntry(new CpioArchiveEntry("testEntry", 10));
        // Fixed buggy line
        invokeSetFormat(cpioOutputStream, (short) 1);
        cpioOutputStream.write(new byte[] { 1, 2, 3, 4, 5 }, 0, 5);
        assertEquals(5, outputStream.size());
        // CRC should be 1+2+3+4+5
        assertEquals(15, getCRCValue(cpioOutputStream));
    }

    private void setEntry(CpioArchiveEntry entry) {
        try {
            Field field = CpioArchiveOutputStream.class.getDeclaredField("entry");
            field.setAccessible(true);
            field.set(cpioOutputStream, entry);
        } catch (Exception e) {
            fail("Failed to set entry: " + e.getMessage());
        }
    }

    private void invokeSetFormat(CpioArchiveOutputStream stream, short format) {
        try {
            Field field = CpioArchiveOutputStream.class.getDeclaredField("entry");
            field.setAccessible(true);
            CpioArchiveEntry entry = (CpioArchiveEntry) field.get(stream);
            Field formatField = CpioArchiveEntry.class.getDeclaredField("format");
            formatField.setAccessible(true);
            formatField.set(entry, format);
        } catch (Exception e) {
            fail("Failed to set format: " + e.getMessage());
        }
    }

    private long getCRCValue(CpioArchiveOutputStream stream) {
        try {
            Field field = CpioArchiveOutputStream.class.getDeclaredField("crc");
            field.setAccessible(true);
            return field.getLong(stream);
        } catch (Exception e) {
            fail("Failed to get CRC value: " + e.getMessage());
            return -1;
        }
    }
}
