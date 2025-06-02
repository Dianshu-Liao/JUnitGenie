package org.apache.commons.compress.archivers.sevenz;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Path;
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
import java.nio.file.Files;
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

public class SevenZOutputFile_createArchiveEntry_3_0_Test {

    private SevenZOutputFile sevenZOutputFile;

    @BeforeEach
    public void setUp() throws IOException {
        File tempFile = File.createTempFile("test", ".7z");
        sevenZOutputFile = new SevenZOutputFile(tempFile);
    }

    @Test
    public void testCreateArchiveEntry_FileIsDirectory() throws Exception {
        File inputFile = mock(File.class);
        when(inputFile.isDirectory()).thenReturn(true);
        String entryName = "testDirectory";
        SevenZArchiveEntry entry = sevenZOutputFile.createArchiveEntry(inputFile, entryName);
        assertTrue(entry.isDirectory());
        assertEquals(entryName, entry.getName());
    }

    @Test
    public void testCreateArchiveEntry_FileIsNotDirectory() throws Exception {
        File inputFile = mock(File.class);
        when(inputFile.isDirectory()).thenReturn(false);
        when(inputFile.lastModified()).thenReturn(System.currentTimeMillis());
        String entryName = "testFile.txt";
        SevenZArchiveEntry entry = sevenZOutputFile.createArchiveEntry(inputFile, entryName);
        assertFalse(entry.isDirectory());
        assertEquals(entryName, entry.getName());
    }

    @Test
    public void testCreateArchiveEntry_FileThrowsIOException() throws Exception {
        File inputFile = mock(File.class);
        when(inputFile.isDirectory()).thenReturn(false);
        when(inputFile.lastModified()).thenThrow(new IOException("Mocked exception"));
        String entryName = "testFile.txt";
        SevenZArchiveEntry entry = sevenZOutputFile.createArchiveEntry(inputFile, entryName);
        assertFalse(entry.isDirectory());
        assertEquals(entryName, entry.getName());
        // Assuming that the lastModifiedDate should be set to the current time when IOException occurs
        assertNotNull(entry.getLastModifiedDate());
    }

    // Reflection test for private method fillDates
    @Test
    public void testFillDates() throws Exception {
        Method fillDatesMethod = SevenZOutputFile.class.getDeclaredMethod("fillDates", Path.class, SevenZArchiveEntry.class);
        fillDatesMethod.setAccessible(true);
        // Mocking Path and SevenZArchiveEntry for testing
        Path mockPath = mock(Path.class);
        SevenZArchiveEntry mockEntry = mock(SevenZArchiveEntry.class);
        // Invoke the private method
        fillDatesMethod.invoke(sevenZOutputFile, mockPath, mockEntry);
        // Verify interactions or state changes if any
        // This is a placeholder as we don't know the actual implementation of fillDates
        // Verify the expected behavior
    }
}
