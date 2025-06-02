package org.apache.commons.compress.archivers.examples;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarFile;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.StandardOpenOption;
import java.util.Enumeration;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipFile;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.NullOutputStream;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class Expander_expand_18_0_Test {

    private Expander expander;

    @BeforeEach
    void setUp() {
        expander = new Expander();
    }

    @Test
    void testExpandSingleFile() throws IOException {
        // Create a TAR file in memory
        byte[] tarContent = createTarContent("test.txt", "Hello, World!");
        Path tempFile = Files.createTempFile("test", ".tar");
        Files.write(tempFile, tarContent);
        TarFile tarFile = new TarFile(tempFile.toFile());
        // Create a temporary directory for extraction
        Path targetDirectory = Files.createTempDirectory("tarExpandTest");
        // Expand the TAR file
        expander.expand(tarFile, targetDirectory);
        // Verify the extracted file
        Path extractedFile = targetDirectory.resolve("test.txt");
        assertTrue(Files.exists(extractedFile));
        String content = new String(Files.readAllBytes(extractedFile));
        assertEquals("Hello, World!", content);
        // Clean up
        Files.deleteIfExists(extractedFile);
        Files.deleteIfExists(targetDirectory);
        Files.deleteIfExists(tempFile);
    }

    @Test
    void testExpandEmptyTarFile() throws IOException {
        // Create an empty TAR file
        byte[] tarContent = new byte[0];
        Path tempFile = Files.createTempFile("empty", ".tar");
        Files.write(tempFile, tarContent);
        TarFile tarFile = new TarFile(tempFile.toFile());
        // Create a temporary directory for extraction
        Path targetDirectory = Files.createTempDirectory("emptyTarExpandTest");
        // Expand the TAR file
        expander.expand(tarFile, targetDirectory);
        // Verify that the directory is still empty
        assertEquals(0, Files.list(targetDirectory).count());
        // Clean up
        Files.deleteIfExists(targetDirectory);
        Files.deleteIfExists(tempFile);
    }

    private byte[] createTarContent(String fileName, String fileContent) throws IOException {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            try (TarArchiveOutputStream taos = new TarArchiveOutputStream(baos)) {
                TarArchiveEntry entry = new TarArchiveEntry(fileName);
                entry.setSize(fileContent.length());
                taos.putArchiveEntry(entry);
                taos.write(fileContent.getBytes());
                taos.closeArchiveEntry();
            }
            return baos.toByteArray();
        }
    }
}
