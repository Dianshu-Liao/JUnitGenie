package org.apache.commons.compress.archivers.examples;

import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.archivers.examples.CloseableConsumer;
import org.apache.commons.compress.archivers.examples.CloseableConsumerAdapter;
import org.apache.commons.compress.archivers.examples.Expander;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
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

class Expander_expand_5_2_Test {

    private Expander expander;

    private CloseableConsumer closeableConsumer;

    @BeforeEach
    void setUp() {
        expander = new Expander();
        closeableConsumer = Mockito.mock(CloseableConsumer.class);
    }

    @Test
    void testExpandValidInput() throws IOException, ArchiveException {
        // Given
        InputStream archiveInputStream = new ByteArrayInputStream(new byte[] {});
        File targetDirectory = new File("targetDir");
        // When
        expander.expand(archiveInputStream, targetDirectory, closeableConsumer);
        // Then
        // No exception should be thrown
    }

    @Test
    void testExpandIOException() throws IOException, ArchiveException {
        // Given
        InputStream archiveInputStream = new ByteArrayInputStream(new byte[] {});
        File targetDirectory = new File("targetDir");
        // Simulate IOException in closeableConsumer
        doThrow(new IOException("Mocked IOException")).when(closeableConsumer).accept(Mockito.any());
        // When
        assertThrows(IOException.class, () -> {
            expander.expand(archiveInputStream, targetDirectory, closeableConsumer);
        });
    }

    @Test
    void testExpandArchiveException() throws IOException, ArchiveException {
        // Given
        InputStream archiveInputStream = new ByteArrayInputStream(new byte[] {});
        File targetDirectory = new File("targetDir");
        // Simulate ArchiveException in creating ArchiveInputStream
        doThrow(new ArchiveException("Mocked ArchiveException")).when(closeableConsumer).accept(Mockito.any());
        // When
        assertThrows(ArchiveException.class, () -> {
            expander.expand(archiveInputStream, targetDirectory, closeableConsumer);
        });
    }
}
