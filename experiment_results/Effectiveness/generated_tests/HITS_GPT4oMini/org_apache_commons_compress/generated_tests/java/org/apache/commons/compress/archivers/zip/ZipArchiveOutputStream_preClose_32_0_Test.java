package org.apache.commons.compress.archivers.zip;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.zip.Deflater;
import java.util.zip.ZipException;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.utils.ByteUtils;
import org.apache.commons.io.Charsets;

public class ZipArchiveOutputStream_preClose_32_0_Test {

    private ZipArchiveOutputStream zipArchiveOutputStream;

    @BeforeEach
    public void setUp() throws IOException {
        zipArchiveOutputStream = new ZipArchiveOutputStream(new ByteArrayOutputStream());
    }

    @Test
    public void testPreClose_WhenFinished_ThrowsIOException() throws IOException {
        // Mark the stream as finished
        zipArchiveOutputStream.finish();
        assertThrows(IOException.class, () -> zipArchiveOutputStream.finish());
    }

    @Test
    public void testPreClose_WhenNoCurrentEntry_ThrowsIOException() {
        assertThrows(IOException.class, () -> zipArchiveOutputStream.finish());
    }

    @Test
    public void testPreClose_WhenEntryHasNotWritten_CallsWrite() throws IOException {
        ZipArchiveEntry entry = new ZipArchiveEntry("test.txt");
        zipArchiveOutputStream.putArchiveEntry(entry);
        assertDoesNotThrow(() -> zipArchiveOutputStream.finish());
    }

    @Test
    public void testPreClose_WhenEntryHasWritten_DoesNotThrow() throws IOException {
        ZipArchiveEntry entry = new ZipArchiveEntry("test.txt");
        zipArchiveOutputStream.putArchiveEntry(entry);
        // Simulate writing
        zipArchiveOutputStream.write(new byte[] { 1, 2, 3 }, 0, 3);
        assertDoesNotThrow(() -> zipArchiveOutputStream.finish());
    }
}
