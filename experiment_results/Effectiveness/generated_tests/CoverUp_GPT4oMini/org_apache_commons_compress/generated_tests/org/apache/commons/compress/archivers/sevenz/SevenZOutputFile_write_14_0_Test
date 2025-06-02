package org.apache.commons.compress.archivers.sevenz;

import org.apache.commons.compress.archivers.sevenz.SevenZOutputFile;
import org.apache.commons.io.output.CountingOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static java.nio.charset.StandardCharsets.UTF_16LE;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
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
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class SevenZOutputFile_write_14_0_Test {

    private SevenZOutputFile sevenZOutputFile;

    private File tempFile;

    @BeforeEach
    void setUp() throws IOException {
        // Create a temporary file for testing
        tempFile = Files.createTempFile("test", ".7z").toFile();
        sevenZOutputFile = new SevenZOutputFile(tempFile);
    }

    @AfterEach
    void tearDown() throws IOException {
        // Clean up the temporary file
        if (sevenZOutputFile != null) {
            sevenZOutputFile.close();
        }
        Files.deleteIfExists(tempFile.toPath());
    }

    @Test
    void testWriteWithValidData() throws Exception {
        byte[] data = "Hello, SevenZ!".getBytes();
        sevenZOutputFile.getClass().getMethod("write", byte[].class).invoke(sevenZOutputFile, (Object) data);
        // Verify that the data is written correctly
        assertTrue(tempFile.length() > 0, "The file should not be empty after writing data.");
    }

    @Test
    void testWriteWithEmptyArray() throws Exception {
        byte[] data = new byte[0];
        sevenZOutputFile.getClass().getMethod("write", byte[].class).invoke(sevenZOutputFile, (Object) data);
        // Ensure that the file is still empty
        assertEquals(0, tempFile.length(), "The file should remain empty when writing an empty array.");
    }

    @Test
    void testWriteWithPartialData() throws Exception {
        byte[] data = "Partial data".getBytes();
        sevenZOutputFile.getClass().getMethod("write", byte[].class).invoke(sevenZOutputFile, (Object) data);
        // Verify that the data is written correctly
        assertTrue(tempFile.length() > 0, "The file should not be empty after writing data.");
    }

    @Test
    void testWriteWithNullArray() {
        assertThrows(NullPointerException.class, () -> {
            sevenZOutputFile.getClass().getMethod("write", byte[].class).invoke(sevenZOutputFile, (Object) null);
        }, "Writing a null byte array should throw NullPointerException.");
    }

    @Test
    void testWriteAfterClose() throws Exception {
        sevenZOutputFile.close();
        byte[] data = "Data after close".getBytes();
        assertThrows(IOException.class, () -> {
            sevenZOutputFile.getClass().getMethod("write", byte[].class).invoke(sevenZOutputFile, (Object) data);
        }, "Writing after closing the output file should throw IOException.");
    }

    @Test
    void testWriteWithNegativeLength() throws Exception {
        byte[] data = "Hello".getBytes();
        assertThrows(IndexOutOfBoundsException.class, () -> {
            sevenZOutputFile.getClass().getMethod("write", byte[].class, int.class, int.class).invoke(sevenZOutputFile, (Object) data, 0, -1);
        }, "Writing with a negative length should throw IndexOutOfBoundsException.");
    }
}
