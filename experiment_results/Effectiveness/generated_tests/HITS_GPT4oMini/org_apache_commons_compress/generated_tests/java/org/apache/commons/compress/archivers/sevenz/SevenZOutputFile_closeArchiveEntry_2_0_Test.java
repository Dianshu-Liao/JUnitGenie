package org.apache.commons.compress.archivers.sevenz;

import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.io.output.CountingOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.io.ByteArrayOutputStream;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
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
import java.nio.channels.SeekableByteChannel;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.BitSet;
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

class SevenZOutputFile_closeArchiveEntry_2_0_Test {

    private SevenZOutputFile sevenZOutputFile;

    private SevenZArchiveEntry entry;

    private Path tempFile;

    @BeforeEach
    void setUp() throws IOException {
        // Create a temporary file to use as a SeekableByteChannel
        tempFile = Files.createTempFile("test", ".tmp");
        FileChannel fileChannel = FileChannel.open(tempFile);
        sevenZOutputFile = new SevenZOutputFile(fileChannel);
        entry = new SevenZArchiveEntry();
        try {
            sevenZOutputFile.getClass().getDeclaredField("files").set(sevenZOutputFile, new ArrayList<>(Collections.singletonList(entry)));
            CountingOutputStream countingOutputStream = new CountingOutputStream(new ByteArrayOutputStream());
            sevenZOutputFile.getClass().getDeclaredField("currentOutputStream").set(sevenZOutputFile, countingOutputStream);
            sevenZOutputFile.getClass().getDeclaredField("fileBytesWritten").set(sevenZOutputFile, 100L);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Failed to set up the test due to reflection issues: " + e.getMessage());
        }
    }

    @AfterEach
    void tearDown() throws IOException {
        // Clean up the temporary file
        Files.deleteIfExists(tempFile);
    }

    @Test
    void testCloseArchiveEntryWithStream() throws IOException {
        sevenZOutputFile.closeArchiveEntry();
        assertTrue(entry.getSize() > 0);
        assertEquals(100, entry.getSize());
        assertEquals(100, entry.getCompressedSize());
        assertTrue(entry.getHasCrc());
    }
}
