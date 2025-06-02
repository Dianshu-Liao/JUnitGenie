package org.apache.commons.compress.archivers.examples;

import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
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
import java.nio.file.StandardOpenOption;
import java.util.Enumeration;
import java.util.Iterator;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarFile;
import org.apache.commons.compress.archivers.zip.ZipFile;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.NullOutputStream;

public class Expander_expand_1_2_Test {

    private Expander expander;

    private ArchiveInputStream<ZipArchiveEntry> archiveInputStream;

    private File targetDirectory;

    @BeforeEach
    public void setUp() {
        expander = new Expander();
        targetDirectory = new File(System.getProperty("java.io.tmpdir"), "expandTestDir");
        targetDirectory.mkdir();
    }

    @Test
    public void testExpand_validZip() throws Exception {
        // Create a sample ZIP input stream
        String zipContent = "This is a test file.";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(zipContent.getBytes());
        archiveInputStream = new ZipArchiveInputStream(byteArrayInputStream);
        // Create a zip entry
        ZipArchiveEntry entry = new ZipArchiveEntry("testfile.txt");
        when(archiveInputStream.getNextEntry()).thenReturn(entry);
        when(archiveInputStream.read(Mockito.any(byte[].class), Mockito.anyInt(), Mockito.anyInt())).thenReturn(zipContent.length());
        // Execute the method using reflection
        java.lang.reflect.Method method = Expander.class.getDeclaredMethod("expand", ArchiveInputStream.class, File.class);
        method.setAccessible(true);
        method.invoke(expander, archiveInputStream, targetDirectory);
        // Verify the file was created
        File createdFile = new File(targetDirectory, "testfile.txt");
        assertTrue(createdFile.exists());
        // Clean up
        Files.deleteIfExists(createdFile.toPath());
        Files.deleteIfExists(targetDirectory.toPath());
    }

    @Test
    public void testExpand_nullTargetDirectory() throws Exception {
        // Create a sample ZIP input stream
        String zipContent = "This is a test file.";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(zipContent.getBytes());
        archiveInputStream = new ZipArchiveInputStream(byteArrayInputStream);
        // Execute the method with null target directory using reflection
        java.lang.reflect.Method method = Expander.class.getDeclaredMethod("expand", ArchiveInputStream.class, File.class);
        method.setAccessible(true);
        method.invoke(expander, archiveInputStream, null);
        // No exception should be thrown, and we don't need to check for file creation
    }

    @Test
    public void testExpand_emptyZip() throws Exception {
        // Create an empty ZIP input stream
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(new byte[0]);
        archiveInputStream = new ZipArchiveInputStream(byteArrayInputStream);
        // Execute the method using reflection
        java.lang.reflect.Method method = Expander.class.getDeclaredMethod("expand", ArchiveInputStream.class, File.class);
        method.setAccessible(true);
        method.invoke(expander, archiveInputStream, targetDirectory);
        // Verify no files were created
        assertTrue(targetDirectory.list().length == 0);
        // Clean up
        Files.deleteIfExists(targetDirectory.toPath());
    }
}
