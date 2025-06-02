package org.apache.commons.compress.archivers.cpio;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
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

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() throws IOException {
        outputStream = new ByteArrayOutputStream();
        cpioOutputStream = new CpioArchiveOutputStream(outputStream);
        // Create a new entry with a size of 10
        CpioArchiveEntry entry = new CpioArchiveEntry("testEntry", 10);
        cpioOutputStream.write(new byte[10], 0, 10);
    }

    @Test
    void testWriteValidData() throws IOException {
        byte[] data = new byte[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        cpioOutputStream.write(data, 0, data.length);
        assertArrayEquals(data, outputStream.toByteArray());
    }

    @Test
    void testWriteZeroLength() throws IOException {
        byte[] data = new byte[] { 1, 2, 3 };
        cpioOutputStream.write(data, 0, 0);
        assertArrayEquals(new byte[0], outputStream.toByteArray());
    }

    @Test
    void testWriteThrowsIOExceptionWhenNoEntry() {
        IOException exception = assertThrows(IOException.class, () -> {
            byte[] data = new byte[] { 1, 2, 3 };
            cpioOutputStream.write(data, 0, data.length);
        });
        assertEquals("No current CPIO entry", exception.getMessage());
    }

    @Test
    void testWriteThrowsIOExceptionWhenExceedingEntrySize() throws IOException {
        cpioOutputStream.write(new byte[5], 0, 5);
        byte[] data = new byte[] { 1, 2, 3, 4, 5, 6 };
        IOException exception = assertThrows(IOException.class, () -> {
            cpioOutputStream.write(data, 0, data.length);
        });
        assertEquals("Attempt to write past end of STORED entry", exception.getMessage());
    }
}
