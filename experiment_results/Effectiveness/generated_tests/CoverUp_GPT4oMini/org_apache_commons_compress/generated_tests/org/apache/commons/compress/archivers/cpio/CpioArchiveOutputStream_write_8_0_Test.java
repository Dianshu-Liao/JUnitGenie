package org.apache.commons.compress.archivers.cpio;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.apache.commons.compress.archivers.cpio.CpioArchiveEntry;
import org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
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

class CpioArchiveOutputStream_write_8_0_Test {

    private CpioArchiveOutputStream cpioOutputStream;

    private ByteArrayOutputStream byteArrayOutputStream;

    @BeforeEach
    void setUp() {
        byteArrayOutputStream = new ByteArrayOutputStream();
        cpioOutputStream = new CpioArchiveOutputStream(byteArrayOutputStream, (short) 1);
    }

    @Test
    void testWriteWithValidParameters() throws IOException {
        CpioArchiveEntry entry = new CpioArchiveEntry((short) 1, "test.txt", 10);
        invokeSetEntry(cpioOutputStream, entry);
        byte[] data = new byte[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        cpioOutputStream.write(data, 0, 10);
        assertEquals(10, byteArrayOutputStream.size());
    }

    @Test
    void testWriteWithZeroLength() throws IOException {
        CpioArchiveEntry entry = new CpioArchiveEntry((short) 1, "test.txt", 0);
        invokeSetEntry(cpioOutputStream, entry);
        cpioOutputStream.write(new byte[0], 0, 0);
        assertEquals(0, byteArrayOutputStream.size());
    }

    @Test
    void testWriteThrowsIOExceptionWhenNoCurrentEntry() {
        assertThrows(IOException.class, () -> {
            cpioOutputStream.write(new byte[] { 1, 2, 3 }, 0, 3);
        });
    }

    @Test
    void testWriteThrowsIOExceptionWhenWritingPastEntrySize() throws IOException {
        CpioArchiveEntry entry = new CpioArchiveEntry((short) 1, "test.txt", 5);
        invokeSetEntry(cpioOutputStream, entry);
        assertThrows(IOException.class, () -> {
            cpioOutputStream.write(new byte[] { 1, 2, 3, 4, 5, 6 }, 0, 6);
        });
    }

    @Test
    void testWriteThrowsIndexOutOfBoundsException() {
        byte[] data = new byte[5];
        assertThrows(IndexOutOfBoundsException.class, () -> {
            cpioOutputStream.write(data, -1, 5);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            cpioOutputStream.write(data, 0, 6);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            cpioOutputStream.write(data, 3, 3);
        });
    }

    private void invokeSetEntry(CpioArchiveOutputStream cpioOutputStream, CpioArchiveEntry entry) {
        try {
            Field field = CpioArchiveOutputStream.class.getDeclaredField("entry");
            field.setAccessible(true);
            field.set(cpioOutputStream, entry);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
