package org.apache.commons.compress.archivers.sevenz;

import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry;
import org.apache.commons.compress.archivers.sevenz.SevenZOutputFile;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
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
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
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

class SevenZOutputFile_createArchiveEntry_3_0_Test {

    @Test
    void testCreateArchiveEntryForFile() throws Exception {
        // Setup
        Path tempFilePath = Files.createTempFile("testFile", ".txt");
        File inputFile = tempFilePath.toFile();
        String entryName = "entryName.txt";
        SevenZOutputFile sevenZOutputFile = new SevenZOutputFile(new File("dummy.7z"));
        // Invoke the focal method
        SevenZArchiveEntry entry = invokeCreateArchiveEntry(sevenZOutputFile, inputFile, entryName);
        // Verify
        assertNotNull(entry);
        assertEquals(entryName, entry.getName());
        assertFalse(entry.getHasCreationDate());
        assertFalse(entry.getHasLastModifiedDate());
        assertFalse(entry.getHasAccessDate());
        assertFalse(entry.isDirectory());
        // Cleanup
        Files.deleteIfExists(tempFilePath);
        // Note: The dummy.7z file is not created/used in a real scenario.
    }

    @Test
    void testCreateArchiveEntryForDirectory() throws Exception {
        // Setup
        Path tempDirPath = Files.createTempDirectory("testDir");
        File inputDir = tempDirPath.toFile();
        String entryName = "testDir";
        SevenZOutputFile sevenZOutputFile = new SevenZOutputFile(new File("dummy.7z"));
        // Invoke the focal method
        SevenZArchiveEntry entry = invokeCreateArchiveEntry(sevenZOutputFile, inputDir, entryName);
        // Verify
        assertNotNull(entry);
        assertEquals(entryName, entry.getName());
        assertTrue(entry.isDirectory());
        // Cleanup
        Files.deleteIfExists(tempDirPath);
        // Note: The dummy.7z file is not created/used in a real scenario.
    }

    @Test
    void testCreateArchiveEntryHandlesIOException() throws Exception {
        // Setup
        File inputFile = new File("nonExistentFile.txt");
        String entryName = "entryName.txt";
        SevenZOutputFile sevenZOutputFile = new SevenZOutputFile(new File("dummy.7z"));
        // Invoke the focal method
        SevenZArchiveEntry entry = invokeCreateArchiveEntry(sevenZOutputFile, inputFile, entryName);
        // Verify
        assertNotNull(entry);
        assertEquals(entryName, entry.getName());
        assertNotNull(entry.getLastModifiedDate());
        assertFalse(entry.getHasCreationDate());
        assertFalse(entry.getHasAccessDate());
        assertFalse(entry.isDirectory());
    }

    private SevenZArchiveEntry invokeCreateArchiveEntry(SevenZOutputFile sevenZOutputFile, File inputFile, String entryName) throws Exception {
        Method method = SevenZOutputFile.class.getDeclaredMethod("createArchiveEntry", File.class, String.class);
        method.setAccessible(true);
        return (SevenZArchiveEntry) method.invoke(sevenZOutputFile, inputFile, entryName);
    }
}
