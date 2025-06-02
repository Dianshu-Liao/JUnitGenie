package org.apache.commons.compress.archivers.sevenz;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry;
import org.apache.commons.compress.archivers.sevenz.SevenZOutputFile;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import static java.nio.charset.StandardCharsets.UTF_16LE;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.OpenOption;
import java.nio.file.StandardOpenOption;
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
import org.apache.commons.io.output.CountingOutputStream;

public class SevenZOutputFile_createArchiveEntry_4_0_Test {

    private SevenZOutputFile sevenZOutputFile;

    @BeforeEach
    public void setUp() throws IOException {
        // Create a mock SeekableByteChannel or use a real one if needed
        sevenZOutputFile = mock(SevenZOutputFile.class);
    }

    @Test
    public void testCreateArchiveEntry_File() throws Exception {
        // Arrange
        Path tempFile = Files.createTempFile("testFile", ".txt");
        String entryName = "testEntry";
        LinkOption[] options = new LinkOption[] {};
        // Create a real instance of SevenZOutputFile to invoke the actual method
        SevenZOutputFile realSevenZOutputFile = new SevenZOutputFile(Files.newByteChannel(tempFile));
        // Act
        SevenZArchiveEntry entry = realSevenZOutputFile.createArchiveEntry(tempFile, entryName, options);
        // Assert
        assertNotNull(entry);
        assertEquals(entryName, entry.getName());
        assertFalse(entry.isDirectory());
        // Clean up
        Files.deleteIfExists(tempFile);
    }

    @Test
    public void testCreateArchiveEntry_Directory() throws Exception {
        // Arrange
        Path tempDir = Files.createTempDirectory("testDir");
        String entryName = "testDirEntry";
        LinkOption[] options = new LinkOption[] {};
        // Create a real instance of SevenZOutputFile to invoke the actual method
        SevenZOutputFile realSevenZOutputFile = new SevenZOutputFile(Files.newByteChannel(tempDir));
        // Act
        SevenZArchiveEntry entry = realSevenZOutputFile.createArchiveEntry(tempDir, entryName, options);
        // Assert
        assertNotNull(entry);
        assertEquals(entryName, entry.getName());
        assertTrue(entry.isDirectory());
        // Clean up
        Files.deleteIfExists(tempDir);
    }

    @Test
    public void testCreateArchiveEntry_InvalidPath() {
        // Arrange
        Path invalidPath = Paths.get("invalid/path");
        String entryName = "invalidEntry";
        LinkOption[] options = new LinkOption[] {};
        // Act & Assert
        assertThrows(IOException.class, () -> {
            sevenZOutputFile.createArchiveEntry(invalidPath, entryName, options);
        });
    }
}
