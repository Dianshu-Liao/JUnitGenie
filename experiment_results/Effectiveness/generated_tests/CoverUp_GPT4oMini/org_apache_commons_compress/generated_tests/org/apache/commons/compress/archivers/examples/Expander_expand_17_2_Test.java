package org.apache.commons.compress.archivers.examples;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarFile;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.lang.reflect.Method;
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
import java.nio.file.StandardOpenOption;
import java.util.Enumeration;
import java.util.Iterator;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipFile;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.NullOutputStream;

class Expander_expand_17_2_Test {

    private Expander expander;

    private File tempDir;

    @BeforeEach
    void setUp() throws IOException {
        expander = new Expander();
        tempDir = Files.createTempDirectory("expanderTest").toFile();
    }

    @AfterEach
    void tearDown() throws IOException {
        for (File file : tempDir.listFiles()) {
            file.delete();
        }
        tempDir.delete();
    }

    @Test
    void testExpandValidTarFile() throws Exception {
        // Create a sample tar file
        Path tarFilePath = Files.createTempFile("sample", ".tar");
        try (FileOutputStream fos = new FileOutputStream(tarFilePath.toFile())) {
            // Write a simple tar structure with a single entry
            String content = "Hello, World!";
            TarArchiveEntry entry = new TarArchiveEntry("hello.txt");
            entry.setSize(content.length());
            // Write the entry to the tar file
            fos.write(content.getBytes());
        }
        // Create TarFile instance
        TarFile tarFile = new TarFile(tarFilePath.toFile());
        // Expand the tar file using reflection to avoid ambiguity
        Method method = Expander.class.getDeclaredMethod("expand", TarFile.class, File.class);
        method.setAccessible(true);
        method.invoke(expander, tarFile, tempDir);
        // Verify the content of the expanded file
        File expandedFile = new File(tempDir, "hello.txt");
        assertTrue(expandedFile.exists());
        assertEquals("Hello, World!", new String(Files.readAllBytes(expandedFile.toPath())));
    }

    @Test
    void testExpandEmptyTarFile() throws Exception {
        // Create an empty tar file
        Path emptyTarFilePath = Files.createTempFile("empty", ".tar");
        TarFile emptyTarFile = new TarFile(emptyTarFilePath.toFile());
        // Expand the empty tar file using reflection to avoid ambiguity
        Method method = Expander.class.getDeclaredMethod("expand", TarFile.class, File.class);
        method.setAccessible(true);
        method.invoke(expander, emptyTarFile, tempDir);
        // Verify that the target directory is still empty
        assertEquals(0, tempDir.listFiles().length);
    }

    @Test
    void testExpandNullTargetDirectory() {
        assertThrows(NullPointerException.class, () -> {
            // Create a sample tar file
            Path tarFilePath = Files.createTempFile("sample", ".tar");
            TarFile tarFile = new TarFile(tarFilePath.toFile());
            // Attempt to expand with a null target directory using reflection
            Method method = Expander.class.getDeclaredMethod("expand", TarFile.class, File.class);
            method.setAccessible(true);
            method.invoke(expander, tarFile, null);
        });
    }
}
