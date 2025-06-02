package org.apache.commons.compress.archivers.examples;

import org.apache.commons.compress.archivers.sevenz.SevenZFile;
import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.io.IOUtils;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.StandardOpenOption;
import java.util.Enumeration;
import java.util.Iterator;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarFile;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipFile;
import org.apache.commons.io.output.NullOutputStream;

public class Expander_expand_8_1_Test {

    private Expander expander;

    private SevenZFile mockSevenZFile;

    private Path targetDirectory;

    @BeforeEach
    public void setUp() throws IOException {
        expander = new Expander();
        mockSevenZFile = mock(SevenZFile.class);
        targetDirectory = Files.createTempDirectory("testExpand");
    }

    @Test
    public void testExpand() throws Exception {
        // Arrange
        when(mockSevenZFile.getNextEntry()).thenReturn(null);
        // Act & Assert
        assertDoesNotThrow(() -> expander.expand(mockSevenZFile, targetDirectory));
        // Verify
        verify(mockSevenZFile, times(1)).getNextEntry();
    }

    @Test
    public void testExpandWithEntries() throws Exception {
        // Arrange
        SevenZArchiveEntry mockEntry = mock(SevenZArchiveEntry.class);
        when(mockEntry.getName()).thenReturn("testFile.txt");
        when(mockSevenZFile.getNextEntry()).thenReturn(mockEntry).thenReturn(null);
        // Act & Assert
        assertDoesNotThrow(() -> expander.expand(mockSevenZFile, targetDirectory));
        // Verify
        verify(mockSevenZFile, times(2)).getNextEntry();
    }

    @Test
    public void testExpandThrowsIOException() throws Exception {
        // Arrange
        when(mockSevenZFile.getNextEntry()).thenThrow(new IOException("Simulated IOException"));
        // Act & Assert
        assertThrows(IOException.class, () -> expander.expand(mockSevenZFile, targetDirectory));
    }

    @Test
    public void testExpandWithEmptyDirectory() throws Exception {
        // Arrange
        when(mockSevenZFile.getNextEntry()).thenReturn(null);
        // Act & Assert
        assertDoesNotThrow(() -> expander.expand(mockSevenZFile, targetDirectory));
    }

    @AfterEach
    public void tearDown() throws IOException {
        // Clean up the temporary directory
        Files.walk(targetDirectory).sorted((a, b) -> b.compareTo(a)).forEach(path -> {
            try {
                Files.delete(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
