package org.apache.commons.compress.archivers.zip;

import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.StandardCharsets;
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
import java.util.zip.ZipException;
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

public class ZipFile_positionAtCentralDirectory_26_0_Test {

    private ZipFile zipFile;

    private SeekableByteChannel mockChannel;

    @BeforeEach
    public void setUp() throws IOException {
        mockChannel = Mockito.mock(SeekableByteChannel.class);
        zipFile = Mockito.mock(ZipFile.class, Mockito.withSettings().useConstructor(mockChannel, "mock channel", StandardCharsets.UTF_8, true, false, false).defaultAnswer(Mockito.CALLS_REAL_METHODS));
    }

    @Test
    public void testPositionAtCentralDirectory32() throws Exception {
        when(mockChannel.position()).thenReturn(100L);
        Method method = ZipFile.class.getDeclaredMethod("positionAtCentralDirectory");
        method.setAccessible(true);
        method.invoke(zipFile);
        assertEquals(0, zipFile.getFirstLocalFileHeaderOffset());
    }

    @Test
    public void testPositionAtCentralDirectory64() throws Exception {
        when(mockChannel.position()).thenReturn(200L);
        Method method = ZipFile.class.getDeclaredMethod("positionAtCentralDirectory");
        method.setAccessible(true);
        method.invoke(zipFile);
        assertEquals(0, zipFile.getFirstLocalFileHeaderOffset());
    }

    @Test
    public void testPositionAtCentralDirectoryThrowsIOException() throws Exception {
        Method method = ZipFile.class.getDeclaredMethod("positionAtCentralDirectory");
        method.setAccessible(true);
        doThrow(new IOException("Test exception")).when(zipFile).getClass().getDeclaredMethod("positionAtEndOfCentralDirectoryRecord", SeekableByteChannel.class).invoke(zipFile, mockChannel);
        assertThrows(IOException.class, () -> {
            method.invoke(zipFile);
        });
    }
}
