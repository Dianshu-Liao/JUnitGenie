package org.apache.commons.compress.archivers.sevenz;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
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
        // Mock a SeekableByteChannel or use a real file for testing
        sevenZOutputFile = new SevenZOutputFile(Files.newByteChannel(Paths.get("test.7z")));
    }

    @Test
    public void testCreateArchiveEntry_File() throws IOException {
        Path inputPath = Files.createTempDirectory("testDir");
        String entryName = "testEntry";
        SevenZArchiveEntry entry = sevenZOutputFile.createArchiveEntry(inputPath, entryName, LinkOption.NOFOLLOW_LINKS);
        assertNotNull(entry);
        assertTrue(entry.isDirectory());
        assertEquals(entryName, entry.getName());
    }

    @Test
    public void testCreateArchiveEntry_NonDirectory() throws IOException {
        Path inputPath = Files.createTempFile("testFile", ".txt");
        String entryName = "testEntry";
        SevenZArchiveEntry entry = sevenZOutputFile.createArchiveEntry(inputPath, entryName, LinkOption.NOFOLLOW_LINKS);
        assertNotNull(entry);
        assertFalse(entry.isDirectory());
        assertEquals(entryName, entry.getName());
    }

    @Test
    public void testCreateArchiveEntry_InvalidPath() {
        Path invalidPath = Paths.get("invalid/path");
        String entryName = "testEntry";
        assertThrows(IOException.class, () -> {
            sevenZOutputFile.createArchiveEntry(invalidPath, entryName, LinkOption.NOFOLLOW_LINKS);
        });
    }

    // Reflection test to invoke private method fillDates
    @Test
    public void testFillDates() throws Exception {
        Path inputPath = Files.createTempFile("testFile", ".txt");
        String entryName = "testEntry";
        SevenZArchiveEntry entry = new SevenZArchiveEntry();
        // Using reflection to access the private method
        java.lang.reflect.Method fillDatesMethod = SevenZOutputFile.class.getDeclaredMethod("fillDates", Path.class, SevenZArchiveEntry.class, LinkOption[].class);
        fillDatesMethod.setAccessible(true);
        fillDatesMethod.invoke(sevenZOutputFile, inputPath, entry, new LinkOption[] { LinkOption.NOFOLLOW_LINKS });
        // Assertions based on what fillDates is supposed to do
        // Assuming fillDates sets the last modified date, etc.
        assertNotNull(entry.getLastModifiedDate());
    }
}
