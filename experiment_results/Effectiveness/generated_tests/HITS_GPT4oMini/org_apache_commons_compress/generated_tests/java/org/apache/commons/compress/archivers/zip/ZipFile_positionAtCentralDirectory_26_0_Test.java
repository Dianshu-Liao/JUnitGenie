package org.apache.commons.compress.archivers.zip;

import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.StandardCharsets;
import java.util.zip.ZipException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.zip.Inflater;
import org.apache.commons.compress.archivers.EntryStreamOffsets;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream;
import org.apache.commons.compress.compressors.deflate64.Deflate64CompressorInputStream;
import org.apache.commons.compress.compressors.xz.XZCompressorInputStream;
import org.apache.commons.compress.compressors.zstandard.ZstdCompressorInputStream;
import org.apache.commons.compress.utils.BoundedArchiveInputStream;
import org.apache.commons.compress.utils.BoundedSeekableByteChannelInputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.InputStreamStatistics;
import org.apache.commons.compress.utils.SeekableInMemoryByteChannel;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.build.AbstractOrigin.ByteArrayOrigin;
import org.apache.commons.io.build.AbstractStreamBuilder;
import org.apache.commons.io.function.IOStream;
import org.apache.commons.io.input.BoundedInputStream;

@ExtendWith(MockitoExtension.class)
public class ZipFile_positionAtCentralDirectory_26_0_Test {

    private ZipFile zipFile;

    private SeekableByteChannel mockChannel;

    @BeforeEach
    public void setUp() throws IOException {
        mockChannel = mock(SeekableByteChannel.class);
        zipFile = new ZipFile(mockChannel, "mock channel", "UTF-8", true);
    }

    @Test
    public void testPositionAtCentralDirectory32() throws Exception {
        when(mockChannel.position()).thenReturn(100L);
        invokePositionAtCentralDirectory();
        assertNotNull(zipFile.getEntries());
    }

    @Test
    public void testPositionAtCentralDirectory64() throws Exception {
        when(mockChannel.position()).thenReturn(200L);
        invokePositionAtCentralDirectory();
        assertNotNull(zipFile.getEntries());
    }

    @Test
    public void testPositionAtEndOfCentralDirectoryRecordThrowsZipException() throws Exception {
        doThrow(new ZipException("Invalid ZIP")).when(mockChannel).position();
        assertThrows(ZipException.class, this::invokePositionAtCentralDirectory);
    }

    @Test
    public void testPositionAtEndOfCentralDirectoryRecordHandlesIOException() throws Exception {
        doThrow(new IOException("IO Error")).when(mockChannel).position();
        assertThrows(IOException.class, this::invokePositionAtCentralDirectory);
    }

    @Test
    public void testPositionAtCentralDirectoryHandlesInvalidState() throws Exception {
        zipFile = new ZipFile(mockChannel, "mock channel", "UTF-8", false);
        assertThrows(IOException.class, this::invokePositionAtCentralDirectory);
    }

    private void invokePositionAtCentralDirectory() throws Exception {
        Method method = ZipFile.class.getDeclaredMethod("positionAtCentralDirectory");
        method.setAccessible(true);
        method.invoke(zipFile);
    }
}
