package org.apache.commons.compress.archivers.examples;

import org.apache.commons.compress.archivers.sevenz.SevenZFile;
import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Method;
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

@ExtendWith(MockitoExtension.class)
class Expander_expand_7_3_Test {

    private Expander expander;

    private SevenZFile mockArchive;

    private File targetDirectory;

    @BeforeEach
    void setUp() throws IOException {
        expander = new Expander();
        mockArchive = Mockito.mock(SevenZFile.class);
        targetDirectory = Files.createTempDirectory("testExpand").toFile();
    }

    @Test
    void testExpand_NullTargetDirectory() {
        assertThrows(NullPointerException.class, () -> {
            invokeExpand(mockArchive, null);
        });
    }

    @Test
    void testExpand_ValidArchive() throws Exception {
        when(mockArchive.getNextEntry()).thenReturn(null);
        invokeExpand(mockArchive, targetDirectory);
        verify(mockArchive, times(1)).getNextEntry();
    }

    @Test
    void testExpand_ArchiveWithEntries() throws Exception {
        SevenZArchiveEntry mockEntry = Mockito.mock(SevenZArchiveEntry.class);
        when(mockEntry.getName()).thenReturn("testFile.txt");
        when(mockArchive.getNextEntry()).thenReturn(mockEntry).thenReturn(null);
        invokeExpand(mockArchive, targetDirectory);
        verify(mockArchive, times(2)).getNextEntry();
    }

    @Test
    void testExpand_IOExceptionThrown() throws Exception {
        when(mockArchive.getNextEntry()).thenThrow(new IOException("Mocked IO Exception"));
        IOException thrown = assertThrows(IOException.class, () -> {
            invokeExpand(mockArchive, targetDirectory);
        });
        assertEquals("Mocked IO Exception", thrown.getMessage());
    }

    @Test
    void testExpand_CreatesTargetDirectory() throws Exception {
        invokeExpand(mockArchive, targetDirectory);
        assertTrue(targetDirectory.exists());
        assertTrue(targetDirectory.isDirectory());
    }

    @Test
    void testExpand_CleansUp() throws Exception {
        invokeExpand(mockArchive, targetDirectory);
        Files.walk(targetDirectory.toPath()).sorted((a, b) -> b.compareTo(a)).forEach(path -> path.toFile().delete());
        assertFalse(targetDirectory.exists());
    }

    private void invokeExpand(SevenZFile archive, File targetDirectory) throws Exception {
        Method method = Expander.class.getDeclaredMethod("expand", SevenZFile.class, File.class);
        method.setAccessible(true);
        method.invoke(expander, archive, targetDirectory);
    }
}
