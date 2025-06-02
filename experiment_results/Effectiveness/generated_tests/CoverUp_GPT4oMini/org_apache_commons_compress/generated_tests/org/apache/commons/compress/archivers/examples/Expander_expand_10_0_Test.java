package org.apache.commons.compress.archivers.examples;

import org.apache.commons.compress.archivers.ArchiveException;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
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
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
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

class Expander_expand_10_0_Test {

    private Expander expander;

    private Path tempDirectory;

    @BeforeEach
    void setUp() throws IOException {
        expander = new Expander();
        tempDirectory = Files.createTempDirectory("expanderTest");
    }

    @Test
    void testExpandWithValidInput() throws Exception {
        String format = "zip";
        String content = "This is a test content for zip file";
        InputStream archive = new ByteArrayInputStream(content.getBytes());
        File targetDirectory = tempDirectory.toFile();
        // Use reflection to invoke the deprecated method
        Method method = Expander.class.getDeclaredMethod("expand", String.class, InputStream.class, File.class);
        method.setAccessible(true);
        method.invoke(expander, format, archive, targetDirectory);
        assertTrue(targetDirectory.exists() && targetDirectory.isDirectory());
    }

    @Test
    void testExpandWithNullFormat() throws Exception {
        InputStream archive = new ByteArrayInputStream("test".getBytes());
        File targetDirectory = tempDirectory.toFile();
        assertThrows(NullPointerException.class, () -> {
            Method method = Expander.class.getDeclaredMethod("expand", String.class, InputStream.class, File.class);
            method.setAccessible(true);
            method.invoke(expander, null, archive, targetDirectory);
        });
    }

    @Test
    void testExpandWithNullArchive() throws Exception {
        String format = "zip";
        File targetDirectory = tempDirectory.toFile();
        assertThrows(NullPointerException.class, () -> {
            Method method = Expander.class.getDeclaredMethod("expand", String.class, InputStream.class, File.class);
            method.setAccessible(true);
            method.invoke(expander, format, null, targetDirectory);
        });
    }

    @Test
    void testExpandWithNullTargetDirectory() throws Exception {
        String format = "zip";
        InputStream archive = new ByteArrayInputStream("test".getBytes());
        assertThrows(NullPointerException.class, () -> {
            Method method = Expander.class.getDeclaredMethod("expand", String.class, InputStream.class, File.class);
            method.setAccessible(true);
            method.invoke(expander, format, archive, null);
        });
    }

    @Test
    void testExpandWithInvalidFormat() throws Exception {
        String format = "invalidFormat";
        InputStream archive = new ByteArrayInputStream("test".getBytes());
        File targetDirectory = tempDirectory.toFile();
        assertThrows(ArchiveException.class, () -> {
            Method method = Expander.class.getDeclaredMethod("expand", String.class, InputStream.class, File.class);
            method.setAccessible(true);
            method.invoke(expander, format, archive, targetDirectory);
        });
    }

    @Test
    void testExpandWithIOException() throws Exception {
        String format = "zip";
        InputStream archive = new ByteArrayInputStream("test".getBytes());
        File targetDirectory = Files.createTempDirectory("readonly").toFile();
        targetDirectory.setWritable(false);
        assertThrows(IOException.class, () -> {
            Method method = Expander.class.getDeclaredMethod("expand", String.class, InputStream.class, File.class);
            method.setAccessible(true);
            method.invoke(expander, format, archive, targetDirectory);
        });
        targetDirectory.setWritable(true);
        Files.deleteIfExists(targetDirectory.toPath());
    }
}
