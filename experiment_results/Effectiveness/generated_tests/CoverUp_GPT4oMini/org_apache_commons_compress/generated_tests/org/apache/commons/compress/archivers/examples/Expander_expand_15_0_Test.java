package org.apache.commons.compress.archivers.examples;

import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.archivers.examples.Expander;
import org.apache.commons.compress.archivers.examples.CloseableConsumer;
import java.io.File;
import java.io.IOException;
import java.nio.channels.SeekableByteChannel;
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

public class Expander_expand_15_0_Test {

    private Expander expander;

    private SeekableByteChannel mockSeekableByteChannel;

    private File targetDirectory;

    private CloseableConsumer mockCloseableConsumer;

    @BeforeEach
    public void setUp() throws IOException {
        expander = new Expander();
        mockSeekableByteChannel = mock(SeekableByteChannel.class);
        targetDirectory = Files.createTempDirectory("testDir").toFile();
        mockCloseableConsumer = mock(CloseableConsumer.class);
    }

    @Test
    public void testExpandWithValidFormatAndSeekableByteChannel() throws Exception {
        String format = "zip";
        assertDoesNotThrow(() -> invokeExpandMethod(format, mockSeekableByteChannel, targetDirectory, mockCloseableConsumer));
    }

    @Test
    public void testExpandWithInvalidFormat() {
        String format = "invalid_format";
        assertThrows(ArchiveException.class, () -> invokeExpandMethod(format, mockSeekableByteChannel, targetDirectory, mockCloseableConsumer));
    }

    @Test
    public void testExpandWithNullTargetDirectory() throws Exception {
        String format = "zip";
        assertDoesNotThrow(() -> invokeExpandMethod(format, mockSeekableByteChannel, null, mockCloseableConsumer));
    }

    @Test
    public void testExpandWithNullCloseableConsumer() throws Exception {
        String format = "zip";
        assertDoesNotThrow(() -> invokeExpandMethod(format, mockSeekableByteChannel, targetDirectory, null));
    }

    @Test
    public void testExpandWithNullSeekableByteChannel() {
        String format = "zip";
        assertThrows(NullPointerException.class, () -> invokeExpandMethod(format, null, targetDirectory, mockCloseableConsumer));
    }

    @Test
    public void testExpandWithEmptyFormat() {
        String format = "";
        assertThrows(ArchiveException.class, () -> invokeExpandMethod(format, mockSeekableByteChannel, targetDirectory, mockCloseableConsumer));
    }

    private void invokeExpandMethod(String format, SeekableByteChannel archive, File targetDirectory, CloseableConsumer closeableConsumer) throws Exception {
        Method method = Expander.class.getDeclaredMethod("expand", String.class, SeekableByteChannel.class, File.class, CloseableConsumer.class);
        method.setAccessible(true);
        method.invoke(expander, format, archive, targetDirectory, closeableConsumer);
    }
}
