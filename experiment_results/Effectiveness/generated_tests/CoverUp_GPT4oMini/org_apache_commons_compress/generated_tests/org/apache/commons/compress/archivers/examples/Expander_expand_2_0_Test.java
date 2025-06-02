package org.apache.commons.compress.archivers.examples;

import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.util.Enumeration;
import java.util.Iterator;
import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarFile;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipFile;
import org.apache.commons.io.output.NullOutputStream;

class Expander_expand_2_0_Test {

    private Expander expander;

    private ArchiveInputStream<ArchiveEntry> archiveInputStream;

    private Path targetDirectory;

    @BeforeEach
    void setUp() throws IOException {
        expander = new Expander();
        targetDirectory = Files.createTempDirectory("testExpand");
        archiveInputStream = mock(ArchiveInputStream.class);
    }

    @AfterEach
    void tearDown() throws IOException {
        // reverse order for deletion
        // reverse order for deletion
        Files.walk(targetDirectory).sorted((a, b) -> b.compareTo(a)).forEach(path -> {
            try {
                Files.delete(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @Test
    void testExpandWithValidEntries() throws IOException {
        ArchiveEntry entry1 = mock(ArchiveEntry.class);
        when(entry1.getName()).thenReturn("file1.txt");
        when(entry1.getSize()).thenReturn(11L);
        ArchiveEntry entry2 = mock(ArchiveEntry.class);
        when(entry2.getName()).thenReturn("file2.txt");
        when(entry2.getSize()).thenReturn(11L);
        when(archiveInputStream.getNextEntry()).thenReturn(entry1).thenReturn(entry2).thenReturn(null);
        when(archiveInputStream.canReadEntryData(entry1)).thenReturn(true);
        when(archiveInputStream.canReadEntryData(entry2)).thenReturn(true);
        OutputStream outputStream = mock(OutputStream.class);
        when(archiveInputStream.getNextEntry()).thenReturn(entry1, entry2, null);
        expander.expand(archiveInputStream, targetDirectory);
        // Verify that the entries were processed
        assertTrue(Files.exists(targetDirectory.resolve("file1.txt")));
        assertTrue(Files.exists(targetDirectory.resolve("file2.txt")));
    }

    @Test
    void testExpandWithNoReadableEntries() throws IOException {
        ArchiveEntry entry1 = mock(ArchiveEntry.class);
        when(entry1.getName()).thenReturn("file1.txt");
        when(archiveInputStream.getNextEntry()).thenReturn(entry1).thenReturn(null);
        when(archiveInputStream.canReadEntryData(entry1)).thenReturn(false);
        expander.expand(archiveInputStream, targetDirectory);
        // Verify that no files were created
        assertFalse(Files.exists(targetDirectory.resolve("file1.txt")));
    }

    @Test
    void testExpandWithIOException() throws IOException {
        when(archiveInputStream.getNextEntry()).thenThrow(new IOException("Test IOException"));
        assertThrows(IOException.class, () -> {
            expander.expand(archiveInputStream, targetDirectory);
        });
    }
}
