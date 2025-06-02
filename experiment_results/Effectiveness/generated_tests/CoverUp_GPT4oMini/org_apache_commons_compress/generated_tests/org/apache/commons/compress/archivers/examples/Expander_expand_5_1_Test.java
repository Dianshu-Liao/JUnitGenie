package org.apache.commons.compress.archivers.examples;

import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.archivers.examples.CloseableConsumer;
import org.apache.commons.compress.archivers.examples.CloseableConsumerAdapter;
import org.apache.commons.compress.archivers.examples.Expander;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.BufferedInputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Enumeration;
import java.util.Iterator;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarFile;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipFile;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.NullOutputStream;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class Expander_expand_5_1_Test {

    private Expander expander;

    private CloseableConsumer closeableConsumer;

    @BeforeEach
    void setUp() {
        expander = new Expander();
        closeableConsumer = mock(CloseableConsumer.class);
    }

    @Test
    void testExpand_ValidInputStream_Success() throws IOException, ArchiveException {
        // Arrange
        String archiveContent = "test content";
        InputStream inputStream = new ByteArrayInputStream(archiveContent.getBytes());
        File targetDirectory = new File("targetDir");
        // Act
        expander.expand(inputStream, targetDirectory, closeableConsumer);
        // Assert
        verify(closeableConsumer, times(1)).accept(any());
    }

    @Test
    void testExpand_NullInputStream_ThrowsIOException() {
        // Arrange
        InputStream inputStream = null;
        File targetDirectory = new File("targetDir");
        // Act & Assert
        assertThrows(IOException.class, () -> {
            expander.expand(inputStream, targetDirectory, closeableConsumer);
        });
    }

    @Test
    void testExpand_NullTargetDirectory_ThrowsIOException() {
        // Arrange
        String archiveContent = "test content";
        InputStream inputStream = new ByteArrayInputStream(archiveContent.getBytes());
        File targetDirectory = null;
        // Act & Assert
        assertThrows(IOException.class, () -> {
            expander.expand(inputStream, targetDirectory, closeableConsumer);
        });
    }

    @Test
    void testExpand_ValidInputStream_ArchiveException() throws IOException {
        // Arrange
        String archiveContent = "invalid archive content";
        InputStream inputStream = new ByteArrayInputStream(archiveContent.getBytes());
        File targetDirectory = new File("targetDir");
        doThrow(new ArchiveException("Mocked Archive Exception")).when(closeableConsumer).accept(any());
        // Act & Assert
        assertThrows(ArchiveException.class, () -> {
            expander.expand(inputStream, targetDirectory, closeableConsumer);
        });
    }
}
