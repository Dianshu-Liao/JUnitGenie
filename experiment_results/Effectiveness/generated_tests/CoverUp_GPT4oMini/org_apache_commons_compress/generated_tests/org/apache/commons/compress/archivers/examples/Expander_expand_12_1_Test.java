package org.apache.commons.compress.archivers.examples;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.StandardOpenOption;
import java.util.Enumeration;
import java.util.Iterator;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarFile;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipFile;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.NullOutputStream;

class Expander_expand_12_1_Test {

    private Expander expander;

    private Path tempDir;

    @BeforeEach
    void setUp() throws IOException {
        expander = new Expander();
        tempDir = Files.createTempDirectory("expanderTest");
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.walk(tempDir).sorted((a, b) -> b.compareTo(a)).forEach(path -> {
            try {
                Files.delete(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @Test
    void testExpandWithValidZip() throws Exception {
        String zipContent = "dummyContent";
        InputStream zipInputStream = new ByteArrayInputStream(zipContent.getBytes());
        CloseableConsumer closeableConsumer = mock(CloseableConsumer.class);
        invokeExpand("zip", zipInputStream, tempDir, closeableConsumer);
        assertTrue(Files.exists(tempDir.resolve("expectedFileName")));
    }

    @Test
    void testExpandWithInvalidFormat() {
        InputStream invalidInputStream = new ByteArrayInputStream(new byte[0]);
        CloseableConsumer closeableConsumer = mock(CloseableConsumer.class);
        assertThrows(ArchiveException.class, () -> {
            invokeExpand("invalidFormat", invalidInputStream, tempDir, closeableConsumer);
        });
    }

    @Test
    void testExpandWithNullInputStream() {
        CloseableConsumer closeableConsumer = mock(CloseableConsumer.class);
        assertThrows(NullPointerException.class, () -> {
            invokeExpand("zip", null, tempDir, closeableConsumer);
        });
    }

    @Test
    void testExpandWithNullTargetDirectory() throws Exception {
        String zipContent = "dummyContent";
        InputStream zipInputStream = new ByteArrayInputStream(zipContent.getBytes());
        CloseableConsumer closeableConsumer = mock(CloseableConsumer.class);
        assertThrows(NullPointerException.class, () -> {
            invokeExpand("zip", zipInputStream, null, closeableConsumer);
        });
    }

    @Test
    void testExpandWithNullCloseableConsumer() throws Exception {
        String zipContent = "dummyContent";
        InputStream zipInputStream = new ByteArrayInputStream(zipContent.getBytes());
        assertThrows(NullPointerException.class, () -> {
            invokeExpand("zip", zipInputStream, tempDir, null);
        });
    }

    private void invokeExpand(String format, InputStream archive, Path targetDirectory, CloseableConsumer closeableConsumer) throws Exception {
        Method method = Expander.class.getDeclaredMethod("expand", String.class, InputStream.class, Path.class, CloseableConsumer.class);
        method.setAccessible(true);
        method.invoke(expander, format, archive, targetDirectory, closeableConsumer);
    }
}
