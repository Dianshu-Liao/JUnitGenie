package org.apache.commons.compress.archivers.sevenz;

import static java.nio.file.Files.createTempDirectory;
import static java.nio.file.Files.createTempFile;
import static java.nio.file.Files.deleteIfExists;
import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.WRITE;
import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
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

class SevenZOutputFile_createArchiveEntry_4_0_Test {

    private Path tempDir;

    private Path tempFile;

    private SevenZOutputFile sevenZOutputFile;

    @BeforeEach
    void setUp() throws IOException {
        // Create temporary directory and file for testing
        tempDir = createTempDirectory("sevenZTestDir");
        tempFile = createTempFile(tempDir, "testFile", ".txt");
        SeekableByteChannel channel = Files.newByteChannel(tempFile, CREATE, WRITE);
        sevenZOutputFile = new SevenZOutputFile(channel);
    }

    @AfterEach
    void tearDown() throws IOException {
        // Clean up temporary files
        deleteIfExists(tempFile);
        deleteIfExists(tempDir);
    }

    @Test
    void testCreateArchiveEntryForFile() throws IOException {
        SevenZArchiveEntry entry = sevenZOutputFile.createArchiveEntry(tempFile, "testFileEntry", LinkOption.NOFOLLOW_LINKS);
        assertNotNull(entry);
        assertEquals("testFileEntry", entry.getName());
        assertFalse(entry.getHasAccessDate());
        assertFalse(entry.getHasCreationDate());
        assertFalse(entry.getHasLastModifiedDate());
        assertFalse(entry.isDirectory());
    }

    @Test
    void testCreateArchiveEntryForDirectory() throws IOException {
        SevenZArchiveEntry entry = sevenZOutputFile.createArchiveEntry(tempDir, "testDirEntry", LinkOption.NOFOLLOW_LINKS);
        assertNotNull(entry);
        assertEquals("testDirEntry", entry.getName());
        assertFalse(entry.getHasAccessDate());
        assertFalse(entry.getHasCreationDate());
        assertFalse(entry.getHasLastModifiedDate());
        assertTrue(entry.isDirectory());
    }

    @Test
    void testCreateArchiveEntryWithLinkOption() throws IOException {
        SevenZArchiveEntry entry = sevenZOutputFile.createArchiveEntry(tempFile, "testFileEntryWithLinkOption", LinkOption.NOFOLLOW_LINKS);
        assertNotNull(entry);
        assertEquals("testFileEntryWithLinkOption", entry.getName());
        assertFalse(entry.getHasAccessDate());
        assertFalse(entry.getHasCreationDate());
        assertFalse(entry.getHasLastModifiedDate());
        assertFalse(entry.isDirectory());
    }

    @Test
    void testCreateArchiveEntryThrowsIOExceptionForInvalidPath() {
        assertThrows(IOException.class, () -> {
            sevenZOutputFile.createArchiveEntry(Paths.get("invalid/path"), "invalidEntry");
        });
    }
}
