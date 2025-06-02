package org.apache.commons.compress.archivers.examples;

import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.BufferedInputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.StandardOpenOption;
import java.util.Enumeration;
import java.util.Iterator;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveException;
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

public class Expander_expand_1_4_Test {

    private Expander expander;

    private File targetDirectory;

    @BeforeEach
    public void setUp() {
        expander = new Expander();
        targetDirectory = new File("target/test/expand");
        // Ensure the target directory exists
        targetDirectory.mkdirs();
    }

    @Test
    public void testExpandValidZip() throws Exception {
        try (InputStream inputStream = getClass().getResourceAsStream("/test.zip");
            ArchiveInputStream archiveInputStream = new ZipArchiveInputStream(inputStream)) {
            invokeExpandMethod(archiveInputStream, targetDirectory);
            // Verify the files were extracted
            assertTrue(new File(targetDirectory, "file1.txt").exists());
            assertTrue(new File(targetDirectory, "file2.txt").exists());
        }
    }

    @Test
    public void testExpandNullArchive() {
        assertThrows(IOException.class, () -> {
            invokeExpandMethod(null, targetDirectory);
        });
    }

    @Test
    public void testExpandNullTargetDirectory() throws Exception {
        try (InputStream inputStream = getClass().getResourceAsStream("/test.zip");
            ArchiveInputStream archiveInputStream = new ZipArchiveInputStream(inputStream)) {
            invokeExpandMethod(archiveInputStream, null);
            // Expect no exception, but we cannot verify files in a null directory
        }
    }

    @Test
    public void testExpandEmptyArchive() throws Exception {
        try (InputStream inputStream = getClass().getResourceAsStream("/empty.zip");
            ArchiveInputStream archiveInputStream = new ZipArchiveInputStream(inputStream)) {
            invokeExpandMethod(archiveInputStream, targetDirectory);
            // Verify no files are extracted
            assertEquals(0, targetDirectory.listFiles().length);
        }
    }

    @Test
    public void testExpandInvalidArchive() {
        assertThrows(IOException.class, () -> {
            try (InputStream inputStream = getClass().getResourceAsStream("/invalid.zip");
                ArchiveInputStream archiveInputStream = new ZipArchiveInputStream(inputStream)) {
                invokeExpandMethod(archiveInputStream, targetDirectory);
            }
        });
    }

    // Clean up after tests
    @AfterEach
    public void tearDown() throws IOException {
        Files.walk(targetDirectory.toPath()).sorted((a, b) -> b.compareTo(a)).forEach(path -> {
            try {
                Files.delete(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void invokeExpandMethod(ArchiveInputStream archiveInputStream, File targetDirectory) throws Exception {
        java.lang.reflect.Method method = Expander.class.getDeclaredMethod("expand", ArchiveInputStream.class, File.class);
        method.setAccessible(true);
        method.invoke(expander, archiveInputStream, targetDirectory);
    }
}
