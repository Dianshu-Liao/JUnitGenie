package org.apache.commons.compress.archivers.examples;

import org.apache.commons.compress.archivers.ArchiveException;
import org.junit.jupiter.api.io.TempDir;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
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

public class Expander_expand_4_0_Test {

    private final Expander expander = new Expander();

    @TempDir
    Path tempDir;

    @Test
    public void testExpand_ValidArchive() throws IOException, ArchiveException {
        // Create a temporary archive file for testing
        File archive = createTestArchive();
        // Create a target directory
        File targetDirectory = tempDir.toFile();
        // Call the focal method
        expander.expand(new FileInputStream(archive), targetDirectory);
        // Verify that the contents were extracted
        assertTrue(new File(targetDirectory, "testfile.txt").exists());
    }

    @Test
    public void testExpand_NullArchive() {
        File targetDirectory = tempDir.toFile();
        assertThrows(NullPointerException.class, () -> {
            expander.expand((FileInputStream) null, targetDirectory);
        });
    }

    @Test
    public void testExpand_NullTargetDirectory() throws IOException {
        File archive = createTestArchive();
        assertThrows(NullPointerException.class, () -> {
            expander.expand(new FileInputStream(archive), null);
        });
    }

    @Test
    public void testExpand_InvalidArchive() {
        File invalidArchive = new File(tempDir.toFile(), "invalid.zip");
        File targetDirectory = tempDir.toFile();
        assertThrows(IOException.class, () -> {
            expander.expand(new FileInputStream(invalidArchive), targetDirectory);
        });
    }

    private File createTestArchive() throws IOException {
        File archive = new File(tempDir.toFile(), "test.zip");
        try (FileOutputStream fos = new FileOutputStream(archive)) {
            // Write a simple text file to the archive for testing
            fos.write("This is a test file.".getBytes());
        }
        return archive;
    }
}
