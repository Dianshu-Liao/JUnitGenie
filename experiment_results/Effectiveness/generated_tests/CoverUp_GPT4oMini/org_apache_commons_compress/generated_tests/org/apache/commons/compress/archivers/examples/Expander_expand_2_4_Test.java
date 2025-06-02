package org.apache.commons.compress.archivers.examples;

import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
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
import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarFile;
import org.apache.commons.compress.archivers.zip.ZipFile;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.NullOutputStream;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class Expander_expand_2_4_Test {

    private Expander expander;

    private ArchiveInputStream<ZipArchiveEntry> archiveInputStream;

    private Path tempDirectory;

    @BeforeEach
    void setUp() throws IOException {
        expander = new Expander();
        tempDirectory = Files.createTempDirectory("expanderTest");
        archiveInputStream = mock(ArchiveInputStream.class);
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.walk(tempDirectory).sorted((p1, p2) -> p2.compareTo(p1)).forEach(p -> {
            try {
                Files.delete(p);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @Test
    void testExpandWithValidArchive() throws IOException {
        ZipArchiveEntry entry = mock(ZipArchiveEntry.class);
        when(archiveInputStream.getNextEntry()).thenReturn(entry, null);
        when(archiveInputStream.canReadEntryData(entry)).thenReturn(true);
        assertDoesNotThrow(() -> expander.expand(archiveInputStream, tempDirectory));
    }

    @Test
    void testExpandWithInvalidArchiveEntry() throws IOException {
        ZipArchiveEntry entry = mock(ZipArchiveEntry.class);
        when(archiveInputStream.getNextEntry()).thenReturn(entry);
        when(archiveInputStream.canReadEntryData(entry)).thenReturn(false, true);
        when(archiveInputStream.getNextEntry()).thenReturn(null);
        assertDoesNotThrow(() -> expander.expand(archiveInputStream, tempDirectory));
    }

    @Test
    void testExpandWithIOException() throws IOException {
        when(archiveInputStream.getNextEntry()).thenThrow(new IOException("Simulated IO Exception"));
        assertDoesNotThrow(() -> expander.expand(archiveInputStream, tempDirectory));
    }
}
