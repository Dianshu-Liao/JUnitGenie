package org.apache.commons.compress.archivers.examples;

import org.apache.commons.compress.archivers.examples.Expander;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
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
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarFile;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipFile;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.NullOutputStream;

public class Expander_expand_7_0_Test {

    private Expander expander;

    private SevenZFile mockSevenZFile;

    private File targetDirectory;

    @BeforeEach
    public void setUp() {
        expander = new Expander();
        mockSevenZFile = mock(SevenZFile.class);
        targetDirectory = new File("testDir");
        targetDirectory.mkdirs();
    }

    @Test
    public void testExpand() {
        assertDoesNotThrow(() -> expander.expand(mockSevenZFile, targetDirectory));
    }

    @Test
    public void testExpandWithNullTargetDirectory() {
        assertDoesNotThrow(() -> expander.expand(mockSevenZFile, (File) null));
    }

    @Test
    public void testExpandWithEmptyDirectory() throws IOException {
        Path emptyDir = Files.createTempDirectory("emptyDir");
        assertDoesNotThrow(() -> expander.expand(mockSevenZFile, emptyDir.toFile()));
        Files.deleteIfExists(emptyDir);
    }

    @Test
    public void testExpandWithNonExistentTargetDirectory() throws IOException {
        File nonExistentDir = new File("nonExistentDir");
        assertDoesNotThrow(() -> expander.expand(mockSevenZFile, nonExistentDir));
    }

    @AfterEach
    public void tearDown() {
        if (targetDirectory.exists()) {
            targetDirectory.delete();
        }
    }
}
