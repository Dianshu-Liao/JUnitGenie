package org.apache.commons.compress.archivers.sevenz;

import org.apache.commons.compress.archivers.sevenz.SevenZOutputFile;
import org.apache.commons.io.output.CountingOutputStream;
import java.io.IOException;
import java.io.ByteArrayOutputStream;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static java.nio.charset.StandardCharsets.UTF_16LE;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import java.util.zip.CRC32;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.io.file.attribute.FileTimes;

public class SevenZOutputFile_write_15_0_Test {

    private SevenZOutputFile sevenZOutputFile;

    private ByteArrayOutputStream byteArrayOutputStream;

    @BeforeEach
    public void setUp() throws IOException {
        // Create a temporary file for testing
        Path tempFile = Files.createTempFile("test", ".7z");
        SeekableByteChannel channel = Files.newByteChannel(tempFile, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        sevenZOutputFile = new SevenZOutputFile(channel);
        byteArrayOutputStream = new ByteArrayOutputStream();
    }

    @Test
    public void testWrite_withValidInput_shouldWriteData() throws IOException {
        byte[] data = "Hello, World!".getBytes();
        sevenZOutputFile.write(data, 0, data.length);
        // Verify the written data
        assertEquals(data.length, byteArrayOutputStream.size());
    }

    @Test
    public void testWrite_withZeroLength_shouldNotWriteData() throws IOException {
        byte[] data = "Hello, World!".getBytes();
        sevenZOutputFile.write(data, 0, 0);
        // Verify that nothing is written
        assertEquals(0, byteArrayOutputStream.size());
    }

    @Test
    public void testWrite_withNegativeOffset_shouldThrowException() {
        byte[] data = "Hello, World!".getBytes();
        assertThrows(IndexOutOfBoundsException.class, () -> {
            sevenZOutputFile.write(data, -1, data.length);
        });
    }

    @Test
    public void testWrite_withInvalidLength_shouldThrowException() {
        byte[] data = "Hello, World!".getBytes();
        assertThrows(IndexOutOfBoundsException.class, () -> {
            sevenZOutputFile.write(data, 0, data.length + 1);
        });
    }

    @Test
    public void testWrite_withOffsetExceedingLength_shouldThrowException() {
        byte[] data = "Hello, World!".getBytes();
        assertThrows(IndexOutOfBoundsException.class, () -> {
            sevenZOutputFile.write(data, data.length, 1);
        });
    }

    @Test
    public void testWrite_withNonEmptyStream_shouldWriteData() throws IOException {
        byte[] data = "Hello, World!".getBytes();
        sevenZOutputFile.write(data, 0, data.length);
        // Verify the written data
        assertEquals(data.length, byteArrayOutputStream.size());
    }

    @Test
    public void testWrite_afterFinish_shouldThrowException() throws IOException {
        // Simulate finishing the output file
        sevenZOutputFile.finish();
        byte[] data = "Hello, World!".getBytes();
        assertThrows(IOException.class, () -> {
            sevenZOutputFile.write(data, 0, data.length);
        });
    }

    // Cleanup method to delete the temporary file after tests
    @AfterEach
    public void tearDown() throws IOException {
        if (sevenZOutputFile != null) {
            sevenZOutputFile.close();
        }
    }
}
