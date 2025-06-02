package org.apache.commons.compress.archivers.examples;

import org.apache.commons.compress.archivers.zip.ZipFile;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Enumeration;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.BufferedInputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.StandardOpenOption;
import java.util.Iterator;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarFile;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.NullOutputStream;

public class Expander_expand_19_0_Test {

    private Expander expander;

    private ZipFile mockZipFile;

    private File targetDirectory;

    @BeforeEach
    public void setUp() throws IOException {
        expander = new Expander();
        // Create a temporary directory for the target
        targetDirectory = Files.createTempDirectory("testDir").toFile();
        // Mock the ZipFile
        mockZipFile = mock(ZipFile.class);
    }

    @Test
    public void testExpandSuccess() throws Exception {
        // Setup mock behavior
        ZipArchiveEntry mockEntry = mock(ZipArchiveEntry.class);
        when(mockEntry.getName()).thenReturn("testFile.txt");
        when(mockZipFile.getEntries()).thenReturn(new Enumeration<ZipArchiveEntry>() {

            private boolean hasMore = true;

            @Override
            public boolean hasMoreElements() {
                return hasMore;
            }

            @Override
            public ZipArchiveEntry nextElement() {
                // Only return one entry
                hasMore = false;
                return mockEntry;
            }
        });
        when(mockZipFile.canReadEntryData(mockEntry)).thenReturn(true);
        InputStream mockInputStream = mock(InputStream.class);
        when(mockZipFile.getInputStream(mockEntry)).thenReturn(mockInputStream);
        // Perform the expand operation
        invokeExpand(mockZipFile, targetDirectory);
        // Verify that the input stream was copied
        verify(mockZipFile).getInputStream(mockEntry);
        verify(mockInputStream).close();
        // Check if the target directory exists
        assertTrue(targetDirectory.exists());
        // Clean up
        Files.walk(Paths.get(targetDirectory.getAbsolutePath())).map(Path::toFile).forEach(File::delete);
    }

    @Test
    public void testExpandWithNoEntries() throws Exception {
        // Setup mock behavior for no entries
        when(mockZipFile.getEntries()).thenReturn(new Enumeration<ZipArchiveEntry>() {

            @Override
            public boolean hasMoreElements() {
                return false;
            }

            @Override
            public ZipArchiveEntry nextElement() {
                // No entries
                return null;
            }
        });
        // Perform the expand operation
        invokeExpand(mockZipFile, targetDirectory);
        // Verify that no input streams were accessed
        verify(mockZipFile, never()).getInputStream(any(ZipArchiveEntry.class));
        // Check if the target directory exists
        assertTrue(targetDirectory.exists());
        // Clean up
        Files.walk(Paths.get(targetDirectory.getAbsolutePath())).map(Path::toFile).forEach(File::delete);
    }

    @Test
    public void testExpandWithIOException() throws Exception {
        // Setup mock behavior to throw IOException
        ZipArchiveEntry mockEntry = mock(ZipArchiveEntry.class);
        when(mockEntry.getName()).thenReturn("testFile.txt");
        when(mockZipFile.getEntries()).thenReturn(new Enumeration<ZipArchiveEntry>() {

            private boolean hasMore = true;

            @Override
            public boolean hasMoreElements() {
                return hasMore;
            }

            @Override
            public ZipArchiveEntry nextElement() {
                // Only return one entry
                hasMore = false;
                return mockEntry;
            }
        });
        when(mockZipFile.canReadEntryData(mockEntry)).thenReturn(true);
        when(mockZipFile.getInputStream(mockEntry)).thenThrow(new IOException("Test Exception"));
        // Perform the expand operation and expect an IOException
        Exception exception = assertThrows(IOException.class, () -> {
            invokeExpand(mockZipFile, targetDirectory);
        });
        // Verify the exception message
        assertEquals("Test Exception", exception.getMessage());
    }

    @Test
    public void testExpandWithNullTargetDirectory() throws Exception {
        // Expecting a NullPointerException when target directory is null
        assertThrows(NullPointerException.class, () -> {
            invokeExpand(mockZipFile, null);
        });
    }

    private void invokeExpand(ZipFile archive, File targetDirectory) throws Exception {
        // Use reflection to invoke the private method
        java.lang.reflect.Method method = Expander.class.getDeclaredMethod("expand", ZipFile.class, File.class);
        method.setAccessible(true);
        method.invoke(expander, archive, targetDirectory);
    }
}
