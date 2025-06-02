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

public class Expander_expand_4_1_Test {

    private Expander expander;

    @BeforeEach
    public void setUp() {
        expander = new Expander();
    }

    @Test
    public void testExpand_ValidInputStream_CreatesFiles() throws Exception {
        // Prepare a sample zip file in memory
        String zipContent = "This is a test.";
        InputStream zipInputStream = new ByteArrayInputStream(zipContent.getBytes());
        // Create a temporary directory
        Path tempDir = Files.createTempDirectory("testExpand");
        File targetDirectory = tempDir.toFile();
        // Execute the method using reflection to avoid ambiguity
        Method method = Expander.class.getDeclaredMethod("expand", InputStream.class, File.class);
        method.setAccessible(true);
        method.invoke(expander, zipInputStream, targetDirectory);
        // Verify that the file was created in the target directory
        assertTrue(targetDirectory.exists());
        assertTrue(targetDirectory.isDirectory());
        // Clean up
        Files.walk(tempDir).sorted((a, b) -> b.compareTo(a)).forEach(path -> path.toFile().delete());
    }

    @Test
    public void testExpand_NullInputStream_ThrowsIOException() throws Exception {
        Method method = Expander.class.getDeclaredMethod("expand", InputStream.class, File.class);
        method.setAccessible(true);
        assertThrows(IOException.class, () -> {
            method.invoke(expander, null, new File("dummy"));
        });
    }

    @Test
    public void testExpand_NullTargetDirectory_ThrowsIOException() throws Exception {
        Method method = Expander.class.getDeclaredMethod("expand", InputStream.class, File.class);
        method.setAccessible(true);
        assertThrows(IOException.class, () -> {
            method.invoke(expander, new ByteArrayInputStream(new byte[0]), null);
        });
    }

    @Test
    public void testExpand_EmptyInputStream_CreatesNoFiles() throws Exception {
        InputStream emptyInputStream = new ByteArrayInputStream(new byte[0]);
        Path tempDir = Files.createTempDirectory("testExpandEmpty");
        File targetDirectory = tempDir.toFile();
        // Execute the method using reflection
        Method method = Expander.class.getDeclaredMethod("expand", InputStream.class, File.class);
        method.setAccessible(true);
        method.invoke(expander, emptyInputStream, targetDirectory);
        assertTrue(targetDirectory.exists());
        assertTrue(targetDirectory.isDirectory());
        // No files should be created
        assertEquals(0, targetDirectory.list().length);
        // Clean up
        Files.walk(tempDir).sorted((a, b) -> b.compareTo(a)).forEach(path -> path.toFile().delete());
    }
}
