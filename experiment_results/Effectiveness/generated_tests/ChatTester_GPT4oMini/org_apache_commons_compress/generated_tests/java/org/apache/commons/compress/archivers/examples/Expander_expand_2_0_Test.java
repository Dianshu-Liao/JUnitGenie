package org.apache.commons.compress.archivers.examples;

import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.io.IOUtils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import java.nio.file.StandardOpenOption;
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

public class Expander_expand_2_0_Test {

    private Expander expander;

    private ArchiveInputStream<ArchiveEntry> mockArchiveInputStream;

    private Path targetDirectory;

    @BeforeEach
    public void setUp() throws IOException {
        expander = new Expander();
        mockArchiveInputStream = mock(ArchiveInputStream.class);
        targetDirectory = Files.createTempDirectory("testDir");
    }

    @Test
    public void testExpandWithValidEntries() throws IOException {
        // Prepare mock behavior for two valid entries
        ArchiveEntry mockEntry1 = mock(ArchiveEntry.class);
        ArchiveEntry mockEntry2 = mock(ArchiveEntry.class);
        when(mockArchiveInputStream.getNextEntry()).thenReturn(mockEntry1, mockEntry2, null);
        when(mockArchiveInputStream.canReadEntryData(mockEntry1)).thenReturn(true);
        when(mockArchiveInputStream.canReadEntryData(mockEntry2)).thenReturn(true);
        // Create a mock OutputStream
        OutputStream mockOutputStream1 = mock(OutputStream.class);
        OutputStream mockOutputStream2 = mock(OutputStream.class);
        when(mockOutputStream1).thenReturn(mockOutputStream1);
        when(mockOutputStream2).thenReturn(mockOutputStream2);
        // Call the focal method
        expander.expand(mockArchiveInputStream, targetDirectory);
        // Verify interactions
        // 2 entries + 1 for null
        verify(mockArchiveInputStream, times(3)).getNextEntry();
        verify(mockArchiveInputStream).canReadEntryData(mockEntry1);
        verify(mockArchiveInputStream).canReadEntryData(mockEntry2);
        verify(mockOutputStream1).write(any(byte[].class), anyInt(), anyInt());
        verify(mockOutputStream2).write(any(byte[].class), anyInt(), anyInt());
    }

    @Test
    public void testExpandWithNoEntries() throws IOException {
        // Prepare mock behavior for no entries
        when(mockArchiveInputStream.getNextEntry()).thenReturn(null);
        // Call the focal method
        expander.expand(mockArchiveInputStream, targetDirectory);
        // Verify that getNextEntry is called once
        verify(mockArchiveInputStream).getNextEntry();
    }

    @Test
    public void testExpandWithUnreadableEntries() throws IOException {
        // Prepare mock behavior for unreadable entries
        ArchiveEntry mockEntry1 = mock(ArchiveEntry.class);
        ArchiveEntry mockEntry2 = mock(ArchiveEntry.class);
        when(mockArchiveInputStream.getNextEntry()).thenReturn(mockEntry1, mockEntry2, null);
        when(mockArchiveInputStream.canReadEntryData(mockEntry1)).thenReturn(false);
        when(mockArchiveInputStream.canReadEntryData(mockEntry2)).thenReturn(true);
        // Create a mock OutputStream
        OutputStream mockOutputStream = mock(OutputStream.class);
        when(mockOutputStream).thenReturn(mockOutputStream);
        // Call the focal method
        expander.expand(mockArchiveInputStream, targetDirectory);
        // Verify interactions
        // 2 entries + 1 for null
        verify(mockArchiveInputStream, times(3)).getNextEntry();
        verify(mockArchiveInputStream).canReadEntryData(mockEntry1);
        verify(mockArchiveInputStream).canReadEntryData(mockEntry2);
        verify(mockOutputStream).write(any(byte[].class), anyInt(), anyInt());
    }

    @AfterEach
    public void tearDown() throws IOException {
        // Clean up the temporary directory
        // reverse order for deletion
        // reverse order for deletion
        Files.walk(targetDirectory).sorted((a, b) -> b.compareTo(a)).map(Path::toFile).forEach(File::delete);
    }
}
